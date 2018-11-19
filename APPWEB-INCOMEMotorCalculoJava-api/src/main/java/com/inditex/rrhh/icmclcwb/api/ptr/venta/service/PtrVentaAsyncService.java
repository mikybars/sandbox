package com.inditex.rrhh.icmclcwb.api.ptr.venta.service;

import java.util.concurrent.CompletableFuture;

import javax.validation.Valid;

import com.inditex.rrhh.icmclcwb.api.ptr.venta.ventaindividual.dto.GetVentaIndividualDetalleRequestDTO;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.ventaindividual.dto.GetVentaIndividualDetalleResponseDTO;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.ventatotalizado.dto.GetVentaTotalizadoRequestDTO;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.ventatotalizado.dto.GetVentaTotalizadoResponseDTO;

public interface PtrVentaAsyncService {

    CompletableFuture<GetVentaTotalizadoResponseDTO> getVentaTotalizado(
            @Valid final GetVentaTotalizadoRequestDTO request) throws Exception;

    CompletableFuture<GetVentaIndividualDetalleResponseDTO> getVentaIndividualDetalle(
            @Valid final GetVentaIndividualDetalleRequestDTO request) throws Exception;

}