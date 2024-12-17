package com.inditex.rrhh.icmclcwb.model.app.run.tarea.recolectar.async.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.service.RunTareaRecolectarPtrVentaEcommerceService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class RunTareaRecolectarPtrVentaEcommerceAsyncServiceImplTest {
  @Mock
  private RunTareaRecolectarPtrVentaEcommerceService tareaRecolectarPtrVentaEcommerceService;

  @InjectMocks
  private RunTareaRecolectarPtrVentaEcommerceAsyncServiceImpl runTareaRecolectarPtrVentaEcommerceAsyncService;

  @Test
  void ventaOnlineEntregaDomicilioCadenaByRunTareaTest() {
    this.runTareaRecolectarPtrVentaEcommerceAsyncService.ventaOnlineEntregaDomicilioCadenaByRunTarea(new RunTareaDto());
    verify(this.tareaRecolectarPtrVentaEcommerceService).ventaOnlineEntregaDomicilioCadenaByRunTarea(any(RunTareaDto.class));
  }

  @Test
  void ventaOnlineEntregaTiendaLocalizacionSeccionByRunTareaTest() {
    this.runTareaRecolectarPtrVentaEcommerceAsyncService.ventaOnlineEntregaTiendaLocalizacionSeccionByRunTarea(new RunTareaDto());
    verify(this.tareaRecolectarPtrVentaEcommerceService).ventaOnlineEntregaTiendaLocalizacionSeccionByRunTarea(any(RunTareaDto.class));
  }

  @Test
  void ventaOnlineIpodLocalizacionSeccionByRunTareaTest() {
    this.runTareaRecolectarPtrVentaEcommerceAsyncService.ventaOnlineIpodLocalizacionSeccionByRunTarea(new RunTareaDto());
    verify(this.tareaRecolectarPtrVentaEcommerceService).ventaOnlineIpodLocalizacionSeccionByRunTarea(any(RunTareaDto.class));
  }

  @Test
  void ventaOnlinePickingLocalizacionSeccionByRunTareaTest() {
    this.runTareaRecolectarPtrVentaEcommerceAsyncService.ventaOnlinePickingLocalizacionSeccionByRunTarea(new RunTareaDto());
    verify(this.tareaRecolectarPtrVentaEcommerceService).ventaOnlinePickingLocalizacionSeccionByRunTarea(any(RunTareaDto.class));
  }

  @Test
  void ventaOnlineIpodLocalizacionPersonaByRunTareaTest() {
    this.runTareaRecolectarPtrVentaEcommerceAsyncService.ventaOnlineIpodLocalizacionPersonaByRunTarea(new RunTareaDto());
    verify(this.tareaRecolectarPtrVentaEcommerceService).ventaOnlineIpodLocalizacionPersonaByRunTarea(any(RunTareaDto.class));
  }

  @Test
  void ventaRangoOnlineIpodLocalizacionSeccionByRunTareaTest() {
    this.runTareaRecolectarPtrVentaEcommerceAsyncService.ventaRangoOnlineIpodLocalizacionSeccionByRunTarea(new RunTareaDto());
    verify(this.tareaRecolectarPtrVentaEcommerceService).ventaRangoOnlineIpodLocalizacionSeccionByRunTarea(any(RunTareaDto.class));
  }

  @Test
  void ventaRangoOnlineSintLocalizacionSeccionByRunTareaTest() {
    this.runTareaRecolectarPtrVentaEcommerceAsyncService.ventaRangoOnlineSintLocalizacionSeccionByRunTarea(new RunTareaDto());
    verify(this.tareaRecolectarPtrVentaEcommerceService).ventaRangoOnlineSintLocalizacionSeccionByRunTarea(any(RunTareaDto.class));
  }

  @Test
  void ventaRangoOnlineEntregaTiendaLocalizacionSeccionByRunTareaTest() {
    this.runTareaRecolectarPtrVentaEcommerceAsyncService.ventaRangoOnlineEntregaTiendaLocalizacionSeccionByRunTarea(new RunTareaDto());
    verify(this.tareaRecolectarPtrVentaEcommerceService).ventaRangoOnlineEntregaTiendaLocalizacionSeccionByRunTarea(any(RunTareaDto.class));
  }

  @Test
  void ventaRangoOnlineEntregaDomicilioLocalizacionSeccionByRunTareaTest() {
    this.runTareaRecolectarPtrVentaEcommerceAsyncService.ventaRangoOnlineEntregaDomicilioLocalizacionSeccionByRunTarea(new RunTareaDto());
    verify(this.tareaRecolectarPtrVentaEcommerceService)
        .ventaRangoOnlineEntregaDomicilioLocalizacionSeccionByRunTarea(any(RunTareaDto.class));
  }

  @Test
  void updateActivoVentaOnlineIpodByRunTareaTest() {
    this.runTareaRecolectarPtrVentaEcommerceAsyncService.updateActivoVentaOnlineIpodByRunTarea(new RunTareaDto());
    verify(this.tareaRecolectarPtrVentaEcommerceService).updateActivoVentaOnlineIpodByRunTarea(any(RunTareaDto.class));
  }

  @Test
  void updateActivoVentaOnlinePickingByRunTareaTest() {
    this.runTareaRecolectarPtrVentaEcommerceAsyncService.updateActivoVentaOnlinePickingByRunTarea(new RunTareaDto());
    verify(this.tareaRecolectarPtrVentaEcommerceService).updateActivoVentaOnlinePickingByRunTarea(any(RunTareaDto.class));
  }

  @Test
  void updateActivoVentaOnlineEntregaTiendaByRunTareaTest() {
    this.runTareaRecolectarPtrVentaEcommerceAsyncService.updateActivoVentaOnlineEntregaTiendaByRunTarea(new RunTareaDto());
    verify(this.tareaRecolectarPtrVentaEcommerceService).updateActivoVentaOnlineEntregaTiendaByRunTarea(any(RunTareaDto.class));
  }

  @Test
  void updateActivoVentaOnlineEntregaDomicilioByRunTareaTest() {
    this.runTareaRecolectarPtrVentaEcommerceAsyncService.updateActivoVentaOnlineEntregaDomicilioByRunTarea(new RunTareaDto());
    verify(this.tareaRecolectarPtrVentaEcommerceService).updateActivoVentaOnlineEntregaDomicilioByRunTarea(any(RunTareaDto.class));
  }
}
