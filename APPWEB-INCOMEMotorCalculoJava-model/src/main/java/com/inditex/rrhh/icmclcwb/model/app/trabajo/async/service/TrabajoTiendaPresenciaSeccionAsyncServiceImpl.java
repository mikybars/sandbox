package com.inditex.rrhh.icmclcwb.model.app.trabajo.async.service;

import java.util.concurrent.CompletableFuture;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.trabajo.async.service.TrabajoTiendaPresenciaSeccionAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.service.TrabajoTiendaPresenciaSeccionService;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;

@Service
@Validated
public class TrabajoTiendaPresenciaSeccionAsyncServiceImpl implements TrabajoTiendaPresenciaSeccionAsyncService {

    @Autowired
    private TrabajoTiendaPresenciaSeccionService trabajoTiendaPresenciaSeccionService;
    
    @Async
    @Override
    public CompletableFuture<Void> pivot(@Valid final TrabajoDto trabajoDto) throws Exception  {
        trabajoTiendaPresenciaSeccionService.pivot(trabajoDto);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }
}
