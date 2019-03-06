package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaEmpleadoEstructuraDto;

public interface TareaEmpleadoEstructuraService {

    List<TareaEmpleadoEstructuraDto> save(final List<TareaEmpleadoEstructuraDto> tareaEmpleadoHistorico,
            @Valid TareaDto tarea); 
    
    Set<Long> findIdTipoCalculoByIdTarea(@Valid Long idTarea);
    

}
