/*
 * Copyright (c) 2021. Inditex
 */

package com.inditex.rrhh.icmclcwb.model.app.limpieza.service;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.Arrays;
import java.util.Collections;

import com.inditex.rrhh.icmclcwb.api.app.run.limpieza.dto.RunLimpiezaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.EstadoLimpiezaEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.model.primary.limpieza.repository.LimpiezaRepositoryCustom;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * javierev
 */
@ExtendWith(SpringExtension.class)
class LimpiezaServiceImplTest {

  private static final long ID_TAREA = 191988L;

  @Mock
  private LimpiezaRepositoryCustom limpiezaRepositoryCustom;

  @InjectMocks
  private LimpiezaServiceImpl limpiezaService;

  @Test
  void runTareaTest() {
    final TareaDto tarea = this.createTarea();
    final TareaAmbitoDto ambito1 = TareaAmbitoDto.builder().id(1L).build();
    final TareaAmbitoDto ambito2 = TareaAmbitoDto.builder().id(2L).build();
    tarea.setAmbito(Arrays.asList(ambito1, ambito2));
    final long idLimpieza = 9393L;
    final RunLimpiezaDto limpieza = RunLimpiezaDto.builder().id(idLimpieza).tarea(tarea).build();

    this.limpiezaService.runTarea(limpieza);

    verify(this.limpiezaRepositoryCustom, times(1)).inicioLimpieza(idLimpieza);
    verify(this.limpiezaRepositoryCustom, times(2)).limpiezaTareaProfunda(any(TareaDto.class), any(TareaAmbitoDto.class));
    verify(this.limpiezaRepositoryCustom, times(1)).limpiezaTareaProfunda(tarea, ambito1);
    verify(this.limpiezaRepositoryCustom, times(1)).limpiezaTareaProfunda(tarea, ambito2);
    verify(this.limpiezaRepositoryCustom, times(1)).updateEstado(idLimpieza, EstadoLimpiezaEnum.OK.getDto());
    verify(this.limpiezaRepositoryCustom, times(1)).updateFechaFinalizacion(idLimpieza);
  }

  @Test
  void runTareaExceptionTest() {
    final TareaDto tarea = this.createTarea();
    tarea.setAmbito(Collections.singletonList(TareaAmbitoDto.builder().build()));
    final long idLimpieza = 9393L;
    final RunLimpiezaDto limpieza = RunLimpiezaDto.builder().id(idLimpieza).tarea(tarea).build();

    doThrow(new RuntimeException("e")).when(this.limpiezaRepositoryCustom)
        .limpiezaTareaProfunda(any(TareaDto.class), any(TareaAmbitoDto.class));

    assertThrows(RuntimeException.class, () -> this.limpiezaService.runTarea(limpieza));

    verify(this.limpiezaRepositoryCustom, times(1)).updateEstado(idLimpieza, EstadoLimpiezaEnum.KO.getDto());
    verify(this.limpiezaRepositoryCustom, times(1)).updateFechaFinalizacion(idLimpieza);
  }

  @Test
  void limpiezaAmbitoTest() {
    final TareaDto tarea = this.createTarea();
    final TareaAmbitoDto ambito1 = TareaAmbitoDto.builder().id(1L).build();
    final TareaAmbitoDto ambito2 = TareaAmbitoDto.builder().id(2L).build();
    tarea.setAmbito(Arrays.asList(ambito1, ambito2));
    this.limpiezaService.limpiezaAmbito(tarea);
    verify(this.limpiezaRepositoryCustom, times(2)).limpieza(any(TareaDto.class), any(TareaAmbitoDto.class));
    verify(this.limpiezaRepositoryCustom, times(1)).limpieza(tarea, ambito1);
    verify(this.limpiezaRepositoryCustom, times(1)).limpieza(tarea, ambito2);
  }

  @Test
  void limpiezaTareaPersonaHistoricoTest() {
    final TareaDto tarea = this.createTarea();
    this.limpiezaService.limpiezaTareaPersonaHistorico(tarea);
    verify(this.limpiezaRepositoryCustom, times(1)).limpiezaTareaPersonaHistorico(tarea);
  }

  @Test
  void limpiezaTareaLocalizacionHistoricoTest() {
    final TareaDto tarea = this.createTarea();
    this.limpiezaService.limpiezaTareaLocalizacionHistorico(tarea);
    verify(this.limpiezaRepositoryCustom, times(1)).limpiezaTareaLocalizacionHistorico(tarea);
  }

  @Test
  void limpiezaTareaGlobalLocalizacionPersonaTest() {
    final TareaDto tarea = this.createTarea();
    this.limpiezaService.limpiezaTareaGlobalLocalizacionPersona(tarea);
    verify(this.limpiezaRepositoryCustom, times(1)).limpiezaTareaGlobalLocalizacionPersona(tarea);
  }

  @Test
  void limpiezaTareaAmbitoGlobalLocalizacionPersonaDesplazamientoTest() {
    final TareaDto tarea = this.createTarea();
    this.limpiezaService.limpiezaTareaAmbitoGlobalLocalizacionPersonaDesplazamiento(tarea);
    verify(this.limpiezaRepositoryCustom, times(1))
        .limpiezaTareaAmbitoGlobalLocalizacionPersonaDesplazamiento(tarea);
  }

  @Test
  void limpiezaTareaAmbitoGlobalLocalizacionPersonaPresenciaTest() {
    final TareaDto tarea = this.createTarea();
    this.limpiezaService.limpiezaTareaAmbitoGlobalLocalizacionPersonaPresencia(tarea);
    verify(this.limpiezaRepositoryCustom, times(1)).limpiezaTareaAmbitoGlobalLocalizacionPersonaPresencia(tarea);
  }

  @Test
  void limpiezaTareaAmbitoGlobalLocalizacionPersonaPresenciaManualTest() {
    final TareaDto tarea = this.createTarea();
    this.limpiezaService.limpiezaTareaAmbitoGlobalLocalizacionPersonaPresenciaManual(tarea);
    verify(this.limpiezaRepositoryCustom, times(1))
        .limpiezaTareaAmbitoGlobalLocalizacionPersonaPresenciaManual(tarea);
  }

  @Test
  void limpiezaTareaAmbitoGlobalPersonaTest() {
    final TareaDto tarea = this.createTarea();
    this.limpiezaService.limpiezaTareaAmbitoGlobalPersona(tarea);
    verify(this.limpiezaRepositoryCustom, times(1)).limpiezaTareaAmbitoGlobalPersona(tarea);
  }

  @Test
  void limpiezaTareaAmbitoLocalizacionTest() {
    final TareaDto tarea = this.createTarea();
    final TareaAmbitoDto ambito1 = TareaAmbitoDto.builder().id(1L).build();
    final TareaAmbitoDto ambito2 = TareaAmbitoDto.builder().id(2L).build();
    tarea.setAmbito(Arrays.asList(ambito1, ambito2));
    this.limpiezaService.limpiezaTareaAmbitoLocalizacion(tarea);
    verify(this.limpiezaRepositoryCustom, times(2)).limpiezaTareaAmbitoLocalizacion(any(TareaDto.class),
        any(TareaAmbitoDto.class));
    verify(this.limpiezaRepositoryCustom, times(1)).limpiezaTareaAmbitoLocalizacion(tarea, ambito1);
    verify(this.limpiezaRepositoryCustom, times(1)).limpiezaTareaAmbitoLocalizacion(tarea, ambito2);
  }

  private TareaDto createTarea() {
    final TareaDto tarea = new TareaDto();
    tarea.setId(ID_TAREA);
    return tarea;
  }

}
