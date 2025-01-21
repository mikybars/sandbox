package com.inditex.rrhh.icmclcwb.api.app.limpieza.service;

import com.inditex.rrhh.icmclcwb.api.app.run.limpieza.dto.RunLimpiezaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public interface LimpiezaService {

  void runTarea(@NotNull @Valid final RunLimpiezaDto tarea);

  void limpiezaTareaPersonaHistorico(@NotNull @Valid final TareaDto tarea);

  void limpiezaTareaLocalizacionHistorico(@NotNull @Valid final TareaDto tarea);

  void limpiezaTareaGlobalLocalizacionPersona(@NotNull @Valid final TareaDto tarea);

  void limpiezaTareaAmbitoGlobalLocalizacionPersonaDesplazamiento(@NotNull @Valid final TareaDto tarea);

  void limpiezaTareaAmbitoGlobalLocalizacionPersonaPresencia(@NotNull @Valid final TareaDto tarea);

  void limpiezaTareaAmbitoLocalizacion(@NotNull @Valid final TareaDto tarea);

  void limpiezaTareaAmbitoGlobalLocalizacionPersonaPresenciaManual(@NotNull @Valid final TareaDto tarea);

  void limpiezaTareaAmbitoGlobalPersona(@NotNull @Valid final TareaDto tarea);

  void limpiezaAmbito(@NotNull @Valid TareaDto tarea);

}
