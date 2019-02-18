package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaEmpleadoEstado;
import com.inditex.rrhh.icmclcwb.model.repository.BaseRepository;

public interface TareaEmpleadoEstadoRepository extends BaseRepository<TareaEmpleadoEstado, Long> {

    @Query("SELECT tee.idEmpleado FROM TareaEmpleadoEstado tee WHERE tee.tarea.id=:idTarea AND tee.estado.id=:idEstado")
    List<String> findIdsEmpleadoByIdTareaAndIdEstado(@Param(SqlPrimaryConstants.SQL_PARAM_ID_TAREA) Long idTarea, @Param(SqlPrimaryConstants.SQL_PARAM_ID_ESTADO) Long idEstado);

}
