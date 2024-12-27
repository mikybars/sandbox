package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

/*
 * Copyright (c) 2022. Inditex
 */
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.MailAmbitoDto;

import org.jspecify.annotations.NonNull;

public interface MailAmbitoRepositoryCustom {

  /**
   * Recupera el mail asociado a un origen y empresa.
   *
   * @param cclIdOrigen cclIdOrigen
   * @param stdIdLegEnt stdIdLegEnt
   */
  List<MailAmbitoDto> findMailByCclIdOrigenAndStdIdLegEnt(@NonNull String cclIdOrigen, @NonNull String stdIdLegEnt);

}
