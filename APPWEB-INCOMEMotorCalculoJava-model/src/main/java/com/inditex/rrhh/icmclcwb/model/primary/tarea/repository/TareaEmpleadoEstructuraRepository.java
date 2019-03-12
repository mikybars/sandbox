package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.util.List;
import javax.validation.constraints.NotNull;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaEmpleadoEstructura;
import com.inditex.rrhh.icmclcwb.model.repository.BaseRepository;

public interface TareaEmpleadoEstructuraRepository extends BaseRepository<TareaEmpleadoEstructura, Long> {

    @Query("SELECT tee.idTipoCalculo FROM TareaEmpleadoEstructura tee WHERE tee.tarea.id=:idTarea GROUP BY tee.idTipoCalculo")
    List<Long> findIdTipoCalculoByIdTarea(@NotNull @Param(SqlPrimaryConstants.SQL_PARAM_ID_TAREA) Long idTarea);

}
