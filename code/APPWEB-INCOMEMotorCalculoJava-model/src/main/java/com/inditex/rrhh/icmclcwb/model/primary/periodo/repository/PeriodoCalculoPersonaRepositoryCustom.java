package com.inditex.rrhh.icmclcwb.model.primary.periodo.repository;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;

import org.jspecify.annotations.NonNull;

public interface PeriodoCalculoPersonaRepositoryCustom {

  void mergePeriodoCalculoPersona(@NonNull RunTareaDto tareaDto);

  void limpiezaPeriodoCalculoPersona(@NonNull RunTareaDto tareaDto, @NonNull TareaAmbitoDto tareaAmbitoDto);

  List<IdPersonaLocalDto> findEmpleadosValidarRecuperar(RunTareaDto runTareaDto, TareaAmbitoDto tareaAmbito,
      List<String> personas);
}
