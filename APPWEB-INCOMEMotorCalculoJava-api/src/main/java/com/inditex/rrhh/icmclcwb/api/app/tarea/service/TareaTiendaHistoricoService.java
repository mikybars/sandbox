package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

import java.util.List;

import javax.validation.Valid;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaTiendaHistoricoDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericTiendaResultItemDto;

public interface TareaTiendaHistoricoService {

    List<TareaTiendaHistoricoDto> save(@Valid final List<TareaTiendaHistoricoDto> tareaTiendaHistorico, @Valid final TareaDto tarea);

    List<TareaTiendaHistoricoDto> saveGenericTiendaResultItemDto(final List<GenericTiendaResultItemDto> genericTiendaResultItemDto,
            @Valid final TareaDto tarea);

}
