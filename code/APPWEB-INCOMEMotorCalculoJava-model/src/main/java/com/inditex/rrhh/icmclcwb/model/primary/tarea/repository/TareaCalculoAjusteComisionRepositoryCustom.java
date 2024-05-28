package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

/*
 * Copyright (c) 2021. Inditex
 */
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;

import jakarta.validation.constraints.NotNull;

public interface TareaCalculoAjusteComisionRepositoryCustom {

  void normalizarAjusteComision(@NotNull TareaDto runTarea);

}
