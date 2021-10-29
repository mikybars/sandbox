/*
 * Copyright (c) 2021. Inditex
 */

package com.inditex.rrhh.icmclcwb.api.app.test.service;

import java.util.List;

import com.inditex.rrhh.icmclcwb.dto.IdTareaDTO;

/**
 * Nota: esta clase se deberá borrar cuando se haya hecho la normalización de tareas consolidadas
 *
 * @author javierev
 */
public interface TestNormalizacionService {

    void normalizarAjusteComision(List<IdTareaDTO> tareas);

}
