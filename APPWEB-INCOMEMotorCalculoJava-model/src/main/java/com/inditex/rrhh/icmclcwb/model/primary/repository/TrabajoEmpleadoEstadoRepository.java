package com.inditex.rrhh.icmclcwb.model.primary.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.inditex.rrhh.icmclcwb.model.primary.entity.TrabajoEmpleadoEstado;
import com.inditex.rrhh.icmclcwb.model.repository.BaseRepository;

public interface TrabajoEmpleadoEstadoRepository extends BaseRepository<TrabajoEmpleadoEstado, Long> {

	Page<TrabajoEmpleadoEstado> findByTrabajoIdAndEstadoId(Long trabajoId, Long estadoTrabajoEmpleadoId, Pageable pageable);


}