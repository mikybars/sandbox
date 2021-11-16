/*
 * Copyright (c) 2021. Inditex
 */

package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;

import javax.validation.constraints.NotNull;

public interface TareaCalculoAjusteComisionRepositoryCustom {

  void normalizarAjusteComision(@NotNull TareaDto runTarea);

}
