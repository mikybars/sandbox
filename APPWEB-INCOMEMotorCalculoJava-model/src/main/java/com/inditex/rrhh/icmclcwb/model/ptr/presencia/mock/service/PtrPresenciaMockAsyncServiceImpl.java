package com.inditex.rrhh.icmclcwb.model.ptr.presencia.mock.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detalle.dto.PtrPresenciasDetalleRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detalle.dto.PtrPresenciasDetalleResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detallecomisionable.dto.PtrPresenciasDetalleComisionableRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.detallecomisionable.dto.PtrPresenciasDetalleComisionableResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.mock.service.PtrPresenciaMockAsyncService;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.mock.service.PtrPresenciaMockService;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.tiposhoras.dto.PtrPresenciasTiposHorasRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.tiposhoras.dto.PtrPresenciasTiposHorasResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.totaltienda.dto.PtrPresenciasTotalTiendaRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.totaltienda.dto.PtrPresenciasTotalTiendaResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.totaltiendaseccion.dto.PtrPresenciasTotalTiendaSeccionRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.totaltiendaseccion.dto.PtrPresenciasTotalTiendaSeccionResultItemDto;

@Service
public class PtrPresenciaMockAsyncServiceImpl implements PtrPresenciaMockAsyncService {

    @Autowired
    private PtrPresenciaMockService ptrPresenciaMockService;

    @Async
    @Override
    public CompletableFuture<List<PtrPresenciasDetalleResultItemDto>> presenciasDetalle(
            PtrPresenciasDetalleRequestDto request) {
        return CompletableFuture.completedFuture(ptrPresenciaMockService.presenciasDetalle(request));
    }

    @Async
    @Override
    public CompletableFuture<List<PtrPresenciasDetalleComisionableResultItemDto>> presenciasDetalleComisionable(
            PtrPresenciasDetalleComisionableRequestDto request) {
        return CompletableFuture.completedFuture(ptrPresenciaMockService.presenciasDetalleComisionable(request));
    }

    @Async
    @Override
    public CompletableFuture<List<PtrPresenciasTotalTiendaResultItemDto>> presenciasTotalTienda(
            PtrPresenciasTotalTiendaRequestDto request) {
        return CompletableFuture.completedFuture(ptrPresenciaMockService.presenciasTotalTienda(request));
    }

    @Async
    @Override
    public CompletableFuture<List<PtrPresenciasTotalTiendaSeccionResultItemDto>> presenciasTotalTiendaSeccion(
            PtrPresenciasTotalTiendaSeccionRequestDto request) {
        return CompletableFuture.completedFuture(ptrPresenciaMockService.presenciasTotalTiendaSeccion(request));
    }

    @Async
    @Override
    public CompletableFuture<List<PtrPresenciasTiposHorasResultItemDto>> tiposHoras(PtrPresenciasTiposHorasRequestDto request) {
        return CompletableFuture.completedFuture(ptrPresenciaMockService.tiposHoras(request));
    }

}