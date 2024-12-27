package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

/*
 * Copyright (c) 2022. Inditex
 */
import java.util.List;

import org.jspecify.annotations.NonNull;

public interface MailAmbitoService {

  List<String> getMailByCclIdOrigenAndStdIdLegEnt(@NonNull String cclIdOrigen, @NonNull String stdIdLegEnt);

}
