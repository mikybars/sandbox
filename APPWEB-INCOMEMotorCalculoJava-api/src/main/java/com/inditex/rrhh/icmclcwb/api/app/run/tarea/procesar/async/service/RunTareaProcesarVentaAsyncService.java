package com.inditex.rrhh.icmclcwb.api.app.run.tarea.procesar.async.service;

import com.inditex.rrhh.icmclcwb.api.app.calcular.TipoCalculoEnum;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import org.springframework.scheduling.annotation.Async;

import java.util.concurrent.CompletableFuture;

@Async
public interface RunTareaProcesarVentaAsyncService {

    CompletableFuture<Void> saveAbierto(RunTareaDto runTarea);

    CompletableFuture<Void> saveCerrado(RunTareaDto runTarea);

    CompletableFuture<Void> trasladar(RunTareaDto runTarea);

    CompletableFuture<Void> repartoVentaEntregaDomicilioAgrupaciones(RunTareaDto runTarea);

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

    CompletableFuture<Void> totalizarDevolucionLocalizacion(RunTareaDto tarea);

    CompletableFuture<Void> totalizarVentaPersonasPorVenta(RunTareaDto tarea, TipoCalculoEnum tipoCalculoEnum);

    CompletableFuture<Void> totalizarVentaPersonaSeccion (RunTareaDto tarea);

    CompletableFuture<Void> totalizarVentaPersonaLocalizacion (RunTareaDto tarea);

}
