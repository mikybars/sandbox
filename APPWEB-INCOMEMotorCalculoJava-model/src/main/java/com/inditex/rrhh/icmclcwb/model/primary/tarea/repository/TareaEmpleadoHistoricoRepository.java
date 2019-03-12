package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.util.Set;

import javax.validation.constraints.NotNull;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaEmpleadoHistorico;
import com.inditex.rrhh.icmclcwb.model.repository.BaseRepository;

public interface TareaEmpleadoHistoricoRepository extends BaseRepository<TareaEmpleadoHistorico, Long> {

    // TODO Filtrar por idOrigen
    @Query("SELECT teh.idEmpleado FROM TareaEmpleadoHistorico teh WHERE teh.tarea.id=:idTarea GROUP BY teh.idEmpleado")
    Set<String> findIdEmpleadoByIdTareaAndIdOrigen(
            @NotNull @Param(SqlPrimaryConstants.SQL_PARAM_ID_TAREA) final Long idTarea
    // ,@NotNull @Param(SqlPrimaryConstants.SQL_PARAM_ID_ORIGEN) final String
    // idOrigen
    );

}
