package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

import java.util.List;

import javax.validation.Valid;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaEmpleadoDto;

public interface TareaEmpleadoService {

    List<TareaEmpleadoDto> findByTarea(@Valid final TareaDto tarea);
    
    List<TareaEmpleadoDto> createTareaEmpleado(@Valid final TareaDto tarea, final List<TareaEmpleadoDto> tareaEmpleado);

}
