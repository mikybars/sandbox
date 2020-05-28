package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
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

    @Value("${app.envars.repository.batch-size.tarea-localizacion-historico: 0}")
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
        return this.saveNamedJdbcBatchList(src, this.sqlSave, this.batchSize);
    }

    @Override
    public List<IdLocalizacionDto> findIdLocalizacionDtoByIdTareaAndCclIdOrigenAndTipoDatoInAmbito(
            @NotNull @Positive final Long idTarea, @NotBlank final String cclIdOrigen,
            @NotNull final List<Integer> idsTipoDato) {
        final MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, idTarea);
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_CCL_ID_ORIGEN, cclIdOrigen);
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_IDS_TIPOS_DATO, idsTipoDato);

        return this.query(
                this.sqlFindIdLocalizacionDtoByIdTareaAndIdOrigenAndTipoDatoInAmbito,
                parameters, new RowMapper<IdLocalizacionDto>() {
                    @Override
                    public IdLocalizacionDto mapRow(final ResultSet rs, final int rowNum) throws SQLException {
                        final IdLocalizacionDto dto = new IdLocalizacionDto();
                        dto.setId(rs.getString(SqlPrimaryConstants.SQL_RESULT_ID_LOCALIZACION_META4));
                        return dto;
                    }
                });
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
    public List<IdLocalizacionLocalDto> findIdLocalizacionLocalDtoByIdTareaAndCclIdOrigenAndTipoDatoInAmbito(
            @NotNull @Positive final Long idTarea, @NotBlank final String cclIdOrigen,
            @NotNull final List<Integer> idsTipoDato) {
        final MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, idTarea);
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_CCL_ID_ORIGEN, cclIdOrigen);
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_IDS_TIPOS_DATO, idsTipoDato);

        return this.query(
                this.sqlFindIdLocalizacionLocalDtoByIdTareaAndIdOrigenAndTipoDatoInAmbito,
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
    public List<IdCadenaDto> getCadenasByTareaAndOrigen(final Long idTarea, final String cclIdOrigen,
            final Long idVentaConcepto) {
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
    public List<IdCadenaDto> getCadenasByTareaAndOrigen(final Long idTarea, final String cclIdOrigen) {
        final MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, idTarea);
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_CCL_ID_ORIGEN, cclIdOrigen);
        return this.query(this.sqlCadenas, parameters, (rs, rowNum) -> IdCadenaDto.builder()
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
    public List<IdLocalizacionLocalPresupuestoDto> findIdLocalizacionLocalDtoPresupuestosByIdTarea(
            @NotNull @Positive final Long idTarea) {
        final MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, idTarea);
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_IDS_TIPOS_COMISION, Arrays
            .asList(TipoComisionEnum.CHALLENGE_PRINCIPAL.getId(), TipoComisionEnum.CHALLENGE_SECUNDARIO.getId()));
        return this.query(this.sqlFindIdLocalizacionPresupuestosByIdTarea, parameters,
                (rs, rowNum) -> IdLocalizacionLocalPresupuestoDto.builder()
                    .id(rs.getString(SqlPrimaryConstants.SQL_RESULT_ID_LOCALIZACION_LOCAL))
                    .idTipoPresupuesto(rs.getInt(SqlPrimaryConstants.SQL_RESULT_ID_TIPO_PRESUPUESTO))
                    .fechaInicio(rs.getDate(SqlPrimaryConstants.SQL_RESULT_FECHA_INICIO).toLocalDate())
                    .fechaFin(rs.getDate(SqlPrimaryConstants.SQL_RESULT_FECHA_FIN).toLocalDate())
                    .build());
    }

    @Override
    public List<IdLocalizacionLocalDto> findTiendasGrupoFechasByIdTarea(@NotNull @Positive final Long idTarea) {
        final MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, idTarea);
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO, SqlPrimaryConstants.SQL_VALUE_BOOLEAN_TRUE);
        return this.query(this.sqlFindIdLocalizacionGrupoFechasByIdTarea, parameters,
                (rs, rowNum) -> IdLocalizacionLocalDto.builder()
                    .id(rs.getString(SqlPrimaryConstants.SQL_RESULT_ID_LOCALIZACION_LOCAL))
                    .build());
    }

}
