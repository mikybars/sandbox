package com.inditex.rrhh.icmclcwb.api.ptr.venta.service;

import javax.validation.Valid;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

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
@Validated
public interface PtrVentaGeneralService {

    PtrVentaTotalizadoResponseDto getVentaTotalizado(@Valid PtrVentaTotalizadoRequestDto request) throws Exception;

    PtrVentaMensualResponseDto getVentaMensual(@Valid PtrVentaMensualRequestDto request) throws Exception;

    PtrVentaDiariaResponseDto getVentaDiaria(@Valid PtrVentaDiariaRequestDto request) throws Exception;

    PtrVentaTotalizadoXmlResponseDto getVentaTotalizadoXML(@Valid PtrVentaTotalizadoXmlRequestDto request)
            throws Exception;

    PtrVentaTotalizadoByMccResponseDto getVentaTotalizadoByMcc(@Valid PtrVentaTotalizadoByMccRequestDto request)
            throws Exception;

    PtrVentaPresupuestadaMensualResponseDto getVentaPresupuestadaMensual(
            @Valid PtrVentaPresupuestadaMensualRequestDto request) throws Exception;

}
