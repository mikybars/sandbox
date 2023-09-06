package com.inditex.rrhh.icmclcwb.model.primary.periodo.repository;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;

import javax.validation.constraints.NotNull;

public interface PeriodoCalculoPersonaRepositoryCustom {

  void mergePeriodoCalculoPersona(@NotNull RunTareaDto tareaDto);

  void limpiezaPeriodoCalculoPersona(@NotNull RunTareaDto tareaDto, @NotNull TareaAmbitoDto tareaAmbitoDto);

  List<IdPersonaLocalDto> findEmpleadosValidarRecuperar(RunTareaDto runTareaDto, TareaAmbitoDto tareaAmbito,
      List<String> personas);
}
