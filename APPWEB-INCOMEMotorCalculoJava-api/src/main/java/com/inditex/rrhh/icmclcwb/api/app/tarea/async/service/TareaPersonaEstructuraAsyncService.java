package com.inditex.rrhh.icmclcwb.api.app.tarea.async.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.scheduling.annotation.Async;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaPersonaEstructuraDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.comisionempleado.dto.ComisionEmpleadoResultItemDto;

@Async("repositoryPrimaryExecutor")
public interface TareaPersonaEstructuraAsyncService {

    CompletableFuture<Void> save(final List<TareaPersonaEstructuraDto> tareaEmpleadoEstructura, final TareaDto tarea);

    CompletableFuture<Void> saveComisionEmpleadoResultItemDto(
            final List<ComisionEmpleadoResultItemDto> comisionEmpleadoResultItemDto, final TareaDto tarea);

}
