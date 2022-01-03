package com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.service;

import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.async.service.Meta4IcmWsCalcIncomeAsyncService;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.catalogo.dto.CatalogoRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.catalogo.dto.CatalogoResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.configuracionorganizacion.ConfiguracionesRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.configuracionorganizacion.ConfiguracionesResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.motivosdesplazamiento.dto.MotivosDesplazamientoRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.motivosdesplazamiento.dto.MotivosDesplazamientoResponseDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.service.Meta4IcmWsCalcIncomeService;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.tiposhora.dto.TiposHoraRequestDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.tiposhora.dto.TiposHoraResponseDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Meta4IcmWsCalcIncomeAsyncServiceImpl implements Meta4IcmWsCalcIncomeAsyncService {

  @Autowired
  private Meta4IcmWsCalcIncomeService meta4IcmWsCalcIncomeService;

  @Override
  public CompletableFuture<ConfiguracionesResponseDto> getConfiguraciones(
      final ConfiguracionesRequestDto request) {
    return CompletableFuture.completedFuture(this.meta4IcmWsCalcIncomeService.getConfiguracion(request));
  }

  @Override
  public CompletableFuture<MotivosDesplazamientoResponseDto> getMotivosDesplazamiento(
      final MotivosDesplazamientoRequestDto request) {
    return CompletableFuture.completedFuture(this.meta4IcmWsCalcIncomeService.getMotivosDesplazamiento(request));
  }

  @Override
  public CompletableFuture<CatalogoResponseDto> getCatalogo(
      final CatalogoRequestDto request) {
    return CompletableFuture.completedFuture(this.meta4IcmWsCalcIncomeService.getCatalogo(request));
  }

  @Override
  public CompletableFuture<TiposHoraResponseDto> getTiposHora(
      final TiposHoraRequestDto request) {
    return CompletableFuture.completedFuture(this.meta4IcmWsCalcIncomeService.getTiposHora(request));
  }

}
