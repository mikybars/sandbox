package com.inditex.rrhh.icmclcwb.api.app.tarea.async.service;

import java.util.concurrent.CompletableFuture;

import javax.validation.Valid;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;

public interface TareaTiendaPresenciaSeccionAsyncService {

    CompletableFuture<Void> pivot(@Valid final TareaDto tarea);

}
