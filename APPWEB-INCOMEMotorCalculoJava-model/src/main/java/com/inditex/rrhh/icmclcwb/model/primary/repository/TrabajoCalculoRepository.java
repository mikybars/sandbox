package com.inditex.rrhh.icmclcwb.model.primary.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.inditex.rrhh.icmclcwb.model.primary.entity.TrabajoCalculo;
import com.inditex.rrhh.icmclcwb.model.repository.BaseRepository;

public interface TrabajoCalculoRepository extends BaseRepository<TrabajoCalculo, Long> {
		  	  
	  @Query(" select tc.id from TrabajoCalculo tc where tc.trabajo.id= :idTrabajo")
	  List<Long>findAllTrabajoCalculadoByIdTrabajo(@Param("idTrabajo") Long idTrabajo);
}
