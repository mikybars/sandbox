package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

import java.util.List;

import javax.validation.Valid;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaPersonaEstructuraDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.comisionempleado.dto.ComisionEmpleadoResultItemDto;

public interface TareaPersonaEstructuraService {
   
    List<TareaPersonaEstructuraDto> merge(@Valid List<ComisionEmpleadoResultItemDto> comisionEmpleadoResultItemDto,
            @Valid TareaDto tarea);

    List<TareaPersonaEstructuraDto> save(@Valid List<TareaPersonaEstructuraDto> tareaPersonaEstructura,
            @Valid TareaDto tarea);

}
