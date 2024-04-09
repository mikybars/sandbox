package com.inditex.rrhh.icmclcwb.model.app.run.tarea.recolectar.service;

/*
 * Copyright (c) 2022. Inditex
 */
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import com.inditex.amigafwk.test.randomizer.Random;
import com.inditex.amigafwk.test.randomizer.RandomizerExtension;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.ambito.recolectar.service.RunTareaAmbitoRecolectarPtrMonacoService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@TestInstance(Lifecycle.PER_CLASS)
@ExtendWith({SpringExtension.class, RandomizerExtension.class})
public class RunTareaRecolectarPtrMonacoServiceImplTest {

  @Mock
  private RunTareaAmbitoRecolectarPtrMonacoService runTareaAmbitoRecolectarPtrMonacoService;

  @InjectMocks
  private RunTareaRecolectarPtrMonacoServiceImpl runTareaRecolectarPtrMonacoServiceImpl;

  @Test
  void presenciaDetalleComisionablePersonaByRunTareaTest(@Random final RunTareaDto runTarea) {
    final TareaAmbitoDto ambito = new TareaAmbitoDto();
    runTarea.getTarea().getAmbito().add(ambito);
    this.runTareaRecolectarPtrMonacoServiceImpl.presenciaDetalleComisionablePersonaByRunTarea(runTarea);
    verify(this.runTareaAmbitoRecolectarPtrMonacoService, times(1)).presenciaDetalleComisionablePersonaByRunTareaAndTareaAmbito(runTarea,
        ambito);
  }

  @Test
  void presenciaDetallePersonaIncluidoCommerceByRunTareaAndTareaAmbitoTest(@Random final RunTareaDto runTarea) {
    final TareaAmbitoDto ambito = new TareaAmbitoDto();
    runTarea.getTarea().getAmbito().add(ambito);
    this.runTareaRecolectarPtrMonacoServiceImpl.presenciaDetallePersonaIncluidoCommerceByRunTarea(runTarea);
    verify(this.runTareaAmbitoRecolectarPtrMonacoService, times(1)).presenciaDetallePersonaIncluidoCommerceByRunTareaAndTareaAmbito(
        runTarea,
        ambito);
  }

  @Test
  void ventaOnlineEntregaTiendaLocalizacionSeccionByRunTareaAndTareaAmbitoTest(@Random final RunTareaDto runTarea) {
    final TareaAmbitoDto ambito = new TareaAmbitoDto();
    runTarea.getTarea().getAmbito().add(ambito);
    this.runTareaRecolectarPtrMonacoServiceImpl.ventaOnlineEntregaTiendaLocalizacionSeccionByRunTarea(runTarea);
    verify(this.runTareaAmbitoRecolectarPtrMonacoService, times(1)).ventaOnlineEntregaTiendaLocalizacionSeccionByRunTareaAndTareaAmbito(
        runTarea,
        ambito);
  }

  @Test
  void ventaFisicaLocalizacionSeccionByRunTareaAndTareaAmbitoTest(@Random final RunTareaDto runTarea) {
    final TareaAmbitoDto ambito = new TareaAmbitoDto();
    runTarea.getTarea().getAmbito().add(ambito);
    this.runTareaRecolectarPtrMonacoServiceImpl.ventaFisicaLocalizacionSeccionByRunTarea(runTarea);
    verify(this.runTareaAmbitoRecolectarPtrMonacoService, times(1)).ventaFisicaLocalizacionSeccionByRunTareaAndTareaAmbito(
        runTarea,
        ambito);
  }

  @Test
  void ventaFisicaLocalizacionSeccionRepartoOnlineByRunTareaTest(@Random final RunTareaDto runTarea) {
    final TareaAmbitoDto ambito = new TareaAmbitoDto();
    runTarea.getTarea().getAmbito().add(ambito);
    this.runTareaRecolectarPtrMonacoServiceImpl.ventaFisicaLocalizacionSeccionRepartoOnlineByRunTarea(runTarea);
    verify(this.runTareaAmbitoRecolectarPtrMonacoService, times(1)).ventaFisicaLocalizacionSeccionRepartoOnlineByRunTareaAndTareaAmbito(
        runTarea,
        ambito);
  }

  @Test
  void ventaOnlineIpodLocalizacionSeccionByRunTareaTest(@Random final RunTareaDto runTarea) {
    final TareaAmbitoDto ambito = new TareaAmbitoDto();
    runTarea.getTarea().getAmbito().add(ambito);
    this.runTareaRecolectarPtrMonacoServiceImpl.ventaOnlineIpodLocalizacionSeccionByRunTarea(runTarea);
    verify(this.runTareaAmbitoRecolectarPtrMonacoService, times(1)).ventaOnlineIpodLocalizacionSeccionByRunTareaAndTareaAmbito(
        runTarea,
        ambito);
  }

  @Test
  void ventaOnlinePickingLocalizacionSeccionByRunTareaTest(@Random final RunTareaDto runTarea) {
    final TareaAmbitoDto ambito = new TareaAmbitoDto();
    runTarea.getTarea().getAmbito().add(ambito);
    this.runTareaRecolectarPtrMonacoServiceImpl.ventaOnlinePickingLocalizacionSeccionByRunTarea(runTarea);
    verify(this.runTareaAmbitoRecolectarPtrMonacoService, times(1)).ventaOnlinePickingLocalizacionSeccionByRunTareaAndTareaAmbito(
        runTarea,
        ambito);
  }

  @Test
  void ventaOnlineEntregaTiendaLocalizacionSeccionByRunTareaTest(@Random final RunTareaDto runTarea) {
    final TareaAmbitoDto ambito = new TareaAmbitoDto();
    runTarea.getTarea().getAmbito().add(ambito);
    this.runTareaRecolectarPtrMonacoServiceImpl.ventaOnlineEntregaTiendaLocalizacionSeccionByRunTarea(runTarea);
    verify(this.runTareaAmbitoRecolectarPtrMonacoService, times(1)).ventaOnlineEntregaTiendaLocalizacionSeccionByRunTareaAndTareaAmbito(
        runTarea,
        ambito);
  }

}
