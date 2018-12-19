package com.inditex.rrhh.icmclcwb.model.primary.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.inditex.rrhh.icmclcwb.model.primary.entity.TrabajoEmpleadoEstado;
import com.inditex.rrhh.icmclcwb.model.repository.BaseRepository;

public interface TrabajoEmpleadoEstadoRepository extends BaseRepository<TrabajoEmpleadoEstado, Long> {

	Page<TrabajoEmpleadoEstado> findByTrabajoId(Long trabajoId, Pageable pageable);
	
	@Query(" select tc.idEmpleado from TrabajoEmpleadoEstado tee where tc.trabajo.id= :idTrabajo and tc.estado.id = :idEstado")
	List<Long> findIdsEmpleadoByIdTrabajo (@Param("idTrabajo")  Long trabajoId, @Param("idEstado")  Long idEstado);

}
