package com.inditex.rrhh.icmclcwb.api.ptr.venta.service;

import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.ptr.venta.ventaindividual.dto.GetVentaIndividualDetalleRequestDTO;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.ventaindividual.dto.GetVentaIndividualDetalleResponseDTO;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.ventatotalizado.dto.GetVentaTotalizadoRequestDTO;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.ventatotalizado.dto.GetVentaTotalizadoResponseDTO;

public interface PtrVentaAsyncService {

    CompletableFuture<GetVentaTotalizadoResponseDTO> getVentaTotalizado(
            final GetVentaTotalizadoRequestDTO request) throws Exception;

    CompletableFuture<GetVentaIndividualDetalleResponseDTO> getVentaIndividualDetalle(
            final GetVentaIndividualDetalleRequestDTO request) throws Exception;

}