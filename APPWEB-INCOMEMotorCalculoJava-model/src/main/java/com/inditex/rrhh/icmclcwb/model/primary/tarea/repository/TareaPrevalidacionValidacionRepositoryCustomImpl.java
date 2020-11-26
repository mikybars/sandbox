package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaPrevalidacionValidacionDto;
import com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants;
import com.inditex.rrhh.icmclcwb.model.app.util.TimeUtils;
import com.inditex.rrhh.icmclcwb.model.primary.repository.JdbcBatchPrimaryRepositoryAbstract;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaPrevalidacionValidacion;

@Repository
public class TareaPrevalidacionValidacionRepositoryCustomImpl
        extends JdbcBatchPrimaryRepositoryAbstract<TareaPrevalidacionValidacion>
        implements TareaPrevalidacionValidacionRepositoryCustom {

    @Value("${app.envars.repository.batch-size.tarea-prevalidacion-validacion:0}")
    private int batchSize;

    @Value("#{primaryQuery['TareaPrevalidacionValidacionRepositoryCustom.save']}")
    private String sqlSave;

    @Value("#{primaryQuery['TareaPrevalidacionValidacionRepositoryCustom.update']}")
    private String sqlUpdate;

    @Value("#{primaryQuery['TareaPrevalidacionValidacionRepositoryCustom.findByIdTareaAndIdTareaPrevalidacionAndTipoValidacion']}")
    private String sqlFindByIdTareaAndIdTareaPrevalidacionAndTipoValidacion;

    @Override
    public List<TareaPrevalidacionValidacion> save(final List<TareaPrevalidacionValidacion> src) {
        return this.saveNamedJdbcBatchList(src, this.sqlSave, this.batchSize);
    }

    @Override
    public void update(final Integer idEstadoValidacion, final Integer idTareaPrevalidacion,
            final Integer idTipoValidacion, final Long idTarea) {
        final MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, idTarea);
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_ESTADO_VALIDACION, idEstadoValidacion);
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA_PREVALIDACION, idTareaPrevalidacion);
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_VALIDACION, idTipoValidacion);
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_FECHA_HORA_ACTUALIZACION,
                TimeUtils.nowDate());
        this.update(this.sqlUpdate, parameters);
    }

    @Override
    public TareaPrevalidacionValidacionDto findByIdTareaAndIdTareaPrevalidacionAndTipoValidacion(
            @NotNull final Long idTarea,
            @NotNull final Integer idTareaPrevalidacion,
            @NotNull final Integer idTipoValidacion) {
        final MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, idTarea);
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA_PREVALIDACION, idTareaPrevalidacion);
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIPO_VALIDACION, idTipoValidacion);

        return this.queryForObject(
                this.sqlFindByIdTareaAndIdTareaPrevalidacionAndTipoValidacion,
                parameters, new RowMapper<TareaPrevalidacionValidacionDto>() {
                    @Override
                    public TareaPrevalidacionValidacionDto mapRow(final ResultSet rs, final int rowNum)
                            throws SQLException {
                        final TareaPrevalidacionValidacionDto dto = new TareaPrevalidacionValidacionDto();
                        dto.setId(rs.getInt(SqlPrimaryConstants.SQL_RESULT_ID_TIPO_VALIDACION));
                        dto.setIdTarea(rs.getLong(SqlPrimaryConstants.SQL_RESULT_ID_TAREA));
                        dto.setIdTareaPrevalidacion(rs.getInt(SqlPrimaryConstants.SQL_RESULT_ID_TAREA_PREVALIDACION));
                        return dto;
                    }
                });
    }

}
