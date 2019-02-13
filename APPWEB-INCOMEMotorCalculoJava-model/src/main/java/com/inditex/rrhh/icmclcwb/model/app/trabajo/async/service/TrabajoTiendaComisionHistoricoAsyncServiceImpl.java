package com.inditex.rrhh.icmclcwb.model.app.trabajo.async.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.inditex.rrhh.icmclcwb.api.app.trabajo.async.service.TrabajoTiendaComisionHistoricoAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoTiendaComisionHistoricoDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.service.TrabajoTiendaComisionHistoricoService;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;

@Service
public class TrabajoTiendaComisionHistoricoAsyncServiceImpl implements TrabajoTiendaComisionHistoricoAsyncService {

    @Autowired
    private TrabajoTiendaComisionHistoricoService trabajoTiendaComisionHistoricoService;

    @Async
    @Override
    public CompletableFuture<Void> save(final List<TrabajoTiendaComisionHistoricoDto> trabajoTiendaComisionHistoricoDto) {
        trabajoTiendaComisionHistoricoService.save(trabajoTiendaComisionHistoricoDto);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }


}
