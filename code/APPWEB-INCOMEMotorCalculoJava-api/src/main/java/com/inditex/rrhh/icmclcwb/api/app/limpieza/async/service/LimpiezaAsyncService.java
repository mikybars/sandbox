package com.inditex.rrhh.icmclcwb.api.app.limpieza.async.service;

import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.scheduling.annotation.Async;

@Async
public interface LimpiezaAsyncService {

  CompletableFuture<Void> limpiezaTareaPersonaHistorico(@NotNull @Valid final TareaDto tarea);

  CompletableFuture<Void> limpiezaTareaLocalizacionHistorico(@NotNull @Valid final TareaDto tarea);

  CompletableFuture<Void> limpiezaTareaGlobalLocalizacionPersona(@NotNull @Valid final TareaDto tarea);

  CompletableFuture<Void> limpiezaTareaAmbitoGlobalLocalizacionPersonaDesplazamiento(
      @NotNull @Valid final TareaDto tarea);

  CompletableFuture<Void> limpiezaTareaAmbitoGlobalLocalizacionPersonaPresencia(@NotNull @Valid final TareaDto tarea);

  CompletableFuture<Void> limpiezaTareaAmbitoLocalizacion(@NotNull @Valid final TareaDto tarea);

  CompletableFuture<Void> limpiezaTareaAmbitoGlobalLocalizacionPersonaPresenciaManual(
      @NotNull @Valid final TareaDto tarea);

  CompletableFuture<Void> limpiezaTareaAmbitoGlobalPersona(@NotNull @Valid final TareaDto tarea);

}
