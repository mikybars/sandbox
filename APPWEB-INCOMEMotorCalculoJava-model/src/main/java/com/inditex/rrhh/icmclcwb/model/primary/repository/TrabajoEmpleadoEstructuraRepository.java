package com.inditex.rrhh.icmclcwb.model.primary.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.inditex.rrhh.icmclcwb.model.primary.entity.TrabajoEmpleadoEstructura;
import com.inditex.rrhh.icmclcwb.model.repository.BaseRepository;

public interface TrabajoEmpleadoEstructuraRepository extends BaseRepository<TrabajoEmpleadoEstructura, Long> {
		

	  //@Query(" SELECT tee.idTipoCalculo, tee.idTipoComision FROM TrabajoEmpleadoEstructura tee WHERE tee.trabajo.id= :idTrabajo GROUP BY  tee.idTipoCalculo, tee.idTipoComision")
	  //FIXME Esta trayendo duplicados revisar mapeo de entidades		
	  @Query(" SELECT DISTINCT tee.idTipoCalculo FROM TrabajoEmpleadoEstructura tee WHERE tee.trabajo.id= :idTrabajo GROUP BY  tee.idTipoCalculo")
	  Set<Long>findIdsEstructuraByIdTrabajo(@Param("idTrabajo") Long idTrabajo);
	

}
