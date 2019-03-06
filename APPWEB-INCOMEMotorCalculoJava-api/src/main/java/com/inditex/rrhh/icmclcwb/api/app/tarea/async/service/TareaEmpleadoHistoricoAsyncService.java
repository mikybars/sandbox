package com.inditex.rrhh.icmclcwb.api.app.tarea.async.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import javax.validation.Valid;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaEmpleadoHistoricoDto;

public interface TareaEmpleadoHistoricoAsyncService {

    CompletableFuture<Void> save(final List<TareaEmpleadoHistoricoDto> tareaEmpleadoHistorico, @Valid TareaDto tarea);

}
