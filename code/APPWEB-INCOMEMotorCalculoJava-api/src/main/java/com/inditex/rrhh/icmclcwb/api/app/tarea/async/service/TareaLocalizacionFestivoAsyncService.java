package com.inditex.rrhh.icmclcwb.api.app.tarea.async.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.slrhorcoms.horariocomercialfestivo.dto.HorarioComercialFestivoDocDto;

import org.jspecify.annotations.NonNull;
import org.springframework.scheduling.annotation.Async;

@Async("repositoryPrimaryExecutor")
public interface TareaLocalizacionFestivoAsyncService {

  CompletableFuture<Void> save(@NonNull List<HorarioComercialFestivoDocDto> src,
      @NonNull TareaDto tarea);

}
