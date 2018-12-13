package com.inditex.rrhh.icmclcwb.model.app.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoTiendaEstadoDto;
import com.inditex.rrhh.icmclcwb.api.app.service.TrabajoTiendaEstadoService;
import com.inditex.rrhh.icmclcwb.model.app.mapper.TrabajoTiendaEstadoMapper;
import com.inditex.rrhh.icmclcwb.model.primary.repository.TrabajoTiendaEstadoRepository;

@Service
@Validated
public class TrabajoTiendaEstadoServiceImpl implements TrabajoTiendaEstadoService {

	@Autowired
	private TrabajoTiendaEstadoRepository trabajoTiendaEstadoRepository;

	@Autowired
	private TrabajoTiendaEstadoMapper trabajoTiendaEstadoMapper;

	@Override
	public List<TrabajoTiendaEstadoDto> save(final List<TrabajoTiendaEstadoDto> trabajoTiendaEstadoDto,
			@Valid TrabajoDto trabajo) {
		return trabajoTiendaEstadoMapper.trabajoTiendaEstadoToTrabajoTiendaEstadoDto(trabajoTiendaEstadoRepository
				.save(trabajoTiendaEstadoMapper.mergeTrabajoTiendaEstadoDtoAndTrabajoDtoToTrabajoTiendaEstado(
						trabajoTiendaEstadoDto, trabajo)));
	}
	
}
