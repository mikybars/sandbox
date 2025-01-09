package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

/*
 * Copyright (c) 2021. Inditex
 */
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;

import org.jspecify.annotations.NonNull;

public interface TareaCalculoAjusteComisionRepositoryCustom {

  void normalizarAjusteComision(@NonNull TareaDto runTarea);

}
