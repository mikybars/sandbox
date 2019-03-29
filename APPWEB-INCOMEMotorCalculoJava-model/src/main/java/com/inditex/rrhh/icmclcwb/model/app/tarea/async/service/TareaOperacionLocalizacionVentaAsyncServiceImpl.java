package com.inditex.rrhh.icmclcwb.model.app.tarea.async.service;

import java.util.concurrent.CompletableFuture;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaOperacionLocalizacionVentaAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaOperacionLocalizacionVentaService;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.individualdetalle.dto.PtrVentaIndividualDetalleResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineipodindividualdetalle.dto.PtrVentaOnlineIpodIndividualDetalleResponseDto;

@Service
public class TareaOperacionLocalizacionVentaAsyncServiceImpl implements TareaOperacionLocalizacionVentaAsyncService {

    @Autowired
    private TareaOperacionLocalizacionVentaService tareaOperacionLocalizacionVentaService;
    
    @Async
    @Override
    public CompletableFuture<Void> savePtrVentaOnlineIpodIndividualDetalleResponse(final PtrVentaOnlineIpodIndividualDetalleResponseDto dto, @Valid final TareaDto tarea)  {
        tareaOperacionLocalizacionVentaService.savePtrVentaOnlineIpodIndividualDetalleResponse(dto, tarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }
    
    @Async
    @Override
    public CompletableFuture<Void> savePtrVentaIndividualDetalleResponse(final PtrVentaIndividualDetalleResponseDto dto, @Valid final TareaDto tarea)  {
        tareaOperacionLocalizacionVentaService.savePtrVentaIndividualDetalleResponse(dto, tarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

}
