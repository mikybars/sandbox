package com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.async.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.scheduling.annotation.Async;

import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.configuracionorganizacion.ConfiguracionesRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.configuracionorganizacion.ConfiguracionesResponseDto;

@Async("meta4Executor")
public interface Meta4IcmWsCalcIncomeAsyncService {

    CompletableFuture<ConfiguracionesResponseDto> getConfiguraciones(ConfiguracionesRequestDto request);

}
