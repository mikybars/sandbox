package com.inditex.rrhh.icmclcwb.api.app.tarea.async.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import javax.validation.Valid;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaEmpleadoEstructuraDto;

public interface TareaEmpleadoEstructuraAsyncService {

    CompletableFuture<Void> save(final List<TareaEmpleadoEstructuraDto> tareaEmpleadoEstructura,
            @Valid TareaDto tarea);

}
