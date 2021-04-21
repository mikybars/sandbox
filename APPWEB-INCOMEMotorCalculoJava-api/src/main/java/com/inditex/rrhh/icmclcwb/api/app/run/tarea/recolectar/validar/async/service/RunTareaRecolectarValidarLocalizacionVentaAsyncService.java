package com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.validar.async.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.scheduling.annotation.Async;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaValidarDto;

@Async
public interface RunTareaRecolectarValidarLocalizacionVentaAsyncService {

    CompletableFuture<List<RunTareaValidarDto>> run(RunTareaDto runTarea);

}
