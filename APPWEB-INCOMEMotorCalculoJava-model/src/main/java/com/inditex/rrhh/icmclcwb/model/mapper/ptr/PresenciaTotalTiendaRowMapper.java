package com.inditex.rrhh.icmclcwb.model.mapper.ptr;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.inditex.rrhh.icmclcwb.model.secondary.entity.ptr.PresenciaTotalTiendaMock;

public class PresenciaTotalTiendaRowMapper implements RowMapper{

	@Override
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		PresenciaTotalTiendaMock pre = new PresenciaTotalTiendaMock();

		pre.setFecha(rs.getDate("FECHA"));
		pre.setHoras(rs.getInt("HORAS"));
		pre.setTienda(rs.getInt("TIENDA"));
		pre.setMinutos(pre.getHoras()*60);
		return pre;
	}
	

}
