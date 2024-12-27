package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.ClasePersonaSilAmbitoDto;

import org.jspecify.annotations.NonNull;

public interface ClasePersonaSilAmbitoRepositoryCustom {

  /**
   * Recupera las clases y estados asociados a un origen y empresa.
   *
   * @param cclIdOrigen cclIdOrigen
   * @param stdIdLegEnt stdIdLegEnt
   */
  List<ClasePersonaSilAmbitoDto> findClaseEstadoByCclIdOrigenAndStdIdLegEnt(@NonNull String cclIdOrigen, @NonNull String stdIdLegEnt);
}
