package com.inditex.rrhh.icmclcwb.api.app.limpieza.async.service;

import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;

import jakarta.validation.Valid;
import org.jspecify.annotations.NonNull;
import org.springframework.scheduling.annotation.Async;

@Async
public interface LimpiezaAsyncService {

  CompletableFuture<Void> limpiezaTareaPersonaHistorico(@NonNull @Valid final TareaDto tarea);

  CompletableFuture<Void> limpiezaTareaLocalizacionHistorico(@NonNull @Valid final TareaDto tarea);

  CompletableFuture<Void> limpiezaTareaGlobalLocalizacionPersona(@NonNull @Valid final TareaDto tarea);

  CompletableFuture<Void> limpiezaTareaAmbitoGlobalLocalizacionPersonaDesplazamiento(
      @NonNull @Valid final TareaDto tarea);

  CompletableFuture<Void> limpiezaTareaAmbitoGlobalLocalizacionPersonaPresencia(@NonNull @Valid final TareaDto tarea);

  CompletableFuture<Void> limpiezaTareaAmbitoLocalizacion(@NonNull @Valid final TareaDto tarea);

  CompletableFuture<Void> limpiezaTareaAmbitoGlobalLocalizacionPersonaPresenciaManual(
      @NonNull @Valid final TareaDto tarea);

  CompletableFuture<Void> limpiezaTareaAmbitoGlobalPersona(@NonNull @Valid final TareaDto tarea);

}
