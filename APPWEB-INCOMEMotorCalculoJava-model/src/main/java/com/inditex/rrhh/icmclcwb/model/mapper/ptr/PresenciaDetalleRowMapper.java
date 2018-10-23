package com.inditex.rrhh.icmclcwb.model.mapper.ptr;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.inditex.rrhh.icmclcwb.model.secondary.entity.ptr.PresenciaDetalleMock;


public class PresenciaDetalleRowMapper implements RowMapper {

	@Override
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		PresenciaDetalleMock pre= new PresenciaDetalleMock();
        //pre.setId(rs.getLong("ID"));
		pre.setTipo(rs.getInt("TIPO"));
		pre.setTienda(rs.getInt("TIENDA"));
		pre.setFecha(rs.getDate("FECHA"));
		pre.setSeccion(rs.getInt("SECCION"));
		pre.setPersona(rs.getInt("PERSONA"));
		pre.setMinutos(rs.getInt("MINUTOS"));
		pre.setModificado_income(rs.getBoolean("MODIFICADO_INCOME"));
		return pre;
	}

}
