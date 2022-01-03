package com.inditex.rrhh.icmclcwb.api.app.test.service;

/*
 * Copyright (c) 2021. Inditex
 */
import java.util.List;

import com.inditex.rrhh.icmclcwb.dto.IdTareaDTO;

/**
 * Some javadoc.
 *
 * <p>Nota: esta clase se deberá borrar cuando se haya hecho la normalización de tareas consolidadas</p>
 *
 */
public interface TestNormalizacionService {

  void normalizarAjusteComision(List<IdTareaDTO> tareas);

}
