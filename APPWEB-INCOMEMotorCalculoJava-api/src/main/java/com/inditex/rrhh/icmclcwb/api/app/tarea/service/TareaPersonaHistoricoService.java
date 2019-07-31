package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaHistoricoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaPersonaHistoricoDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericEmpleadoResultItemDto;

public interface TareaPersonaHistoricoService {

    List<TareaPersonaHistoricoDto> merge(
            @Valid final List<GenericEmpleadoResultItemDto> genericEmpleadoResultItemDto, @Valid final TareaDto tarea);

    List<TareaPersonaHistoricoDto> save(@Valid final List<TareaPersonaHistoricoDto> tareaEmpleadoHistorico);

    List<IdPersonaDto> findIdPersonaByIdTareaAndIdOrigenInAmbito(@NotNull final Long idTarea, @NotNull final String cclIdOrigen);
    
    List<IdPersonaHistoricoDto> findIdPersonaHistoricoByIdTareaAndIdOrigen(@NotNull final Long idTarea, @NotNull final String cclIdOrigen);
    
    List<IdPersonaLocalDto> findIdPersonaLocalByIdTareaAndIdOrigen(@NotNull final Long idTarea, @NotNull final String cclIdOrigen);

    List<IdPersonaHistoricoDto> findIdPersonaHistoricoDtoByIdTareaAndIdOrigenAndTipoDatoInAmbito(@NotNull final Long idTarea,
            @NotNull final String cclIdOrigen, @NotNull final List<Integer> idsTipoDato);

    List<IdPersonaHistoricoDto> findIdPersonaHistoricoDtoByIdTareaAndIdOrigenInAmbito(@NotNull final Long idTarea,
            @NotNull final String cclIdOrigen);

}
