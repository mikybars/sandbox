package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

import java.util.List;

import javax.validation.Valid;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaLocalizacionComisionHistoricoDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericTiendaResultItemDto;

public interface TareaLocalizacionComisionHistoricoService {

    List<TareaLocalizacionComisionHistoricoDto> saveGenericTiendaResultItemDto(
            @Valid final List<GenericTiendaResultItemDto> genericTiendaResultItemDto, @Valid final TareaDto tarea);

    List<TareaLocalizacionComisionHistoricoDto> save(@Valid final List<TareaLocalizacionComisionHistoricoDto> tareaLocalizacionComisionHistorico,
            @Valid final TareaDto tarea);

}
