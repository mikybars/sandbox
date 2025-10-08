package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalDto;

import jakarta.validation.constraints.NotNull;

public interface TareaCalculoPorcentajeService {

  List<IdPersonaLocalDto> findPersonaPorcetaje0(@NotNull Long idTarea);
}
