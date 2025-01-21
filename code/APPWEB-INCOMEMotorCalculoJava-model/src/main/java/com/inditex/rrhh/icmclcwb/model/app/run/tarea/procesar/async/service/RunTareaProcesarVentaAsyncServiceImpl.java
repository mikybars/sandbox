package com.inditex.rrhh.icmclcwb.model.app.run.tarea.procesar.async.service;

import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.procesar.async.service.RunTareaProcesarVentaAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.procesar.service.RunTareaProcesarVentaService;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RunTareaProcesarVentaAsyncServiceImpl implements RunTareaProcesarVentaAsyncService {

  private final RunTareaProcesarVentaService tareaProcesarVentaService;

  @Override
  public CompletableFuture<Void> saveAbierto(final RunTareaDto runTarea) {
    this.tareaProcesarVentaService.saveAbierto(runTarea);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

  @Override
  public CompletableFuture<Void> saveAbiertoSeccion(final RunTareaDto runTarea) {
    this.tareaProcesarVentaService.saveAbiertoSeccion(runTarea);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

  @Override
  public CompletableFuture<Void> compensarOnlineSeccionCerrada(final RunTareaDto runTarea) {
    this.tareaProcesarVentaService.compensarOnlineSeccionCerrada(runTarea);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

  @Override
  public CompletableFuture<Void> saveCerrado(final RunTareaDto runTarea) {
    this.tareaProcesarVentaService.saveCerrado(runTarea);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

  @Override
  public CompletableFuture<Void> saveCerradoSeccion(final RunTareaDto runTarea) {
    this.tareaProcesarVentaService.saveCerradoSeccion(runTarea);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

  @Override
  public CompletableFuture<Void> trasladar(final RunTareaDto runTarea) {
    this.tareaProcesarVentaService.trasladar(runTarea);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

  @Override
  public CompletableFuture<Void> compensar(final RunTareaDto runTarea) {
    this.tareaProcesarVentaService.compensar(runTarea);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

  @Override
  public CompletableFuture<Void> repartoVentaEntregaDomicilioPorVentasAgrupaciones(final RunTareaDto runTarea) {
    this.tareaProcesarVentaService.repartoVentaEntregaDomicilioPorVentasAgrupaciones(runTarea);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

  @Override
  public CompletableFuture<Void> repartoVentaEntregaDomicilioPorPresenciaAgrupaciones(final RunTareaDto runTarea) {
    this.tareaProcesarVentaService.repartoVentaEntregaDomicilioPorPresenciaAgrupaciones(runTarea);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

  @Override
  public CompletableFuture<Void> repartoVentaEntregaDomicilioSeccion(final RunTareaDto runTarea) {
    this.tareaProcesarVentaService.repartoVentaEntregaDomicilioSeccion(runTarea);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

  @Override
  public CompletableFuture<Void> updateActivoTrasladadas(final RunTareaDto runTarea) {
    this.tareaProcesarVentaService.updateActivoTrasladadas(runTarea);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

  @Override
  public CompletableFuture<Void> updateActivoExcepcionada(final RunTareaDto runTarea) {
    this.tareaProcesarVentaService.updateActivoExcepcionada(runTarea);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

  @Override
  public CompletableFuture<Void> updateActivoCongeladaSeccion(final RunTareaDto runTarea) {
    this.tareaProcesarVentaService.updateActivoCongeladaSeccion(runTarea);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

  @Override
  public CompletableFuture<Void> updateActivoCongelada(final RunTareaDto runTarea) {
    this.tareaProcesarVentaService.updateActivoCongelada(runTarea);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

  @Override
  public CompletableFuture<Void> totalizarPresupuesto(final RunTareaDto runTarea) {
    this.tareaProcesarVentaService.totalizarPresupuesto(runTarea);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

  @Override
  public CompletableFuture<Void> updateActivoTrasladadasSeccion(final RunTareaDto runTarea) {
    this.tareaProcesarVentaService.updateActivoTrasladadasSeccion(runTarea);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

  @Override
  public CompletableFuture<Void> agruparOnlineSeccionDia(final RunTareaDto runTarea) {
    this.tareaProcesarVentaService.agruparOnlineSeccionDia(runTarea);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

  @Override
  public CompletableFuture<Void> updateActivoTrasladadasTotalizado(final RunTareaDto runTarea) {
    this.tareaProcesarVentaService.updateActivoTrasladadasTotalizado(runTarea);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

  @Override
  public CompletableFuture<Void> totalizarVentaSinDevolucionPersonasPorVenta(final RunTareaDto tarea) {
    this.tareaProcesarVentaService.totalizarVentaSinDevolucionPersonasPorVenta(tarea);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

  @Override
  public CompletableFuture<Void> totalizarDevolucionLocalizacionSeccion(final RunTareaDto tarea) {
    this.tareaProcesarVentaService.totalizarDevolucionLocalizacionSeccion(tarea);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

  @Override
  public CompletableFuture<Void> totalizarDevolucionLocalizacion(final RunTareaDto tarea) {
    this.tareaProcesarVentaService.totalizarDevolucionLocalizacion(tarea);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

  @Override
  public CompletableFuture<Void> totalizarVentaSinDevolucionLocalizacion(final RunTareaDto tarea) {
    this.tareaProcesarVentaService.totalizarVentasSinDevolucionLocalizacionSeccion(tarea);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

  @Override
  public CompletableFuture<Void> totalizarVentaSinDevolucionPersonaLocalizacion(final RunTareaDto tarea) {
    this.tareaProcesarVentaService.totalizarVentaSinDevolucionPersonaLocalizacion(tarea);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

  @Override
  public CompletableFuture<Void> totalizarDevolucionPersonaLocalizacion(final RunTareaDto tarea) {
    this.tareaProcesarVentaService.totalizarDevolucionPersonaLocalizacion(tarea);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

  @Override
  public CompletableFuture<Void> calcularImporteComisionVendedores(final RunTareaDto tarea) {
    this.tareaProcesarVentaService.calcularImporteComisionVendedores(tarea);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

  @Override
  public CompletableFuture<Void> calcularImporteComisionVentaODevolucion(final RunTareaDto tarea) {
    this.tareaProcesarVentaService.calcularImporteComisionVentaODevolucion(tarea);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

  @Override
  public CompletableFuture<Void> updateActivoNegativoTotalizado(final RunTareaDto tarea) {
    this.tareaProcesarVentaService.updateActivoNegativoTotalizado(tarea);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

  @Override
  public CompletableFuture<Void> totalizarDevolucionesVendedor0(final RunTareaDto tarea) {
    this.tareaProcesarVentaService.totalizarDevolucionesVendedor0(tarea);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

  @Override
  public CompletableFuture<Void> repartoDevolucionVendedor0(final RunTareaDto tarea) {
    this.tareaProcesarVentaService.repartoDevolucionVendedor0(tarea);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

  @Override
  public CompletableFuture<Void> updateActivoManual(final RunTareaDto tarea) {
    this.tareaProcesarVentaService.updateActivoManual(tarea);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

  @Override
  public CompletableFuture<Void> devolucionImporte0(final RunTareaDto tarea) {
    this.tareaProcesarVentaService.devolucionImporte0(tarea);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

  @Override
  public CompletableFuture<Void> totalizarDevolucionOnlineIpodPersonaSeccion(final RunTareaDto tarea) {
    this.tareaProcesarVentaService.totalizarDevolucionOnlineIpodPersonaSeccion(tarea);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

  @Override
  public CompletableFuture<Void> totalizarDevolucionFisicaPersonaSeccion(final RunTareaDto tarea) {
    this.tareaProcesarVentaService.totalizarDevolucionFisicaPersonaSeccion(tarea);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

  @Override
  public CompletableFuture<Void> totalizarVentaOnlineIpodSinDevolucionPersonaSeccion(final RunTareaDto tarea) {
    this.tareaProcesarVentaService.totalizarVentaOnlineIpodSinDevolucionPersonaSeccion(tarea);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

  @Override
  public CompletableFuture<Void> totalizarVentaFisicaSinDevolucionPersonaSeccion(final RunTareaDto tarea) {
    this.tareaProcesarVentaService.totalizarVentaFisicaSinDevolucionPersonaSeccion(tarea);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

}
