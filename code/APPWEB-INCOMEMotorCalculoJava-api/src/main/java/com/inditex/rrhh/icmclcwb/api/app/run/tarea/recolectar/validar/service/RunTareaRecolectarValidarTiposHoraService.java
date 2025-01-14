package com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.validar.service;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaValidarDto;

import jakarta.validation.Valid;
import org.jspecify.annotations.NonNull;

public interface RunTareaRecolectarValidarTiposHoraService {

  List<RunTareaValidarDto> run(@NonNull @Valid final RunTareaDto runTarea);

}
