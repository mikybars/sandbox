package com.inditex.rrhh.icmclcwb.model.ptr.venta.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.service.PtrVentaAsyncService;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.service.PtrVentaService;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.ventaindividual.dto.GetVentaIndividualDetalleRequestDTO;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.ventaindividual.dto.GetVentaIndividualDetalleResponseDTO;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.ventatotalizado.dto.GetVentaTotalizadoRequestDTO;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.ventatotalizado.dto.GetVentaTotalizadoResponseDTO;

@Service
public class PtrVentaAsyncServiceImpl implements PtrVentaAsyncService {

    @Autowired
    private PtrVentaService ptrVentaService;

    @Async
    @Override
    public CompletableFuture<GetVentaTotalizadoResponseDTO> getVentaTotalizado(
            final GetVentaTotalizadoRequestDTO request) throws Exception {
        return CompletableFuture.completedFuture(ptrVentaService.getVentaTotalizado(request));
    }

    @Async
    @Override
    public CompletableFuture<GetVentaIndividualDetalleResponseDTO> getVentaIndividualDetalle(
            final GetVentaIndividualDetalleRequestDTO request) throws Exception {
        return CompletableFuture.completedFuture(ptrVentaService.getVentaIndividualDetalle(request));
    }

}