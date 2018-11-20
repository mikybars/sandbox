package com.inditex.rrhh.icmclcwb.model.ptr.presencia.mock.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.request.PtrPresenciasMockDetalleComisionableRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.request.PtrPresenciasMockDetalleRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.request.PtrPresenciasMockTotalTiendaRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.request.PtrPresenciasMockTotalTiendaSeccionRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.request.PtrPresenciasMockTiposHorasRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.response.PtrPresenciasMockDetalleComisionableResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.response.PtrPresenciasMockDetalleResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.response.PtrPresenciasMockTotalTiendaResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.response.PtrPresenciasMockTotalTiendaSeccionResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.response.PtrPresenciasMockTiposHorasResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.mock.service.PtrPresenciaMockAsyncService;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.mock.service.PtrPresenciaMockService;

@Service
public class PtrPresenciaMockAsyncServiceImpl implements PtrPresenciaMockAsyncService {

    @Autowired
    private PtrPresenciaMockService ptrPresenciaMockService;

    @Async
    @Override
    public CompletableFuture<List<PtrPresenciasMockDetalleResponseDto>> presenciasDetalle(
            PtrPresenciasMockDetalleRequestDto request) {
        return CompletableFuture.completedFuture(ptrPresenciaMockService.presenciasDetalle(request));
    }

    @Async
    @Override
    public CompletableFuture<List<PtrPresenciasMockDetalleComisionableResponseDto>> presenciasDetalleComisionable(
            PtrPresenciasMockDetalleComisionableRequestDto request) {
        return CompletableFuture.completedFuture(ptrPresenciaMockService.presenciasDetalleComisionable(request));
    }

    @Async
    @Override
    public CompletableFuture<List<PtrPresenciasMockTotalTiendaResponseDto>> presenciasTotalTienda(
            PtrPresenciasMockTotalTiendaRequestDto request) {
        return CompletableFuture.completedFuture(ptrPresenciaMockService.presenciasTotalTienda(request));
    }

    @Async
    @Override
    public CompletableFuture<List<PtrPresenciasMockTotalTiendaSeccionResponseDto>> presenciasTotalTiendaSeccion(
            PtrPresenciasMockTotalTiendaSeccionRequestDto request) {
        return CompletableFuture.completedFuture(ptrPresenciaMockService.presenciasTotalTiendaSeccion(request));
    }

    @Async
    @Override
    public CompletableFuture<List<PtrPresenciasMockTiposHorasResponseDto>> tiposHoras(PtrPresenciasMockTiposHorasRequestDto request) {
        return CompletableFuture.completedFuture(ptrPresenciaMockService.tiposHoras(request));
    }

}