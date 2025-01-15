package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.ReglaEmpleadoExternoMeta4RequestDto;

import jakarta.validation.constraints.NotNull;

public interface ReglaEmpleadoExternoMeta4Service {

  List<ReglaEmpleadoExternoMeta4RequestDto> getReglasEmpleadoExternoMeta4ActivasByCclIdOrigen(@NotNull String cclIdOrigen,
      @NotNull String stdIdLegEnt);

}
