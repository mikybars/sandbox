package com.inditex.rrhh.icmclcwb.model.app.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoEmpleadoDto;
import com.inditex.rrhh.icmclcwb.api.app.service.TrabajoEmpleadoService;
import com.inditex.rrhh.icmclcwb.model.app.mapper.TrabajoEmpleadoMapper;
import com.inditex.rrhh.icmclcwb.model.primary.repository.TrabajoEmpleadoRepository;

@Service
@Validated
public class TrabajoEmpleadoServiceImpl implements TrabajoEmpleadoService{
	
	@Autowired
	Logger LOG;
	
	@Autowired
	TrabajoEmpleadoRepository trabajoEmpleadoRepository;
	
	@Autowired
	TrabajoEmpleadoMapper mapper;
	
	@Override
	public TrabajoEmpleadoDto save(@Valid final TrabajoEmpleadoDto trabajoEmpleadoDto) {
		LOG.info("TrabajoEmpleado[{}] :: Inicio :: TrabajoEmpleadoService.save(): {}", trabajoEmpleadoDto.getId(), trabajoEmpleadoDto);
		TrabajoEmpleadoDto result = mapper
				.trabajoEmpleadoToTrabajoEmpleadoDto(trabajoEmpleadoRepository.save(mapper.trabajoEmpleadoDtoToTrabajoEmpleado(trabajoEmpleadoDto)));
		LOG.info("TrabajoEmpleado[{}] :: Fin :: TrabajoEmpleadoService.save(): {}", result.getId(), result);
		return result;
	}
	
	@Async
	@Override
	@Transactional
	public CompletableFuture<Void> save(@Valid final List<TrabajoEmpleadoDto> trabajoEmpleadoDto) {
		LOG.info("TrabajoEmpleado :: Inicio :: TrabajoEmpleadoService.save(): {}", trabajoEmpleadoDto);
		List<TrabajoEmpleadoDto> saved = mapper.trabajoEmpleadoToTrabajoEmpleadoDto(
				trabajoEmpleadoRepository.save(
						mapper.trabajoEmpleadoDtoToTrabajoEmpleado(trabajoEmpleadoDto)));
		LOG.info("TrabajoEmpleado :: Fin :: TrabajoEmpleadoService.save(): {}", trabajoEmpleadoDto);
		return CompletableFuture.completedFuture(null);
	}



}
