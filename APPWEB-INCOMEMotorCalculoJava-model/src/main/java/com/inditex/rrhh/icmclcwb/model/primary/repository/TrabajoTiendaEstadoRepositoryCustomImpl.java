package com.inditex.rrhh.icmclcwb.model.primary.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Set;

import javax.validation.constraints.NotEmpty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.inditex.rrhh.icmclcwb.api.meta4.dto.Meta4PropertiesDto;
import com.inditex.rrhh.icmclcwb.model.primary.entity.TrabajoTiendaEstado;

@Repository
public class TrabajoTiendaEstadoRepositoryCustomImpl extends JdbcBatchRepository<TrabajoTiendaEstado> implements TrabajoTiendaEstadoRepositoryCustom {

    @Autowired
    @Qualifier("primaryJdbcTemplate")
    private JdbcTemplate jdbcTemplate;
    
    @Autowired
    @Qualifier("searchTiendasDto")
    private Meta4PropertiesDto searchTiendasDto;

    private static final String QUERY = " SELECT ID FROM TABLE ( VALUES :ids) AS TIENDA (ID) WHERE NOT EXISTS ( SELECT 1 FROM TRABAJO_TIENDA_ESTADO A WHERE A.CCL_ID_COD_ORIGEN = TIENDA.ID)";
    
    private static final String INSERT = "INSERT INTO TRABAJO_TIENDA_ESTADO ( "
            + "CCL_ID_CADENA, STD_ID_LEG_ENT, STD_ID_COUNTRY, "  
            + "CCL_ID_ORIGEN, CCL_ID_COD_ORIGEN, STD_ID_WORK_LOCAT, "
            + "ID_TIPO_TRABAJO_TIENDA, ID_TRABAJO)" 
            + "VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
    
    @Override
    public List<TrabajoTiendaEstado> save(final List<TrabajoTiendaEstado> src) throws Exception{
        return saveJdbcBatchList(src, INSERT, searchTiendasDto.getFilter().getMaxBatchSize());
    }

    @Override
    public void setParameters(PreparedStatement pstmt, TrabajoTiendaEstado entity) throws SQLException {
        pstmt.setString(1, entity.getIdCadena());
        pstmt.setString(2, entity.getIdEmpresa());
        pstmt.setString(3, entity.getIdPais());
        pstmt.setString(4, entity.getIdPaisOrigen());
        pstmt.setString(5, entity.getIdTienda());    
        pstmt.setString(6, entity.getIdTiendaMeta4()); 
        pstmt.setLong(7, entity.getTipo().getId());    
        pstmt.setLong(8, entity.getTrabajo().getId());    

    }
    
    @Override
    public List<Integer> customFindByIdTiendaNotExists(@NotEmpty Set<Integer> ids) {
        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue("ids", ids);
        return namedParameterJdbcTemplate.query(QUERY, parameters, new RowMapper<Integer>() {
            @Override
            public Integer mapRow(ResultSet rs, int rowNum) throws SQLException {
                return rs.getInt("ID");
            }
        });
    }
    
}
