package com.inditex.rrhh.icmclcwb.api.ptr.venta.async.service;

import java.util.concurrent.CompletableFuture;

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
