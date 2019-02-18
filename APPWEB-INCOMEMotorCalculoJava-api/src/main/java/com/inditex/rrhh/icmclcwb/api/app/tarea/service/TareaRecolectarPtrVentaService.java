package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

import javax.validation.Valid;

import com.inditex.rrhh.icmclcwb.api.app.run.dto.RunTareaRecolectarBloqueDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;

public interface TareaRecolectarPtrVentaService {

    void ventaDetalleEmpleado(@Valid final TareaDto tarea,
            @Valid final RunTareaRecolectarBloqueDto runTareaRecolectarBloque);

    void ventaTotalizadaTienda(@Valid final TareaDto tarea,
            @Valid final RunTareaRecolectarBloqueDto runTareaRecolectarBloque);

}