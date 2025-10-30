package com.inditex.rrhh.icmclcwb.model.app.run.tarea.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.dto.ValidacionDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.service.RunValidacionesAgrupadasService;
import com.inditex.rrhh.icmclcwb.api.app.service.MailService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.EstadoTareaFaseAccionEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.PuntoEjecucionEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.FaseDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaFaseAccionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.AccionService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.MailEntornoService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaFaseAccionService;
import com.inditex.rrhh.icmclcwb.model.app.calcular.RunValidacionNoBloqueanteFactory;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class RunValidacionesAgrupadasServiceImpl implements RunValidacionesAgrupadasService {

  private static final Logger LOG = LoggerFactory.getLogger(RunValidacionesAgrupadasServiceImpl.class);

  private static final List<Integer> ID_ACCIONES_NO_BLOQUEANTES = List.of(32, 33, 34);

  @Value("${metadata.environment}")
  private String environment;

  @Autowired
  private TareaFaseAccionService tareaFaseAccionService;

  @Autowired
  private RunValidacionNoBloqueanteFactory runValidacionNoBloqueanteFactory;

  @Autowired
  private AccionService accionService;

  @Autowired
  private MailService mailService;

  @Autowired
  private MailEntornoService mailEntornoService;

  @Override
  public void ejecutarValidacionesNoBloqueantes(@NotNull @Valid final RunTareaDto runTareaDto,
      @NotNull @Valid final FaseDto faseDto) {

    final TareaDto tareaDto = runTareaDto.getTarea();

    LOG.info("Trabajo[{}]Tarea[{}] :: Ejecutando validaciones no bloqueantes - Fase[{}]",
        tareaDto.getIdTrabajo(), tareaDto.getId(), faseDto.getId());

    final List<TareaFaseAccionDto> accionesNoBloquantes = this.obtenerAccionesNoBloqueantes(tareaDto, faseDto);

    if (accionesNoBloquantes.isEmpty()) {
      return;
    }

    this.inicializarEstadosAcciones(tareaDto, accionesNoBloquantes);

    final List<CompletableFuture<List<ValidacionDto>>> futures =
        this.ejecutarValidacionesAsync(runTareaDto, tareaDto, accionesNoBloquantes);

    this.esperarFinalizacionValidaciones(tareaDto, futures);

    final List<ValidacionDto> todasLasValidaciones = this.obtenerResultadosValidaciones(futures);

    this.actualizarEstadosFinales(tareaDto, todasLasValidaciones);

    this.notificarValidacionesFallidas(runTareaDto, tareaDto, todasLasValidaciones);
  }

  private List<TareaFaseAccionDto> obtenerAccionesNoBloqueantes(final TareaDto tareaDto, final FaseDto faseDto) {
    final List<TareaFaseAccionDto> acciones = this.tareaFaseAccionService
        .findTareaFaseAccionDtoByIdTareaAndIdFaseAndIdPuntoEjecucion(tareaDto.getId(), faseDto.getId(),
            PuntoEjecucionEnum.DESPUES.getId())
        .stream()
        .filter(tfa -> ID_ACCIONES_NO_BLOQUEANTES.contains(tfa.getIdAccion()))
        .sorted(Comparator.comparingInt(TareaFaseAccionDto::getPeso).reversed())
        .toList();

    LOG.info("Trabajo[{}]Tarea[{}] :: Acciones no bloqueantes encontradas: {}",
        tareaDto.getIdTrabajo(), tareaDto.getId(), acciones.size());

    return acciones;
  }

  private void inicializarEstadosAcciones(final TareaDto tareaDto, final List<TareaFaseAccionDto> acciones) {
    for (final TareaFaseAccionDto tareaFaseAccion : acciones) {
      try {
        this.tareaFaseAccionService.updateFechaInicio(tareaFaseAccion);
      } catch (final Exception e) {
        LOG.error("Trabajo[{}]Tarea[{}] :: Error actualizando estado inicial - IdTareaFaseAccion[{}]: {}",
            tareaDto.getIdTrabajo(), tareaDto.getId(), tareaFaseAccion.getId(), e.getMessage(), e);
      }
    }
  }

  private List<CompletableFuture<List<ValidacionDto>>> ejecutarValidacionesAsync(final RunTareaDto runTareaDto,
      final TareaDto tareaDto, final List<TareaFaseAccionDto> acciones) {
    final List<CompletableFuture<List<ValidacionDto>>> futures = new ArrayList<>();

    for (final TareaFaseAccionDto tareaFaseAccion : acciones) {
      try {
        final String nombreAccion = this.accionService.findAccionDtoById(tareaFaseAccion.getIdAccion()).getNombre();

        final CompletableFuture<List<ValidacionDto>> future = this.runValidacionNoBloqueanteFactory
            .getRunValidacionNoBloqueante(nombreAccion)
            .execute(runTareaDto, tareaFaseAccion);

        futures.add(future);
      } catch (final Exception e) {
        LOG.error("Trabajo[{}]Tarea[{}] :: Error ejecutando validación idTareaFaseAccion[{}]: {}",
            tareaDto.getIdTrabajo(), tareaDto.getId(), tareaFaseAccion.getId(), e.getMessage(), e);
        this.marcarAccionComoError(tareaDto, tareaFaseAccion);
      }
    }

    return futures;
  }

  private void marcarAccionComoError(final TareaDto tareaDto, final TareaFaseAccionDto tareaFaseAccion) {
    try {
      this.tareaFaseAccionService.updateFechaFinAndEstado(tareaFaseAccion,
          EstadoTareaFaseAccionEnum.ERROR.getDto());
    } catch (final Exception e) {
      LOG.error("Trabajo[{}]Tarea[{}] :: Error actualizando estado a ERROR - IdTareaFaseAccion[{}]",
          tareaDto.getIdTrabajo(), tareaDto.getId(), tareaFaseAccion.getId(), e);
    }
  }

  private void esperarFinalizacionValidaciones(final TareaDto tareaDto, final List<CompletableFuture<List<ValidacionDto>>> futures) {
    try {
      CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();
    } catch (final Exception e) {
      LOG.error("Trabajo[{}]Tarea[{}] :: Error esperando validaciones: {}",
          tareaDto.getIdTrabajo(), tareaDto.getId(), e.getMessage(), e);
    }
  }

  private List<ValidacionDto> obtenerResultadosValidaciones(final List<CompletableFuture<List<ValidacionDto>>> futures) {
    return futures.stream()
        .map(this::obtenerResultadoFuture)
        .flatMap(List::stream)
        .toList();
  }

  private void actualizarEstadosFinales(final TareaDto tareaDto, final List<ValidacionDto> validaciones) {
    for (final ValidacionDto validacion : validaciones) {
      try {
        final TareaFaseAccionDto tareaFaseAccion = this.tareaFaseAccionService.findById(validacion.getIdTareaFaseAccion());

        final boolean tienePersonas = validacion.getIdPersonaLocal() != null && !validacion.getIdPersonaLocal().isEmpty();
        final EstadoTareaFaseAccionEnum estado = tienePersonas
            ? EstadoTareaFaseAccionEnum.KO
            : EstadoTareaFaseAccionEnum.OK;

        this.tareaFaseAccionService.updateFechaFinAndEstado(tareaFaseAccion, estado.getDto());
      } catch (final Exception e) {
        LOG.error("Trabajo[{}]Tarea[{}] :: Error actualizando estado final - IdTareaFaseAccion[{}]: {}",
            tareaDto.getIdTrabajo(), tareaDto.getId(), validacion.getIdTareaFaseAccion(), e.getMessage(), e);
      }
    }
  }

  private void notificarValidacionesFallidas(final RunTareaDto runTareaDto, final TareaDto tareaDto,
      final List<ValidacionDto> validaciones) {
    final List<ValidacionDto> validacionesParaNotificar = validaciones.stream()
        .filter(v -> v.getIdPersonaLocal() != null && !v.getIdPersonaLocal().isEmpty())
        .sorted(Comparator.comparingInt(ValidacionDto::getReaccionPeso).reversed())
        .toList();

    if (validacionesParaNotificar.isEmpty()) {
      LOG.info("Trabajo[{}]Tarea[{}] :: No hay validaciones para notificar",
          tareaDto.getIdTrabajo(), tareaDto.getId());
      return;
    }

    LOG.info("Trabajo[{}]Tarea[{}] :: Notificando {} validaciones con errores",
        tareaDto.getIdTrabajo(), tareaDto.getId(), validacionesParaNotificar.size());

    this.enviarCorreoValidaciones(runTareaDto, tareaDto, validacionesParaNotificar);
  }

  private void enviarCorreoValidaciones(final RunTareaDto runTareaDto, final TareaDto tareaDto,
      final List<ValidacionDto> validaciones) {
    if (Boolean.TRUE.equals(this.mailEntornoService.findEsActivoByEntorno(this.environment))) {
      try {
        this.mailService.sendMailValidacionesAgrupadas(validaciones, runTareaDto);
        LOG.info("Trabajo[{}]Tarea[{}] :: Correo de validaciones enviado correctamente",
            tareaDto.getIdTrabajo(), tareaDto.getId());
      } catch (final Exception e) {
        LOG.error("Trabajo[{}]Tarea[{}] :: Error enviando correo: {}",
            tareaDto.getIdTrabajo(), tareaDto.getId(), e.getMessage(), e);
      }
    } else {
      LOG.info("Trabajo[{}]Tarea[{}] :: Mail no activo para entorno: {}",
          tareaDto.getIdTrabajo(), tareaDto.getId(), this.environment);
    }
  }

  private List<ValidacionDto> obtenerResultadoFuture(final CompletableFuture<List<ValidacionDto>> future) {
    try {
      return future.join();
    } catch (final Exception e) {
      LOG.error("Error obteniendo resultado de validación: {}", e.getMessage(), e);
      return List.of();
    }
  }

}
