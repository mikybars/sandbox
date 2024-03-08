package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.ReglaEmpleadoExternoMeta4RequestDto;

import javax.validation.constraints.NotNull;

public interface ReglaEmpleadoExternoMeta4Service {

  ReglaEmpleadoExternoMeta4RequestDto getReglasEmpleadoExternoMeta4ActivasByCclIdOrigen(@NotNull String cclIdOrigen,
      @NotNull String stdIdLegEnt);

}
