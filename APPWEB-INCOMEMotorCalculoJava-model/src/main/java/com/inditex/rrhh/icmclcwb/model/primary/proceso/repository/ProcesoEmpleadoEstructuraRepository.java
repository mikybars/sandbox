package com.inditex.rrhh.icmclcwb.model.primary.proceso.repository;

import java.util.Set;

import javax.validation.constraints.NotNull;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants;
import com.inditex.rrhh.icmclcwb.model.primary.proceso.entity.ProcesoEmpleadoEstructura;
import com.inditex.rrhh.icmclcwb.model.repository.BaseRepository;

public interface ProcesoEmpleadoEstructuraRepository extends BaseRepository<ProcesoEmpleadoEstructura, Long> {

    @Query("SELECT tee.idTipoCalculo FROM ProcesoEmpleadoEstructura tee WHERE tee.proceso.id=:idProceso GROUP BY tee.idTipoCalculo")
    Set<Long> findIdTipoCalculoByIdProceso(@NotNull @Param(SqlPrimaryConstants.SQL_PARAM_ID_PROCESO) Long idProceso);

}
