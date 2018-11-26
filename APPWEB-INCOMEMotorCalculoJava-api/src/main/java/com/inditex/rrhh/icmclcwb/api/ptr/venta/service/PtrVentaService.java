package com.inditex.rrhh.icmclcwb.api.ptr.venta.service;

import javax.validation.Valid;

import com.inditex.rrhh.icmclcwb.api.ptr.venta.ventaindividual.dto.GetVentaIndividualDetalleRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.ventaindividual.dto.GetVentaIndividualDetalleResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.ventatotalizado.dto.GetVentaTotalizadoRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.ventatotalizado.dto.GetVentaTotalizadoResponseDto;

public interface PtrVentaService {

    GetVentaTotalizadoResponseDto getVentaTotalizado(@Valid final GetVentaTotalizadoRequestDto request)
            throws Exception;

    GetVentaIndividualDetalleResponseDto getVentaIndividualDetalle(
            @Valid final GetVentaIndividualDetalleRequestDto request) throws Exception;

}