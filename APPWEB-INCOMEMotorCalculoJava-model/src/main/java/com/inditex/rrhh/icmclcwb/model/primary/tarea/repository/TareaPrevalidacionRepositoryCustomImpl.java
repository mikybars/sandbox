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

import com.inditex.rrhh.icmclcwb.api.app.dto.AccionValidacionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.EstadoValidacionEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.EstadoTareaPrevalidacionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaPrevalidacionDto;
import com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants;
import com.inditex.rrhh.icmclcwb.model.app.util.TimeUtils;
import com.inditex.rrhh.icmclcwb.model.primary.repository.JdbcBatchPrimaryRepositoryAbstract;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaPrevalidacion;

@Repository
public class TareaPrevalidacionRepositoryCustomImpl extends JdbcBatchPrimaryRepositoryAbstract<TareaPrevalidacion>
        implements TareaPrevalidacionRepositoryCustom {

    @Value("${app.envars.repository.batch-size.tarea-flujo:0}")
    private int batchSize;

    @Value("#{primaryQuery['TareaPrevalidacionRepositoryCustom.save']}")
    private String sqlSave;

    @Value("#{primaryQuery['TareaPrevalidacionRepositoryCustom.findByTareaUltimoIntento']}")
    private String sqlFindByTareaUltimoIntento;

    @Value("#{primaryQuery['TareaPrevalidacionRepositoryCustom.findAccionValidacion']}")
    private String sqlFindAccionValidacion;

    @Value("#{primaryQuery['TareaPrevalidacionRepositoryCustom.updateFecha']}")
    private String sqlUpdateFecha;

    @Value("#{primaryQuery['TareaPrevalidacionRepositoryCustom.updateEstado']}")
    private String sqlUpdateEstado;

    @Override
    public List<TareaPrevalidacion> save(final List<TareaPrevalidacion> src) {
        return this.saveNamedJdbcBatchList(src, this.sqlSave, this.batchSize);
    }

    @Override
    public TareaPrevalidacionDto findMaxReintento(
            @NotNull @Positive final Long idTarea) {
        final MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, idTarea);

        return this.queryForObject(
                this.sqlFindByTareaUltimoIntento,
                parameters, new RowMapper<TareaPrevalidacionDto>() {
                    @Override
                    public TareaPrevalidacionDto mapRow(final ResultSet rs, final int rowNum) throws SQLException {
                        final TareaPrevalidacionDto dto = new TareaPrevalidacionDto();
                        dto.setId(rs.getInt(SqlPrimaryConstants.SQL_RESULT_ID_TAREA_PREVALIDACION));
                        return dto;
                    }
                });
    }

    @Override
    public AccionValidacionDto findAccionValidacion(
            @NotNull @Positive final Long idTarea, @NotNull @Positive final Integer idTareaPrevalidacion) {
        final MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, idTarea);
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ACTIVO, Boolean.TRUE);
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_ESTADO, EstadoValidacionEnum.OK.getId());
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA_PREVALIDACION, idTareaPrevalidacion);
        final List<AccionValidacionDto> accion = this.query(
                this.sqlFindAccionValidacion,
                parameters, new RowMapper<AccionValidacionDto>() {
                    @Override
                    public AccionValidacionDto mapRow(final ResultSet rs, final int rowNum) throws SQLException {
                        final AccionValidacionDto dto = new AccionValidacionDto();
                        dto.setId(rs.getInt(SqlPrimaryConstants.SQL_RESULT_ID_TIPO_ACCION_VALIDACION));
                        dto.setDelayTime(rs.getLong(SqlPrimaryConstants.SQL_RESULT_REINTENTO_DELAY));
                        return dto;
                    }
                });
        if (accion.size() == 1) { // list contains exactly 1 element
            return accion.get(0);
        }
        return null;
    }

    @Override
    public void updateFechaFin(@NotNull final TareaPrevalidacionDto tareaPrevalidacionDto) {
        final MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA_PREVALIDACION, tareaPrevalidacionDto.getId());
        params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tareaPrevalidacionDto.getIdTarea());
        params.addValue(SqlPrimaryConstants.SQL_PARAM_NUEVA_FECHA, TimeUtils.nowDate());
        this.update(this.sqlUpdateFecha, params);
    }

    @Override
    public void updateEstado(@NotNull final TareaPrevalidacionDto tareaPrevalidacionDto,
            @NotNull final EstadoTareaPrevalidacionDto estado) {
        final MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA_PREVALIDACION, tareaPrevalidacionDto.getId());
        params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tareaPrevalidacionDto.getIdTarea());
        params.addValue(SqlPrimaryConstants.SQL_PARAM_NUEVO_ID_ESTADO, estado.getId());
        this.update(this.sqlUpdateEstado, params);
    }

}
