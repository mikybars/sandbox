package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaAgrupacionPresenciaService;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaAgrupacionPresenciaRepositoryCustom;

import jakarta.validation.Valid;
import org.jspecify.annotations.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class TareaAgrupacionPresenciaServiceImpl implements TareaAgrupacionPresenciaService {

  @Autowired
  private TareaAgrupacionPresenciaRepositoryCustom tareaAgrupacionPresenciaRepositoryCustom;

  @Override
  public void calcularPresenciasTotalesAgrupacion(@Valid @NonNull final TareaDto tarea) {
    tareaAgrupacionPresenciaRepositoryCustom.calcularPresenciasTotalesAgrupacion(tarea);
  }

}
