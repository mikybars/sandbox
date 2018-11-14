package com.inditex.rrhh.icmclcwb.model.secondary.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.inditex.rrhh.icmclcwb.model.secondary.entity.PresenciaTotalTiendaMock;

public class PresenciaTotalTiendaMockRowMapper implements RowMapper<PresenciaTotalTiendaMock> {

	@Override
	public PresenciaTotalTiendaMock mapRow(ResultSet rs, int rowNum) throws SQLException {
		PresenciaTotalTiendaMock pre = new PresenciaTotalTiendaMock();
		pre.setFecha(rs.getDate("FECHA"));
		pre.setMinutos(rs.getInt("MINUTOS"));
		pre.setTienda(rs.getInt("ID_TIENDA"));
		return pre;
	}

}