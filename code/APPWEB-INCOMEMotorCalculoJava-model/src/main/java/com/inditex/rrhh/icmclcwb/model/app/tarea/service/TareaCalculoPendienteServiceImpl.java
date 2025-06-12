package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaCalculoPendienteService;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaCalculoRepositoryCustom;

import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class TareaCalculoPendienteServiceImpl implements TareaCalculoPendienteService {

  @Autowired
  private TareaCalculoRepositoryCustom tareaCalculoRepositoryCustom;

  @Override
  public List<IdPersonaLocalDto> findPersonaCalculoPendiente(@NotNull Long idTarea, @NotNull String cclIdOrigen,
      @NotNull String stdIdLegEnt) {
    return this.tareaCalculoRepositoryCustom.findPersonaCalculoPendiente(idTarea, cclIdOrigen, stdIdLegEnt);
  }
}
