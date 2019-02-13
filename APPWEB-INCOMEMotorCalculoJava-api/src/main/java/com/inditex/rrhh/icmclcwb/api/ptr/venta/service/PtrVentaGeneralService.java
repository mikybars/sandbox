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

    PtrVentaTotalizadoResponseDto getVentaTotalizado(@Valid PtrVentaTotalizadoRequestDto request);

    PtrVentaMensualResponseDto getVentaMensual(@Valid PtrVentaMensualRequestDto request);

    PtrVentaDiariaResponseDto getVentaDiaria(@Valid PtrVentaDiariaRequestDto request);

    PtrVentaTotalizadoXmlResponseDto getVentaTotalizadoXML(@Valid PtrVentaTotalizadoXmlRequestDto request);

    PtrVentaTotalizadoByMccResponseDto getVentaTotalizadoByMcc(@Valid PtrVentaTotalizadoByMccRequestDto request);

    PtrVentaPresupuestadaMensualResponseDto getVentaPresupuestadaMensual(
            @Valid PtrVentaPresupuestadaMensualRequestDto request);

    String getVersion();

    String test();

}
