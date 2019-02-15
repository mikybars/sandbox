package com.inditex.rrhh.icmclcwb.api.ptr.venta.async.service;

import java.util.concurrent.CompletableFuture;

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

public interface PtrVentaGeneralAsyncService {

    CompletableFuture<PtrVentaDiariaResponseDto> getVentaDiaria(PtrVentaDiariaRequestDto request);

    CompletableFuture<PtrVentaMensualResponseDto> getVentaMensual(PtrVentaMensualRequestDto request);

    CompletableFuture<PtrVentaPresupuestadaMensualResponseDto> getVentaPresupuestadaMensual(
            PtrVentaPresupuestadaMensualRequestDto request);

    CompletableFuture<PtrVentaTotalizadoResponseDto> getVentaTotalizado(PtrVentaTotalizadoRequestDto request);

    CompletableFuture<PtrVentaTotalizadoByMccResponseDto> getVentaTotalizadoByMcc(
            PtrVentaTotalizadoByMccRequestDto request);

    CompletableFuture<PtrVentaTotalizadoXmlResponseDto> getVentaTotalizadoXML(PtrVentaTotalizadoXmlRequestDto request);

    CompletableFuture<String> test();

    CompletableFuture<String> getVersion();

}
