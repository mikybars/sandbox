package com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.service;

import javax.validation.Valid;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;

public interface RunTareaRecolectarPtrVentaEmpleadoService {

    void ventaFisicaDetalleLocalizacionByRunTarea(@Valid final RunTareaDto runTarea);

    void ventaFisicaDetalleOperacionLocalizacionByRunTarea(@Valid final RunTareaDto runTarea);

    void ventaFisicaDetalleOperacionVendedorLocalizacionByRunTarea(@Valid final RunTareaDto runTarea);

    void ventaFisicaDetalleVendedorLocalizacionByRunTarea(@Valid final RunTareaDto runTarea);

}
