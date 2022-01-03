package com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.async.service;

import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.catalogo.dto.CatalogoRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.catalogo.dto.CatalogoResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.configuracionorganizacion.ConfiguracionesRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.configuracionorganizacion.ConfiguracionesResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.motivosdesplazamiento.dto.MotivosDesplazamientoRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.motivosdesplazamiento.dto.MotivosDesplazamientoResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.tiposhora.dto.TiposHoraRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.tiposhora.dto.TiposHoraResponseDto;

import org.springframework.scheduling.annotation.Async;

@Async("meta4Executor")
public interface Meta4IcmWsCalcIncomeAsyncService {

  CompletableFuture<ConfiguracionesResponseDto> getConfiguraciones(ConfiguracionesRequestDto request);

  CompletableFuture<MotivosDesplazamientoResponseDto> getMotivosDesplazamiento(
      MotivosDesplazamientoRequestDto request);

  CompletableFuture<CatalogoResponseDto> getCatalogo(CatalogoRequestDto request);

  CompletableFuture<TiposHoraResponseDto> getTiposHora(TiposHoraRequestDto request);

}
