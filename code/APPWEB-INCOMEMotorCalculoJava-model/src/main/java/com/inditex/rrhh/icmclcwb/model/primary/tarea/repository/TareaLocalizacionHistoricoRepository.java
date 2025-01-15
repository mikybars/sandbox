package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.dto.IdLocalizacionDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdLocalizacionLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLocalizacionHistorico;
import com.inditex.rrhh.icmclcwb.model.repository.BaseRepository;

import jakarta.validation.constraints.NotEmpty;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TareaLocalizacionHistoricoRepository extends BaseRepository<TareaLocalizacionHistorico, Long> {

  @Query("SELECT new com.inditex.rrhh.icmclcwb.api.app.dto.IdLocalizacionDto(tth.stdIdWorkLocat) FROM TareaLocalizacionHistorico tth "
      + "WHERE tth.tarea.id=:idTarea AND tth.cclIdOrigen=:cclIdOrigen GROUP BY tth.stdIdWorkLocat")
  List<IdLocalizacionDto> findIdLocalizacionDtoByIdTareaAndCclIdOrigen(
      @NotNull @Param(SqlPrimaryConstants.SQL_PARAM_ID_TAREA) final Long idTarea,
      @NotNull @Param(SqlPrimaryConstants.SQL_PARAM_CCL_ID_ORIGEN) final String cclIdOrigen);

  @Query("SELECT new com.inditex.rrhh.icmclcwb.api.app.dto.IdLocalizacionLocalDto(tth.cclIdCodOrigen) FROM TareaLocalizacionHistorico tth "
      + "WHERE tth.tarea.id=:idTarea AND tth.cclIdOrigen=:cclIdOrigen GROUP BY tth.cclIdCodOrigen")
  List<IdLocalizacionLocalDto> findIdLocalizacionLocalDtoByIdTareaAndCclIdOrigen(
      @NotNull @Param(SqlPrimaryConstants.SQL_PARAM_ID_TAREA) final Long idTarea,
      @NotNull @Param(SqlPrimaryConstants.SQL_PARAM_CCL_ID_ORIGEN) final String cclIdOrigen);

  @Query("SELECT new com.inditex.rrhh.icmclcwb.api.app.dto.IdLocalizacionLocalDto(tth.cclIdCodOrigen) FROM TareaLocalizacionHistorico tth "
      + "WHERE tth.tarea.id=:idTarea AND tth.cclIdOrigen=:cclIdOrigen AND tth.stdIdLegEnt=:stdIdLegEnt GROUP BY tth.cclIdCodOrigen")
  List<IdLocalizacionLocalDto> findIdLocalizacionLocalDtoByIdTareaAndCclIdOrigenAndStdIdLegEnt(
      @NotNull @Param(SqlPrimaryConstants.SQL_PARAM_ID_TAREA) final Long idTarea,
      @NotNull @Param(SqlPrimaryConstants.SQL_PARAM_CCL_ID_ORIGEN) final String cclIdOrigen,
      @NotNull @Param(SqlPrimaryConstants.SQL_PARAM_STD_ID_LEG_ENT) final String stdIdLegEnt);

  @Query("SELECT new com.inditex.rrhh.icmclcwb.api.app.dto.IdLocalizacionLocalDto(tth.cclIdCodOrigen) FROM TareaLocalizacionHistorico tth"
      + " WHERE tth.tarea.id=:idTarea AND tth.cclIdOrigen=:cclIdOrigen AND tth.stdIdLegEnt IN (:stdIdLegEnt) GROUP BY tth.cclIdCodOrigen")
  List<IdLocalizacionLocalDto> findIdLocalizacionLocalDtoByIdTareaAndCClIdOrigenAndStdIdLegEntList(
      @NotNull @Param(SqlPrimaryConstants.SQL_PARAM_ID_TAREA) final Long idTarea,
      @NotNull @Param(SqlPrimaryConstants.SQL_PARAM_CCL_ID_ORIGEN) final String cclIdOrigen,
      @NotNull @NotEmpty @Param(SqlPrimaryConstants.SQL_PARAM_STD_ID_LEG_ENT) final List<String> stdIdLegEnt);

  @Query("SELECT new com.inditex.rrhh.icmclcwb.api.app.dto.IdLocalizacionDto(tth.stdIdWorkLocat) FROM TareaLocalizacionHistorico tth "
      + "WHERE tth.tarea.id=:idTarea AND tth.cclIdOrigen=:cclIdOrigen AND tth.cclIdCadena IN (:idCadena) GROUP BY tth.stdIdWorkLocat")
  List<IdLocalizacionDto> findIdLocalizacionDtoByTareaAndCclIdOrigenAndCadenas(
      @NotNull @Param(SqlPrimaryConstants.SQL_PARAM_ID_TAREA) final Long idTarea,
      @NotNull @Param(SqlPrimaryConstants.SQL_PARAM_CCL_ID_ORIGEN) final String cclIdOrigen,
      @NotNull @Param(SqlPrimaryConstants.SQL_PARAM_ID_CADENA) final List<String> idsCadena);

  @Query("SELECT new com.inditex.rrhh.icmclcwb.api.app.dto.IdLocalizacionLocalDto(tth.cclIdCodOrigen) FROM TareaLocalizacionHistorico tth"
      + " WHERE tth.tarea.id=:idTarea AND tth.cclIdOrigen=:cclIdOrigen AND tth.cclIdCadena IN (:idCadena) GROUP BY tth.cclIdCodOrigen")
  List<IdLocalizacionLocalDto> findIdLocalizacionLocalDtoByTareaAndCclIdOrigenAndCadenas(
      @NotNull @Param(SqlPrimaryConstants.SQL_PARAM_ID_TAREA) final Long idTarea,
      @NotNull @Param(SqlPrimaryConstants.SQL_PARAM_CCL_ID_ORIGEN) final String cclIdOrigen,
      @NotNull @Param(SqlPrimaryConstants.SQL_PARAM_ID_CADENA) final List<String> idsCadena);

}
