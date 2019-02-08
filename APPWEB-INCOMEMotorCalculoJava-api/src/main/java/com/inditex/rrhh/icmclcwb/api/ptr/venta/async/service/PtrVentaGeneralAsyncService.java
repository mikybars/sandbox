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

    CompletableFuture<PtrVentaDiariaResponseDto> getVentaDiaria(PtrVentaDiariaRequestDto request) throws Exception;

    CompletableFuture<PtrVentaMensualResponseDto> getVentaMensual(PtrVentaMensualRequestDto request) throws Exception;

    CompletableFuture<PtrVentaPresupuestadaMensualResponseDto> getVentaPresupuestadaMensual(
            PtrVentaPresupuestadaMensualRequestDto request) throws Exception;
    
    CompletableFuture<PtrVentaTotalizadoResponseDto> getVentaTotalizado(PtrVentaTotalizadoRequestDto request)
            throws Exception;

    CompletableFuture<PtrVentaTotalizadoByMccResponseDto> getVentaTotalizadoByMcc(
            PtrVentaTotalizadoByMccRequestDto request) throws Exception;

    CompletableFuture<PtrVentaTotalizadoXmlResponseDto> getVentaTotalizadoXML(PtrVentaTotalizadoXmlRequestDto request)
            throws Exception;


 
}