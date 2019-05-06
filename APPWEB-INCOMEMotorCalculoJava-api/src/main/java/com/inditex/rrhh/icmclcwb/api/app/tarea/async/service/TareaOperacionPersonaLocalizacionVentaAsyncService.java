package com.inditex.rrhh.icmclcwb.api.app.tarea.async.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.scheduling.annotation.Async;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.individualdetalle.dto.PtrVentaIndividualDetalleResponseDto;

@Async("repositoryPrimaryExecutor")
public interface TareaOperacionPersonaLocalizacionVentaAsyncService {

    CompletableFuture<Void> savePtrVentaIndividualDetalleResponse(PtrVentaIndividualDetalleResponseDto dto,
           TareaDto tarea);

}
