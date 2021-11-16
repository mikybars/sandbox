package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAgrupacionCadenasDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineentregadomicilio.dto.PtrVentaOnlineEntregaDomicilioResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineentregadomicilio.dto.PtrVentaOnlineEntregaDomicilioResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.totalizado.dto.PtrVentaTotalizadoResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.totalizado.dto.PtrVentaTotalizadoResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaAgrupacionVentaMapper;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator.TareaAgrupacionVentaDecorator;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaAgrupacionVenta;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaAgrupacionVentaRepositoryCustomImpl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class TareaAgrupacionVentaServiceImplTest {

  @Mock
  private TareaAgrupacionVentaRepositoryCustomImpl tareaAgrupacionVentaRepositoryCustomImpl;

  @InjectMocks
  private TareaAgrupacionVentaServiceImpl tareaAgrupacionVentaServiceImpl;

  @Mock
  private TareaAgrupacionVentaMapper tareaAgrupacionVentaMapper;

  @Mock
  private TareaAgrupacionVentaDecorator tareaAgrupacionVentaDecorator;

  @Test
  public void savePtrVentaTotalizadoResponseTest() {
    final TareaDto tarea = mock(TareaDto.class);
    final PtrVentaTotalizadoResponseDto ptrVentaTotalizadoResponseDto = new PtrVentaTotalizadoResponseDto();
    ptrVentaTotalizadoResponseDto.setVentaTotalizado(new ArrayList<>());
    final PtrVentaTotalizadoResultItemDto ptrVentaTotalizadoResultItemDto = mock(
        PtrVentaTotalizadoResultItemDto.class);
    ptrVentaTotalizadoResponseDto.getVentaTotalizado().add(ptrVentaTotalizadoResultItemDto);
    final List<TareaAgrupacionVenta> dtoList = new ArrayList<TareaAgrupacionVenta>();
    final List<TareaAgrupacionCadenasDto> agrupaciones = new ArrayList<>();
    when(this.tareaAgrupacionVentaRepositoryCustomImpl.save(ArgumentMatchers.<List<TareaAgrupacionVenta>>any()))
        .thenReturn(dtoList);

    this.tareaAgrupacionVentaServiceImpl.savePtrVentaTotalizadoResponse(ptrVentaTotalizadoResponseDto, tarea,
        agrupaciones);

    verify(this.tareaAgrupacionVentaRepositoryCustomImpl, times(1))
        .save(ArgumentMatchers.<List<TareaAgrupacionVenta>>any());
  }

  @Test
  public void savePtrVentaOnlineEntregaDomicilioResponseTest() {
    final TareaDto tarea = mock(TareaDto.class);
    final PtrVentaOnlineEntregaDomicilioResponseDto ptrVentaOnlineEntregaDomicilioResponseDto =
        new PtrVentaOnlineEntregaDomicilioResponseDto();
    ptrVentaOnlineEntregaDomicilioResponseDto.setVentaOnline(new ArrayList<>());
    final PtrVentaOnlineEntregaDomicilioResultItemDto ptrVentaTotalizadoResultItemDto = mock(
        PtrVentaOnlineEntregaDomicilioResultItemDto.class);
    ptrVentaOnlineEntregaDomicilioResponseDto.getVentaOnline().add(ptrVentaTotalizadoResultItemDto);
    final List<TareaAgrupacionVenta> list = new ArrayList<TareaAgrupacionVenta>();
    final List<TareaAgrupacionCadenasDto> agrupaciones = new ArrayList<>();
    when(this.tareaAgrupacionVentaRepositoryCustomImpl.save(ArgumentMatchers.<List<TareaAgrupacionVenta>>any()))
        .thenReturn(list);

    this.tareaAgrupacionVentaServiceImpl
        .savePtrVentaOnlineEntregaDomicilioResponse(ptrVentaOnlineEntregaDomicilioResponseDto, tarea, agrupaciones);

    verify(this.tareaAgrupacionVentaRepositoryCustomImpl, times(1))
        .save(ArgumentMatchers.<List<TareaAgrupacionVenta>>any());
  }

}
