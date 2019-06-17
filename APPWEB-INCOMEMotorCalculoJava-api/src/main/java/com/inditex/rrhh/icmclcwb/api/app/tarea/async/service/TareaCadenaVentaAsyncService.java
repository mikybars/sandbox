package com.inditex.rrhh.icmclcwb.api.app.tarea.async.service;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineentregadomicilio.dto.PtrVentaOnlineEntregaDomicilioResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.totalizado.dto.PtrVentaTotalizadoResponseDto;
import org.springframework.scheduling.annotation.Async;

import java.util.concurrent.CompletableFuture;

@Async("repositoryPrimaryExecutor")
public interface TareaCadenaVentaAsyncService {

    CompletableFuture<Void> savePtrVentaTotalizadoResponse(PtrVentaTotalizadoResponseDto dto, TareaDto tarea);

    CompletableFuture<Void> savePtrVentaOnlineEntregaDomicilioResponse(PtrVentaOnlineEntregaDomicilioResponseDto dto,
        TareaDto tarea);

}
