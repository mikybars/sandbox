package com.inditex.rrhh.icmclcwb.api.ptr.venta.async.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.scheduling.annotation.Async;

import com.inditex.rrhh.icmclcwb.api.ptr.venta.individualdetalle.dto.PtrVentaIndividualDetalleRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.individualdetalle.dto.PtrVentaIndividualDetalleResponseDto;


@Async("ptrVentaExecutor")
public interface PtrVentaEmpleadoAsyncService {

    CompletableFuture<PtrVentaIndividualDetalleResponseDto> ventaIndividualDetalle(
            final PtrVentaIndividualDetalleRequestDto request);

}
