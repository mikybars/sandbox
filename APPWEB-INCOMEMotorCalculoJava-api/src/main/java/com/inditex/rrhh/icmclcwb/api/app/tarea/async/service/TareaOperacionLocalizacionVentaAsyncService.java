package com.inditex.rrhh.icmclcwb.api.app.tarea.async.service;

import java.util.concurrent.CompletableFuture;

import javax.validation.Valid;

import org.springframework.scheduling.annotation.Async;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.individualdetalle.dto.PtrVentaIndividualDetalleResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineipodindividualdetalle.dto.PtrVentaOnlineIpodIndividualDetalleResponseDto;

@Async("repositoryPrimaryExecutor")
public interface TareaOperacionLocalizacionVentaAsyncService {

    CompletableFuture<Void> savePtrVentaOnlineIpodIndividualDetalleResponse(
            PtrVentaOnlineIpodIndividualDetalleResponseDto dto, @Valid TareaDto tarea);

    CompletableFuture<Void> savePtrVentaIndividualDetalleResponse(PtrVentaIndividualDetalleResponseDto dto,
            @Valid TareaDto tarea);

}
