package com.inditex.rrhh.icmclcwb.model.primary.trabajo.repository;

import java.util.List;

import com.inditex.rrhh.icmclcwb.model.primary.trabajo.entity.TrabajoTienda;
import com.inditex.rrhh.icmclcwb.model.repository.BaseRepository;

public interface TrabajoTiendaRepository extends BaseRepository<TrabajoTienda, Long> {
    
    List<TrabajoTienda> findByTrabajoId(Long trabajoId);
	
}