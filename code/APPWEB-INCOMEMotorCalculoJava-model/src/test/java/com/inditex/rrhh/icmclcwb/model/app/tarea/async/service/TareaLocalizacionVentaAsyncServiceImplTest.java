package com.inditex.rrhh.icmclcwb.model.app.tarea.async.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaLocalizacionVentaService;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.ventamanualwloc.dto.VentaManualWlocResultItemDto;
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
class TareaLocalizacionVentaAsyncServiceImplTest {
  @Mock
  private TareaLocalizacionVentaService tareaLocalizacionVentaService;

  @InjectMocks
  private TareaLocalizacionVentaAsyncServiceImpl tareaLocalizacionVentaAsyncService;

  @Test
  void saveTest() {
    final List<VentaManualWlocResultItemDto> src = new ArrayList<>();
    final TareaDto tareaDto = new TareaDto();

    this.tareaLocalizacionVentaAsyncService.save(src, tareaDto);

    verify(this.tareaLocalizacionVentaService).save(anyList(), any(TareaDto.class));
  }

  @Test
  void savePtrVentaTotalizadoResponseTest() {
    final PtrVentaTotalizadoResponseDto dto = new PtrVentaTotalizadoResponseDto();
    final TareaDto tarea = new TareaDto();

    this.tareaLocalizacionVentaAsyncService.savePtrVentaTotalizadoResponse(dto, tarea);

    verify(this.tareaLocalizacionVentaService).savePtrVentaTotalizadoResponse(any(PtrVentaTotalizadoResponseDto.class),
        any(TareaDto.class));
  }

  @Test
  void savePtrVentaTotalizadoResponseRepartoOnlineTest() {
    final PtrVentaTotalizadoResponseDto dto = new PtrVentaTotalizadoResponseDto();
    final TareaDto tarea = new TareaDto();

    this.tareaLocalizacionVentaAsyncService.savePtrVentaTotalizadoResponseRepartoOnline(dto, tarea);

    verify(this.tareaLocalizacionVentaService).savePtrVentaTotalizadoResponseRepartoOnline(any(PtrVentaTotalizadoResponseDto.class),
        any(TareaDto.class));
  }

  @Test
  void savePtrVentaOnlineIpodResponseTest() {
    final PtrVentaOnlineIpodResponseDto dto = new PtrVentaOnlineIpodResponseDto();
    final TareaDto tarea = new TareaDto();

    this.tareaLocalizacionVentaAsyncService.savePtrVentaOnlineIpodResponse(dto, tarea);

    verify(this.tareaLocalizacionVentaService).savePtrVentaOnlineIpodResponse(any(PtrVentaOnlineIpodResponseDto.class),
        any(TareaDto.class));
  }

  @Test
  void savePtrVentaOnlinePickingResponseTest() {
    final PtrVentaOnlinePickingResponseDto dto = new PtrVentaOnlinePickingResponseDto();
    final TareaDto tarea = new TareaDto();

    this.tareaLocalizacionVentaAsyncService.savePtrVentaOnlinePickingResponse(dto, tarea);

    verify(this.tareaLocalizacionVentaService).savePtrVentaOnlinePickingResponse(any(PtrVentaOnlinePickingResponseDto.class),
        any(TareaDto.class));
  }

  @Test
  void savePtrVentaOnlineEntregaTiendaResponseTest() {
    final PtrVentaOnlineEntregaTiendaResponseDto dto = new PtrVentaOnlineEntregaTiendaResponseDto();
    final TareaDto tarea = new TareaDto();

    this.tareaLocalizacionVentaAsyncService.savePtrVentaOnlineEntregaTiendaResponse(dto, tarea);

    verify(this.tareaLocalizacionVentaService).savePtrVentaOnlineEntregaTiendaResponse(any(PtrVentaOnlineEntregaTiendaResponseDto.class),
        any(TareaDto.class));
  }

  @Test
  void savePtrVentaOnlineEntregaDomicilioResponseTest() {
    final PtrVentaOnlineEntregaDomicilioResponseDto dto = new PtrVentaOnlineEntregaDomicilioResponseDto();
    final TareaDto tarea = new TareaDto();

    this.tareaLocalizacionVentaAsyncService.savePtrVentaOnlineEntregaDomicilioResponse(dto, tarea);

    verify(this.tareaLocalizacionVentaService).savePtrVentaOnlineEntregaDomicilioResponse(
        any(PtrVentaOnlineEntregaDomicilioResponseDto.class),
        any(TareaDto.class));
  }
}
