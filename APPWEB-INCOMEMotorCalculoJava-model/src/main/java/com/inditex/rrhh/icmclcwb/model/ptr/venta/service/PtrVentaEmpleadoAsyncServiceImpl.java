package com.inditex.rrhh.icmclcwb.model.ptr.venta.service;

import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.ptr.venta.async.service.PtrVentaEmpleadoAsyncService;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.individualdetalle.dto.PtrVentaIndividualDetalleRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.individualdetalle.dto.PtrVentaIndividualDetalleResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.service.PtrVentaEmpleadoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PtrVentaEmpleadoAsyncServiceImpl implements PtrVentaEmpleadoAsyncService {

  @Autowired
  private PtrVentaEmpleadoService ptrVentaEmpleadoService;

  @Override
  public CompletableFuture<PtrVentaIndividualDetalleResponseDto> ventaIndividualDetalle(
      final PtrVentaIndividualDetalleRequestDto request) {
    return CompletableFuture.completedFuture(ptrVentaEmpleadoService.ventaIndividualDetalle(request));
  }

}
