package com.inditex.rrhh.icmclcwb.api.ptr.venta.async.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.scheduling.annotation.Async;

import com.inditex.rrhh.icmclcwb.api.ptr.venta.individual.dto.PtrVentaIndividualRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.individual.dto.PtrVentaIndividualResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.individualdetalle.dto.PtrVentaIndividualDetalleRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.individualdetalle.dto.PtrVentaIndividualDetalleResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.individualdetallemcc.dto.PtrVentaIndividualDetalleByMccRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.individualdetallemcc.dto.PtrVentaIndividualDetalleByMccResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.individualmcc.dto.PtrVentaIndividualByMccRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.individualmcc.dto.PtrVentaIndividualByMccResponseDto;

@Async("ptrVentaExecutor")
public interface PtrVentaEmpleadoAsyncService {

    CompletableFuture<PtrVentaIndividualDetalleResponseDto> ventaIndividualDetalle(
            final PtrVentaIndividualDetalleRequestDto request);

    CompletableFuture<PtrVentaIndividualDetalleByMccResponseDto> ventaIndividualDetalleByMcc(
            PtrVentaIndividualDetalleByMccRequestDto request);

    CompletableFuture<PtrVentaIndividualResponseDto> ventaIndividual(PtrVentaIndividualRequestDto request);

    CompletableFuture<PtrVentaIndividualByMccResponseDto> ventaIndividualByMCC(
            PtrVentaIndividualByMccRequestDto request);

    CompletableFuture<String> test();

    CompletableFuture<String> getVersion();

}