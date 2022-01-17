package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaPersonaEstructuraDesplazamiento;

public interface TareaPersonaEstructuraDesplazamientoRepositoryCustom {

  List<TareaPersonaEstructuraDesplazamiento> save(List<TareaPersonaEstructuraDesplazamiento> src);

  void crearChallengeOpcionOrigenIgualarBandas(final TareaDto tarea);

}
