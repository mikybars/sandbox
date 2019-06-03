package com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.service;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;

public interface RunTareaRecolectarPtrVentaGeneralService {

    void ventaFisicaLocalizacionSeccionByRunTarea(@NotNull @Valid final RunTareaDto runTarea);

    void ventaFisicaLocalizacionByRunTarea(@NotNull @Valid final RunTareaDto runTarea);

}