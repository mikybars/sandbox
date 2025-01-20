package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

/*
 * Copyright (c) 2022. Inditex
 */

import java.util.List;

import jakarta.validation.constraints.NotNull;

public interface MailAmbitoService {

  List<String> getMailByCclIdOrigenAndStdIdLegEnt(@NotNull String cclIdOrigen, @NotNull String stdIdLegEnt);

}
