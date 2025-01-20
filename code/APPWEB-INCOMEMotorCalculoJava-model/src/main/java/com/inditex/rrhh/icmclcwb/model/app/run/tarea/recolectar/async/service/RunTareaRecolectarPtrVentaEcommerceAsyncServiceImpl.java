package com.inditex.rrhh.icmclcwb.model.app.run.tarea.recolectar.async.service;

import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.async.service.RunTareaRecolectarPtrVentaEcommerceAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.service.RunTareaRecolectarPtrVentaEcommerceService;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RunTareaRecolectarPtrVentaEcommerceAsyncServiceImpl
    implements RunTareaRecolectarPtrVentaEcommerceAsyncService {

  private final RunTareaRecolectarPtrVentaEcommerceService tareaRecolectarPtrVentaEcommerceService;

  @Override
  public CompletableFuture<Void> ventaOnlineEntregaDomicilioCadenaByRunTarea(final RunTareaDto runTarea) {
    tareaRecolectarPtrVentaEcommerceService.ventaOnlineEntregaDomicilioCadenaByRunTarea(runTarea);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

  @Override
  public CompletableFuture<Void> ventaOnlineEntregaTiendaLocalizacionSeccionByRunTarea(final RunTareaDto runTarea) {
    tareaRecolectarPtrVentaEcommerceService.ventaOnlineEntregaTiendaLocalizacionSeccionByRunTarea(runTarea);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

  @Override
  public CompletableFuture<Void> ventaOnlineIpodLocalizacionSeccionByRunTarea(final RunTareaDto runTarea) {
    tareaRecolectarPtrVentaEcommerceService.ventaOnlineIpodLocalizacionSeccionByRunTarea(runTarea);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

  @Override
  public CompletableFuture<Void> ventaOnlinePickingLocalizacionSeccionByRunTarea(final RunTareaDto runTarea) {
    tareaRecolectarPtrVentaEcommerceService.ventaOnlinePickingLocalizacionSeccionByRunTarea(runTarea);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

  @Override
  public CompletableFuture<Void> ventaOnlineIpodLocalizacionPersonaByRunTarea(RunTareaDto runTarea) {
    tareaRecolectarPtrVentaEcommerceService.ventaOnlineIpodLocalizacionPersonaByRunTarea(runTarea);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

  @Override
  public CompletableFuture<Void> ventaRangoOnlineIpodLocalizacionSeccionByRunTarea(RunTareaDto runTarea) {
    tareaRecolectarPtrVentaEcommerceService.ventaRangoOnlineIpodLocalizacionSeccionByRunTarea(runTarea);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

  @Override
  public CompletableFuture<Void> ventaRangoOnlineSintLocalizacionSeccionByRunTarea(RunTareaDto runTarea) {
    tareaRecolectarPtrVentaEcommerceService.ventaRangoOnlineSintLocalizacionSeccionByRunTarea(runTarea);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

  @Override
  public CompletableFuture<Void> ventaRangoOnlineEntregaTiendaLocalizacionSeccionByRunTarea(RunTareaDto runTarea) {
    tareaRecolectarPtrVentaEcommerceService.ventaRangoOnlineEntregaTiendaLocalizacionSeccionByRunTarea(runTarea);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

  @Override
  public CompletableFuture<Void> ventaRangoOnlineEntregaDomicilioLocalizacionSeccionByRunTarea(RunTareaDto runTarea) {
    tareaRecolectarPtrVentaEcommerceService.ventaRangoOnlineEntregaDomicilioLocalizacionSeccionByRunTarea(runTarea);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

  @Override
  public CompletableFuture<Void> updateActivoVentaOnlineIpodByRunTarea(RunTareaDto runTarea) {
    tareaRecolectarPtrVentaEcommerceService.updateActivoVentaOnlineIpodByRunTarea(runTarea);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

  @Override
  public CompletableFuture<Void> updateActivoVentaOnlinePickingByRunTarea(RunTareaDto runTarea) {
    tareaRecolectarPtrVentaEcommerceService.updateActivoVentaOnlinePickingByRunTarea(runTarea);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

  @Override
  public CompletableFuture<Void> updateActivoVentaOnlineEntregaTiendaByRunTarea(RunTareaDto runTarea) {
    tareaRecolectarPtrVentaEcommerceService.updateActivoVentaOnlineEntregaTiendaByRunTarea(runTarea);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

  @Override
  public CompletableFuture<Void> updateActivoVentaOnlineEntregaDomicilioByRunTarea(RunTareaDto runTarea) {
    tareaRecolectarPtrVentaEcommerceService.updateActivoVentaOnlineEntregaDomicilioByRunTarea(runTarea);
    return CompletableFuture.completedFuture(AsyncConstants.NIL);
  }

}
