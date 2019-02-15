package com.inditex.rrhh.icmclcwb.api.ptr.venta.async.service;

import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.ptr.venta.individualdetalle.dto.PtrVentaIndividualDetalleRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.individualdetalle.dto.PtrVentaIndividualDetalleResponseDto;

public interface PtrVentaEmpleadoAsyncService {

    CompletableFuture<PtrVentaIndividualDetalleResponseDto> getVentaIndividualDetalle(
            final PtrVentaIndividualDetalleRequestDto request);

}