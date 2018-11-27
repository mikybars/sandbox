package com.inditex.rrhh.icmclcwb.model.ptr.presencia.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.request.PtrPresenciasMockDetalleRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.request.PtrPresenciasMockTotalTiendaSeccionRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.response.PtrPresenciasMockDetalleResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.response.PtrPresenciasMockTotalTiendaSeccionResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.service.PtrPresenciaAsyncService;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.service.PtrPresenciasService;

@Service
public class PtrPresenciaAsyncServiceImpl implements PtrPresenciaAsyncService {

    @Autowired
    private PtrPresenciasService ptrPresenciaService;

    @Async
    @Override
    public CompletableFuture<PtrPresenciasMockTotalTiendaSeccionResponseDto> getPresenciasTotalTiendaSeccionDto(
            final PtrPresenciasMockTotalTiendaSeccionRequestDto request) throws Exception {
        return CompletableFuture.completedFuture(ptrPresenciaService.getPresenciasTotalTiendaSeccionDto(request));
    }

    @Async
    @Override
    public CompletableFuture<PtrPresenciasMockDetalleResponseDto> getPresenciasDetalleDto(
            final PtrPresenciasMockDetalleRequestDto request) throws Exception {
        return CompletableFuture.completedFuture(ptrPresenciaService.getPresenciasDetalleDto(request));
    }

}
