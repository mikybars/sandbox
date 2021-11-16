package com.inditex.rrhh.icmclcwb.api.ptr.venta.service;

import com.inditex.rrhh.icmclcwb.api.ptr.venta.individualdetalle.dto.PtrVentaIndividualDetalleRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.individualdetalle.dto.PtrVentaIndividualDetalleResponseDto;

import javax.validation.Valid;

public interface PtrVentaEmpleadoService {

  PtrVentaIndividualDetalleResponseDto ventaIndividualDetalle(@Valid PtrVentaIndividualDetalleRequestDto request);

}
