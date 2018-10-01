package com.inditex.rrhh.icmclcwb.model.service;

import com.inditex.rrhh.icmclcwb.api.service.ChunkService;
import com.inditex.rrhh.icmclcwb.api.service.Meta4Service;
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
	public CompletableFuture<Boolean> obtenerEmpleadosTienda(String idTienda) {
		Boolean result = Boolean.FALSE;
		try {
			meta4Service.obtenerEmpleadosTienda(idTienda);
			result = Boolean.TRUE;
		} catch (Exception e) {
			LOG.error("Error no controlado", e);
		}
		return CompletableFuture.completedFuture(result);
	}

}