package com.inditex.rrhh.icmclcwb.api.app.run.tarea.validar.service;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;

public interface RunTareaRecolectarValidarTiendaPresenciaSeccionService {

    RunTareaDto run(@NotNull @Valid RunTareaDto runTarea);

}
