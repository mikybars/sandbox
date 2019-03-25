package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.util.List;
import javax.validation.constraints.NotNull;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaHistoricoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaEmpleadoHistorico;
import com.inditex.rrhh.icmclcwb.model.repository.BaseRepository;

public interface TareaEmpleadoHistoricoRepository extends BaseRepository<TareaEmpleadoHistorico, Long> {

    // TODO Filtrar por idOrigen
    @Query("SELECT new com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaDto(teh.idEmpleado) FROM TareaEmpleadoHistorico teh WHERE teh.tarea.id=:idTarea GROUP BY teh.idEmpleado")
    List<IdPersonaDto> findIdPersonaByIdTareaAndIdOrigen(
            @NotNull @Param(SqlPrimaryConstants.SQL_PARAM_ID_TAREA) final Long idTarea
    // ,@NotNull @Param(SqlPrimaryConstants.SQL_PARAM_ID_ORIGEN) final String
    // idOrigen
    );
    
    @Query("SELECT new com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaHistoricoDto(teh.idEmpleado, teh.orEmpleado) FROM TareaEmpleadoHistorico teh WHERE teh.tarea.id=:idTarea GROUP BY teh.idEmpleado, teh.orEmpleado")
    List<IdPersonaHistoricoDto> findIdPersonaHistoricoByIdTareaAndIdOrigen(
            @NotNull @Param(SqlPrimaryConstants.SQL_PARAM_ID_TAREA) final Long idTarea
    // ,@NotNull @Param(SqlPrimaryConstants.SQL_PARAM_ID_ORIGEN) final String
    // idOrigen
    );

    @Query("SELECT new com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalDto(teh.idEmpleadoLocal) FROM TareaEmpleadoHistorico teh WHERE teh.tarea.id=:idTarea GROUP BY teh.idEmpleadoLocal")
    List<IdPersonaLocalDto> findIdPersonaLocalByIdTareaAndIdOrigen(
            @NotNull @Param(SqlPrimaryConstants.SQL_PARAM_ID_TAREA) final Long idTarea
    // ,@NotNull @Param(SqlPrimaryConstants.SQL_PARAM_ID_ORIGEN) final String
    // idOrigen
    );

}
