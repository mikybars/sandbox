package com.inditex.rrhh.icmclcwb.model.secondary.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.inditex.rrhh.icmclcwb.model.secondary.entity.PresenciaDetalleMock;


public class PresenciaDetalleRowMapper implements RowMapper {

	@Override
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		PresenciaDetalleMock pre= new PresenciaDetalleMock();
		pre.setTipo(rs.getInt("ID_TIPO"));
		pre.setTienda(rs.getInt("ID_TIENDA"));
		pre.setFecha(rs.getDate("FECHA"));
		pre.setSeccion(rs.getInt("ID_SECCION"));
		pre.setPersona(rs.getInt("EMPLEADO"));
		pre.setMinutos(rs.getInt("MINUTOS"));
		pre.setModificado_income(rs.getBoolean("MODIFICADO_INCOME"));
		pre.setCadena(rs.getInt("CADENA"));
		return pre;
	}

}
