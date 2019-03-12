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

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.EstadoTareaEmpleadoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaEmpleadoEstadoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaEmpleadoHistoricoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaTiendaEstadoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TipoTareaTiendaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaEmpleadoEstado;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaEmpleadoHistorico;

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
    
    @Value("#{primaryQuery['RunTareaValidarService.TiendaEmptyFields']}")
    private String sqlTiendaEmptyFields;
    
    @Value("#{primaryQuery['RunTareaValidarService.EmpleadoEmptyFields']}")
    private String sqlEmpleadoEmptyFields;
    
    @Value("#{primaryQuery['RunTareaValidarService.EmpleadoHistoricoEmptyFields']}")
    private String sqlEmpleadoHistoricoEmptyFields;
    
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
    public List<TareaTiendaEstadoDto> tiendaEmptyFields(@NotNull @Positive final Long idTarea) {
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, idTarea);
        return namedParameterJdbcTemplate.query(sqlTiendaEmptyFields, parameters, new RowMapper<TareaTiendaEstadoDto>() {
            public TareaTiendaEstadoDto mapRow(ResultSet rs, int rowNum) throws SQLException {
                TareaTiendaEstadoDto dto = new TareaTiendaEstadoDto();
                dto.setId(rs.getString("ID_TAREA_TIENDA_ESTADO"));
                dto.setIdCadena(rs.getString("CCL_ID_CADENA"));
                dto.setIdEmpresa(rs.getString("STD_ID_LEG_ENT"));
                dto.setIdPais(rs.getString("STD_ID_COUNTRY"));
                dto.setIdPaisOrigen(rs.getString("CCL_ID_ORIGEN"));
                dto.setIdTarea(rs.getLong("ID_TAREA"));
                dto.setIdTienda(rs.getString("CCL_ID_COD_ORIGEN"));
                dto.setIdTiendaMeta4(rs.getString("STD_ID_WORK_LOCAT"));
                dto.setTipo(new TipoTareaTiendaDto(rs.getLong("ID_TIPO_TAREA_TIENDA")));
                return dto;
            }
        });
    }
    
    @Override
    public List<TareaEmpleadoEstadoDto> empleadoEmptyFields(@NotNull @Positive final Long idTarea) {
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, idTarea);
        return namedParameterJdbcTemplate.query(sqlEmpleadoEmptyFields, parameters, new RowMapper<TareaEmpleadoEstadoDto>() {
            public TareaEmpleadoEstadoDto mapRow(ResultSet rs, int rowNum) throws SQLException {
                TareaEmpleadoEstadoDto dto = new TareaEmpleadoEstadoDto();
                dto.setId(rs.getString("ID_TAREA_EMPLEADO_ESTADO"));
                dto.setIdEmpleado(rs.getString("ID_EMPLEADO"));
                dto.setIdEmpleadoLocal(rs.getString("ID_EMPLEADO_LOCAL"));
                dto.setOrEmpleado(rs.getString("OR_EMPLEADO"));
                dto.setIdTarea(rs.getLong("ID_TAREA"));
                dto.setEstado(new EstadoTareaEmpleadoDto(rs.getLong("ID_ESTADO_TAREA_EMPLEADO")));
                return dto;
            }
        });
    }
    
    @Override
    public List<TareaEmpleadoHistoricoDto> empleadoHistoricoEmptyFields(@NotNull @Positive final Long idTarea) {
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, idTarea);
        return namedParameterJdbcTemplate.query(sqlEmpleadoEmptyFields, parameters, new RowMapper<TareaEmpleadoHistoricoDto>() {
            public TareaEmpleadoHistoricoDto mapRow(ResultSet rs, int rowNum) throws SQLException {
                TareaEmpleadoHistoricoDto dto = new TareaEmpleadoHistoricoDto();
                dto.setId(rs.getString("ID_TAREA_EMPLEADO_ESTADO"));
                dto.setIdEmpleado(rs.getString("ID_EMPLEADO"));
                dto.setIdEmpleadoLocal(rs.getString("ID_EMPLEADO_LOCAL"));
                dto.setOrEmpleado(rs.getString("OR_EMPLEADO"));
                dto.setIdTarea(rs.getLong("ID_TAREA"));
                dto.setIdTienda(rs.getString("CCL_ID_COD_ORIGEN"));
                dto.setIdTiendaMeta4(rs.getString("STD_ID_WORK_LOCAT"));
                dto.setFechaFin(rs.getDate("FECHA_FIN"));
                dto.setFechaInicio(rs.getDate("FECHA_INICIO"));
                return dto;
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
