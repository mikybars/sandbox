package com.inditex.rrhh.icmclcwb.model.app.tarea.async.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaLocalizacionAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaLocalizacionService;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;

@Service
public class TareaLocalizacionAsyncServiceImpl implements TareaLocalizacionAsyncService {

    @Autowired
    private TareaLocalizacionService tareaLocalizacionService; 
    
    @Async
    @Override
    public CompletableFuture<Void> mergeLocalizacion(final RunTareaDto runTareaDto) {
        tareaLocalizacionService.mergeLocalizacion(runTareaDto);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }
}
