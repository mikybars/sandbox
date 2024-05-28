package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.calcular.TipoCalculoEnum;
import com.inditex.rrhh.icmclcwb.api.app.calcular.TipoComisionEnum;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdCadenaDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdLocalizacionDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdLocalizacionEmpresaDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdLocalizacionLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdLocalizacionLocalPresupuestoDto;
import com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants;
import com.inditex.rrhh.icmclcwb.model.app.util.TimeUtils;
import com.inditex.rrhh.icmclcwb.model.primary.repository.JdbcBatchPrimaryRepositoryAbstract;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLocalizacionHistorico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class TareaLocalizacionHistoricoRepositoryCustomImpl
    extends JdbcBatchPrimaryRepositoryAbstract<TareaLocalizacionHistorico>
    implements TareaLocalizacionHistoricoRepositoryCustom {

  @Value("${app.envars.repository.batch-size.tarea-localizacion-historico: 0}")
  private int batchSize;

  @Value("#{primaryQuery['TareaLocalizacionHistoricoRepositoryCustom.save']}")
  private String sqlSave;

  @Value("#{primaryQuery['TareaLocalizacionHistoricoRepositoryCustom.findIdLocalizacionDtoByIdTareaAndIdOrigenInAmbito']}")
  private String sqlFindIdLocalizacionDtoByIdTareaAndIdOrigenInAmbito;

  @Value("#{primaryQuery['TareaLocalizacionHistoricoRepositoryCustom.findIdLocalizacionLocalDtoByIdTareaAndIdOrigenInAmbito']}")
  private String sqlFindIdLocalizacionLocalDtoByIdTareaAndIdOrigenInAmbito;

  @Value("#{primaryQuery['TareaLocalizacionHistoricoRepositoryCustom.findIdLocalizacionLocalDtoByIdTareaAndIdOrigenAndIdEmpresaInAmbito']}")
  private String sqlFindIdLocalizacionLocalDtoByIdTareaAndIdOrigenAndIdEmpresaInAmbito;

  @Value("#{primaryQuery['TareaLocalizacionHistoricoRepositoryCustom."
      + "findIdLocalizacionLocalInCadenaAndProvinciaDtoByIdTareaAndIdOrigenAndIdEmpresaInAmbito']}")
  private String sqlFindIdLocalizacionLocalInCadenaAndProvinciaDtoByIdTareaAndIdOrigenAndIdEmpresaInAmbito;

  @Value("#{primaryQuery['TareaLocalizacionHistoricoRepositoryCustom.findIdLocalizacionDtoByIdTareaAndIdOrigenAndIdEmpresaInAmbito']}")
  private String sqlFindIdLocalizacionDtoByIdTareaAndIdOrigenAndIdEmpresaInAmbito;

  @Value("#{primaryQuery['TareaLocalizacionHistoricoRepositoryCustom.findIdLocalizacionDtoByIdTareaAndIdOrigenInAmbitoLocalizacion']}")
  private String sqlFindIdLocalizacionDtoByIdTareaAndIdOrigenInAmbitoLocalizacion;

  @Value("#{primaryQuery['TareaLocalizacionHistoricoRepositoryCustom.findIdLocalizacionLocalDtoByIdTareaAndIdOrigenInAmbitoLocalizacion']}")
  private String sqlFindIdLocalizacionLocalDtoByIdTareaAndIdOrigenInAmbitoLocalizacion;

  @Value("#{primaryQuery['TareaLocalizacionHistoricoRepositoryCustom.findIdLocalizacionLocalDtoByIdTareaAndIdOrigenAndIdCadena']}")
  private String sqlFindIdLocalizacionLocalDtoByIdTareaAndIdOrigenAndIdCadena;

  @Value("#{primaryQuery['TareaLocalizacionHistoricoRepositoryCustom.getCadenasByTareaAndOrigenAndTipoDato']}")
  private String sqlCadenasFiltroTipoDato;

  @Value("#{primaryQuery['TareaLocalizacionHistoricoRepositoryCustom.getCadenasByTareaAndOrigenAndTipoDatoAndEmpresa']}")
  private String sqlCadenasFiltroTipoDatoEmpresa;

  @Value("#{primaryQuery['TareaLocalizacionHistoricoRepositoryCustom.getCadenasByTareaAndOrigenAndTipoDatoNotInAmbito']}")
  private String sqlGetCadenasByTareaAndOrigenAndTipoDatoNotInAmbito;

  @Value("#{primaryQuery['TareaLocalizacionHistoricoRepositoryCustom.getCadenasByTareaAndOrigen']}")
  private String sqlCadenas;

  @Value("#{primaryQuery['TareaLocalizacionHistoricoRepositoryCustom.findIdLocalizacionByIdTareaAndCclIdPersonInAmbito']}")
  private String sqlFindIdLocalizacionByIdTareaAndCclIdPersonInAmbito;

  @Value("#{primaryQuery['TareaLocalizacionHistoricoRepositoryCustom.findIdLocalizacionByIdTareaAndCclIdOrigenAndStdIdLegEntInAmbito']}")
  private String sqlFindIdLocalizacionByIdTareaAndCclIdOrigenAndStdIdLegEntInAmbito;

  @Value("#{primaryQuery['TareaLocalizacionHistoricoRepositoryCustom.findIdLocalizacionPresupuestosByIdTarea']}")
  private String sqlFindIdLocalizacionPresupuestosByIdTarea;

  @Value("#{primaryQuery['TareaLocalizacionHistoricoRepositoryCustom.findIdLocalizacionPresupuestosByStdIdLegEntAndIdTarea']}")
  private String sqlFindIdLocalizacionPresupuestosByStdIdLegEntAndIdTarea;

  @Value("#{primaryQuery['TareaLocalizacionHistoricoRepositoryCustom.findIdLocalizacionLocalByIdTipoPresupuestoAndFechaAndIdTarea']}")
  private String sqlFindIdLocalizacionLocalByIdTipoPresupuestoAndFechaAndIdTarea;

  @Value("#{primaryQuery['TareaLocalizacionHistoricoRepositoryCustom.mergeLocalizacionFicticia']}")
  private String sqlMergeLocalizacionFicticia;

  @Value("#{primaryQuery['TareaLocalizacionHistoricoRepositoryCustom.findLocalizacionFicticiaByIdOrigenAndIdEmpresa']}")
  private String sqlFindLocalizacionFicticiaByIdOrigenAndIdEmpresa;

  @Value("#{primaryQuery['TareaLocalizacionHistoricoRepositoryCustom.findIdLocalizacionByIdTarea']}")
  private String sqlFindIdLocalizacionByIdTarea;

  @Override
  public List<TareaLocalizacionHistorico> save(final List<TareaLocalizacionHistorico> src) {
    return this.saveNamedJdbcBatchList(src, this.sqlSave, this.batchSize);
  }

  @Override
  public List<IdLocalizacionDto> findIdLocalizacionDtoByIdTareaAndCclIdOrigenInAmbito(
      @NotNull @Positive final Long idTarea, @NotBlank final String cclIdOrigen) {
    final MapSqlParameterSource parameters = new MapSqlParameterSource();
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, idTarea);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_CCL_ID_ORIGEN, cclIdOrigen);
    return this.query(this.sqlFindIdLocalizacionDtoByIdTareaAndIdOrigenInAmbito,
        parameters,
        new RowMapper<IdLocalizacionDto>() {
          @Override
          public IdLocalizacionDto mapRow(final ResultSet rs, final int rowNum) throws SQLException {
            final IdLocalizacionDto dto = new IdLocalizacionDto();
            dto.setId(rs.getString(SqlPrimaryConstants.SQL_RESULT_ID_LOCALIZACION_META4));
            return dto;
          }
        });
  }

  @Override
  public List<IdLocalizacionDto> findIdLocalizacionDtoByIdTareaAndCclIdOrigenInAmbitoLocalizacion(
      @NotNull @Positive final Long idTarea, @NotBlank final String cclIdOrigen) {
    final MapSqlParameterSource parameters = new MapSqlParameterSource();
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, idTarea);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_CCL_ID_ORIGEN, cclIdOrigen);
    return this.query(
        this.sqlFindIdLocalizacionDtoByIdTareaAndIdOrigenInAmbitoLocalizacion,
        parameters,
        new RowMapper<IdLocalizacionDto>() {
          @Override
          public IdLocalizacionDto mapRow(final ResultSet rs, final int rowNum) throws SQLException {
            final IdLocalizacionDto dto = new IdLocalizacionDto();
            dto.setId(rs.getString(SqlPrimaryConstants.SQL_RESULT_ID_LOCALIZACION_META4));
            return dto;
          }
        });
  }

  @Override
  public List<IdLocalizacionLocalDto> findIdLocalizacionLocalDtoByIdTareaAndCclIdOrigenAndStdIdLegEntInAmbito(
      @NotNull @Positive final Long idTarea, @NotBlank final String cclIdOrigen,
      @NotNull @NotEmpty final List<String> stdIdLegEnt) {
    final MapSqlParameterSource parameters = new MapSqlParameterSource();
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, idTarea);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_CCL_ID_ORIGEN, cclIdOrigen);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_STD_ID_LEG_ENT, stdIdLegEnt);

    return this.query(this.sqlFindIdLocalizacionLocalDtoByIdTareaAndIdOrigenAndIdEmpresaInAmbito,
        parameters, (rs, rowNum) -> {
          final IdLocalizacionLocalDto dto = new IdLocalizacionLocalDto();
          dto.setId(rs.getString(SqlPrimaryConstants.SQL_RESULT_ID_LOCALIZACION_LOCAL));
          return dto;
        });
  }

  @Override
  public List<IdLocalizacionLocalDto> findIdLocalizacionLocalInCadenaAndProvinciaDtoByIdTareaAndIdOrigenAndIdEmpresaInAmbito(
      @NotNull @Positive final Long idTarea, @NotBlank final String cclIdOrigen,
      @NotNull @NotEmpty final List<String> stdIdLegEnt) {
    final MapSqlParameterSource parameters = new MapSqlParameterSource();
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, idTarea);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_CCL_ID_ORIGEN, cclIdOrigen);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_STD_ID_LEG_ENT, stdIdLegEnt);

    return this.query(
        this.sqlFindIdLocalizacionLocalInCadenaAndProvinciaDtoByIdTareaAndIdOrigenAndIdEmpresaInAmbito,
        parameters, (rs, rowNum) -> {
          final IdLocalizacionLocalDto dto = new IdLocalizacionLocalDto();
          dto.setId(rs.getString(SqlPrimaryConstants.SQL_RESULT_ID_LOCALIZACION_LOCAL));
          return dto;
        });
  }

  @Override
  public List<IdLocalizacionEmpresaDto> findIdLocalizacionDtoByIdTareaAndCclIdOrigenAndStdIdLegEntInAmbito(
      @NotNull @Positive final Long idTarea, @NotBlank final String cclIdOrigen,
      @NotNull @NotEmpty final List<String> stdIdLegEnt) {
    final MapSqlParameterSource parameters = new MapSqlParameterSource();
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, idTarea);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_CCL_ID_ORIGEN, cclIdOrigen);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_STD_ID_LEG_ENT, stdIdLegEnt);

    return this.query(this.sqlFindIdLocalizacionDtoByIdTareaAndIdOrigenAndIdEmpresaInAmbito,
        parameters, (rs, rowNum) -> {
          final IdLocalizacionEmpresaDto dto = new IdLocalizacionEmpresaDto();
          dto.setId(rs.getString(SqlPrimaryConstants.SQL_RESULT_ID_LOCALIZACION_META4));
          dto.setStdIdLegEnt(rs.getString(SqlPrimaryConstants.SQL_RESULT_EMPRESA));
          return dto;
        });
  }

  @Override
  public List<IdLocalizacionLocalDto> findIdLocalizacionLocalDtoByIdTareaAndCclIdOrigenInAmbito(
      @NotNull @Positive final Long idTarea, @NotBlank final String cclIdOrigen) {
    final MapSqlParameterSource parameters = new MapSqlParameterSource();
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, idTarea);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_CCL_ID_ORIGEN, cclIdOrigen);

    return this.query(this.sqlFindIdLocalizacionLocalDtoByIdTareaAndIdOrigenInAmbito,
        parameters,
        new RowMapper<IdLocalizacionLocalDto>() {
          @Override
          public IdLocalizacionLocalDto mapRow(final ResultSet rs, final int rowNum) throws SQLException {
            final IdLocalizacionLocalDto dto = new IdLocalizacionLocalDto();
            dto.setId(rs.getString(SqlPrimaryConstants.SQL_RESULT_ID_LOCALIZACION_LOCAL));
            return dto;
          }
        });
  }

  @Override
  public List<IdLocalizacionLocalDto> findIdLocalizacionLocalDtoByIdTareaAndCclIdOrigenInAmbitoLocalizacion(
      @NotNull @Positive final Long idTarea, @NotBlank final String cclIdOrigen) {
    final MapSqlParameterSource parameters = new MapSqlParameterSource();
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, idTarea);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_CCL_ID_ORIGEN, cclIdOrigen);

    return this.query(
        this.sqlFindIdLocalizacionLocalDtoByIdTareaAndIdOrigenInAmbitoLocalizacion,
        parameters,
        new RowMapper<IdLocalizacionLocalDto>() {
          @Override
          public IdLocalizacionLocalDto mapRow(final ResultSet rs, final int rowNum) throws SQLException {
            final IdLocalizacionLocalDto dto = new IdLocalizacionLocalDto();
            dto.setId(rs.getString(SqlPrimaryConstants.SQL_RESULT_ID_LOCALIZACION_LOCAL));
            return dto;
          }
        });
  }

  @Override
  public List<IdLocalizacionLocalDto> findIdLocalizacionLocalDtoByIdTareaAndIdOrigenAndIdCadena(
      @NotNull @Positive final Long idTarea, @NotBlank final String cclIdOrigen,
      @NotNull final List<String> idsCadena) {
    final MapSqlParameterSource parameters = new MapSqlParameterSource();
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, idTarea);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_CCL_ID_ORIGEN, cclIdOrigen);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_CADENA, idsCadena);

    return this.query(
        this.sqlFindIdLocalizacionLocalDtoByIdTareaAndIdOrigenAndIdCadena,
        parameters, new RowMapper<IdLocalizacionLocalDto>() {
          @Override
          public IdLocalizacionLocalDto mapRow(final ResultSet rs, final int rowNum) throws SQLException {
            final IdLocalizacionLocalDto dto = new IdLocalizacionLocalDto();
            dto.setId(rs.getString(SqlPrimaryConstants.SQL_RESULT_ID_LOCALIZACION_LOCAL));
            return dto;
          }
        });
  }

  @Override
  public List<IdCadenaDto> getCadenasByTareaAndOrigenAndEmpresa(final Long idTarea, final String cclIdOrigen,
      final String stdIdLegEnt, final List<Long> idVentaConcepto) {
    final MapSqlParameterSource parameters = new MapSqlParameterSource();
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, idTarea);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_CCL_ID_ORIGEN, cclIdOrigen);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_STD_ID_LEG_ENT, stdIdLegEnt);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_CONCEPTO, idVentaConcepto);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_PORCENTAJE_INCLUSION,
        SqlPrimaryConstants.SQL_VALUE_PORCENTAJE_CERO);
    return this.query(this.sqlCadenasFiltroTipoDatoEmpresa, parameters,
        (rs, rowNum) -> IdCadenaDto.builder()
            .id(rs.getString(SqlPrimaryConstants.SQL_RESULT_ID_CADENA))
            .build());
  }

  @Override
  public List<IdCadenaDto> getCadenasByTareaAndOrigen(final Long idTarea, final String cclIdOrigen) {
    final MapSqlParameterSource parameters = new MapSqlParameterSource();
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, idTarea);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_CCL_ID_ORIGEN, cclIdOrigen);
    return this.query(this.sqlCadenas, parameters, (rs, rowNum) -> IdCadenaDto.builder()
        .id(rs.getString(SqlPrimaryConstants.SQL_RESULT_ID_CADENA))
        .build());
  }

  @Override
  public List<IdCadenaDto> getCadenasByTareaAndOrigen(final Long idTarea, final String cclIdOrigen,
      final List<Long> idVentaConcepto) {
    final MapSqlParameterSource parameters = new MapSqlParameterSource();
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, idTarea);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_CCL_ID_ORIGEN, cclIdOrigen);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_CONCEPTO, idVentaConcepto);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_PORCENTAJE_INCLUSION,
        SqlPrimaryConstants.SQL_VALUE_PORCENTAJE_CERO);
    return this.query(this.sqlCadenasFiltroTipoDato, parameters,
        (rs, rowNum) -> IdCadenaDto.builder()
            .id(rs.getString(SqlPrimaryConstants.SQL_RESULT_ID_CADENA))
            .build());
  }

  @Override
  public List<IdCadenaDto> findIdCadenaDtoByIdTareaAndCclIdOrigenAndTipoDatoNotInAmbito(final Long idTarea,
      final String cclIdOrigen,
      final List<Long> idVentaConcepto) {
    final MapSqlParameterSource parameters = new MapSqlParameterSource();
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, idTarea);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_CCL_ID_ORIGEN, cclIdOrigen);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_CONCEPTO, idVentaConcepto);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_PORCENTAJE_INCLUSION,
        SqlPrimaryConstants.SQL_VALUE_PORCENTAJE_CERO);
    return this.query(this.sqlGetCadenasByTareaAndOrigenAndTipoDatoNotInAmbito, parameters,
        (rs, rowNum) -> IdCadenaDto.builder()
            .id(rs.getString(SqlPrimaryConstants.SQL_RESULT_ID_CADENA))
            .build());
  }

  @Override
  public List<IdLocalizacionLocalDto> findIdLocalizacionLocalDtoByIdTareaAndCclIdOrigenAndTipoCalculoInAmbitoLocalizacion(
      @NotNull @Positive final Long idTarea, final String cclCodOrigen, final List<String> tiposCalculo) {
    final MapSqlParameterSource parameters = new MapSqlParameterSource();
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, idTarea);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_IDS_TIPOS_CALCULO, tiposCalculo);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_CCL_ID_ORIGEN, cclCodOrigen);

    return this.query(this.sqlFindIdLocalizacionByIdTareaAndCclIdPersonInAmbito,
        parameters,
        (rs, rowNum) -> IdLocalizacionLocalDto.builder()
            .id(rs.getString(SqlPrimaryConstants.SQL_RESULT_ID_LOCALIZACION_LOCAL))
            .build());
  }

  @Override
  public List<IdLocalizacionLocalDto> findIdLocalizacionLocalDtoByIdTareaAndCclIdOrigenAndStdIdLegEntAndTipoCalculoInAmbitoLocalizacion(
      @NotNull @Positive final Long idTarea, @NotBlank final String cclCodOrigen,
      @NotNull @NotEmpty final List<String> stdIdLegEnt,
      @NotNull final List<String> tiposCalculo) {
    final MapSqlParameterSource parameters = new MapSqlParameterSource();
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, idTarea);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_IDS_TIPOS_CALCULO, tiposCalculo);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_CCL_ID_ORIGEN, cclCodOrigen);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_STD_ID_LEG_ENT, stdIdLegEnt);

    return this.query(this.sqlFindIdLocalizacionByIdTareaAndCclIdOrigenAndStdIdLegEntInAmbito,
        parameters,
        (rs, rowNum) -> IdLocalizacionLocalDto.builder()
            .id(rs.getString(SqlPrimaryConstants.SQL_RESULT_ID_LOCALIZACION_LOCAL))
            .build());
  }

  @Override
  public List<IdLocalizacionLocalPresupuestoDto> findIdLocalizacionLocalDtoPresupuestosByIdTarea(
      @NotNull @Positive final Long idTarea) {
    final MapSqlParameterSource parameters = new MapSqlParameterSource();
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, idTarea);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_IDS_TIPOS_COMISION, Arrays
        .asList(TipoComisionEnum.CHALLENGE_PRINCIPAL.getId(), TipoComisionEnum.CHALLENGE_SECUNDARIO.getId()));
    return this.query(this.sqlFindIdLocalizacionPresupuestosByIdTarea, parameters,
        (rs, rowNum) -> IdLocalizacionLocalPresupuestoDto.builder()
            .idTipoPresupuesto(rs.getInt(SqlPrimaryConstants.SQL_RESULT_ID_TIPO_PRESUPUESTO))
            .fechaInicio(rs.getDate(SqlPrimaryConstants.SQL_RESULT_FECHA_INICIO).toLocalDate())
            .fechaFin(rs.getDate(SqlPrimaryConstants.SQL_RESULT_FECHA_FIN).toLocalDate())
            .build());
  }

  @Override
  public List<IdLocalizacionLocalPresupuestoDto> findIdLocalizacionPresupuestosByStdIdLegEntAndIdTarea(
      @NotNull @NotEmpty final List<String> stdIdLegEnt, @NotNull @Positive final Long idTarea,
      @NotNull @NotEmpty final List<Long> idTipoConceptoVentaChallenge) {
    final MapSqlParameterSource parameters = new MapSqlParameterSource();
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, idTarea);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_STD_ID_LEG_ENT, stdIdLegEnt);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_IDS_TIPOS_CALCULO, Arrays
        .asList(TipoCalculoEnum.CHALLENGE_PORCENTAJE.getId(), TipoCalculoEnum.CHALLENGE_IMPORTE_SECCION.getId(),
            TipoCalculoEnum.CHALLENGE_IMPORTE_TIENDA.getId(),
            TipoCalculoEnum.CHALLENGE_PRECIO_HORA_SECCION.getId(),
            TipoCalculoEnum.CHALLENGE_PRECIO_HORA_TIENDA.getId()));
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_TIPO_CONCEPTO_VENTA_CHALLENGE, idTipoConceptoVentaChallenge);

    return this.query(this.sqlFindIdLocalizacionPresupuestosByStdIdLegEntAndIdTarea, parameters,
        (rs, rowNum) -> IdLocalizacionLocalPresupuestoDto.builder()
            .idTipoPresupuesto(rs.getInt(SqlPrimaryConstants.SQL_RESULT_ID_TIPO_PRESUPUESTO))
            .fechaInicio(rs.getDate(SqlPrimaryConstants.SQL_RESULT_FECHA_INICIO).toLocalDate())
            .fechaFin(rs.getDate(SqlPrimaryConstants.SQL_RESULT_FECHA_FIN).toLocalDate())
            .build());
  }

  @Override
  public List<IdLocalizacionLocalDto> findIdLocalizacionLocalByIdTipoPresupuestoAndFechaAndIdTarea(
      @NotNull @Positive final Long idTarea, @NotNull @Positive final Integer idTipoPresupuesto,
      @NotNull final LocalDate fechaInicio, @NotNull final LocalDate fechaFin) {
    final MapSqlParameterSource parameters = new MapSqlParameterSource();
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, idTarea);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_PRESUPUESTO, idTipoPresupuesto);
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_FECHA_INICIO, TimeUtils.toDate(fechaInicio));
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_FECHA_FIN, TimeUtils.toDate(fechaFin));

    return this.query(this.sqlFindIdLocalizacionLocalByIdTipoPresupuestoAndFechaAndIdTarea, parameters,
        (rs, rowNum) -> IdLocalizacionLocalDto.builder()
            .id(rs.getString(SqlPrimaryConstants.SQL_RESULT_ID_LOCALIZACION_LOCAL))
            .build());
  }

  @Override
  public List<IdLocalizacionDto> findIdLocalizacionByIdTarea(
      @NotNull @Positive final Long idTarea) {
    final MapSqlParameterSource parameters = new MapSqlParameterSource();
    parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, idTarea);

    return this.query(this.sqlFindIdLocalizacionByIdTarea, parameters,
        (rs, rowNum) -> IdLocalizacionDto.builder()
            .id(rs.getString(SqlPrimaryConstants.SQL_RESULT_ID_LOCALIZACION_META4))
            .build());
  }

  @Override
  public void mergeLocalizacionFicticia(@NotNull final Long idTarea,
      @NotNull final String cclIdOrigen, @NotBlank final String stdIdLegEnt) {
    final MapSqlParameterSource params = new MapSqlParameterSource();
    params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, idTarea);
    params.addValue(SqlPrimaryConstants.SQL_PARAM_CCL_ID_ORIGEN, cclIdOrigen);
    params.addValue(SqlPrimaryConstants.SQL_PARAM_STD_ID_LEG_ENT, stdIdLegEnt);

    this.update(this.sqlMergeLocalizacionFicticia, params);
  }

  @Override
  public List<IdLocalizacionLocalDto> findLocalizacionFicticiaByIdOrigenAndIdEmpresa(
      @NotNull final String cclIdOrigen, @NotBlank final String stdIdLegEnt) {
    final MapSqlParameterSource params = new MapSqlParameterSource();
    params.addValue(SqlPrimaryConstants.SQL_PARAM_CCL_ID_ORIGEN, cclIdOrigen);
    params.addValue(SqlPrimaryConstants.SQL_PARAM_STD_ID_LEG_ENT, stdIdLegEnt);

    return this.query(this.sqlFindLocalizacionFicticiaByIdOrigenAndIdEmpresa, params,
        (rs, rowNum) -> IdLocalizacionLocalDto.builder()
            .id(rs.getString(SqlPrimaryConstants.SQL_RESULT_ID_LOCALIZACION_LOCAL))
            .build());
  }

}
