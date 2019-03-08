package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

import javax.validation.Valid;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaRecolectarBloqueDto;

public interface RunTareaRecolectarPtrPresenciaService {

    void tiposHoras(@Valid final RunTareaDto runTarea, @Valid final RunTareaRecolectarBloqueDto runTareaRecolectarBloque);

    void presenciaDetalleComisionable(@Valid final RunTareaDto runTarea, @Valid final RunTareaRecolectarBloqueDto runTareaRecolectarBloque);

    void presenciaTotalizadaTiendaSeccion(@Valid final RunTareaDto runTarea, @Valid final RunTareaRecolectarBloqueDto runTareaRecolectarBloque);

    void presenciaTotalizadaTienda(@Valid RunTareaDto runTarea,
            @Valid RunTareaRecolectarBloqueDto runTareaRecolectarBloque);

}