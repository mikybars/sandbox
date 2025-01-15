package com.inditex.rrhh.icmclcwb.model.app.run.limpieza.async.service;

import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.limpieza.async.service.LimpiezaAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.limpieza.service.LimpiezaService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
@RequiredArgsConstructor
public class LimpiezaAsyncServiceImpl implements LimpiezaAsyncService {

  private final LimpiezaService limpiezaService;

  @Override
  public CompletableFuture<Void> limpiezaTareaPersonaHistorico(@NonNull @Valid TareaDto tarea) {
      this.limpiezaService.limpiezaTareaPersonaHistorico(tarea);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

  @Override
  public CompletableFuture<Void> limpiezaTareaLocalizacionHistorico(@NonNull @Valid TareaDto tarea) {
      this.limpiezaService.limpiezaTareaLocalizacionHistorico(tarea);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

  @Override
  public CompletableFuture<Void> limpiezaTareaGlobalLocalizacionPersona(@NonNull @Valid TareaDto tarea) {
      this.limpiezaService.limpiezaTareaGlobalLocalizacionPersona(tarea);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

  @Override
  public CompletableFuture<Void> limpiezaTareaAmbitoGlobalLocalizacionPersonaDesplazamiento(
      @NonNull @Valid TareaDto tarea) {
      this.limpiezaService.limpiezaTareaAmbitoGlobalLocalizacionPersonaDesplazamiento(tarea);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

  @Override
  public CompletableFuture<Void> limpiezaTareaAmbitoGlobalLocalizacionPersonaPresencia(
      @NonNull @Valid TareaDto tarea) {
      this.limpiezaService.limpiezaTareaAmbitoGlobalLocalizacionPersonaPresencia(tarea);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

  @Override
  public CompletableFuture<Void> limpiezaTareaAmbitoLocalizacion(@NonNull @Valid TareaDto tarea) {
      this.limpiezaService.limpiezaTareaAmbitoLocalizacion(tarea);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

  @Override
  public CompletableFuture<Void> limpiezaTareaAmbitoGlobalLocalizacionPersonaPresenciaManual(
      @NonNull @Valid TareaDto tarea) {
      this.limpiezaService.limpiezaTareaAmbitoGlobalLocalizacionPersonaPresenciaManual(tarea);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

  @Override
  public CompletableFuture<Void> limpiezaTareaAmbitoGlobalPersona(@NonNull @Valid TareaDto tarea) {
      this.limpiezaService.limpiezaTareaAmbitoGlobalPersona(tarea);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

}
