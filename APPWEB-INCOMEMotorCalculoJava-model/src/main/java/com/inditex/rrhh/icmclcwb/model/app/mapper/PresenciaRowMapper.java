package com.inditex.rrhh.icmclcwb.model.app.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class PresenciaRowMapper implements RowMapper {

	@Override
	public Object mapRow(ResultSet arg0, int arg1) throws SQLException {
		PresenciaResultExtractor extractor = new PresenciaResultExtractor();
		return extractor.extractData(arg0);
	}

}
