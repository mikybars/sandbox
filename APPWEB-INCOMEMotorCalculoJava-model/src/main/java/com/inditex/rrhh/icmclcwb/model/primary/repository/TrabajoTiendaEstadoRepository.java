package com.inditex.rrhh.icmclcwb.model.primary.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.inditex.rrhh.icmclcwb.model.primary.entity.TrabajoTiendaEstado;
import com.inditex.rrhh.icmclcwb.model.repository.BaseRepository;

public interface TrabajoTiendaEstadoRepository extends BaseRepository<TrabajoTiendaEstado, Long> {
	
	  Page<TrabajoTiendaEstado> findByTrabajoIdAndEstadoIdAndTipoIdIn(Long trabajoId, Long estadoTrabajoTiendaId, List<Long> tipoTrabajoTiendaId, Pageable pageable);
	
}