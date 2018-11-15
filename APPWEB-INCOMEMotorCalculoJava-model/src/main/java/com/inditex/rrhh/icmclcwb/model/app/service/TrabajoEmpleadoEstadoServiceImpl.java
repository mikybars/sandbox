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

import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoEmpleadoEstadoDto;
import com.inditex.rrhh.icmclcwb.api.app.service.TrabajoEmpleadoEstadoService;
import com.inditex.rrhh.icmclcwb.model.app.mapper.TrabajoEmpleadoEstadoMapper;
import com.inditex.rrhh.icmclcwb.model.primary.repository.TrabajoEmpleadoEstadoRepository;

@Service
@Validated
public class TrabajoEmpleadoEstadoServiceImpl implements TrabajoEmpleadoEstadoService {

	@Autowired
	private Logger LOG;

	@Autowired
	private TrabajoEmpleadoEstadoRepository trabajoEmpleadoEstadoRepository;

	@Autowired
	private TrabajoEmpleadoEstadoMapper trabajoEmpleadoEstadoMapper;

	@Override
	public TrabajoEmpleadoEstadoDto save(@Valid final TrabajoEmpleadoEstadoDto trabajoEmpleadoDto) {
		LOG.info("TrabajoEmpleadoEstado[{}] :: Inicio :: TrabajoEmpleadoEstadoService.save(): {}", trabajoEmpleadoDto.getId(),
				trabajoEmpleadoDto);
		TrabajoEmpleadoEstadoDto result = trabajoEmpleadoEstadoMapper.trabajoEmpleadoEstadoToTrabajoEmpleadoEstadoDto(
				trabajoEmpleadoEstadoRepository.save(trabajoEmpleadoEstadoMapper
						.trabajoEmpleadoEstadoDtoToTrabajoEmpleadoEstado(trabajoEmpleadoDto)));
		LOG.info("TrabajoEmpleadoEstado[{}] :: Fin :: TrabajoEmpleadoEstadoService.save(): {}", result.getId(), result);
		return result;
	}

	@Async
	@Override
	@Transactional
	public CompletableFuture<Void> save(@Valid final List<TrabajoEmpleadoEstadoDto> trabajoEmpleadoEstado) {
		LOG.info("TrabajoEmpleadoEstado[] :: Inicio :: TrabajoEmpleadoEstadoService.save(): {}", trabajoEmpleadoEstado);
		List<TrabajoEmpleadoEstadoDto> result = trabajoEmpleadoEstadoMapper
				.trabajoEmpleadoEstadoToTrabajoEmpleadoEstadoDto(
						trabajoEmpleadoEstadoRepository.save(trabajoEmpleadoEstadoMapper
								.trabajoEmpleadoEstadoDtoToTrabajoEmpleadoEstado(trabajoEmpleadoEstado)));
		LOG.info("TrabajoEmpleadoEstado[] :: Fin :: TrabajoEmpleadoEstadoService.save(): {}", result);
		return CompletableFuture.completedFuture(null);
	}
	
}