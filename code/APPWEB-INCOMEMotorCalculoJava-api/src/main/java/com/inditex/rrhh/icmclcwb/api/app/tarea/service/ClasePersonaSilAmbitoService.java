package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.ClasePersonaSilAmbitoDto;

import org.jspecify.annotations.NonNull;

public interface ClasePersonaSilAmbitoService {

  List<ClasePersonaSilAmbitoDto> getClaseAndEstadoByCclIdOrigenAndStdIdLegEnt(@NonNull String cclIdOrigen, @NonNull String stdIdLegEnt);

}
