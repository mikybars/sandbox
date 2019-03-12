package com.inditex.rrhh.icmclcwb.model.app.tarea.async.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaTiendaHistoricoAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaTiendaHistoricoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaTiendaHistoricoService;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericTiendaResultItemDto;

@Service
public class TareaTiendaHistoricoAsyncServiceImpl implements TareaTiendaHistoricoAsyncService {

    @Autowired
    private TareaTiendaHistoricoService tareaTiendaHistoricoService;

    @Async
    @Override
    public CompletableFuture<Void> save(final List<TareaTiendaHistoricoDto> tareaTiendaHistorico,
            final TareaDto tarea) {
        tareaTiendaHistoricoService.save(tareaTiendaHistorico, tarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

    @Async
    @Override
    public CompletableFuture<Void> saveGenericTiendaResultItemDto(
            final List<GenericTiendaResultItemDto> genericTiendaResultItemDto, final TareaDto tarea) {
        tareaTiendaHistoricoService.saveGenericTiendaResultItemDto(genericTiendaResultItemDto, tarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

}
