package com.inditex.rrhh.icmclcwb.api.app.tarea.async.service;

import java.util.concurrent.CompletableFuture;

import javax.validation.Valid;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.individualdetalle.dto.PtrVentaIndividualDetalleResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineipodindividualdetalle.dto.PtrVentaOnlineIpodIndividualDetalleResponseDto;

public interface TareaPersonaLocalizacionVentaAsyncService {

    CompletableFuture<Void> savePtrVentaOnlineIpodIndividualDetalleResponse(
            PtrVentaOnlineIpodIndividualDetalleResponseDto dto, @Valid TareaDto tarea);

    CompletableFuture<Void> savePtrVentaIndividualDetalleResponseDto(PtrVentaIndividualDetalleResponseDto dto,
            @Valid TareaDto tarea);

}
