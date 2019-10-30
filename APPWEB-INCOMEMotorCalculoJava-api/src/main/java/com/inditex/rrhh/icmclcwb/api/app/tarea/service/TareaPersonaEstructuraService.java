package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

import java.util.List;

import javax.validation.Valid;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaPersonaEstructuraDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.comisionempleado.dto.ComisionEmpleadoResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.estructurascom.dto.EstructurasComResultItemDto;

public interface TareaPersonaEstructuraService {
   
    List<TareaPersonaEstructuraDto> save(@Valid List<TareaPersonaEstructuraDto> tareaPersonaEstructura,
            @Valid TareaDto tarea);

    List<TareaPersonaEstructuraDto> mergeEstructurasComResultItemDto(
            @Valid List<EstructurasComResultItemDto> estructurasComResultItemDto, @Valid TareaDto tarea);

}
