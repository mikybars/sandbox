package com.inditex.rrhh.icmclcwb.model.secondary.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.inditex.rrhh.icmclcwb.model.secondary.entity.PtrPresenciasMockTotalTiendaSeccion;

public class PtrPresenciasMockTotalTiendaSeccionRowMapper implements RowMapper<PtrPresenciasMockTotalTiendaSeccion> {

	@Override
	public PtrPresenciasMockTotalTiendaSeccion mapRow(ResultSet rs, int rowNum) throws SQLException {
		PtrPresenciasMockTotalTiendaSeccion pre = new PtrPresenciasMockTotalTiendaSeccion();
		pre.setFecha(rs.getDate("FECHA"));
		pre.setMinutos(rs.getInt("MINUTOS"));
		pre.setTienda(rs.getInt("ID_TIENDA"));
		pre.setSeccion(rs.getInt("ID_SECCION"));
		return pre;
	}
}