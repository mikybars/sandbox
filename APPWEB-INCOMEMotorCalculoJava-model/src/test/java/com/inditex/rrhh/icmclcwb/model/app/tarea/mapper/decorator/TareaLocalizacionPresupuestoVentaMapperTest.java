package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import com.inditex.aqsw.framework.test.randomizer.Random;
import com.inditex.aqsw.framework.test.randomizer.RandomizerExtension;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdLocalizacionLocalPresupuestoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.ventacongelada.dto.VentaCongeladaResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineentregadomicilio.dto.PtrVentaOnlineEntregaDomicilioResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineentregatienda.dto.PtrVentaOnlineEntregaTiendaResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineipod.dto.PtrVentaOnlineIpodResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlinepicking.dto.PtrVentaOnlinePickingResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.totalizado.dto.PtrVentaTotalizadoResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaLocalizacionPresupuestoVentaMapper;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith({SpringExtension.class, RandomizerExtension.class})
class TareaLocalizacionPresupuestoVentaMapperTest {

  @InjectMocks
  TareaLocalizacionPresupuestoVentaMapper tareaLocalizacionPresupuestoVentaMapper = getClassMock();

  @Random(type = VentaCongeladaResultItemDto.class, size = 2)
  List<VentaCongeladaResultItemDto> ventaCongeladaResultItemDtoList;

  @Random
  TareaDto tarea;

  @Random(type = PtrVentaTotalizadoResultItemDto.class, size = 2)
  List<PtrVentaTotalizadoResultItemDto> ptrVentaTotalizadoResultItemDtoList;

  @Random
  IdLocalizacionLocalPresupuestoDto idLocalizacionLocalPresupuestoDto;

  @Random(type = PtrVentaOnlineIpodResultItemDto.class, size = 2)
  List<PtrVentaOnlineIpodResultItemDto> PtrVentaOnlineIpodResultItemDtoList;

  @Random(type = PtrVentaOnlinePickingResultItemDto.class, size = 2)
  List<PtrVentaOnlinePickingResultItemDto> ptrVentaOnlinePickingResultItemDtoList;

  @Random(type = PtrVentaOnlineEntregaTiendaResultItemDto.class, size = 2)
  List<PtrVentaOnlineEntregaTiendaResultItemDto> ptrVentaOnlineEntregaTiendaResultItemDtoList;

  @Random(type = PtrVentaOnlineEntregaDomicilioResultItemDto.class, size = 2)
  List<PtrVentaOnlineEntregaDomicilioResultItemDto> ptrVentaOnlineEntregaDomicilioResultItemDtoList;

  private TareaLocalizacionPresupuestoVentaMapper getClassMock() {
    return Mockito.mock(TareaLocalizacionPresupuestoVentaMapper.class, Mockito.CALLS_REAL_METHODS);
  }

  @Test
  void ventaCongeladaResultItemDtoToTareaLocalizacionPresupuestoVentaExceptionTest() {
    assertThrows(UnsupportedOperationException.class, () -> {
      this.tareaLocalizacionPresupuestoVentaMapper
          .ventaCongeladaResultItemDtoToTareaLocalizacionPresupuestoVenta(this.ventaCongeladaResultItemDtoList, this.tarea);
    });
  }

  @Test
  void ventaTotalizadoResponseItemDtoToTareaLocalizacionPresupuestoVentaExceptionTest() {
    assertThrows(UnsupportedOperationException.class, () -> {
      this.tareaLocalizacionPresupuestoVentaMapper
          .ventaTotalizadoResponseItemDtoToTareaLocalizacionPresupuestoVenta(this.ptrVentaTotalizadoResultItemDtoList,
              this.idLocalizacionLocalPresupuestoDto, this.tarea);
    });
  }

  @Test
  void ventaOnlineIpodResponseItemDtoToTareaLocalizacionPresupuestoVentaExceptionTest() {
    assertThrows(UnsupportedOperationException.class, () -> {
      this.tareaLocalizacionPresupuestoVentaMapper
          .ventaOnlineIpodResponseItemDtoToTareaLocalizacionPresupuestoVenta(this.PtrVentaOnlineIpodResultItemDtoList,
              this.idLocalizacionLocalPresupuestoDto, this.tarea);
    });
  }

  @Test
  void ventaOnlinePickingResponseItemDtoToTareaLocalizacionPresupuestoVentaExceptionTest() {
    assertThrows(UnsupportedOperationException.class, () -> {
      this.tareaLocalizacionPresupuestoVentaMapper
          .ventaOnlinePickingResponseItemDtoToTareaLocalizacionPresupuestoVenta(this.ptrVentaOnlinePickingResultItemDtoList,
              this.idLocalizacionLocalPresupuestoDto, this.tarea);
    });
  }

  @Test
  void ventaOnlineEntregaTiendaResponseItemDtoToTareaLocalizacionPresupuestoVentaExceptionTest() {
    assertThrows(UnsupportedOperationException.class, () -> {
      this.tareaLocalizacionPresupuestoVentaMapper
          .ventaOnlineEntregaDomicilioResponseItemDtoToTareaLocalizacionPresupuestoVenta(
              this.ptrVentaOnlineEntregaDomicilioResultItemDtoList, this.idLocalizacionLocalPresupuestoDto, this.tarea);
    });
  }

  @Test
  void ventaOnlineEntregaDomicilioResponseItemDtoToTareaLocalizacionPresupuestoVentaExceptionTest() {
    assertThrows(UnsupportedOperationException.class, () -> {
      this.tareaLocalizacionPresupuestoVentaMapper
          .ventaOnlineEntregaDomicilioResponseItemDtoToTareaLocalizacionPresupuestoVenta(
              this.ptrVentaOnlineEntregaDomicilioResultItemDtoList, this.idLocalizacionLocalPresupuestoDto, this.tarea);
    });
  }

}
