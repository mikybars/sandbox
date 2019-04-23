package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

import java.util.List;

import javax.validation.Valid;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaTiendaEmpleadoPresenciaSeccionDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detalle.dto.PtrPresenciaDetalleResultItemDto;

public interface TareaTiendaEmpleadoPresenciaSeccionService {

    List<TareaTiendaEmpleadoPresenciaSeccionDto> save(@Valid final List<PtrPresenciaDetalleResultItemDto> dtos,
            @Valid final TareaDto tareaDto);

}
