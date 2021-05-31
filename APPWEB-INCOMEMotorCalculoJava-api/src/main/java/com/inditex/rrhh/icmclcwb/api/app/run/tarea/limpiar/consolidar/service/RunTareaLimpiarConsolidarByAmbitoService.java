package com.inditex.rrhh.icmclcwb.api.app.run.tarea.limpiar.consolidar.service;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;

public interface RunTareaLimpiarConsolidarByAmbitoService {

    void run(@NotNull @Valid RunTareaDto runTarea);

}
