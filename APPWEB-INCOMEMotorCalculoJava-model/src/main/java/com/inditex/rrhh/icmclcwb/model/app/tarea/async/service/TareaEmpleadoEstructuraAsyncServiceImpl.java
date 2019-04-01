package com.inditex.rrhh.icmclcwb.model.app.tarea.async.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaEmpleadoEstructuraAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaEmpleadoEstructuraDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaEmpleadoEstructuraService;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericEmpleadoResultItemDto;

@Service
public class TareaEmpleadoEstructuraAsyncServiceImpl implements TareaEmpleadoEstructuraAsyncService {

    @Autowired
    private TareaEmpleadoEstructuraService tareaEmpleadoEstructuraService;

    
    @Override
    public CompletableFuture<Void> save(final List<TareaEmpleadoEstructuraDto> tareaEmpleadoEstructura,
            @Valid final TareaDto tarea) {
        tareaEmpleadoEstructuraService.save(tareaEmpleadoEstructura, tarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

    
    @Override
    public CompletableFuture<Void> saveGenericEmpleadoResultItemDto(
            final List<GenericEmpleadoResultItemDto> genericEmpleadoResultItemDto, @Valid final TareaDto tarea) {
        tareaEmpleadoEstructuraService.saveGenericEmpleadoResultItemDto(genericEmpleadoResultItemDto, tarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

}
