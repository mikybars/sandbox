package com.inditex.rrhh.icmclcwb.model.primary.repository;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.calcular.TipoCalculoEnum;
import com.inditex.rrhh.icmclcwb.api.app.dto.GenericAlgoritmoPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdMotivoDesplazamientoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalCarenciaDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalComisionManualDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalCondicionesDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalLocalizacionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.AppConstants;
import com.inditex.rrhh.icmclcwb.api.app.util.SqlComisConstants;
import com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants;
import com.inditex.rrhh.icmclcwb.model.app.util.RunUtils;
import com.inditex.rrhh.icmclcwb.model.app.util.StreamUtils;
import com.inditex.rrhh.icmclcwb.model.app.util.TimeUtils;

import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class PrimaryTemporaryTableRepositoryCustomImpl
    implements PrimaryTemporaryTableRepositoryCustom {

  @Autowired
  @Qualifier("primaryJdbcTemplate")
  private JdbcTemplate jdbcTemplate;

  @Autowired
  @Qualifier("primaryNamedParameterJdbcTemplate")
  private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

  @Value("${app.envars.repository.batch-size.default}")
  private int batchSize;

  @Value("#{primaryQuery['PrimaryTemporaryTableRepositoryCustom.createTempMotivoDesplazamientoComis']}")
  private String sqlCreateTempMotivoDesplazamientoComis;

  @Value("#{primaryQuery['PrimaryTemporaryTableRepositoryCustom.deleteTempMotivoDesplazamientoComis']}")
  private String sqlDeleteTempMotivoDesplazamientoComis;

  @Value("#{primaryQuery['PrimaryTemporaryTableRepositoryCustom.insertTempMotivoDesplazamientoComis']}")
  private String sqlInsertTempMotivoDesplazamientoComis;

  @Value("#{primaryQuery['PrimaryTemporaryTableRepositoryCustom.createTempMotivoDesplazamientoMeta4']}")
  private String sqlCreateTempMotivoDesplazamientoMeta4;

  @Value("#{primaryQuery['PrimaryTemporaryTableRepositoryCustom.deleteTempMotivoDesplazamientoMeta4']}")
  private String sqlDeleteTempMotivoDesplazamientoMeta4;

  @Value("#{primaryQuery['PrimaryTemporaryTableRepositoryCustom.insertTempMotivoDesplazamientoMeta4']}")
  private String sqlInsertTempMotivoDesplazamientoMeta4;

  @Value("#{primaryQuery['PrimaryTemporaryTableRepositoryCustom.validateTempMotivoDesplazamiento']}")
  private String sqlValidateTempMotivoDesplazamiento;

  @Value("#{primaryQuery['PrimaryTemporaryTableRepositoryCustom.createTempComisHistorico']}")
  private String sqlCreateTempComisHistorico;

  @Value("#{primaryQuery['PrimaryTemporaryTableRepositoryCustom.deleteTempComisHistorico']}")
  private String sqlDeleteTempComisHistorico;

  @Value("#{primaryQuery['PrimaryTemporaryTableRepositoryCustom.insertTempComisHistorico']}")
  private String sqlInsertTempComisHistorico;

  @Value("#{primaryQuery['PrimaryTemporaryTableRepositoryCustom.mergeDateRangesTempComisHistorico']}")
  private String sqlMergeDateRangesTempComisHistorico;

  @Value("#{primaryQuery['PrimaryTemporaryTableRepositoryCustom.mergeDateRangesSeccionNotEqualsTempComisHistorico']}")
  private String sqlMergeDateRangesSeccionNotEqualsTempComisHistorico;

  @Value("#{primaryQuery['PrimaryTemporaryTableRepositoryCustom.validateTempComisHistorico']}")
  private String sqlValidateTempComisHistorico;

  @Value("#{primaryQuery['PrimaryTemporaryTableRepositoryCustom.createTempComisDesplazamiento']}")
  private String sqlCreateTempComisDesplazamiento;

  @Value("#{primaryQuery['PrimaryTemporaryTableRepositoryCustom.deleteTempComisDesplazamiento']}")
  private String sqlDeleteTempComisDesplazamiento;

  @Value("#{primaryQuery['PrimaryTemporaryTableRepositoryCustom.insertTempComisDesplazamiento']}")
  private String sqlInsertTempComisDesplazamiento;

  @Value("#{primaryQuery['PrimaryTemporaryTableRepositoryCustom.validateTempComisDesplazamiento']}")
  private String sqlValidateTempComisDesplazamiento;

  @Value("#{primaryQuery['PrimaryTemporaryTableRepositoryCustom.desactivaFechasSolapadas']}")
  private String sqlDesactivaFechasSolapadas;

  @Value("#{primaryQuery['PrimaryTemporaryTableRepositoryCustom.reactivaFechasSolapadas']}")
  private String sqlReactivaFechasSolapadas;

  @Value("#{primaryQuery['PrimaryTemporaryTableRepositoryCustom.createTempComisResalta']}")
  private String sqlCreateTempComisResalta;

  @Value("#{primaryQuery['PrimaryTemporaryTableRepositoryCustom.deleteTempComisResalta']}")
  private String sqlDeleteTempComisResalta;

  @Value("#{primaryQuery['PrimaryTemporaryTableRepositoryCustom.insertTempComisResalta']}")
  private String sqlInsertTempComisResalta;

  @Value("#{primaryQuery['PrimaryTemporaryTableRepositoryCustom.mergeDateRangesTempComisResalta']}")
  private String sqlMergeDateRangesTempComisResalta;

  @Value("#{primaryQuery['PrimaryTemporaryTableRepositoryCustom.mergeDateRangesSeccionNotEqualsTempComisResalta']}")
  private String sqlMergeDateRangesSeccionNotEqualsTempComisResalta;

  @Value("#{primaryQuery['PrimaryTemporaryTableRepositoryCustom.validateTempComisResalta']}")
  private String sqlValidateTempComisResalta;

  @Value("#{primaryQuery['PrimaryTemporaryTableRepositoryCustom.createTempComisBajaIt']}")
  private String sqlCreateTempComisBajaIt;

  @Value("#{primaryQuery['PrimaryTemporaryTableRepositoryCustom.deleteTempComisBajaIt']}")
  private String sqlDeleteTempComisBajaIt;

  @Value("#{primaryQuery['PrimaryTemporaryTableRepositoryCustom.insertTempComisBajaIt']}")
  private String sqlInsertTempComisBajaIt;

  @Value("#{primaryQuery['PrimaryTemporaryTableRepositoryCustom.validateTempComisBajaIt']}")
  private String sqlValidateTempComisBajaIt;

  @Value("#{primaryQuery['PrimaryTemporaryTableRepositoryCustom.createTempComisCarencia']}")
  private String sqlCreateTempComisCarencia;

  @Value("#{primaryQuery['PrimaryTemporaryTableRepositoryCustom.deleteTempComisCarencia']}")
  private String sqlDeleteTempComisCarencia;

  @Value("#{primaryQuery['PrimaryTemporaryTableRepositoryCustom.insertTempComisCarencia']}")
  private String sqlInsertTempComisCarencia;

  @Value("#{primaryQuery['PrimaryTemporaryTableRepositoryCustom.validateTempComisCarencia']}")
  private String sqlValidateTempComisCarencia;

  @Value("#{primaryQuery['PrimaryTemporaryTableRepositoryCustom.createTempAlgoritmo']}")
  private String sqlCreateTempAlgoritmo;

  @Value("#{primaryQuery['PrimaryTemporaryTableRepositoryCustom.indexTempAlgoritmo']}")
  private String sqlIndexTempAlgoritmo;

  @Value("#{primaryQuery['PrimaryTemporaryTableRepositoryCustom.deleteTempAlgoritmo']}")
  private String sqlDeleteTempAlgoritmo;

  @Value("#{primaryQuery['PrimaryTemporaryTableRepositoryCustom.createTempMejorOpcion']}")
  private String sqlCreateTempMejorOpcion;

  @Value("#{primaryQuery['PrimaryTemporaryTableRepositoryCustom.indexTempMejorOpcion']}")
  private String sqlIndexTempMejorOpcion;

  @Value("#{primaryQuery['PrimaryTemporaryTableRepositoryCustom.insertTempMejorOpcion']}")
  private String sqlInsertTempMejorOpcion;

  @Value("#{primaryQuery['PrimaryTemporaryTableRepositoryCustom.deleteTempMejorOpcion']}")
  private String sqlDeleteTempMejorOpcion;

  @Value("#{primaryQuery['PrimaryTemporaryTableRepositoryCustom.createTempMejorOpcionSinFechas']}")
  private String sqlCreateTempMejorOpcionSinFechas;

  @Value("#{primaryQuery['PrimaryTemporaryTableRepositoryCustom.indexTempMejorOpcionSinFechas']}")
  private String sqlIndexTempMejorOpcionSinFechas;

  @Value("#{primaryQuery['PrimaryTemporaryTableRepositoryCustom.insertTempMejorOpcionSinFechas']}")
  private String sqlInsertTempMejorOpcionSinFechas;

  @Value("#{primaryQuery['PrimaryTemporaryTableRepositoryCustom.deleteTempMejorOpcionSinFechas']}")
  private String sqlDeleteTempMejorOpcionSinFechas;

  @Value("#{primaryQuery['PrimaryTemporaryTableRepositoryCustom.createTempMejorOpcionSinFechasTodoPeriodo']}")
  private String sqlCreateTempMejorOpcionSinFechasTodoPeriodo;

  @Value("#{primaryQuery['PrimaryTemporaryTableRepositoryCustom.indexTempMejorOpcionSinFechasTodoPeriodo']}")
  private String sqlIndexTempMejorOpcionSinFechasTodoPeriodo;

  @Value("#{primaryQuery['PrimaryTemporaryTableRepositoryCustom.insertTempMejorOpcionSinFechasTodoPeriodo']}")
  private String sqlInsertTempMejorOpcionSinFechasTodoPeriodo;

  @Value("#{primaryQuery['PrimaryTemporaryTableRepositoryCustom.deleteTempMejorOpcionSinFechasTodoPeriodo']}")
  private String sqlDeleteTempMejorOpcionSinFechasTodoPeriodo;

  @Value("#{primaryQuery['PrimaryTemporaryTableRepositoryCustom.insertTempComisAlgoritmo']}")
  private String sqlInsertTempComisAlgoritmo;

  @Value("#{primaryQuery['PrimaryTemporaryTableRepositoryCustom.createTempEstructura']}")
  private String sqlCreateTempEstructura;

  @Value("#{primaryQuery['PrimaryTemporaryTableRepositoryCustom.indexTempEstructura']}")
  private String sqlIndexTempEstructura;

  @Value("#{primaryQuery['PrimaryTemporaryTableRepositoryCustom.deleteTempEstructura']}")
  private String sqlDeleteTempEstructura;

  @Value("#{primaryQuery['PrimaryTemporaryTableRepositoryCustom.insertTempEstructura']}")
  private String sqlInsertTempEstructura;

  @Value("#{primaryQuery['PrimaryTemporaryTableRepositoryCustom.createTempPersonas']}")
  private String sqlCreateTempPersonas;

  @Value("#{primaryQuery['PrimaryTemporaryTableRepositoryCustom.indexTempPersonas']}")
  private String sqlIndexTempPersonas;

  @Value("#{primaryQuery['PrimaryTemporaryTableRepositoryCustom.deleteTempPersonas']}")
  private String sqlDeleteTempPersonas;

  @Value("#{primaryQuery['PrimaryTemporaryTableRepositoryCustom.insertTempPersonas']}")
  private String sqlInsertTempPersonas;

  @Value("#{primaryQuery['PrimaryTemporaryTableRepositoryCustom.createTempPresupuestos']}")
  private String sqlCreateTempPresupuestos;

  @Value("#{primaryQuery['PrimaryTemporaryTableRepositoryCustom.indexTempPresupuestos']}")
  private String sqlIndexTempPresupuestos;

  @Value("#{primaryQuery['PrimaryTemporaryTableRepositoryCustom.deleteTempPresupuestos']}")
  private String sqlDeleteTempPresupuestos;

  @Value("#{primaryQuery['PrimaryTemporaryTableRepositoryCustom.insertTempPresupuesto']}")
  private String sqlInsertTempPresupuestos;

  @Value("#{primaryQuery['PrimaryTemporaryTableRepositoryCustom.insertTareaLocalizacionPresupuestoTareaPersonaEstructura']}")
  private String sqlInsertTareaLocalizacionPresupuestoTareaPersonaEstructura;

  @Value("#{primaryQuery['PrimaryTemporaryTableRepositoryCustom.createTempComisPrimas']}")
  private String sqlCreateTempComisPrimas;

  @Value("#{primaryQuery['PrimaryTemporaryTableRepositoryCustom.deleteTempComisPrimas']}")
  private String sqlDeleteTempComisPrimas;

  @Value("#{primaryQuery['PrimaryTemporaryTableRepositoryCustom.insertTempComisPrimas']}")
  private String sqlInsertTempComisPrimas;

  @Value("#{primaryQuery['PrimaryTemporaryTableRepositoryCustom.mergeDateRangesTempComisPrimas']}")
  private String sqlMergeDateRangesTempComisPrimas;

  @Value("#{primaryQuery['PrimaryTemporaryTableRepositoryCustom.mergeDateRangesSeccionNotEqualsTempComisPrimas']}")
  private String sqlMergeDateRangesSeccionNotEqualsTempComisPrimas;

  @Value("#{primaryQuery['PrimaryTemporaryTableRepositoryCustom.validateTempComisPrimas']}")
  private String sqlValidateTempComisPrimas;

  @Value("#{primaryQuery['PrimaryTemporaryTableRepositoryCustom.createTempCalculoPorComision']}")
  private String sqlCreateTempCalculoPorComision;

  @Value("#{primaryQuery['PrimaryTemporaryTableRepositoryCustom.deleteTempCalculoPorComision']}")
  private String sqlDeleteTempCalculoPorComision;

  @Value("#{primaryQuery['PrimaryTemporaryTableRepositoryCustom.mergeCalculoTempCalculoSinComision']}")
  private String sqlMergeCalculoTempCalculoSinComision;

  @Value("#{primaryQuery['PrimaryTemporaryTableRepositoryCustom.mergeCalculoTempCalculoPorComision']}")
  private String sqlMergeCalculoTempCalculoPorComision;

  @Value("#{primaryQuery['PrimaryTemporaryTableRepositoryCustom.createTempCalculoAjusteTotalizado']}")
  private String sqlCreateTempCalculoAjusteTotalizado;

  @Value("#{primaryQuery['PrimaryTemporaryTableRepositoryCustom.deleteTempCalculoAjusteTotalizado']}")
  private String sqlDeleteTempCalculoAjusteTotalizado;

  @Value("#{primaryQuery['PrimaryTemporaryTableRepositoryCustom.mergeCalculoAjusteTotalizado']}")
  private String sqlMergeCalculoAjusteTotalizado;

  @Value("#{primaryQuery['PrimaryTemporaryTableRepositoryCustom.createTempBandasOrigenSinBandaDesplazamiento']}")
  private String sqlCreateTempBandasOrigenSinBandaDesplazamiento;

  @Value("#{primaryQuery['PrimaryTemporaryTableRepositoryCustom.insertBandasOrigenSinBandaDesplazamiento']}")
  private String sqlInsertBandasOrigenSinBandaDesplazamiento;

  @Value("#{primaryQuery['PrimaryTemporaryTableRepositoryCustom.deleteTempBandasOrigenSinBandaDesplazamiento']}")
  private String sqlDeleteTempBandasOrigenSinBandaDesplazamiento;

  @Value("#{primaryQuery['PrimaryTemporaryTableRepositoryCustom.createTempEstructurasBaseChallenge']}")
  private String sqlCreateTempEstructurasBaseChallenge;

  @Value("#{primaryQuery['PrimaryTemporaryTableRepositoryCustom.indexTempEstructurasBaseChallenge']}")
  private String sqlIndexTempEstructurasBaseChallenge;

  @Value("#{primaryQuery['PrimaryTemporaryTableRepositoryCustom.insertTempEstructurasBaseChallenge']}")
  private String sqlInsertTempEstructurasBaseChallenge;

  @Value("#{primaryQuery['PrimaryTemporaryTableRepositoryCustom.deleteTempEstructurasBaseChallenge']}")
  private String sqlDeleteTempEstructurasBaseChallenge;

  @Value("#{primaryQuery['PrimaryTemporaryTableRepositoryCustom.createTempEstructurasDesplazamientoNoChallenge']}")
  private String sqlCreateTempEstructurasDesplazamientoNoChallenge;

  @Value("#{primaryQuery['PrimaryTemporaryTableRepositoryCustom.indexTempEstructurasDesplazamientoNoChallenge']}")
  private String sqlIndexTempEstructurasDesplazamientoNoChallenge;

  @Value("#{primaryQuery['PrimaryTemporaryTableRepositoryCustom.insertTempEstructurasDesplazamientoNoChallenge']}")
  private String sqlInsertTempEstructurasDesplazamientoNoChallenge;

  @Value("#{primaryQuery['PrimaryTemporaryTableRepositoryCustom.deleteTempEstructurasDesplazamientoNoChallenge']}")
  private String sqlDeleteTempEstructurasDesplazamientoNoChallenge;

  @Value("#{primaryQuery['PrimaryTemporaryTableRepositoryCustom.createTempComisComisionManual']}")
  private String sqlCreateTempComisComisionManual;

  @Value("#{primaryQuery['PrimaryTemporaryTableRepositoryCustom.indexTempComisComisionManual']}")
  private String sqlIndexTempComisComisionManual;

  @Value("#{primaryQuery['PrimaryTemporaryTableRepositoryCustom.insertTempComisComisionManual']}")
  private String sqlInsertTempComisComisionManual;

  @Value("#{primaryQuery['PrimaryTemporaryTableRepositoryCustom.deleteTempComisComisionManual']}")
  private String sqlDeleteTempComisComisionManual;

  @Value("#{primaryQuery['PrimaryTemporaryTableRepositoryCustom.validateTempComisComisionManual']}")
  private String sqlValidateTempComisComisionManual;

  @Value("#{primaryQuery['PrimaryTemporaryTableRepositoryCustom.createTempComisPersonasLocalizaciones']}")
  private String sqlCreateTempComisPersonasLocalizaciones;

  @Value("#{primaryQuery['PrimaryTemporaryTableRepositoryCustom.indexTempComisPersonasLocalizaciones']}")
  private String sqlIndexTempComisPersonasLocalizaciones;

  @Value("#{primaryQuery['PrimaryTemporaryTableRepositoryCustom.deleteTempComisPersonasLocalizaciones']}")
  private String sqlDeleteTempComisPersonasLocalizaciones;

  @Value("#{primaryQuery['PrimaryTemporaryTableRepositoryCustom.insertTempComisPersonasLocalizaciones']}")
  private String sqlInsertTempComisPersonasLocalizaciones;

  @Value("#{primaryQuery['PrimaryTemporaryTableRepositoryCustom.validateTempComisPersonas']}")
  private String sqlValidateTempComisPersonas;

  @Value("#{primaryQuery['PrimaryTemporaryTableRepositoryCustom.validateTempComisChallengePorcentaje']}")
  private String sqlValidateTempComisChallengePorcentaje;

  @Value("#{primaryQuery['PrimaryTemporaryTableRepositoryCustom.validateTempComisDesplazamientoChallengePorcentaje']}")
  private String sqlValidateTempComisDesplazamientoChallengePorcentaje;

  @Override
  public int deleteTempMotivoDesplazamientoComis() {
    return this.jdbcTemplate.update(this.sqlDeleteTempMotivoDesplazamientoComis);
  }

  @Override
  public int createTempMotivoDesplazamientoComis() {
    return this.jdbcTemplate.update(this.sqlCreateTempMotivoDesplazamientoComis);
  }

  @Override
  public void insertTempMotivoDesplazamientoComis(final List<IdMotivoDesplazamientoDto> listado) {
    for (final List<IdMotivoDesplazamientoDto> iter : StreamUtils.partition(listado, this.batchSize)) {
      this.jdbcTemplate.batchUpdate(this.sqlInsertTempMotivoDesplazamientoComis,
          new BatchPreparedStatementSetter() {
            @Override
            public void setValues(final PreparedStatement ps, final int i) throws SQLException {
              final IdMotivoDesplazamientoDto el = iter.get(i);
              ps.setInt(1, el.getIdMotivoDesplazamiento());
            }

            @Override
            public int getBatchSize() {
              return iter.size();
            }
          });
    }
  }

  @Override
  public List<IdMotivoDesplazamientoDto> validateTempMotivoDesplazamiento() {
    return this.jdbcTemplate.query(this.sqlValidateTempMotivoDesplazamiento,
        new RowMapper<IdMotivoDesplazamientoDto>() {

          @Override
          public IdMotivoDesplazamientoDto mapRow(final ResultSet rs, final int rowNum) throws SQLException {
            final IdMotivoDesplazamientoDto idMotivoDesplazamiento = new IdMotivoDesplazamientoDto();
            idMotivoDesplazamiento.setIdMotivoDesplazamiento(
                rs.getInt(SqlComisConstants.SQL_RESULT_ID_MOTIVO_DESPLAZAMIENTO));
            return idMotivoDesplazamiento;
          }
        });
  }

  @Override
  public int deleteTempMotivoDesplazamientoMeta4() {
    return this.jdbcTemplate.update(this.sqlDeleteTempMotivoDesplazamientoMeta4);
  }

  @Override
  public int createTempMotivoDesplazamientoMeta4() {
    return this.jdbcTemplate.update(this.sqlCreateTempMotivoDesplazamientoMeta4);
  }

  @Override
  public void insertTempMotivoDesplazamientoMeta4(final List<IdMotivoDesplazamientoDto> listado) {
    for (final List<IdMotivoDesplazamientoDto> iter : StreamUtils.partition(listado, this.batchSize)) {
      this.jdbcTemplate.batchUpdate(this.sqlInsertTempMotivoDesplazamientoMeta4,
          new BatchPreparedStatementSetter() {
            @Override
            public void setValues(final PreparedStatement ps, final int i) throws SQLException {
              final IdMotivoDesplazamientoDto el = iter.get(i);
              ps.setInt(1, el.getIdMotivoDesplazamiento());
            }

            @Override
            public int getBatchSize() {
              return iter.size();
            }
          });
    }
  }

  @Override
  public int createTempComisHistorico() {
    return this.jdbcTemplate.update(this.sqlCreateTempComisHistorico);
  }

  @Override
  public int deleteTempComisHistorico() {
    return this.jdbcTemplate.update(this.sqlDeleteTempComisHistorico);
  }

  @Override
  public void insertTempComisHistorico(final List<IdPersonaLocalCondicionesDto> listado) {
    for (final List<IdPersonaLocalCondicionesDto> iter : StreamUtils.partition(listado, this.batchSize)) {
      this.jdbcTemplate.batchUpdate(this.sqlInsertTempComisHistorico,
          new BatchPreparedStatementSetter() {
            @Override
            public void setValues(final PreparedStatement ps, final int i) throws SQLException {
              final IdPersonaLocalCondicionesDto el = iter.get(i);
              ps.setString(1, el.getIdPersonaLocal());
              ps.setDate(2, new Date(TimeUtils.toDate(el.getFechaDesde()).getTime()));
              ps.setDate(3, new Date(TimeUtils.toDate(el.getFechaHasta()).getTime()));
              ps.setString(4, el.getIdTipoCalculo());
              ps.setString(5, el.getPorcentaje());
              ps.setString(6, el.getBanda());
              ps.setString(7, el.getImporte());
              ps.setString(8, el.getCclIdSeccion());
            }

            @Override
            public int getBatchSize() {
              return iter.size();
            }
          });
    }
  }

  @Override
  public void mergeDateRangesTempComisHistorico(final TareaDto tarea) {
    final MapSqlParameterSource map = new MapSqlParameterSource();
    // Se amplia dos dias para no descartar tramos que acaben en el penultimo o ultimo dia del mes
    final LocalDate fechaHasta = RunUtils.addDays(tarea.getFechaFinPeriodo(), 2);
    map.addValue(SqlComisConstants.SQL_PARAM_FECHA_HASTA, TimeUtils.toDate(fechaHasta));
    map.addValue(SqlComisConstants.SQL_PARAM_ID_TAREA, tarea.getId());

    this.namedParameterJdbcTemplate.update(this.sqlMergeDateRangesTempComisHistorico, map);
  }

  @Override
  public void mergeDateRangesSeccionNotEqualsTempComisHistorico(final TareaDto tarea) {
    final MapSqlParameterSource map = new MapSqlParameterSource();
    map.addValue(SqlComisConstants.SQL_PARAM_ID_TAREA, tarea.getId());

    this.namedParameterJdbcTemplate.update(this.sqlMergeDateRangesSeccionNotEqualsTempComisHistorico, map);
  }

  @Override
  public List<IdPersonaLocalDto> validateTempComisHistorico(final TareaDto tarea) {
    final MapSqlParameterSource map = new MapSqlParameterSource();
    map.addValue(SqlComisConstants.SQL_PARAM_ID_TAREA, tarea.getId());

    return this.namedParameterJdbcTemplate.query(this.sqlValidateTempComisHistorico, map,
        (rs, rowNum) -> {
          final IdPersonaLocalDto idPersonaLocalDto = new IdPersonaLocalDto();
          idPersonaLocalDto
              .setIdPersonaLocal((rs.getString(SqlComisConstants.SQL_RESULT_CCL_ID_PERSON)));
          return idPersonaLocalDto;
        });
  }

  @Override
  public int createTempComisDesplazamiento() {
    return this.jdbcTemplate.update(this.sqlCreateTempComisDesplazamiento);
  }

  @Override
  public int deleteTempComisDesplazamiento() {
    return this.jdbcTemplate.update(this.sqlDeleteTempComisDesplazamiento);
  }

  @Override
  public void insertTempComisDesplazamiento(final List<IdPersonaLocalCondicionesDto> listado) {
    for (final List<IdPersonaLocalCondicionesDto> iter : StreamUtils.partition(listado, this.batchSize)) {
      this.jdbcTemplate.batchUpdate(this.sqlInsertTempComisDesplazamiento,
          new BatchPreparedStatementSetter() {
            @Override
            public void setValues(final PreparedStatement ps, final int i) throws SQLException {
              final IdPersonaLocalCondicionesDto el = iter.get(i);
              ps.setString(1, el.getIdPersonaLocal());
              ps.setDate(2, new Date(TimeUtils.toDate(el.getFechaDesde()).getTime()));
              ps.setDate(3, new Date(TimeUtils.toDate(el.getFechaHasta()).getTime()));
              ps.setString(4, el.getCclIdCodOrigenDestino());
              ps.setString(5, el.getIdTipoCalculo());
              ps.setString(6, el.getIdTipoOpcionCalculo());
              ps.setString(7, el.getPorcentaje());
              ps.setString(8, el.getBanda());
              ps.setString(9, el.getImporte());
              ps.setString(10, el.getCclIdSeccion());
              ps.setString(11, el.getCclIdSeccionDestino());
              ps.setInt(12, el.getEsIncluirTotalCondiciones() ? 1 : 0);
            }

            @Override
            public int getBatchSize() {
              return iter.size();
            }
          });
    }
  }

  @Override
  public List<IdPersonaLocalDto> validateTempComisDesplazamiento(final TareaDto tarea) {
    final MapSqlParameterSource map = new MapSqlParameterSource();
    map.addValue(SqlComisConstants.SQL_PARAM_ID_TAREA, tarea.getId());

    return this.namedParameterJdbcTemplate.query(this.sqlValidateTempComisDesplazamiento, map,
        (rs, rowNum) -> {
          final IdPersonaLocalDto idPersonaLocalCondicionesDto = new IdPersonaLocalDto();
          idPersonaLocalCondicionesDto
              .setIdPersonaLocal((rs.getString(SqlComisConstants.SQL_RESULT_CCL_ID_PERSON)));
          return idPersonaLocalCondicionesDto;
        });
  }

  @Override
  public int desactivaFechasSolapadas() {
    return this.jdbcTemplate.update(this.sqlDesactivaFechasSolapadas);
  }

  @Override
  public void reactivaFechasSolapadas(final TareaDto tarea) {
    final MapSqlParameterSource map = new MapSqlParameterSource();
    map.addValue(SqlComisConstants.SQL_PARAM_FECHA_HASTA, TimeUtils.toDate(tarea.getFechaFinPeriodo()));
    map.addValue(SqlComisConstants.SQL_PARAM_FECHA_DESDE, TimeUtils.toDate(tarea.getFechaInicioPeriodo()));

    this.namedParameterJdbcTemplate.update(this.sqlReactivaFechasSolapadas, map);
  }

  @Override
  public int createTempComisResalta() {
    return this.jdbcTemplate.update(this.sqlCreateTempComisResalta);
  }

  @Override
  public int deleteTempComisResalta() {
    return this.jdbcTemplate.update(this.sqlDeleteTempComisResalta);
  }

  @Override
  public void insertTempComisResalta(final List<IdPersonaLocalCondicionesDto> listado) {
    for (final List<IdPersonaLocalCondicionesDto> iter : StreamUtils.partition(listado, this.batchSize)) {
      this.jdbcTemplate.batchUpdate(this.sqlInsertTempComisResalta,
          new BatchPreparedStatementSetter() {
            @Override
            public void setValues(final PreparedStatement ps, final int i) throws SQLException {
              final IdPersonaLocalCondicionesDto el = iter.get(i);
              ps.setString(1, el.getIdPersonaLocal());
              ps.setDate(2, new Date(TimeUtils.toDate(el.getFechaDesde()).getTime()));
              ps.setDate(3, new Date(TimeUtils.toDate(el.getFechaHasta()).getTime()));
              ps.setString(4, el.getIdTipoCalculo());
              ps.setString(5, el.getPorcentaje());
              ps.setString(6, el.getBanda());
              ps.setString(7, el.getImporte());
              ps.setString(8, el.getCclIdSeccion());
            }

            @Override
            public int getBatchSize() {
              return iter.size();
            }
          });
    }
  }

  @Override
  public List<IdPersonaLocalDto> validateTempComisResalta(final TareaDto tarea) {
    final MapSqlParameterSource map = new MapSqlParameterSource();
    map.addValue(SqlComisConstants.SQL_PARAM_ID_TAREA, tarea.getId());

    return this.namedParameterJdbcTemplate.query(this.sqlValidateTempComisResalta, map,
        (rs, rowMap) -> {
          final IdPersonaLocalDto idPersonaLocalDto = new IdPersonaLocalDto();
          idPersonaLocalDto
              .setIdPersonaLocal((rs.getString(SqlComisConstants.SQL_RESULT_CCL_ID_PERSON)));
          return idPersonaLocalDto;
        });
  }

  @Override
  public int createTempComisBajaIt() {
    return this.jdbcTemplate.update(this.sqlCreateTempComisBajaIt);
  }

  @Override
  public int deleteTempComisBajaIt() {
    return this.jdbcTemplate.update(this.sqlDeleteTempComisBajaIt);
  }

  @Override
  public void insertTempComisBajaIt(final List<IdPersonaLocalCondicionesDto> listado) {
    for (final List<IdPersonaLocalCondicionesDto> iter : StreamUtils.partition(listado, this.batchSize)) {
      this.jdbcTemplate.batchUpdate(this.sqlInsertTempComisBajaIt,
          new BatchPreparedStatementSetter() {
            @Override
            public void setValues(final PreparedStatement ps, final int i) throws SQLException {
              final IdPersonaLocalCondicionesDto el = iter.get(i);
              ps.setString(1, el.getIdPersonaLocal());
              ps.setDate(2, new Date(TimeUtils.toDate(el.getFechaDesde()).getTime()));
              ps.setDate(3, new Date(TimeUtils.toDate(el.getFechaHasta()).getTime()));
              ps.setString(4, el.getPorcentaje());
            }

            @Override
            public int getBatchSize() {
              return iter.size();
            }
          });
    }
  }

  @Override
  public List<IdPersonaLocalDto> validateTempComisBajaIt(
      @NotNull final TareaDto tarea) {
    final MapSqlParameterSource params = new MapSqlParameterSource();
    params.addValue(SqlComisConstants.SQL_PARAM_ID_TAREA, tarea.getId());

    return this.namedParameterJdbcTemplate.query(this.sqlValidateTempComisBajaIt, params,
        (rs, rowNum) -> {
          final IdPersonaLocalDto idPersonaLocalDto = new IdPersonaLocalDto();
          idPersonaLocalDto
              .setIdPersonaLocal((rs.getString(SqlComisConstants.SQL_RESULT_CCL_ID_PERSON)));
          return idPersonaLocalDto;
        });
  }

  @Override
  public int createTempComisCarencia() {
    return this.jdbcTemplate.update(this.sqlCreateTempComisCarencia);
  }

  @Override
  public int deleteTempComisCarencia() {
    return this.jdbcTemplate.update(this.sqlDeleteTempComisCarencia);
  }

  @Override
  public void insertTempComisCarencia(final List<IdPersonaLocalCarenciaDto> listado) {
    for (final List<IdPersonaLocalCarenciaDto> iter : StreamUtils.partition(listado, this.batchSize)) {
      this.jdbcTemplate.batchUpdate(this.sqlInsertTempComisCarencia,
          new BatchPreparedStatementSetter() {
            @Override
            public void setValues(final PreparedStatement ps, final int i) throws SQLException {
              final IdPersonaLocalCarenciaDto el = iter.get(i);
              ps.setString(1, el.getIdPersonaLocal());
              ps.setDate(2, new Date(TimeUtils.toDate(el.getFechaAlta()).getTime()));
              ps.setDate(3, new Date(TimeUtils.toDate(el.getFechaInicioCalculo()).getTime()));
              ps.setString(4, el.getCclIdCodOrigen());
            }

            @Override
            public int getBatchSize() {
              return iter.size();
            }
          });
    }
  }

  @Override
  public List<IdPersonaLocalDto> validateTempComisCarencia(@NotNull final TareaDto tarea) {
    final MapSqlParameterSource params = new MapSqlParameterSource();
    params.addValue(SqlComisConstants.SQL_PARAM_ID_TAREA, tarea.getId());

    return this.namedParameterJdbcTemplate.query(this.sqlValidateTempComisCarencia, params,
        (rs, rowNum) -> {
          final IdPersonaLocalDto idPersonaLocalCarenciaDto = new IdPersonaLocalDto();
          idPersonaLocalCarenciaDto
              .setIdPersonaLocal(rs.getString(SqlComisConstants.SQL_RESULT_CCL_ID_PERSON));
          return idPersonaLocalCarenciaDto;
        });
  }

  @Override
  public int deleteTempAlgoritmo() {
    return this.jdbcTemplate.update(this.sqlDeleteTempAlgoritmo);
  }

  @Override
  public int createTempAlgoritmo() {
    return this.jdbcTemplate.update(this.sqlCreateTempAlgoritmo);
  }

  @Override
  public int indexTempAlgoritmo() {
    return this.jdbcTemplate.update(this.sqlIndexTempAlgoritmo);
  }

  @Override
  public void insertTempAlgoritmo(@NotNull final List<GenericAlgoritmoPropertiesDto> algoritmoDto) {
    for (final List<GenericAlgoritmoPropertiesDto> iter : StreamUtils.partition(algoritmoDto, this.batchSize)) {
      this.jdbcTemplate.batchUpdate(this.sqlInsertTempComisAlgoritmo,
          new BatchPreparedStatementSetter() {
            @Override
            public void setValues(final PreparedStatement ps, final int i) throws SQLException {
              final GenericAlgoritmoPropertiesDto el = iter.get(i);
              ps.setString(1, el.getIdTipoCalculo());
              ps.setString(2, el.getIdTipoComision());
            }

            @Override
            public int getBatchSize() {
              return iter.size();
            }
          });
    }
  }

  @Override
  public int deleteTempEstructura() {
    return this.jdbcTemplate.update(this.sqlDeleteTempEstructura);
  }

  @Override
  public int createTempEstructura() {
    return this.jdbcTemplate.update(this.sqlCreateTempEstructura);
  }

  @Override
  public int indexTempEstructura() {
    return this.jdbcTemplate.update(this.sqlIndexTempEstructura);
  }

  @Override
  public void insertTempEstructura(@NotNull final TareaDto tareaDto) {
    final MapSqlParameterSource map = new MapSqlParameterSource();
    map.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tareaDto.getId());
    map.addValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);

    this.namedParameterJdbcTemplate.update(this.sqlInsertTempEstructura, map);
  }

  @Override
  public int deleteTempPersonas() {
    return this.jdbcTemplate.update(this.sqlDeleteTempPersonas);
  }

  @Override
  public int createTempPersonas() {
    return this.jdbcTemplate.update(this.sqlCreateTempPersonas);
  }

  @Override
  public int indexTempPersonas() {
    return this.jdbcTemplate.update(this.sqlIndexTempPersonas);
  }

  @Override
  public void insertTempPersonas() {
    final MapSqlParameterSource map = new MapSqlParameterSource();
    this.namedParameterJdbcTemplate.update(this.sqlInsertTempPersonas, map);
  }

  @Override
  public int deleteTempPresupuestos() {
    return this.jdbcTemplate.update(this.sqlDeleteTempPresupuestos);
  }

  @Override
  public int createTempPresupuestos() {
    return this.jdbcTemplate.update(this.sqlCreateTempPresupuestos);
  }

  @Override
  public int indexTempPresupuestos() {
    return this.jdbcTemplate.update(this.sqlIndexTempPresupuestos);
  }

  @Override
  public void insertTempPresupuestos(@NotNull final TareaDto tareaDto) {
    final MapSqlParameterSource map = new MapSqlParameterSource();
    map.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tareaDto.getId());
    map.addValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);

    this.namedParameterJdbcTemplate.update(this.sqlInsertTempPresupuestos, map);
  }

  @Override
  public void insertTareaLocalizacionPresupuestoTareaPersonaEstructura(@NotNull final TareaDto tareaDto) {
    final MapSqlParameterSource map = new MapSqlParameterSource();
    map.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_CALCULO,
        Arrays.asList(TipoCalculoEnum.CHALLENGE_JORNADA.getId(), TipoCalculoEnum.CHALLENGE_DIRECTO_VENTA.getId()));
    map.addValue(SqlPrimaryConstants.SQL_PARAM_IDS_TIPOS_CALCULO_CHALLENGE_LOCALIZACION,
        Arrays.asList(TipoCalculoEnum.CHALLENGE_PRECIO_HORA_TIENDA.getId(),
            TipoCalculoEnum.CHALLENGE_IMPORTE_TIENDA.getId(),
            TipoCalculoEnum.CHALLENGE_PORCENTAJE.getId(),
            TipoCalculoEnum.CHALLENGE_JORNADA.getId()),
        TipoCalculoEnum.CHALLENGE_DIRECTO_VENTA.getId());

    this.namedParameterJdbcTemplate.update(this.sqlInsertTareaLocalizacionPresupuestoTareaPersonaEstructura, map);
  }

  @Override
  public void mergeDateRangesTempComisResalta(final TareaDto tarea) {
    final MapSqlParameterSource map = new MapSqlParameterSource();
    map.addValue(SqlComisConstants.SQL_PARAM_FECHA_HASTA, TimeUtils.toDate(tarea.getFechaFinPeriodo()));
    map.addValue(SqlComisConstants.SQL_PARAM_ID_TAREA, tarea.getId());

    this.namedParameterJdbcTemplate.update(this.sqlMergeDateRangesTempComisResalta, map);
  }

  @Override
  public void mergeDateRangesSeccionNotEqualsTempComisResalta(final TareaDto tarea) {
    final MapSqlParameterSource map = new MapSqlParameterSource();
    map.addValue(SqlComisConstants.SQL_PARAM_FECHA_HASTA, TimeUtils.toDate(tarea.getFechaFinPeriodo()));
    map.addValue(SqlComisConstants.SQL_PARAM_ID_TAREA, tarea.getId());

    this.namedParameterJdbcTemplate.update(this.sqlMergeDateRangesSeccionNotEqualsTempComisResalta, map);
  }

  @Override
  public int createTempComisPrimas() {
    return this.jdbcTemplate.update(this.sqlCreateTempComisPrimas);
  }

  @Override
  public int deleteTempComisPrimas() {
    return this.jdbcTemplate.update(this.sqlDeleteTempComisPrimas);
  }

  @Override
  public void insertTempComisPrimas(
      final List<IdPersonaLocalCondicionesDto> listado) {
    for (final List<IdPersonaLocalCondicionesDto> iter : StreamUtils.partition(listado, this.batchSize)) {
      this.jdbcTemplate.batchUpdate(this.sqlInsertTempComisPrimas,
          new BatchPreparedStatementSetter() {
            @Override
            public void setValues(final PreparedStatement ps, final int i) throws SQLException {
              final IdPersonaLocalCondicionesDto el = iter.get(i);
              ps.setString(1, el.getIdPersonaLocal());
              ps.setDate(2, new Date(TimeUtils.toDate(el.getFechaDesde()).getTime()));
              ps.setDate(3, new Date(TimeUtils.toDate(el.getFechaHasta()).getTime()));
              ps.setString(4, el.getIdTipoCalculo());
              ps.setString(5, el.getPorcentaje());
              ps.setString(6, el.getBanda());
              ps.setString(7, el.getImporte());
              ps.setString(8, el.getCclIdSeccion());
            }

            @Override
            public int getBatchSize() {
              return iter.size();
            }
          });
    }
  }

  @Override
  public void mergeDateRangesSeccionNotEqualsTempComisPrimas(final TareaDto tarea) {
    final MapSqlParameterSource map = new MapSqlParameterSource();
    map.addValue(SqlComisConstants.SQL_PARAM_FECHA_HASTA, TimeUtils.toDate(tarea.getFechaFinPeriodo()));
    map.addValue(SqlComisConstants.SQL_PARAM_ID_TAREA, tarea.getId());

    this.namedParameterJdbcTemplate.update(this.sqlMergeDateRangesSeccionNotEqualsTempComisPrimas, map);
  }

  @Override
  public void mergeDateRangesTempComisPrimas(final TareaDto tarea) {
    final MapSqlParameterSource map = new MapSqlParameterSource();
    map.addValue(SqlComisConstants.SQL_PARAM_FECHA_HASTA, TimeUtils.toDate(tarea.getFechaFinPeriodo()));
    map.addValue(SqlComisConstants.SQL_PARAM_ID_TAREA, tarea.getId());

    this.namedParameterJdbcTemplate.update(this.sqlMergeDateRangesTempComisPrimas, map);
  }

  @Override
  public List<IdPersonaLocalDto> validateTempComisPrimas(final TareaDto tarea) {
    final MapSqlParameterSource map = new MapSqlParameterSource();
    map.addValue(SqlComisConstants.SQL_PARAM_ID_TAREA, tarea.getId());

    return this.namedParameterJdbcTemplate.query(this.sqlValidateTempComisPrimas, map,
        (rs, rowMap) -> {
          final IdPersonaLocalDto idPersonaLocalDto = new IdPersonaLocalDto();
          idPersonaLocalDto
              .setIdPersonaLocal((rs.getString(SqlComisConstants.SQL_RESULT_CCL_ID_PERSON)));
          return idPersonaLocalDto;
        });
  }

  @Override
  public int createTempCalculoPorComision() {
    return this.jdbcTemplate.update(this.sqlCreateTempCalculoPorComision);
  }

  @Override
  public int deleteTempCalculoPorComision() {
    return this.jdbcTemplate.update(this.sqlDeleteTempCalculoPorComision);
  }

  @Override
  public void mergeCalculoTempCalculoPorComision(final TareaDto tarea) {

    final MapSqlParameterSource params = new MapSqlParameterSource();
    params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tarea.getId());
    params.addValue(SqlPrimaryConstants.SQL_PARAM_INACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE);
    params.addValue(SqlPrimaryConstants.SQL_PARAM_IMPORTE, SqlPrimaryConstants.SQL_VALUE_IMPORTE_CERO);

    this.namedParameterJdbcTemplate.update(this.sqlMergeCalculoTempCalculoPorComision, params);
  }

  @Override
  public void mergeCalculoTempCalculoSinComision(final TareaDto tarea) {
    final MapSqlParameterSource params = new MapSqlParameterSource();
    params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tarea.getId());
    params.addValue(SqlPrimaryConstants.SQL_PARAM_INACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE);
    params.addValue(SqlPrimaryConstants.SQL_PARAM_IMPORTE, SqlPrimaryConstants.SQL_VALUE_IMPORTE_CERO);

    this.namedParameterJdbcTemplate.update(this.sqlMergeCalculoTempCalculoSinComision, params);
  }

  @Override
  public int createTempCalculoAjusteTotalizado() {
    return this.jdbcTemplate.update(this.sqlCreateTempCalculoAjusteTotalizado);
  }

  @Override
  public int deleteTempCalculoAjusteTotalizado() {
    return this.jdbcTemplate.update(this.sqlDeleteTempCalculoAjusteTotalizado);
  }

  @Override
  public void mergeCalculoTempCalculoAjusteTotalizado(final TareaDto tarea) {
    final MapSqlParameterSource params = new MapSqlParameterSource();
    params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tarea.getId());
    params.addValue(SqlPrimaryConstants.SQL_PARAM_IMPORTE, SqlPrimaryConstants.SQL_VALUE_IMPORTE_CERO);
    this.namedParameterJdbcTemplate.update(this.sqlMergeCalculoAjusteTotalizado, params);
  }

  @Override
  public int deleteTempMejorOpcion() {
    return this.jdbcTemplate.update(this.sqlDeleteTempMejorOpcion);
  }

  @Override
  public int createTempMejorOpcion() {
    return this.jdbcTemplate.update(this.sqlCreateTempMejorOpcion);
  }

  @Override
  public int indexTempMejorOpcion() {
    return this.jdbcTemplate.update(this.sqlIndexTempMejorOpcion);
  }

  @Override
  public void insertTempMejorOpcion(final TareaDto tarea) {
    final MapSqlParameterSource map = new MapSqlParameterSource();
    map.addValue(SqlComisConstants.SQL_PARAM_ID_TAREA, tarea.getId());

    this.namedParameterJdbcTemplate.update(this.sqlInsertTempMejorOpcion, map);
  }

  @Override
  public int deleteTempMejorOpcionSinFechas() {
    return this.jdbcTemplate.update(this.sqlDeleteTempMejorOpcionSinFechas);
  }

  @Override
  public int createTempMejorOpcionSinFechas() {
    return this.jdbcTemplate.update(this.sqlCreateTempMejorOpcionSinFechas);
  }

  @Override
  public int indexTempMejorOpcionSinFechas() {
    return this.jdbcTemplate.update(this.sqlIndexTempMejorOpcionSinFechas);
  }

  @Override
  public void insertTempMejorOpcionSinFechas(final TareaDto tarea) {
    final MapSqlParameterSource map = new MapSqlParameterSource();
    map.addValue(SqlComisConstants.SQL_PARAM_ID_TAREA, tarea.getId());

    this.namedParameterJdbcTemplate.update(this.sqlInsertTempMejorOpcionSinFechas, map);
  }

  @Override
  public int deleteTempMejorOpcionSinFechasTodoPeriodo() {
    return this.jdbcTemplate.update(this.sqlDeleteTempMejorOpcionSinFechasTodoPeriodo);
  }

  @Override
  public int createTempMejorOpcionSinFechasTodoPeriodo() {
    return this.jdbcTemplate.update(this.sqlCreateTempMejorOpcionSinFechasTodoPeriodo);
  }

  @Override
  public int indexTempMejorOpcionSinFechasTodoPeriodo() {
    return this.jdbcTemplate.update(this.sqlIndexTempMejorOpcionSinFechasTodoPeriodo);
  }

  @Override
  public void insertTempMejorOpcionSinFechasTodoPeriodo(final TareaDto tarea) {
    final MapSqlParameterSource map = new MapSqlParameterSource();
    map.addValue(SqlComisConstants.SQL_PARAM_FECHA_INICIO_PERIODO, TimeUtils.toDate(tarea.getFechaInicioPeriodo()));
    map.addValue(SqlComisConstants.SQL_PARAM_ID_TAREA, tarea.getId());

    this.namedParameterJdbcTemplate.update(this.sqlInsertTempMejorOpcionSinFechasTodoPeriodo, map);
  }

  @Override
  public int createTempBandasOrigenSinBandaDesplazamiento() {
    return this.jdbcTemplate.update(this.sqlCreateTempBandasOrigenSinBandaDesplazamiento);
  }

  @Override
  public void insertBandasOrigenSinBandaDesplazamiento(final TareaDto tarea) {
    final MapSqlParameterSource map = new MapSqlParameterSource();
    map.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tarea.getId());
    map.addValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
    map.addValue(SqlPrimaryConstants.SQL_PARAM_INACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE);
    map.addValue(SqlPrimaryConstants.SQL_PARAM_IDS_TIPOS_COMISION, AppConstants.getTIPOS_COMISION_CHALLENGE());
    map.addValue(SqlPrimaryConstants.SQL_PARAM_IDS_TIPOS_CALCULO, AppConstants.getTIPOS_CALCULO_CHALLENGE());
    this.namedParameterJdbcTemplate.update(this.sqlInsertBandasOrigenSinBandaDesplazamiento, map);
  }

  @Override
  public int deleteTempBandasOrigenSinBandaDesplazamiento() {
    return this.jdbcTemplate.update(this.sqlDeleteTempBandasOrigenSinBandaDesplazamiento);
  }

  @Override
  public int deleteTempEstructurasBaseChallenge() {
    return this.jdbcTemplate.update(this.sqlDeleteTempEstructurasBaseChallenge);
  }

  @Override
  public int createTempEstructurasBaseChallenge() {
    return this.jdbcTemplate.update(this.sqlCreateTempEstructurasBaseChallenge);
  }

  @Override
  public int indexTempEstructurasBaseChallenge() {
    return this.jdbcTemplate.update(this.sqlIndexTempEstructurasBaseChallenge);
  }

  @Override
  public void insertTempEstructurasBaseChallenge(final TareaDto tarea) {
    final MapSqlParameterSource map = new MapSqlParameterSource();
    map.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tarea.getId());
    map.addValue(SqlPrimaryConstants.SQL_PARAM_IDS_TIPOS_COMISION, AppConstants.getTIPOS_COMISION_CHALLENGE());
    map.addValue(SqlPrimaryConstants.SQL_PARAM_IDS_TIPOS_CALCULO, AppConstants.getTIPOS_CALCULO_CHALLENGE());
    map.addValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
    this.namedParameterJdbcTemplate.update(this.sqlInsertTempEstructurasBaseChallenge, map);
  }

  @Override
  public int deleteTempEstructurasDesplazamientoNoChallenge() {
    return this.jdbcTemplate.update(this.sqlDeleteTempEstructurasDesplazamientoNoChallenge);
  }

  @Override
  public int createTempEstructurasDesplazamientoNoChallenge() {
    return this.jdbcTemplate.update(this.sqlCreateTempEstructurasDesplazamientoNoChallenge);
  }

  @Override
  public int indexTempEstructurasDesplazamientoNoChallenge() {
    return this.jdbcTemplate.update(this.sqlIndexTempEstructurasDesplazamientoNoChallenge);
  }

  @Override
  public void insertTempEstructurasDesplazamientoNoChallenge(final TareaDto tarea) {
    final MapSqlParameterSource map = new MapSqlParameterSource();
    map.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tarea.getId());
    map.addValue(SqlPrimaryConstants.SQL_PARAM_IDS_TIPOS_COMISION, AppConstants.getTIPOS_COMISION_CHALLENGE());
    map.addValue(SqlPrimaryConstants.SQL_PARAM_IDS_TIPOS_CALCULO, AppConstants.getTIPOS_CALCULO_CHALLENGE());
    map.addValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
    map.addValue(SqlPrimaryConstants.SQL_PARAM_INACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_FALSE);
    this.namedParameterJdbcTemplate.update(this.sqlInsertTempEstructurasDesplazamientoNoChallenge, map);
  }

  @Override
  public int deleteTempComisComisionManual() {
    return this.jdbcTemplate.update(this.sqlDeleteTempComisComisionManual);
  }

  @Override
  public int createTempComisComisionManual() {
    return this.jdbcTemplate.update(this.sqlCreateTempComisComisionManual);
  }

  @Override
  public int indexTempComisComisionManual() {
    return this.jdbcTemplate.update(this.sqlIndexTempComisComisionManual);
  }

  @Override
  public void insertTempComisComisionManual(final List<IdPersonaLocalComisionManualDto> comisiones) {
    for (final List<IdPersonaLocalComisionManualDto> iter : StreamUtils.partition(comisiones, this.batchSize)) {
      this.jdbcTemplate.batchUpdate(this.sqlInsertTempComisComisionManual, new BatchPreparedStatementSetter() {
        @Override
        public void setValues(final PreparedStatement ps, final int i) throws SQLException {
          final IdPersonaLocalComisionManualDto idPersonaLocalComisionManualDto = iter.get(i);
          ps.setString(1, idPersonaLocalComisionManualDto.getIdPersonaLocal());
          ps.setInt(2, Integer.parseInt(idPersonaLocalComisionManualDto.getGrupoManual()));
          ps.setString(3, idPersonaLocalComisionManualDto.getTipoComision());
          ps.setString(4, idPersonaLocalComisionManualDto.getImporte());
        }

        @Override
        public int getBatchSize() {
          return iter.size();
        }
      });
    }
  }

  @Override
  public List<IdPersonaLocalDto> validateTempComisComisionManual(final TareaDto tarea) {
    final MapSqlParameterSource map = new MapSqlParameterSource();
    map.addValue(SqlComisConstants.SQL_PARAM_ID_TAREA, tarea.getId());

    return this.namedParameterJdbcTemplate.query(this.sqlValidateTempComisComisionManual, map,
        (rs, i) -> IdPersonaLocalDto.builder().idPersonaLocal(rs.getString(SqlComisConstants.SQL_RESULT_CCL_ID_PERSON)).build());
  }

  @Override
  public int deleteTempComisPersonasLocalizaciones() {
    return this.jdbcTemplate.update(this.sqlDeleteTempComisPersonasLocalizaciones);
  }

  @Override
  public int createTempComisPersonasLocalizaciones() {
    return this.jdbcTemplate.update(this.sqlCreateTempComisPersonasLocalizaciones);
  }

  @Override
  public int indexTempComisPersonasLocalizaciones() {
    return this.jdbcTemplate.update(this.sqlIndexTempComisPersonasLocalizaciones);
  }

  @Override
  public void insertTempComisPersonasLocalizaciones(final List<IdPersonaLocalLocalizacionDto> personas) {
    for (final List<IdPersonaLocalLocalizacionDto> iter : StreamUtils.partition(personas, this.batchSize)) {
      this.jdbcTemplate.batchUpdate(this.sqlInsertTempComisPersonasLocalizaciones, new BatchPreparedStatementSetter() {
        @Override
        public void setValues(final PreparedStatement ps, final int i) throws SQLException {
          final IdPersonaLocalLocalizacionDto idPersonaLocalComisionManualDto = iter.get(i);
          ps.setString(1, idPersonaLocalComisionManualDto.getIdPersonaLocal());
          ps.setString(2, idPersonaLocalComisionManualDto.getCclIdCodOrigen());
        }

        @Override
        public int getBatchSize() {
          return iter.size();
        }
      });
    }
  }

  @Override
  public List<IdPersonaLocalDto> validateTempComisPersonas(final TareaDto tarea) {
    final MapSqlParameterSource map = new MapSqlParameterSource();
    map.addValue(SqlComisConstants.SQL_PARAM_ID_TAREA, tarea.getId());

    return this.namedParameterJdbcTemplate.query(this.sqlValidateTempComisPersonas, map,
        (rs, i) -> IdPersonaLocalDto.builder().idPersonaLocal(rs.getString(SqlComisConstants.SQL_RESULT_CCL_ID_PERSON)).build());
  }

  @Override
  public List<IdPersonaLocalDto> validateTempComisChallengePorcentaje(final TareaDto tarea) {
    final MapSqlParameterSource map = new MapSqlParameterSource();
    map.addValue(SqlComisConstants.SQL_PARAM_ID_TAREA, tarea.getId());

    return this.namedParameterJdbcTemplate.query(this.sqlValidateTempComisChallengePorcentaje, map,
        (rs, rowNum) -> {
          final IdPersonaLocalDto idPersonaLocalDto = new IdPersonaLocalDto();
          idPersonaLocalDto
              .setIdPersonaLocal((rs.getString(SqlComisConstants.SQL_RESULT_CCL_ID_PERSON)));
          return idPersonaLocalDto;
        });
  }

  @Override
  public List<IdPersonaLocalDto> validateTempComisDesplazamientoChallengePorcentaje(final TareaDto tarea) {
    final MapSqlParameterSource map = new MapSqlParameterSource();
    map.addValue(SqlComisConstants.SQL_PARAM_ID_TAREA, tarea.getId());

    return this.namedParameterJdbcTemplate.query(this.sqlValidateTempComisDesplazamientoChallengePorcentaje, map,
        (rs, rowNum) -> {
          final IdPersonaLocalDto idPersonaLocalCondicionesDto = new IdPersonaLocalDto();
          idPersonaLocalCondicionesDto
              .setIdPersonaLocal((rs.getString(SqlComisConstants.SQL_RESULT_CCL_ID_PERSON)));
          return idPersonaLocalCondicionesDto;
        });
  }

}
