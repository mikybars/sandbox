package com.inditex.rrhh.icmclcwb.model.primary.programacion.repository;

import java.time.LocalDateTime;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.dto.IdProgramacionDto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public interface ProgramacionRepositoryCustom {

  void reset();

  void activa();

  void activa(@Positive @NotNull final Long id);

  void desactiva();

  void desactiva(@Positive @NotNull final Long id);

  void updateFechaSiguienteEjecucion(@NotNull @NotEmpty final List<IdProgramacionDto> idProgramacion,
      @NotNull LocalDateTime fechaSiguienteEjeucion);

}
