package com.inditex.rrhh.icmclcwb.model.secondary.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.inditex.rrhh.icmclcwb.model.secondary.entity.PresenciaTotalTiendaMock;
import com.inditex.rrhh.icmclcwb.model.secondary.entity.PresenciaTotalTiendaSeccionMock;

public class PresenciaTotalTiendaSeccionMockRowMapper implements RowMapper{

	@Override
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		PresenciaTotalTiendaSeccionMock pre = new PresenciaTotalTiendaSeccionMock();

		pre.setFecha(rs.getDate("FECHA"));
		pre.setMinutos(rs.getInt("MINUTOS"));
		pre.setTienda(rs.getInt("ID_TIENDA"));
		pre.setSeccion(rs.getInt("ID_SECCION"));
		return pre;
	}
}
