/*
 * Copyright (c) 2021. Inditex
 */

package com.inditex.rrhh.icmclcwb.model.app.test.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.normalizar.service.RunTareaNormalizarAjusteComisionService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaService;
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
class TestNormalizacionServiceImplTest {

  @Mock
  private RunTareaNormalizarAjusteComisionService runTareaNormalizarAjusteComisionService;

  @Mock
  private TareaService tareaService;

  @InjectMocks
  private TestNormalizacionServiceImpl testNormalizacionService;

  @Test
  void normalizarAjusteComisionTest() {

    final long idTarea1 = 123456L;
    final long idTarea2 = 123489L;
    final IdTareaDTO idDto1 = new IdTareaDTO();
    idDto1.setId(idTarea1);
    final IdTareaDTO idDto2 = new IdTareaDTO();
    idDto2.setId(idTarea2);
    final List<IdTareaDTO> tareas = Arrays.asList(idDto1, idDto2);
    when(this.tareaService.find(any(Long.class))).thenAnswer(invocation -> {
      final Long idTarea = invocation.getArgument(0);
      final TareaDto tarea = new TareaDto();
      tarea.setId(idTarea);
      return tarea;
    });

    this.testNormalizacionService.normalizarAjusteComision(tareas);

    final TareaDto tarea1 = new TareaDto();
    tarea1.setId(idTarea1);
    verify(this.runTareaNormalizarAjusteComisionService, times(1)).normalizarAjusteComision(tarea1);

    final TareaDto tarea2 = new TareaDto();
    tarea2.setId(idTarea2);
    verify(this.runTareaNormalizarAjusteComisionService, times(1)).normalizarAjusteComision(tarea2);

  }

}
