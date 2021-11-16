package com.inditex.rrhh.icmclcwb.model.primary.trabajo.repository;

import com.inditex.rrhh.icmclcwb.dto.EstadoTrabajoDTO;
import com.inditex.rrhh.icmclcwb.dto.TrabajoDTO;

import javax.validation.constraints.NotNull;

public interface TrabajoRepositoryCustom {

  void updateEstado(@NotNull final TrabajoDTO trabajo, @NotNull final EstadoTrabajoDTO estado);

  void updateFechaFin(@NotNull final TrabajoDTO trabajo);

}
