package com.inditex.rrhh.icmclcwb.model.app.tarea.async.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaEmpleadoEstructuraAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaEmpleadoEstructuraDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaEmpleadoEstructuraService;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;

@Service
public class TareaEmpleadoEstructuraAsyncServiceImpl implements TareaEmpleadoEstructuraAsyncService {

    @Autowired
    private TareaEmpleadoEstructuraService tareaEmpleadoEstructuraService;
    
    @Async
    @Override
    public CompletableFuture<Void> save(final List<TareaEmpleadoEstructuraDto> tareaEmpleadoEstructura , @Valid TareaDto tarea) {
        tareaEmpleadoEstructuraService.save(tareaEmpleadoEstructura, tarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }
}
