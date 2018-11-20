package com.inditex.rrhh.icmclcwb.model.secondary.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.inditex.rrhh.icmclcwb.model.secondary.entity.PtrPresenciasMockTotalTienda;

public class PtrPresenciasMockTotalTiendaRowMapper implements RowMapper<PtrPresenciasMockTotalTienda> {

	@Override
	public PtrPresenciasMockTotalTienda mapRow(ResultSet rs, int rowNum) throws SQLException {
		PtrPresenciasMockTotalTienda pre = new PtrPresenciasMockTotalTienda();
		pre.setFecha(rs.getDate("FECHA"));
		pre.setMinutos(rs.getInt("MINUTOS"));
		pre.setTienda(rs.getInt("ID_TIENDA"));
		return pre;
	}

}