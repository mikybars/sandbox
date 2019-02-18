package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.util.List;

import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaTienda;
import com.inditex.rrhh.icmclcwb.model.repository.BaseRepository;

public interface TareaTiendaRepository extends BaseRepository<TareaTienda, Long> {
    
    List<TareaTienda> findByTareaId(Long tareaId);
	
}