package com.inditex.rrhh.icmclcwb.api.ptr.venta.service;

import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.ptr.venta.ventaindividual.dto.GetVentaIndividualDetalleRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.ventaindividual.dto.GetVentaIndividualDetalleResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.ventatotalizado.dto.GetVentaTotalizadoRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.ventatotalizado.dto.GetVentaTotalizadoResponseDto;

public interface PtrVentaAsyncService {

    CompletableFuture<GetVentaTotalizadoResponseDto> getVentaTotalizado(
            final GetVentaTotalizadoRequestDto request) throws Exception;

    CompletableFuture<GetVentaIndividualDetalleResponseDto> getVentaIndividualDetalle(
            final GetVentaIndividualDetalleRequestDto request) throws Exception;

}