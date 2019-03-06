package com.inditex.rrhh.icmclcwb.model.app.tarea.async.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaTiendaComisionHistoricoAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaTiendaComisionHistoricoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaTiendaComisionHistoricoService;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;

@Service
public class TareaTiendaComisionHistoricoAsyncServiceImpl implements TareaTiendaComisionHistoricoAsyncService {

    @Autowired
    private TareaTiendaComisionHistoricoService tareaTiendaComisionHistoricoService;

    @Async
    @Override
    public CompletableFuture<Void> save(final List<TareaTiendaComisionHistoricoDto> tareaTiendaComisionHistoricoDto) {
        tareaTiendaComisionHistoricoService.save(tareaTiendaComisionHistoricoDto);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }


}
