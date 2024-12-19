package com.inditex.rrhh.icmclcwb.model.app.run.tarea.recolectar.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.ambito.recolectar.service.RunTareaAmbitoRecolectarPtrVentaEcommerceService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaAgrupacionVentaService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaLocalizacionVentaService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class RunTareaRecolectarPtrVentaEcommerceServiceImplTest {
  @Mock
  private RunTareaAmbitoRecolectarPtrVentaEcommerceService runTareaAmbitoRecolectarPtrVentaEcommerceService;

  @Mock
  private TareaLocalizacionVentaService tareaLocalizacionVentaService;

  @Mock
  private TareaAgrupacionVentaService tareaAgrupacionVentaService;

  @InjectMocks
  private RunTareaRecolectarPtrVentaEcommerceServiceImpl runTareaRecolectarPtrVentaEcommerceService;

  @Test
  void ventaOnlineIpodLocalizacionSeccionByRunTareaTest() {
    final RunTareaDto runTarea = new RunTareaDto();
    final TareaDto tarea = new TareaDto();
    runTarea.setTarea(tarea);
    final List<TareaAmbitoDto> ambito = new ArrayList<>();
    tarea.setAmbito(ambito);
    ambito.add(new TareaAmbitoDto());

    this.runTareaRecolectarPtrVentaEcommerceService.ventaOnlineIpodLocalizacionSeccionByRunTarea(runTarea);

    verify(this.runTareaAmbitoRecolectarPtrVentaEcommerceService)
        .ventaOnlineIpodLocalizacionSeccionByRunTareaAndTareaAmbito(any(RunTareaDto.class), any(
            TareaAmbitoDto.class));
  }

  @Test
  void ventaOnlinePickingLocalizacionSeccionByRunTareaTest() {
    final RunTareaDto runTarea = new RunTareaDto();
    final TareaDto tarea = new TareaDto();
    runTarea.setTarea(tarea);
    final List<TareaAmbitoDto> ambito = new ArrayList<>();
    tarea.setAmbito(ambito);
    ambito.add(new TareaAmbitoDto());

    this.runTareaRecolectarPtrVentaEcommerceService.ventaOnlinePickingLocalizacionSeccionByRunTarea(runTarea);

    verify(this.runTareaAmbitoRecolectarPtrVentaEcommerceService)
        .ventaOnlinePickingLocalizacionSeccionByRunTareaAndTareaAmbito(any(RunTareaDto.class), any(
            TareaAmbitoDto.class));
  }

  @Test
  void ventaOnlineEntregaTiendaLocalizacionSeccionByRunTareaTest() {
    final RunTareaDto runTarea = new RunTareaDto();
    final TareaDto tarea = new TareaDto();
    runTarea.setTarea(tarea);
    final List<TareaAmbitoDto> ambito = new ArrayList<>();
    tarea.setAmbito(ambito);
    ambito.add(new TareaAmbitoDto());

    this.runTareaRecolectarPtrVentaEcommerceService.ventaOnlineEntregaTiendaLocalizacionSeccionByRunTarea(runTarea);

    verify(this.runTareaAmbitoRecolectarPtrVentaEcommerceService)
        .ventaOnlineEntregaTiendaLocalizacionSeccionByRunTareaAndTareaAmbito(any(RunTareaDto.class), any(
            TareaAmbitoDto.class));
  }

  @Test
  void ventaOnlineEntregaDomicilioCadenaByRunTareaTest() {
    final RunTareaDto runTarea = new RunTareaDto();
    final TareaDto tarea = new TareaDto();
    runTarea.setTarea(tarea);
    final List<TareaAmbitoDto> ambito = new ArrayList<>();
    tarea.setAmbito(ambito);
    ambito.add(new TareaAmbitoDto());

    this.runTareaRecolectarPtrVentaEcommerceService.ventaOnlineEntregaDomicilioCadenaByRunTarea(runTarea);

    verify(this.runTareaAmbitoRecolectarPtrVentaEcommerceService)
        .ventaOnlineEntregaDomicilioCadenaByRunTareaAndTareaAmbito(any(RunTareaDto.class), any(
            TareaAmbitoDto.class));
  }

  @Test
  void ventaOnlineIpodLocalizacionPersonaByRunTareaTest() {
    final RunTareaDto runTarea = new RunTareaDto();
    final TareaDto tarea = new TareaDto();
    runTarea.setTarea(tarea);
    final List<TareaAmbitoDto> ambito = new ArrayList<>();
    tarea.setAmbito(ambito);
    ambito.add(new TareaAmbitoDto());

    this.runTareaRecolectarPtrVentaEcommerceService.ventaOnlineIpodLocalizacionPersonaByRunTarea(runTarea);

    verify(this.runTareaAmbitoRecolectarPtrVentaEcommerceService)
        .ventaOnlineIpodLocalizacionPersonaByRunTareaAndTareaAmbito(any(RunTareaDto.class), any(
            TareaAmbitoDto.class));
  }

  @Test
  void ventaRangoOnlineIpodLocalizacionSeccionByRunTareaTest() {
    final RunTareaDto runTarea = new RunTareaDto();
    final TareaDto tarea = new TareaDto();
    runTarea.setTarea(tarea);
    final List<TareaAmbitoDto> ambito = new ArrayList<>();
    tarea.setAmbito(ambito);
    ambito.add(new TareaAmbitoDto());

    this.runTareaRecolectarPtrVentaEcommerceService.ventaRangoOnlineIpodLocalizacionSeccionByRunTarea(runTarea);

    verify(this.runTareaAmbitoRecolectarPtrVentaEcommerceService)
        .ventaRangoOnlineIpodLocalizacionSeccionByRunTareaAndTareaAmbito(any(RunTareaDto.class), any(
            TareaAmbitoDto.class));
  }

  @Test
  void ventaRangoOnlineSintLocalizacionSeccionByRunTareaTest() {
    final RunTareaDto runTarea = new RunTareaDto();
    final TareaDto tarea = new TareaDto();
    runTarea.setTarea(tarea);
    final List<TareaAmbitoDto> ambito = new ArrayList<>();
    tarea.setAmbito(ambito);
    ambito.add(new TareaAmbitoDto());

    this.runTareaRecolectarPtrVentaEcommerceService.ventaRangoOnlineSintLocalizacionSeccionByRunTarea(runTarea);

    verify(this.runTareaAmbitoRecolectarPtrVentaEcommerceService)
        .ventaRangoOnlineSintLocalizacionSeccionByRunTareaAndTareaAmbito(any(RunTareaDto.class), any(
            TareaAmbitoDto.class));
  }

  @Test
  void ventaRangoOnlineEntregaTiendaLocalizacionSeccionByRunTareaTest() {
    final RunTareaDto runTarea = new RunTareaDto();
    final TareaDto tarea = new TareaDto();
    runTarea.setTarea(tarea);
    final List<TareaAmbitoDto> ambito = new ArrayList<>();
    tarea.setAmbito(ambito);
    ambito.add(new TareaAmbitoDto());

    this.runTareaRecolectarPtrVentaEcommerceService.ventaRangoOnlineEntregaTiendaLocalizacionSeccionByRunTarea(runTarea);

    verify(this.runTareaAmbitoRecolectarPtrVentaEcommerceService)
        .ventaRangoOnlineEntregaTiendaLocalizacionSeccionByRunTareaAndTareaAmbito(any(RunTareaDto.class), any(
            TareaAmbitoDto.class));
  }

  @Test
  void ventaRangoOnlineEntregaDomicilioLocalizacionSeccionByRunTareaTest() {
    final RunTareaDto runTarea = new RunTareaDto();
    final TareaDto tarea = new TareaDto();
    runTarea.setTarea(tarea);
    final List<TareaAmbitoDto> ambito = new ArrayList<>();
    tarea.setAmbito(ambito);
    ambito.add(new TareaAmbitoDto());

    this.runTareaRecolectarPtrVentaEcommerceService.ventaRangoOnlineEntregaDomicilioLocalizacionSeccionByRunTarea(runTarea);

    verify(this.runTareaAmbitoRecolectarPtrVentaEcommerceService)
        .ventaRangoOnlineEntregaDomicilioLocalizacionSeccionByRunTareaAndTareaAmbito(any(RunTareaDto.class), any(
            TareaAmbitoDto.class));
  }

  @Test
  void updateActivoVentaOnlineIpodByRunTareaTest() {
    final RunTareaDto runTarea = new RunTareaDto();
    final TareaDto tarea = new TareaDto();
    runTarea.setTarea(tarea);

    this.runTareaRecolectarPtrVentaEcommerceService.updateActivoVentaOnlineIpodByRunTarea(runTarea);

    verify(this.tareaLocalizacionVentaService)
        .updateActivoVentaOnlineIpod(any(TareaDto.class));
  }

  @Test
  void updateActivoVentaOnlinePickingByRunTareaTest() {
    final RunTareaDto runTarea = new RunTareaDto();
    final TareaDto tarea = new TareaDto();
    runTarea.setTarea(tarea);

    this.runTareaRecolectarPtrVentaEcommerceService.updateActivoVentaOnlinePickingByRunTarea(runTarea);

    verify(this.tareaLocalizacionVentaService)
        .updateActivoVentaOnlinePicking(any(TareaDto.class));
  }

  @Test
  void updateActivoVentaOnlineEntregaTiendaByRunTareaTest() {
    final RunTareaDto runTarea = new RunTareaDto();
    final TareaDto tarea = new TareaDto();
    runTarea.setTarea(tarea);

    this.runTareaRecolectarPtrVentaEcommerceService.updateActivoVentaOnlineEntregaTiendaByRunTarea(runTarea);

    verify(this.tareaLocalizacionVentaService)
        .updateActivoVentaOnlineEntregaTienda(any(TareaDto.class));
  }

  @Test
  void updateActivoVentaOnlineEntregaDomicilioByRunTareaTest() {
    final RunTareaDto runTarea = new RunTareaDto();
    final TareaDto tarea = new TareaDto();
    runTarea.setTarea(tarea);

    this.runTareaRecolectarPtrVentaEcommerceService.updateActivoVentaOnlineEntregaDomicilioByRunTarea(runTarea);

    verify(this.tareaAgrupacionVentaService)
        .updateActivoVentaOnlineEntregaDomicilio(any(TareaDto.class));
  }
}
