package com.inditex.rrhh.icmclcwb.model.app.tarea.async.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.dto.IdLocalizacionLocalPresupuestoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaLocalizacionPresupuestoVentaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaLocalizacionPresupuestoVentaService;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.ventacongelada.dto.VentaCongeladaResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineentregadomicilio.dto.PtrVentaOnlineEntregaDomicilioResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineentregatienda.dto.PtrVentaOnlineEntregaTiendaResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineipod.dto.PtrVentaOnlineIpodResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlinepicking.dto.PtrVentaOnlinePickingResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.totalizado.dto.PtrVentaTotalizadoResponseDto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class TareaLocalizacionPresupuestoVentaAsyncServiceImplTest {
  @Mock
  private TareaLocalizacionPresupuestoVentaService tareaLocalizacionPresupuestoVentaService;

  @InjectMocks
  private TareaLocalizacionPresupuestoVentaAsyncServiceImpl tareaLocalizacionPresupuestoVentaAsyncService;

  @Test
  void saveTest() {
    final List<TareaLocalizacionPresupuestoVentaDto> lista = new ArrayList<>();

    this.tareaLocalizacionPresupuestoVentaAsyncService.save(lista);

    verify(this.tareaLocalizacionPresupuestoVentaService).save(anyList());
  }

  @Test
  void saveVentaCongeladaResultItemDtoTest() {
    final List<VentaCongeladaResultItemDto> src = new ArrayList<>();
    final TareaDto tarea = new TareaDto();

    this.tareaLocalizacionPresupuestoVentaAsyncService.saveVentaCongeladaResultItemDto(src, tarea);

    verify(this.tareaLocalizacionPresupuestoVentaService).save(anyList(), any(TareaDto.class));
  }

  @Test
  void savePtrVentaTotalizadoResponseTest() {
    final TareaDto tarea = new TareaDto();
    final IdLocalizacionLocalPresupuestoDto iter = new IdLocalizacionLocalPresupuestoDto();
    final PtrVentaTotalizadoResponseDto src = new PtrVentaTotalizadoResponseDto();

    this.tareaLocalizacionPresupuestoVentaAsyncService.savePtrVentaTotalizadoResponse(src, iter, tarea);

    verify(this.tareaLocalizacionPresupuestoVentaService).savePtrVentaTotalizadoResponse(any(PtrVentaTotalizadoResponseDto.class),
        any(IdLocalizacionLocalPresupuestoDto.class), any(TareaDto.class));
  }

  @Test
  void savePtrVentaOnlineIpodResponseTest() {
    final TareaDto tarea = new TareaDto();
    final IdLocalizacionLocalPresupuestoDto iter = new IdLocalizacionLocalPresupuestoDto();
    final PtrVentaOnlineIpodResponseDto src = new PtrVentaOnlineIpodResponseDto();

    this.tareaLocalizacionPresupuestoVentaAsyncService.savePtrVentaOnlineIpodResponse(src, iter, tarea);

    verify(this.tareaLocalizacionPresupuestoVentaService).savePtrVentaOnlineIpodResponse(any(PtrVentaOnlineIpodResponseDto.class),
        any(IdLocalizacionLocalPresupuestoDto.class), any(TareaDto.class));
  }

  @Test
  void savePtrVentaOnlinePickingResponseDtoTest() {
    final TareaDto tarea = new TareaDto();
    final IdLocalizacionLocalPresupuestoDto iter = new IdLocalizacionLocalPresupuestoDto();
    final PtrVentaOnlinePickingResponseDto src = new PtrVentaOnlinePickingResponseDto();

    this.tareaLocalizacionPresupuestoVentaAsyncService.savePtrVentaOnlinePickingResponse(src, iter, tarea);

    verify(this.tareaLocalizacionPresupuestoVentaService).savePtrVentaOnlinePickingResponse(any(PtrVentaOnlinePickingResponseDto.class),
        any(IdLocalizacionLocalPresupuestoDto.class), any(TareaDto.class));
  }

  @Test
  void savePtrVentaOnlineEntregaTiendaResponseTest() {
    final IdLocalizacionLocalPresupuestoDto iter = new IdLocalizacionLocalPresupuestoDto();
    final PtrVentaOnlineEntregaTiendaResponseDto src = new PtrVentaOnlineEntregaTiendaResponseDto();
    final TareaDto tarea = new TareaDto();

    this.tareaLocalizacionPresupuestoVentaAsyncService.savePtrVentaOnlineEntregaTiendaResponse(src, iter, tarea);

    verify(this.tareaLocalizacionPresupuestoVentaService).savePtrVentaOnlineEntregaTiendaResponse(
        any(PtrVentaOnlineEntregaTiendaResponseDto.class),
        any(IdLocalizacionLocalPresupuestoDto.class), any(TareaDto.class));
  }

  @Test
  void savePtrVentaOnlineEntregaDomicilioResponseTest() {
    final TareaDto tarea = new TareaDto();
    final PtrVentaOnlineEntregaDomicilioResponseDto src = new PtrVentaOnlineEntregaDomicilioResponseDto();
    final IdLocalizacionLocalPresupuestoDto iter = new IdLocalizacionLocalPresupuestoDto();

    this.tareaLocalizacionPresupuestoVentaAsyncService.savePtrVentaOnlineEntregaDomicilioResponse(src, iter, tarea);

    verify(this.tareaLocalizacionPresupuestoVentaService).savePtrVentaOnlineEntregaDomicilioResponse(
        any(PtrVentaOnlineEntregaDomicilioResponseDto.class),
        any(IdLocalizacionLocalPresupuestoDto.class), any(TareaDto.class));
  }
}
