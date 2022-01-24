package com.inditex.rrhh.icmclcwb.model.app.run.tarea.recolectar.service;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.ambito.recolectar.service.RunTareaAmbitoRecolectarPtrVentaEcommerceService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.service.RunTareaRecolectarPtrVentaEcommerceService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaAgrupacionVentaService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaLocalizacionVentaService;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class RunTareaRecolectarPtrVentaEcommerceServiceImpl implements RunTareaRecolectarPtrVentaEcommerceService {

  @Autowired
  private RunTareaAmbitoRecolectarPtrVentaEcommerceService runTareaAmbitoRecolectarPtrVentaEcommerceService;

  @Autowired
  private TareaLocalizacionVentaService tareaLocalizacionVentaService;

  @Autowired
  private TareaAgrupacionVentaService tareaAgrupacionVentaService;

  @Override
  public void ventaOnlineIpodLocalizacionSeccionByRunTarea(@NotNull @Valid final RunTareaDto runTarea) {
    runTarea.getTarea()
        .getAmbito()
        .stream()
        .forEach(item -> runTareaAmbitoRecolectarPtrVentaEcommerceService
            .ventaOnlineIpodLocalizacionSeccionByRunTareaAndTareaAmbito(runTarea, item));
  }

  @Override
  public void ventaOnlinePickingLocalizacionSeccionByRunTarea(@NotNull @Valid final RunTareaDto runTarea) {
    runTarea.getTarea()
        .getAmbito()
        .stream()
        .forEach(item -> runTareaAmbitoRecolectarPtrVentaEcommerceService
            .ventaOnlinePickingLocalizacionSeccionByRunTareaAndTareaAmbito(runTarea, item));
  }

  @Override
  public void ventaOnlineEntregaTiendaLocalizacionSeccionByRunTarea(@NotNull @Valid final RunTareaDto runTarea) {
    runTarea.getTarea()
        .getAmbito()
        .stream()
        .forEach(item -> runTareaAmbitoRecolectarPtrVentaEcommerceService
            .ventaOnlineEntregaTiendaLocalizacionSeccionByRunTareaAndTareaAmbito(runTarea, item));
  }

  @Override
  public void ventaOnlineEntregaDomicilioCadenaByRunTarea(@NotNull @Valid final RunTareaDto runTarea) {
    runTarea.getTarea()
        .getAmbito()
        .stream()
        .forEach(item -> runTareaAmbitoRecolectarPtrVentaEcommerceService
            .ventaOnlineEntregaDomicilioCadenaByRunTareaAndTareaAmbito(runTarea, item));
  }

  @Override
  public void ventaOnlineIpodLocalizacionPersonaByRunTarea(@NotNull @Valid RunTareaDto runTarea) {
    runTarea.getTarea()
        .getAmbito()
        .stream()
        .forEach(item -> runTareaAmbitoRecolectarPtrVentaEcommerceService
            .ventaOnlineIpodLocalizacionPersonaByRunTareaAndTareaAmbito(runTarea, item));
  }

  @Override
  public void ventaRangoOnlineIpodLocalizacionSeccionByRunTarea(@NotNull @Valid RunTareaDto runTarea) {
    runTarea.getTarea()
        .getAmbito()
        .stream()
        .forEach(item -> runTareaAmbitoRecolectarPtrVentaEcommerceService
            .ventaRangoOnlineIpodLocalizacionSeccionByRunTareaAndTareaAmbito(runTarea, item));
  }

  @Override
  public void ventaRangoOnlineSintLocalizacionSeccionByRunTarea(@NotNull @Valid RunTareaDto runTarea) {
    runTarea.getTarea()
        .getAmbito()
        .stream()
        .forEach(item -> runTareaAmbitoRecolectarPtrVentaEcommerceService
            .ventaRangoOnlineSintLocalizacionSeccionByRunTareaAndTareaAmbito(runTarea, item));
  }

  @Override
  public void ventaRangoOnlineEntregaTiendaLocalizacionSeccionByRunTarea(@NotNull @Valid RunTareaDto runTarea) {
    runTarea.getTarea()
        .getAmbito()
        .stream()
        .forEach(item -> runTareaAmbitoRecolectarPtrVentaEcommerceService
            .ventaRangoOnlineEntregaTiendaLocalizacionSeccionByRunTareaAndTareaAmbito(runTarea, item));
  }

  @Override
  public void ventaRangoOnlineEntregaDomicilioLocalizacionSeccionByRunTarea(@NotNull @Valid RunTareaDto runTarea) {
    runTarea.getTarea()
        .getAmbito()
        .stream()
        .forEach(item -> runTareaAmbitoRecolectarPtrVentaEcommerceService
            .ventaRangoOnlineEntregaDomicilioLocalizacionSeccionByRunTareaAndTareaAmbito(runTarea, item));
  }

  @Override
  public void updateActivoVentaOnlineIpodByRunTarea(@NotNull @Valid RunTareaDto runTarea) {
    tareaLocalizacionVentaService.updateActivoVentaOnlineIpod(runTarea.getTarea());
  }

  @Override
  public void updateActivoVentaOnlinePickingByRunTarea(@NotNull @Valid RunTareaDto runTarea) {
    tareaLocalizacionVentaService.updateActivoVentaOnlinePicking(runTarea.getTarea());
  }

  @Override
  public void updateActivoVentaOnlineEntregaTiendaByRunTarea(@NotNull @Valid RunTareaDto runTarea) {
    tareaLocalizacionVentaService.updateActivoVentaOnlineEntregaTienda(runTarea.getTarea());
  }

  @Override
  public void updateActivoVentaOnlineEntregaDomicilioByRunTarea(@NotNull @Valid RunTareaDto runTarea) {
    tareaAgrupacionVentaService.updateActivoVentaOnlineEntregaDomicilio(runTarea.getTarea());
  }

}
