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

  private final IOPComercialCalendarService iopComercialCalendarService;

  @Autowired
  public IOPComercialCalendarAsyncServiceImpl(IOPComercialCalendarService iopComercialCalendarService) {
    this.iopComercialCalendarService = iopComercialCalendarService;
  }

  @Override
  public CompletableFuture<ResponseDto<HorarioComercialFestivoDocDto>> horarioComercialFestivos(
      final HorarioComercialFestivosRequestDto request) {
    return CompletableFuture.completedFuture(this.iopComercialCalendarService.horarioComercialFestivos(request));
  }

}
