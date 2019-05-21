package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

import java.util.List;

import javax.validation.Valid;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaTiendaEmpleadoSeccionPresenciaDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detalle.dto.PtrPresenciaDetalleResultItemDto;

public interface TareaTiendaEmpleadoSeccionPresenciaService {

    List<TareaTiendaEmpleadoSeccionPresenciaDto> save(@Valid final List<PtrPresenciaDetalleResultItemDto> dtos,
            @Valid final TareaDto tareaDto);
    
}
