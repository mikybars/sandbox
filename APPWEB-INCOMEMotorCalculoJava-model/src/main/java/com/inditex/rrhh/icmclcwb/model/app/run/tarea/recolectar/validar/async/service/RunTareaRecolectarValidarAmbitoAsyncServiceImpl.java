package com.inditex.rrhh.icmclcwb.model.app.run.tarea.recolectar.validar.async.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaValidarDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.validar.async.service.RunTareaRecolectarValidarAmbitoAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.validar.service.RunTareaRecolectarValidarAmbitoService;

@Service
public class RunTareaRecolectarValidarAmbitoAsyncServiceImpl implements RunTareaRecolectarValidarAmbitoAsyncService {

    @Autowired
    private RunTareaRecolectarValidarAmbitoService runTareaRecolectarValidarAmbitoService;

    @Override
    public CompletableFuture<List<RunTareaValidarDto>> run(RunTareaDto runTarea) {
        return CompletableFuture.completedFuture(runTareaRecolectarValidarAmbitoService.run(runTarea));
    }

}
