package com.inditex.rrhh.icmclcwb.api.ptr.venta.async.service;

import com.inditex.rrhh.icmclcwb.api.ptr.venta.totalizado.dto.PtrVentaTotalizadoRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.totalizado.dto.PtrVentaTotalizadoResponseDto;
import org.springframework.scheduling.annotation.Async;

import java.util.concurrent.CompletableFuture;

@Async("ptrVentaExecutor")
public interface PtrVentaGeneralAsyncService {

    CompletableFuture<PtrVentaTotalizadoResponseDto> ventaTotalizado(PtrVentaTotalizadoRequestDto request);

}
