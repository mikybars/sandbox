package com.inditex.rrhh.icmclcwb.model.app.proceso.async.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import com.inditex.rrhh.icmclcwb.api.app.proceso.async.service.ProcesoTiendaVentaSeccionAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.proceso.dto.ProcesoDto;
import com.inditex.rrhh.icmclcwb.api.app.proceso.service.ProcesoTiendaVentaSeccionService;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;

@Service
public class ProcesoTiendaVentaSeccionAsyncServiceImpl implements ProcesoTiendaVentaSeccionAsyncService {

    @Autowired
    private ProcesoTiendaVentaSeccionService procesoTiendaVentaSeccionService;
    
    @Async
    @Override
    public CompletableFuture<Void> pivot(final ProcesoDto proceso)  {
        procesoTiendaVentaSeccionService.pivot(proceso);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }
    
}
