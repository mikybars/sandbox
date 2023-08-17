package com.inditex.rrhh.icmclcwb.model.app.run.tarea.recolectar.async.service;

import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.async.service.RunTareaRecolectarMeta4IcmWsCalcIncomeAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.service.RunTareaRecolectarMeta4IcmWsCalcIncomeService;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RunTareaRecolectarMeta4IcmWsCalcIncomeAsyncServiceImpl
    implements RunTareaRecolectarMeta4IcmWsCalcIncomeAsyncService {

  @Autowired
  private RunTareaRecolectarMeta4IcmWsCalcIncomeService tareaRecolectarMeta4IcmWsCalcIncomeService;

  @Override
  public CompletableFuture<Void> fechaAmbitoAndEmpresaByRunTarea(final RunTareaDto runTarea) {
    this.tareaRecolectarMeta4IcmWsCalcIncomeService.fechaAmbitoAndEmpresaByRunTarea(runTarea);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

  @Override
  public CompletableFuture<Void> personaByRunTarea(final RunTareaDto runTarea) {
    this.tareaRecolectarMeta4IcmWsCalcIncomeService.personaByRunTarea(runTarea);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

  @Override
  public CompletableFuture<Void> localizacionByRunTarea(final RunTareaDto runTarea) {
    this.tareaRecolectarMeta4IcmWsCalcIncomeService.localizacionByRunTarea(runTarea);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

  @Override
  public CompletableFuture<Void> estructurasComByRunTarea(final RunTareaDto runTarea) {
    this.tareaRecolectarMeta4IcmWsCalcIncomeService.estructurasComByRunTarea(runTarea);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

  @Override
  public CompletableFuture<Void> estructurasPolByRunTarea(final RunTareaDto runTarea) {
    this.tareaRecolectarMeta4IcmWsCalcIncomeService.estructurasPolByRunTarea(runTarea);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

  @Override
  public CompletableFuture<Void> tiendasComisionableByRunTarea(final RunTareaDto runTarea) {
    this.tareaRecolectarMeta4IcmWsCalcIncomeService.tiendasComisionableByRunTarea(runTarea);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

  @Override
  public CompletableFuture<Void> presenciaManualByRunTarea(final RunTareaDto runTarea) {
    this.tareaRecolectarMeta4IcmWsCalcIncomeService.presenciaManualByRunTarea(runTarea);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

  @Override
  public CompletableFuture<Void> presenciaManualLocalizacionByRunTarea(final RunTareaDto runTarea) {
    this.tareaRecolectarMeta4IcmWsCalcIncomeService.presenciaManualLocalizacionByRunTarea(runTarea);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

  @Override
  public CompletableFuture<Void> ventaManualLocalizacionByRunTarea(final RunTareaDto runTarea) {
    this.tareaRecolectarMeta4IcmWsCalcIncomeService.ventaManualLocalizacionByRunTarea(runTarea);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

  @Override
  public CompletableFuture<Void> empleadosPresenciaByRunTarea(final RunTareaDto runTarea) {
    this.tareaRecolectarMeta4IcmWsCalcIncomeService.empleadosPresenciaByRunTarea(runTarea);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

  @Override
  public CompletableFuture<Void> coefJornadaByRunTarea(final RunTareaDto runTarea) {
    this.tareaRecolectarMeta4IcmWsCalcIncomeService.coefJornadaByRunTarea(runTarea);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

  @Override
  public CompletableFuture<Void> flagCalculaByRunTarea(final RunTareaDto runTarea) {
    this.tareaRecolectarMeta4IcmWsCalcIncomeService.flagCalculaByRunTarea(runTarea);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

  @Override
  public CompletableFuture<Void> configuracionVentaOnlineByRunTarea(final RunTareaDto runTarea) {
    this.tareaRecolectarMeta4IcmWsCalcIncomeService.configuracionVentaOnlineByRunTarea(runTarea);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

  @Override
  public CompletableFuture<Void> agrupacionesCadenaByRunTarea(final RunTareaDto runTarea) {
    this.tareaRecolectarMeta4IcmWsCalcIncomeService.agrupacionesCadenaByRunTarea(runTarea);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

  @Override
  public CompletableFuture<Void> localizacionesOnlineByRunTarea(final RunTareaDto runTarea) {
    this.tareaRecolectarMeta4IcmWsCalcIncomeService.localizacionesOnlineByRunTarea(runTarea);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

  @Override
  public CompletableFuture<Void> empleadosDesplazamientoByRunTarea(final RunTareaDto runTarea) {
    this.tareaRecolectarMeta4IcmWsCalcIncomeService.empleadosDesplazamientoByRunTarea(runTarea);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

  @Override
  public CompletableFuture<Void> ausenciasByRunTarea(final RunTareaDto runTarea) {
    this.tareaRecolectarMeta4IcmWsCalcIncomeService.ausenciasByRunTarea(runTarea);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

  @Override
  public CompletableFuture<Void> configuracionesByRunTarea(final RunTareaDto runTarea) {
    this.tareaRecolectarMeta4IcmWsCalcIncomeService.configuraciones(runTarea);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

  @Override
  public CompletableFuture<Void> confChallengeDiasMinimosByRunTarea(final RunTareaDto runTarea) {
    this.tareaRecolectarMeta4IcmWsCalcIncomeService.confChallengeDiasMinimosByRunTarea(runTarea);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

  @Override
  public CompletableFuture<Void> presupuestosWlocByRunTarea(final RunTareaDto runTarea) {
    this.tareaRecolectarMeta4IcmWsCalcIncomeService.presupuestosWlocByRunTarea(runTarea);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

  @Override
  public CompletableFuture<Void> confPrecioHoraByRunTarea(final RunTareaDto runTarea) {
    this.tareaRecolectarMeta4IcmWsCalcIncomeService.confPrecioHoraByRunTarea(runTarea);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

  @Override
  public CompletableFuture<Void> confChallengeTipoVentaByRunTarea(final RunTareaDto runTarea) {
    this.tareaRecolectarMeta4IcmWsCalcIncomeService.confChallengeTipoVentaByRunTarea(runTarea);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

  @Override
  public CompletableFuture<Void> presupuestosRangoByRunTarea(final RunTareaDto runTarea) {
    this.tareaRecolectarMeta4IcmWsCalcIncomeService.presupuestosRangoByRunTarea(runTarea);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

  @Override
  public CompletableFuture<Void> ventaCongeladaByRunTarea(final RunTareaDto runTarea) {
    this.tareaRecolectarMeta4IcmWsCalcIncomeService.ventaCongeladaByRunTarea(runTarea);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

  @Override
  public CompletableFuture<Void> desplazamientoRealByRunTarea(final RunTareaDto runTarea) {
    this.tareaRecolectarMeta4IcmWsCalcIncomeService.desplazamientoRealByRunTarea(runTarea);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

  @Override
  public CompletableFuture<Void> localizacionCadenaByRunTarea(final RunTareaDto runTarea) {
    this.tareaRecolectarMeta4IcmWsCalcIncomeService.localizacionCadenaByRunTarea(runTarea);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

  @Override
  public CompletableFuture<Void> estructurasPolByConfiguracionVentaOnlineEntregaDomicilio(
      final RunTareaDto runTarea) {
    this.tareaRecolectarMeta4IcmWsCalcIncomeService
        .estructurasPolCadenaByRunTarea(runTarea);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

  @Override
  public CompletableFuture<Void> empleadosCadenaByRunTarea(
      final RunTareaDto runTarea) {
    this.tareaRecolectarMeta4IcmWsCalcIncomeService.empleadosCadenaByRunTarea(runTarea);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

  @Override
  public CompletableFuture<Void> tiposHoraByRunTarea(
      final RunTareaDto runTarea) {
    this.tareaRecolectarMeta4IcmWsCalcIncomeService.tiposHoraByRunTarea(runTarea);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

  @Override
  public CompletableFuture<Void> estadoWlocByRunTarea(
      final RunTareaDto runTarea) {
    this.tareaRecolectarMeta4IcmWsCalcIncomeService.estadoWlocByRunTarea(runTarea);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

}
