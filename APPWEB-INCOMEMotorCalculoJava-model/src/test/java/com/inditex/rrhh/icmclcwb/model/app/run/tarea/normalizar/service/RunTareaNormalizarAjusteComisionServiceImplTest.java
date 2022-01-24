/*
 * Copyright (c) 2021. Inditex
 */

package com.inditex.rrhh.icmclcwb.model.app.run.tarea.normalizar.service;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.model.primary.repository.PrimaryTemporaryTableRepositoryCustom;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaCalculoAjusteComisionRepositoryCustom;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.slf4j.Logger;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class RunTareaNormalizarAjusteComisionServiceImplTest {

  private static final long ID_TAREA = 9039L;

  @Mock
  private Logger log;

  @Mock
  private PrimaryTemporaryTableRepositoryCustom primaryTemporaryTableRepositoryCustom;

  @Mock
  private TareaCalculoAjusteComisionRepositoryCustom tareaCalculoAjusteComisionRepositoryCustom;

  @InjectMocks
  private RunTareaNormalizarAjusteComisionServiceImpl runTareaNormalizarAjusteComisionService;

  @ParameterizedTest
  @ValueSource(strings = {
      "Tarea[{}] :: Inicio :: RunTareaNormalizarAjusteComisionServiceImpl :: normalizarAjusteComision :: creacion tablas temporales",
      "Tarea[{}] :: Fin :: RunTareaNormalizarAjusteComisionServiceImpl :: normalizarAjusteComision :: creacion tablas temporales",
      "Tarea[{}] :: Inicio :: RunTareaNormalizarAjusteComisionServiceImpl :: normalizarAjusteComision :: insercion tablas temporales",
      "Tarea[{}] :: Fin :: RunTareaNormalizarAjusteComisionServiceImpl :: normalizarAjusteComision :: insercion tablas temporales",
      "Tarea[{}] :: Inicio :: RunTareaNormalizarAjusteComisionServiceImpl :: normalizarAjusteComision :: normalizar ajuste comision",
      "Tarea[{}] :: Fin :: RunTareaNormalizarAjusteComisionServiceImpl :: normalizarAjusteComision :: normalizar ajuste comision",
      "Tarea[{}] :: Inicio :: RunTareaNormalizarAjusteComisionServiceImpl :: normalizarAjusteComision :: borrado tablas temporales",
      "Tarea[{}] :: Fin :: RunTareaNormalizarAjusteComisionServiceImpl :: normalizarAjusteComision :: borrado tablas temporales",
  })
  void normalizarAjusteComisionLogTest(final String logText) {

    this.runTareaNormalizarAjusteComisionService.normalizarAjusteComision(this.createTarea());
    verify(this.log, times(1)).info(logText, ID_TAREA);

  }

  @Test
  void normalizarAjusteComisionInsertTareaCalculoAjusteComisionTest() {

    final TareaDto tarea = this.createTarea();
    this.runTareaNormalizarAjusteComisionService.normalizarAjusteComision(tarea);
    verify(this.tareaCalculoAjusteComisionRepositoryCustom, times(1)).normalizarAjusteComision(tarea);

  }

  @Test
  void normalizarAjusteComisionCreaTablaTemporalCalculoPorComisionTest() {

    this.runTareaNormalizarAjusteComisionService.normalizarAjusteComision(this.createTarea());
    verify(this.primaryTemporaryTableRepositoryCustom, times(1)).createTempCalculoPorComision();

  }

  @Test
  void normalizarAjusteComisionMergeCalculoTemporalPorComisionTest() {

    final TareaDto tarea = this.createTarea();
    this.runTareaNormalizarAjusteComisionService.normalizarAjusteComision(tarea);
    verify(this.primaryTemporaryTableRepositoryCustom, times(1)).mergeCalculoTempCalculoPorComision(tarea);

  }

  @Test
  void normalizarAjusteComisionMergeCalculoTemporalSinComisionTest() {

    final TareaDto tarea = this.createTarea();
    this.runTareaNormalizarAjusteComisionService.normalizarAjusteComision(tarea);
    verify(this.primaryTemporaryTableRepositoryCustom, times(1)).mergeCalculoTempCalculoSinComision(tarea);

  }

  @Test
  void normalizarAjusteComisionEliminaTablaTemporalCalculoPorComisionTest() {

    this.runTareaNormalizarAjusteComisionService.normalizarAjusteComision(this.createTarea());
    verify(this.primaryTemporaryTableRepositoryCustom, times(1)).deleteTempCalculoPorComision();

  }

  @Test
  void normalizarAjusteComisionInsertTareaCalculoAjusteComisionExcepcionEliminaTablasTemporalesTest() {

    final TareaDto tarea = this.createTarea();
    doThrow(new RuntimeException("e")).when(this.tareaCalculoAjusteComisionRepositoryCustom)
        .normalizarAjusteComision(any(TareaDto.class));

    assertThrows(RuntimeException.class,
        () -> this.runTareaNormalizarAjusteComisionService.normalizarAjusteComision(tarea));

    verify(this.primaryTemporaryTableRepositoryCustom, times(1)).deleteTempCalculoPorComision();
    verify(this.primaryTemporaryTableRepositoryCustom, times(1)).deleteTempCalculoAjusteTotalizado();

  }

  @Test
  void normalizarAjusteComisionCrearTablaTemporalCalculoPorComisionExcepcionEliminaTablasTemporalesTest() {

    final TareaDto tarea = this.createTarea();
    doThrow(new RuntimeException("e")).when(this.primaryTemporaryTableRepositoryCustom)
        .createTempCalculoPorComision();

    assertThrows(RuntimeException.class, () -> {
      this.runTareaNormalizarAjusteComisionService.normalizarAjusteComision(tarea);
    });

    verify(this.primaryTemporaryTableRepositoryCustom, times(1)).deleteTempCalculoPorComision();
    verify(this.primaryTemporaryTableRepositoryCustom, times(1)).deleteTempCalculoAjusteTotalizado();

  }

  @Test
  void normalizarAjusteComisionMergeCalculoPorComisionExcepcionEliminaTablasTemporalesTest() {

    final TareaDto tarea = this.createTarea();
    doThrow(new RuntimeException("e")).when(this.primaryTemporaryTableRepositoryCustom)
        .mergeCalculoTempCalculoPorComision(any(TareaDto.class));

    assertThrows(RuntimeException.class, () -> {
      this.runTareaNormalizarAjusteComisionService.normalizarAjusteComision(tarea);
    });

    verify(this.primaryTemporaryTableRepositoryCustom, times(1)).deleteTempCalculoPorComision();
    verify(this.primaryTemporaryTableRepositoryCustom, times(1)).deleteTempCalculoAjusteTotalizado();

  }

  @Test
  void normalizarAjusteComisionMergeCalculoSinComisionExcepcionEliminaTablasTemporalesTest() {

    final TareaDto tarea = this.createTarea();
    doThrow(new RuntimeException("e")).when(this.primaryTemporaryTableRepositoryCustom)
        .mergeCalculoTempCalculoSinComision(any(TareaDto.class));

    assertThrows(RuntimeException.class, () -> {
      this.runTareaNormalizarAjusteComisionService.normalizarAjusteComision(tarea);
    });

    verify(this.primaryTemporaryTableRepositoryCustom, times(1)).deleteTempCalculoPorComision();
    verify(this.primaryTemporaryTableRepositoryCustom, times(1)).deleteTempCalculoAjusteTotalizado();

  }

  @Test
  void normalizarAjusteComisionCreaTablaTemporalCalculoAjusteTotalizadoTest() {

    this.runTareaNormalizarAjusteComisionService.normalizarAjusteComision(this.createTarea());
    verify(this.primaryTemporaryTableRepositoryCustom, times(1)).createTempCalculoAjusteTotalizado();

  }

  @Test
  void normalizarAjusteComisionMergeCalculoAjusteTotalizadoTemporalTest() {

    final TareaDto tarea = this.createTarea();
    this.runTareaNormalizarAjusteComisionService.normalizarAjusteComision(tarea);
    verify(this.primaryTemporaryTableRepositoryCustom, times(1)).mergeCalculoTempCalculoAjusteTotalizado(tarea);

  }

  @Test
  void normalizarAjusteComisionEliminaTablaTemporalCalculoAjusteTotalizadoTest() {

    this.runTareaNormalizarAjusteComisionService.normalizarAjusteComision(this.createTarea());
    verify(this.primaryTemporaryTableRepositoryCustom, times(1)).deleteTempCalculoAjusteTotalizado();

  }

  @Test
  void normalizarAjusteComisionCrearTablaTemporalAjusteTotalizadoExcepcionEliminaTablasTemporalesTest() {

    final TareaDto tarea = this.createTarea();
    doThrow(new RuntimeException("e")).when(this.primaryTemporaryTableRepositoryCustom)
        .createTempCalculoAjusteTotalizado();

    assertThrows(RuntimeException.class, () -> {
      this.runTareaNormalizarAjusteComisionService.normalizarAjusteComision(tarea);
    });

    verify(this.primaryTemporaryTableRepositoryCustom, times(1)).deleteTempCalculoPorComision();
    verify(this.primaryTemporaryTableRepositoryCustom, times(1)).deleteTempCalculoAjusteTotalizado();

  }

  @Test
  void normalizarAjusteComisionMergeCalculoAjusteTotalizadoExcepcionEliminaTablasTemporalesTest() {

    final TareaDto tarea = this.createTarea();
    doThrow(new RuntimeException("e")).when(this.primaryTemporaryTableRepositoryCustom)
        .mergeCalculoTempCalculoAjusteTotalizado(any(TareaDto.class));

    assertThrows(RuntimeException.class, () -> {
      this.runTareaNormalizarAjusteComisionService.normalizarAjusteComision(tarea);
    });

    verify(this.primaryTemporaryTableRepositoryCustom, times(1)).deleteTempCalculoPorComision();
    verify(this.primaryTemporaryTableRepositoryCustom, times(1)).deleteTempCalculoAjusteTotalizado();

  }

  private TareaDto createTarea() {
    final TareaDto tarea = new TareaDto();
    tarea.setId(ID_TAREA);
    return tarea;
  }

}
