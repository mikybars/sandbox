package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaPersonaEstructura;

public interface TareaPersonaEstructuraRepositoryCustom {

  List<TareaPersonaEstructura> save(List<TareaPersonaEstructura> src);

  void updateActivoTopes(TareaDto tarea);

  List<IdPersonaLocalDto> findPersonasChallenge(TareaDto tarea);

  void desactivarChallengeOpcionOrigen(final TareaDto tarea);

  void crearChallengeOpcionOrigen(final TareaDto tarea);

  Boolean calcularFestivos(final TareaDto tarea);

  void desactivarManualOrdinalDoble(final TareaDto tarea);

  void crearEstructurasOrigenIgualarBandas();

  void establecerBandaOpcionOrigen();

  void desactivarGlobalSeccionOpcionOrigen(TareaDto tarea);

  void crearGlobalSeccionOpcionOrigen(TareaDto tarea);
}
