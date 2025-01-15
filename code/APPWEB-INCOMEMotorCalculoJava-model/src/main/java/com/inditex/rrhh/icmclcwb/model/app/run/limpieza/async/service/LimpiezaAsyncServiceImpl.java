package com.inditex.rrhh.icmclcwb.model.app.run.limpieza.async.service;

import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.limpieza.async.service.LimpiezaAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.limpieza.service.LimpiezaService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class LimpiezaAsyncServiceImpl implements LimpiezaAsyncService {

  @Autowired
  private LimpiezaService limpiezaService;

  @Override
  public CompletableFuture<Void> limpiezaTareaPersonaHistorico(@NotNull @Valid TareaDto tarea) {
    this.limpiezaService.limpiezaTareaPersonaHistorico(tarea);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

  @Override
  public CompletableFuture<Void> limpiezaTareaLocalizacionHistorico(@NotNull @Valid TareaDto tarea) {
    this.limpiezaService.limpiezaTareaLocalizacionHistorico(tarea);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

  @Override
  public CompletableFuture<Void> limpiezaTareaGlobalLocalizacionPersona(@NotNull @Valid TareaDto tarea) {
    this.limpiezaService.limpiezaTareaGlobalLocalizacionPersona(tarea);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

  @Override
  public CompletableFuture<Void> limpiezaTareaAmbitoGlobalLocalizacionPersonaDesplazamiento(
      @NotNull @Valid TareaDto tarea) {
    this.limpiezaService.limpiezaTareaAmbitoGlobalLocalizacionPersonaDesplazamiento(tarea);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

  @Override
  public CompletableFuture<Void> limpiezaTareaAmbitoGlobalLocalizacionPersonaPresencia(
      @NotNull @Valid TareaDto tarea) {
    this.limpiezaService.limpiezaTareaAmbitoGlobalLocalizacionPersonaPresencia(tarea);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

  @Override
  public CompletableFuture<Void> limpiezaTareaAmbitoLocalizacion(@NotNull @Valid TareaDto tarea) {
    this.limpiezaService.limpiezaTareaAmbitoLocalizacion(tarea);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

  @Override
  public CompletableFuture<Void> limpiezaTareaAmbitoGlobalLocalizacionPersonaPresenciaManual(
      @NotNull @Valid TareaDto tarea) {
    this.limpiezaService.limpiezaTareaAmbitoGlobalLocalizacionPersonaPresenciaManual(tarea);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

  @Override
  public CompletableFuture<Void> limpiezaTareaAmbitoGlobalPersona(@NotNull @Valid TareaDto tarea) {
    this.limpiezaService.limpiezaTareaAmbitoGlobalPersona(tarea);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

}
