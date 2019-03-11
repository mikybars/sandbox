package com.inditex.rrhh.icmclcwb.model.app.tarea.async.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaEmpleadoHistoricoAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaEmpleadoHistoricoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaEmpleadoHistoricoService;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericEmpleadoResultItemDto;

@Service
public class TareaEmpleadoHistoricoAsyncServiceImpl implements TareaEmpleadoHistoricoAsyncService {

    @Autowired
    private TareaEmpleadoHistoricoService tareaEmpleadoHistoricoService;

    @Async
    @Override
    public CompletableFuture<Void> save(final List<TareaEmpleadoHistoricoDto> tareaEmpleadoHistorico,
            @Valid final TareaDto tarea) {
        tareaEmpleadoHistoricoService.save(tareaEmpleadoHistorico, tarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

    @Async
    @Override
    public CompletableFuture<Void> saveGenericEmpleadoResultItemDto(
            final List<GenericEmpleadoResultItemDto> genericEmpleadoResultItemDto, @Valid final TareaDto tarea) {
        tareaEmpleadoHistoricoService.saveGenericEmpleadoResultItemDto(genericEmpleadoResultItemDto, tarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

}
