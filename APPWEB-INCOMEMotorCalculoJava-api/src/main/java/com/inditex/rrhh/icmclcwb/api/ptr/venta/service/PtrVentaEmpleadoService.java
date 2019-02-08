package com.inditex.rrhh.icmclcwb.api.ptr.venta.service;

import javax.validation.Valid;

import com.inditex.rrhh.icmclcwb.api.ptr.venta.ventaindividual.dto.PtrVentaIndividualDetalleRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.ventaindividual.dto.PtrVentaIndividualDetalleResponseDto;

public interface PtrVentaEmpleadoService {

    PtrVentaIndividualDetalleResponseDto getVentaIndividualDetalle(@Valid PtrVentaIndividualDetalleRequestDto request)
            throws Exception;

}
