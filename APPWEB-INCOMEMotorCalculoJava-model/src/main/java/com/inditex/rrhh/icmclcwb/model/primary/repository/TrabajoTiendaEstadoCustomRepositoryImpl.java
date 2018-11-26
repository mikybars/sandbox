package com.inditex.rrhh.icmclcwb.model.primary.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Set;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class TrabajoTiendaEstadoCustomRepositoryImpl implements TrabajoTiendaEstadoCustomRepository {

	@Autowired
	@Qualifier("primaryJdbcTemplate")
	private JdbcTemplate jdbcTemplate;
	
	private static final String QUERY = " SELECT ID FROM TABLE ( VALUES :ids) AS TIENDA (ID) "
			+ " WHERE NOT EXISTS ( SELECT 1 FROM DESARROLLO_RRHH.INCOME_TRABAJO_TIENDA_ESTADO A "
			+ " WHERE A.CCL_ID_COD_ORIGEN = TIENDA.ID"
			+ ")"; 
	
	@Override
	public List<Integer> customFindByIdTiendaNotExists(@NotNull Set<Integer> ids){

		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		parameters.addValue("ids", ids);

		List<Integer> list = namedParameterJdbcTemplate.query(QUERY,
		     parameters, new RowMapper<Integer>() {
				@Override
				public Integer mapRow(ResultSet rs, int rowNum) throws SQLException {
					return rs.getInt("ID");
				}
			});
		
		return list;
	}
}
