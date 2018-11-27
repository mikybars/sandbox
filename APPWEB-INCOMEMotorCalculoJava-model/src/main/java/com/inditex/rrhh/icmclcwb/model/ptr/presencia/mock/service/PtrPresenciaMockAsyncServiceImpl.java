package com.inditex.rrhh.icmclcwb.model.ptr.presencia.mock.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detalle.dto.PtrPresenciaDetalleRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detalle.dto.PtrPresenciaDetalleResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detallecomisionable.dto.PtrPresenciaDetalleComisionableRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detallecomisionable.dto.PtrPresenciaDetalleComisionableResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.mock.service.PtrPresenciaMockAsyncService;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.mock.service.PtrPresenciaMockService;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.tiposhoras.dto.PtrPresenciaTiposHorasRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.tiposhoras.dto.PtrPresenciaTiposHorasResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.totaltienda.dto.PtrPresenciaTotalTiendaRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.totaltienda.dto.PtrPresenciaTotalTiendaResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.totaltiendaseccion.dto.PtrPresenciaTotalTiendaSeccionRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.totaltiendaseccion.dto.PtrPresenciaTotalTiendaSeccionResultItemDto;

@Service
public class PtrPresenciaMockAsyncServiceImpl implements PtrPresenciaMockAsyncService {

    @Autowired
    private PtrPresenciaMockService ptrPresenciaMockService;

    @Async
    @Override
    public CompletableFuture<List<PtrPresenciaDetalleResultItemDto>> presenciasDetalle(
            PtrPresenciaDetalleRequestDto request) {
        return CompletableFuture.completedFuture(ptrPresenciaMockService.presenciasDetalle(request));
    }

    @Async
    @Override
    public CompletableFuture<List<PtrPresenciaDetalleComisionableResultItemDto>> presenciasDetalleComisionable(
            PtrPresenciaDetalleComisionableRequestDto request) {
        return CompletableFuture.completedFuture(ptrPresenciaMockService.presenciasDetalleComisionable(request));
    }

    @Async
    @Override
    public CompletableFuture<List<PtrPresenciaTotalTiendaResultItemDto>> presenciasTotalTienda(
            PtrPresenciaTotalTiendaRequestDto request) {
        return CompletableFuture.completedFuture(ptrPresenciaMockService.presenciasTotalTienda(request));
    }

    @Async
    @Override
    public CompletableFuture<List<PtrPresenciaTotalTiendaSeccionResultItemDto>> presenciasTotalTiendaSeccion(
            PtrPresenciaTotalTiendaSeccionRequestDto request) {
        return CompletableFuture.completedFuture(ptrPresenciaMockService.presenciasTotalTiendaSeccion(request));
    }

    @Async
    @Override
    public CompletableFuture<List<PtrPresenciaTiposHorasResultItemDto>> tiposHoras(PtrPresenciaTiposHorasRequestDto request) {
        return CompletableFuture.completedFuture(ptrPresenciaMockService.tiposHoras(request));
    }

}