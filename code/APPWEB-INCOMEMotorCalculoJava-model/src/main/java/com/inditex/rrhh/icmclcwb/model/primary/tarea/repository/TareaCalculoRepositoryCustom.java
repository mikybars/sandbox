package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalChallengeDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;

public interface TareaCalculoRepositoryCustom {

  void regularizarMejorOpcion(@NotNull TareaDto tareaDto);

  void regularizarChallenge(@NotNull TareaDto tareaDto,
      @NotNull final IdPersonaLocalChallengeDto idPersonaLocalChallengeDto);

  void regularizarMejorOpcionSinFechas(@NotNull final TareaDto tareaDto);

  void regularizarMejorOpcionSinFechasTodoPeriodo(@NotNull final TareaDto tareaDto);

}
