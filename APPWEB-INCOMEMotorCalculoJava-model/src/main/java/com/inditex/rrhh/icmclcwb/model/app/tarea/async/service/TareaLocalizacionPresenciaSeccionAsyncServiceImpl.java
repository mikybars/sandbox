package com.inditex.rrhh.icmclcwb.model.app.tarea.async.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaLocalizacionPresenciaSeccionAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaLocalizacionPresenciaSeccionService;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.totalizado.dto.PtrPresenciaTotalizadoResultItemDto;

@Service
public class TareaLocalizacionPresenciaSeccionAsyncServiceImpl implements TareaLocalizacionPresenciaSeccionAsyncService {

    @Autowired
    private TareaLocalizacionPresenciaSeccionService tareaLocalizacionPresenciaSeccionService;

    @Override
    public CompletableFuture<Void> save(List<PtrPresenciaTotalizadoResultItemDto> dto, TareaDto tarea) {
        tareaLocalizacionPresenciaSeccionService.save(dto, tarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }
    
    @Override
    public CompletableFuture<Void> compensar(@Valid final RunTareaDto runTarea) {
        tareaLocalizacionPresenciaSeccionService.compensar(runTarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }
    
    @Override
    public CompletableFuture<Void> updateActivo(@Valid final RunTareaDto runTarea) {
        tareaLocalizacionPresenciaSeccionService.updateActivo(runTarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

}
