package com.inditex.rrhh.icmclcwb.model.app.run.tarea.validar.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.dto.ValidacionDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.service.RunValidacionesAgrupadasService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.EstadoTareaFaseAccionEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.FaseDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaFaseAccionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaFaseAccionService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaFaseService;
import com.inditex.rrhh.icmclcwb.model.app.calcular.RunPrevalidar;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

/**
 * Wrapper component that integrates grouped non-blocking validations into the existing validation flow.
 */
@Component("validacionesAgrupadasV1")
@Validated
public class RunTareaValidacionesAgrupadasWrapper implements RunPrevalidar {

  private static final Logger LOG = LoggerFactory.getLogger(RunTareaValidacionesAgrupadasWrapper.class);

  private static final Integer ID_FASE = 4;

  @Autowired
  private RunValidacionesAgrupadasService runValidacionesAgrupadasService;

  @Autowired
  private TareaFaseService tareaFaseService;

  @Autowired
  private TareaFaseAccionService tareaFaseAccionService;

  @Override
  public CompletableFuture<List<ValidacionDto>> execute(@NotNull @Valid final RunTareaDto runTarea,
      @NotNull @Valid final TareaFaseAccionDto tareaFaseAccion) {

    final Long idTrabajo = runTarea.getTrabajo().getId();
    final Long idTarea = runTarea.getTarea().getId();

    List<ValidacionDto> validacionesFallidas = List.of();

    try {
      this.tareaFaseAccionService.updateFechaInicio(tareaFaseAccion);
      LOG.info("Trabajo[{}]Tarea[{}] :: Validación agrupada iniciada - IdTareaFaseAccion: {}",
          idTrabajo, idTarea, tareaFaseAccion.getId());

      final FaseDto faseDto = new FaseDto(ID_FASE);

      validacionesFallidas = this.runValidacionesAgrupadasService.ejecutarValidacionesNoBloqueantes(runTarea, faseDto);

      // Siempre marcamos OK porque las validaciones hijas ya se han marcado individualmente
      this.tareaFaseAccionService.updateFechaFinAndEstado(tareaFaseAccion, EstadoTareaFaseAccionEnum.OK.getDto());

      if (validacionesFallidas.isEmpty()) {
        LOG.info("Trabajo[{}]Tarea[{}] :: Validación agrupada completada sin errores - IdTareaFaseAccion: {}",
            idTrabajo, idTarea, tareaFaseAccion.getId());
      } else {
        LOG.info("Trabajo[{}]Tarea[{}] :: Validación agrupada completada con {} validaciones fallidas - IdTareaFaseAccion: {}",
            idTrabajo, idTarea, validacionesFallidas.size(), tareaFaseAccion.getId());
      }

    } catch (final Exception e) {
      LOG.error("Trabajo[{}]Tarea[{}] :: Error inesperado en validación agrupada - IdTareaFaseAccion[{}]: {}",
          idTrabajo, idTarea, tareaFaseAccion.getId(), e.getMessage(), e);

      try {
        this.tareaFaseAccionService.updateFechaFinAndEstado(tareaFaseAccion, EstadoTareaFaseAccionEnum.ERROR.getDto());
      } catch (final Exception e2) {
        LOG.error("Trabajo[{}]Tarea[{}] :: Error actualizando estado a ERROR - IdTareaFaseAccion[{}]",
            idTrabajo, idTarea, tareaFaseAccion.getId(), e2);
      }

      final ValidacionDto validacionError = ValidacionDto.builder()
          .idTareaFaseAccion(tareaFaseAccion.getId())
          .result(Boolean.FALSE)
          .reaccionPeso(tareaFaseAccion.getReaccionPeso() != null ? tareaFaseAccion.getReaccionPeso() : 100)
          .idPersonaLocal(List.of())
          .build();
      validacionesFallidas = List.of(validacionError);
    }

    return CompletableFuture.completedFuture(validacionesFallidas);
  }

}
