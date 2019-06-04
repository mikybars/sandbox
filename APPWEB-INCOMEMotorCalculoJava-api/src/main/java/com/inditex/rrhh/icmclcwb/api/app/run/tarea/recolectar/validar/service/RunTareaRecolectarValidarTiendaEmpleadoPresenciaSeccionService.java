package com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.validar.service;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaValidarDto;

public interface RunTareaRecolectarValidarTiendaEmpleadoPresenciaSeccionService {

    List<RunTareaValidarDto> run(@NotNull @Valid final RunTareaDto runTarea);

}
