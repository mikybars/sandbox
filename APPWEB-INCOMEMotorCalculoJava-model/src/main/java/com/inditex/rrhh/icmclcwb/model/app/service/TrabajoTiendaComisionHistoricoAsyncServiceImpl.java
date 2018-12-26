package com.inditex.rrhh.icmclcwb.model.app.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoTiendaComisionHistoricoDto;
import com.inditex.rrhh.icmclcwb.api.app.service.TrabajoTiendaComisionHistoricoAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.service.TrabajoTiendaComisionHistoricoService;

@Service
public class TrabajoTiendaComisionHistoricoAsyncServiceImpl implements TrabajoTiendaComisionHistoricoAsyncService {

    @Autowired
    private TrabajoTiendaComisionHistoricoService trabajoTiendaComisionHistoricoService;

    @Async
    @Override
    public CompletableFuture<Void> save(final List<TrabajoTiendaComisionHistoricoDto> trabajoTiendaComisionHistoricoDto) throws Exception {
        trabajoTiendaComisionHistoricoService.save(trabajoTiendaComisionHistoricoDto);
        return CompletableFuture.completedFuture(null);
    }


}
