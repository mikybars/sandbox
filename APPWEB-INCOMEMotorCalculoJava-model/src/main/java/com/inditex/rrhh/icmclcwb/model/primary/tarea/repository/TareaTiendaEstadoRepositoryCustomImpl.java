package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.validation.constraints.NotEmpty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.inditex.rrhh.icmclcwb.api.app.util.SqlPrimaryConstants;
import com.inditex.rrhh.icmclcwb.api.meta4.dto.Meta4PropertiesDto;
import com.inditex.rrhh.icmclcwb.api.meta4.util.Meta4Constants;
import com.inditex.rrhh.icmclcwb.model.primary.repository.JdbcBatchPrimaryRepositoryAbstract;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaTiendaEstado;

@Repository
public class TareaTiendaEstadoRepositoryCustomImpl extends JdbcBatchPrimaryRepositoryAbstract<TareaTiendaEstado>
        implements TareaTiendaEstadoRepositoryCustom {

    @Autowired
    @Qualifier("primaryNamedParameterJdbcTemplate")
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    @Qualifier("meta4Properties")
    private Map<String, Meta4PropertiesDto> meta4Properties;

    @Value("#{primaryQuery['TareaTiendaEstadoRepositoryCustom.customFindByIdTiendaNotExists']}")
    private String sqlCustomFindByIdTiendaNotExists;

    @Value("#{primaryQuery['TareaTiendaEstadoRepositoryCustom.save']}")
    private String sqlSave;

    @Override
    public List<TareaTiendaEstado> save(final List<TareaTiendaEstado> src) {
        return saveJdbcBatchList(src, sqlSave, meta4Properties.get(Meta4Constants.SEARCH_TIENDAS).getFilter().getMaxBatchSize());
    }

    @Override
    public void setParameters(PreparedStatement pstmt, TareaTiendaEstado entity) throws SQLException {
        pstmt.setString(1, entity.getIdCadena());
        pstmt.setString(2, entity.getIdEmpresa());
        pstmt.setString(3, entity.getIdPais());
        pstmt.setString(4, entity.getIdPaisOrigen());
        pstmt.setString(5, entity.getIdTienda());
        pstmt.setString(6, entity.getIdTiendaMeta4());
        pstmt.setLong(7, entity.getTipo().getId());
        pstmt.setLong(8, entity.getTarea().getId());
    }

    @Override
    public List<Integer> customFindByIdTiendaNotExists(@NotEmpty Set<Integer> ids) {
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue(SqlPrimaryConstants.SQL_PARAM_ID_TIENDA, ids);
        return namedParameterJdbcTemplate.query(sqlCustomFindByIdTiendaNotExists, parameters, new RowMapper<Integer>() {
            @Override
            public Integer mapRow(ResultSet rs, int rowNum) throws SQLException {
                return rs.getInt(SqlPrimaryConstants.SQL_RESULT_ID);
            }
        });
    }

}
