package com.inditex.rrhh.icmclcwb.api.app.run.tarea.ambito.recolectar.service;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public interface RunTareaAmbitoRecolectarMeta4IcmWsCalcIncomePresupuestosService {

  void personaByRunTareaAndTareaAmbito(@Valid final RunTareaDto runTarea,
      @NotNull @Valid final TareaAmbitoDto tareaAmbito);

  void localizacionByRunTareaAndTareaAmbito(@NotNull @Valid final RunTareaDto runTarea,
      @NotNull @Valid final TareaAmbitoDto tareaAmbito);

  void empleadosPresenciaByRunTareaAndTareaAmbito(@NotNull @Valid final RunTareaDto runTarea,
      @NotNull @Valid final TareaAmbitoDto tareaAmbito);

  void empleadosDesplazamientoByRunTareaAndTareaAmbito(@NotNull @Valid final RunTareaDto runTarea,
      @NotNull @Valid final TareaAmbitoDto tareaAmbito);

}
