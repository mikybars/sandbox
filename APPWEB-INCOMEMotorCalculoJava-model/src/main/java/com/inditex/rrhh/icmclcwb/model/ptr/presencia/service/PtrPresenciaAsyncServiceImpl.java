package com.inditex.rrhh.icmclcwb.model.ptr.presencia.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.request.PresenciasDetalleRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.request.PresenciasTotalTiendaSeccionRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.response.PresenciasDetalleResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.response.PresenciasTotalTiendaSeccionResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.service.PtrPresenciaAsyncService;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.service.PtrPresenciaService;

@Service
public class PtrPresenciaAsyncServiceImpl implements PtrPresenciaAsyncService {

    @Autowired
    private PtrPresenciaService ptrPresenciaService;

    @Async
    @Override
    public CompletableFuture<PresenciasTotalTiendaSeccionResponseDto> getPresenciasTotalTiendaSeccionDto(
            final PresenciasTotalTiendaSeccionRequestDto request) throws Exception {
        return CompletableFuture.completedFuture(ptrPresenciaService.getPresenciasTotalTiendaSeccionDto(request));
    }

    @Async
    @Override
    public CompletableFuture<PresenciasDetalleResponseDto> getPresenciasDetalleDto(
            final PresenciasDetalleRequestDto request) throws Exception {
        return CompletableFuture.completedFuture(ptrPresenciaService.getPresenciasDetalleDto(request));
    }

}
