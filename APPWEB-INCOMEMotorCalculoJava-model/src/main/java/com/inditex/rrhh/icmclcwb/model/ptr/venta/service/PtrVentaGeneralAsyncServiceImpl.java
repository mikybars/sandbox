package com.inditex.rrhh.icmclcwb.model.ptr.venta.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.inditex.rrhh.icmclcwb.api.ptr.venta.async.service.PtrVentaGeneralAsyncService;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.diaria.dto.PtrVentaDiariaRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.diaria.dto.PtrVentaDiariaResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.mensual.dto.PtrVentaMensualRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.mensual.dto.PtrVentaMensualResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.presupuestadamensual.dto.PtrVentaPresupuestadaMensualRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.presupuestadamensual.dto.PtrVentaPresupuestadaMensualResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.service.PtrVentaGeneralService;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.totalizado.dto.PtrVentaTotalizadoRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.totalizado.dto.PtrVentaTotalizadoResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.totalizadobymcc.dto.PtrVentaTotalizadoByMccRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.totalizadobymcc.dto.PtrVentaTotalizadoByMccResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.totalizadoxml.dto.PtrVentaTotalizadoXmlRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.totalizadoxml.dto.PtrVentaTotalizadoXmlResponseDto;

@Service
public class PtrVentaGeneralAsyncServiceImpl implements PtrVentaGeneralAsyncService {

    @Autowired
    private PtrVentaGeneralService ptrVentaGeneralService;

    @Async
    @Override
    public CompletableFuture<PtrVentaDiariaResponseDto> getVentaDiaria(final PtrVentaDiariaRequestDto request) {
        return CompletableFuture.completedFuture(ptrVentaGeneralService.ventaDiaria(request));
    }

    @Async
    @Override
    public CompletableFuture<PtrVentaMensualResponseDto> getVentaMensual(final PtrVentaMensualRequestDto request) {
        return CompletableFuture.completedFuture(ptrVentaGeneralService.ventaMensual(request));
    }

    @Async
    @Override
    public CompletableFuture<PtrVentaPresupuestadaMensualResponseDto> getVentaPresupuestadaMensual(
            final PtrVentaPresupuestadaMensualRequestDto request) {
        return CompletableFuture.completedFuture(ptrVentaGeneralService.ventaPresupuestadaMensual(request));
    }

    @Async
    @Override
    public CompletableFuture<PtrVentaTotalizadoResponseDto> getVentaTotalizado(
            final PtrVentaTotalizadoRequestDto request) {
        return CompletableFuture.completedFuture(ptrVentaGeneralService.ventaTotalizado(request));
    }

    @Async
    @Override
    public CompletableFuture<PtrVentaTotalizadoByMccResponseDto> getVentaTotalizadoByMcc(
            final PtrVentaTotalizadoByMccRequestDto request) {
        return CompletableFuture.completedFuture(ptrVentaGeneralService.ventaTotalizadoByMcc(request));
    }

    @Async
    @Override
    public CompletableFuture<PtrVentaTotalizadoXmlResponseDto> getVentaTotalizadoXML(
            final PtrVentaTotalizadoXmlRequestDto request) {
        return CompletableFuture.completedFuture(ptrVentaGeneralService.ventaTotalizadoXML(request));
    }

    @Async
    @Override
    public CompletableFuture<String> test() {
        return CompletableFuture.completedFuture(ptrVentaGeneralService.test());
    }

    @Async
    @Override
    public CompletableFuture<String> getVersion() {
        return CompletableFuture.completedFuture(ptrVentaGeneralService.version());
    }
}