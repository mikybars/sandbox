package com.inditex.rrhh.icmclcwb.model.app.proceso.async.service;

import java.util.concurrent.CompletableFuture;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.proceso.async.service.ProcesoTiendaPresenciaSeccionAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.proceso.dto.ProcesoDto;
import com.inditex.rrhh.icmclcwb.api.app.proceso.service.ProcesoTiendaPresenciaSeccionService;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;

@Service
@Validated
public class ProcesoTiendaPresenciaSeccionAsyncServiceImpl implements ProcesoTiendaPresenciaSeccionAsyncService {

    @Autowired
    private ProcesoTiendaPresenciaSeccionService procesoTiendaPresenciaSeccionService;
    
    @Async
    @Override
    public CompletableFuture<Void> pivot(@Valid final ProcesoDto proceso)  {
        procesoTiendaPresenciaSeccionService.pivot(proceso);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }
}
