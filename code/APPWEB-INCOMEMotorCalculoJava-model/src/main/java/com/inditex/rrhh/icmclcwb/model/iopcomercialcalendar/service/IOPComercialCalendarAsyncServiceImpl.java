package com.inditex.rrhh.icmclcwb.model.iopcomercialcalendar.service;

/*
 * Copyright (c) 2021. Inditex
 */
import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.iopcomercialcalendar.dto.ResponseDto;
import com.inditex.rrhh.icmclcwb.api.iopcomercialcalendar.horariocomercialfestivo.dto.HorarioComercialFestivoDocDto;
import com.inditex.rrhh.icmclcwb.api.iopcomercialcalendar.horariocomercialfestivo.dto.HorarioComercialFestivosRequestDto;
import com.inditex.rrhh.icmclcwb.api.iopcomercialcalendar.service.IOPComercialCalendarAsyncService;
import com.inditex.rrhh.icmclcwb.api.iopcomercialcalendar.service.IOPComercialCalendarService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IOPComercialCalendarAsyncServiceImpl implements IOPComercialCalendarAsyncService {

  @Autowired
  private IOPComercialCalendarService iopcomercialcalendarService;

  @Override
  public CompletableFuture<ResponseDto<HorarioComercialFestivoDocDto>> horarioComercialFestivos(
      final HorarioComercialFestivosRequestDto request) {
    return CompletableFuture.completedFuture(this.iopcomercialcalendarService.horarioComercialFestivos(request));
  }

}
