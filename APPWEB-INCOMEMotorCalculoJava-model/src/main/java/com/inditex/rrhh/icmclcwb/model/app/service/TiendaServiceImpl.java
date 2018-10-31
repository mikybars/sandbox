package com.inditex.rrhh.icmclcwb.model.app.service;

import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.stream.LongStream;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.retry.annotation.Retryable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.service.TiendaService;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.empleadostienda.dto.EmpleadosTiendaResultItemDto;

@Service
@Validated
public class TiendaServiceImpl implements TiendaService {
	
	@Autowired
	private Logger LOG;
	
	@Async
	@Override
	public CompletableFuture<Void> save(List<EmpleadosTiendaResultItemDto> result, TrabajoDto trabajoDto) throws Exception {
		LOG.info("Tienda[{}] :: Inicio :: TiendaService.save() - {}" , result.get(0).getIdEmpleado());
		Random random = new Random();
		LongStream ls = random.longs(10000, 50000);
		long time = ls.findFirst().getAsLong();
		ls.close();
		Thread.sleep(time);
		LOG.info("Tienda[{}] :: Fin :: TiendaService.save() - {}" , result.get(0).getIdEmpleado());
		return CompletableFuture.completedFuture(null);
	}

}
