/**
 *
 */
package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaFaseAccionDto;
import com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants;
import com.inditex.rrhh.icmclcwb.model.app.util.TimeUtils;
import com.inditex.rrhh.icmclcwb.model.primary.repository.JdbcBatchPrimaryRepositoryAbstract;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaFaseAccion;

/**
 * @author mdelrio
 *
 */
@Repository
public class TareaFaseAccionRepositoryCustomImpl
        extends JdbcBatchPrimaryRepositoryAbstract<TareaFaseAccion>
        implements TareaFaseAccionRepositoryCustom {

    @Value("${app.envars.repository.batch-size.tarea-fase-accion:0}")
    private int batchSize;

    @Value("#{primaryQuery['TareaFaseAccionRepositoryCustom.save']}")
    private String sqlSave;

    @Value("#{primaryQuery['TareaFaseAccionRepositoryCustom.findTareaFaseAccionDtoByIdTareaAndIdFaseAndIdPuntoEjecucion']}")
    private String sqlFindTareaFaseAccionDtoByIdTareaAndIdFaseAndIdPuntoEjecucion;

    @Value("#{primaryQuery['TareaFaseAccionRepositoryCustom.findValidacionPesoByIdTareaAndIdFaseAndIdPuntoEjecucion']}")
    private String sqlFindValidacionPesoByIdTareaAndIdFaseAndIdPuntoEjecucion;

    @Override
    public List<TareaFaseAccion> save(final List<TareaFaseAccion> src) {
        return this.saveNamedJdbcBatchList(src, this.sqlSave, this.batchSize);
    }

    @Override
    public List<TareaFaseAccionDto> findTareaFaseAccionDtoByIdTareaAndIdFaseAndIdPuntoEjecucionAndPeso(
            @NotNull @Positive final Long idTarea, @NotBlank final Integer idFase,
            @NotNull final Integer idPuntoEjecucion, @NotNull final Long peso) {
        final MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, idTarea);
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_FASE, idFase);
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_PUNTO_EJECUCION, idPuntoEjecucion);
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_PESO, peso);

        return this.query(
                this.sqlFindTareaFaseAccionDtoByIdTareaAndIdFaseAndIdPuntoEjecucion,
                parameters, new RowMapper<TareaFaseAccionDto>() {
                    @Override
                    public TareaFaseAccionDto mapRow(final ResultSet rs, final int rowNum) throws SQLException {
                        final TareaFaseAccionDto dto = new TareaFaseAccionDto();
                        dto.setId(rs.getLong(SqlPrimaryConstants.SQL_RESULT_ID_TAREA_FASE_ACCION));
                        dto.setIdTareaFase(rs.getLong(SqlPrimaryConstants.SQL_RESULT_ID_TAREA_FASE));
                        dto.setIdAccion(rs.getInt(SqlPrimaryConstants.SQL_RESULT_ID_ACCION));
                        dto.setIdPuntoEjecucion(rs.getInt(SqlPrimaryConstants.SQL_RESULT_ID_PUNTO_EJECUCION));
                        dto.setIdEstadoTareaFaseAccion(
                                rs.getInt(SqlPrimaryConstants.SQL_RESULT_ID_ESTADO_TAREA_FASE_ACCION));
                        dto.setActivo(rs.getBoolean(SqlPrimaryConstants.SQL_RESULT_ES_ACTIVO));
                        // dto.setFechaHoraInicio(TimeUtils
                        // .toLocalDateTime(
                        // rs.getDate(SqlPrimaryConstants.SQL_RESULT_FECHA_HORA_INICIO).toLocalDate()));
                        dto.setFechaHoraCreacion(TimeUtils
                            .toLocalDateTime(
                                    rs.getDate(SqlPrimaryConstants.SQL_RESULT_FECHA_HORA_CREACION).toLocalDate()));
                        return dto;
                    }
                });
    }

    @Override
    public List<Long> findValidacionPesoByIdTareaAndIdFaseAndIdPuntoEjecucion(
            @NotNull @Positive final Long idTarea, @NotBlank final Integer idFase,
            @NotNull final Integer idPuntoEjecucion) {
        final MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, idTarea);
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_FASE, idFase);
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_PUNTO_EJECUCION, idPuntoEjecucion);

        return this.query(
                this.sqlFindValidacionPesoByIdTareaAndIdFaseAndIdPuntoEjecucion,
                parameters, new RowMapper<Long>() {
                    @Override
                    public Long mapRow(final ResultSet rs, final int rowNum) throws SQLException {
                        return (rs.getLong(SqlPrimaryConstants.SQL_RESULT_PESO));
                    }
                });
    }

}
