package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaTiendaEstadoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaTiendaEstadoService;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaTiendaEstadoMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaTiendaEstadoRepositoryCustom;

@Service
@Validated
public class TareaTiendaEstadoServiceImpl implements TareaTiendaEstadoService {
	
	@Autowired
	private TareaTiendaEstadoRepositoryCustom tareaTiendaEstadoRepositoryCustom;

	@Autowired
	private TareaTiendaEstadoMapper tareaTiendaEstadoMapper;

	@Override
	public List<TareaTiendaEstadoDto> save(@Valid final List<TareaTiendaEstadoDto> tareaTiendaEstadoDto,
			@Valid final TareaDto tarea) {
		return tareaTiendaEstadoMapper.tareaTiendaEstadoToTareaTiendaEstadoDto(tareaTiendaEstadoRepositoryCustom
				.save(tareaTiendaEstadoMapper.mergeTareaTiendaEstadoDtoAndTareaDtoToTareaTiendaEstado(
						tareaTiendaEstadoDto, tarea)));
	}
	
}
