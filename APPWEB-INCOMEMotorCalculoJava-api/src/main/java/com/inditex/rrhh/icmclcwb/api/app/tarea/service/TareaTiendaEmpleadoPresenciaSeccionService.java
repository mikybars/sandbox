package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

import java.util.List;

import javax.validation.Valid;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaTiendaEmpleadoPresenciaSeccionDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detallecomisionable.dto.PtrPresenciaDetalleComisionableResultItemDto;

public interface TareaTiendaEmpleadoPresenciaSeccionService {

    List<TareaTiendaEmpleadoPresenciaSeccionDto> save(@Valid final List<PtrPresenciaDetalleComisionableResultItemDto> dtos, @Valid final TareaDto tareaDto);

}
