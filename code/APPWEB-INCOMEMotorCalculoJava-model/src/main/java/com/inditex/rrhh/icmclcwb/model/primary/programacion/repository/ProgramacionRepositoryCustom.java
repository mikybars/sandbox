package com.inditex.rrhh.icmclcwb.model.primary.programacion.repository;

import java.time.LocalDateTime;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.dto.IdProgramacionDto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import org.jspecify.annotations.NonNull;

public interface ProgramacionRepositoryCustom {

  void reset();

  void activa();

  void activa(@Positive @NonNull final Long id);

  void desactiva();

  void desactiva(@Positive @NonNull final Long id);

  void updateFechaSiguienteEjecucion(@NonNull @NotEmpty final List<IdProgramacionDto> idProgramacion,
      @NonNull LocalDateTime fechaSiguienteEjeucion);

}
