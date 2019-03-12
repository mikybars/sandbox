package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

import java.util.List;
import java.util.Set;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaEmpleadoHistoricoDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericEmpleadoResultItemDto;

public interface TareaEmpleadoHistoricoService {

    List<TareaEmpleadoHistoricoDto> saveGenericEmpleadoResultItemDto(
            final List<GenericEmpleadoResultItemDto> genericEmpleadoResultItemDto, @Valid final TareaDto tarea);

    List<TareaEmpleadoHistoricoDto> save(@Valid final List<TareaEmpleadoHistoricoDto> tareaEmpleadoHistorico,
            @Valid final TareaDto tarea);

    Set<String> findIdEmpleadoByIdTareaAndIdOrigen(@NotNull final Long idTarea, @NotNull final String idOrigen);

}
