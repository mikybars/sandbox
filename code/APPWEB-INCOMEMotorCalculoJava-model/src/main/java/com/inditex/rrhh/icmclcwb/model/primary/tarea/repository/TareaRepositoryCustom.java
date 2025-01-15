package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.EstadoTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.dto.IdTareaDTO;

public interface TareaRepositoryCustom {

  void updateFechaFin(@NotNull final TareaDto tarea);

  void updateFechaInicioAndEstado(@NotNull final TareaDto tarea, @NotNull final EstadoTareaDto estado);

  void updateEstado(@NotNull final TareaDto tarea, @NotNull final EstadoTareaDto estado);

  void updateEstadoFinal(@NotNull final TareaDto tarea);

  List<IdTareaDTO> findLimpieza();

  Integer totalLimpieza();

  List<IdTareaDTO> findLimpiezaByIdTarea(@NotNull final Long idTarea);

  // Comienzo de normalización de tareas consolidadas (para borrar)

  List<IdTareaDTO> findTareasConsolidadesSinAjusteComision(@NotNull final Integer limit);

  Integer totalTareasConsolidadesSinAjusteComision();

  // Fin de normalización de tareas consolidadas (para borrar)

}
