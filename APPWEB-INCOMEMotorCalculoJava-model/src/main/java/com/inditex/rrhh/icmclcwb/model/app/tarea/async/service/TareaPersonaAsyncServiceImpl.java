package com.inditex.rrhh.icmclcwb.model.app.tarea.async.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaPersonaAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaPersonaService;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;

@Service
public class TareaPersonaAsyncServiceImpl implements TareaPersonaAsyncService {

    @Autowired
    private TareaPersonaService tareaPersonaService;

    @Override
    public CompletableFuture<Void> mergePersona(final RunTareaDto runTareaDto) {
        tareaPersonaService.mergePersona(runTareaDto);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

}
