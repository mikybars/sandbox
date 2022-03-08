package com.inditex.rrhh.icmclcwb.model.app.async.service;
/*
 * Copyright (c) 2022. Inditex
 */

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalCondicionesDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.service.ComisService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class ComisAsyncServiceImplTest {

  @Mock
  private ComisService comisService;

  @InjectMocks
  private ComisAsyncServiceImpl comisAsyncServiceImpl;

  @Test
  public void findCondicionesHistoricoSinChallenge() throws ExecutionException, InterruptedException {

    final List<IdPersonaLocalCondicionesDto> response = new ArrayList<>();
    when(this.comisService.findCondicionesHistoricoSinChallenge(any(RunTareaDto.class), any(TareaAmbitoDto.class)))
        .thenReturn(response);
    final CompletableFuture<List<IdPersonaLocalCondicionesDto>> cf = this.comisAsyncServiceImpl
        .findCondicionesHistoricoSinChallenge(new RunTareaDto(), new TareaAmbitoDto());
    assertEquals(response, cf.get());

  }

  @Test
  public void findCondicionesDesplazamientoSinChallenge() throws ExecutionException, InterruptedException {

    final List<IdPersonaLocalCondicionesDto> response = new ArrayList<>();
    when(this.comisService.findCondicionesDesplazamientoSinChallenge(any(RunTareaDto.class), any(TareaAmbitoDto.class)))
        .thenReturn(response);
    final CompletableFuture<List<IdPersonaLocalCondicionesDto>> cf = this.comisAsyncServiceImpl
        .findCondicionesDesplazamientoSinChallenge(new RunTareaDto(), new TareaAmbitoDto());
    assertEquals(response, cf.get());

  }

  @Test
  public void findCondicionesResaltaSinChallenge() throws ExecutionException, InterruptedException {

    final List<IdPersonaLocalCondicionesDto> response = new ArrayList<>();
    when(this.comisService.findCondicionesResaltaSinChallenge(any(RunTareaDto.class), any(TareaAmbitoDto.class)))
        .thenReturn(response);
    final CompletableFuture<List<IdPersonaLocalCondicionesDto>> cf = this.comisAsyncServiceImpl
        .findCondicionesResaltaSinChallenge(new RunTareaDto(), new TareaAmbitoDto());
    assertEquals(response, cf.get());

  }

}
