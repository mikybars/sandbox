package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

import java.util.List;

import javax.validation.Valid;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaTiendaComisionHistoricoDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericTiendaResultItemDto;

public interface TareaTiendaComisionHistoricoService {


    List<TareaTiendaComisionHistoricoDto> saveGenericTiendaResultItemDto(
            List<GenericTiendaResultItemDto> genericTiendaResultItemDto, @Valid TareaDto tarea);

    List<TareaTiendaComisionHistoricoDto> save(@Valid List<TareaTiendaComisionHistoricoDto> tareaTiendaComisionHistorico,
            @Valid TareaDto tarea);

}
