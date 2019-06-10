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
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalDto;
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
    
    @Value("#{primaryQuery['TareaPersonaHistoricoRepositoryCustom.findIdPersonaDtoByIdTareaAndIdOrigenAndTipoDatoInAmbito']}")
    private String sqlFindIdPersonaDtoByIdTareaAndIdOrigenAndTipoDatoInAmbito;
    
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
        pstmt.setString(5, entity.getIdPersona());
        pstmt.setString(6, entity.getIdPersonaLocal());
        pstmt.setString(7, entity.getIdLocalizacion());
        pstmt.setString(8, entity.getIdLocalizacionMeta4());
        pstmt.setString(9, entity.getOrPersona());
        pstmt.setString(10, entity.getIdEmpresa());
        pstmt.setString(11, entity.getIdOrigen());
        pstmt.setString(12, entity.getIdSeccion());
        pstmt.setLong(13, entity.getTarea().getId());        
    }
    
    @Override
    public List<IdPersonaDto> findIdPersonaByIdTareaAndIdOrigenInAmbito(@NotNull @Positive final Long idTarea, @NotBlank final String idOrigen) {
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, idTarea);
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_ORIGEN, idOrigen);
        return namedParameterJdbcTemplate.query(sqlFindIdPersonaByIdTareaAndIdOrigen, parameters, new RowMapper<IdPersonaDto>() {
            public IdPersonaDto mapRow(ResultSet rs, int rowNum) throws SQLException {
                IdPersonaDto dto = new IdPersonaDto();
                dto.setIdPersona(rs.getString(SqlPrimaryConstants.SQL_RESULT_ID_PERSONA));
                return dto;
            }
        });
    }
    
    @Override
    public List<IdPersonaLocalDto> findIdPersonaDtoByIdTareaAndIdOrigenAndTipoDatoInAmbito(@NotNull @Positive final Long idTarea, @NotBlank final String idOrigen,
            @NotNull final List<Long> idsTipoDato) {
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, idTarea);
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_ORIGEN, idOrigen);
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_IDS_TIPOS_DATO, idsTipoDato);

        return namedParameterJdbcTemplate.query(sqlFindIdPersonaDtoByIdTareaAndIdOrigenAndTipoDatoInAmbito, parameters, new RowMapper<IdPersonaLocalDto>() {
            public IdPersonaLocalDto mapRow(ResultSet rs, int rowNum) throws SQLException {
                IdPersonaLocalDto dto = new IdPersonaLocalDto();
                dto.setIdPersonaLocal(rs.getString(SqlPrimaryConstants.SQL_RESULT_ID_PERSONA));
                return dto;
            }
        });
    }
    

}
