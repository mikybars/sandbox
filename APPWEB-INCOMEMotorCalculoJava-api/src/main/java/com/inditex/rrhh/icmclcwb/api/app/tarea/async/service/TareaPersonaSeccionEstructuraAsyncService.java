package com.inditex.rrhh.icmclcwb.api.app.tarea.async.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.scheduling.annotation.Async;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaPersonaSeccionEstructuraDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.comisionempleado.dto.ComisionEmpleadoResultItemDto;

@Async("repositoryPrimaryExecutor")
public interface TareaPersonaSeccionEstructuraAsyncService {

    CompletableFuture<Void> save(final List<TareaPersonaSeccionEstructuraDto> tareaEmpleadoEstructura, final TareaDto tareaDto);
    
    CompletableFuture<Void> saveComisionEmpleadoResultItemDto(
            final List<ComisionEmpleadoResultItemDto> comisionEmpleadoResultItemDto, final TareaDto tareaDto);
}
