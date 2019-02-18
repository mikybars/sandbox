package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.util.List;

import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaEmpleado;
import com.inditex.rrhh.icmclcwb.model.repository.BaseRepository;

public interface TareaEmpleadoRepository extends BaseRepository<TareaEmpleado, Long> {

    List<TareaEmpleado> findByTareaId(Long tareaId);

}