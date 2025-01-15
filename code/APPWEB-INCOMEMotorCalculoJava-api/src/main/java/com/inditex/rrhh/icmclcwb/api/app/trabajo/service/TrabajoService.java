package com.inditex.rrhh.icmclcwb.api.app.trabajo.service;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.dto.IdOrigenEmpresaDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.annotation.TrabajoValidator;
import com.inditex.rrhh.icmclcwb.dto.EstadoTrabajoDTO;
import com.inditex.rrhh.icmclcwb.dto.PeriodoDTO;
import com.inditex.rrhh.icmclcwb.dto.ProgramacionAmbitoDTO;
import com.inditex.rrhh.icmclcwb.dto.ProgramacionDTO;
import com.inditex.rrhh.icmclcwb.dto.TrabajoDTO;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;

public interface TrabajoService {

  TrabajoDTO find(@NotNull @Positive final Long id);

  TrabajoDTO create(@Valid @TrabajoValidator final TrabajoDTO trabajo);

  TrabajoDTO merge(@Valid @NotNull final ProgramacionDTO programacion,
      @Valid @NotNull final ProgramacionAmbitoDTO programacionAmbito, @Valid @NotNull final PeriodoDTO periodo);

  void updateFechaFin(@NotNull final TrabajoDTO trabajo);

  void updateEstado(@NotNull final TrabajoDTO trabajo, @NotNull final EstadoTrabajoDTO estado);

  TrabajoDTO findByIdWithStates(@NotNull @Positive final Long id);

  List<IdOrigenEmpresaDto> findEmpresasCalcularProgramados(@NotNull final TrabajoDTO trabajo, @NotNull final List<String> stdIdLegEnt,
      @NotNull final List<String> cclIdOrigen);
}
