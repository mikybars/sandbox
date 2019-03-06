package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

import java.util.List;

import javax.validation.Valid;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaEmpleadoHistoricoDto;

public interface TareaEmpleadoHistoricoService {

    List<TareaEmpleadoHistoricoDto> save(List<TareaEmpleadoHistoricoDto> tareaEmpleadoHistorico,
            @Valid TareaDto tarea);


}
