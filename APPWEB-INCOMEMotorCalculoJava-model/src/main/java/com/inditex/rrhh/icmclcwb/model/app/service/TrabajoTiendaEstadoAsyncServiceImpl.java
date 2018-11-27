package com.inditex.rrhh.icmclcwb.model.app.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoTiendaEstadoDto;
import com.inditex.rrhh.icmclcwb.api.app.service.TrabajoTiendaEstadoAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.service.TrabajoTiendaEstadoService;

@Service
public class TrabajoTiendaEstadoAsyncServiceImpl implements TrabajoTiendaEstadoAsyncService {

	@Autowired
	private TrabajoTiendaEstadoService trabajoTiendaEstadoService;
	
    @Async
    @Override
    public CompletableFuture<Void> save(final List<TrabajoTiendaEstadoDto> trabajoTiendaEstado) {
    	trabajoTiendaEstadoService.save(trabajoTiendaEstado);
        return CompletableFuture.completedFuture(null);
    }
    
    @Async
    @Override
    public CompletableFuture<Void> save(final List<TrabajoTiendaEstadoDto> trabajoTiendaEstado, final TrabajoDto trabajo) {
    	trabajoTiendaEstadoService.save(trabajoTiendaEstado, trabajo);
        return CompletableFuture.completedFuture(null);
    }
}
