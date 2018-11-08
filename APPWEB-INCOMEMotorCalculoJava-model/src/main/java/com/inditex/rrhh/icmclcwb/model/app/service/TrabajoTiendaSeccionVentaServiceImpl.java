package com.inditex.rrhh.icmclcwb.model.app.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoTiendaSeccionVentaDto;
import com.inditex.rrhh.icmclcwb.api.app.service.TrabajoTiendaSeccionVentaService;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.dto.GetVentaTotalizadoResponseItemDTO;
import com.inditex.rrhh.icmclcwb.model.app.mapper.TrabajoTiendaSeccionVentaMapper;
import com.inditex.rrhh.icmclcwb.model.primary.entity.TrabajoTiendaSeccionVenta;
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
	public TrabajoTiendaSeccionVentaDto save(TrabajoTiendaSeccionVentaDto dto){
		LOG.info("TrabajoTiendaSeccionVentaDto[{}] :: Inicio :: TrabajoTiendaSeccionVentaDto.save(): {}", dto.getId(), dto);
		TrabajoTiendaSeccionVentaDto result = mapper.trabajoTiendaSeccionVentaToTrabajoTiendaSeccionVentaDto(trabajoTiendaSeccionVentaRepository.save(mapper.trabajoTiendaSeccionVentaDtoToTrabajoTiendaSeccionVenta(dto)));
		LOG.info("TrabajoTiendaSeccionVentaDto[{}] :: Fin :: TrabajoTiendaSeccionVentaDto.save(): {}", dto.getId(), dto);
		return result;
	} 
	
	@Override
	public CompletableFuture<Void> save(GetVentaTotalizadoResponseItemDTO dto, TrabajoDto trabajoDto){
		LOG.info("TrabajoTiendaSeccionVentaDto[] :: Inicio :: TrabajoTiendaSeccionVentaDto.save(): {}",  dto);
		TrabajoTiendaSeccionVentaDto result = mapper.trabajoTiendaSeccionVentaToTrabajoTiendaSeccionVentaDto(trabajoTiendaSeccionVentaRepository.save(mapper.getVentaTotalizadoResponseItemDTOToTrabajoTiendaSeccionVenta(dto, trabajoDto)));
		LOG.info("TrabajoTiendaSeccionVentaDto[{}] :: Fin :: TrabajoTiendaSeccionVentaDto.save(): {}", result.getId(), result);
		return CompletableFuture.completedFuture(null);
	}
	
	@Async
	@Override
	@Transactional
	public CompletableFuture<Void> save(List<GetVentaTotalizadoResponseItemDTO> dto , TrabajoDto trabajoDto){
		LOG.info("TrabajoTiendaSeccionVentaDto[] :: Inicio :: TrabajoTiendaSeccionVentaDto.save(): {}",  dto);
		List<TrabajoTiendaSeccionVenta> persist = mapper.getVentaTotalizadoReponseItemsDtoToTrabajoTiendaSeccionVentas(dto, trabajoDto);
		List<TrabajoTiendaSeccionVentaDto> result = mapper.trabajoTiendaSeccionVentasToTrabajoTiendaSeccionVentasDto(trabajoTiendaSeccionVentaRepository.save(persist));
		LOG.info("TrabajoTiendaSeccionVentaDto[] :: Fin :: TrabajoTiendaSeccionVentaDto.save(): {}", result);
		return CompletableFuture.completedFuture(null);
	}

}
