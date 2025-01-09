package com.inditex.rrhh.icmclcwb.api.app.limpieza.service;

import com.inditex.rrhh.icmclcwb.api.app.run.limpieza.dto.RunLimpiezaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;

import jakarta.validation.Valid;
import org.jspecify.annotations.NonNull;

public interface LimpiezaService {

  void runTarea(@NonNull @Valid final RunLimpiezaDto tarea);

  void limpiezaTareaPersonaHistorico(@NonNull @Valid final TareaDto tarea);

  void limpiezaTareaLocalizacionHistorico(@NonNull @Valid final TareaDto tarea);

  void limpiezaTareaGlobalLocalizacionPersona(@NonNull @Valid final TareaDto tarea);

  void limpiezaTareaAmbitoGlobalLocalizacionPersonaDesplazamiento(@NonNull @Valid final TareaDto tarea);

  void limpiezaTareaAmbitoGlobalLocalizacionPersonaPresencia(@NonNull @Valid final TareaDto tarea);

  void limpiezaTareaAmbitoLocalizacion(@NonNull @Valid final TareaDto tarea);

  void limpiezaTareaAmbitoGlobalLocalizacionPersonaPresenciaManual(@NonNull @Valid final TareaDto tarea);

  void limpiezaTareaAmbitoGlobalPersona(@NonNull @Valid final TareaDto tarea);

  void limpiezaAmbito(@NonNull @Valid TareaDto tarea);

}
