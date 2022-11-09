package com.inditex.rrhh.icmclcwb.model.primary.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.List;

import com.inditex.aqsw.framework.test.randomizer.Random;
import com.inditex.aqsw.framework.test.randomizer.RandomizerExtension;
import com.inditex.rrhh.icmclcwb.api.app.calcular.service.TipoDatoService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.TipoDatoEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaLocalizacionVentaDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.ventamanualwloc.dto.VentaManualWlocResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineentregatienda.dto.PtrVentaOnlineEntregaTiendaResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineipod.dto.PtrVentaOnlineIpodResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlinepicking.dto.PtrVentaOnlinePickingResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.totalizado.dto.PtrVentaTotalizadoResponseDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaLocalizacionVentaMapper;
import com.inditex.rrhh.icmclcwb.model.primary.repository.PrimaryTemporaryTableVentasMonacoRepositoryCustom;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLocalizacionVenta;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith({SpringExtension.class, RandomizerExtension.class})
public class PrimaryVentasMonacoAsyncServiceImplTest {

  @Mock
  private TareaLocalizacionVentaMapper tareaLocalizacionVentaMapper;

  @Mock
  private PrimaryTemporaryTableVentasMonacoRepositoryCustom primaryTemporaryTableVentasMonacoRepositoryCustom;

  @Mock
  private TipoDatoService tipoDatoService;

  @InjectMocks
  private PrimaryVentasMonacoAsyncServiceImpl ventasMonacoAsyncService;

  @Test
  void createTempMonacoPtrTest() {
    this.ventasMonacoAsyncService.createTempMonacoPtr();

    verify(this.primaryTemporaryTableVentasMonacoRepositoryCustom, times(1))
        .createTempMonacoPtr();
  }

  @Test
  void deleteTempMonacoPtrTest() {
    this.ventasMonacoAsyncService.deleteTempMonacoPtr();

    verify(this.primaryTemporaryTableVentasMonacoRepositoryCustom, times(1))
        .deleteTempMonacoPtr();
  }

  @Test
  void mergeIntoTareaLocalizacionVentaTest() {
    this.ventasMonacoAsyncService.mergeIntoTareaLocalizacionVenta(Mockito.mock(TareaDto.class));

    verify(this.primaryTemporaryTableVentasMonacoRepositoryCustom, times(1))
        .mergeIntoTareaLocalizacionVenta(any(TareaDto.class));
  }

  @Test
  void saveTest(
      @Random(size = 1, type = VentaManualWlocResultItemDto.class) final List<VentaManualWlocResultItemDto> src,
      @Random final TareaDto tareaDto,
      @Random(size = 1, type = TareaLocalizacionVenta.class) final List<TareaLocalizacionVenta> tareaLocVenta) {

    doReturn(tareaLocVenta).when(this.tareaLocalizacionVentaMapper)
        .genericTiendaResultItemDtoToTareaLocalizacionVenta(src, tareaDto);

    this.ventasMonacoAsyncService.save(src, tareaDto);

    verify(this.primaryTemporaryTableVentasMonacoRepositoryCustom, times(1))
        .insertTempMonacoPtr(tareaLocVenta);
  }

  @Test
  void savePtrVentaTotalizadoResponseTest(
      @Random final PtrVentaTotalizadoResponseDto dto,
      @Random final TareaDto tarea,
      @Random(size = 1, type = TareaLocalizacionVenta.class) final List<TareaLocalizacionVenta> tareaLocVentaList,
      @Random(size = 1, type = TareaLocalizacionVentaDto.class) final List<TareaLocalizacionVentaDto> tareaLocVentaDto) {

    doReturn(tareaLocVentaList).when(this.tareaLocalizacionVentaMapper).ventaTotalizadoResponseItemDtoToTareaLocalizacionVenta(
        dto.getVentaTotalizado(),
        tarea, TipoDatoEnum.VENTA_FISICA_LOCALIZACION_SECCION.getId(),
        TipoDatoEnum.VENTA_FISICA_LOCALIZACION.getId());
    doReturn(tareaLocVentaDto).when(this.tareaLocalizacionVentaMapper).tareaLocalizacionVentaToTareaLocalizacionVentaDto(tareaLocVentaList);

    this.ventasMonacoAsyncService.savePtrVentaTotalizadoResponse(dto, tarea);

    verify(this.primaryTemporaryTableVentasMonacoRepositoryCustom, times(1))
        .insertTempMonacoPtr(tareaLocVentaList);
  }

