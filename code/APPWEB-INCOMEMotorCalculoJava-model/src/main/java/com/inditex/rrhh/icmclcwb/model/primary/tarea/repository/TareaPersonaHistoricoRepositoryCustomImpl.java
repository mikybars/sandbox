package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.TipoVentaConceptoEnum;
import com.inditex.rrhh.icmclcwb.api.app.calcular.TipoCalculoEnum;
import com.inditex.rrhh.icmclcwb.api.app.calcular.TipoComisionEnum;
import com.inditex.rrhh.icmclcwb.api.app.dto.GenericAlgoritmoPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaHIstoricoLocalizacionDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaHistoricoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalChallengeDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.PeriodoDto;
import com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants;
import com.inditex.rrhh.icmclcwb.model.primary.repository.JdbcBatchPrimaryRepositoryAbstract;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaPersonaHistorico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class TareaPersonaHistoricoRepositoryCustomImpl
    extends JdbcBatchPrimaryRepositoryAbstract<TareaPersonaHistorico>
    implements TareaPersonaHistoricoRepositoryCustom {

  @Value("${app.envars.repository.batch-size.tarea-persona-historico:0}")
  private int batchSize;

  @Value("#{primaryQuery['TareaPersonaHistoricoRepositoryCustom.save']}")
  private String sqlSave;

  @Value("#{primaryQuery['TareaPersonaHistoricoRepositoryCustom.findIdPersonaHistoricoDtoByIdTareaAndIdOrigenAndTipoDatoInAmbito']}")
  private String sqlFindIdPersonaHistoricoDtoByIdTareaAndIdOrigenAndTipoDatoInAmbito;

  @Value("#{primaryQuery['TareaPersonaHistoricoRepositoryCustom.findIdPersonaHistoricoByIdTareaAndIdOrigenInPeriodoCalculoPersona']}")
  private String sqlFindIdPersonaHistoricoByIdTareaAndIdOrigen;

  @Value("#{primaryQuery['TareaPersonaHistoricoRepositoryCustom.findIdPersonaLocalByIdTareaAndIdOrigenInPeriodoCalculoPersona']}")
  private String sqlFindIdPersonaLocalByIdTareaAndIdOrigenInPeriodoCalculoPersona;

  @Value("#{primaryQuery['TareaPersonaHistoricoRepositoryCustom.findPeriodoDtoByIdTarea']}")
  private String sqlFindPeriodoDtoByIdTarea;

  @Value("#{primaryQuery['TareaPersonaHistoricoRepositoryCustom.findIdPersonaHistoricoDtoGrupoFechasByIdTarea']}")
  private String sqlFindIdPersonaHistoricoDtoGrupoFechasByIdTarea;

  @Value("#{primaryQuery['TareaPersonaHistoricoRepositoryCustom.findIdPersonaLocalCompensacionChallengeByIdTarea']}")
  private String sqlFindIdPersonaLocalCompensacionChallengeByIdTarea;

  @Value("#{primaryQuery['TareaPersonaHistoricoRepositoryCustom."
      + "findIdPersonaHistoricoDtoByIdTareaAndConfiguracionVentaOnlineEntregaDomicilio']}")
  private String sqlFindIdPersonaHistoricoDtoByIdTareaAndConfiguracionVentaOnlineEntregaDomicilio;

  @Value("#{primaryQuery['TareaCalculoPersonaRepositoryCustom.findIdTipoCalculoAndIdTipoComisionByIdsTiposDato']}")
  private String sqlFindIdTipoCalculoAndIdTipoComisionByIdsTiposDato;

  @Value("#{primaryQuery['TareaPersonaHistoricoRepositoryCustom.findIdPersonaHistoricoAndLocalizacionByIdTareaAndIdOrigenInPcp']}")
  private String sqlFindIdPersonaHistoricoLocalizacionByIdTareaAndIdOrigenInPeriodoCalculoPersona;

  @Override
  public List<TareaPersonaHistorico> save(final List<TareaPersonaHistorico> src) {
    return this.saveNamedJdbcBatchList(src, this.sqlSave, this.batchSize);
  }

  @Override
  public List<IdPersonaHistoricoDto> findIdPersonaHistoricoDtoByIdTareaAndIdOrigenInAmbito(
      @NotNull @Positive final Long idTarea, @NotBlank final String cclIdOrigen) {
    final MapSqlParameterSource parameters = new MapSqlParameterSource();
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, idTarea);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_CCL_ID_ORIGEN, cclIdOrigen);
    return this.query(this.sqlFindIdPersonaHistoricoByIdTareaAndIdOrigen, parameters,
        new RowMapper<IdPersonaHistoricoDto>() {
          @Override
          public IdPersonaHistoricoDto mapRow(final ResultSet rs, final int rowNum) throws SQLException {
            final IdPersonaHistoricoDto dto = new IdPersonaHistoricoDto();
            dto.setStdIdHr(rs.getString(SqlPrimaryConstants.SQL_RESULT_ID_PERSONA_META4));
            dto.setStdOrHrPeriod(rs.getString(SqlPrimaryConstants.SQL_RESULT_OR_PERSONA));
            return dto;
          }
        });
  }

  @Override
  public List<IdPersonaHistoricoDto> findIdPersonaHistoricoDtoByIdTareaAndIdOrigenAndTipoDatoInAmbito(
      @NotNull @Positive final Long idTarea, @NotBlank final String cclIdOrigen,
      @NotNull final List<Integer> idsTipoDato) {
    final MapSqlParameterSource parameters = new MapSqlParameterSource();
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, idTarea);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_CCL_ID_ORIGEN, cclIdOrigen);

    return this.query(
        this.sqlFindIdPersonaHistoricoDtoByIdTareaAndIdOrigenAndTipoDatoInAmbito,
        parameters, new RowMapper<IdPersonaHistoricoDto>() {
          @Override
          public IdPersonaHistoricoDto mapRow(final ResultSet rs, final int rowNum) throws SQLException {
            final IdPersonaHistoricoDto dto = new IdPersonaHistoricoDto();
            dto.setStdIdHr(rs.getString(SqlPrimaryConstants.SQL_RESULT_ID_PERSONA_META4));
            dto.setStdOrHrPeriod(rs.getString(SqlPrimaryConstants.SQL_RESULT_OR_PERSONA));
            return dto;
          }
        });
  }

  @Override
  public PeriodoDto findPeriodoDtoByIdTarea(@NotNull @Positive final Long idTarea) {
    final MapSqlParameterSource parameters = new MapSqlParameterSource();
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, idTarea);

    return this.queryForObject(this.sqlFindPeriodoDtoByIdTarea, parameters,
        new RowMapper<PeriodoDto>() {
          @Override
          public PeriodoDto mapRow(final ResultSet rs, final int rowNum) throws SQLException {
            final PeriodoDto dto = new PeriodoDto();
            dto.setFechaInicioPeriodo(
                rs.getDate(SqlPrimaryConstants.SQL_RESULT_FECHA_INICIO_PERIODO).toLocalDate());
            dto.setFechaFinPeriodo(
                rs.getDate(SqlPrimaryConstants.SQL_RESULT_FECHA_FIN_PERIODO).toLocalDate());
            return dto;
          }
        });
  }

  @Override
  public List<IdPersonaHistoricoDto> findIdPersonaHistoricoDtoGrupoFechasByIdTarea(
      @NotNull @Positive final Long idTarea) {
    final MapSqlParameterSource parameters = new MapSqlParameterSource();
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, idTarea);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
    return this.query(this.sqlFindIdPersonaHistoricoDtoGrupoFechasByIdTarea, parameters,
        (rs, rowNum) -> IdPersonaHistoricoDto
            .builder()
            .stdIdHr(rs.getString(SqlPrimaryConstants.SQL_RESULT_ID_PERSONA_META4))
            .stdOrHrPeriod(rs.getString(SqlPrimaryConstants.SQL_RESULT_OR_PERSONA))
            .build());
  }

  @Override
  public List<IdPersonaLocalChallengeDto> findIdPersonaLocalCompensacionChallengeByIdTarea(
      @NotNull @Positive final Long idTarea) {
    final MapSqlParameterSource parameters = new MapSqlParameterSource();
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, idTarea);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_IDS_TIPOS_CALCULO, Arrays.asList(
        TipoCalculoEnum.CHALLENGE_IMPORTE_TIENDA.getId(), TipoCalculoEnum.CHALLENGE_IMPORTE_SECCION.getId()));
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_IDS_TIPOS_COMISION, Arrays
        .asList(TipoComisionEnum.CHALLENGE_PRINCIPAL.getId(), TipoComisionEnum.CHALLENGE_SECUNDARIO.getId()));

    return this.query(this.sqlFindIdPersonaLocalCompensacionChallengeByIdTarea,
        parameters,
        (rs, rowNum) -> IdPersonaLocalChallengeDto
            .builder()
            .cclIdPerson(rs.getString(SqlPrimaryConstants.SQL_RESULT_ID_PERSONA_LOCAL))
            .stdOrHrPeriod(rs.getString(SqlPrimaryConstants.SQL_RESULT_OR_PERSONA))
            .icmIdTpCalculo(rs.getString(SqlPrimaryConstants.SQL_RESULT_ICM_ID_TP_CALCULO))
            .icmIdTpComision(rs.getString(SqlPrimaryConstants.SQL_RESULT_ICM_ID_TP_COMISION))
            .esDesplazamiento(rs.getBoolean(SqlPrimaryConstants.SQL_RESULT_ES_DESPLAZAMIENTO))
            .esDesplazamientoBase(rs.getBoolean(SqlPrimaryConstants.SQL_RESULT_ES_DESPLAZAMIENTO_BASE))
            .build());
  }

  @Override
  public List<IdPersonaHistoricoDto> findIdPersonaHistoricoDtoByIdTareaAndConfiguracionVentaOnlineEntregaDomicilio(
      @NotNull @Positive final Long idTarea, @NotNull final String cclIdOrigen,
      @NotNull final TipoVentaConceptoEnum tipoVentaConcepto) {
    final MapSqlParameterSource parameters = new MapSqlParameterSource();
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, idTarea);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_PORCENTAJE_INCLUSION,
        SqlPrimaryConstants.SQL_VALUE_PORCENTAJE_CERO);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_CONCEPTO, tipoVentaConcepto.getId());
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_CCL_ID_ORIGEN, cclIdOrigen);
    return this
        .query(this.sqlFindIdPersonaHistoricoDtoByIdTareaAndConfiguracionVentaOnlineEntregaDomicilio, parameters,
            (rs, rowNum) -> IdPersonaHistoricoDto
                .builder()
                .stdIdHr(rs.getString(SqlPrimaryConstants.SQL_RESULT_ID_PERSONA_META4))
                .stdOrHrPeriod(rs.getString(SqlPrimaryConstants.SQL_RESULT_OR_PERSONA))
                .build());
  }

  @Override
  public List<GenericAlgoritmoPropertiesDto> findIdTipoCalculoAndIdTipoComisionByIdsTiposDato(
      @NotNull final List<Integer> idsTipoDato) {
    final MapSqlParameterSource parameters = new MapSqlParameterSource();
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_IDS_TIPOS_DATO, idsTipoDato);
    return this.query(this.sqlFindIdTipoCalculoAndIdTipoComisionByIdsTiposDato, parameters,
        new RowMapper<GenericAlgoritmoPropertiesDto>() {
          @Override
          public GenericAlgoritmoPropertiesDto mapRow(final ResultSet rs, final int rowNum)
              throws SQLException {
            final GenericAlgoritmoPropertiesDto dto = new GenericAlgoritmoPropertiesDto();
            dto.setIdTipoCalculo(rs.getString(SqlPrimaryConstants.SQL_RESULT_ID_TIPO_CALCULO));
            dto.setIdTipoComision(rs.getString(SqlPrimaryConstants.SQL_RESULT_ID_TIPO_COMISION));
            return dto;
          }
        });
  }

  @Override
  public List<IdPersonaHIstoricoLocalizacionDto> findIdPersonaHistoricoLocalizacionDtoByIdTareaAndIdOrigenInAmbito(
      @NotNull @Positive final Long idTarea, @NotBlank final String cclIdOrigen) {
    final MapSqlParameterSource parameters = new MapSqlParameterSource();
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, idTarea);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_CCL_ID_ORIGEN, cclIdOrigen);
    return this.query(this.sqlFindIdPersonaHistoricoLocalizacionByIdTareaAndIdOrigenInPeriodoCalculoPersona, parameters,
        new RowMapper<IdPersonaHIstoricoLocalizacionDto>() {
          @Override
          public IdPersonaHIstoricoLocalizacionDto mapRow(final ResultSet rs, final int rowNum) throws SQLException {
            final IdPersonaHIstoricoLocalizacionDto dto = new IdPersonaHIstoricoLocalizacionDto();
            dto.setStdIdHr(rs.getString(SqlPrimaryConstants.SQL_RESULT_ID_PERSONA_META4));
            dto.setStdOrHrPeriod(rs.getString(SqlPrimaryConstants.SQL_RESULT_OR_PERSONA));

            return dto;
          }
        });
  }

}
