package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

import java.util.List;

import javax.validation.Valid;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaTiendaSeccionEmpleadoPresenciaDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detallecomisionable.dto.PtrPresenciaDetalleComisionableResultItemDto;

@Deprecated
public interface TareaTiendaSeccionEmpleadoPresenciaService {

	TareaTiendaSeccionEmpleadoPresenciaDto save(@Valid final TareaTiendaSeccionEmpleadoPresenciaDto item);

    List<TareaTiendaSeccionEmpleadoPresenciaDto> save(final List<PtrPresenciaDetalleComisionableResultItemDto> item, final TareaDto tarea);

}
