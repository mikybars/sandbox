package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.TipoVentaConceptoEnum;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdTipoDatoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoDatoEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaLocalizacionVentaDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.ventamanualwloc.dto.VentaManualWlocResultItemDto;
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
import com.inditex.rrhh.icmclcwb.model.app.calcular.service.TipoDatoServiceImpl;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaLocalizacionVentaMapper;
import com.inditex.rrhh.icmclcwb.model.app.trabajo.service.TrabajoServiceImpl;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLocalizacionVenta;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaLocalizacionVentaRepositoryCustom;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class TareaLocalizacionVentaServiceImplTest {

  @Mock
  private TareaLocalizacionVentaRepositoryCustom tareaLocalizacionVentaRepositoryCustom;

  @InjectMocks
  private TareaLocalizacionVentaServiceImpl tareaLocalizacionVentaServiceImpl;

  @Mock
  private TareaLocalizacionVentaMapper tareaLocalizacionVentaMapper;

  @Mock
  private TrabajoServiceImpl trabajoServiceImpl;

  @Mock
  private TipoDatoServiceImpl tipoDatoServiceImpl;

  @Test
  public void savePtrVentaTotalizadoResponseTest() {
    final TareaDto tarea = mock(TareaDto.class);
    tarea.setIdTrabajo(1L);
    final PtrVentaTotalizadoResponseDto ventaTotalizado = new PtrVentaTotalizadoResponseDto();
    ventaTotalizado.setVentaTotalizado(new ArrayList<PtrVentaTotalizadoResultItemDto>());
    ventaTotalizado.getVentaTotalizado().add(new PtrVentaTotalizadoResultItemDto());
    this.tareaLocalizacionVentaServiceImpl.savePtrVentaTotalizadoResponse(ventaTotalizado, tarea);

    verify(this.tareaLocalizacionVentaRepositoryCustom, times(1)).save(ArgumentMatchers
        .any());
  }

  @Test
  public void savePtrVentaOnlineIpodResponseTest() {
    final TareaDto tarea = mock(TareaDto.class);
    tarea.setIdTrabajo(1L);
    final PtrVentaOnlineIpodResponseDto ventaOnline = new PtrVentaOnlineIpodResponseDto();
    ventaOnline.setVentaOnline(new ArrayList<PtrVentaOnlineIpodResultItemDto>());
    ventaOnline.getVentaOnline().add(new PtrVentaOnlineIpodResultItemDto());

    this.tareaLocalizacionVentaServiceImpl.savePtrVentaOnlineIpodResponse(ventaOnline, tarea);

    verify(this.tareaLocalizacionVentaRepositoryCustom, times(1)).save(ArgumentMatchers
        .any());
  }

  @Test
  public void savePtrVentaOnlinePickingResponseTest() {
    final TareaDto tarea = mock(TareaDto.class);
    tarea.setIdTrabajo(1L);
    final PtrVentaOnlinePickingResponseDto ventaOnline = new PtrVentaOnlinePickingResponseDto();
    ventaOnline.setVentaOnline(new ArrayList<PtrVentaOnlinePickingResultItemDto>());
    ventaOnline.getVentaOnline().add(new PtrVentaOnlinePickingResultItemDto());

    this.tareaLocalizacionVentaServiceImpl.savePtrVentaOnlinePickingResponse(ventaOnline, tarea);

    verify(this.tareaLocalizacionVentaRepositoryCustom, times(1)).save(ArgumentMatchers
        .any());
  }

  @Test
  public void savePtrVentaOnlineEntregaTiendaResponseTest() {
    final TareaDto tarea = mock(TareaDto.class);
    tarea.setIdTrabajo(1L);
    final PtrVentaOnlineEntregaTiendaResponseDto ventaOnline = new PtrVentaOnlineEntregaTiendaResponseDto();
    ventaOnline.setVentaOnline(new ArrayList<PtrVentaOnlineEntregaTiendaResultItemDto>());
    ventaOnline.getVentaOnline().add(new PtrVentaOnlineEntregaTiendaResultItemDto());

    this.tareaLocalizacionVentaServiceImpl.savePtrVentaOnlineEntregaTiendaResponse(ventaOnline, tarea);

    verify(this.tareaLocalizacionVentaRepositoryCustom, times(1)).save(ArgumentMatchers
        .any());
  }

  @Test
  public void savePtrVentaOnlineEntregaDomicilioResponseTest() {
    final TareaDto tarea = mock(TareaDto.class);
    tarea.setIdTrabajo(1L);
    final PtrVentaOnlineEntregaDomicilioResponseDto ventaOnline = new PtrVentaOnlineEntregaDomicilioResponseDto();
    ventaOnline.setVentaOnline(new ArrayList<PtrVentaOnlineEntregaDomicilioResultItemDto>());
    ventaOnline.getVentaOnline().add(new PtrVentaOnlineEntregaDomicilioResultItemDto());

    this.tareaLocalizacionVentaServiceImpl.savePtrVentaOnlineEntregaDomicilioResponse(ventaOnline, tarea);

    verify(this.tareaLocalizacionVentaRepositoryCustom, times(1)).save(ArgumentMatchers
        .any());
  }

  @Test
  public void updateActivoVentaOnlineIpodTest() {
    final TareaDto tarea = mock(TareaDto.class);
    tarea.setIdTrabajo(1L);
    final PtrVentaOnlineEntregaDomicilioResponseDto ventaOnline = new PtrVentaOnlineEntregaDomicilioResponseDto();
    ventaOnline.setVentaOnline(new ArrayList<PtrVentaOnlineEntregaDomicilioResultItemDto>());
    ventaOnline.getVentaOnline().add(new PtrVentaOnlineEntregaDomicilioResultItemDto());
    when(this.tipoDatoServiceImpl.findTipoDatoByTipoGrupoDato(any(Integer.class)))
        .thenReturn(new ArrayList<IdTipoDatoDto>());

    this.tareaLocalizacionVentaServiceImpl.updateActivoVentaOnlineIpod(tarea);

    verify(this.tareaLocalizacionVentaRepositoryCustom, times(1)).updateActivo(any(TareaDto.class),
        any(TipoVentaConceptoEnum.class), ArgumentMatchers.any());
  }

  @Test
  public void saveTest() {
    final TareaDto tarea = mock(TareaDto.class);
    tarea.setIdTrabajo(1L);
    final VentaManualWlocResultItemDto ventaTotalizado = new VentaManualWlocResultItemDto();
    this.tareaLocalizacionVentaServiceImpl.save(List.of(ventaTotalizado), tarea);

    verify(this.tareaLocalizacionVentaRepositoryCustom, times(1)).save(ArgumentMatchers
        .any());
  }

  @Test
  void savePtrVentaTotalizadoResponseRepartoOnlineEmptyResultTest() {
    final PtrVentaTotalizadoResponseDto response = PtrVentaTotalizadoResponseDto
        .builder()
        .ventaTotalizado(new ArrayList<>())
        .build();
    final TareaDto tarea = new TareaDto();
    this.tareaLocalizacionVentaServiceImpl.savePtrVentaTotalizadoResponseRepartoOnline(response, tarea);
    verify(this.tareaLocalizacionVentaRepositoryCustom, times(0)).save(ArgumentMatchers
        .any());

  }

  @Test
  void savePtrVentaTotalizadoResponseRepartoOnlineNullTest() {
    final PtrVentaTotalizadoResponseDto response = new PtrVentaTotalizadoResponseDto();
    final TareaDto tarea = new TareaDto();
    this.tareaLocalizacionVentaServiceImpl.savePtrVentaTotalizadoResponseRepartoOnline(response, tarea);
    verify(this.tareaLocalizacionVentaRepositoryCustom, times(0)).save(ArgumentMatchers
        .any());

  }

  @Test
  void savePtrVentaTotalizadoResponseRepartoSaveTest() {
    final List<PtrVentaTotalizadoResultItemDto> ventaTotalizado = Collections
        .singletonList(new PtrVentaTotalizadoResultItemDto());
    final PtrVentaTotalizadoResponseDto response = PtrVentaTotalizadoResponseDto
        .builder()
        .ventaTotalizado(ventaTotalizado)
        .build();
    final TareaDto tarea = new TareaDto();
    tarea.setId(12345L);

    final List<TareaLocalizacionVenta> tareaLocalizacionVentaFromMapper = Collections
        .singletonList(new TareaLocalizacionVenta());
    when(this.tareaLocalizacionVentaMapper.ventaTotalizadoResponseItemDtoToTareaLocalizacionVenta(ArgumentMatchers
        .any(), any(TareaDto.class), any(Integer.class)))
            .thenReturn(tareaLocalizacionVentaFromMapper);
    final List<TareaLocalizacionVenta> tareaLocalizacionVentaFromSave = Collections
        .singletonList(new TareaLocalizacionVenta());
    when(this.tareaLocalizacionVentaRepositoryCustom.save(ArgumentMatchers.any()))
        .thenReturn(tareaLocalizacionVentaFromSave);
    final List<TareaLocalizacionVentaDto> tareaLocalizacionVentaDtoFromMapper = Collections
        .singletonList(new TareaLocalizacionVentaDto());
    when(this.tareaLocalizacionVentaMapper
        .tareaLocalizacionVentaToTareaLocalizacionVentaDto(ArgumentMatchers.<List<TareaLocalizacionVenta>>any()))
            .thenReturn(tareaLocalizacionVentaDtoFromMapper);

    final List<TareaLocalizacionVentaDto> result = this.tareaLocalizacionVentaServiceImpl
        .savePtrVentaTotalizadoResponseRepartoOnline(response, tarea);

    verify(this.tareaLocalizacionVentaMapper, times(1)).ventaTotalizadoResponseItemDtoToTareaLocalizacionVenta(
        ventaTotalizado, tarea,
        TipoDatoEnum.VENTA_FISICA_LOCALIZACION_REPARTO_ONLINE.getId());
    verify(this.tareaLocalizacionVentaRepositoryCustom, times(1)).save(tareaLocalizacionVentaFromMapper);
    verify(this.tareaLocalizacionVentaMapper, times(1))
        .tareaLocalizacionVentaToTareaLocalizacionVentaDto(tareaLocalizacionVentaFromSave);

    assertEquals(tareaLocalizacionVentaDtoFromMapper, result);

  }

}
