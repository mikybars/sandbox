package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.inditex.rrhh.icmclcwb.api.app.dto.IdLocalizacionDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdLocalizacionLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaLocalizacionHistoricoDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericTiendaResultItemDto;

public interface TareaLocalizacionHistoricoService {

    List<TareaLocalizacionHistoricoDto> save(@Valid final List<TareaLocalizacionHistoricoDto> tareaLocalizacionHistorico,
            @Valid final TareaDto tarea);

    List<TareaLocalizacionHistoricoDto> saveGenericTiendaResultItemDto(
            @Valid final List<GenericTiendaResultItemDto> genericTiendaResultItemDto, @Valid final TareaDto tarea);

    List<IdLocalizacionDto> findIdLocalizacionDtoByIdTareaAndIdOrigen(@NotNull final Long idTarea,
            @NotNull final String idOrigen);

    List<IdLocalizacionLocalDto> findIdLocalizacionLocalDtoByIdTareaAndIdOrigen(@NotNull final Long idTarea,
            @NotNull final String idOrigen);

    List<IdLocalizacionDto> findIdLocalizacionDtoByIdTareaAndIdOrigenInAmbito(@NotNull final Long idTarea,
            @NotNull final String idOrigen);

    List<IdLocalizacionLocalDto> findIdLocalizacionLocalDtoByIdTareaAndIdOrigenInAmbito(@NotNull final Long idTarea,
            @NotNull final String idOrigen);

}
