package com.inditex.rrhh.icmclcwb.api.app.programacion.service;

import java.time.LocalDateTime;
import java.util.List;

import com.inditex.rrhh.icmclcwb.dto.ProgramacionDTO;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public interface ProgramacionService {

  ProgramacionDTO create(@Valid final ProgramacionDTO programacion);

  ProgramacionDTO modify(final ProgramacionDTO programacion);

  LocalDateTime fechaSiguienteEjecucion(@Valid final ProgramacionDTO programacion);

  List<ProgramacionDTO> findPendiente();

  ProgramacionDTO updateEjecucion(@Valid final ProgramacionDTO programacion);

  void reset();

  void activa();

  void activa(@Positive @NotNull final Long id);

  void desactiva();

  void desactiva(@Positive @NotNull final Long id);

  ProgramacionDTO findById(@Positive @NotNull final Long id);

  ProgramacionDTO findActivoById(@Positive @NotNull final Long id);

  ProgramacionDTO findPendienteById(@Positive @NotNull Long id);

  void updateFechaSiguienteEjecucion(@NotNull @NotEmpty List<ProgramacionDTO> programaciones);

}
