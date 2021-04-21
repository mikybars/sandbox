/**
 *
 */
package com.inditex.rrhh.icmclcwb.model.primary.repository;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.inditex.rrhh.icmclcwb.api.app.dto.IdMotivoDesplazamientoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalCarenciaDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalCondicionesDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.SqlComisConstants;
import com.inditex.rrhh.icmclcwb.model.app.util.StreamUtils;
import com.inditex.rrhh.icmclcwb.model.app.util.TimeUtils;

/**
 * @author mdelrio
 *
 */
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

    @Value("#{primaryQuery['PrimaryTemporaryTableRepositoryCustom.createTempComisResalta']}")
    private String sqlCreateTempComisResalta;

    @Value("#{primaryQuery['PrimaryTemporaryTableRepositoryCustom.deleteTempComisResalta']}")
    private String sqlDeleteTempComisResalta;

    @Value("#{primaryQuery['PrimaryTemporaryTableRepositoryCustom.insertTempComisResalta']}")
    private String sqlInsertTempComisResalta;

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
                            ps.setString(4, el.getCclIdCodOrigen());
                            ps.setString(5, el.getIdTipoCalculo());
                            ps.setString(6, el.getPorcentaje());
                            ps.setString(7, el.getBanda());
                            ps.setString(8, el.getImporte());
                            ps.setString(9, el.getCclIdSeccion());
                            ps.setString(10, el.getPuesto());
                            ps.setString(11, el.getSecciones());
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
        map.addValue(SqlComisConstants.SQL_PARAM_FECHA_HASTA, TimeUtils.toDate(tarea.getFechaFinPeriodo()));
        this.namedParameterJdbcTemplate.update(this.sqlMergeDateRangesTempComisHistorico, map);
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
                            ps.setString(4, el.getCclIdCodOrigen());
                            ps.setString(5, el.getCclIdCodOrigenDestino());
                            ps.setString(6, el.getIdTipoCalculo());
                            ps.setString(7, el.getIdTipoOpcionCalculo());
                            ps.setString(8, el.getPorcentaje());
                            ps.setString(9, el.getBanda());
                            ps.setString(10, el.getImporte());
                            ps.setString(11, el.getCclIdSeccion());
                            ps.setString(12, el.getCclIdSeccionDestino());
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
                            ps.setString(9, el.getCclIdCodOrigen());
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
                            ps.setString(5, el.getCclIdCodOrigen());
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

}
