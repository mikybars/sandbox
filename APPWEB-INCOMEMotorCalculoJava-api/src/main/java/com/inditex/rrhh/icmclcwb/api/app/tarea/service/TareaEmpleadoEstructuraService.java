package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

import java.util.List;
import javax.validation.Valid;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaEmpleadoEstructuraDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericEmpleadoResultItemDto;

public interface TareaEmpleadoEstructuraService {

    List<Long> findIdTipoCalculoByIdTarea(@Valid final Long idTarea);
    
    List<TareaEmpleadoEstructuraDto> save(final List<TareaEmpleadoEstructuraDto> tareaPersonaHistorico,
            @Valid final TareaDto tarea);

    List<TareaEmpleadoEstructuraDto> saveGenericEmpleadoResultItemDto(
            @Valid final List<GenericEmpleadoResultItemDto> genericEmpleadoResultItemDto, @Valid final TareaDto tarea);

}
