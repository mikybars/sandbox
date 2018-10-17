package com.inditex.rrhh.icmclcwb.model.mapper.ptr;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.inditex.rrhh.icmclcwb.model.secondary.entity.ptr.PresenciaGHRS;

public class PresenciaGHRSRowMapper implements RowMapper {
	@Override
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		PresenciaGHRS pre= new PresenciaGHRS();
        //pre.setId(rs.getLong("ID"));
		pre.setTipo(rs.getInt("TIPO"));
		pre.setTienda(rs.getInt("TIENDA"));
		pre.setFecha(rs.getDate("FECHA"));
		pre.setSeccion(rs.getInt("SECCION"));
		pre.setPersona(rs.getInt("PERSONA"));
		pre.setHoras(rs.getInt("HORAS"));
		pre.setCcl_id_origen(rs.getInt("CCL_ID_ORIGEN"));
		return pre;
	}
}
