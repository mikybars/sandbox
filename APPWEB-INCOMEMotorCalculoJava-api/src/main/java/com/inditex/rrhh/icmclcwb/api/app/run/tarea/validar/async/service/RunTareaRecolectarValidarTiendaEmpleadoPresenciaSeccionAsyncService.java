package com.inditex.rrhh.icmclcwb.api.app.run.tarea.validar.async.service;

import java.util.concurrent.CompletableFuture;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;

public interface RunTareaRecolectarValidarTiendaEmpleadoPresenciaSeccionAsyncService {

    CompletableFuture<Void> run(@NotNull @Valid RunTareaDto runTarea);

}
