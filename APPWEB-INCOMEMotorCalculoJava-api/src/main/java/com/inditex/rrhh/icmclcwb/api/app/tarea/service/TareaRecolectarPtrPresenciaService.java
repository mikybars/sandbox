package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

import javax.validation.Valid;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaRecolectarBloqueDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;

public interface TareaRecolectarPtrPresenciaService {

    void tiposHoras(@Valid final TareaDto tarea, @Valid final RunTareaRecolectarBloqueDto runTareaRecolectarBloque);

    void presenciaDetalleEmpleado(@Valid final TareaDto tarea, @Valid final RunTareaRecolectarBloqueDto runTareaRecolectarBloque);

    void presenciaTotalizadaTienda(@Valid final TareaDto tarea, @Valid final RunTareaRecolectarBloqueDto runTareaRecolectarBloque);

}