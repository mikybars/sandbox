package com.inditex.rrhh.icmclcwb.api.iopcomercialcalendar.service;

/*
 * Copyright (c) 2021. Inditex
 */
import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.iopcomercialcalendar.dto.ResponseDto;
import com.inditex.rrhh.icmclcwb.api.iopcomercialcalendar.horariocomercialfestivo.dto.HorarioComercialFestivoDocDto;
import com.inditex.rrhh.icmclcwb.api.iopcomercialcalendar.horariocomercialfestivo.dto.HorarioComercialFestivosRequestDto;

import org.springframework.scheduling.annotation.Async;

@Async("iopcomercialcalendarExecutor")
public interface IOPComercialCalendarAsyncService {

  CompletableFuture<ResponseDto<HorarioComercialFestivoDocDto>> horarioComercialFestivos(
      HorarioComercialFestivosRequestDto request);

}
