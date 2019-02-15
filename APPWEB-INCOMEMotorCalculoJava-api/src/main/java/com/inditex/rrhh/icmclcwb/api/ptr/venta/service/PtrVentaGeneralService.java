package com.inditex.rrhh.icmclcwb.api.ptr.venta.service;

import javax.validation.Valid;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

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

@Service
@Validated
public interface PtrVentaGeneralService {

    PtrVentaTotalizadoResponseDto ventaTotalizado(@Valid PtrVentaTotalizadoRequestDto request);

    PtrVentaMensualResponseDto ventaMensual(@Valid PtrVentaMensualRequestDto request);

    PtrVentaDiariaResponseDto ventaDiaria(@Valid PtrVentaDiariaRequestDto request);

    PtrVentaTotalizadoXmlResponseDto ventaTotalizadoXML(@Valid PtrVentaTotalizadoXmlRequestDto request);

    PtrVentaTotalizadoByMccResponseDto ventaTotalizadoByMcc(@Valid PtrVentaTotalizadoByMccRequestDto request);

    PtrVentaPresupuestadaMensualResponseDto ventaPresupuestadaMensual(
            @Valid PtrVentaPresupuestadaMensualRequestDto request);

    String version();

    String test();

}
