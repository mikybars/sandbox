package com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.async.service;

import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;

import org.springframework.scheduling.annotation.Async;

@Async
public interface RunTareaRecolectarMeta4IcmWsCalcIncomeAsyncService {

  CompletableFuture<Void> personaByRunTarea(final RunTareaDto runTarea);

  CompletableFuture<Void> localizacionByRunTarea(final RunTareaDto runTarea);

  CompletableFuture<Void> tiendasComisionableByRunTarea(final RunTareaDto runTarea);

  CompletableFuture<Void> presenciaManualByRunTarea(final RunTareaDto runTarea);

  CompletableFuture<Void> empleadosPresenciaByRunTarea(final RunTareaDto runTarea);

  CompletableFuture<Void> coefJornadaByRunTarea(final RunTareaDto runTarea);

  CompletableFuture<Void> flagCalculaByRunTarea(final RunTareaDto runTarea);

  CompletableFuture<Void> configuracionVentaOnlineByRunTarea(final RunTareaDto runTarea);

  CompletableFuture<Void> agrupacionesCadenaByRunTarea(final RunTareaDto runTarea);

  CompletableFuture<Void> localizacionesOnlineByRunTarea(final RunTareaDto runTarea);

  CompletableFuture<Void> empleadosDesplazamientoByRunTarea(final RunTareaDto runTarea);

  CompletableFuture<Void> estructurasComByRunTarea(final RunTareaDto runTarea);

  CompletableFuture<Void> estructurasPolByRunTarea(final RunTareaDto runTarea);

  CompletableFuture<Void> ausenciasByRunTarea(final RunTareaDto runTarea);

  CompletableFuture<Void> configuracionesByRunTarea(final RunTareaDto runTarea);

  CompletableFuture<Void> confChallengeDiasMinimosByRunTarea(final RunTareaDto runTarea);

  CompletableFuture<Void> presupuestosWlocByRunTarea(final RunTareaDto runTarea);

  CompletableFuture<Void> confPrecioHoraByRunTarea(final RunTareaDto runTarea);

  CompletableFuture<Void> confChallengeTipoVentaByRunTarea(final RunTareaDto runTarea);

  CompletableFuture<Void> presupuestosRangoByRunTarea(final RunTareaDto runTarea);

  CompletableFuture<Void> ventaCongeladaByRunTarea(final RunTareaDto runTarea);

  CompletableFuture<Void> fechaAmbitoAndEmpresaByRunTarea(final RunTareaDto runTarea);

  CompletableFuture<Void> desplazamientoRealByRunTarea(final RunTareaDto runTarea);

  CompletableFuture<Void> presenciaManualLocalizacionByRunTarea(final RunTareaDto runTarea);

  CompletableFuture<Void> ventaManualLocalizacionByRunTarea(final RunTareaDto runTarea);

  CompletableFuture<Void> localizacionCadenaByRunTarea(final RunTareaDto runTarea);

  CompletableFuture<Void> estructurasPolByConfiguracionVentaOnlineEntregaDomicilio(final RunTareaDto runTarea);

  CompletableFuture<Void> empleadosCadenaByRunTarea(final RunTareaDto runTarea);

  CompletableFuture<Void> tiposHoraByRunTarea(final RunTareaDto runTarea);

  CompletableFuture<Void> estadoWlocByRunTarea(
      RunTareaDto runTarea);
}
