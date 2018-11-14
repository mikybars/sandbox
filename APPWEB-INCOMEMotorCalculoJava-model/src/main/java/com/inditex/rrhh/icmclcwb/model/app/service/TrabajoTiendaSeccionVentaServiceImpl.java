package com.inditex.rrhh.icmclcwb.model.app.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoTiendaSeccionVentaDto;
import com.inditex.rrhh.icmclcwb.api.app.service.TrabajoTiendaSeccionVentaService;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.ventatotalizado.dto.GetVentaTotalizadoResponseItemDTO;
import com.inditex.rrhh.icmclcwb.model.app.mapper.TrabajoTiendaSeccionVentaMapper;
import com.inditex.rrhh.icmclcwb.model.primary.repository.TrabajoTiendaSeccionVentaRepository;

@Service
@Validated
public class TrabajoTiendaSeccionVentaServiceImpl implements TrabajoTiendaSeccionVentaService {

	@Autowired
	private Logger LOG;
	
	@Autowired
	private TrabajoTiendaSeccionVentaMapper mapper;
	
	@Autowired
	private TrabajoTiendaSeccionVentaRepository trabajoTiendaSeccionVentaRepository;
	
	@Override
	public TrabajoTiendaSeccionVentaDto save(@Valid final TrabajoTiendaSeccionVentaDto dto){
		LOG.info("TrabajoTiendaSeccionVentaDto[{}] :: Inicio :: TrabajoTiendaSeccionVentaService.save(): {}", dto.getId(), dto);
		TrabajoTiendaSeccionVentaDto result = mapper.trabajoTiendaSeccionVentaToTrabajoTiendaSeccionVentaDto(trabajoTiendaSeccionVentaRepository.save(mapper.trabajoTiendaSeccionVentaDtoToTrabajoTiendaSeccionVenta(dto)));
		LOG.info("TrabajoTiendaSeccionVentaDto[{}] :: Fin :: TrabajoTiendaSeccionVentaService.save(): {}", dto.getId(), dto);
		return result;
	} 
	
	@Override
	public CompletableFuture<Void> save(GetVentaTotalizadoResponseItemDTO dto, TrabajoDto trabajoDto){
		LOG.info("TrabajoTiendaSeccionVentaDto[] :: Inicio :: TrabajoTiendaSeccionVentaService.save(): {}",  dto);
		TrabajoTiendaSeccionVentaDto result = mapper.trabajoTiendaSeccionVentaToTrabajoTiendaSeccionVentaDto(trabajoTiendaSeccionVentaRepository.save(mapper.getVentaTotalizadoResponseItemDTOToTrabajoTiendaSeccionVenta(dto, trabajoDto)));
		LOG.info("TrabajoTiendaSeccionVentaDto[{}] :: Fin :: TrabajoTiendaSeccionVentaService.save(): {}", result.getId(), result);
		return CompletableFuture.completedFuture(null);
	}
	
	@Async
	@Override
	@Transactional(timeout = 60) //TODO: Revisar timeouts en transacciones
	public CompletableFuture<Void> save(List<GetVentaTotalizadoResponseItemDTO> dto , TrabajoDto trabajoDto){
		LOG.info("TrabajoTiendaSeccionVentaDto[] :: Inicio :: TrabajoTiendaSeccionVentaService.save(): {}",  dto);
		List<TrabajoTiendaSeccionVentaDto> result = mapper.trabajoTiendaSeccionVentasToTrabajoTiendaSeccionVentasDto(trabajoTiendaSeccionVentaRepository.save(mapper.getVentaTotalizadoReponseItemsDtoToTrabajoTiendaSeccionVentas(dto, trabajoDto)));
		LOG.info("TrabajoTiendaSeccionVentaDto[] :: Fin :: TrabajoTiendaSeccionVentaService.save(): {}", result);
		return CompletableFuture.completedFuture(null);
	}

}
