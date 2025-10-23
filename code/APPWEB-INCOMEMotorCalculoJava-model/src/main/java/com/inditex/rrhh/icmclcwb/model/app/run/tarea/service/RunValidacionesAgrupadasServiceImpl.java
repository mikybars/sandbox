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

/**
 * Service implementation for executing grouped non-blocking validations. This implementation executes multiple validations
 * (validarCalculoPendiente, validarImporteExcedido, validarPorcentaje0) in parallel, waits for all to complete, and sends a single
 * consolidated email with all validation results.
 */
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

    LOG.info("Trabajo[{}]Tarea[{}] :: Inicio :: Ejecución de validaciones agrupadas no bloqueantes",
        tareaDto.getIdTrabajo(), tareaDto.getId());

    // Paso 1: Obtener solo las acciones de validaciones no bloqueantes (IDs: 32, 33, 34)
    final List<TareaFaseAccionDto> accionesNoBloquantes = this.tareaFaseAccionService
        .findTareaFaseAccionDtoByIdTareaAndIdFaseAndIdPuntoEjecucion(tareaDto.getId(), faseDto.getId(),
            PuntoEjecucionEnum.DESPUES.getId())
        .stream()
        .filter(tfa -> ID_ACCIONES_NO_BLOQUEANTES.contains(tfa.getIdAccion()))
        .sorted(Comparator.comparingInt(TareaFaseAccionDto::getPeso).reversed())
        .toList();

    if (accionesNoBloquantes.isEmpty()) {
      LOG.info("Trabajo[{}]Tarea[{}] :: No hay validaciones no bloqueantes configuradas",
          tareaDto.getIdTrabajo(), tareaDto.getId());
      return;
    }

    // Paso 2: Ejecutar todas las validaciones en paralelo sin esperar resultados
    final List<CompletableFuture<List<ValidacionDto>>> futures = new ArrayList<>();

    for (final TareaFaseAccionDto tareaFaseAccion : accionesNoBloquantes) {
      try {
        final String nombreAccion = this.accionService.findAccionDtoById(tareaFaseAccion.getIdAccion()).getNombre();

        LOG.debug("Trabajo[{}]Tarea[{}] :: Ejecutando validación: {}",
            tareaDto.getIdTrabajo(), tareaDto.getId(), nombreAccion);

        // Obtener instancia de validación y ejecutar de forma asíncrona
        final CompletableFuture<List<ValidacionDto>> future = this.runValidacionNoBloqueanteFactory
            .getRunValidacionNoBloqueante(nombreAccion)
            .execute(runTareaDto, tareaFaseAccion);

        futures.add(future);
      } catch (final Exception e) {
        LOG.error("Trabajo[{}]Tarea[{}] :: Error al ejecutar validación idTareaFaseAccion[{}]: {}",
            tareaDto.getIdTrabajo(), tareaDto.getId(), tareaFaseAccion.getId(), e.getMessage(), e);
      }
    }

    // Paso 3: Esperar a que TODAS las validaciones terminen (sin importar si fallan)
    try {
      CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();
      LOG.info("Trabajo[{}]Tarea[{}] :: Todas las validaciones completadas",
          tareaDto.getIdTrabajo(), tareaDto.getId());
    } catch (final Exception e) {
      LOG.error("Trabajo[{}]Tarea[{}] :: Error al esperar validaciones: {}",
          tareaDto.getIdTrabajo(), tareaDto.getId(), e.getMessage(), e);
    }

    // Paso 4: Consolidar TODOS los resultados de las validaciones ejecutadas
    final List<ValidacionDto> todasLasValidaciones = futures.stream()
        .map(future -> {
          try {
            return future.join();
          } catch (final Exception e) {
            LOG.error("Trabajo[{}]Tarea[{}] :: Error al obtener resultado de validación: {}",
                tareaDto.getIdTrabajo(), tareaDto.getId(), e.getMessage(), e);
            return new ArrayList<ValidacionDto>();
          }
        })
        .flatMap(List::stream)
        .toList();

    LOG.info("Trabajo[{}]Tarea[{}] :: Total de validaciones ejecutadas: {}",
        tareaDto.getIdTrabajo(), tareaDto.getId(), todasLasValidaciones.size());

    // Paso 5: Filtrar validaciones que requieren notificación (result=false indica que hay problemas)
    final List<ValidacionDto> validacionesParaNotificar = todasLasValidaciones.stream()
        .filter(v -> Boolean.FALSE.equals(v.getResult()))
        .sorted(Comparator.comparingInt(ValidacionDto::getReaccionPeso).reversed())
        .toList();

    if (validacionesParaNotificar.isEmpty()) {
      LOG.info("Trabajo[{}]Tarea[{}] :: No hay validaciones que requieran notificación",
          tareaDto.getIdTrabajo(), tareaDto.getId());
      return;
    }

    LOG.info("Trabajo[{}]Tarea[{}] :: Validaciones que requieren notificación: {}",
        tareaDto.getIdTrabajo(), tareaDto.getId(), validacionesParaNotificar.size());

    // Paso 6: Enviar UN ÚNICO correo consolidado con las validaciones que requieren atención
    if (Boolean.TRUE.equals(this.mailEntornoService.findEsActivoByEntorno(this.environment))) {
      LOG.info("Trabajo[{}]Tarea[{}] :: Enviando correo consolidado con {} validaciones",
          tareaDto.getIdTrabajo(), tareaDto.getId(), validacionesParaNotificar.size());

      try {
        this.mailService.sendMail(validacionesParaNotificar, runTareaDto);

        LOG.info("Trabajo[{}]Tarea[{}] :: Correo consolidado enviado correctamente",
            tareaDto.getIdTrabajo(), tareaDto.getId());
      } catch (final Exception e) {
        LOG.error("Trabajo[{}]Tarea[{}] :: Error al enviar correo consolidado: {}",
            tareaDto.getIdTrabajo(), tareaDto.getId(), e.getMessage(), e);
      }
    } else {
      LOG.info("Trabajo[{}]Tarea[{}] :: Envío de correo deshabilitado para el entorno: {}",
          tareaDto.getIdTrabajo(), tareaDto.getId(), this.environment);
    }

    // Paso 7: Finalizar sin lanzar excepciones - el flujo de cálculo continúa
    LOG.info("Trabajo[{}]Tarea[{}] :: Fin :: Ejecución de validaciones agrupadas (flujo continúa)",
        tareaDto.getIdTrabajo(), tareaDto.getId());
  }

}
