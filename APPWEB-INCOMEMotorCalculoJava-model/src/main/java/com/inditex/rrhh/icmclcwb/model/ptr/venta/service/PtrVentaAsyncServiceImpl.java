package com.inditex.rrhh.icmclcwb.model.ptr.venta.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.service.PtrVentaAsyncService;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.service.PtrVentaService;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.ventaindividual.dto.GetVentaIndividualDetalleRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.ventaindividual.dto.GetVentaIndividualDetalleResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.ventatotalizado.dto.GetVentaTotalizadoRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.ventatotalizado.dto.GetVentaTotalizadoResponseDto;

@Service
public class PtrVentaAsyncServiceImpl implements PtrVentaAsyncService {

    @Autowired
    private PtrVentaService ptrVentaService;

    @Async
    @Override
    public CompletableFuture<GetVentaTotalizadoResponseDto> getVentaTotalizado(
            final GetVentaTotalizadoRequestDto request) throws Exception {
        return CompletableFuture.completedFuture(ptrVentaService.getVentaTotalizado(request));
    }

    @Async
    @Override
    public CompletableFuture<GetVentaIndividualDetalleResponseDto> getVentaIndividualDetalle(
            final GetVentaIndividualDetalleRequestDto request) throws Exception {
        return CompletableFuture.completedFuture(ptrVentaService.getVentaIndividualDetalle(request));
    }

}