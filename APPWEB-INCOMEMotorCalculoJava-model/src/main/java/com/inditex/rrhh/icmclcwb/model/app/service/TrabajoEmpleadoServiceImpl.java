package com.inditex.rrhh.icmclcwb.model.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.dto.EstadoTrabajoEmpleadoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoEmpleadoDto;
import com.inditex.rrhh.icmclcwb.api.app.service.TrabajoEmpleadoService;
import com.inditex.rrhh.icmclcwb.api.meta4.icm_ws_income.empleadostienda.dto.EmpleadosTiendaResultItemDto;
import com.inditex.rrhh.icmclcwb.model.primary.repository.TrabajoEmpleadoRepository;

@Service
@Validated
public class TrabajoEmpleadoServiceImpl implements TrabajoEmpleadoService{
	
	@Autowired
	Logger LOG;
	
	
	@Autowired
	TrabajoEmpleadoRepository trabajoEmpleadoRepository;
	
	@Override
	public TrabajoEmpleadoDto save(@Valid final TrabajoEmpleadoDto trabajoEmpleadoDto) {
		LOG.info("TrabajoEmpleado[{}] :: Inicio :: TrabajoEmpleadoService.save(): {}", trabajoEmpleadoDto.getId(), trabajoEmpleadoDto);
		TrabajoEmpleadoDto result = null;
//		trabajoEmpleadoMapper
//				.trabajoEmpleadoToTrabajoEmpleadoDto(trabajoEmpleadoRepository.save(trabajoEmpleadoMapper.trabajoEmpleadoDtoToTrabajoEmpleado(trabajoEmpleadoDto)));
		LOG.info("TrabajoEmpleado[{}] :: Fin :: TrabajoEmpleadoService.save(): {}", result.getId(), result);
		return null;
	}
	
	@Async
	@Override
	public CompletableFuture<Void> save(@Valid final List<EmpleadosTiendaResultItemDto> result, TrabajoDto trabajoDto) {
		LOG.info("TrabajoEmpleado[] :: Inicio :: TrabajoEmpleadoService.save(): {}", trabajoDto);

		List<TrabajoEmpleadoDto> dto = new ArrayList<>();
		for(EmpleadosTiendaResultItemDto e : result){
			TrabajoEmpleadoDto te = new TrabajoEmpleadoDto();
			te.setIdEmpleado(e.getIdEmpleado());
			te.setTrabajo(trabajoDto);
			te.setEstado(new EstadoTrabajoEmpleadoDto());
			te.getEstado().setId(1L);
			dto.add(te);
		}
		
//		List<TrabajoEmpleadoDto> saved = trabajoEmpleadoMapper.trabajoEmpleadosToTrabajoEmpleadosDto(trabajoEmpleadoRepository.save(trabajoEmpleadoMapper.trabajoEmpleadosDtoToTrabajoEmpleados(dto)));
		LOG.info("TrabajoEmpleado[] :: Fin :: TrabajoEmpleadoService.save(): {}", result);
		return CompletableFuture.completedFuture(null);
	}


}
