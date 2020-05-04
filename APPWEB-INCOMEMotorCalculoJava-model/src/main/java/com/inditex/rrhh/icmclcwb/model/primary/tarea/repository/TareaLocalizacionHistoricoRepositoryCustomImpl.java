package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.inditex.rrhh.icmclcwb.api.app.calcular.TipoComisionEnum;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdCadenaDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdLocalizacionDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdLocalizacionLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdLocalizacionLocalPresupuestoDto;
import com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants;
import com.inditex.rrhh.icmclcwb.model.primary.repository.JdbcBatchPrimaryRepositoryAbstract;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLocalizacionHistorico;

@Repository
public class TareaLocalizacionHistoricoRepositoryCustomImpl
        extends JdbcBatchPrimaryRepositoryAbstract<TareaLocalizacionHistorico>
        implements TareaLocalizacionHistoricoRepositoryCustom {

    @Autowired
    @Qualifier("primaryNamedParameterJdbcTemplate")
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Value("${app.envars.repository.batch-size.tarea-localizacion-historico:${app.envars.repository.batch-size.default}}")
    private int batchSize;

    @Value("#{primaryQuery['TareaLocalizacionHistoricoRepositoryCustom.save']}")
    private String sqlSave;

    @Value("#{primaryQuery['TareaLocalizacionHistoricoRepositoryCustom.findIdLocalizacionDtoByIdTareaAndIdOrigenInAmbito']}")
    private String sqlFindIdLocalizacionDtoByIdTareaAndIdOrigenInAmbito;

    @Value("#{primaryQuery['TareaLocalizacionHistoricoRepositoryCustom.findIdLocalizacionLocalDtoByIdTareaAndIdOrigenInAmbito']}")
    private String sqlFindIdLocalizacionLocalDtoByIdTareaAndIdOrigenInAmbito;

    @Value("#{primaryQuery['TareaLocalizacionHistoricoRepositoryCustom.findIdLocalizacionDtoByIdTareaAndIdOrigenInAmbitoLocalizacion']}")
    private String sqlFindIdLocalizacionDtoByIdTareaAndIdOrigenInAmbitoLocalizacion;

    @Value("#{primaryQuery['TareaLocalizacionHistoricoRepositoryCustom.findIdLocalizacionLocalDtoByIdTareaAndIdOrigenInAmbitoLocalizacion']}")
    private String sqlFindIdLocalizacionLocalDtoByIdTareaAndIdOrigenInAmbitoLocalizacion;

    @Value("#{primaryQuery['TareaLocalizacionHistoricoRepositoryCustom.findIdLocalizacionDtoByIdTareaAndIdOrigenAndTipoDatoInAmbito']}")
    private String sqlFindIdLocalizacionDtoByIdTareaAndIdOrigenAndTipoDatoInAmbito;

    @Value("#{primaryQuery['TareaLocalizacionHistoricoRepositoryCustom.findIdLocalizacionLocalDtoByIdTareaAndIdOrigenAndTipoDatoInAmbito']}")
    private String sqlFindIdLocalizacionLocalDtoByIdTareaAndIdOrigenAndTipoDatoInAmbito;

    @Value("#{primaryQuery['TareaLocalizacionHistoricoRepositoryCustom.getCadenasByTareaAndOrigenAndTipoDato']}")
    private String sqlCadenasFiltroTipoDato;

    @Value("#{primaryQuery['TareaLocalizacionHistoricoRepositoryCustom.getCadenasByTareaAndOrigen']}")
    private String sqlCadenas;

    @Value("#{primaryQuery['TareaLocalizacionHistoricoRepositoryCustom.findIdLocalizacionByIdTareaAndCclIdPersonInAmbito']}")
    private String sqlFindIdLocalizacionByIdTareaAndCclIdPersonInAmbito;

    @Value("#{primaryQuery['TareaLocalizacionHistoricoRepositoryCustom.findIdLocalizacionPresupuestosByIdTarea']}")
    private String sqlFindIdLocalizacionPresupuestosByIdTarea;

    @Value("#{primaryQuery['TareaLocalizacionHistoricoRepositoryCustom.findIdLocalizacionGrupoFechasByIdTarea']}")
    private String sqlFindIdLocalizacionGrupoFechasByIdTarea;

    @Override
    public List<TareaLocalizacionHistorico> save(final List<TareaLocalizacionHistorico> src) {
        return saveJdbcBatchList(src, sqlSave, batchSize);
    }

    @Override
    public void setParameters(PreparedStatement pstmt, TareaLocalizacionHistorico entity) throws SQLException {
        pstmt.setObject(1, entity.getFechaFin());
        pstmt.setObject(2, entity.getFechaInicio());
        pstmt.setString(3, entity.getCclIdCadena());
        pstmt.setString(4, entity.getStdIdLegEnt());
        pstmt.setString(5, entity.getStdIdCountry());
        pstmt.setString(6, entity.getCclIdOrigen());
        pstmt.setString(7, entity.getCclIdCodOrigen());
        pstmt.setString(8, entity.getStdIdWorkLocat());
        pstmt.setLong(9, entity.getTarea().getId());
    }

    @Override
    public List<IdLocalizacionDto> findIdLocalizacionDtoByIdTareaAndCclIdOrigenAndTipoDatoInAmbito(
            @NotNull @Positive final Long idTarea, @NotBlank final String cclIdOrigen,
            @NotNull final List<Integer> idsTipoDato) {
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, idTarea);
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_CCL_ID_ORIGEN, cclIdOrigen);
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_IDS_TIPOS_DATO, idsTipoDato);

        return namedParameterJdbcTemplate.query(sqlFindIdLocalizacionDtoByIdTareaAndIdOrigenAndTipoDatoInAmbito,
                parameters, new RowMapper<IdLocalizacionDto>() {
                    public IdLocalizacionDto mapRow(ResultSet rs, int rowNum) throws SQLException {
                        IdLocalizacionDto dto = new IdLocalizacionDto();
                        dto.setId(rs.getString(SqlPrimaryConstants.SQL_RESULT_ID_LOCALIZACION_META4));
                        return dto;
                    }
                });
    }

    @Override
    public List<IdLocalizacionDto> findIdLocalizacionDtoByIdTareaAndCclIdOrigenInAmbito(
            @NotNull @Positive final Long idTarea, @NotBlank final String cclIdOrigen) {
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, idTarea);
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_CCL_ID_ORIGEN, cclIdOrigen);
        return namedParameterJdbcTemplate.query(sqlFindIdLocalizacionDtoByIdTareaAndIdOrigenInAmbito, parameters,
                new RowMapper<IdLocalizacionDto>() {
                    public IdLocalizacionDto mapRow(ResultSet rs, int rowNum) throws SQLException {
                        IdLocalizacionDto dto = new IdLocalizacionDto();
                        dto.setId(rs.getString(SqlPrimaryConstants.SQL_RESULT_ID_LOCALIZACION_META4));
                        return dto;
                    }
                });
    }

    @Override
    public List<IdLocalizacionDto> findIdLocalizacionDtoByIdTareaAndCclIdOrigenInAmbitoLocalizacion(
            @NotNull @Positive final Long idTarea, @NotBlank final String cclIdOrigen) {
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, idTarea);
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_CCL_ID_ORIGEN, cclIdOrigen);
        return namedParameterJdbcTemplate.query(sqlFindIdLocalizacionDtoByIdTareaAndIdOrigenInAmbitoLocalizacion,
                parameters,
                new RowMapper<IdLocalizacionDto>() {
                    public IdLocalizacionDto mapRow(ResultSet rs, int rowNum) throws SQLException {
                        IdLocalizacionDto dto = new IdLocalizacionDto();
                        dto.setId(rs.getString(SqlPrimaryConstants.SQL_RESULT_ID_LOCALIZACION_META4));
                        return dto;
                    }
                });
    }

    @Override
    public List<IdLocalizacionLocalDto> findIdLocalizacionLocalDtoByIdTareaAndCclIdOrigenInAmbito(
            @NotNull @Positive final Long idTarea, @NotBlank final String cclIdOrigen) {
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, idTarea);
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_CCL_ID_ORIGEN, cclIdOrigen);

        return namedParameterJdbcTemplate.query(sqlFindIdLocalizacionLocalDtoByIdTareaAndIdOrigenInAmbito, parameters,
                new RowMapper<IdLocalizacionLocalDto>() {
                    public IdLocalizacionLocalDto mapRow(ResultSet rs, int rowNum) throws SQLException {
                        IdLocalizacionLocalDto dto = new IdLocalizacionLocalDto();
                        dto.setId(rs.getString(SqlPrimaryConstants.SQL_RESULT_ID_LOCALIZACION_LOCAL));
                        return dto;
                    }
                });
    }

    @Override
    public List<IdLocalizacionLocalDto> findIdLocalizacionLocalDtoByIdTareaAndCclIdOrigenInAmbitoLocalizacion(
            @NotNull @Positive final Long idTarea, @NotBlank final String cclIdOrigen) {
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, idTarea);
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_CCL_ID_ORIGEN, cclIdOrigen);

        return namedParameterJdbcTemplate.query(sqlFindIdLocalizacionLocalDtoByIdTareaAndIdOrigenInAmbitoLocalizacion,
                parameters,
                new RowMapper<IdLocalizacionLocalDto>() {
                    public IdLocalizacionLocalDto mapRow(ResultSet rs, int rowNum) throws SQLException {
                        IdLocalizacionLocalDto dto = new IdLocalizacionLocalDto();
                        dto.setId(rs.getString(SqlPrimaryConstants.SQL_RESULT_ID_LOCALIZACION_LOCAL));
                        return dto;
                    }
                });
    }


    @Override
    public List<IdLocalizacionLocalDto> findIdLocalizacionLocalDtoByIdTareaAndCclIdOrigenAndTipoDatoInAmbito(
            @NotNull @Positive final Long idTarea, @NotBlank final String cclIdOrigen,
            @NotNull final List<Integer> idsTipoDato) {
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, idTarea);
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_CCL_ID_ORIGEN, cclIdOrigen);
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_IDS_TIPOS_DATO, idsTipoDato);

        return namedParameterJdbcTemplate.query(sqlFindIdLocalizacionLocalDtoByIdTareaAndIdOrigenAndTipoDatoInAmbito,
                parameters, new RowMapper<IdLocalizacionLocalDto>() {
                    public IdLocalizacionLocalDto mapRow(ResultSet rs, int rowNum) throws SQLException {
                        IdLocalizacionLocalDto dto = new IdLocalizacionLocalDto();
                        dto.setId(rs.getString(SqlPrimaryConstants.SQL_RESULT_ID_LOCALIZACION_LOCAL));
                        return dto;
                    }
                });
    }

    @Override
    public List<IdCadenaDto> getCadenasByTareaAndOrigen(Long idTarea, String cclIdOrigen, Long idVentaConcepto) {
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, idTarea);
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_CCL_ID_ORIGEN, cclIdOrigen);
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_CONCEPTO, idVentaConcepto);
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_PORCENTAJE_INCLUSION,
                SqlPrimaryConstants.SQL_VALUE_PORCENTAJE_CERO);
        return namedParameterJdbcTemplate.query(sqlCadenasFiltroTipoDato, parameters,
                (rs, rowNum) -> IdCadenaDto.builder()
                    .id(rs.getString(SqlPrimaryConstants.SQL_RESULT_ID_CADENA))
                    .build());
    }

    @Override
    public List<IdCadenaDto> getCadenasByTareaAndOrigen(Long idTarea, String cclIdOrigen) {
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, idTarea);
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_CCL_ID_ORIGEN, cclIdOrigen);
        return namedParameterJdbcTemplate.query(sqlCadenas, parameters, (rs, rowNum) -> IdCadenaDto.builder()
            .id(rs.getString(SqlPrimaryConstants.SQL_RESULT_ID_CADENA))
            .build());
    }

    @Override
    public List<IdLocalizacionLocalDto> findIdLocalizacionLocalDtoByIdTareaAndCclIdOrigenAndTipoCalculoInAmbitoLocalizacion(
            @NotNull @Positive Long idTarea, String cclCodOrigen, List<String> tiposCalculo) {
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, idTarea);
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_IDS_TIPOS_CALCULO, tiposCalculo);
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_CCL_ID_ORIGEN, cclCodOrigen);

        return namedParameterJdbcTemplate.query(sqlFindIdLocalizacionByIdTareaAndCclIdPersonInAmbito, parameters,
                (rs, rowNum) -> IdLocalizacionLocalDto.builder()
                    .id(rs.getString(SqlPrimaryConstants.SQL_RESULT_ID_LOCALIZACION_LOCAL))
                    .build());
    }

    @Override
    public List<IdLocalizacionLocalPresupuestoDto> findIdLocalizacionLocalDtoPresupuestosByIdTarea(
            @NotNull @Positive Long idTarea) {
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, idTarea);
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_IDS_TIPOS_COMISION, Arrays
            .asList(TipoComisionEnum.CHALLENGE_PRINCIPAL.getId(), TipoComisionEnum.CHALLENGE_SECUNDARIO.getId()));
        return namedParameterJdbcTemplate.query(sqlFindIdLocalizacionPresupuestosByIdTarea, parameters,
                (rs, rowNum) -> IdLocalizacionLocalPresupuestoDto.builder()
                    .id(rs.getString(SqlPrimaryConstants.SQL_RESULT_ID_LOCALIZACION_LOCAL))
                    .idTipoPresupuesto(rs.getInt(SqlPrimaryConstants.SQL_RESULT_ID_TIPO_PRESUPUESTO))
                    .fechaInicio(rs.getDate(SqlPrimaryConstants.SQL_RESULT_FECHA_INICIO).toLocalDate())
                    .fechaFin(rs.getDate(SqlPrimaryConstants.SQL_RESULT_FECHA_FIN).toLocalDate())
                    .build());
    }

    @Override
    public List<IdLocalizacionLocalDto> findTiendasGrupoFechasByIdTarea(@NotNull @Positive Long idTarea) {
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, idTarea);
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
        return namedParameterJdbcTemplate.query(sqlFindIdLocalizacionGrupoFechasByIdTarea, parameters,
                (rs, rowNum) -> IdLocalizacionLocalDto.builder()
                    .id(rs.getString(SqlPrimaryConstants.SQL_RESULT_ID_LOCALIZACION_LOCAL))
                    .build());
    }

}
