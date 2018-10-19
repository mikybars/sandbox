package com.inditex.rrhh.icmclcwb.model.app.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.inditex.rrhh.icmclcwb.api.dto.ptr.response.TiposHorasResponseDTO;

public class PresenciaResultExtractor implements ResultSetExtractor {

	@Override
	public Object extractData(ResultSet arg0) throws SQLException, DataAccessException {
		TiposHorasResponseDTO presencia = new TiposHorasResponseDTO();
		presencia.setOrigen(arg0.getInt(7));
		presencia.setTipoHora(arg0.getInt(1));
		return presencia;
	}

}
