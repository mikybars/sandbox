package com.inditex.rrhh.icmclcwb.model.primary.trabajo.repository;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.dto.IdOrigenEmpresaDto;
import com.inditex.rrhh.icmclcwb.dto.EstadoTrabajoDTO;
import com.inditex.rrhh.icmclcwb.dto.TrabajoDTO;

import javax.validation.constraints.NotNull;

public interface TrabajoRepositoryCustom {

  void updateEstado(@NotNull final TrabajoDTO trabajo, @NotNull final EstadoTrabajoDTO estado);

  void updateFechaFin(@NotNull final TrabajoDTO trabajo);

  List<IdOrigenEmpresaDto> findEmpresasCalcularProgramados(@NotNull final TrabajoDTO trabajo, @NotNull final List<String> stdIdLegEnt,
      @NotNull final List<String> cclIdOrigen);
}
