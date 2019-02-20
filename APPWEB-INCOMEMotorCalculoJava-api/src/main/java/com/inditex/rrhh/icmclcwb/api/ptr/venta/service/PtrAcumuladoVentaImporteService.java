package com.inditex.rrhh.icmclcwb.api.ptr.venta.service;

import javax.validation.Valid;

import com.inditex.rrhh.icmclcwb.api.ptr.venta.acumulada.dto.PtrObtenerVentaAcumuladaRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.acumulada.dto.PtrObtenerVentaAcumuladaResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.acumuladadia.dto.PtrObtenerVentaAcumuladaDiaRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.acumuladadia.dto.PtrObtenerVentaAcumuladaDiaResponseDto;

public interface PtrAcumuladoVentaImporteService {

    PtrObtenerVentaAcumuladaResponseDto ventaAcumulada(@Valid PtrObtenerVentaAcumuladaRequestDto request);

    PtrObtenerVentaAcumuladaDiaResponseDto ventaAcumuladaDia(@Valid PtrObtenerVentaAcumuladaDiaRequestDto request);

    String version();

    String test();

}
