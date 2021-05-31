/*
 * Copyright (c) 2021. Inditex
 */

package com.inditex.rrhh.icmclcwb.api.slrhorcoms.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.scheduling.annotation.Async;

import com.inditex.rrhh.icmclcwb.api.slrhorcoms.horariocomercialfestivo.dto.HorarioComercialFestivoDocDto;
import com.inditex.rrhh.icmclcwb.api.slrhorcoms.horariocomercialfestivo.dto.HorarioComercialFestivosRequestDto;

@Async("slrhorcomsExecutor")
public interface SlrHorarioComercialAsyncService {

    CompletableFuture<List<HorarioComercialFestivoDocDto>> horarioComercialFestivos(
            HorarioComercialFestivosRequestDto request);

}
