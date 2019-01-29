package com.inditex.rrhh.icmclcwb.model.primary.repository;

import java.util.List;

import com.inditex.rrhh.icmclcwb.model.primary.entity.TrabajoEmpleado;
import com.inditex.rrhh.icmclcwb.model.repository.BaseRepository;

public interface TrabajoEmpleadoRepository extends BaseRepository<TrabajoEmpleado, Long> {

    List<TrabajoEmpleado> findByTrabajoId(Long trabajoId);

}