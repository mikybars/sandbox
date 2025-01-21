package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.ReglaEmpleadoExternoMeta4Dto;

import jakarta.validation.constraints.NotNull;

public interface ReglaEmpleadoExternoMeta4RepositoryCustom {

  /**
   * Recupera las reglas activas para empleados externos de meta4 por origen.
   *
   * @param cclIdOrigen cclIdOrigen
   */
  List<ReglaEmpleadoExternoMeta4Dto> findReglasEmpleadoExternoMeta4ActivasByCclIdOrigen(@NotNull String cclIdOrigen,
      @NotNull String stdIdLegEnt);

}
