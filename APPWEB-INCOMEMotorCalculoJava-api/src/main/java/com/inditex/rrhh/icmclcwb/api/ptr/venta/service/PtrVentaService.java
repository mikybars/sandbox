package com.inditex.rrhh.icmclcwb.api.ptr.venta.service;

import javax.validation.Valid;

import com.inditex.rrhh.icmclcwb.api.ptr.venta.ventaindividual.dto.PtrVentaIndividualDetalleRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.ventaindividual.dto.PtrVentaIndividualDetalleResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.ventatotalizado.dto.PtrVentaTotalizadoRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.ventatotalizado.dto.PtrVentaTotalizadoResponseDto;

public interface PtrVentaService {

    PtrVentaTotalizadoResponseDto getVentaTotalizado(@Valid final PtrVentaTotalizadoRequestDto request)
            throws Exception;

    PtrVentaIndividualDetalleResponseDto getVentaIndividualDetalle(
            @Valid final PtrVentaIndividualDetalleRequestDto request) throws Exception;

}