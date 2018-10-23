package com.inditex.rrhh.icmclcwb.model.app.service.test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.dto.JobDto;
import com.inditex.rrhh.icmclcwb.api.app.service.ChunkService;
import com.inditex.rrhh.icmclcwb.api.app.service.Meta4Service;
import com.inditex.rrhh.icmclcwb.api.app.service.PTRVentaService;
import com.inditex.rrhh.icmclcwb.api.meta4.empleadosestructura.dto.EmpleadosEstructuraRequestDTO;
import com.inditex.rrhh.icmclcwb.api.meta4.empleadosestructura.dto.EmpleadosEstructuraResultItemDTO;
import com.inditex.rrhh.icmclcwb.api.meta4.empleadostienda.dto.EmpleadosTiendaRequestDTO;
import com.inditex.rrhh.icmclcwb.api.meta4.empleadostienda.dto.EmpleadosTiendaResultItemDTO;
import com.inditex.rrhh.icmclcwb.api.meta4.valorescondiciones.dto.ValoresCondicionesRequestDTO;
import com.inditex.rrhh.icmclcwb.api.meta4.valorescondiciones.dto.ValoresCondicionesResultItemDTO;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.dto.GetVentaTotalizadoRequestDTO;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.dto.GetVentaTotalizadoResponseDTO;
import com.inditex.rrhh.icmclcwb.model.primary.repository.SessionRepository;

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
	public CompletableFuture<List<EmpleadosTiendaResultItemDTO>> getEmpleadosTienda(JobDto jobDto) {
		List<EmpleadosTiendaResultItemDTO> result = new ArrayList<>();
		try {
			result = meta4Service.getEmpleadosTienda(jobDto);
		} catch (Exception e) {
			LOG.error("Error no controlado", e);
		}
		return CompletableFuture.completedFuture(result);
	}
	@Async
	@Override
	public CompletableFuture<List<EmpleadosTiendaResultItemDTO>> getEmpleadosTienda(@Valid EmpleadosTiendaRequestDTO request){
		List<EmpleadosTiendaResultItemDTO> result = new ArrayList<>();
		try {
			result = meta4Service.getEmpleadosTienda(request);
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

	@Async
	@Override
	public CompletableFuture<List<EmpleadosEstructuraResultItemDTO>> getEmpleadosEstructura(@Valid EmpleadosEstructuraRequestDTO request){
		List<EmpleadosEstructuraResultItemDTO> result = new ArrayList<>();
			
		try {
			result = meta4Service.getEmpleadosEstructura(request);
		} catch (Exception e) {
			LOG.error("Error no controlado", e);
		}
		return CompletableFuture.completedFuture(result);
	}
	
	@Async
	@Override
	public CompletableFuture<List<ValoresCondicionesResultItemDTO>> getValoresCondiciones(@Valid ValoresCondicionesRequestDTO request){
		List<ValoresCondicionesResultItemDTO> result = new ArrayList<>();
		
		try {
			result = meta4Service.getValoresCondiciones(request);
		} catch (Exception e) {
			LOG.error("Error no controlado", e);		
		}
		return CompletableFuture.completedFuture(result);
		
	}
}