package com.inditex.rrhh.icmclcwb.api.ptr.venta.service;

import javax.validation.Valid;

import com.inditex.rrhh.icmclcwb.api.ptr.venta.individual.dto.PtrVentaIndividualRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.individual.dto.PtrVentaIndividualResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.individualdetalle.dto.PtrVentaIndividualDetalleRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.individualdetalle.dto.PtrVentaIndividualDetalleResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.individualdetallemcc.dto.PtrVentaIndividualDetalleByMccRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.individualdetallemcc.dto.PtrVentaIndividualDetalleByMccResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.individualmcc.dto.PtrVentaIndividualByMccRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.individualmcc.dto.PtrVentaIndividualByMccResponseDto;

public interface PtrVentaEmpleadoService {

    PtrVentaIndividualDetalleResponseDto ventaIndividualDetalle(@Valid PtrVentaIndividualDetalleRequestDto request);

    PtrVentaIndividualDetalleByMccResponseDto ventaIndividualDetalleByMcc(
            @Valid PtrVentaIndividualDetalleByMccRequestDto request);

    PtrVentaIndividualResponseDto ventaIndividual(@Valid PtrVentaIndividualRequestDto request);

    PtrVentaIndividualByMccResponseDto ventaIndividualByMCC(@Valid PtrVentaIndividualByMccRequestDto request);

    String test();

    String version();

}
