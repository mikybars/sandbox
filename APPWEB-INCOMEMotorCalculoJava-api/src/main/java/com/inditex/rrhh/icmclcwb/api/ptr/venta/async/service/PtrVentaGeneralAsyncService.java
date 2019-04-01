package com.inditex.rrhh.icmclcwb.api.ptr.venta.async.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.scheduling.annotation.Async;

import com.inditex.rrhh.icmclcwb.api.ptr.venta.diaria.dto.PtrVentaDiariaRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.diaria.dto.PtrVentaDiariaResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.mensual.dto.PtrVentaMensualRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.mensual.dto.PtrVentaMensualResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.presupuestadamensual.dto.PtrVentaPresupuestadaMensualRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.presupuestadamensual.dto.PtrVentaPresupuestadaMensualResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.totalizado.dto.PtrVentaTotalizadoRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.totalizado.dto.PtrVentaTotalizadoResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.totalizadobymcc.dto.PtrVentaTotalizadoByMccRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.totalizadobymcc.dto.PtrVentaTotalizadoByMccResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.totalizadoxml.dto.PtrVentaTotalizadoXmlRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.totalizadoxml.dto.PtrVentaTotalizadoXmlResponseDto;

@Async("ptrVentaExecutor")
public interface PtrVentaGeneralAsyncService {

    CompletableFuture<PtrVentaDiariaResponseDto> ventaDiaria(PtrVentaDiariaRequestDto request);

    CompletableFuture<PtrVentaMensualResponseDto> ventaMensual(PtrVentaMensualRequestDto request);

    CompletableFuture<PtrVentaPresupuestadaMensualResponseDto> ventaPresupuestadaMensual(
            PtrVentaPresupuestadaMensualRequestDto request);

    CompletableFuture<PtrVentaTotalizadoResponseDto> ventaTotalizado(PtrVentaTotalizadoRequestDto request);

    CompletableFuture<PtrVentaTotalizadoByMccResponseDto> ventaTotalizadoByMcc(
            PtrVentaTotalizadoByMccRequestDto request);

    CompletableFuture<PtrVentaTotalizadoXmlResponseDto> ventaTotalizadoXML(PtrVentaTotalizadoXmlRequestDto request);

    CompletableFuture<String> test();

    CompletableFuture<String> version();

}
