/**
 *
 */
package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.EstadoTareaFaseDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaFaseDto;
import com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants;
import com.inditex.rrhh.icmclcwb.model.app.util.TimeUtils;
import com.inditex.rrhh.icmclcwb.model.primary.repository.JdbcBatchPrimaryRepositoryAbstract;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaFase;

/**
 * @author mdelrio
 *
 */
@Repository
public class TareaFaseRepositoryCustomImpl
        extends JdbcBatchPrimaryRepositoryAbstract<TareaFase>
        implements TareaFaseRepositoryCustom {

    @Value("${app.envars.repository.batch-size.tarea-fase:0}")
    private int batchSize;

    @Value("#{primaryQuery['TareaFaseRepositoryCustom.save']}")
    private String sqlSave;

    @Value("#{primaryQuery['TareaFaseRepositoryCustom.findTareaFaseDtoByIdTareaAndIdFase']}")
    private String sqlFindTareaFaseDtoByIdTareaAndIdFase;

    @Value("#{primaryQuery['TareaFaseRepositoryCustom.findTareaFaseDtoByIdTarea']}")
    private String sqlFindTareaFaseDtoByIdTarea;

    @Value("#{primaryQuery['TareaFaseRepositoryCustom.updateFechaInicio']}")
    private String sqlUpdateFechaInicio;

    @Value("#{primaryQuery['TareaFaseRepositoryCustom.updateFechaFinAndEstado']}")
    private String sqlUpdateFechaFinAndEstado;

    @Override
    public List<TareaFase> save(final List<TareaFase> src) {
        return this.saveNamedJdbcBatchList(src, this.sqlSave, this.batchSize);
    }

    @Override
    public TareaFaseDto findTareaFaseDtoByIdTareaAndIdFase(
            @NotNull @Positive final Long idTarea,
            @NotNull @Positive final Integer idFase) {
        final MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, idTarea);
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_FASE, idFase);

        return this.queryForObject(this.sqlFindTareaFaseDtoByIdTareaAndIdFase,
                parameters,
                new RowMapper<TareaFaseDto>() {
                    @Override
                    public TareaFaseDto mapRow(final ResultSet rs, final int rowNum) throws SQLException {
                        final TareaFaseDto dto = new TareaFaseDto();
                        dto.setId(rs.getLong(SqlPrimaryConstants.SQL_RESULT_ID_TAREA_FASE));
                        dto.setIdTarea(rs.getLong(SqlPrimaryConstants.SQL_RESULT_ID_TAREA));
                        dto.setActivo(rs.getBoolean(SqlPrimaryConstants.SQL_RESULT_ES_ACTIVO));
                        return dto;
                    }
                });
    }

    @Override
    public List<TareaFaseDto> findTareaFaseDtoByIdTarea(
            @NotNull @Positive final Long idTarea) {
        final MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, idTarea);

        return this.query(this.sqlFindTareaFaseDtoByIdTarea,
                parameters,
                new RowMapper<TareaFaseDto>() {
                    @Override
                    public TareaFaseDto mapRow(final ResultSet rs, final int rowNum) throws SQLException {
                        final TareaFaseDto dto = new TareaFaseDto();
                        dto.setId(rs.getLong(SqlPrimaryConstants.SQL_RESULT_ID_TAREA_FASE));
                        dto.setIdTarea(rs.getLong(SqlPrimaryConstants.SQL_RESULT_ID_TAREA));
                        dto.setActivo(rs.getBoolean(SqlPrimaryConstants.SQL_RESULT_ES_ACTIVO));
                        dto.setIdFase(rs.getInt(SqlPrimaryConstants.SQL_RESULT_ID_FASE));
                        return dto;
                    }
                });
    }

    @Override
    public void updateFechaInicio(@NotNull final TareaFaseDto tareaFaseDto) {
        final MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA_FASE, tareaFaseDto.getId());
        params.addValue(SqlPrimaryConstants.SQL_PARAM_NUEVA_FECHA, TimeUtils.nowDate());
        this.update(this.sqlUpdateFechaInicio, params);
    }

    @Override
    public void updateFechaFinAndEstado(@NotNull final TareaFaseDto tareaFaseDto,
            @NotNull final EstadoTareaFaseDto estadoTareaFaseDto) {
        final MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA_FASE, tareaFaseDto.getId());
        params.addValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ID_ESTADO, estadoTareaFaseDto.getId());
        params.addValue(SqlPrimaryConstants.SQL_PARAM_NUEVA_FECHA, TimeUtils.nowDate());
        this.update(this.sqlUpdateFechaFinAndEstado, params);
    }

}
