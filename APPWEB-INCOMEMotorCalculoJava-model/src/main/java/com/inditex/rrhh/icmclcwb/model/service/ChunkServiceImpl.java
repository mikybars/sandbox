package com.inditex.rrhh.icmclcwb.model.service;

import com.inditex.rrhh.icmclcwb.api.service.ChunkService;
import com.inditex.rrhh.icmclcwb.api.service.Meta4Service;
import com.inditex.rrhh.icmclcwb.api.ws.meta4.dto.rrhhappwscincome.icm_ws_income.GetEmpleadosTiendaResultItemDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class ChunkServiceImpl implements ChunkService {

	@Autowired
	private Logger LOG;
	
	@Autowired
	private Meta4Service meta4Service;
	
	@Async
	@Override
	public CompletableFuture<List<GetEmpleadosTiendaResultItemDTO>> obtenerEmpleadosTienda(String idTienda) {
		List<GetEmpleadosTiendaResultItemDTO> result = new ArrayList<GetEmpleadosTiendaResultItemDTO>();
		try {
			result = meta4Service.obtenerEmpleadosTienda(idTienda);
		} catch (Exception e) {
			LOG.error("Error no controlado", e);
		}
		return CompletableFuture.completedFuture(result);
	}

}