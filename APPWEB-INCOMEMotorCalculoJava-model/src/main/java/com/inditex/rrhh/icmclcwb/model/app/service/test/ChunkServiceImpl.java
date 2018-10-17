package com.inditex.rrhh.icmclcwb.model.app.service.test;

import com.inditex.rrhh.icmclcwb.api.app.service.ChunkService;
import com.inditex.rrhh.icmclcwb.api.app.service.Meta4Service;
import com.inditex.rrhh.icmclcwb.api.app.service.PTRVentaService;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.dto.GetVentaTotalizadoRequestDTO;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.dto.GetVentaTotalizadoResponseDTO;
import com.inditex.rrhh.icmclcwb.api.ws.meta4.dto.rrhhappwscincome.icm_ws_income.GetEmpleadosTiendaResultItemDTO;
import com.inditex.rrhh.icmclcwb.model.primary.repository.SessionRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import javax.validation.Valid;

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
	
	@Autowired
	private PTRVentaService ptrVentaService;
	
	@Autowired
	private SessionRepository sessionRepository;
	
	@Async
	@Override
	public CompletableFuture<List<GetEmpleadosTiendaResultItemDTO>> obtenerEmpleadosTienda(String idTienda) {
		List<GetEmpleadosTiendaResultItemDTO> result = new ArrayList<>();
		try {
			result = meta4Service.obtenerEmpleadosTienda(idTienda);
		} catch (Exception e) {
			LOG.error("Error no controlado", e);
		}
		return CompletableFuture.completedFuture(result);
	}

	@Async
	@Override
	public CompletableFuture<GetVentaTotalizadoResponseDTO> getVentaTotalizado(
					@Valid GetVentaTotalizadoRequestDTO getVentaTotalizadoRequest) {
		GetVentaTotalizadoResponseDTO result = new GetVentaTotalizadoResponseDTO();
		try {
			result = ptrVentaService.getVentaTotalizado(getVentaTotalizadoRequest);
		} catch (Exception e) {
			LOG.error("Error no controlado", e);
		}
		return CompletableFuture.completedFuture(result);
	}

}