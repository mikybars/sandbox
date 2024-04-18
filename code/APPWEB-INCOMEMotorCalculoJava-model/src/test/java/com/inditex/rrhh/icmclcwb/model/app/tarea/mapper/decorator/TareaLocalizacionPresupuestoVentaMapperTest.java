package com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator;

import static org.junit.jupiter.api.Assertions.assertThrows;

import com.inditex.rrhh.icmclcwb.api.app.dto.IdLocalizacionLocalPresupuestoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.ventacongelada.dto.VentaCongeladaResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineentregadomicilio.dto.PtrVentaOnlineEntregaDomicilioResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineipod.dto.PtrVentaOnlineIpodResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlinepicking.dto.PtrVentaOnlinePickingResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.totalizado.dto.PtrVentaTotalizadoResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaLocalizacionPresupuestoVentaMapper;

import org.instancio.Instancio;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith({SpringExtension.class})
class TareaLocalizacionPresupuestoVentaMapperTest {

  @InjectMocks
  TareaLocalizacionPresupuestoVentaMapper tareaLocalizacionPresupuestoVentaMapper = this.getClassMock();

  private TareaLocalizacionPresupuestoVentaMapper getClassMock() {
    return Mockito.mock(TareaLocalizacionPresupuestoVentaMapper.class, Mockito.CALLS_REAL_METHODS);
  }

  @Test
  void ventaCongeladaResultItemDtoToTareaLocalizacionPresupuestoVentaExceptionTest() {
    final var ventaCongeladaResultItemDtoList = Instancio.createList(VentaCongeladaResultItemDto.class);
    final var tarea = Instancio.create(TareaDto.class);
    assertThrows(UnsupportedOperationException.class, () -> {
      this.tareaLocalizacionPresupuestoVentaMapper
          .ventaCongeladaResultItemDtoToTareaLocalizacionPresupuestoVenta(ventaCongeladaResultItemDtoList, tarea);
    });
  }

  @Test
  void ventaTotalizadoResponseItemDtoToTareaLocalizacionPresupuestoVentaExceptionTest() {
    final var idLocalizacionLocalPresupuestoDto = Instancio.create(IdLocalizacionLocalPresupuestoDto.class);
    final var ptrVentaTotalizadoResultItemDtoList = Instancio.createList(PtrVentaTotalizadoResultItemDto.class);
    final var tarea = Instancio.create(TareaDto.class);
    assertThrows(UnsupportedOperationException.class, () -> {
      this.tareaLocalizacionPresupuestoVentaMapper
          .ventaTotalizadoResponseItemDtoToTareaLocalizacionPresupuestoVenta(ptrVentaTotalizadoResultItemDtoList,
              idLocalizacionLocalPresupuestoDto, tarea);
    });
  }

  @Test
  void ventaOnlineIpodResponseItemDtoToTareaLocalizacionPresupuestoVentaExceptionTest() {
    final var idLocalizacionLocalPresupuestoDto = Instancio.create(IdLocalizacionLocalPresupuestoDto.class);
    final var ptrVentaOnlineIpodResultItemDtoList = Instancio.createList(PtrVentaOnlineIpodResultItemDto.class);
    final var tarea = Instancio.create(TareaDto.class);
    assertThrows(UnsupportedOperationException.class, () -> {
      this.tareaLocalizacionPresupuestoVentaMapper
          .ventaOnlineIpodResponseItemDtoToTareaLocalizacionPresupuestoVenta(ptrVentaOnlineIpodResultItemDtoList,
              idLocalizacionLocalPresupuestoDto, tarea);
    });
  }

  @Test
  void ventaOnlinePickingResponseItemDtoToTareaLocalizacionPresupuestoVentaExceptionTest() {
    final var idLocalizacionLocalPresupuestoDto = Instancio.create(IdLocalizacionLocalPresupuestoDto.class);
    final var ptrVentaOnlinePickingResultItemDtoList = Instancio.createList(PtrVentaOnlinePickingResultItemDto.class);
    final var tarea = Instancio.create(TareaDto.class);
    assertThrows(UnsupportedOperationException.class, () -> {
      this.tareaLocalizacionPresupuestoVentaMapper
          .ventaOnlinePickingResponseItemDtoToTareaLocalizacionPresupuestoVenta(ptrVentaOnlinePickingResultItemDtoList,
              idLocalizacionLocalPresupuestoDto, tarea);
    });
  }

  @Test
  void ventaOnlineEntregaTiendaResponseItemDtoToTareaLocalizacionPresupuestoVentaExceptionTest() {
    final var idLocalizacionLocalPresupuestoDto = Instancio.create(IdLocalizacionLocalPresupuestoDto.class);
    final var ptrVentaOnlineEntregaDomicilioResultItemDtoList = Instancio.createList(PtrVentaOnlineEntregaDomicilioResultItemDto.class);
    final var tarea = Instancio.create(TareaDto.class);
    assertThrows(UnsupportedOperationException.class, () -> {
      this.tareaLocalizacionPresupuestoVentaMapper
          .ventaOnlineEntregaDomicilioResponseItemDtoToTareaLocalizacionPresupuestoVenta(
              ptrVentaOnlineEntregaDomicilioResultItemDtoList, idLocalizacionLocalPresupuestoDto, tarea);
    });
  }

  @Test
  void ventaOnlineEntregaDomicilioResponseItemDtoToTareaLocalizacionPresupuestoVentaExceptionTest() {
    final var idLocalizacionLocalPresupuestoDto = Instancio.create(IdLocalizacionLocalPresupuestoDto.class);
    final var ptrVentaOnlineEntregaDomicilioResultItemDtoList = Instancio.createList(PtrVentaOnlineEntregaDomicilioResultItemDto.class);
    final var tarea = Instancio.create(TareaDto.class);
    assertThrows(UnsupportedOperationException.class, () -> {
      this.tareaLocalizacionPresupuestoVentaMapper
          .ventaOnlineEntregaDomicilioResponseItemDtoToTareaLocalizacionPresupuestoVenta(
              ptrVentaOnlineEntregaDomicilioResultItemDtoList, idLocalizacionLocalPresupuestoDto, tarea);
    });
  }

}
