package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.EstadoTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.dto.IdTareaDTO;

import org.jspecify.annotations.NonNull;

public interface TareaRepositoryCustom {

  void updateFechaFin(@NonNull final TareaDto tarea);

  void updateFechaInicioAndEstado(@NonNull final TareaDto tarea, @NonNull final EstadoTareaDto estado);

  void updateEstado(@NonNull final TareaDto tarea, @NonNull final EstadoTareaDto estado);

  void updateEstadoFinal(@NonNull final TareaDto tarea);

  List<IdTareaDTO> findLimpieza();

  Integer totalLimpieza();

  List<IdTareaDTO> findLimpiezaByIdTarea(@NonNull final Long idTarea);

  // Comienzo de normalización de tareas consolidadas (para borrar)

  List<IdTareaDTO> findTareasConsolidadesSinAjusteComision(@NonNull final Integer limit);

  Integer totalTareasConsolidadesSinAjusteComision();

  // Fin de normalización de tareas consolidadas (para borrar)

}
