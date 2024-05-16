package com.inditex.rrhh.icmclcwb.model.app.run.tarea.recolectar.async.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.service.RunTareaRecolectarPtrVentaGeneralService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class RunTareaRecolectarPtrVentaGeneralAsyncServiceImplTest {
  @Mock
  private RunTareaRecolectarPtrVentaGeneralService tareaRecolectarPtrVentaService;

  @InjectMocks
  private RunTareaRecolectarPtrVentaGeneralAsyncServiceImpl runTareaRecolectarPtrVentaGeneralAsyncService;

  @Test
  void ventaFisicaLocalizacionSeccionByRunTareaTest() {
    this.runTareaRecolectarPtrVentaGeneralAsyncService.ventaFisicaLocalizacionSeccionByRunTarea(new RunTareaDto());
    verify(this.tareaRecolectarPtrVentaService).ventaFisicaLocalizacionSeccionByRunTarea(any(RunTareaDto.class));
  }

  @Test
  void ventaFisicaCadenaByRunTareaTest() {
    this.runTareaRecolectarPtrVentaGeneralAsyncService.ventaFisicaCadenaByRunTarea(new RunTareaDto());
    verify(this.tareaRecolectarPtrVentaService).ventaFisicaCadenaByRunTarea(any(RunTareaDto.class));
  }

  @Test
  void ventaRangoFisicaLocalizacionSeccionByRunTareaTest() {
    this.runTareaRecolectarPtrVentaGeneralAsyncService.ventaRangoFisicaLocalizacionSeccionByRunTarea(new RunTareaDto());
    verify(this.tareaRecolectarPtrVentaService).ventaRangoFisicaLocalizacionSeccionByRunTarea(any(RunTareaDto.class));
  }

  @Test
  void devolucionRangoFisicaLocalizacionSeccionByRunTareaAndTareaAmbitoTest() {
    this.runTareaRecolectarPtrVentaGeneralAsyncService.devolucionRangoFisicaLocalizacionSeccionByRunTareaAndTareaAmbito(new RunTareaDto());
    verify(this.tareaRecolectarPtrVentaService).devolucionRangoFisicaLocalizacionSeccionByRunTareaAndTareaAmbito(any(RunTareaDto.class));
  }

  @Test
  void devolucionVentaOriginalOtraTiendaRangoFisicaLocalizacionSeccionByRunTareaAndTareaAmbitoTest() {
    this.runTareaRecolectarPtrVentaGeneralAsyncService
        .devolucionVentaOriginalOtraTiendaRangoFisicaLocalizacionSeccionByRunTareaAndTareaAmbito(new RunTareaDto());
    verify(this.tareaRecolectarPtrVentaService)
        .devolucionVentaOriginalOtraTiendaRangoFisicaLocalizacionSeccionByRunTareaAndTareaAmbito(any(RunTareaDto.class));
  }

  @Test
  void ventaFisicaLocalizacionSeccionRepartoOnlineByRunTareaTest() {
    this.runTareaRecolectarPtrVentaGeneralAsyncService.ventaFisicaLocalizacionSeccionRepartoOnlineByRunTarea(new RunTareaDto());
    verify(this.tareaRecolectarPtrVentaService).ventaFisicaLocalizacionSeccionRepartoOnlineByRunTareaAndTareaAmbito(any(RunTareaDto.class));
  }
}
