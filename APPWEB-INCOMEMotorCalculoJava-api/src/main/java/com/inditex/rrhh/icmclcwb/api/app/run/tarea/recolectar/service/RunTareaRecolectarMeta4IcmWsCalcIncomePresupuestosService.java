package com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.service;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public interface RunTareaRecolectarMeta4IcmWsCalcIncomePresupuestosService {

  void personaByRunTarea(@NotNull @Valid final RunTareaDto runTarea);

  void localizacionByRunTarea(@NotNull @Valid final RunTareaDto runTarea);

  void empleadosPresenciaByRunTarea(@NotNull @Valid final RunTareaDto runTarea);

  void empleadosDesplazamientoByRunTarea(@NotNull @Valid final RunTareaDto runTarea);

}
