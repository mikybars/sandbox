package com.inditex.rrhh.icmclcwb.model.primary.proceso.repository;

import java.util.List;

import com.inditex.rrhh.icmclcwb.model.primary.proceso.entity.ProcesoTienda;
import com.inditex.rrhh.icmclcwb.model.repository.BaseRepository;

public interface ProcesoTiendaRepository extends BaseRepository<ProcesoTienda, Long> {
    
    List<ProcesoTienda> findByProcesoId(Long procesoId);
	
}