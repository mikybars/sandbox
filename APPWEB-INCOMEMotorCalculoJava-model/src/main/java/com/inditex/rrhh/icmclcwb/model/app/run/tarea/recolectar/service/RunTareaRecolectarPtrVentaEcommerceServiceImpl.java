package com.inditex.rrhh.icmclcwb.model.app.run.tarea.recolectar.service;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.ambito.recolectar.service.RunTareaAmbitoRecolectarPtrVentaEcommerceService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.service.RunTareaRecolectarPtrVentaEcommerceService;

@Service
@Validated
public class RunTareaRecolectarPtrVentaEcommerceServiceImpl implements RunTareaRecolectarPtrVentaEcommerceService {

    @Autowired
    private RunTareaAmbitoRecolectarPtrVentaEcommerceService runTareaAmbitoRecolectarPtrVentaEcommerceService;

    @Override
    public void ventaOnlineIpodDetalleOperacionLocalizacionByRunTarea(@NotNull @Valid final RunTareaDto runTarea) {
        runTarea.getTarea().getAmbito().stream().forEach(item -> runTareaAmbitoRecolectarPtrVentaEcommerceService
                .ventaOnlineIpodDetalleOperacionLocalizacionByRunTareaAndTareaAmbito(runTarea, item));
    }

    @Override
    public void ventaOnlineIpodDetalleVendedorLocalizacionByRunTarea(@NotNull @Valid final RunTareaDto runTarea) {
        runTarea.getTarea().getAmbito().stream().forEach(item -> runTareaAmbitoRecolectarPtrVentaEcommerceService
                .ventaOnlineIpodDetalleVendedorLocalizacionByRunTareaAndTareaAmbito(runTarea, item));
    }

    @Override
    public void ventaOnlineIpodLocalizacionSeccionByRunTarea(@NotNull @Valid final RunTareaDto runTarea) {
        runTarea.getTarea().getAmbito().stream().forEach(item -> runTareaAmbitoRecolectarPtrVentaEcommerceService
                .ventaOnlineIpodLocalizacionSeccionByRunTareaAndTareaAmbito(runTarea, item));
    }

    @Override
    public void ventaOnlinePickingLocalizacionSeccionByRunTarea(@NotNull @Valid final RunTareaDto runTarea) {
        runTarea.getTarea().getAmbito().stream().forEach(item -> runTareaAmbitoRecolectarPtrVentaEcommerceService
                .ventaOnlinePickingLocalizacionSeccionByRunTareaAndTareaAmbito(runTarea, item));
    }

    @Override
    public void ventaOnlineEntregaTiendaLocalizacionSeccionByRunTarea(@NotNull @Valid final RunTareaDto runTarea) {
        runTarea.getTarea().getAmbito().stream().forEach(item -> runTareaAmbitoRecolectarPtrVentaEcommerceService
                .ventaOnlineEntregaTiendaLocalizacionSeccionByRunTareaAndTareaAmbito(runTarea, item));
    }
    
    @Override
    public void ventaOnlineEntregaDomicilioLocalizacionSeccionByRunTarea(@NotNull @Valid final RunTareaDto runTarea) {
        runTarea.getTarea().getAmbito().stream().forEach(item -> runTareaAmbitoRecolectarPtrVentaEcommerceService
                .ventaOnlineEntregaDomicilioLocalizacionSeccionByRunTareaAndTareaAmbito(runTarea, item));
    }
    
    @Override
    public void ventaOnlineIpodDetalleLocalizacionSeccionByRunTarea(@NotNull @Valid final RunTareaDto runTarea) {
        runTarea.getTarea().getAmbito().stream().forEach(item -> runTareaAmbitoRecolectarPtrVentaEcommerceService
                .ventaOnlineIpodDetalleLocalizacionSeccionByRunTareaAndTareaAmbito(runTarea, item));
    }
  
}
