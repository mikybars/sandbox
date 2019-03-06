package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaTiendaHistoricoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaTiendaHistoricoService;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaTiendaHistoricoMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaTiendaHistoricoRepositoryCustom;

@Service
@Validated
public class TareaTiendaHistoricoServiceImpl implements TareaTiendaHistoricoService {

	@Autowired
	private TareaTiendaHistoricoRepositoryCustom tareaTiendaHistoricoRepositoryCustom;

	@Autowired
	private TareaTiendaHistoricoMapper tareaTiendaHistoricoMapper;


	@Override
	public List<TareaTiendaHistoricoDto> save(final List<TareaTiendaHistoricoDto> tareaTiendaHistorico,
			@Valid TareaDto tarea) {
		return tareaTiendaHistoricoMapper.tareaTiendaHistoricoToTareaTiendaHistoricoDto(
		        tareaTiendaHistoricoRepositoryCustom.save(tareaTiendaHistoricoMapper
						.mergeTareaTiendaHistoricoDtoAndTareaDtoToTareaTiendaHistorico(tareaTiendaHistorico,
								tarea)));
	}
}
