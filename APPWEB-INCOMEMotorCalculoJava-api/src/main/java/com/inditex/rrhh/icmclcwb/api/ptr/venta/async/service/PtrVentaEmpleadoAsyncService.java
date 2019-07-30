package com.inditex.rrhh.icmclcwb.api.ptr.venta.async.service;

import com.inditex.rrhh.icmclcwb.api.ptr.venta.individualdetalle.dto.PtrVentaIndividualDetalleRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.individualdetalle.dto.PtrVentaIndividualDetalleResponseDto;
import org.springframework.scheduling.annotation.Async;

import java.util.concurrent.CompletableFuture;


@Async("ptrVentaExecutor")
public interface PtrVentaEmpleadoAsyncService {

    CompletableFuture<PtrVentaIndividualDetalleResponseDto> ventaIndividualDetalle(
            final PtrVentaIndividualDetalleRequestDto request);

}
