/*
 * Copyright (c) 2021. Inditex
 */

package com.inditex.rrhh.icmclcwb.model.app.run.tarea.service;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.normalizar.async.service.RunTareaNormalizarAjusteComisionAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.EstadoTareaFaseEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.FaseEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.EstadoTareaFaseDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaFaseDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaFaseService;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class RunTareaNormalizarServiceImplTest {

  @Mock
  private RunTareaNormalizarAjusteComisionAsyncService runTareaNormalizarAjusteComisionAsyncService;

  @Mock
  private TareaFaseService tareaFaseService;

  @InjectMocks
  private RunTareaNormalizarServiceImpl runTareaNormalizarService;

  private TareaFaseDto tareaFase;

  private TareaDto tarea;

  private RunTareaDto runTarea;

  @BeforeEach
  public void setup() {

    // Moks de runTarea y tarea para usar en todos los tests
    this.runTarea = new RunTareaDto();
    this.tarea = new TareaDto();
    this.tarea.setId(8989L);
    this.runTarea.setTarea(this.tarea);

    // Implementación del mock de findTareaFaseDtoByIdTareaAndIdFase
    this.tareaFase = TareaFaseDto
        .builder()
        .estadoTareaFase(EstadoTareaFaseDto.builder().id(111).build())
        .activo(Boolean.TRUE)
        .build();
    when(this.tareaFaseService.findTareaFaseDtoByIdTareaAndIdFase(any(Long.class), any(Integer.class)))
        .thenReturn(this.tareaFase);

    // Implementación del mock de normalizarAjusteComision
    when(this.runTareaNormalizarAjusteComisionAsyncService.normalizarAjusteComision(any(TareaDto.class)))
        .thenReturn(
            CompletableFuture.completedFuture(AsyncConstants.NIL));
  }

  @Test
  void runNormalizarAjusteComisionTest() {
    this.runTareaNormalizarService.run(this.runTarea);
    verify(this.runTareaNormalizarAjusteComisionAsyncService, times(1)).normalizarAjusteComision(this.tarea);
  }

  @Test
  void runFindTareaFaseTest() {
    this.runTareaNormalizarService.run(this.runTarea);
    verify(this.tareaFaseService, times(1)).findTareaFaseDtoByIdTareaAndIdFase(this.tarea.getId(),
        FaseEnum.NORMALIZAR.getId());
  }

  @Test
  void runUpdateFechaInicioTest() {
    this.runTareaNormalizarService.run(this.runTarea);
    verify(this.tareaFaseService, times(1)).updateFechaInicio(this.tareaFase);
  }

  @Test
  void runUpdateFechaFinOKTest() {
    this.runTareaNormalizarService.run(this.runTarea);
    verify(this.tareaFaseService, times(1)).updateFechaFinAndEstado(this.tareaFase,
        EstadoTareaFaseEnum.OK.getDto());
  }

  @Test
  void runUpdateFechaFinKOTest() {
    when(this.runTareaNormalizarAjusteComisionAsyncService.normalizarAjusteComision(any(TareaDto.class))).thenThrow(
        new RuntimeException("e"));
    assertThrows(RuntimeException.class, () -> this.runTareaNormalizarService.run(this.runTarea));
    verify(this.tareaFaseService, times(1)).updateFechaFinAndEstado(this.tareaFase,
        EstadoTareaFaseEnum.KO.getDto());
  }

}
