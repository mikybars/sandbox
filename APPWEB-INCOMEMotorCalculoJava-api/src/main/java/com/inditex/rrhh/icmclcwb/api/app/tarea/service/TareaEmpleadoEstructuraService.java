package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

import java.util.List;

import javax.validation.Valid;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaEmpleadoEstructuraDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.comisionempleado.dto.ComisionEmpleadoResultItemDto;

public interface TareaEmpleadoEstructuraService {

    List<Long> findIdTipoCalculoByIdTarea(@Valid final Long idTarea);
    
    List<TareaEmpleadoEstructuraDto> save(final List<TareaEmpleadoEstructuraDto> tareaPersonaHistorico,
            @Valid final TareaDto tarea);

    List<TareaEmpleadoEstructuraDto> saveComisionEmpleadoResultItemDto(
            @Valid final List<ComisionEmpleadoResultItemDto> comisionEmpleadoResultItemDto, @Valid final TareaDto tarea);

}
