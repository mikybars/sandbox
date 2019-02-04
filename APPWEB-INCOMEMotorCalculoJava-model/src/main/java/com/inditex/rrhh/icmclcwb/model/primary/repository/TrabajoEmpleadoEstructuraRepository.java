package com.inditex.rrhh.icmclcwb.model.primary.repository;

import java.util.Set;

import javax.validation.constraints.NotNull;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants;
import com.inditex.rrhh.icmclcwb.model.primary.entity.TrabajoEmpleadoEstructura;
import com.inditex.rrhh.icmclcwb.model.repository.BaseRepository;

public interface TrabajoEmpleadoEstructuraRepository extends BaseRepository<TrabajoEmpleadoEstructura, Long> {

    @Query("SELECT tee.idTipoCalculo FROM TrabajoEmpleadoEstructura tee WHERE tee.trabajo.id=:idTrabajo GROUP BY tee.idTipoCalculo")
    Set<Long> findIdTipoCalculoByIdTrabajo(@NotNull @Param(SqlPrimaryConstants.SQL_PARAM_ID_TRABAJO) Long idTrabajo);

}
