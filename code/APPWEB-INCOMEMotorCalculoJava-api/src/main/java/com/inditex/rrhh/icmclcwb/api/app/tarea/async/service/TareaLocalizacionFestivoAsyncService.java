package com.inditex.rrhh.icmclcwb.api.app.tarea.async.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.iopcomercialcalendar.horariocomercialfestivo.dto.HorarioComercialFestivoDocDto;

import jakarta.validation.constraints.NotNull;
import org.springframework.scheduling.annotation.Async;

@Async("repositoryPrimaryExecutor")
public interface TareaLocalizacionFestivoAsyncService {

  CompletableFuture<Void> save(@NotNull List<HorarioComercialFestivoDocDto> src,
      @NotNull TareaDto tarea);

}
