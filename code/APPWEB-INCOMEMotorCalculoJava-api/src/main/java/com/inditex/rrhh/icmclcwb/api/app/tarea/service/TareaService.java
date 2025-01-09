package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.EstadoTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.dto.RunMantenimientoLimpiezaDTO;
import com.inditex.rrhh.icmclcwb.dto.TrabajoDTO;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import org.jspecify.annotations.NonNull;

public interface TareaService {

  TareaDto save(@Valid @NonNull final TareaDto tarea);

  TareaDto find(@NonNull @Positive final Long id);

  TareaDto create(@Valid @NonNull final TrabajoDTO trabajo, @Valid @NonNull final TareaDto tarea);

  List<TareaDto> create(@Valid @NonNull final TrabajoDTO trabajo);

  List<TareaDto> findByTrabajoId(@NonNull @Positive final Long id);

  void updateFechaFin(@Valid @NonNull final TareaDto tarea);

  void updateFechaInicioAndEstado(@Valid @NonNull final TareaDto tarea, @Valid @NonNull final EstadoTareaDto estado);

  void updateEstado(@Valid @NonNull final TareaDto tarea, @Valid @NonNull final EstadoTareaDto estado);

  void updateEstadoFinal(@Valid @NonNull final TareaDto tarea);

  RunMantenimientoLimpiezaDTO findLimpieza();

  RunMantenimientoLimpiezaDTO findLimpiezaByIdTarea(@NonNull @Positive final Long idTarea);

  TareaDto findByIdLimpieza(@NonNull @Positive final Long idLimpieza);

  TareaDto findByIdWithStates(@NonNull @Positive final Long id);

}
