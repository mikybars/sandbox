package com.inditex.rrhh.icmclcwb.model.app.service;

import java.util.concurrent.CompletableFuture;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.service.TrabajoTiendaVentaSeccionAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.service.TrabajoTiendaVentaSeccionService;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;

@Service
@Validated
public class TrabajoTiendaVentaSeccionAsyncServiceImpl implements TrabajoTiendaVentaSeccionAsyncService {

    @Autowired
    private TrabajoTiendaVentaSeccionService trabajoTiendaVentaSeccionService;
    
    @Async
    @Override
    public CompletableFuture<Void> pivot(@Valid TrabajoDto trabajoDto) throws Exception  {
        trabajoTiendaVentaSeccionService.pivot(trabajoDto);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }
    
}
