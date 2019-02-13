package com.inditex.rrhh.icmclcwb.model.ptr.venta.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.inditex.rrhh.icmclcwb.api.ptr.venta.async.service.PtrVentaEmpleadoAsyncService;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.service.PtrVentaEmpleadoService;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.ventaindividual.dto.PtrVentaIndividualDetalleRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.ventaindividual.dto.PtrVentaIndividualDetalleResponseDto;

@Service
public class PtrVentaEmpleadoAsyncServiceImpl implements PtrVentaEmpleadoAsyncService {

    @Autowired
    private PtrVentaEmpleadoService ptrVentaEmpleadoService;
    
    @Async
    @Override
    public CompletableFuture<PtrVentaIndividualDetalleResponseDto> getVentaIndividualDetalle(
            final PtrVentaIndividualDetalleRequestDto request) {
        return CompletableFuture.completedFuture(ptrVentaEmpleadoService.getVentaIndividualDetalle(request));
    }


}