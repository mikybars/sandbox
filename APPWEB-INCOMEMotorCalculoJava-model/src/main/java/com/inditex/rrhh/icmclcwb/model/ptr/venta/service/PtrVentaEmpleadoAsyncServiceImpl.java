package com.inditex.rrhh.icmclcwb.model.ptr.venta.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.inditex.rrhh.icmclcwb.api.ptr.venta.async.service.PtrVentaEmpleadoAsyncService;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.individualdetalle.dto.PtrVentaIndividualDetalleRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.individualdetalle.dto.PtrVentaIndividualDetalleResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.service.PtrVentaEmpleadoService;

@Service
public class PtrVentaEmpleadoAsyncServiceImpl implements PtrVentaEmpleadoAsyncService {

    @Autowired
    private PtrVentaEmpleadoService ptrVentaEmpleadoService;
    
    @Async
    @Override
    public CompletableFuture<PtrVentaIndividualDetalleResponseDto> getVentaIndividualDetalle(
            final PtrVentaIndividualDetalleRequestDto request) {
        return CompletableFuture.completedFuture(ptrVentaEmpleadoService.ventaIndividualDetalle(request));
    }


}