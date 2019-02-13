package com.inditex.rrhh.icmclcwb.model.ptr.venta.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.inditex.rrhh.icmclcwb.api.ptr.venta.async.service.PtrVentaGeneralAsyncService;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.service.PtrVentaGeneralService;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.ventadiaria.dto.PtrVentaDiariaRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.ventadiaria.dto.PtrVentaDiariaResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.ventamensual.dto.PtrVentaMensualRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.ventamensual.dto.PtrVentaMensualResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.ventapresupuestadamensual.dto.PtrVentaPresupuestadaMensualRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.ventapresupuestadamensual.dto.PtrVentaPresupuestadaMensualResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.ventatotalizado.dto.PtrVentaTotalizadoRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.ventatotalizado.dto.PtrVentaTotalizadoResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.ventatotalizadobymcc.dto.PtrVentaTotalizadoByMccRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.ventatotalizadobymcc.dto.PtrVentaTotalizadoByMccResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.ventatotalizadoxml.dto.PtrVentaTotalizadoXmlRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.ventatotalizadoxml.dto.PtrVentaTotalizadoXmlResponseDto;

@Service
public class PtrVentaGeneralAsyncServiceImpl implements PtrVentaGeneralAsyncService {

    @Autowired
    private PtrVentaGeneralService ptrVentaGeneralService;

    @Async
    @Override
    public CompletableFuture<PtrVentaDiariaResponseDto> getVentaDiaria(final PtrVentaDiariaRequestDto request) {
        return CompletableFuture.completedFuture(ptrVentaGeneralService.getVentaDiaria(request));
    }

    @Async
    @Override
    public CompletableFuture<PtrVentaMensualResponseDto> getVentaMensual(final PtrVentaMensualRequestDto request) {
        return CompletableFuture.completedFuture(ptrVentaGeneralService.getVentaMensual(request));
    }

    @Async
    @Override
    public CompletableFuture<PtrVentaPresupuestadaMensualResponseDto> getVentaPresupuestadaMensual(
            final PtrVentaPresupuestadaMensualRequestDto request) {
        return CompletableFuture.completedFuture(ptrVentaGeneralService.getVentaPresupuestadaMensual(request));
    }

    @Async
    @Override
    public CompletableFuture<PtrVentaTotalizadoResponseDto> getVentaTotalizado(
            final PtrVentaTotalizadoRequestDto request) {
        return CompletableFuture.completedFuture(ptrVentaGeneralService.getVentaTotalizado(request));
    }

    @Async
    @Override
    public CompletableFuture<PtrVentaTotalizadoByMccResponseDto> getVentaTotalizadoByMcc(
            final PtrVentaTotalizadoByMccRequestDto request) {
        return CompletableFuture.completedFuture(ptrVentaGeneralService.getVentaTotalizadoByMcc(request));
    }

    @Async
    @Override
    public CompletableFuture<PtrVentaTotalizadoXmlResponseDto> getVentaTotalizadoXML(
            final PtrVentaTotalizadoXmlRequestDto request) {
        return CompletableFuture.completedFuture(ptrVentaGeneralService.getVentaTotalizadoXML(request));
    }

    @Async
    @Override
    public CompletableFuture<String> test() {
        return CompletableFuture.completedFuture(ptrVentaGeneralService.test());
    }

    @Async
    @Override
    public CompletableFuture<String> getVersion() {
        return CompletableFuture.completedFuture(ptrVentaGeneralService.getVersion());
    }
}