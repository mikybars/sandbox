package com.inditex.rrhh.icmclcwb.model.app.run.tarea.recolectar.service;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.ambito.recolectar.service.RunTareaAmbitoRecolectarPtrVentaEcommerceService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.service.RunTareaRecolectarPtrVentaEcommerceService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaAgrupacionVentaService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaLocalizacionVentaService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
@RequiredArgsConstructor
public class RunTareaRecolectarPtrVentaEcommerceServiceImpl implements RunTareaRecolectarPtrVentaEcommerceService {

  private final RunTareaAmbitoRecolectarPtrVentaEcommerceService runTareaAmbitoRecolectarPtrVentaEcommerceService;

  private final TareaLocalizacionVentaService tareaLocalizacionVentaService;

  private final TareaAgrupacionVentaService tareaAgrupacionVentaService;

  @Override
  public void ventaOnlineIpodLocalizacionSeccionByRunTarea(@NotNull @Valid final RunTareaDto runTarea) {
    runTarea.getTarea()
        .getAmbito()
        .stream()
        .forEach(item -> this.runTareaAmbitoRecolectarPtrVentaEcommerceService
            .ventaOnlineIpodLocalizacionSeccionByRunTareaAndTareaAmbito(runTarea, item));
  }

  @Override
  public void ventaOnlinePickingLocalizacionSeccionByRunTarea(@NotNull @Valid final RunTareaDto runTarea) {
    runTarea.getTarea()
        .getAmbito()
        .stream()
        .forEach(item -> this.runTareaAmbitoRecolectarPtrVentaEcommerceService
            .ventaOnlinePickingLocalizacionSeccionByRunTareaAndTareaAmbito(runTarea, item));
  }

  @Override
  public void ventaOnlineEntregaTiendaLocalizacionSeccionByRunTarea(@NotNull @Valid final RunTareaDto runTarea) {
    runTarea.getTarea()
        .getAmbito()
        .stream()
        .forEach(item -> this.runTareaAmbitoRecolectarPtrVentaEcommerceService
            .ventaOnlineEntregaTiendaLocalizacionSeccionByRunTareaAndTareaAmbito(runTarea, item));
  }

  @Override
  public void ventaOnlineEntregaDomicilioCadenaByRunTarea(@NotNull @Valid final RunTareaDto runTarea) {
    runTarea.getTarea()
        .getAmbito()
        .stream()
        .forEach(item -> this.runTareaAmbitoRecolectarPtrVentaEcommerceService
            .ventaOnlineEntregaDomicilioCadenaByRunTareaAndTareaAmbito(runTarea, item));
  }

  @Override
  public void ventaOnlineIpodLocalizacionPersonaByRunTarea(@NotNull @Valid RunTareaDto runTarea) {
    runTarea.getTarea()
        .getAmbito()
        .stream()
        .forEach(item -> this.runTareaAmbitoRecolectarPtrVentaEcommerceService
            .ventaOnlineIpodLocalizacionPersonaByRunTareaAndTareaAmbito(runTarea, item));
  }

  @Override
  public void ventaRangoOnlineIpodLocalizacionSeccionByRunTarea(@NotNull @Valid RunTareaDto runTarea) {
    runTarea.getTarea()
        .getAmbito()
        .stream()
        .forEach(item -> this.runTareaAmbitoRecolectarPtrVentaEcommerceService
            .ventaRangoOnlineIpodLocalizacionSeccionByRunTareaAndTareaAmbito(runTarea, item));
  }

  @Override
  public void ventaRangoOnlineSintLocalizacionSeccionByRunTarea(@NotNull @Valid RunTareaDto runTarea) {
    runTarea.getTarea()
        .getAmbito()
        .stream()
        .forEach(item -> this.runTareaAmbitoRecolectarPtrVentaEcommerceService
            .ventaRangoOnlineSintLocalizacionSeccionByRunTareaAndTareaAmbito(runTarea, item));
  }

  @Override
  public void ventaRangoOnlineEntregaTiendaLocalizacionSeccionByRunTarea(@NotNull @Valid RunTareaDto runTarea) {
    runTarea.getTarea()
        .getAmbito()
        .stream()
        .forEach(item -> this.runTareaAmbitoRecolectarPtrVentaEcommerceService
            .ventaRangoOnlineEntregaTiendaLocalizacionSeccionByRunTareaAndTareaAmbito(runTarea, item));
  }

  @Override
  public void ventaRangoOnlineEntregaDomicilioLocalizacionSeccionByRunTarea(@NotNull @Valid RunTareaDto runTarea) {
    runTarea.getTarea()
        .getAmbito()
        .stream()
        .forEach(item -> this.runTareaAmbitoRecolectarPtrVentaEcommerceService
            .ventaRangoOnlineEntregaDomicilioLocalizacionSeccionByRunTareaAndTareaAmbito(runTarea, item));
  }

  @Override
  public void updateActivoVentaOnlineIpodByRunTarea(@NotNull @Valid RunTareaDto runTarea) {
    this.tareaLocalizacionVentaService.updateActivoVentaOnlineIpod(runTarea.getTarea());
  }

  @Override
  public void updateActivoVentaOnlinePickingByRunTarea(@NotNull @Valid RunTareaDto runTarea) {
    this.tareaLocalizacionVentaService.updateActivoVentaOnlinePicking(runTarea.getTarea());
  }

  @Override
  public void updateActivoVentaOnlineEntregaTiendaByRunTarea(@NotNull @Valid RunTareaDto runTarea) {
    this.tareaLocalizacionVentaService.updateActivoVentaOnlineEntregaTienda(runTarea.getTarea());
  }

  @Override
  public void updateActivoVentaOnlineEntregaDomicilioByRunTarea(@NotNull @Valid RunTareaDto runTarea) {
    this.tareaAgrupacionVentaService.updateActivoVentaOnlineEntregaDomicilio(runTarea.getTarea());
  }

}