  @Test
  void savePtrVentaOnlineIpodResponseTest(
      @Random final PtrVentaOnlineIpodResponseDto dto,
      @Random final TareaDto tarea,
      @Random(size = 1, type = TareaLocalizacionVenta.class) final List<TareaLocalizacionVenta> tareaLocVentaList,
      @Random(size = 1, type = TareaLocalizacionVentaDto.class) final List<TareaLocalizacionVentaDto> tareaLocVentaDto) {

    doReturn(tareaLocVentaList).when(this.tareaLocalizacionVentaMapper).ventaOnlineIpodResponseItemDtoToTareaLocalizacionVenta(
        dto.getVentaOnline(),
        tarea, TipoDatoEnum.VENTA_ONLINE_IPOD_LOCALIZACION_SECCION.getId(),
        TipoDatoEnum.VENTA_ONLINE_IPOD_LOCALIZACION.getId());
    doReturn(tareaLocVentaDto).when(this.tareaLocalizacionVentaMapper).tareaLocalizacionVentaToTareaLocalizacionVentaDto(tareaLocVentaList);

    this.ventasMonacoAsyncService.savePtrVentaOnlineIpodResponse(dto, tarea);

    verify(this.primaryTemporaryTableVentasMonacoRepositoryCustom, times(1))
        .insertTempMonacoPtr(tareaLocVentaList);

  }

  @Test
  void savePtrVentaOnlinePickingResponseTest(
      @Random final PtrVentaOnlinePickingResponseDto dto,
      @Random final TareaDto tarea,
      @Random(size = 1, type = TareaLocalizacionVenta.class) final List<TareaLocalizacionVenta> tareaLocVentaList,
      @Random(size = 1, type = TareaLocalizacionVentaDto.class) final List<TareaLocalizacionVentaDto> tareaLocVentaDto) {

    doReturn(tareaLocVentaList).when(this.tareaLocalizacionVentaMapper).ventaOnlinePickingResponseItemDtoToTareaLocalizacionVenta(
        dto.getVentaOnline(),
        tarea, TipoDatoEnum.VENTA_ONLINE_SINT_LOCALIZACION_SECCION.getId(),
        TipoDatoEnum.VENTA_ONLINE_SINT_LOCALIZACION.getId());
    doReturn(tareaLocVentaDto).when(this.tareaLocalizacionVentaMapper).tareaLocalizacionVentaToTareaLocalizacionVentaDto(tareaLocVentaList);

    this.ventasMonacoAsyncService.savePtrVentaOnlinePickingResponse(dto, tarea);

    verify(this.primaryTemporaryTableVentasMonacoRepositoryCustom, times(1))
        .insertTempMonacoPtr(tareaLocVentaList);

  }

  @Test
  void savePtrVentaOnlineEntregaTiendaResponseTest(
      @Random final PtrVentaOnlineEntregaTiendaResponseDto dto,
      @Random final TareaDto tarea,
      @Random(size = 1, type = TareaLocalizacionVenta.class) final List<TareaLocalizacionVenta> tareaLocVentaList,
      @Random(size = 1, type = TareaLocalizacionVentaDto.class) final List<TareaLocalizacionVentaDto> tareaLocVentaDto) {

    doReturn(tareaLocVentaList).when(this.tareaLocalizacionVentaMapper).ventaOnlineEntregaTiendaResponseItemDtoToTareaLocalizacionVenta(
        dto.getVentaOnline(),
        tarea, TipoDatoEnum.VENTA_ONLINE_ENTREGATIENDA_LOCALIZACION_SECCION.getId(),
        TipoDatoEnum.VENTA_ONLINE_ENTREGATIENDA_LOCALIZACION.getId());
    doReturn(tareaLocVentaDto).when(this.tareaLocalizacionVentaMapper).tareaLocalizacionVentaToTareaLocalizacionVentaDto(tareaLocVentaList);

    this.ventasMonacoAsyncService.savePtrVentaOnlineEntregaTiendaResponse(dto, tarea);

    verify(this.primaryTemporaryTableVentasMonacoRepositoryCustom, times(1))
        .insertTempMonacoPtr(tareaLocVentaList);

  }

  @Test
  void savePtrVentaTotalizadoResponseRepartoOnlineTest(
      @Random final PtrVentaTotalizadoResponseDto dto,
      @Random final TareaDto tarea,
      @Random(size = 1, type = TareaLocalizacionVenta.class) final List<TareaLocalizacionVenta> tareaLocVentaList,
      @Random(size = 1, type = TareaLocalizacionVentaDto.class) final List<TareaLocalizacionVentaDto> tareaLocVentaDto) {

    doReturn(tareaLocVentaList).when(this.tareaLocalizacionVentaMapper).ventaTotalizadoResponseItemDtoToTareaLocalizacionVenta(
        dto.getVentaTotalizado(),
        tarea, TipoDatoEnum.VENTA_FISICA_LOCALIZACION_REPARTO_ONLINE.getId());
    doReturn(tareaLocVentaDto).when(this.tareaLocalizacionVentaMapper).tareaLocalizacionVentaToTareaLocalizacionVentaDto(tareaLocVentaList);

    this.ventasMonacoAsyncService.savePtrVentaTotalizadoResponseRepartoOnline(dto, tarea);

    verify(this.primaryTemporaryTableVentasMonacoRepositoryCustom, times(1))
        .insertTempMonacoPtr(tareaLocVentaList);

  }

}
