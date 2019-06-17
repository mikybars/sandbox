package com.inditex.rrhh.icmclcwb.model.app.tarea.async.service;

import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaCadenaVentaAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaCadenaVentaService;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineentregadomicilio.dto.PtrVentaOnlineEntregaDomicilioResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.totalizado.dto.PtrVentaTotalizadoResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class TareaCadenaVentaAsyncServiceImpl implements TareaCadenaVentaAsyncService {

    @Autowired
    private TareaCadenaVentaService tareaCadenaVentaService;

    @Override
    public CompletableFuture<Void> savePtrVentaTotalizadoResponse(PtrVentaTotalizadoResponseDto dto, TareaDto tarea) {
        tareaCadenaVentaService.savePtrVentaTotalizadoResponse(dto, tarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

    @Override
    public CompletableFuture<Void> savePtrVentaOnlineEntregaDomicilioResponse(
        PtrVentaOnlineEntregaDomicilioResponseDto dto, TareaDto tarea) {
        tareaCadenaVentaService.savePtrVentaOnlineEntregaDomicilioResponse(dto, tarea);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }
}
