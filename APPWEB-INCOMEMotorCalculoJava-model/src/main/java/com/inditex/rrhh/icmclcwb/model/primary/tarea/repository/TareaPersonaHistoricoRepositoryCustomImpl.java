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

import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaHistoricoDto;
import com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants;
import com.inditex.rrhh.icmclcwb.model.primary.repository.JdbcBatchPrimaryRepositoryAbstract;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaPersonaHistorico;

@Repository
public class TareaPersonaHistoricoRepositoryCustomImpl 
    extends JdbcBatchPrimaryRepositoryAbstract<TareaPersonaHistorico> implements TareaPersonaHistoricoRepositoryCustom {

    @Autowired
    @Qualifier("primaryNamedParameterJdbcTemplate")
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    
    @Value("${app.envars.repository.batch-size.tarea-persona-historico:${app.envars.repository.batch-size.default}}")
    private int batchSize;
    
    @Value("#{primaryQuery['TareaPersonaHistoricoRepositoryCustom.save']}")
    private String sqlSave;
    
    @Value("#{primaryQuery['TareaPersonaHistoricoRepositoryCustom.findIdPersonaByIdTareaAndIdOrigenInPeriodoCalculoPersona']}")
    private String sqlFindIdPersonaByIdTareaAndIdOrigen;

    @Value("#{primaryQuery['TareaPersonaHistoricoRepositoryCustom.findIdPersonaHistoricoDtoByIdTareaAndIdOrigenAndTipoDatoInAmbito']}")
    private String sqlFindIdPersonaHistoricoDtoByIdTareaAndIdOrigenAndTipoDatoInAmbito;
   
    @Value("#{primaryQuery['TareaPersonaHistoricoRepositoryCustom.findIdPersonaHistoricoByIdTareaAndIdOrigenInPeriodoCalculoPersona']}")
    private String sqlFindIdPersonaHistoricoByIdTareaAndIdOrigen;
    
    @Override
    public List<TareaPersonaHistorico> save(final List<TareaPersonaHistorico> src) {
        return saveJdbcBatchList(src, sqlSave, batchSize);
    }

    @Override
    public void setParameters(PreparedStatement pstmt, TareaPersonaHistorico entity) throws SQLException {
        pstmt.setObject(1, entity.getFechaFin());
        pstmt.setObject(2, entity.getFechaInicio());
        pstmt.setObject(3, entity.getFechaFinSeccion());
        pstmt.setObject(4, entity.getFechaInicioSeccion());
        pstmt.setObject(5, entity.getFechaFinLocalizacion());
        pstmt.setObject(6, entity.getFechaInicioLocalizacion());
        pstmt.setString(7, entity.getStdIdHr());
        pstmt.setString(8, entity.getCclIdPerson());
        pstmt.setString(9, entity.getCclIdCodOrigen());
        pstmt.setString(10, entity.getStdIdWorkLocat());
        pstmt.setString(11, entity.getStdOrHrPeriod());
        pstmt.setString(12, entity.getStdIdLegEnt());
        pstmt.setString(13, entity.getCclIdOrigen());
        pstmt.setString(14, entity.getCclIdSeccion());
        pstmt.setLong(15, entity.getTarea().getId());
        pstmt.setObject(16, entity.getPk().getFechaInicioPeriodo());
        pstmt.setObject(17, entity.getFechaAntiguedad());
    }
    
    @Override
    public List<IdPersonaDto> findIdPersonaByIdTareaAndIdOrigenInAmbito(@NotNull @Positive final Long idTarea, @NotBlank final String cclIdOrigen) {
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, idTarea);
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_CCL_ID_ORIGEN, cclIdOrigen);
        return namedParameterJdbcTemplate.query(sqlFindIdPersonaByIdTareaAndIdOrigen, parameters, new RowMapper<IdPersonaDto>() {
            public IdPersonaDto mapRow(ResultSet rs, int rowNum) throws SQLException {
                IdPersonaDto dto = new IdPersonaDto();
                dto.setStdIdHr(rs.getString(SqlPrimaryConstants.SQL_RESULT_ID_PERSONA_META4));
                return dto;
            }
        });
    }
    
    @Override
    public List<IdPersonaHistoricoDto> findIdPersonaHistoricoDtoByIdTareaAndIdOrigenInAmbito(@NotNull @Positive final Long idTarea, @NotBlank final String cclIdOrigen) {
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, idTarea);
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_CCL_ID_ORIGEN, cclIdOrigen);
        return namedParameterJdbcTemplate.query(sqlFindIdPersonaHistoricoByIdTareaAndIdOrigen, parameters, new RowMapper<IdPersonaHistoricoDto>() {
            public IdPersonaHistoricoDto mapRow(ResultSet rs, int rowNum) throws SQLException {
                IdPersonaHistoricoDto dto = new IdPersonaHistoricoDto();
                dto.setStdIdHr(rs.getString(SqlPrimaryConstants.SQL_RESULT_ID_PERSONA_META4));
                dto.setStdOrHrPeriod(rs.getString(SqlPrimaryConstants.SQL_RESULT_OR_PERSONA));
                return dto;
            }
        });
    }
    
    @Override
    public List<IdPersonaHistoricoDto> findIdPersonaHistoricoDtoByIdTareaAndIdOrigenAndTipoDatoInAmbito(@NotNull @Positive final Long idTarea, @NotBlank final String cclIdOrigen,
            @NotNull final List<Integer> idsTipoDato) {
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, idTarea);
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_CCL_ID_ORIGEN, cclIdOrigen);
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_IDS_TIPOS_DATO, idsTipoDato);

        return namedParameterJdbcTemplate.query(sqlFindIdPersonaHistoricoDtoByIdTareaAndIdOrigenAndTipoDatoInAmbito, parameters, new RowMapper<IdPersonaHistoricoDto>() {
            public IdPersonaHistoricoDto mapRow(ResultSet rs, int rowNum) throws SQLException {
                IdPersonaHistoricoDto dto = new IdPersonaHistoricoDto();
                dto.setStdIdHr(rs.getString(SqlPrimaryConstants.SQL_RESULT_ID_PERSONA_META4));
                dto.setStdOrHrPeriod(rs.getString(SqlPrimaryConstants.SQL_RESULT_OR_PERSONA));
                return dto;
            }
        });
    }

}
