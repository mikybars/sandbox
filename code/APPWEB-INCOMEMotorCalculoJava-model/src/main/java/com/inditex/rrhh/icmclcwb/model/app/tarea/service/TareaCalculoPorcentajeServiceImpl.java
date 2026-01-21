package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaCalculoPorcentajeService;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaCalculoRepositoryCustom;

import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class TareaCalculoPorcentajeServiceImpl implements TareaCalculoPorcentajeService {

  @Autowired
  private TareaCalculoRepositoryCustom tareaCalculoRepositoryCustom;

  @Override
  public List<IdPersonaLocalDto> findPersonaPorcetaje0(@NotNull Long idTarea) {
    return this.tareaCalculoRepositoryCustom.findPersonaPorcentaje0(idTarea);
  }
}
