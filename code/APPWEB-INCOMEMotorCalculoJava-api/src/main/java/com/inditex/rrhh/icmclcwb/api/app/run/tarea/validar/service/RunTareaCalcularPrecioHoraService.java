package com.inditex.rrhh.icmclcwb.api.app.run.tarea.validar.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.dto.ValidacionDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaFaseAccionDto;

import jakarta.validation.Valid;

public interface RunTareaCalcularPrecioHoraService {

  CompletableFuture<List<ValidacionDto>> execute(@Valid RunTareaDto runTareaDto, @Valid final TareaFaseAccionDto tareaFaseAccion);

}
