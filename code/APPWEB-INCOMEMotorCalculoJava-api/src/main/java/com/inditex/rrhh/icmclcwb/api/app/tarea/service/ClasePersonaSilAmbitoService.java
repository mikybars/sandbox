package com.inditex.rrhh.icmclcwb.api.app.tarea.service;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.ClasePersonaSilAmbitoDto;

import javax.validation.constraints.NotNull;

public interface ClasePersonaSilAmbitoService {

  List<ClasePersonaSilAmbitoDto> getClaseAndEstadoByCclIdOrigenAndStdIdLegEnt(@NotNull String cclIdOrigen, @NotNull String stdIdLegEnt);

}
