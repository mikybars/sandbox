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

import com.inditex.rrhh.icmclcwb.api.app.dto.IdLocalizacionDto;
import com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants;
import com.inditex.rrhh.icmclcwb.model.primary.repository.JdbcBatchPrimaryRepositoryAbstract;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLocalizacionHistorico;

@Repository
public class TareaLocalizacionHistoricoRepositoryCustomImpl extends JdbcBatchPrimaryRepositoryAbstract<TareaLocalizacionHistorico>
        implements TareaLocalizacionHistoricoRepositoryCustom {
    
    @Autowired
    @Qualifier("primaryNamedParameterJdbcTemplate")
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    
    @Value("${app.envars.repository.batch-size.tarea-localizacion-historico:${app.envars.repository.batch-size.default}}")
    private int batchSize;

    @Value("#{primaryQuery['TareaLocalizacionHistoricoRepositoryCustom.save']}")
    private String sqlSave;
    
    @Value("#{primaryQuery['TareaLocalizacionHistoricoRepositoryCustom.findIdLocalizacionDtoByIdTareaAndIdOrigenInAmbito']}")
    private String sqlFindIdLocalizacionDtoByIdTareaAndIdOrigenInAmbito;

    @Override
    public List<TareaLocalizacionHistorico> save(final List<TareaLocalizacionHistorico> src) {
        return saveJdbcBatchList(src, sqlSave, batchSize);
    }

    @Override
    public void setParameters(PreparedStatement pstmt, TareaLocalizacionHistorico entity) throws SQLException {
        pstmt.setObject(1, entity.getFechaFin());
        pstmt.setObject(2, entity.getFechaInicio());
        pstmt.setString(3, entity.getIdCadena());
        pstmt.setString(4, entity.getIdEmpresa());
        pstmt.setString(5, entity.getIdPais());
        pstmt.setString(6, entity.getIdPaisOrigen());
        pstmt.setString(7, entity.getIdLocalizacion());
        pstmt.setString(8, entity.getIdLocalizacionMeta4());
        pstmt.setLong(9, entity.getTarea().getId());
    }

    @Override
    public List<IdLocalizacionDto> findIdLocalizacionDtoByIdTareaAndIdOrigenInAmbito(@NotNull @Positive final Long idTarea, @NotBlank final String idOrigen) {
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TAREA, idTarea);
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_ORIGEN, idOrigen);
        return namedParameterJdbcTemplate.query(sqlFindIdLocalizacionDtoByIdTareaAndIdOrigenInAmbito, parameters, new RowMapper<IdLocalizacionDto>() {
            public IdLocalizacionDto mapRow(ResultSet rs, int rowNum) throws SQLException {
                IdLocalizacionDto dto = new IdLocalizacionDto();
                dto.setId(rs.getString(SqlPrimaryConstants.SQL_RESULT_ID_LOCALIZACION_META4));
                return dto;
            }
        });
    }
}
