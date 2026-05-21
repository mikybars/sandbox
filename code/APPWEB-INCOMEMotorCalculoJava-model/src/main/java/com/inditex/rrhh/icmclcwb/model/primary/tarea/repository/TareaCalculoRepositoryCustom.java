package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.dto.IdLocalizacionLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalChallengeDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;

import jakarta.validation.constraints.NotNull;

public interface TareaCalculoRepositoryCustom {

  void regularizarMejorOpcion(@NotNull TareaDto tareaDto);

  void regularizarChallenge(@NotNull TareaDto tareaDto,
      @NotNull final IdPersonaLocalChallengeDto idPersonaLocalChallengeDto);

  void regularizarMejorOpcionSinFechas(@NotNull final TareaDto tareaDto);

  void regularizarMejorOpcionSinFechasTodoPeriodo(@NotNull final TareaDto tareaDto);

  List<IdPersonaLocalDto> findPersonaImporteExcedidoByIdTarea(@NotNull Long idTarea, @NotNull String cclIdOrigen,
      @NotNull String stdIdLegEnt);

  List<IdPersonaLocalDto> findPersonaCalculoPendiente(@NotNull Long idTarea);

  List<IdPersonaLocalDto> findPersonaPorcentaje0(@NotNull Long idTarea);

  List<IdLocalizacionLocalDto> findTiendaVentasSinPresencias(@NotNull Long idTarea);

  List<IdLocalizacionLocalDto> findTiendaPresenciasSinVentas(@NotNull Long idTarea);

  List<IdPersonaLocalDto> findPersonaPresenciasMismaFechaDistintaTienda(@NotNull Long idTarea);
}
