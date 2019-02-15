package com.inditex.rrhh.icmclcwb.model.ptr.presencia.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.inditex.rrhh.icmclcwb.api.ptr.presencia.async.service.PtrPresenciaAsyncService;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detalle.dto.PtrPresenciaDetalleRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detalle.dto.PtrPresenciaDetalleResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detallecomisionable.dto.PtrPresenciaDetalleComisionableRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detallecomisionable.dto.PtrPresenciaDetalleComisionableResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.service.PtrPresenciaService;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.tiposhoras.dto.PtrPresenciaTiposHorasRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.tiposhoras.dto.PtrPresenciaTiposHorasResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.totaltiendaseccion.dto.PtrPresenciaTotalTiendaSeccionRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.totaltiendaseccion.dto.PtrPresenciaTotalTiendaSeccionResponseDto;

@Service
public class PtrPresenciaAsyncServiceImpl implements PtrPresenciaAsyncService {

    @Autowired
    private PtrPresenciaService ptrPresenciaService;

    @Async
    @Override
    public CompletableFuture<PtrPresenciaTotalTiendaSeccionResponseDto> getPresenciasTotalTiendaSeccionDto(
            final PtrPresenciaTotalTiendaSeccionRequestDto request) {
        return CompletableFuture.completedFuture(ptrPresenciaService.presenciasTotalTiendaSeccion(request));
    }

    @Async
    @Override
    public CompletableFuture<PtrPresenciaDetalleResponseDto> getPresenciasDetalleDto(
            final PtrPresenciaDetalleRequestDto request) {
        return CompletableFuture.completedFuture(ptrPresenciaService.presenciasDetalle(request));
    }

    @Async
    @Override
    public CompletableFuture<PtrPresenciaDetalleComisionableResponseDto> getPresenciasDetalleComisionableDto(
            final PtrPresenciaDetalleComisionableRequestDto request) {
        return CompletableFuture.completedFuture(ptrPresenciaService.presenciasDetalleComisionable(request));
    }

    @Async
    @Override
    public CompletableFuture<PtrPresenciaTiposHorasResponseDto> getTiposHoras(
            final PtrPresenciaTiposHorasRequestDto request) {
        return CompletableFuture.completedFuture(ptrPresenciaService.tiposHoras(request));
    }
    
    @Async
    @Override
    public CompletableFuture<String> getVersion() {
        return CompletableFuture.completedFuture(ptrPresenciaService.version());
    }
    
    @Async
    @Override
    public CompletableFuture<String> test() {
        return CompletableFuture.completedFuture(ptrPresenciaService.test());
    }

}
