package com.inditex.rrhh.icmclcwb.api.app.tarea.async.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import javax.validation.Valid;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaEmpleadoHistoricoDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericEmpleadoResultItemDto;

public interface TareaEmpleadoHistoricoAsyncService {

    CompletableFuture<Void> saveGenericEmpleadoResultItemDto(final List<GenericEmpleadoResultItemDto> genericEmpleadoResultItemDto, @Valid final TareaDto tarea);
    
    CompletableFuture<Void> save(final List<TareaEmpleadoHistoricoDto> tareaEmpleadoHistorico, @Valid final TareaDto tarea);

}
