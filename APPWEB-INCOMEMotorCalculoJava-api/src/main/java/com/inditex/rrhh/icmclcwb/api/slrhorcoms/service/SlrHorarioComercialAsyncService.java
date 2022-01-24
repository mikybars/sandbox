package com.inditex.rrhh.icmclcwb.api.slrhorcoms.service;

/*
 * Copyright (c) 2021. Inditex
 */
import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.slrhorcoms.dto.ResponseDto;
import com.inditex.rrhh.icmclcwb.api.slrhorcoms.horariocomercialfestivo.dto.HorarioComercialFestivoDocDto;
import com.inditex.rrhh.icmclcwb.api.slrhorcoms.horariocomercialfestivo.dto.HorarioComercialFestivosRequestDto;

import org.springframework.scheduling.annotation.Async;

@Async("slrhorcomsExecutor")
public interface SlrHorarioComercialAsyncService {

  CompletableFuture<ResponseDto<HorarioComercialFestivoDocDto>> horarioComercialFestivos(
      HorarioComercialFestivosRequestDto request);

}
