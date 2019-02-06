package com.inditex.rrhh.icmclcwb.model.primary.trabajo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants;
import com.inditex.rrhh.icmclcwb.model.primary.trabajo.entity.TrabajoEmpleadoEstado;
import com.inditex.rrhh.icmclcwb.model.repository.BaseRepository;

public interface TrabajoEmpleadoEstadoRepository extends BaseRepository<TrabajoEmpleadoEstado, Long> {

    @Query("SELECT tee.idEmpleado FROM TrabajoEmpleadoEstado tee WHERE tee.trabajo.id=:idTrabajo AND tee.estado.id=:idEstado")
    List<String> findIdsEmpleadoByIdTrabajoAndIdEstado(@Param(SqlPrimaryConstants.SQL_PARAM_ID_TRABAJO) Long idTrabajo, @Param(SqlPrimaryConstants.SQL_PARAM_ID_ESTADO) Long idEstado);

}
