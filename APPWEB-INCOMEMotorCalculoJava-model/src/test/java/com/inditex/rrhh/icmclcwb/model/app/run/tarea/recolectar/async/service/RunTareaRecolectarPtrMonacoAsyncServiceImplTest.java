package com.inditex.rrhh.icmclcwb.model.app.run.tarea.recolectar.async.service;

/*
 * Copyright (c) 2022. Inditex
 */
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import com.inditex.aqsw.framework.test.randomizer.Random;
import com.inditex.aqsw.framework.test.randomizer.RandomizerExtension;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.service.RunTareaRecolectarPtrMonacoService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith({SpringExtension.class, RandomizerExtension.class})
public class RunTareaRecolectarPtrMonacoAsyncServiceImplTest {

  @Mock
  private RunTareaRecolectarPtrMonacoService runTareaRecolectarPtrMonacoService;

  @InjectMocks
  private RunTareaRecolectarPtrMonacoAsyncServiceImpl runTareaRecolectarPtrMonacoAsyncServiceImpl;

  @Test
  void presenciaDetalleComisionablePersonaByRunTareaTest(@Random final RunTareaDto runTarea) {
    this.runTareaRecolectarPtrMonacoAsyncServiceImpl.presenciaDetalleComisionablePersonaByRunTarea(runTarea);
    verify(this.runTareaRecolectarPtrMonacoService, times(1)).presenciaDetalleComisionablePersonaByRunTarea(runTarea);
  }

  @Test
  void presenciaDetallePersonaIncluidoCommerceByRunTareaTest(@Random final RunTareaDto runTarea) {
    this.runTareaRecolectarPtrMonacoAsyncServiceImpl.presenciaDetallePersonaIncluidoCommerceByRunTarea(runTarea);
    verify(this.runTareaRecolectarPtrMonacoService, times(1)).presenciaDetallePersonaIncluidoCommerceByRunTarea(runTarea);
  }

  @Test
  void ventaFisicaLocalizacionSeccionByRunTareaTest(@Random final RunTareaDto runTarea) {
    this.runTareaRecolectarPtrMonacoAsyncServiceImpl.ventaFisicaLocalizacionSeccionByRunTarea(runTarea);
    verify(this.runTareaRecolectarPtrMonacoService, times(1)).ventaFisicaLocalizacionSeccionByRunTarea(runTarea);
  }

  @Test
  void ventaOnlineIpodLocalizacionSeccionByRunTareaTest(@Random final RunTareaDto runTarea) {
    this.runTareaRecolectarPtrMonacoAsyncServiceImpl.ventaOnlineIpodLocalizacionSeccionByRunTarea(runTarea);
    verify(this.runTareaRecolectarPtrMonacoService, times(1)).ventaOnlineIpodLocalizacionSeccionByRunTarea(runTarea);
  }

  @Test
  void ventaFisicaLocalizacionSeccionRepartoOnlineByRunTareaTest(@Random final RunTareaDto runTarea) {
    this.runTareaRecolectarPtrMonacoAsyncServiceImpl.ventaFisicaLocalizacionSeccionRepartoOnlineByRunTarea(runTarea);
    verify(this.runTareaRecolectarPtrMonacoService, times(1)).ventaFisicaLocalizacionSeccionRepartoOnlineByRunTarea(runTarea);
  }

  @Test
  void ventaOnlineEntregaTiendaLocalizacionSeccionByRunTareaTest(@Random final RunTareaDto runTarea) {
    this.runTareaRecolectarPtrMonacoAsyncServiceImpl.ventaOnlineEntregaTiendaLocalizacionSeccionByRunTarea(runTarea);
    verify(this.runTareaRecolectarPtrMonacoService, times(1)).ventaOnlineEntregaTiendaLocalizacionSeccionByRunTarea(runTarea);
  }

  @Test
  void ventaOnlinePickingLocalizacionSeccionByRunTareaTest(@Random final RunTareaDto runTarea) {
    this.runTareaRecolectarPtrMonacoAsyncServiceImpl.ventaOnlinePickingLocalizacionSeccionByRunTarea(runTarea);
    verify(this.runTareaRecolectarPtrMonacoService, times(1)).ventaOnlinePickingLocalizacionSeccionByRunTarea(runTarea);
  }

}
