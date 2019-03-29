package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaHistoricoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaEmpleadoHistoricoDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericEmpleadoResultItemDto;

public interface TareaEmpleadoHistoricoService {

    List<TareaEmpleadoHistoricoDto> saveGenericEmpleadoResultItemDto(
            @Valid final List<GenericEmpleadoResultItemDto> genericEmpleadoResultItemDto, @Valid final TareaDto tarea);

    List<TareaEmpleadoHistoricoDto> save(@Valid final List<TareaEmpleadoHistoricoDto> tareaEmpleadoHistorico,
            @Valid final TareaDto tarea);

    List<IdPersonaDto> findIdPersonaByIdTareaAndIdOrigen(@NotNull final Long idTarea, @NotNull final String idOrigen);
    
    List<IdPersonaHistoricoDto> findIdPersonaHistoricoByIdTareaAndIdOrigen(@NotNull final Long idTarea, @NotNull final String idOrigen);
    
    List<IdPersonaLocalDto> findIdPersonaLocalByIdTareaAndIdOrigen(@NotNull final Long idTarea, @NotNull final String idOrigen);

}
