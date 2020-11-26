/**
 *
 */
package com.inditex.rrhh.icmclcwb.model.app.run.tarea.prevalidar.async.service;

import java.util.concurrent.CompletableFuture;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaPrevalidarDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.prevalidar.async.service.RunTareaPreValidarPresenciasAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.prevalidar.service.RunTareaPreValidarPresenciasService;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;

@Service
public class RunTareaPreValidarPresenciasAsyncServiceImpl implements RunTareaPreValidarPresenciasAsyncService {

    @Autowired
    private RunTareaPreValidarPresenciasService runTareaPreValidarPresenciasService;

    @Override
    public CompletableFuture<Void> run(@NotNull @Valid final RunTareaPrevalidarDto runTareaPrevalidarDto) {
        this.runTareaPreValidarPresenciasService.run(runTareaPrevalidarDto);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

}
