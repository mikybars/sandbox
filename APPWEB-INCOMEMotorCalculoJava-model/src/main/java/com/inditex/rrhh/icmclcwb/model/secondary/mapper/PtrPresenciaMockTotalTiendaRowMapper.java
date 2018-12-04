package com.inditex.rrhh.icmclcwb.model.secondary.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.inditex.rrhh.icmclcwb.model.secondary.entity.PtrPresenciaMockTotalTienda;

public class PtrPresenciaMockTotalTiendaRowMapper implements RowMapper<PtrPresenciaMockTotalTienda> {

	@Override
	public PtrPresenciaMockTotalTienda mapRow(ResultSet rs, int rowNum) throws SQLException {
		PtrPresenciaMockTotalTienda pre = new PtrPresenciaMockTotalTienda();
		pre.setFecha(rs.getDate("FECHA"));
		pre.setMinutos(rs.getInt("MINUTOS"));
		pre.setTienda(rs.getInt("ID_TIENDA"));
		pre.setOrigen(rs.getInt("ORIGEN"));
		return pre;
	}

}