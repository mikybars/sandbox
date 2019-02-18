package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

import java.util.List;

import javax.validation.Valid;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaTiendaHistoricoDto;

public interface TareaTiendaHistoricoService {

	List<TareaTiendaHistoricoDto> save(List<TareaTiendaHistoricoDto> tareaTiendaHistorico,
			@Valid TareaDto tarea);

}
