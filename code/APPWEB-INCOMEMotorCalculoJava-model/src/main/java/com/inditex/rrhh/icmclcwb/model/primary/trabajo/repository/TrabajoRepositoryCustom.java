package com.inditex.rrhh.icmclcwb.model.primary.trabajo.repository;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.dto.IdOrigenEmpresaDto;
import com.inditex.rrhh.icmclcwb.dto.EstadoTrabajoDTO;
import com.inditex.rrhh.icmclcwb.dto.TrabajoDTO;

import org.jspecify.annotations.NonNull;

public interface TrabajoRepositoryCustom {

  void updateEstado(@NonNull final TrabajoDTO trabajo, @NonNull final EstadoTrabajoDTO estado);

  void updateFechaFin(@NonNull final TrabajoDTO trabajo);

  List<IdOrigenEmpresaDto> findEmpresasCalcularProgramados(@NonNull final TrabajoDTO trabajo, @NonNull final List<String> stdIdLegEnt,
      @NonNull final List<String> cclIdOrigen);
}
