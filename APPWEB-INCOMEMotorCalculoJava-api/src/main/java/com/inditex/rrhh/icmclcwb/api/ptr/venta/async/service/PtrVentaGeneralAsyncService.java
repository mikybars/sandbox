package com.inditex.rrhh.icmclcwb.api.ptr.venta.async.service;

import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.ptr.venta.totalizado.dto.PtrVentaTotalizadoRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.totalizado.dto.PtrVentaTotalizadoResponseDto;

import org.springframework.scheduling.annotation.Async;

@Async("ptrVentaExecutor")
public interface PtrVentaGeneralAsyncService {

  CompletableFuture<PtrVentaTotalizadoResponseDto> ventaTotalizado(PtrVentaTotalizadoRequestDto request);

}
