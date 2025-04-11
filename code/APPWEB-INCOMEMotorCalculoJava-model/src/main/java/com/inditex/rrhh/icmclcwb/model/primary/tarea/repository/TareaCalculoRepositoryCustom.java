package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalChallengeDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaPersonaImporteExcedidoDto;

import jakarta.validation.constraints.NotNull;

public interface TareaCalculoRepositoryCustom {

  void regularizarMejorOpcion(@NotNull TareaDto tareaDto);

  void regularizarChallenge(@NotNull TareaDto tareaDto,
      @NotNull final IdPersonaLocalChallengeDto idPersonaLocalChallengeDto);

  void regularizarMejorOpcionSinFechas(@NotNull final TareaDto tareaDto);

  void regularizarMejorOpcionSinFechasTodoPeriodo(@NotNull final TareaDto tareaDto);

  List<TareaPersonaImporteExcedidoDto> findPersonaImporteExcedidoByIdTarea(@NotNull Long idTarea);
}
