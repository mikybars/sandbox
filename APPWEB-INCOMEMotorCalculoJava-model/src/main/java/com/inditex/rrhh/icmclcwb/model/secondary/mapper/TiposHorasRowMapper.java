package com.inditex.rrhh.icmclcwb.model.secondary.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.inditex.rrhh.icmclcwb.model.secondary.entity.PresenciaDetalleMock;
import com.inditex.rrhh.icmclcwb.model.secondary.entity.TiposHorasMock;

public class TiposHorasRowMapper implements RowMapper{
	@Override
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		TiposHorasMock pre= new TiposHorasMock();
		pre.setTipoHora(rs.getInt("TIPO"));
		pre.setOrigen(rs.getInt("CCL_ID_ORIGEN"));
		pre.setExcluidoCalculo(rs.getBoolean("EXCLUIDOCALCULO"));
		pre.setExcluidoDenom(rs.getBoolean("EXCLUIDODENOM"));
		return pre;
	}
	

}
