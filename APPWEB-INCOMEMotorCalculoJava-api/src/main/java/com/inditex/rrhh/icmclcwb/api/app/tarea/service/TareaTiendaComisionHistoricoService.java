package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

import java.util.List;

import javax.validation.Valid;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaTiendaComisionHistoricoDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericTiendaResultItemDto;

public interface TareaTiendaComisionHistoricoService {

    List<TareaTiendaComisionHistoricoDto> saveGenericTiendaResultItemDto(
            @Valid final List<GenericTiendaResultItemDto> genericTiendaResultItemDto, @Valid final TareaDto tarea);

    List<TareaTiendaComisionHistoricoDto> save(@Valid final List<TareaTiendaComisionHistoricoDto> tareaTiendaComisionHistorico,
            @Valid final TareaDto tarea);

}
