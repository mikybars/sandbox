package com.inditex.rrhh.icmclcwb.model.app.run.tarea.procesar.async.service;

import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.procesar.async.service.RunTareaProcesarPresenciaAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.procesar.service.RunTareaProcesarPresenciaService;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RunTareaProcesarPresenciaAsyncServiceImpl implements RunTareaProcesarPresenciaAsyncService {

  @Autowired
  private RunTareaProcesarPresenciaService runTareaProcesarPresenciaService;

  @Override
  public CompletableFuture<Void> compensarLocalizacion(final RunTareaDto runTarea) {
    this.runTareaProcesarPresenciaService.compensarLocalizacion(runTarea);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

  @Override
  public CompletableFuture<Void> totalizarLocalizacion(final RunTareaDto runTarea) {
    this.runTareaProcesarPresenciaService.totalizarLocalizacion(runTarea);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

  @Override
  public CompletableFuture<Void> totalizarEcommerceLocalizacion(final RunTareaDto runTarea) {
    this.runTareaProcesarPresenciaService.totalizarEcommerceLocalizacion(runTarea);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

  @Override
  public CompletableFuture<Void> totalizarEmpleadosPorVenta(final RunTareaDto runTarea) {
    this.runTareaProcesarPresenciaService.totalizarEmpleadosPorVenta(runTarea);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

  @Override
  public CompletableFuture<Void> updateActivoLocalizacionPersonaPresencia(final RunTareaDto runTarea) {
    this.runTareaProcesarPresenciaService.updateActivoLocalizacionPersonaPresencia(runTarea);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

  @Override
  public CompletableFuture<Void> updateActivoLocalizacionPersonaPresenciaVacio(final RunTareaDto runTarea) {
    this.runTareaProcesarPresenciaService.updateActivoLocalizacionPersonaPresenciaVacio(runTarea);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

  @Override
  public CompletableFuture<Void> compensarLocalizacionPersonaPresencia(final RunTareaDto runTarea) {
    this.runTareaProcesarPresenciaService.compensarLocalizacionPersonaPresencia(runTarea);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

  @Override
  public CompletableFuture<Void> compensarChallenge(final RunTareaDto runTarea) {
    this.runTareaProcesarPresenciaService.compensarChallenge(runTarea);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

  @Override
  public CompletableFuture<Void> presenciasIncluidoVentaPersona(final RunTareaDto runTarea) {
    this.runTareaProcesarPresenciaService.presenciasIncluidoVentaPersona(runTarea);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

  @Override
  public CompletableFuture<Void> updateActivoLocalizacionVacio(final RunTareaDto runTarea) {
    this.runTareaProcesarPresenciaService.updateActivoLocalizacionVacio(runTarea);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

  @Override
  public CompletableFuture<Void> calcularPresenciasTotalesAgrupacion(final RunTareaDto runTarea) {
    this.runTareaProcesarPresenciaService.calcularPresenciasTotalesAgrupacion(runTarea);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

  @Override
  public CompletableFuture<Void> indicadorPresencia(final RunTareaDto runTarea) {
    this.runTareaProcesarPresenciaService.indicadorPresencia(runTarea);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

  @Override
  public CompletableFuture<Void> indicadorPresenciaDesplazamiento(final RunTareaDto runTarea) {
    this.runTareaProcesarPresenciaService.indicadorPresenciaDesplazamiento(runTarea);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

  @Override
  public CompletableFuture<Void> indicadorPresenciaDesplazamientoBase(final RunTareaDto runTarea) {
    this.runTareaProcesarPresenciaService.indicadorPresenciaDesplazamientoBase(runTarea);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

  @Override
  public CompletableFuture<Void> indicadorPresenciaDesplazamientoBaseDesplazamientoMismaLocalizacion(
      final RunTareaDto runTarea) {
    this.runTareaProcesarPresenciaService
        .indicadorPresenciaDesplazamientoBaseDesplazamientoMismaLocalizacion(runTarea);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

  @Override
  public CompletableFuture<Void> presenciasHorasFijas(final RunTareaDto runTarea) {
    this.runTareaProcesarPresenciaService.presenciasHorasFijas(runTarea);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

  @Override
  public CompletableFuture<Void> presenciasHorasFijasDesplazamientos(final RunTareaDto runTarea) {
    this.runTareaProcesarPresenciaService.presenciasHorasFijasDesplazamientos(runTarea);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

  @Override
  public CompletableFuture<Void> indicadorPersonaPorVenta(final RunTareaDto runTarea) {
    this.runTareaProcesarPresenciaService.indicadorPersonaPorVenta(runTarea);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

  @Override
  public CompletableFuture<Void> indicadorDesplazamientoDirectoVenta(final RunTareaDto runTarea) {
    this.runTareaProcesarPresenciaService.indicadorDesplazamientoDirectoVenta(runTarea);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

  @Override
  public CompletableFuture<Void> indicadorDesplazamientoDirectoVentaSinPresencias(final RunTareaDto runTarea) {
    this.runTareaProcesarPresenciaService.indicadorDesplazamientoDirectoVentaSinPresencias(runTarea);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

  @Override
  public CompletableFuture<Void> indicadorDesplazamientoBaseDirectoVenta(final RunTareaDto runTarea) {
    this.runTareaProcesarPresenciaService.indicadorDesplazamientoBaseDirectoVenta(runTarea);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

  @Override
  public CompletableFuture<Void> indicadorDesplazamientoBaseDirectoVentaSinDesplazamiento(final RunTareaDto runTarea) {
    this.runTareaProcesarPresenciaService.indicadorDesplazamientoBaseDirectoVentaSinDesplazamiento(runTarea);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

  @Override
  public CompletableFuture<Void> indicadorDesplazamientoBaseDirectoVentaOtraTienda(final RunTareaDto runTarea) {
    this.runTareaProcesarPresenciaService.indicadorDesplazamientoBaseDirectoVentaOtraTienda(runTarea);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

  @Override
  public CompletableFuture<Void> indicadorDesplazamientoDirectoVentaCambioFuncion(final RunTareaDto runTarea) {
    this.runTareaProcesarPresenciaService.indicadorDesplazamientoDirectoVentaCambioFuncion(runTarea);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

  @Override
  public CompletableFuture<Void> indicadorDesplazamientoChallengeImporteTienda(final RunTareaDto runTarea) {
    this.runTareaProcesarPresenciaService.indicadorDesplazamientoChallengeImporteTienda(runTarea);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

  @Override
  public CompletableFuture<Void> compensarLocalizacionManual(final RunTareaDto runTarea) {
    this.runTareaProcesarPresenciaService.compensarLocalizacionManual(runTarea);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

  @Override
  public CompletableFuture<Void> repartirPresenciasSindicalesLocalizacion(
      final RunTareaDto runTarea) {
    this.runTareaProcesarPresenciaService.repartirPresenciasSindicalesLocalizacion(runTarea);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

  @Override
  public CompletableFuture<Void> repartirPresenciasSindicalesLocalizacionSeccion(
      final RunTareaDto runTarea) {
    this.runTareaProcesarPresenciaService.repartirPresenciasSindicalesLocalizacionSeccion(runTarea);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

  @Override
  public CompletableFuture<Void> totalizarEcommerceSeccion(
      final RunTareaDto runTareaDto) {
    this.runTareaProcesarPresenciaService.totalizarEcommerceSeccion(runTareaDto);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

  @Override
  public CompletableFuture<Void> totalizarPresenciasSindicalesLocalizacion(
      final RunTareaDto runTareaDto) {
    this.runTareaProcesarPresenciaService.totalizarPresenciasSindicalesLocalizacion(runTareaDto);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

  @Override
  public CompletableFuture<Void> totalizarLocalizacionIncluidoChallengePorcentaje(final RunTareaDto runTarea) {
    this.runTareaProcesarPresenciaService.totalizarLocalizacionIncluidoChallengePorcentaje(runTarea);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

  @Override
  public CompletableFuture<Void> compensarLocalizacionIncluidoChallengePorcentaje(final RunTareaDto runTarea) {
    this.runTareaProcesarPresenciaService.compensarLocalizacionManualIncluidoChallengePorcentaje(runTarea);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

}
