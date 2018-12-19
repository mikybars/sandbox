package com.inditex.rrhh.icmclcwb.model.primary.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.inditex.rrhh.icmclcwb.model.primary.entity.TrabajoEmpleadoEstructura;
import com.inditex.rrhh.icmclcwb.model.repository.BaseRepository;

public interface TrabajoEmpleadoEstructuraRepository extends BaseRepository<TrabajoEmpleadoEstructura, Long> {
		

	  @Query(" select tee.idTipoCalculo, tee.idTipoComision from TrabajoEmpleadoEstructura tee where tc.trabajo.id= :idTrabajo groupBy tee.idTipoCalculo, tee.idTipoComision")
	  List<TrabajoEmpleadoEstructura>findIdsEstructuraByIdTrabajo(@Param("idTrabajo") Long idTrabajo);
	

}
