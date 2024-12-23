package com.inditex.rrhh.icmclcwb.model.app.tarea.async.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAgrupacionCadenasDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaAgrupacionVentaService;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineentregadomicilio.dto.PtrVentaOnlineEntregaDomicilioResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.totalizado.dto.PtrVentaTotalizadoResponseDto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class TareaAgrupacionVentaAsyncServiceImplTest {
  @Mock
  private TareaAgrupacionVentaService tareaAgrupacionVentaService;

  @InjectMocks
  private TareaAgrupacionVentaAsyncServiceImpl tareaAgrupacionVentaAsyncService;

  @Test
  void savePtrVentaTotalizadoResponseTest() {
    final PtrVentaTotalizadoResponseDto dto = new PtrVentaTotalizadoResponseDto();
    final TareaDto tarea = new TareaDto();
    final List<TareaAgrupacionCadenasDto> agrupaciones = new ArrayList<>();

    this.tareaAgrupacionVentaAsyncService.savePtrVentaTotalizadoResponse(dto, tarea, agrupaciones);

    verify(this.tareaAgrupacionVentaService).savePtrVentaTotalizadoResponse(any(PtrVentaTotalizadoResponseDto.class), any(TareaDto.class),
        anyList());
  }

  @Test
  void savePtrVentaOnlineEntregaDomicilioResponseTest() {
    final PtrVentaOnlineEntregaDomicilioResponseDto dto = new PtrVentaOnlineEntregaDomicilioResponseDto();
    final TareaDto tarea = new TareaDto();
    final List<TareaAgrupacionCadenasDto> agrupaciones = new ArrayList<>();

    this.tareaAgrupacionVentaAsyncService.savePtrVentaOnlineEntregaDomicilioResponse(dto, tarea, agrupaciones);

    verify(this.tareaAgrupacionVentaService).savePtrVentaOnlineEntregaDomicilioResponse(
        any(PtrVentaOnlineEntregaDomicilioResponseDto.class),
        any(TareaDto.class),
        anyList());
  }
}
