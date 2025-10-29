package com.inditex.rrhh.icmclcwb.model.app.run.tarea.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.dto.ValidacionDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.service.RunValidacionesAgrupadasService;
import com.inditex.rrhh.icmclcwb.api.app.service.MailService;
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

    LOG.info("[LOG TEMP] INICIO ejecutarValidacionesNoBloqueantes - tareaDto.getId(): {}, faseDto.getId(): {}", tareaDto.getId(),
        faseDto.getId()); // LOG TEMP

    LOG.info("Trabajo[{}]Tarea[{}] :: Ejecutando validaciones no bloqueantes",
        tareaDto.getIdTrabajo(), tareaDto.getId());

    LOG.info("[LOG TEMP] Antes de findTareaFaseAccionDto - idTarea: {}, idFase: {}, idPuntoEjecucion: {}", tareaDto.getId(),
        faseDto.getId(), PuntoEjecucionEnum.DESPUES.getId()); // LOG TEMP

    final List<TareaFaseAccionDto> accionesNoBloquantes = this.tareaFaseAccionService
        .findTareaFaseAccionDtoByIdTareaAndIdFaseAndIdPuntoEjecucion(tareaDto.getId(), faseDto.getId(),
            PuntoEjecucionEnum.DESPUES.getId())
        .stream()
        .filter(tfa -> ID_ACCIONES_NO_BLOQUEANTES.contains(tfa.getIdAccion()))
        .sorted(Comparator.comparingInt(TareaFaseAccionDto::getPeso).reversed())
        .toList();

    LOG.info("[LOG TEMP] accionesNoBloquantes obtenidas (cantidad: {}): {}", accionesNoBloquantes.size(), accionesNoBloquantes); // LOG TEMP

    LOG.info("[LOG TEMP] accionesNoBloquantes obtenidas (cantidad: {}): {}", accionesNoBloquantes.size(), accionesNoBloquantes); // LOG TEMP

    if (accionesNoBloquantes.isEmpty()) {
      LOG.info("[LOG TEMP] No hay acciones no bloqueantes, saliendo"); // LOG TEMP
      return;
    }

    final List<CompletableFuture<List<ValidacionDto>>> futures = new ArrayList<>();

    LOG.info("[LOG TEMP] Iniciando procesamiento de {} acciones no bloqueantes", accionesNoBloquantes.size()); // LOG TEMP

    for (final TareaFaseAccionDto tareaFaseAccion : accionesNoBloquantes) {
      try {
        final String nombreAccion = this.accionService.findAccionDtoById(tareaFaseAccion.getIdAccion()).getNombre();

        LOG.info("[LOG TEMP] Ejecutando acción: {} con idTareaFaseAccion: {}, idAccion: {}", nombreAccion, tareaFaseAccion.getId(),
            tareaFaseAccion.getIdAccion()); // LOG TEMP

        final CompletableFuture<List<ValidacionDto>> future = this.runValidacionNoBloqueanteFactory
            .getRunValidacionNoBloqueante(nombreAccion)
            .execute(runTareaDto, tareaFaseAccion);

        futures.add(future);

        LOG.info("[LOG TEMP] Acción {} agregada al procesamiento", nombreAccion); // LOG TEMP
      } catch (final Exception e) {
        LOG.error("Trabajo[{}]Tarea[{}] :: Error ejecutando validación idTareaFaseAccion[{}]: {}",
            tareaDto.getIdTrabajo(), tareaDto.getId(), tareaFaseAccion.getId(), e.getMessage(), e);
        LOG.error("[LOG TEMP] Error en acción idTareaFaseAccion[{}]: {}", tareaFaseAccion.getId(), e.getMessage(), e); // LOG TEMP
      }
    }

    try {
      LOG.info("[LOG TEMP] Esperando la finalización de {} futures", futures.size()); // LOG TEMP
      CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();
      LOG.info("[LOG TEMP] Todos los futures completados correctamente"); // LOG TEMP
    } catch (final Exception e) {
      LOG.error("Trabajo[{}]Tarea[{}] :: Error esperando validaciones: {}",
          tareaDto.getIdTrabajo(), tareaDto.getId(), e.getMessage(), e);
      LOG.error("[LOG TEMP] Error esperando validaciones: {}", e.getMessage(), e); // LOG TEMP
    }

    final List<ValidacionDto> todasLasValidaciones = futures.stream()
        .map(future -> {
          try {
            return future.join();
          } catch (final Exception e) {
            LOG.error("Trabajo[{}]Tarea[{}] :: Error obteniendo resultado: {}",
                tareaDto.getIdTrabajo(), tareaDto.getId(), e.getMessage(), e);
            LOG.error("[LOG TEMP] Error obteniendo resultado de future: {}", e.getMessage(), e); // LOG TEMP
            return new ArrayList<ValidacionDto>();
          }
        })
        .flatMap(List::stream)
        .toList();

    LOG.info("[LOG TEMP] Total de validaciones obtenidas: {}", todasLasValidaciones.size()); // LOG TEMP

    final List<ValidacionDto> validacionesParaNotificar = todasLasValidaciones.stream()
        .filter(v -> Boolean.FALSE.equals(v.getResult()))
        .sorted(Comparator.comparingInt(ValidacionDto::getReaccionPeso).reversed())
        .toList();

    LOG.info("[LOG TEMP] Validaciones para notificar (con result=false): {}", validacionesParaNotificar.size()); // LOG TEMP

    LOG.info("[LOG TEMP] Validaciones para notificar (con result=false): {}", validacionesParaNotificar.size()); // LOG TEMP

    if (validacionesParaNotificar.isEmpty()) {
      LOG.info("[LOG TEMP] No hay validaciones para notificar, saliendo"); // LOG TEMP
      return;
    }

    if (Boolean.TRUE.equals(this.mailEntornoService.findEsActivoByEntorno(this.environment))) {
      try {
        LOG.info("[LOG TEMP] Enviando correo de validaciones..."); // LOG TEMP
        this.mailService.sendMail(validacionesParaNotificar, runTareaDto);
        LOG.info("[LOG TEMP] Correo enviado correctamente"); // LOG TEMP
      } catch (final Exception e) {
        LOG.error("Trabajo[{}]Tarea[{}] :: Error enviando correo: {}",
            tareaDto.getIdTrabajo(), tareaDto.getId(), e.getMessage(), e);
        LOG.error("[LOG TEMP] Error enviando correo: {}", e.getMessage(), e); // LOG TEMP
      }
    } else {
      LOG.info("[LOG TEMP] Mail no activo para entorno: {}", this.environment); // LOG TEMP
    }
  }

}
