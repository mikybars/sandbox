package com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.service;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;

import jakarta.validation.Valid;
import org.jspecify.annotations.NonNull;

public interface RunTareaRecolectarMeta4IcmWsCalcIncomePresupuestosService {

  void personaByRunTarea(@NonNull @Valid final RunTareaDto runTarea);

  void localizacionByRunTarea(@NonNull @Valid final RunTareaDto runTarea);

  void empleadosPresenciaByRunTarea(@NonNull @Valid final RunTareaDto runTarea);

  void empleadosDesplazamientoByRunTarea(@NonNull @Valid final RunTareaDto runTarea);

}
