package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalDto;

import jakarta.validation.constraints.NotNull;

public interface TareaCalculoPendienteService {

  List<IdPersonaLocalDto> findPersonaCalculoPendiente(@NotNull Long idTarea, @NotNull String cclIdOrigen,
      @NotNull String stdIdLegEnt);
}
