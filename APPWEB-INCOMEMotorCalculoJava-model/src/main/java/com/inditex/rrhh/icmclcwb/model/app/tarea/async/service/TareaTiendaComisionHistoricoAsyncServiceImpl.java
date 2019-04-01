package com.inditex.rrhh.icmclcwb.model.app.tarea.async.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaTiendaComisionHistoricoAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaTiendaComisionHistoricoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaTiendaComisionHistoricoService;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericTiendaResultItemDto;

@Service
public class TareaTiendaComisionHistoricoAsyncServiceImpl implements TareaTiendaComisionHistoricoAsyncService {

    @Autowired
    private TareaTiendaComisionHistoricoService tareaTiendaComisionHistoricoService;

    
    @Override
    public CompletableFuture<Void> save(final List<TareaTiendaComisionHistoricoDto> tareaTiendaComisionHistoricoDto, @Valid TareaDto tarea) {
        tareaTiendaComisionHistoricoService.save(tareaTiendaComisionHistoricoDto, tarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

    
    @Override
    public CompletableFuture<Void> saveGenericTiendaResultItemDto(final List<GenericTiendaResultItemDto> genericTiendaResultItemDto, @Valid TareaDto tarea) {
        tareaTiendaComisionHistoricoService.saveGenericTiendaResultItemDto(genericTiendaResultItemDto, tarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

}
