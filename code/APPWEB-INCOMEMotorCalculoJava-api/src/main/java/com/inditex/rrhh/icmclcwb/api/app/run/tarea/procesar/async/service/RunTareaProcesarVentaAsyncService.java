package com.inditex.rrhh.icmclcwb.api.app.run.tarea.procesar.async.service;

import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;

import jakarta.validation.Valid;
import org.springframework.scheduling.annotation.Async;

@Async
public interface RunTareaProcesarVentaAsyncService {

  CompletableFuture<Void> saveAbierto(RunTareaDto runTarea);

  CompletableFuture<Void> saveCerrado(RunTareaDto runTarea);

  CompletableFuture<Void> trasladar(RunTareaDto runTarea);

  CompletableFuture<Void> repartoVentaEntregaDomicilioPorVentasAgrupaciones(RunTareaDto runTarea);

  CompletableFuture<Void> repartoVentaEntregaDomicilioPorPresenciaAgrupaciones(RunTareaDto runTarea);

  CompletableFuture<Void> repartoVentaEntregaDomicilioSeccion(RunTareaDto runTarea);

  CompletableFuture<Void> compensar(RunTareaDto runTarea);

  CompletableFuture<Void> updateActivoTrasladadas(RunTareaDto runTarea);

  CompletableFuture<Void> saveAbiertoSeccion(RunTareaDto runTarea);

  CompletableFuture<Void> saveCerradoSeccion(RunTareaDto runTarea);

  CompletableFuture<Void> compensarOnlineSeccionCerrada(RunTareaDto runTarea);

  CompletableFuture<Void> updateActivoTrasladadasSeccion(RunTareaDto runTarea);

  CompletableFuture<Void> agruparOnlineSeccionDia(RunTareaDto runTarea);

  CompletableFuture<Void> updateActivoTrasladadasTotalizado(RunTareaDto runTarea);

  CompletableFuture<Void> totalizarDevolucionLocalizacionSeccion(RunTareaDto tarea);

  CompletableFuture<Void> totalizarDevolucionLocalizacion(RunTareaDto tarea);

  CompletableFuture<Void> totalizarVentaSinDevolucionLocalizacion(RunTareaDto tarea);

  CompletableFuture<Void> totalizarVentaSinDevolucionPersonasPorVenta(RunTareaDto tarea);

  CompletableFuture<Void> totalizarVentaSinDevolucionPersonaLocalizacion(RunTareaDto tarea);

  CompletableFuture<Void> totalizarDevolucionPersonaLocalizacion(RunTareaDto tarea);

  CompletableFuture<Void> calcularImporteComisionVendedores(@Valid RunTareaDto tarea);

  CompletableFuture<Void> calcularImporteComisionVentaODevolucion(@Valid RunTareaDto tarea);

  CompletableFuture<Void> updateActivoNegativoTotalizado(@Valid RunTareaDto tarea);

  CompletableFuture<Void> updateActivoExcepcionada(@Valid RunTareaDto runTarea);

  CompletableFuture<Void> updateActivoCongelada(@Valid RunTareaDto runTarea);

  CompletableFuture<Void> totalizarPresupuesto(@Valid RunTareaDto runTarea);

  CompletableFuture<Void> totalizarDevolucionesVendedor0(@Valid RunTareaDto tarea);

  CompletableFuture<Void> repartoDevolucionVendedor0(@Valid RunTareaDto tarea);

  CompletableFuture<Void> updateActivoCongeladaSeccion(@Valid RunTareaDto runTarea);

  CompletableFuture<Void> updateActivoManual(RunTareaDto tarea);

  CompletableFuture<Void> devolucionImporte0(RunTareaDto tarea);

  CompletableFuture<Void> totalizarDevolucionOnlineIpodPersonaSeccion(RunTareaDto tarea);

  CompletableFuture<Void> totalizarDevolucionFisicaPersonaSeccion(RunTareaDto tarea);

  CompletableFuture<Void> totalizarVentaOnlineIpodSinDevolucionPersonaSeccion(RunTareaDto tarea);

  CompletableFuture<Void> totalizarVentaFisicaSinDevolucionPersonaSeccion(RunTareaDto tarea);
}
