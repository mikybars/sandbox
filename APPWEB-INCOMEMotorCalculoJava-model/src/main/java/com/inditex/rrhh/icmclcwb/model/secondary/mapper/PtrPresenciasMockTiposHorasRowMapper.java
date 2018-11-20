package com.inditex.rrhh.icmclcwb.model.secondary.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.inditex.rrhh.icmclcwb.model.secondary.entity.PtrPresenciasMockTiposHoras;

public class PtrPresenciasMockTiposHorasRowMapper implements RowMapper<PtrPresenciasMockTiposHoras> {

	@Override
	public PtrPresenciasMockTiposHoras mapRow(ResultSet rs, int rowNum) throws SQLException {
		PtrPresenciasMockTiposHoras pre = new PtrPresenciasMockTiposHoras();
		pre.setTipoHora(rs.getInt("TIPO"));
		pre.setOrigen(rs.getInt("CCL_ID_ORIGEN"));
		pre.setExcluidoCalculo(rs.getBoolean("EXCLUIDOCALCULO"));
		pre.setExcluidoDenom(rs.getBoolean("EXCLUIDODENOM"));
		return pre;
	}

}