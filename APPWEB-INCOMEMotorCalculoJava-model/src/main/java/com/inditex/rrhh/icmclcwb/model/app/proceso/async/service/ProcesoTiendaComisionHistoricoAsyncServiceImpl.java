package com.inditex.rrhh.icmclcwb.model.app.proceso.async.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.inditex.rrhh.icmclcwb.api.app.proceso.async.service.ProcesoTiendaComisionHistoricoAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.proceso.dto.ProcesoTiendaComisionHistoricoDto;
import com.inditex.rrhh.icmclcwb.api.app.proceso.service.ProcesoTiendaComisionHistoricoService;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;

@Service
public class ProcesoTiendaComisionHistoricoAsyncServiceImpl implements ProcesoTiendaComisionHistoricoAsyncService {

    @Autowired
    private ProcesoTiendaComisionHistoricoService procesoTiendaComisionHistoricoService;

    @Async
    @Override
    public CompletableFuture<Void> save(final List<ProcesoTiendaComisionHistoricoDto> procesoTiendaComisionHistoricoDto) {
        procesoTiendaComisionHistoricoService.save(procesoTiendaComisionHistoricoDto);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }


}
