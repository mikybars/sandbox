/*
 * Copyright (c) 2021. Inditex
 */

package com.inditex.rrhh.icmclcwb.model.app.test.service;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.Collections;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.test.service.TestNormalizacionService;
import com.inditex.rrhh.icmclcwb.dto.IdTareaDTO;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * Nota: esta clase se deberá borrar cuando se haya hecho la normalización de tareas consolidadas
 *
 */
@ExtendWith(SpringExtension.class)
class TestNormalizacionAsyncServiceImplTest {

  @Mock
  private TestNormalizacionService testNormalizacionService;

  @InjectMocks
  private TestNormalizacionAsyncServiceImpl testNormalizacionAsyncService;

  @Test
  void normalizarAjusteComisionTest() {

    final IdTareaDTO id = new IdTareaDTO();
    id.setId(123456L);
    final List<IdTareaDTO> tareas = Collections.singletonList(id);

    this.testNormalizacionAsyncService.normalizarAjusteComision(tareas);
    verify(this.testNormalizacionService, times(1)).normalizarAjusteComision(tareas);

  }

}
