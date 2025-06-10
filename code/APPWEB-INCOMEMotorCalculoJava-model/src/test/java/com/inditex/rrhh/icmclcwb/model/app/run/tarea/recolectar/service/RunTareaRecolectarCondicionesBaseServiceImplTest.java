package com.inditex.rrhh.icmclcwb.model.app.run.tarea.recolectar.service;

/*
 * Copyright (c) 2021. Inditex
 */
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.exception.IcmclcwbException;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.async.service.RunTareaRecolectarMeta4IcmWsCalcIncomeAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.service.RunTareaPrevalidarDuranteService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.AccionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.FaseDto;
import com.inditex.rrhh.icmclcwb.dto.TrabajoDTO;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith({SpringExtension.class})
class RunTareaRecolectarCondicionesBaseServiceImplTest {

  @Mock
  private RunTareaRecolectarMeta4IcmWsCalcIncomeAsyncService runTareaRecolectarMeta4IcmWsCalcIncomeAsyncService;

  @Mock
  private RunTareaPrevalidarDuranteService runTareaPrevalidarDuranteService;

  @Spy
  @InjectMocks
  private RunTareaRecolectarCondicionesBaseServiceImpl runTareaRecolectarCondicionesBaseServiceImpl;

  private RunTareaDto runTarea;

  private TrabajoDTO trabajo;

  private final CompletableFuture<Void> cf = CompletableFuture.completedFuture(null);

  @BeforeEach
  void setUp() {
    this.runTarea = spy(new RunTareaDto());
    this.trabajo = new TrabajoDTO();
    this.runTarea.setTrabajo(this.trabajo);

    when(this.runTareaRecolectarMeta4IcmWsCalcIncomeAsyncService.estructurasComByRunTarea(any(RunTareaDto.class))).thenReturn(this.cf);
    when(this.runTareaRecolectarMeta4IcmWsCalcIncomeAsyncService.estructurasPolByRunTarea(any(RunTareaDto.class))).thenReturn(this.cf);
    doNothing().when(this.runTareaPrevalidarDuranteService).run(any(RunTareaDto.class), any(FaseDto.class), any(AccionDto.class));
    when(this.runTareaRecolectarMeta4IcmWsCalcIncomeAsyncService.presupuestosWlocByRunTarea(any(RunTareaDto.class))).thenReturn(this.cf);

  }

  @Test
  void runTestWithoutSimulacion() {

    this.trabajo.setIdSimulacion(null);

    this.runTareaRecolectarCondicionesBaseServiceImpl.run(this.runTarea);

    verify(this.runTareaRecolectarMeta4IcmWsCalcIncomeAsyncService).estructurasComByRunTarea(any(RunTareaDto.class));
    verify(this.runTareaRecolectarMeta4IcmWsCalcIncomeAsyncService).estructurasPolByRunTarea(any(RunTareaDto.class));
    verify(this.runTareaRecolectarMeta4IcmWsCalcIncomeAsyncService).presupuestosWlocByRunTarea(any(RunTareaDto.class));
    verify(this.runTareaPrevalidarDuranteService, times(5)).run(any(RunTareaDto.class), any(), any());
  }

  @Test
  void runTestWithSimulacion() {

    this.trabajo.setIdSimulacion(1L);

    this.runTareaRecolectarCondicionesBaseServiceImpl.run(this.runTarea);

    verify(this.runTareaRecolectarMeta4IcmWsCalcIncomeAsyncService).presupuestosWlocByRunTarea(any(RunTareaDto.class));
    verify(this.runTareaPrevalidarDuranteService, times(5)).run(any(RunTareaDto.class), any(), any());
  }

  @Test
  void runTestException() {
    doThrow(new IcmclcwbException("")).when(this.runTareaRecolectarMeta4IcmWsCalcIncomeAsyncService)
        .presupuestosWlocByRunTarea(any(RunTareaDto.class));

    assertThrows(IcmclcwbException.class, () -> this.runTareaRecolectarCondicionesBaseServiceImpl.run(this.runTarea));
  }

}
