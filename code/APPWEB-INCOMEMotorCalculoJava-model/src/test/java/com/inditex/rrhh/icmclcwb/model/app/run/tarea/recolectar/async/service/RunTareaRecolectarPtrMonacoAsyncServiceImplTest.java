package com.inditex.rrhh.icmclcwb.model.app.run.tarea.recolectar.async.service;

/*
 * Copyright (c) 2022. Inditex
 */
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.service.RunTareaRecolectarPtrMonacoService;

import org.instancio.junit.InstancioSource;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@TestInstance(Lifecycle.PER_CLASS)
@ExtendWith({SpringExtension.class})
public class RunTareaRecolectarPtrMonacoAsyncServiceImplTest {

  @Mock
  private RunTareaRecolectarPtrMonacoService runTareaRecolectarPtrMonacoService;

  @InjectMocks
  private RunTareaRecolectarPtrMonacoAsyncServiceImpl runTareaRecolectarPtrMonacoAsyncServiceImpl;

  @ParameterizedTest
  @InstancioSource(samples = 1)
  void presenciaDetalleComisionablePersonaByRunTareaTest(final RunTareaDto runTarea) {
    this.runTareaRecolectarPtrMonacoAsyncServiceImpl.presenciaDetalleComisionablePersonaByRunTarea(runTarea);
    verify(this.runTareaRecolectarPtrMonacoService, times(1)).presenciaDetalleComisionablePersonaByRunTarea(runTarea);
  }

  @ParameterizedTest
  @InstancioSource(samples = 1)
  void presenciaDetallePersonaIncluidoCommerceByRunTareaTest(final RunTareaDto runTarea) {
    this.runTareaRecolectarPtrMonacoAsyncServiceImpl.presenciaDetallePersonaIncluidoCommerceByRunTarea(runTarea);
    verify(this.runTareaRecolectarPtrMonacoService, times(1)).presenciaDetallePersonaIncluidoCommerceByRunTarea(runTarea);
  }

  @ParameterizedTest
  @InstancioSource(samples = 1)
  void ventaFisicaLocalizacionSeccionByRunTareaTest(final RunTareaDto runTarea) {
    this.runTareaRecolectarPtrMonacoAsyncServiceImpl.ventaFisicaLocalizacionSeccionByRunTarea(runTarea);
    verify(this.runTareaRecolectarPtrMonacoService, times(1)).ventaFisicaLocalizacionSeccionByRunTarea(runTarea);
  }

  @ParameterizedTest
  @InstancioSource(samples = 1)
  void ventaOnlineIpodLocalizacionSeccionByRunTareaTest(final RunTareaDto runTarea) {
    this.runTareaRecolectarPtrMonacoAsyncServiceImpl.ventaOnlineIpodLocalizacionSeccionByRunTarea(runTarea);
    verify(this.runTareaRecolectarPtrMonacoService, times(1)).ventaOnlineIpodLocalizacionSeccionByRunTarea(runTarea);
  }

  @ParameterizedTest
  @InstancioSource(samples = 1)
  void ventaFisicaLocalizacionSeccionRepartoOnlineByRunTareaTest(final RunTareaDto runTarea) {
    this.runTareaRecolectarPtrMonacoAsyncServiceImpl.ventaFisicaLocalizacionSeccionRepartoOnlineByRunTarea(runTarea);
    verify(this.runTareaRecolectarPtrMonacoService, times(1)).ventaFisicaLocalizacionSeccionRepartoOnlineByRunTarea(runTarea);
  }

  @ParameterizedTest
  @InstancioSource(samples = 1)
  void ventaOnlineEntregaTiendaLocalizacionSeccionByRunTareaTest(final RunTareaDto runTarea) {
    this.runTareaRecolectarPtrMonacoAsyncServiceImpl.ventaOnlineEntregaTiendaLocalizacionSeccionByRunTarea(runTarea);
    verify(this.runTareaRecolectarPtrMonacoService, times(1)).ventaOnlineEntregaTiendaLocalizacionSeccionByRunTarea(runTarea);
  }

  @ParameterizedTest
  @InstancioSource(samples = 1)
  void ventaOnlinePickingLocalizacionSeccionByRunTareaTest(final RunTareaDto runTarea) {
    this.runTareaRecolectarPtrMonacoAsyncServiceImpl.ventaOnlinePickingLocalizacionSeccionByRunTarea(runTarea);
    verify(this.runTareaRecolectarPtrMonacoService, times(1)).ventaOnlinePickingLocalizacionSeccionByRunTarea(runTarea);
  }

}
