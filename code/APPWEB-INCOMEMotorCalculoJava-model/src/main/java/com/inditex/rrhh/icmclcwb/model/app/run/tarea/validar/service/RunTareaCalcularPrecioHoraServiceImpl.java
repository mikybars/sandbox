package com.inditex.rrhh.icmclcwb.model.app.run.tarea.validar.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.dto.ValidacionDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.validar.service.RunTareaCalcularPrecioHoraService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.EstadoTareaFaseAccionEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaFaseAccionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.AccionService;
import com.inditex.rrhh.icmclcwb.model.app.tarea.service.TareaFaseAccionServiceImpl;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

@Component("calcularPrecioHoraV1")
@Validated
@RequiredArgsConstructor
public class RunTareaCalcularPrecioHoraServiceImpl implements RunTareaCalcularPrecioHoraService {

  private final TareaFaseAccionServiceImpl tareaFaseAccionService;

  private final AccionService accionService;

  private final RunTareaAmbitoCalcularPrecioHoraServiceImpl runTareaAmbitoCalcularPrecioHoraService;

  @Override
  public CompletableFuture<List<ValidacionDto>> execute(@NotNull @Valid final RunTareaDto runTarea,
      @NotNull @Valid final TareaFaseAccionDto tareaFaseAccion) {
    final TareaDto tareaDto = runTarea.getTarea();

    this.tareaFaseAccionService.updateFechaInicio(tareaFaseAccion);

    final List<ValidacionDto> validaciones = runTarea.getTarea().getAmbito().stream()
        .filter(a -> Boolean.TRUE.equals(
            this.accionService.findByIdAccionAndIdOrigenAndStdIdLegEnt(tareaFaseAccion.getIdAccion(), a.getCclIdOrigen(),
                tareaDto.getStdIdLegEnt())))
        .map(item -> this.runTareaAmbitoCalcularPrecioHoraService.execute(runTarea, item, tareaFaseAccion)).toList();

    if (validaciones.isEmpty()) {
      this.tareaFaseAccionService.updateFechaFinAndEstado(tareaFaseAccion,
          EstadoTareaFaseAccionEnum.NO_EJECUTADA.getDto());
      return CompletableFuture.completedFuture(validaciones);
    }

    if (validaciones.stream().noneMatch(e -> e.getResult().equals(Boolean.FALSE))) {
      this.tareaFaseAccionService.updateFechaFinAndEstado(tareaFaseAccion, EstadoTareaFaseAccionEnum.OK.getDto());
    }
    return CompletableFuture.completedFuture(validaciones);
  }

}
