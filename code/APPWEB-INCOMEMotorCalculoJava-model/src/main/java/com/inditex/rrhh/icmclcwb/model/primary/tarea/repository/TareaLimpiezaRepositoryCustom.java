package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.EstadoLimpiezaDto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import org.jspecify.annotations.NonNull;

public interface TareaLimpiezaRepositoryCustom {

  void updateFechaFinalizacion(@NonNull @Positive Long idTareaLimpieza);

  void inicioLimpieza(@NonNull @Positive Long idTareaLimpieza);

  void updateEstado(@NonNull @Positive Long idTareaLimpieza, @NonNull @Valid EstadoLimpiezaDto estado);

}
