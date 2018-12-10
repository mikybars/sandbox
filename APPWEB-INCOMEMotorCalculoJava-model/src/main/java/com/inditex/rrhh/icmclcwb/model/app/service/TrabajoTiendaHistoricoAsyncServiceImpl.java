package com.inditex.rrhh.icmclcwb.model.app.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoTiendaHistoricoDto;
import com.inditex.rrhh.icmclcwb.api.app.service.TrabajoTiendaHistoricoAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.service.TrabajoTiendaHistoricoService;

@Service
public class TrabajoTiendaHistoricoAsyncServiceImpl implements TrabajoTiendaHistoricoAsyncService {

	@Autowired
	private TrabajoTiendaHistoricoService trabajoTiendaHistoricoService;
    
    @Async
    @Override
    public CompletableFuture<Void> save(final List<TrabajoTiendaHistoricoDto> trabajoTiendaHistorico, final TrabajoDto trabajo) {
    	trabajoTiendaHistoricoService.save(trabajoTiendaHistorico, trabajo);
        return CompletableFuture.completedFuture(null);
    }
    
}
