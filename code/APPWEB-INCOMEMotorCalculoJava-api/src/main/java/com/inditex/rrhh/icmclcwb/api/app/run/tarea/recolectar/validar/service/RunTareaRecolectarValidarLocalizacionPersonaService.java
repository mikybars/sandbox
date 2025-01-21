package com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.validar.service;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaValidarDto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public interface RunTareaRecolectarValidarLocalizacionPersonaService {

  List<RunTareaValidarDto> run(@NotNull @Valid final RunTareaDto runTarea);

}
