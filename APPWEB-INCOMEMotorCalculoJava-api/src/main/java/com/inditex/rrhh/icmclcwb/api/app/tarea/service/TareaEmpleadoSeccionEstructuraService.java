package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

import java.util.List;

import javax.validation.Valid;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaEmpleadoSeccionEstructuraDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.comisionempleado.dto.ComisionEmpleadoResultItemDto;

public interface TareaEmpleadoSeccionEstructuraService {
    
    List<TareaEmpleadoSeccionEstructuraDto> save(final List<TareaEmpleadoSeccionEstructuraDto> tareaEmpleadoSeccionEstructura,
            @Valid final TareaDto tarea);
    
    List<TareaEmpleadoSeccionEstructuraDto> saveComisionEmpleadoResultItemDto(
            @Valid final List<ComisionEmpleadoResultItemDto> comisionEmpleadoResultItemDto, @Valid final TareaDto tarea);

}
