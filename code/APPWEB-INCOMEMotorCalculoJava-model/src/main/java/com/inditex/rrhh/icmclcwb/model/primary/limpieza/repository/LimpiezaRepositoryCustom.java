package com.inditex.rrhh.icmclcwb.model.primary.limpieza.repository;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.EstadoLimpiezaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import org.jspecify.annotations.NonNull;

public interface LimpiezaRepositoryCustom {

  void limpieza(@NonNull @Valid final TareaDto tarea, @NonNull @Valid final TareaAmbitoDto ambito);

  void limpiezaTareaProfunda(@NonNull @Valid final TareaDto tarea, @NonNull @Valid final TareaAmbitoDto ambito);

  void updateEstado(@NonNull @Positive final Long idTareaLimpieza,
      @NonNull @Valid final EstadoLimpiezaDto estado);

  void updateFechaFinalizacion(@NonNull @Positive final Long idTareaLimpieza);

  void inicioLimpieza(@NonNull @Positive final Long idTareaLimpieza);

  void limpiezaTareaPersonaHistorico(@NonNull @Valid final TareaDto tarea);

  void limpiezaTareaLocalizacionHistorico(@NonNull @Valid final TareaDto tarea);

  void limpiezaTareaGlobalLocalizacionPersona(@NonNull @Valid final TareaDto tarea);

  void limpiezaTareaAmbitoGlobalLocalizacionPersonaDesplazamiento(@NonNull @Valid final TareaDto tarea);

  void limpiezaTareaAmbitoGlobalLocalizacionPersonaPresencia(@NonNull @Valid final TareaDto tarea);

  void limpiezaTareaAmbitoLocalizacion(@NonNull @Valid final TareaDto tarea,
      @NonNull @Valid final TareaAmbitoDto ambito);

  void limpiezaTareaAmbitoGlobalLocalizacionPersonaPresenciaManual(@NonNull @Valid final TareaDto tarea);

  void limpiezaTareaAmbitoGlobalPersona(@NonNull @Valid final TareaDto tarea);

  void limpiezaTareaPersonaExterna(@NonNull @Valid final TareaDto tarea);

}
