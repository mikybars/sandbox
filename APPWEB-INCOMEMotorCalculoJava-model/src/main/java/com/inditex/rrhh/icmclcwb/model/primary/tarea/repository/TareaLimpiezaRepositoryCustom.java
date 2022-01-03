package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.EstadoLimpiezaDto;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public interface TareaLimpiezaRepositoryCustom {

  void updateFechaFinalizacion(@NotNull @Positive Long idTareaLimpieza);

  void inicioLimpieza(@NotNull @Positive Long idTareaLimpieza);

  void updateEstado(@NotNull @Positive Long idTareaLimpieza, @NotNull @Valid EstadoLimpiezaDto estado);

}
