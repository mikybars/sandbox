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

    @Query("SELECT new com.inditex.rrhh.icmclcwb.api.app.dto.IdLocalizacionDto(tth.idLocalizacionMeta4) FROM TareaLocalizacionHistorico tth WHERE tth.tarea.id=:idTarea AND tth.idPaisOrigen=:idOrigen GROUP BY tth.idLocalizacionMeta4")
    List<IdLocalizacionDto> findIdLocalizacionDtoByIdTareaAndIdOrigen(
            @NotNull @Param(SqlPrimaryConstants.SQL_PARAM_ID_TAREA) final Long idTarea,
            @NotNull @Param(SqlPrimaryConstants.SQL_PARAM_ID_ORIGEN) final String idOrigen);
    
    @Query("SELECT new com.inditex.rrhh.icmclcwb.api.app.dto.IdLocalizacionLocalDto(tth.idLocalizacion) FROM TareaLocalizacionHistorico tth WHERE tth.tarea.id=:idTarea AND tth.idPaisOrigen=:idOrigen GROUP BY tth.idLocalizacion")
    List<IdLocalizacionLocalDto> findIdLocalizacionLocalDtoByIdTareaAndIdOrigen(
            @NotNull @Param(SqlPrimaryConstants.SQL_PARAM_ID_TAREA) final Long idTarea,
            @NotNull @Param(SqlPrimaryConstants.SQL_PARAM_ID_ORIGEN) final String idOrigen);

    @Query("SELECT new com.inditex.rrhh.icmclcwb.api.app.dto.IdLocalizacionDto(tth.idLocalizacionMeta4) FROM TareaLocalizacionHistorico tth WHERE tth.tarea.id=:idTarea AND tth.idPaisOrigen=:idOrigen AND tth.idCadena IN (:idCadena) GROUP BY tth.idLocalizacionMeta4")
    List<IdLocalizacionDto> findIdLocalizacionDtoByTareaAndIdOrigenAndCadenas(
        @NotNull @Param(SqlPrimaryConstants.SQL_PARAM_ID_TAREA) final Long idTarea,
        @NotNull @Param(SqlPrimaryConstants.SQL_PARAM_ID_ORIGEN) final String idOrigen,
        @NotNull @Param(SqlPrimaryConstants.SQL_PARAM_ID_CADENA) final List<String> idsCadena);

    @Query("SELECT new com.inditex.rrhh.icmclcwb.api.app.dto.IdLocalizacionLocalDto(tth.idLocalizacion) FROM TareaLocalizacionHistorico tth WHERE tth.tarea.id=:idTarea AND tth.idPaisOrigen=:idOrigen AND tth.idCadena IN (:idCadena) GROUP BY tth.idLocalizacion")
    List<IdLocalizacionLocalDto> findIdLocalizacionLocalDtoByTareaAndIdOrigenAndCadenas(
        @NotNull @Param(SqlPrimaryConstants.SQL_PARAM_ID_TAREA) final Long idTarea,
        @NotNull @Param(SqlPrimaryConstants.SQL_PARAM_ID_ORIGEN) final String idOrigen,
        @NotNull @Param(SqlPrimaryConstants.SQL_PARAM_ID_CADENA) final List<String> idsCadena);

}
