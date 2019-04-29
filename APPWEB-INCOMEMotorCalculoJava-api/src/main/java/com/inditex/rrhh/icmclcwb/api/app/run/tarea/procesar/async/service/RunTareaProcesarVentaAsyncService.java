package com.inditex.rrhh.icmclcwb.api.app.run.tarea.procesar.async.service;

import java.util.concurrent.CompletableFuture;

import javax.validation.Valid;

import org.springframework.scheduling.annotation.Async;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;

@Async
public interface RunTareaProcesarVentaAsyncService {

    CompletableFuture<Void> ventaLocalizacionSeccion(final RunTareaDto runTarea);

    CompletableFuture<Void> ventaLocalizacionTienda(final RunTareaDto runTarea);

    CompletableFuture<Void> ventaOnlineEntregaTiendaAgrupacionCadena(RunTareaDto runTarea);

    CompletableFuture<Void> ventaOnlineEntregaTiendaAgrupacionCadenaSeccion(RunTareaDto runTarea);

    CompletableFuture<Void> ventaFisicaAgrupacionCadena(RunTareaDto runTarea);

    CompletableFuture<Void> ventaFisicaAgrupacionCadenaSeccion(@Valid RunTareaDto runTarea);

    CompletableFuture<Void> saveAbierto(RunTareaDto runTarea);

    CompletableFuture<Void> saveCerrado(RunTareaDto runTarea);

    CompletableFuture<Void> trasladar(RunTareaDto runTarea);

    CompletableFuture<Void> repartoVentaEntregaDomicilioAgrupaciones(RunTareaDto runTarea);

    CompletableFuture<Void> repartoVentaEntregaDomicilioCadenas(RunTareaDto runTarea);

    CompletableFuture<Void> compensar(RunTareaDto runTarea);

    CompletableFuture<Void> mergePersonaLocalizacion(RunTareaDto runTarea);

    CompletableFuture<Void> mergePersona(RunTareaDto runTarea);

}
