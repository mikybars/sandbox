/*
 * Copyright (c) 2021. Inditex
 */

package com.inditex.rrhh.icmclcwb.model.primary.tarea.repository;

import javax.validation.constraints.NotNull;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;

/**
 * @author javierev
 */
public interface TareaCalculoAjusteComisionRepositoryCustom {

    void normalizarAjusteComision(@NotNull TareaDto runTarea);

}
