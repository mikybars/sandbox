package com.inditex.rrhh.icmclcwb.api.app.programacion.service;

import java.time.LocalDateTime;
import java.util.List;

import com.inditex.rrhh.icmclcwb.dto.ProgramacionDTO;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import org.jspecify.annotations.NonNull;

public interface ProgramacionService {

  ProgramacionDTO create(@Valid final ProgramacionDTO programacion);

  ProgramacionDTO modify(final ProgramacionDTO programacion);

  LocalDateTime fechaSiguienteEjecucion(@Valid final ProgramacionDTO programacion);

  List<ProgramacionDTO> findPendiente();

  ProgramacionDTO updateEjecucion(@Valid final ProgramacionDTO programacion);

  void reset();

  void activa();

  void activa(@Positive @NonNull final Long id);

  void desactiva();

  void desactiva(@Positive @NonNull final Long id);

  ProgramacionDTO findById(@Positive @NonNull final Long id);

  ProgramacionDTO findActivoById(@Positive @NonNull final Long id);

  ProgramacionDTO findPendienteById(@Positive @NonNull Long id);

  void updateFechaSiguienteEjecucion(@NonNull @NotEmpty List<ProgramacionDTO> programaciones);

}
