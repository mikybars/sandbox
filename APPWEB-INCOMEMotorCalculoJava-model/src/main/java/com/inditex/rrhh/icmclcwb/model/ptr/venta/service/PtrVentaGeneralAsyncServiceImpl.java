package com.inditex.rrhh.icmclcwb.model.ptr.venta.service;

import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.ptr.venta.async.service.PtrVentaGeneralAsyncService;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.service.PtrVentaGeneralService;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.totalizado.dto.PtrVentaTotalizadoRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.totalizado.dto.PtrVentaTotalizadoResponseDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PtrVentaGeneralAsyncServiceImpl implements PtrVentaGeneralAsyncService {

  @Autowired
  private PtrVentaGeneralService ptrVentaGeneralService;

  @Override
  public CompletableFuture<PtrVentaTotalizadoResponseDto> ventaTotalizado(
      final PtrVentaTotalizadoRequestDto request) {
    return CompletableFuture.completedFuture(ptrVentaGeneralService.ventaTotalizado(request));
  }

}
