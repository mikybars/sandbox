package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

import com.inditex.rrhh.icmclcwb.api.app.calcular.dto.AlgoritmoDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.EstadoTareaCalculoPersonaEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.EstadoTareaPersonaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants;
import com.inditex.rrhh.icmclcwb.model.primary.repository.JdbcBatchPrimaryRepositoryAbstract;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaCalculoPersona;

@Repository
public class TareaCalculoPersonaRepositoryCustomImpl extends JdbcBatchPrimaryRepositoryAbstract<TareaCalculoPersona>
        implements TareaCalculoPersonaRepositoryCustom {

    @Autowired
    @Qualifier("primaryNamedParameterJdbcTemplate")
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Value("#{primaryQuery['TareaCalculoPersonaRepositoryCustom.mergePersonaCalculoByAmbito']}")
    private String sqlMergePersonaCalculoByAmbito;
    
    @Value("#{primaryQuery['TareaCalculoPersonaRepositoryCustom.mergePersonaCalculoByAmbitoLocalizacion']}")
    private String sqlMergePersonaCalculoByAmbitoLocalizacion;
    
    @Value("#{primaryQuery['TareaCalculoPersonaRepositoryCustom.mergePersonaCalculoByAmbitoPersona']}")
    private String sqlMergePersonaCalculoByAmbitoPersona;
    
    @Value("#{primaryQuery['TareaCalculoPersonaRepositoryCustom.updateWithEstado']}")
    private String sqlUpdateWithEstado;
    
    @Value("#{primaryQuery['TareaCalculoPersonaRepositoryCustom.findByAlgoritmo']}")
    private String sqlFindByAlgoritmo;

    @Value("#{primaryQuery['TareaCalculoPersonaRepositoryCustom.updateEstadoActualWithEstadoNuevo']}")
    private String sqlUpdateEstadoActualWithEstadoNuevo;

    @Override
    public List<TareaCalculoPersona> findByAlgoritmo(@NotNull @Positive final TareaDto tarea, @NotBlank final AlgoritmoDto algoritmo) {
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tarea.getId());
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_ALGORITMO, algoritmo.getId());
        return namedParameterJdbcTemplate.query(sqlFindByAlgoritmo, parameters, new RowMapper<TareaCalculoPersona>() {
            public TareaCalculoPersona mapRow(ResultSet rs, int rowNum) throws SQLException {
                TareaCalculoPersona dto = new TareaCalculoPersona();
                dto.setIdPersona(rs.getString(SqlPrimaryConstants.SQL_RESULT_ID_PERSONA_LOCAL));
                dto.setOrPersona(rs.getString(SqlPrimaryConstants.SQL_RESULT_OR_PERSONA));
                return dto;
            }
        });
    }
    
    @Override
    public void updateWithEstadoAndidPersona(final List<String> idPersona, RunTareaDto runTareaDto, EstadoTareaPersonaDto estado) {
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_ESTADO, estado.getId());
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_PERSONA, idPersona);
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, runTareaDto.getTarea().getId());
        namedParameterJdbcTemplate.update(sqlUpdateWithEstado, parameters);
    }
    
    @Override
    public void updateWithEstado(RunTareaDto runTareaDto, EstadoTareaPersonaDto estadoActual, EstadoTareaPersonaDto estadoNuevo) {
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_ESTADO_ACTUAL, estadoActual.getId());
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_ESTADO_NUEVO, estadoNuevo.getId());
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, runTareaDto.getTarea().getId());
        namedParameterJdbcTemplate.update(sqlUpdateEstadoActualWithEstadoNuevo, parameters);
    }

    @Override
    public void mergePersonaCalculoByAmbito(@NotNull RunTareaDto tareaDto) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tareaDto.getTarea().getId());
        params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_ESTADO_TAREA_PERSONA, EstadoTareaCalculoPersonaEnum.PENDIENTE.getId());
        namedParameterJdbcTemplate.update(sqlMergePersonaCalculoByAmbito, params);
    }
    
    @Override
    public void mergePersonaCalculoByAmbitoLocalizacion(@NotNull RunTareaDto tareaDto) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tareaDto.getTarea().getId());
        params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_ESTADO_TAREA_PERSONA, EstadoTareaCalculoPersonaEnum.PENDIENTE.getId());
        namedParameterJdbcTemplate.update(sqlMergePersonaCalculoByAmbitoLocalizacion, params);
    }
    
    @Override
    public void mergePersonaCalculoByAmbitoPersona(@NotNull RunTareaDto tareaDto) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, tareaDto.getTarea().getId());
        params.addValue(SqlPrimaryConstants.SQL_PARAM_ID_ESTADO_TAREA_PERSONA, EstadoTareaCalculoPersonaEnum.PENDIENTE.getId());
        namedParameterJdbcTemplate.update(sqlMergePersonaCalculoByAmbitoPersona, params);
    }

    @Override
    public void setParameters(PreparedStatement pstmt, TareaCalculoPersona entity) throws SQLException {
        pstmt.setLong(1, entity.getTarea().getId());
        pstmt.setString(2, entity.getIdOrigen());
        pstmt.setString(3, entity.getIdPersona());
        pstmt.setString(4, entity.getOrPersona());
        pstmt.setLong(5, entity.getEstado().getId());
    }

}
