package com.inditex.rrhh.icmclcwb.model.ptr.venta.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.inditex.rrhh.icmclcwb.api.ptr.venta.async.service.PtrVentaEmpleadoAsyncService;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.individual.dto.PtrVentaIndividualRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.individual.dto.PtrVentaIndividualResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.individualdetalle.dto.PtrVentaIndividualDetalleRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.individualdetalle.dto.PtrVentaIndividualDetalleResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.individualdetallemcc.dto.PtrVentaIndividualDetalleByMccRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.individualdetallemcc.dto.PtrVentaIndividualDetalleByMccResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.individualmcc.dto.PtrVentaIndividualByMccRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.individualmcc.dto.PtrVentaIndividualByMccResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.service.PtrVentaEmpleadoService;

@Service
public class PtrVentaEmpleadoAsyncServiceImpl implements PtrVentaEmpleadoAsyncService {

    @Autowired
    private PtrVentaEmpleadoService ptrVentaEmpleadoService;
    
    @Async
    @Override
    public CompletableFuture<PtrVentaIndividualDetalleResponseDto> ventaIndividualDetalle(
            final PtrVentaIndividualDetalleRequestDto request) {
        return CompletableFuture.completedFuture(ptrVentaEmpleadoService.ventaIndividualDetalle(request));
    }
    
    @Async
    @Override
    public CompletableFuture<PtrVentaIndividualDetalleByMccResponseDto> ventaIndividualDetalleByMcc(
            final PtrVentaIndividualDetalleByMccRequestDto request) {
        return CompletableFuture.completedFuture(ptrVentaEmpleadoService.ventaIndividualDetalleByMcc(request));
    }
    
    @Async
    @Override
    public CompletableFuture<PtrVentaIndividualResponseDto> ventaIndividual(
            final PtrVentaIndividualRequestDto request) {
        return CompletableFuture.completedFuture(ptrVentaEmpleadoService.ventaIndividual(request));
    }
    
    @Async
    @Override
    public CompletableFuture<PtrVentaIndividualByMccResponseDto> ventaIndividualByMCC(PtrVentaIndividualByMccRequestDto request){
        return CompletableFuture.completedFuture(ptrVentaEmpleadoService.ventaIndividualByMCC(request));
    }

    @Async
    @Override
    public CompletableFuture<String> test() {
        return CompletableFuture.completedFuture(ptrVentaEmpleadoService.test());
    }

    @Async
    @Override
    public CompletableFuture<String> getVersion() {
        return CompletableFuture.completedFuture(ptrVentaEmpleadoService.version());
    }
}