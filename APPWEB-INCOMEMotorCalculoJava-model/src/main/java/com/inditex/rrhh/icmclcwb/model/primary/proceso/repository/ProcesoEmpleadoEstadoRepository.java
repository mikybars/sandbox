package com.inditex.rrhh.icmclcwb.model.primary.proceso.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants;
import com.inditex.rrhh.icmclcwb.model.primary.proceso.entity.ProcesoEmpleadoEstado;
import com.inditex.rrhh.icmclcwb.model.repository.BaseRepository;

public interface ProcesoEmpleadoEstadoRepository extends BaseRepository<ProcesoEmpleadoEstado, Long> {

    @Query("SELECT tee.idEmpleado FROM ProcesoEmpleadoEstado tee WHERE tee.proceso.id=:idProceso AND tee.estado.id=:idEstado")
    List<String> findIdsEmpleadoByIdProcesoAndIdEstado(@Param(SqlPrimaryConstants.SQL_PARAM_ID_PROCESO) Long idProceso, @Param(SqlPrimaryConstants.SQL_PARAM_ID_ESTADO) Long idEstado);

}
