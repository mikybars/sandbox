package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

import java.util.List;

import javax.validation.Valid;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaTiendaEstadoDto;

public interface TareaTiendaEstadoService {

	List<TareaTiendaEstadoDto> save(List<TareaTiendaEstadoDto> tareaTiendaEstadoDto, @Valid TareaDto tarea);

}
