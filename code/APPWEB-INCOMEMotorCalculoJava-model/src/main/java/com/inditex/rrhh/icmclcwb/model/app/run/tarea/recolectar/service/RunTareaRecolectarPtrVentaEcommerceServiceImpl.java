package com.inditex.rrhh.icmclcwb.model.app.run.tarea.recolectar.service;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.ambito.recolectar.service.RunTareaAmbitoRecolectarPtrVentaEcommerceService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.service.RunTareaRecolectarPtrVentaEcommerceService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaAgrupacionVentaService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaLocalizacionVentaService;

import jakarta.validation.Valid;
import org.jspecify.annotations.NonNull;
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
  public void ventaOnlineIpodLocalizacionSeccionByRunTarea(@NonNull @Valid final RunTareaDto runTarea) {
    runTarea.getTarea()
        .getAmbito()
        .stream()
        .forEach(item -> runTareaAmbitoRecolectarPtrVentaEcommerceService
            .ventaOnlineIpodLocalizacionSeccionByRunTareaAndTareaAmbito(runTarea, item));
  }

  @Override
  public void ventaOnlinePickingLocalizacionSeccionByRunTarea(@NonNull @Valid final RunTareaDto runTarea) {
    runTarea.getTarea()
        .getAmbito()
        .stream()
        .forEach(item -> runTareaAmbitoRecolectarPtrVentaEcommerceService
            .ventaOnlinePickingLocalizacionSeccionByRunTareaAndTareaAmbito(runTarea, item));
  }

  @Override
  public void ventaOnlineEntregaTiendaLocalizacionSeccionByRunTarea(@NonNull @Valid final RunTareaDto runTarea) {
    runTarea.getTarea()
        .getAmbito()
        .stream()
        .forEach(item -> runTareaAmbitoRecolectarPtrVentaEcommerceService
            .ventaOnlineEntregaTiendaLocalizacionSeccionByRunTareaAndTareaAmbito(runTarea, item));
  }

  @Override
  public void ventaOnlineEntregaDomicilioCadenaByRunTarea(@NonNull @Valid final RunTareaDto runTarea) {
    runTarea.getTarea()
        .getAmbito()
        .stream()
        .forEach(item -> runTareaAmbitoRecolectarPtrVentaEcommerceService
            .ventaOnlineEntregaDomicilioCadenaByRunTareaAndTareaAmbito(runTarea, item));
  }

  @Override
  public void ventaOnlineIpodLocalizacionPersonaByRunTarea(@NonNull @Valid RunTareaDto runTarea) {
    runTarea.getTarea()
        .getAmbito()
        .stream()
        .forEach(item -> runTareaAmbitoRecolectarPtrVentaEcommerceService
            .ventaOnlineIpodLocalizacionPersonaByRunTareaAndTareaAmbito(runTarea, item));
  }

  @Override
  public void ventaRangoOnlineIpodLocalizacionSeccionByRunTarea(@NonNull @Valid RunTareaDto runTarea) {
    runTarea.getTarea()
        .getAmbito()
        .stream()
        .forEach(item -> runTareaAmbitoRecolectarPtrVentaEcommerceService
            .ventaRangoOnlineIpodLocalizacionSeccionByRunTareaAndTareaAmbito(runTarea, item));
  }

  @Override
  public void ventaRangoOnlineSintLocalizacionSeccionByRunTarea(@NonNull @Valid RunTareaDto runTarea) {
    runTarea.getTarea()
        .getAmbito()
        .stream()
        .forEach(item -> runTareaAmbitoRecolectarPtrVentaEcommerceService
            .ventaRangoOnlineSintLocalizacionSeccionByRunTareaAndTareaAmbito(runTarea, item));
  }

  @Override
  public void ventaRangoOnlineEntregaTiendaLocalizacionSeccionByRunTarea(@NonNull @Valid RunTareaDto runTarea) {
    runTarea.getTarea()
        .getAmbito()
        .stream()
        .forEach(item -> runTareaAmbitoRecolectarPtrVentaEcommerceService
            .ventaRangoOnlineEntregaTiendaLocalizacionSeccionByRunTareaAndTareaAmbito(runTarea, item));
  }

  @Override
  public void ventaRangoOnlineEntregaDomicilioLocalizacionSeccionByRunTarea(@NonNull @Valid RunTareaDto runTarea) {
    runTarea.getTarea()
        .getAmbito()
        .stream()
        .forEach(item -> runTareaAmbitoRecolectarPtrVentaEcommerceService
            .ventaRangoOnlineEntregaDomicilioLocalizacionSeccionByRunTareaAndTareaAmbito(runTarea, item));
  }

  @Override
  public void updateActivoVentaOnlineIpodByRunTarea(@NonNull @Valid RunTareaDto runTarea) {
    tareaLocalizacionVentaService.updateActivoVentaOnlineIpod(runTarea.getTarea());
  }

  @Override
  public void updateActivoVentaOnlinePickingByRunTarea(@NonNull @Valid RunTareaDto runTarea) {
    tareaLocalizacionVentaService.updateActivoVentaOnlinePicking(runTarea.getTarea());
  }

  @Override
  public void updateActivoVentaOnlineEntregaTiendaByRunTarea(@NonNull @Valid RunTareaDto runTarea) {
    tareaLocalizacionVentaService.updateActivoVentaOnlineEntregaTienda(runTarea.getTarea());
  }

  @Override
  public void updateActivoVentaOnlineEntregaDomicilioByRunTarea(@NonNull @Valid RunTareaDto runTarea) {
    tareaAgrupacionVentaService.updateActivoVentaOnlineEntregaDomicilio(runTarea.getTarea());
  }

}
