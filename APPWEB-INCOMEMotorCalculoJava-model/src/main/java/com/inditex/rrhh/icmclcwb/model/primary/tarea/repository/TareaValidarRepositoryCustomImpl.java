package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants;

@Repository
public class TareaValidarRepositoryCustomImpl implements TareaValidarRepositoryCustom {

    @Autowired
    @Qualifier("primaryNamedParameterJdbcTemplate")
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    
    @Value("#{primaryQuery['RunTareaValidarService.checkDuplicatedEmpleados']}")
    private String sqlCheckDuplicatedEmpleados;
    
    @Value("#{primaryQuery['RunTareaValidarService.checkDuplicatedTiendas']}")
    private String sqlCheckDuplicatedTiendas;
    
    @Value("#{primaryQuery['RunTareaValidarService.checkDuplicatedTiendasHistorico']}")
    private String sqlCheckDuplicatedTiendasHistorico;
    
    @Value("#{primaryQuery['RunTareaValidarService.countEmpleados']}")
    private String sqlCountEmpleados;
    
    @Value("#{primaryQuery['RunTareaValidarService.countEmpleadosHistorico']}")
    private String sqlCountEmpleadosHistorico;
    
    @Value("#{primaryQuery['RunTareaValidarService.countTiendas']}")
    private String sqlCountTiendas;
    
    @Value("#{primaryQuery['RunTareaValidarService.countTiendasHistorico']}")
    private String sqlCountTiendasHistorico;
    
    @Value("#{primaryQuery['RunTareaValidarService.countEstructuras']}")
    private String sqlCountEstructuras;

    @Value("#{primaryQuery['RunTareaValidarService.countTiendaPresenciaSeccion']}")
    private String sqlCountTiendaPresenciaSeccion;

    @Value("#{primaryQuery['RunTareaValidarService.countTiendaEmpleadoPresenciaSeccion']}")
    private String sqlCountTiendaEmpleadoPresenciaSeccion;

    @Value("#{primaryQuery['RunTareaValidarService.countTiendaVentaSeccion']}")
    private String sqlCountTiendaVentaSeccion;
    
    
    @Override
    public List<String> checkDuplicatedEmpleados(@NotNull @Positive final Long idTarea) {
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, idTarea);
        return namedParameterJdbcTemplate.query(sqlCheckDuplicatedEmpleados, parameters, new RowMapper<String>() {
            public String mapRow(ResultSet rs, int rowNum) throws SQLException {
                  return rs.getString(1);
            }
        });
    }
    
    @Override
    public List<String> checkDuplicatedTiendas(@NotNull @Positive final Long idTarea) {
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, idTarea);
        return namedParameterJdbcTemplate.query(sqlCheckDuplicatedTiendas, parameters, new RowMapper<String>() {
            public String mapRow(ResultSet rs, int rowNum) throws SQLException {
                  return rs.getString(1);
            }
        });
    }
    
    @Override
    public List<String> checkDuplicatedTiendasHistorico(@NotNull @Positive final Long idTarea) {
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, idTarea);
        return namedParameterJdbcTemplate.query(sqlCheckDuplicatedTiendasHistorico, parameters, new RowMapper<String>() {
            public String mapRow(ResultSet rs, int rowNum) throws SQLException {
                  return rs.getString(1);
            }
        });
    }
    
    @Override
    public Integer countEmpleados(@NotNull @Positive final Long idTarea) {
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, idTarea);
        return namedParameterJdbcTemplate.queryForObject(sqlCountEmpleados, parameters, Integer.class);
    }
    
    @Override
    public Integer countEmpleadosHistorico(@NotNull @Positive Long idTarea) {
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, idTarea);
        return namedParameterJdbcTemplate.queryForObject(sqlCountEmpleadosHistorico, parameters, Integer.class);
    }
    
    @Override
    public Integer countTiendas(@NotNull @Positive final Long idTarea) {
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, idTarea);
        return namedParameterJdbcTemplate.queryForObject(sqlCountTiendas, parameters, Integer.class);
    }
    
    @Override
    public Integer countTiendasHistorico(@NotNull @Positive final Long idTarea) {
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, idTarea);
        return namedParameterJdbcTemplate.queryForObject(sqlCountTiendasHistorico, parameters, Integer.class);
    }
    
    @Override
    public Integer countEstructuras(@NotNull @Positive final Long idTarea) {
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, idTarea);
        return namedParameterJdbcTemplate.queryForObject(sqlCountEstructuras, parameters, Integer.class);
    }
    
    @Override
    public Integer countTiendaPresenciaSeccion(@NotNull @Positive final Long idTarea) {
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, idTarea);
        return namedParameterJdbcTemplate.queryForObject(sqlCountTiendaPresenciaSeccion, parameters, Integer.class);
    }

    @Override
    public Integer countTiendaEmpleadoPresenciaSeccion(@NotNull @Positive final Long idTarea) {
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, idTarea);
        return namedParameterJdbcTemplate.queryForObject(sqlCountTiendaEmpleadoPresenciaSeccion, parameters, Integer.class);
    }

    @Override
    public Integer countTiendaVentaSeccion(@NotNull @Positive final Long idTarea) {
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, idTarea);
        return namedParameterJdbcTemplate.queryForObject(sqlCountTiendaVentaSeccion, parameters, Integer.class);
    }
    
}
