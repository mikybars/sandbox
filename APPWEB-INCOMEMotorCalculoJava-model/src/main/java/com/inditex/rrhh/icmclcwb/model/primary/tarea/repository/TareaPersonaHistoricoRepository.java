package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.util.List;
import javax.validation.constraints.NotNull;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaHistoricoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaPersonaHistorico;
import com.inditex.rrhh.icmclcwb.model.repository.BaseRepository;

public interface TareaPersonaHistoricoRepository extends BaseRepository<TareaPersonaHistorico, Long> {

    @Query("SELECT new com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaDto(teh.idPersona) FROM TareaPersonaHistorico teh WHERE teh.tarea.id=:idTarea AND teh.idOrigen=:idOrigen GROUP BY teh.idPersona")
    List<IdPersonaDto> findIdPersonaByIdTareaAndIdOrigen(
            @NotNull @Param(SqlPrimaryConstants.SQL_PARAM_ID_TAREA) final Long idTarea,
            @NotNull @Param(SqlPrimaryConstants.SQL_PARAM_ID_ORIGEN) final String idOrigen);

    @Query("SELECT new com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaHistoricoDto(teh.idPersona, teh.orPersona) FROM TareaPersonaHistorico teh WHERE teh.tarea.id=:idTarea AND teh.idOrigen=:idOrigen GROUP BY teh.idPersona, teh.orPersona")
    List<IdPersonaHistoricoDto> findIdPersonaHistoricoByIdTareaAndIdOrigen(
            @NotNull @Param(SqlPrimaryConstants.SQL_PARAM_ID_TAREA) final Long idTarea,
            @NotNull @Param(SqlPrimaryConstants.SQL_PARAM_ID_ORIGEN) final String idOrigen);

    @Query("SELECT new com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalDto(teh.idPersonaLocal) FROM TareaPersonaHistorico teh WHERE teh.tarea.id=:idTarea AND teh.idOrigen=:idOrigen GROUP BY teh.idPersonaLocal")
    List<IdPersonaLocalDto> findIdPersonaLocalByIdTareaAndIdOrigen(
            @NotNull @Param(SqlPrimaryConstants.SQL_PARAM_ID_TAREA) final Long idTarea,
            @NotNull @Param(SqlPrimaryConstants.SQL_PARAM_ID_ORIGEN) final String idOrigen);

}
