package com.inditex.rrhh.icmclcwb.model.app.tarea.async.service;

import java.util.concurrent.CompletableFuture;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaOperacionPersonaLocalizacionVentaAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaOperacionPersonaLocalizacionVentaService;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.individualdetalle.dto.PtrVentaIndividualDetalleResponseDto;

@Service
public class TareaOperacionPersonaLocalizacionVentaAsyncServiceImpl
        implements TareaOperacionPersonaLocalizacionVentaAsyncService {

    @Autowired
    private TareaOperacionPersonaLocalizacionVentaService tareaOperacionPersonaLocalizacionVentaService;
    
    @Async
    @Override
    public CompletableFuture<Void> savePtrVentaIndividualDetalleResponse(final PtrVentaIndividualDetalleResponseDto dto, @Valid final TareaDto tarea)  {
        tareaOperacionPersonaLocalizacionVentaService.savePtrVentaIndividualDetalleResponse(dto, tarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }
}
