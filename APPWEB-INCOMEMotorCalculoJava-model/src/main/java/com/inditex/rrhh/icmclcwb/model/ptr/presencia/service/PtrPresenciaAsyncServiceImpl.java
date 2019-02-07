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
            final PtrPresenciaTotalTiendaSeccionRequestDto request) throws Exception {
        return CompletableFuture.completedFuture(ptrPresenciaService.getPresenciasTotalTiendaSeccionDto(request));
    }

    @Async
    @Override
    public CompletableFuture<PtrPresenciaDetalleResponseDto> getPresenciasDetalleDto(
            final PtrPresenciaDetalleRequestDto request) throws Exception {
        return CompletableFuture.completedFuture(ptrPresenciaService.getPresenciasDetalleDto(request));
    }
    
    @Async
    @Override
    public CompletableFuture<PtrPresenciaDetalleComisionableResponseDto> getPresenciasDetalleComisionableDto(
            final PtrPresenciaDetalleComisionableRequestDto request) throws Exception {
        return CompletableFuture.completedFuture(ptrPresenciaService.getPresenciasDetalleComisionableDto(request));
    }
    
    @Async
    @Override
    public CompletableFuture<PtrPresenciaTiposHorasResponseDto> getTiposHoras(final PtrPresenciaTiposHorasRequestDto request) throws Exception{
        return CompletableFuture.completedFuture(ptrPresenciaService.getTiposHorasDto(request));
    }

}
