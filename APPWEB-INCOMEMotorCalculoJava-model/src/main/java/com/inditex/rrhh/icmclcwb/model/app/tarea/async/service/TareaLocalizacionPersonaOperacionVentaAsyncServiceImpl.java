package com.inditex.rrhh.icmclcwb.model.app.tarea.async.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaLocalizacionPersonaOperacionVentaAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaLocalizacionPersonaOperacionVentaService;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.individualdetalle.dto.PtrVentaIndividualDetalleResponseDto;

@Service
public class TareaLocalizacionPersonaOperacionVentaAsyncServiceImpl
        implements TareaLocalizacionPersonaOperacionVentaAsyncService {

    @Autowired
    private TareaLocalizacionPersonaOperacionVentaService tareaLocalizacionPersonaOperacionVentaService;
    
    @Override
    public CompletableFuture<Void> savePtrVentaIndividualDetalleResponse(final PtrVentaIndividualDetalleResponseDto dto,final TareaDto tarea)  {
        tareaLocalizacionPersonaOperacionVentaService.savePtrVentaIndividualDetalleResponse(dto, tarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }
}
