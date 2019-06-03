package com.inditex.rrhh.icmclcwb.model.app.run.tarea.recolectar.service;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.ambito.recolectar.service.RunTareaAmbitoRecolectarPtrVentaEmpleadoService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.service.RunTareaRecolectarPtrVentaEmpleadoService;

@Service
@Validated
public class RunTareaRecolectarPtrVentaEmpleadoServiceImpl implements RunTareaRecolectarPtrVentaEmpleadoService {

    @Autowired
    private RunTareaAmbitoRecolectarPtrVentaEmpleadoService runTareaAmbitoRecolectarPtrVentaEmpleadoService;
    
    @Override
    public void ventaFisicaDetalleLocalizacionByRunTarea(@NotNull @Valid final RunTareaDto runTarea) {
        runTarea.getTarea().getAmbito().stream().forEach(item -> runTareaAmbitoRecolectarPtrVentaEmpleadoService
                .ventaFisicaDetalleLocalizacionByRunTareaAndTareaAmbito(runTarea, item));
    }
    
    @Override
    public void ventaFisicaDetalleOperacionLocalizacionByRunTarea(@NotNull @Valid final RunTareaDto runTarea) {
        runTarea.getTarea().getAmbito().stream().forEach(item -> runTareaAmbitoRecolectarPtrVentaEmpleadoService
                .ventaFisicaDetalleOperacionLocalizacionByRunTareaAndTareaAmbito(runTarea, item));
    }

    @Override
    public void ventaFisicaDetalleOperacionVendedorLocalizacionByRunTarea(@NotNull @Valid final RunTareaDto runTarea) {
        runTarea.getTarea().getAmbito().stream().forEach(item -> runTareaAmbitoRecolectarPtrVentaEmpleadoService
                .ventaFisicaDetalleOperacionVendedorLocalizacionByRunTareaAndTareaAmbito(runTarea, item));
    }

    @Override
    public void ventaFisicaDetalleVendedorLocalizacionByRunTarea(@NotNull @Valid final RunTareaDto runTarea) {
        runTarea.getTarea().getAmbito().stream().forEach(item -> runTareaAmbitoRecolectarPtrVentaEmpleadoService
                .ventaFisicaDetalleVendedorLocalizacionByRunTareaAndTareaAmbito(runTarea, item));
    }

}
