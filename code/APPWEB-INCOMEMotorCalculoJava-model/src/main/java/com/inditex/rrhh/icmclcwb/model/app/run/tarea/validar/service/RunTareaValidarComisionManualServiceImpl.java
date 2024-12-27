package com.inditex.rrhh.icmclcwb.model.app.run.tarea.validar.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

import com.inditex.rrhh.icmclcwb.api.app.dto.ValidacionDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.validar.service.RunTareaAmbitoValidarComisionManualService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.EstadoTareaFaseAccionEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaFaseAccionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.AccionService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaFaseAccionService;
import com.inditex.rrhh.icmclcwb.model.app.calcular.RunPrevalidar;
import com.inditex.rrhh.icmclcwb.model.app.util.CollectionUtils;

import jakarta.validation.Valid;
import org.jspecify.annotations.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

@Component("comisionManualV1")
@Validated
public class RunTareaValidarComisionManualServiceImpl implements RunPrevalidar {

  @Autowired
  private TareaFaseAccionService tareaFaseAccionService;

  @Autowired
  private AccionService accionService;

  @Autowired
  private RunTareaAmbitoValidarComisionManualService runTareaAmbitoValidarComisionManualService;

  @Override
  public CompletableFuture<List<ValidacionDto>> execute(
      @NonNull @Valid final RunTareaDto runTarea,
      @NonNull @Valid final TareaFaseAccionDto tareaFaseAccion) {
    final TareaDto tarea = runTarea.getTarea();
    this.tareaFaseAccionService.updateFechaInicio(tareaFaseAccion);
    final List<ValidacionDto> validaciones = tarea.getAmbito().stream()
        .filter(a -> Boolean.TRUE.equals(this.accionService.findByIdAccionAndIdOrigenAndStdIdLegEnt(tareaFaseAccion.getIdAccion(),
            a.getCclIdOrigen(), tarea.getStdIdLegEnt())))
        .map(item -> this.runTareaAmbitoValidarComisionManualService.execute(runTarea, item, tareaFaseAccion))
        .collect(Collectors.toList());
    if (CollectionUtils.isEmpty(validaciones)) {
      this.tareaFaseAccionService.updateFechaFinAndEstado(tareaFaseAccion, EstadoTareaFaseAccionEnum.NO_EJECUTADA.getDto());
      return CompletableFuture.completedFuture(validaciones);
    }
    if (CollectionUtils.isEmpty(validaciones.stream().filter(e -> e.getResult().equals(Boolean.FALSE)).collect(Collectors.toList()))) {
      this.tareaFaseAccionService.updateFechaFinAndEstado(tareaFaseAccion, EstadoTareaFaseAccionEnum.OK.getDto());
    }
    return CompletableFuture.completedFuture(validaciones);
  }
}
