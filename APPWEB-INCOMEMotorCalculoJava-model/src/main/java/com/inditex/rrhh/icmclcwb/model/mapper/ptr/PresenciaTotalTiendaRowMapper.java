package com.inditex.rrhh.icmclcwb.model.mapper.ptr;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.inditex.rrhh.icmclcwb.model.secondary.entity.ptr.PresenciaTotalTiendaMock;

public class PresenciaTotalTiendaRowMapper implements RowMapper{

	@Override
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		PresenciaTotalTiendaMock pre = new PresenciaTotalTiendaMock();
		//List<Integer> listaTienda= new Lista
		pre.setTipo(rs.getInt("TIPO"));
		//pre.setTienda(rs.getInt("TIENDA"));
		pre.setFecha(rs.getDate("FECHA"));
		pre.setSeccion(rs.getInt("SECCION"));
		pre.setPersona(rs.getInt("PERSONA"));
		pre.setHoras(rs.getInt("HORAS"));
	
		return pre;
	}
	

}
