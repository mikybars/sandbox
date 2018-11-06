package com.inditex.rrhh.icmclcwb.model.primary.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.inditex.rrhh.icmclcwb.model.primary.entity.TrabajoTienda;
import com.inditex.rrhh.icmclcwb.model.repository.BaseRepository;

public interface TrabajoTiendaRepository extends BaseRepository<TrabajoTienda, Long> {
	
	  Page<TrabajoTienda> findByTrabajoIdAndEstadoId(Long trabajoId, Long estadoTrabajoTiendaId, Pageable pageable);
	
}