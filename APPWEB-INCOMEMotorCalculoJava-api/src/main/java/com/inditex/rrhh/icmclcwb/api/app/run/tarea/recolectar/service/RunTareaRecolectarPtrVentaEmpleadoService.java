package com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.service;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;

public interface RunTareaRecolectarPtrVentaEmpleadoService {

    void ventaFisicaDetalleLocalizacionByRunTarea(@NotNull @Valid final RunTareaDto runTarea);

    void ventaFisicaDetalleOperacionLocalizacionByRunTarea(@NotNull @Valid final RunTareaDto runTarea);

    void ventaFisicaDetalleOperacionVendedorLocalizacionByRunTarea(@NotNull @Valid final RunTareaDto runTarea);

    void ventaFisicaDetalleVendedorLocalizacionByRunTarea(@NotNull @Valid final RunTareaDto runTarea);

}
