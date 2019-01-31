package com.inditex.rrhh.icmclcwb.model.app.trabajo.async.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.inditex.rrhh.icmclcwb.api.app.trabajo.async.service.TrabajoTiendaHistoricoAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoTiendaHistoricoDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.service.TrabajoTiendaHistoricoService;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;

@Service
public class TrabajoTiendaHistoricoAsyncServiceImpl implements TrabajoTiendaHistoricoAsyncService {

	@Autowired
	private TrabajoTiendaHistoricoService trabajoTiendaHistoricoService;
    
    @Async
    @Override
    public CompletableFuture<Void> save(final List<TrabajoTiendaHistoricoDto> trabajoTiendaHistorico, final TrabajoDto trabajo) throws Exception {
    	trabajoTiendaHistoricoService.save(trabajoTiendaHistorico, trabajo);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }
    
}
