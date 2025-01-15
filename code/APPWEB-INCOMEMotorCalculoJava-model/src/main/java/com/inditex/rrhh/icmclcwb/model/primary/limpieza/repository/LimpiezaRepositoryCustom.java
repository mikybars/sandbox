package com.inditex.rrhh.icmclcwb.model.primary.limpieza.repository;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.EstadoLimpiezaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;

public interface LimpiezaRepositoryCustom {

  void limpieza(@NotNull @Valid final TareaDto tarea, @NotNull @Valid final TareaAmbitoDto ambito);

  void limpiezaTareaProfunda(@NotNull @Valid final TareaDto tarea, @NotNull @Valid final TareaAmbitoDto ambito);

  void updateEstado(@NotNull @Positive final Long idTareaLimpieza,
      @NotNull @Valid final EstadoLimpiezaDto estado);

  void updateFechaFinalizacion(@NotNull @Positive final Long idTareaLimpieza);

  void inicioLimpieza(@NotNull @Positive final Long idTareaLimpieza);

  void limpiezaTareaPersonaHistorico(@NotNull @Valid final TareaDto tarea);

  void limpiezaTareaLocalizacionHistorico(@NotNull @Valid final TareaDto tarea);

  void limpiezaTareaGlobalLocalizacionPersona(@NotNull @Valid final TareaDto tarea);

  void limpiezaTareaAmbitoGlobalLocalizacionPersonaDesplazamiento(@NotNull @Valid final TareaDto tarea);

  void limpiezaTareaAmbitoGlobalLocalizacionPersonaPresencia(@NotNull @Valid final TareaDto tarea);

  void limpiezaTareaAmbitoLocalizacion(@NotNull @Valid final TareaDto tarea,
      @NotNull @Valid final TareaAmbitoDto ambito);

  void limpiezaTareaAmbitoGlobalLocalizacionPersonaPresenciaManual(@NotNull @Valid final TareaDto tarea);

  void limpiezaTareaAmbitoGlobalPersona(@NotNull @Valid final TareaDto tarea);

  void limpiezaTareaPersonaExterna(@NotNull @Valid final TareaDto tarea);

}
