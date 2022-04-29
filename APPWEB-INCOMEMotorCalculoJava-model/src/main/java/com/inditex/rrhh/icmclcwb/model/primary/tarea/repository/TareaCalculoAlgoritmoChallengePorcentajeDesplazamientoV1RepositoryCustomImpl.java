package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.inditex.rrhh.icmclcwb.api.app.calcular.service.TipoDatoService;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaCalculoPersonaService;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

/*
 * Copyright (c) 2022. Inditex
 */
@Repository
public class TareaCalculoAlgoritmoChallengePorcentajeDesplazamientoV1RepositoryCustomImpl
    extends AbstractTareaCalculoAlgoritmoBaseRepositoryCustom
    implements TareaCalculoAlgoritmoChallengePorcentajeDesplazamientoV1RepositoryCustom {

  @Value("#{calculoPrimaryQuery['TareaCalculoAlgoritmoBaseRepository.calcular.insert']} "
      + "#{calculoPrimaryQuery['TareaCalculoAlgoritmoChallengePorcentajeDesplazamientoV1RepositoryCustom.calcular']} "
      + "#{calculoPrimaryQuery['TareaCalculoAlgoritmoBaseRepository.calcular.where']}")
  @Getter
  private String sqlCalcular;

  @Value("#{calculoPrimaryQuery['TareaCalculoAlgoritmoChallengePorcentajeDesplazamientoV1RepositoryCustom.calcular']} "
      + "#{calculoPrimaryQuery['TareaCalculoAlgoritmoBaseRepository.calcular.where']}")
  @Getter
  private String sqlCalcularBase;

  @Autowired
  private TareaCalculoPersonaService tareaCalculoPersonaService;

  @Autowired
  private TipoDatoService tipoDatoService;

  @Override
  public List<IdPersonaLocalDto> ids(final AlgoritmoDTO algoritmo, final TareaDto tarea) {
    return this.tareaCalculoPersonaService.findByAlgoritmo(tarea, algoritmo);
  }

  @Override
  protected Map<String, Object> getMapValues(final AlgoritmoDTO algoritmo, final TareaDto tarea,
      final IdPersonaLocalDto persona) {
    final Map<String, Object> map = new HashMap<>();

    return map;

  }
}
