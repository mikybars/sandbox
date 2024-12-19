package com.inditex.rrhh.icmclcwb.model.app.run.tarea.recolectar.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.ambito.recolectar.service.RunTareaAmbitoRecolectarPtrVentaGeneralService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class RunTareaRecolectarPtrVentaGeneralServiceImplTest {
  @Mock
  private RunTareaAmbitoRecolectarPtrVentaGeneralService runTareaAmbitoRecolectarPtrVentaGeneralService;

  @InjectMocks
  private RunTareaRecolectarPtrVentaGeneralServiceImpl runTareaRecolectarPtrVentaGeneralService;

  @Test
  void ventaFisicaLocalizacionSeccionByRunTareaTest() {
    final RunTareaDto runTarea = new RunTareaDto();
    final TareaDto tarea = new TareaDto();
    final List<TareaAmbitoDto> ambito = new ArrayList<>();
    final TareaAmbitoDto tareaAmbito = new TareaAmbitoDto();
    tarea.setAmbito(ambito);
    ambito.add(tareaAmbito);
    runTarea.setTarea(tarea);

    this.runTareaRecolectarPtrVentaGeneralService.ventaFisicaLocalizacionSeccionByRunTarea(runTarea);

    verify(this.runTareaAmbitoRecolectarPtrVentaGeneralService)
        .ventaFisicaLocalizacionSeccionByRunTareaAndTareaAmbito(any(RunTareaDto.class), any(
            TareaAmbitoDto.class));
  }

  @Test
  void ventaFisicaCadenaByRunTareaTest() {
    final RunTareaDto runTarea = new RunTareaDto();
    final TareaDto tarea = new TareaDto();
    final List<TareaAmbitoDto> ambito = new ArrayList<>();
    final TareaAmbitoDto tareaAmbito = new TareaAmbitoDto();
    tarea.setAmbito(ambito);
    ambito.add(tareaAmbito);
    runTarea.setTarea(tarea);

    this.runTareaRecolectarPtrVentaGeneralService.ventaFisicaCadenaByRunTarea(runTarea);

    verify(this.runTareaAmbitoRecolectarPtrVentaGeneralService)
        .ventaFisicaCadenaByRunTareaAndTareaAmbito(any(RunTareaDto.class), any(
            TareaAmbitoDto.class));
  }

  @Test
  void ventaRangoFisicaLocalizacionSeccionByRunTareaTest() {
    final RunTareaDto runTarea = new RunTareaDto();
    final TareaDto tarea = new TareaDto();
    final List<TareaAmbitoDto> ambito = new ArrayList<>();
    final TareaAmbitoDto tareaAmbito = new TareaAmbitoDto();
    tarea.setAmbito(ambito);
    ambito.add(tareaAmbito);
    runTarea.setTarea(tarea);

    this.runTareaRecolectarPtrVentaGeneralService.ventaRangoFisicaLocalizacionSeccionByRunTarea(runTarea);

    verify(this.runTareaAmbitoRecolectarPtrVentaGeneralService)
        .ventaRangoFisicaLocalizacionSeccionByRunTareaAndTareaAmbito(any(RunTareaDto.class), any(
            TareaAmbitoDto.class));
  }

  @Test
  void devolucionRangoFisicaLocalizacionSeccionByRunTareaAndTareaAmbitoTest() {
    final RunTareaDto runTarea = new RunTareaDto();
    final TareaDto tarea = new TareaDto();
    final List<TareaAmbitoDto> ambito = new ArrayList<>();
    final TareaAmbitoDto tareaAmbito = new TareaAmbitoDto();
    tarea.setAmbito(ambito);
    ambito.add(tareaAmbito);
    runTarea.setTarea(tarea);

    this.runTareaRecolectarPtrVentaGeneralService.devolucionRangoFisicaLocalizacionSeccionByRunTareaAndTareaAmbito(runTarea);

    verify(this.runTareaAmbitoRecolectarPtrVentaGeneralService)
        .devolucionRangoFisicaLocalizacionSeccionByRunTareaAndTareaAmbito(any(RunTareaDto.class), any(
            TareaAmbitoDto.class));
  }

  @Test
  void devolucionVentaOriginalOtraTiendaRangoFisicaLocalizacionSeccionByRunTareaAndTareaAmbitoTest() {
    final RunTareaDto runTarea = new RunTareaDto();
    final TareaDto tarea = new TareaDto();
    final List<TareaAmbitoDto> ambito = new ArrayList<>();
    final TareaAmbitoDto tareaAmbito = new TareaAmbitoDto();
    tarea.setAmbito(ambito);
    ambito.add(tareaAmbito);
    runTarea.setTarea(tarea);

    this.runTareaRecolectarPtrVentaGeneralService
        .devolucionVentaOriginalOtraTiendaRangoFisicaLocalizacionSeccionByRunTareaAndTareaAmbito(runTarea);

    verify(this.runTareaAmbitoRecolectarPtrVentaGeneralService)
        .devolucionVentaOriginalOtraTiendaRangoFisicaLocalizacionSeccionByRunTareaAndTareaAmbito(any(RunTareaDto.class), any(
            TareaAmbitoDto.class));
  }

  @Test
  void ventaFisicaLocalizacionSeccionRepartoOnlineByRunTareaAndTareaAmbitoTest() {
    final RunTareaDto runTarea = new RunTareaDto();
    final TareaDto tarea = new TareaDto();
    final List<TareaAmbitoDto> ambito = new ArrayList<>();
    final TareaAmbitoDto tareaAmbito = new TareaAmbitoDto();
    tarea.setAmbito(ambito);
    ambito.add(tareaAmbito);
    runTarea.setTarea(tarea);

    this.runTareaRecolectarPtrVentaGeneralService.ventaFisicaLocalizacionSeccionRepartoOnlineByRunTareaAndTareaAmbito(runTarea);

    verify(this.runTareaAmbitoRecolectarPtrVentaGeneralService)
        .ventaFisicaLocalizacionSeccionRepartoOnlineByRunTareaAndTareaAmbito(any(RunTareaDto.class), any(
            TareaAmbitoDto.class));
  }
}
