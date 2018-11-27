package com.inditex.rrhh.icmclcwb.model.ptr.presencia.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detalle.dto.PtrPresenciasDetalleRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detalle.dto.PtrPresenciasDetalleResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detalle.dto.PtrPresenciasDetalleResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.service.PtrPresenciaAsyncService;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.service.PtrPresenciasService;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.totaltiendaseccion.dto.PtrPresenciasTotalTiendaSeccionRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.totaltiendaseccion.dto.PtrPresenciasTotalTiendaSeccionResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.totaltiendaseccion.dto.PtrPresenciasTotalTiendaSeccionResponseDto;

@Service
public class PtrPresenciaAsyncServiceImpl implements PtrPresenciaAsyncService {

    @Autowired
    private PtrPresenciasService ptrPresenciaService;

    @Async
    @Override
    public CompletableFuture<PtrPresenciasTotalTiendaSeccionResponseDto> getPresenciasTotalTiendaSeccionDto(
            final PtrPresenciasTotalTiendaSeccionRequestDto request) throws Exception {
        return CompletableFuture.completedFuture(ptrPresenciaService.getPresenciasTotalTiendaSeccionDto(request));
    }

    @Async
    @Override
    public CompletableFuture<PtrPresenciasDetalleResponseDto> getPresenciasDetalleDto(
            final PtrPresenciasDetalleRequestDto request) throws Exception {
        return CompletableFuture.completedFuture(ptrPresenciaService.getPresenciasDetalleDto(request));
    }

}
