package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.inditex.rrhh.icmclcwb.api.app.dto.IdLocalizacionDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdLocalizacionLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLocalizacionHistorico;
import com.inditex.rrhh.icmclcwb.model.repository.BaseRepository;

public interface TareaLocalizacionHistoricoRepository extends BaseRepository<TareaLocalizacionHistorico, Long> {

    @Query("SELECT new com.inditex.rrhh.icmclcwb.api.app.dto.IdLocalizacionDto(tth.stdIdWorkLocat) FROM TareaLocalizacionHistorico tth WHERE tth.tarea.id=:idTarea AND tth.cclIdOrigen=:idOrigen GROUP BY tth.stdIdWorkLocat")
    List<IdLocalizacionDto> findIdLocalizacionDtoByIdTareaAndIdOrigen(
            @NotNull @Param(SqlPrimaryConstants.SQL_PARAM_ID_TAREA) final Long idTarea,
            @NotNull @Param(SqlPrimaryConstants.SQL_PARAM_ID_ORIGEN) final String idOrigen);
    
    @Query("SELECT new com.inditex.rrhh.icmclcwb.api.app.dto.IdLocalizacionLocalDto(tth.cclIdCodOrigen) FROM TareaLocalizacionHistorico tth WHERE tth.tarea.id=:idTarea AND tth.cclIdOrigen=:idOrigen GROUP BY tth.cclIdCodOrigen")
    List<IdLocalizacionLocalDto> findIdLocalizacionLocalDtoByIdTareaAndIdOrigen(
            @NotNull @Param(SqlPrimaryConstants.SQL_PARAM_ID_TAREA) final Long idTarea,
            @NotNull @Param(SqlPrimaryConstants.SQL_PARAM_ID_ORIGEN) final String idOrigen);

    @Query("SELECT new com.inditex.rrhh.icmclcwb.api.app.dto.IdLocalizacionDto(tth.stdIdWorkLocat) FROM TareaLocalizacionHistorico tth WHERE tth.tarea.id=:idTarea AND tth.cclIdOrigen=:idOrigen AND tth.cclIdCadena IN (:idCadena) GROUP BY tth.stdIdWorkLocat")
    List<IdLocalizacionDto> findIdLocalizacionDtoByTareaAndIdOrigenAndCadenas(
        @NotNull @Param(SqlPrimaryConstants.SQL_PARAM_ID_TAREA) final Long idTarea,
        @NotNull @Param(SqlPrimaryConstants.SQL_PARAM_ID_ORIGEN) final String idOrigen,
        @NotNull @Param(SqlPrimaryConstants.SQL_PARAM_ID_CADENA) final List<String> idsCadena);

    @Query("SELECT new com.inditex.rrhh.icmclcwb.api.app.dto.IdLocalizacionLocalDto(tth.cclIdCodOrigen) FROM TareaLocalizacionHistorico tth WHERE tth.tarea.id=:idTarea AND tth.cclIdOrigen=:idOrigen AND tth.cclIdCadena IN (:idCadena) GROUP BY tth.cclIdCodOrigen")
    List<IdLocalizacionLocalDto> findIdLocalizacionLocalDtoByTareaAndIdOrigenAndCadenas(
        @NotNull @Param(SqlPrimaryConstants.SQL_PARAM_ID_TAREA) final Long idTarea,
        @NotNull @Param(SqlPrimaryConstants.SQL_PARAM_ID_ORIGEN) final String idOrigen,
        @NotNull @Param(SqlPrimaryConstants.SQL_PARAM_ID_CADENA) final List<String> idsCadena);

}
