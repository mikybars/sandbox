package com.inditex.rrhh.icmclcwb.model.ptr.venta.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.inditex.rrhh.icmclcwb.api.ptr.venta.async.service.PtrVentaAsyncService;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.service.PtrVentaService;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.ventaindividual.dto.PtrVentaIndividualDetalleRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.ventaindividual.dto.PtrVentaIndividualDetalleResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.ventatotalizado.dto.PtrVentaTotalizadoRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.ventatotalizado.dto.PtrVentaTotalizadoResponseDto;

@Service
public class PtrVentaAsyncServiceImpl implements PtrVentaAsyncService {

    @Autowired
    private PtrVentaService ptrVentaService;

    @Async
    @Override
    public CompletableFuture<PtrVentaTotalizadoResponseDto> getVentaTotalizado(
            final PtrVentaTotalizadoRequestDto request) throws Exception {
        return CompletableFuture.completedFuture(ptrVentaService.getVentaTotalizado(request));
    }

    @Async
    @Override
    public CompletableFuture<PtrVentaIndividualDetalleResponseDto> getVentaIndividualDetalle(
            final PtrVentaIndividualDetalleRequestDto request) throws Exception {
        return CompletableFuture.completedFuture(ptrVentaService.getVentaIndividualDetalle(request));
    }

}