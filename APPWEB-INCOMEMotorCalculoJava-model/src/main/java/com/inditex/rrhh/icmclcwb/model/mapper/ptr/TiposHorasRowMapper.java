package com.inditex.rrhh.icmclcwb.model.mapper.ptr;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.inditex.rrhh.icmclcwb.model.secondary.entity.ptr.PresenciaDetalleMock;
import com.inditex.rrhh.icmclcwb.model.secondary.entity.ptr.TiposHorasMock;

public class TiposHorasRowMapper implements RowMapper{
	@Override
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		TiposHorasMock pre= new TiposHorasMock();
		pre.setTipo(rs.getInt("TIPO"));
		pre.setOrigen(rs.getInt("CCL_ID_ORIGEN"));
		pre.setExcluidoCalculo(rs.getBoolean("EXCLUIDOCALCULO"));
		pre.setExcluidoDenom(rs.getBoolean("EXCLUIDODENOM"));
		return pre;
	}
	

}
