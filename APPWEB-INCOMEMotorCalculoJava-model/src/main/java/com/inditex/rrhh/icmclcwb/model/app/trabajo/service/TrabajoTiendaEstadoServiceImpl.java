package com.inditex.rrhh.icmclcwb.model.app.trabajo.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoTiendaEstadoDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.service.TrabajoTiendaEstadoService;
import com.inditex.rrhh.icmclcwb.model.app.trabajo.mapper.TrabajoTiendaEstadoMapper;
import com.inditex.rrhh.icmclcwb.model.primary.repository.TrabajoTiendaEstadoRepositoryCustom;

@Service
@Validated
public class TrabajoTiendaEstadoServiceImpl implements TrabajoTiendaEstadoService {
	
	@Autowired
	private TrabajoTiendaEstadoRepositoryCustom trabajoTiendaEstadoRepositoryCustom;

	@Autowired
	private TrabajoTiendaEstadoMapper trabajoTiendaEstadoMapper;

	@Override
	public List<TrabajoTiendaEstadoDto> save(final List<TrabajoTiendaEstadoDto> trabajoTiendaEstadoDto,
			@Valid TrabajoDto trabajo) throws Exception {
		return trabajoTiendaEstadoMapper.trabajoTiendaEstadoToTrabajoTiendaEstadoDto(trabajoTiendaEstadoRepositoryCustom
				.save(trabajoTiendaEstadoMapper.mergeTrabajoTiendaEstadoDtoAndTrabajoDtoToTrabajoTiendaEstado(
						trabajoTiendaEstadoDto, trabajo)));
	}
	
}
