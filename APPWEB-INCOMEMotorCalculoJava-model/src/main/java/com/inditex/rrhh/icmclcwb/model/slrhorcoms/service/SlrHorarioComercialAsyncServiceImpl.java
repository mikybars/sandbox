package com.inditex.rrhh.icmclcwb.model.slrhorcoms.service;

/*
 * Copyright (c) 2021. Inditex
 */
import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.slrhorcoms.dto.ResponseDto;
import com.inditex.rrhh.icmclcwb.api.slrhorcoms.horariocomercialfestivo.dto.HorarioComercialFestivoDocDto;
import com.inditex.rrhh.icmclcwb.api.slrhorcoms.horariocomercialfestivo.dto.HorarioComercialFestivosRequestDto;
import com.inditex.rrhh.icmclcwb.api.slrhorcoms.service.SlrHorarioComercialAsyncService;
import com.inditex.rrhh.icmclcwb.api.slrhorcoms.service.SlrHorarioComercialService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SlrHorarioComercialAsyncServiceImpl implements SlrHorarioComercialAsyncService {

  @Autowired
  private SlrHorarioComercialService slrHorarioComercialService;

  @Override
  public CompletableFuture<ResponseDto<HorarioComercialFestivoDocDto>> horarioComercialFestivos(
      final HorarioComercialFestivosRequestDto request) {
    return CompletableFuture.completedFuture(this.slrHorarioComercialService.horarioComercialFestivos(request));
  }

}
