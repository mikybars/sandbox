package com.inditex.rrhh.icmclcwb.api.app.run.tarea.consolidar.service;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public interface RunTareaConsolidarByAmbitoLocalizacionService {

  void run(@NotNull @Valid RunTareaDto runTarea);

}
