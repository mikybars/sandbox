package com.inditex.rrhh.icmclcwb.model.ptr.presencia.mock.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.request.PresenciasDetalleComisionableRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.request.PresenciasDetalleRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.request.PresenciasTotalTiendaRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.request.PresenciasTotalTiendaSeccionRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.request.TiposHorasRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.response.PresenciasDetalleComisionableResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.response.PresenciasDetalleResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.response.PresenciasTotalTiendaResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.response.PresenciasTotalTiendaSeccionResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.dto.response.TiposHorasResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.mock.service.PtrPresenciaMockAsyncService;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.mock.service.PtrPresenciaMockService;

@Service
public class PtrPresenciaMockAsyncServiceImpl implements PtrPresenciaMockAsyncService {

    @Autowired
    private PtrPresenciaMockService ptrPresenciaMockService;

    @Async
    @Override
    public CompletableFuture<List<PresenciasDetalleResponseDto>> presenciasDetalle(
            PresenciasDetalleRequestDto request) {
        return CompletableFuture.completedFuture(ptrPresenciaMockService.presenciasDetalle(request));
    }

    @Async
    @Override
    public CompletableFuture<List<PresenciasDetalleComisionableResponseDto>> presenciasDetalleComisionable(
            PresenciasDetalleComisionableRequestDto request) {
        return CompletableFuture.completedFuture(ptrPresenciaMockService.presenciasDetalleComisionable(request));
    }

    @Async
    @Override
    public CompletableFuture<List<PresenciasTotalTiendaResponseDto>> presenciasTotalTienda(
            PresenciasTotalTiendaRequestDto request) {
        return CompletableFuture.completedFuture(ptrPresenciaMockService.presenciasTotalTienda(request));
    }

    @Async
    @Override
    public CompletableFuture<List<PresenciasTotalTiendaSeccionResponseDto>> presenciasTotalTiendaSeccion(
            PresenciasTotalTiendaSeccionRequestDto request) {
        return CompletableFuture.completedFuture(ptrPresenciaMockService.presenciasTotalTiendaSeccion(request));
    }

    @Async
    @Override
    public CompletableFuture<List<TiposHorasResponseDto>> tiposHoras(TiposHorasRequestDto request) {
        return CompletableFuture.completedFuture(ptrPresenciaMockService.tiposHoras(request));
    }

}