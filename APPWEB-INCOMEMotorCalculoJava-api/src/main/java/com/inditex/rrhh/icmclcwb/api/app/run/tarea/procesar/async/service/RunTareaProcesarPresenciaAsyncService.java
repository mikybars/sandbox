package com.inditex.rrhh.icmclcwb.api.app.run.tarea.procesar.async.service;

import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;

import org.springframework.scheduling.annotation.Async;

@Async
public interface RunTareaProcesarPresenciaAsyncService {

  CompletableFuture<Void> updateActivoLocalizacionPersonaPresencia(RunTareaDto runTarea);

  CompletableFuture<Void> compensarLocalizacion(RunTareaDto runTarea);

  CompletableFuture<Void> compensarLocalizacionPersonaPresencia(RunTareaDto runTarea);

  CompletableFuture<Void> presenciasIncluidoVentaPersona(RunTareaDto runTarea);

  CompletableFuture<Void> totalizarLocalizacion(RunTareaDto runTarea);

  CompletableFuture<Void> calcularPresenciasTotalesAgrupacion(RunTareaDto runTarea);

  CompletableFuture<Void> updateActivoLocalizacionVacio(RunTareaDto runTarea);

  CompletableFuture<Void> updateActivoLocalizacionPersonaPresenciaVacio(RunTareaDto runTarea);

  CompletableFuture<Void> indicadorPresencia(RunTareaDto runTarea);

  CompletableFuture<Void> indicadorPresenciaDesplazamiento(RunTareaDto runTarea);

  CompletableFuture<Void> presenciaDesplazamiento(RunTareaDto runTarea);

  CompletableFuture<Void> indicadorPresenciaDesplazamientoBase(RunTareaDto runTarea);

  CompletableFuture<Void> indicadorPresenciaDesplazamientoBaseDesplazamientoMismaLocalizacion(RunTareaDto runTarea);

  CompletableFuture<Void> totalizarEcommerceLocalizacion(RunTareaDto runTarea);

  CompletableFuture<Void> totalizarEmpleadosPorVenta(RunTareaDto runTarea);

  CompletableFuture<Void> presenciasHorasFijas(RunTareaDto runTarea);

  CompletableFuture<Void> presenciasHorasFijasDesplazamientos(RunTareaDto runTarea);

  CompletableFuture<Void> indicadorPersonaPorVenta(RunTareaDto runTarea);

  CompletableFuture<Void> compensarChallenge(RunTareaDto runTarea);

  CompletableFuture<Void> indicadorDesplazamientoDirectoVenta(RunTareaDto runTarea);

  CompletableFuture<Void> compensarLocalizacionManual(RunTareaDto runTarea);

  CompletableFuture<Void> indicadorDesplazamientoBaseDirectoVenta(RunTareaDto runTarea);

  CompletableFuture<Void> indicadorDesplazamientoDirectoVentaSinPresencias(RunTareaDto runTarea);

  CompletableFuture<Void> indicadorDesplazamientoBaseDirectoVentaSinDesplazamiento(RunTareaDto runTarea);

  CompletableFuture<Void> indicadorDesplazamientoBaseDirectoVentaOtraTienda(RunTareaDto runTarea);

  CompletableFuture<Void> indicadorDesplazamientoDirectoVentaCambioFuncion(RunTareaDto runTarea);

  CompletableFuture<Void> repartirPresenciasSindicalesLocalizacion(RunTareaDto runTarea);

  CompletableFuture<Void> repartirPresenciasSindicalesLocalizacionSeccion(RunTareaDto runTarea);

  CompletableFuture<Void> totalizarEcommerceSeccion(RunTareaDto runTareaDto);

  CompletableFuture<Void> totalizarPresenciasSindicalesLocalizacion(RunTareaDto runTareaDto);

  CompletableFuture<Void> indicadorDesplazamientoChallengeImporteTienda(RunTareaDto runTarea);

  CompletableFuture<Void> totalizarLocalizacionIncluidoChallengePorcentaje(RunTareaDto runTarea);

  CompletableFuture<Void> compensarLocalizacionIncluidoChallengePorcentaje(RunTareaDto runTarea);
}
