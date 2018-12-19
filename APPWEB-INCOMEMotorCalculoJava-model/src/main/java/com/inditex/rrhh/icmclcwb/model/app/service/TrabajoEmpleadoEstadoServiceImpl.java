package com.inditex.rrhh.icmclcwb.model.app.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoEmpleadoEstadoDto;
import com.inditex.rrhh.icmclcwb.api.app.service.TrabajoEmpleadoEstadoService;
import com.inditex.rrhh.icmclcwb.model.app.mapper.TrabajoEmpleadoEstadoMapper;
import com.inditex.rrhh.icmclcwb.model.primary.repository.TrabajoEmpleadoEstadoRepository;

@Service
@Validated
public class TrabajoEmpleadoEstadoServiceImpl implements TrabajoEmpleadoEstadoService {

	@Autowired
	private TrabajoEmpleadoEstadoRepository trabajoEmpleadoEstadoRepository;

	@Autowired
	private TrabajoEmpleadoEstadoMapper trabajoEmpleadoEstadoMapper;

	// TODO: Revisar timeouts
	@Transactional(timeout = 60)
	@Override
	public List<TrabajoEmpleadoEstadoDto> save(@Valid final List<TrabajoEmpleadoEstadoDto> trabajoEmpleadoEstado) {
		return trabajoEmpleadoEstadoMapper.trabajoEmpleadoEstadoToTrabajoEmpleadoEstadoDto(
				trabajoEmpleadoEstadoRepository.save(trabajoEmpleadoEstadoMapper
						.trabajoEmpleadoEstadoDtoToTrabajoEmpleadoEstado(trabajoEmpleadoEstado)));
	}

	// TODO: Revisar timeouts
	@Transactional(timeout = 60)
	@Override
	public List<TrabajoEmpleadoEstadoDto> save(@Valid final List<TrabajoEmpleadoEstadoDto> trabajoEmpleadoEstado,
			@Valid final TrabajoDto trabajo) {
		return trabajoEmpleadoEstadoMapper
				.trabajoEmpleadoEstadoToTrabajoEmpleadoEstadoDto(trabajoEmpleadoEstadoRepository.save(
						trabajoEmpleadoEstadoMapper.mergeTrabajoEmpleadoEstadoDtoAndTrabajoDtoToTrabajoEmpleadoEstado(
								trabajoEmpleadoEstado, trabajo)));
	}

	@Override
	public List<Long> findIdsEmpleadoByIdTrabajo(Long trabajoId, Long idEstado) {
		return trabajoEmpleadoEstadoRepository.findIdsEmpleadoByIdTrabajo(trabajoId, idEstado);		 
	}
	
	
	
}