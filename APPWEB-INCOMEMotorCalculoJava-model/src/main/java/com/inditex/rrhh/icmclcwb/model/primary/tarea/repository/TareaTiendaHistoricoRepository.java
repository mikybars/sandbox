package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.inditex.rrhh.icmclcwb.api.app.dto.IdLocalizacionDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdLocalizacionLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaTiendaHistorico;
import com.inditex.rrhh.icmclcwb.model.repository.BaseRepository;

public interface TareaTiendaHistoricoRepository extends BaseRepository<TareaTiendaHistorico, Long> {

    @Query("SELECT new com.inditex.rrhh.icmclcwb.api.app.dto.IdLocalizacionDto(tth.idTiendaMeta4) FROM TareaTiendaHistorico tth WHERE tth.tarea.id=:idTarea AND tth.idPaisOrigen=:idOrigen GROUP BY tth.idTiendaMeta4")
    List<IdLocalizacionDto> findIdLocalizacionDtoByIdTareaAndIdOrigen(
            @NotNull @Param(SqlPrimaryConstants.SQL_PARAM_ID_TAREA) final Long idTarea,
            @NotNull @Param(SqlPrimaryConstants.SQL_PARAM_ID_ORIGEN) final String idOrigen);
    
    @Query("SELECT new com.inditex.rrhh.icmclcwb.api.app.dto.IdLocalizacionLocalDto(tth.idTienda) FROM TareaTiendaHistorico tth WHERE tth.tarea.id=:idTarea AND tth.idPaisOrigen=:idOrigen GROUP BY tth.idTienda")
    List<IdLocalizacionLocalDto> findIdLocalizacionLocalDtoByIdTareaAndIdOrigen(
            @NotNull @Param(SqlPrimaryConstants.SQL_PARAM_ID_TAREA) final Long idTarea,
            @NotNull @Param(SqlPrimaryConstants.SQL_PARAM_ID_ORIGEN) final String idOrigen);

}
