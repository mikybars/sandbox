package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.dto.IdLocalizacionLocalPresupuestoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaLocalizacionPresupuestoVentaDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.ventacongelada.dto.VentaCongeladaResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineentregadomicilio.dto.PtrVentaOnlineEntregaDomicilioResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineentregadomicilio.dto.PtrVentaOnlineEntregaDomicilioResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineentregatienda.dto.PtrVentaOnlineEntregaTiendaResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineentregatienda.dto.PtrVentaOnlineEntregaTiendaResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineipod.dto.PtrVentaOnlineIpodResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineipod.dto.PtrVentaOnlineIpodResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlinepicking.dto.PtrVentaOnlinePickingResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlinepicking.dto.PtrVentaOnlinePickingResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.totalizado.dto.PtrVentaTotalizadoResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.totalizado.dto.PtrVentaTotalizadoResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaLocalizacionPresupuestoVentaMapper;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator.TareaLocalizacionPresupuestoVentaDecorator;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLocalizacionPresupuestoVenta;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaLocalizacionPresupuestoVentaRepositoryCustomImpl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class TareaLocalizacionPresupuestoVentaServiceImplTest {

  @Mock
  private TareaLocalizacionPresupuestoVentaRepositoryCustomImpl tareaLocalizacionPresupuestoVentaRepositoryCustomImpl;

  @InjectMocks
  private TareaLocalizacionPresupuestoVentaServiceImpl tareaLocalizacionPresupuestoVentaService;

  @Mock
  private TareaLocalizacionPresupuestoVentaMapper tareaLocalizacionPresupuestoVentaMapper;

  @Mock
  private TareaLocalizacionPresupuestoVentaDecorator tareaLocalizacionPresupuestoVentaDecorator;

  @Test
  public void saveTest() {
    final TareaLocalizacionPresupuestoVentaDto tareaLocalizacionPresupuestoVentaDto = mock(
        TareaLocalizacionPresupuestoVentaDto.class);
    final List<TareaLocalizacionPresupuestoVentaDto> dtoList = new ArrayList<TareaLocalizacionPresupuestoVentaDto>();
    final List<TareaLocalizacionPresupuestoVenta> list = new ArrayList<TareaLocalizacionPresupuestoVenta>();

    dtoList.add(tareaLocalizacionPresupuestoVentaDto);
    when(this.tareaLocalizacionPresupuestoVentaRepositoryCustomImpl
        .save(ArgumentMatchers.<List<TareaLocalizacionPresupuestoVenta>>any())).thenReturn(list);

    this.tareaLocalizacionPresupuestoVentaService.save(dtoList);

    verify(this.tareaLocalizacionPresupuestoVentaRepositoryCustomImpl, times(1))
        .save(ArgumentMatchers.<List<TareaLocalizacionPresupuestoVenta>>any());
  }

  @Test
  public void saveVentaCongeladaResultItemDtoTest() {
    final TareaDto tarea = mock(TareaDto.class);
    final VentaCongeladaResultItemDto ventaCongeladaResultItemDto = mock(VentaCongeladaResultItemDto.class);
    final List<VentaCongeladaResultItemDto> dtoList = new ArrayList<VentaCongeladaResultItemDto>();
    final List<TareaLocalizacionPresupuestoVenta> list = new ArrayList<TareaLocalizacionPresupuestoVenta>();

    dtoList.add(ventaCongeladaResultItemDto);
    when(this.tareaLocalizacionPresupuestoVentaRepositoryCustomImpl
        .save(ArgumentMatchers.<List<TareaLocalizacionPresupuestoVenta>>any())).thenReturn(list);

    this.tareaLocalizacionPresupuestoVentaService.save(dtoList, tarea);

    verify(this.tareaLocalizacionPresupuestoVentaRepositoryCustomImpl, times(1))
        .save(ArgumentMatchers.<List<TareaLocalizacionPresupuestoVenta>>any());
  }

  @Test
  public void savePtrVentaTotalizadoResponseTest() {
    final TareaDto tarea = mock(TareaDto.class);
    final IdLocalizacionLocalPresupuestoDto localizacion = mock(IdLocalizacionLocalPresupuestoDto.class);
    final PtrVentaTotalizadoResponseDto ptrVentaTotalizadoResponseDto = new PtrVentaTotalizadoResponseDto();
    ptrVentaTotalizadoResponseDto.setVentaTotalizado(new ArrayList<>());
    final PtrVentaTotalizadoResultItemDto ptrVentaTotalizadoResultItemDto = mock(
        PtrVentaTotalizadoResultItemDto.class);
    ptrVentaTotalizadoResponseDto.getVentaTotalizado().add(ptrVentaTotalizadoResultItemDto);
    final List<TareaLocalizacionPresupuestoVenta> list = new ArrayList<TareaLocalizacionPresupuestoVenta>();

    when(this.tareaLocalizacionPresupuestoVentaRepositoryCustomImpl
        .save(ArgumentMatchers.<List<TareaLocalizacionPresupuestoVenta>>any())).thenReturn(list);

    this.tareaLocalizacionPresupuestoVentaService.savePtrVentaTotalizadoResponse(ptrVentaTotalizadoResponseDto,
        localizacion, tarea);

    verify(this.tareaLocalizacionPresupuestoVentaRepositoryCustomImpl, times(1))
        .save(ArgumentMatchers.<List<TareaLocalizacionPresupuestoVenta>>any());
  }

  @Test
  public void savePtrVentaOnlineIpodResponseTest() {
    final TareaDto tarea = mock(TareaDto.class);
    final IdLocalizacionLocalPresupuestoDto localizacion = mock(IdLocalizacionLocalPresupuestoDto.class);
    final PtrVentaOnlineIpodResponseDto ptrVentaOnlineIpodResponseDto = new PtrVentaOnlineIpodResponseDto();
    ptrVentaOnlineIpodResponseDto.setVentaOnline(new ArrayList<>());
    final PtrVentaOnlineIpodResultItemDto ptrVentaOnlineIpodResultItemDto = mock(
        PtrVentaOnlineIpodResultItemDto.class);
    ptrVentaOnlineIpodResponseDto.getVentaOnline().add(ptrVentaOnlineIpodResultItemDto);

    final List<TareaLocalizacionPresupuestoVenta> list = new ArrayList<>();
    when(this.tareaLocalizacionPresupuestoVentaRepositoryCustomImpl.save(ArgumentMatchers
        .<List<TareaLocalizacionPresupuestoVenta>>any())).thenReturn(list);
    this.tareaLocalizacionPresupuestoVentaService.savePtrVentaOnlineIpodResponse(ptrVentaOnlineIpodResponseDto,
        localizacion, tarea);

    verify(this.tareaLocalizacionPresupuestoVentaRepositoryCustomImpl, times(1)).save(ArgumentMatchers
        .<List<TareaLocalizacionPresupuestoVenta>>any());
  }

  @Test
  public void savePtrVentaOnlinePickingResponseTest() {
    final TareaDto tarea = mock(TareaDto.class);
    final IdLocalizacionLocalPresupuestoDto localizacion = mock(IdLocalizacionLocalPresupuestoDto.class);
    final PtrVentaOnlinePickingResponseDto ptrVentaOnlinePickingResponseDto = new PtrVentaOnlinePickingResponseDto();
    ptrVentaOnlinePickingResponseDto.setVentaOnline(new ArrayList<>());
    final PtrVentaOnlinePickingResultItemDto ptrVentaOnlinePickingResultItemDto = mock(
        PtrVentaOnlinePickingResultItemDto.class);
    ptrVentaOnlinePickingResponseDto.getVentaOnline().add(ptrVentaOnlinePickingResultItemDto);
    final List<TareaLocalizacionPresupuestoVenta> list = new ArrayList<>();

    when(this.tareaLocalizacionPresupuestoVentaRepositoryCustomImpl.save(ArgumentMatchers
        .<List<TareaLocalizacionPresupuestoVenta>>any())).thenReturn(list);

    this.tareaLocalizacionPresupuestoVentaService.savePtrVentaOnlinePickingResponse(
        ptrVentaOnlinePickingResponseDto,
        localizacion, tarea);

    verify(this.tareaLocalizacionPresupuestoVentaRepositoryCustomImpl, times(1)).save(ArgumentMatchers
        .<List<TareaLocalizacionPresupuestoVenta>>any());
  }

  @Test
  public void savePtrVentaOnlineEntregaTiendaResponseTest() {
    final TareaDto tarea = mock(TareaDto.class);
    final IdLocalizacionLocalPresupuestoDto localizacion = mock(IdLocalizacionLocalPresupuestoDto.class);
    final PtrVentaOnlineEntregaTiendaResponseDto ptVentaOnlineEntregaTiendaResponseDto = new PtrVentaOnlineEntregaTiendaResponseDto();
    ptVentaOnlineEntregaTiendaResponseDto.setVentaOnline(new ArrayList<>());
    final PtrVentaOnlineEntregaTiendaResultItemDto ptrVentaOnlineEntregaTiendaResultItemDto = mock(
        PtrVentaOnlineEntregaTiendaResultItemDto.class);
    ptVentaOnlineEntregaTiendaResponseDto.getVentaOnline().add(ptrVentaOnlineEntregaTiendaResultItemDto);
    final List<TareaLocalizacionPresupuestoVenta> list = new ArrayList<>();

    when(this.tareaLocalizacionPresupuestoVentaRepositoryCustomImpl.save(ArgumentMatchers
        .<List<TareaLocalizacionPresupuestoVenta>>any())).thenReturn(list);

    this.tareaLocalizacionPresupuestoVentaService
        .savePtrVentaOnlineEntregaTiendaResponse(ptVentaOnlineEntregaTiendaResponseDto, localizacion, tarea);

    verify(this.tareaLocalizacionPresupuestoVentaRepositoryCustomImpl, times(1)).save(ArgumentMatchers
        .<List<TareaLocalizacionPresupuestoVenta>>any());
  }

  @Test
  public void savePtrVentaOnlineEntregaDomicilioResponseTest() {
    final TareaDto tarea = mock(TareaDto.class);
    final IdLocalizacionLocalPresupuestoDto localizacion = mock(IdLocalizacionLocalPresupuestoDto.class);
    final PtrVentaOnlineEntregaDomicilioResponseDto ptVentaOnlineEntregaDomicilioResponseDto =
        new PtrVentaOnlineEntregaDomicilioResponseDto();
    ptVentaOnlineEntregaDomicilioResponseDto.setVentaOnline(new ArrayList<>());
    final PtrVentaOnlineEntregaDomicilioResultItemDto ptrVentaOnlineEntregaDomicilioResultItemDto = mock(
        PtrVentaOnlineEntregaDomicilioResultItemDto.class);
    ptVentaOnlineEntregaDomicilioResponseDto.getVentaOnline().add(ptrVentaOnlineEntregaDomicilioResultItemDto);
    final List<TareaLocalizacionPresupuestoVenta> list = new ArrayList<>();

    when(this.tareaLocalizacionPresupuestoVentaRepositoryCustomImpl.save(ArgumentMatchers
        .<List<TareaLocalizacionPresupuestoVenta>>any())).thenReturn(list);

    this.tareaLocalizacionPresupuestoVentaService
        .savePtrVentaOnlineEntregaDomicilioResponse(ptVentaOnlineEntregaDomicilioResponseDto, localizacion, tarea);

    verify(this.tareaLocalizacionPresupuestoVentaRepositoryCustomImpl, times(1)).save(ArgumentMatchers
        .<List<TareaLocalizacionPresupuestoVenta>>any());
  }

}
