package com.inditex.rrhh.icmclcwb.api.app.tarea.async.service;

import java.util.concurrent.CompletableFuture;

import javax.validation.Valid;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.individualdetalle.dto.PtrVentaIndividualDetalleResponseDto;

public interface TareaOperacionPersonaLocalizacionVentaAsyncService {

    CompletableFuture<Void> savePtrVentaIndividualDetalleResponse(PtrVentaIndividualDetalleResponseDto dto,
            @Valid TareaDto tarea);

}
