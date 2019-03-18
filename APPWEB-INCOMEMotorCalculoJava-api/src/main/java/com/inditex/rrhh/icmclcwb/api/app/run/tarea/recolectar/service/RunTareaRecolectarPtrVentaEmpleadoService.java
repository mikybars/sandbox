package com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.service;

import javax.validation.Valid;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaRecolectarBloqueDto;

public interface RunTareaRecolectarPtrVentaEmpleadoService {

    void ventaDetalleEmpleado(@Valid final RunTareaDto runTarea,
            @Valid final RunTareaRecolectarBloqueDto runTareaRecolectarBloque);

    void ventaFisicaPersonaLocalizacionByRunTarea(@Valid final RunTareaDto runTarea);

    void ventaFisicaPersonaOperacionLocalizacionByRunTarea(@Valid final RunTareaDto runTarea);

}
