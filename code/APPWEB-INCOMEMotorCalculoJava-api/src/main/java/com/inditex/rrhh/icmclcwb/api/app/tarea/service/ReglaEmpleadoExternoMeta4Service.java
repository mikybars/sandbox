package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.ReglaEmpleadoExternoMeta4RequestDto;

import org.jspecify.annotations.NonNull;

public interface ReglaEmpleadoExternoMeta4Service {

  List<ReglaEmpleadoExternoMeta4RequestDto> getReglasEmpleadoExternoMeta4ActivasByCclIdOrigen(@NonNull String cclIdOrigen,
      @NonNull String stdIdLegEnt);

}
