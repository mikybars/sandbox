package com.inditex.rrhh.icmclcwb.model.app.async.service;

/*
 * Copyright (c) 2022. Inditex
 */
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalComisionManualDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalCondicionesDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalLocalizacionDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.service.ComisService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.clases.dto.ClaseResultItemDto;

import org.instancio.junit.InstancioSource;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith({SpringExtension.class})
class ComisAsyncServiceImplTest {

  @Mock
  private ComisService comisService;

  @InjectMocks
  private ComisAsyncServiceImpl comisAsyncServiceImpl;

  @Test
  void findCondicionesHistoricoSinChallenge() throws ExecutionException, InterruptedException {

    final List<IdPersonaLocalCondicionesDto> response = new ArrayList<>();
    when(this.comisService.findCondicionesHistoricoSinChallenge(any(RunTareaDto.class), any(TareaAmbitoDto.class)))
        .thenReturn(response);
    final CompletableFuture<List<IdPersonaLocalCondicionesDto>> cf = this.comisAsyncServiceImpl
        .findCondicionesHistoricoSinChallenge(new RunTareaDto(), new TareaAmbitoDto());
    assertEquals(response, cf.get());

  }

  @Test
  void findCondicionesDesplazamientoSinChallenge() throws ExecutionException, InterruptedException {

    final List<IdPersonaLocalCondicionesDto> response = new ArrayList<>();
    when(this.comisService.findCondicionesDesplazamientoSinChallenge(any(RunTareaDto.class), any(TareaAmbitoDto.class)))
        .thenReturn(response);
    final CompletableFuture<List<IdPersonaLocalCondicionesDto>> cf = this.comisAsyncServiceImpl
        .findCondicionesDesplazamientoSinChallenge(new RunTareaDto(), new TareaAmbitoDto());
    assertEquals(response, cf.get());

  }

  @Test
  void findCondicionesResaltaSinChallenge() throws ExecutionException, InterruptedException {

    final List<IdPersonaLocalCondicionesDto> response = new ArrayList<>();
    when(this.comisService.findCondicionesResaltaSinChallenge(any(RunTareaDto.class), any(TareaAmbitoDto.class)))
        .thenReturn(response);
    final CompletableFuture<List<IdPersonaLocalCondicionesDto>> cf = this.comisAsyncServiceImpl
        .findCondicionesResaltaSinChallenge(new RunTareaDto(), new TareaAmbitoDto());
    assertEquals(response, cf.get());

  }

  @ParameterizedTest
  @InstancioSource
  void findComisionManualTest(final RunTareaDto runTarea, final TareaAmbitoDto ambito)
      throws ExecutionException, InterruptedException {
    final List<IdPersonaLocalComisionManualDto> response = new ArrayList<>();
    when(this.comisService.findComisionManual(any(RunTareaDto.class), any(TareaAmbitoDto.class))).thenReturn(response);
    final CompletableFuture<List<IdPersonaLocalComisionManualDto>> cf =
        this.comisAsyncServiceImpl.findComisionManual(runTarea, ambito);
    assertEquals(response, cf.get());
  }

  @ParameterizedTest
  @InstancioSource
  void findPersonasTest(final RunTareaDto runTarea, final TareaAmbitoDto ambito, final Long maxIdPersona)
      throws ExecutionException, InterruptedException {
    final List<IdPersonaLocalLocalizacionDto> response = new ArrayList<>();
    when(this.comisService.findPersonas(any(RunTareaDto.class), any(TareaAmbitoDto.class), any(Long.class))).thenReturn(response);
    final CompletableFuture<List<IdPersonaLocalLocalizacionDto>> cf =
        this.comisAsyncServiceImpl.findPersonas(runTarea, ambito, maxIdPersona);
    verify(this.comisService, times(1)).findPersonas(runTarea, ambito, maxIdPersona);
    assertEquals(response, cf.get());
  }

  @ParameterizedTest
  @InstancioSource
  void findPersonasSilTest(final RunTareaDto runTarea, final TareaAmbitoDto ambito, final Long maxIdPersona,
      final ClaseResultItemDto clase)
      throws ExecutionException, InterruptedException {
    final List<IdPersonaLocalLocalizacionDto> response = new ArrayList<>();
    when(this.comisService.findPersonasSil(any(RunTareaDto.class), any(TareaAmbitoDto.class), any(Long.class),
        any(ClaseResultItemDto.class))).thenReturn(response);
    final CompletableFuture<List<IdPersonaLocalLocalizacionDto>> cf =
        this.comisAsyncServiceImpl.findPersonasSil(runTarea, ambito, maxIdPersona, clase);
    verify(this.comisService, times(1)).findPersonasSil(runTarea, ambito, maxIdPersona, clase);
    assertEquals(response, cf.get());
  }

  @Test
  void findCondicionesHistoricoChallengeIncluidoPorcentajeTest() throws ExecutionException, InterruptedException {

    final List<IdPersonaLocalCondicionesDto> response = new ArrayList<>();
    when(this.comisService.findCondicionesHistoricoChallengeIncluidoPorcentaje(any(RunTareaDto.class), any(TareaAmbitoDto.class)))
        .thenReturn(response);
    final CompletableFuture<List<IdPersonaLocalCondicionesDto>> cf = this.comisAsyncServiceImpl
        .findCondicionesHistoricoChallengeIncluidoPorcentaje(new RunTareaDto(), new TareaAmbitoDto());
    assertEquals(response, cf.get());

  }

  @Test
  void findCondicionesDesplazamientoChallengeIncluidoPorcentaje() throws ExecutionException, InterruptedException {

    final List<IdPersonaLocalCondicionesDto> response = new ArrayList<>();
    when(this.comisService.findCondicionesHistoricoChallengeIncluidoPorcentaje(any(RunTareaDto.class), any(TareaAmbitoDto.class)))
        .thenReturn(response);
    final CompletableFuture<List<IdPersonaLocalCondicionesDto>> cf = this.comisAsyncServiceImpl
        .findCondicionesDesplazamientoChallengeIncluidoPorcentaje(new RunTareaDto(), new TareaAmbitoDto());
    assertEquals(response, cf.get());

  }

}
