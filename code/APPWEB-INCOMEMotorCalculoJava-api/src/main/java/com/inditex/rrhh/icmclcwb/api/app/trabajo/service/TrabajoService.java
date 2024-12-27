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
import org.jspecify.annotations.NonNull;

public interface TrabajoService {

  TrabajoDTO find(@NonNull @Positive final Long id);

  TrabajoDTO create(@Valid @TrabajoValidator final TrabajoDTO trabajo);

  TrabajoDTO merge(@Valid @NonNull final ProgramacionDTO programacion,
      @Valid @NonNull final ProgramacionAmbitoDTO programacionAmbito, @Valid @NonNull final PeriodoDTO periodo);

  void updateFechaFin(@NonNull final TrabajoDTO trabajo);

  void updateEstado(@NonNull final TrabajoDTO trabajo, @NonNull final EstadoTrabajoDTO estado);

  TrabajoDTO findByIdWithStates(@NonNull @Positive final Long id);

  List<IdOrigenEmpresaDto> findEmpresasCalcularProgramados(@NonNull final TrabajoDTO trabajo, @NonNull final List<String> stdIdLegEnt,
      @NonNull final List<String> cclIdOrigen);
}
