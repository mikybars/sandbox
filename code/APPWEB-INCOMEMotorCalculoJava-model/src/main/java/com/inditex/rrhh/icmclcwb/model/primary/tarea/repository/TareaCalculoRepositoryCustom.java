package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalChallengeDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;

import org.jspecify.annotations.NonNull;

public interface TareaCalculoRepositoryCustom {

  void regularizarMejorOpcion(@NonNull TareaDto tareaDto);

  void regularizarChallenge(@NonNull TareaDto tareaDto,
      @NonNull final IdPersonaLocalChallengeDto idPersonaLocalChallengeDto);

  void regularizarMejorOpcionSinFechas(@NonNull final TareaDto tareaDto);

  void regularizarMejorOpcionSinFechasTodoPeriodo(@NonNull final TareaDto tareaDto);

}
