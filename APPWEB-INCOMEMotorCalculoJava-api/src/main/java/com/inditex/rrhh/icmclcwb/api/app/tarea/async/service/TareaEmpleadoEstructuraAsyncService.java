package com.inditex.rrhh.icmclcwb.api.app.tarea.async.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.scheduling.annotation.Async;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaEmpleadoEstructuraDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.comisionempleado.dto.ComisionEmpleadoResultItemDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericEmpleadoResultItemDto;

@Async("repositoryPrimaryExecutor")
public interface TareaEmpleadoEstructuraAsyncService {

    CompletableFuture<Void> save(final List<TareaEmpleadoEstructuraDto> tareaEmpleadoEstructura, final TareaDto tarea);

    CompletableFuture<Void> saveComisionEmpleadoResultItemDto(
            final List<ComisionEmpleadoResultItemDto> comisionEmpleadoResultItemDto, final TareaDto tarea);

}
