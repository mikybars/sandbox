package com.inditex.rrhh.icmclcwb.model.ptr.venta.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineentregadomicilio.dto.PtrVentaOnlineEntregaDomicilioRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineentregatienda.dto.PtrVentaOnlineEntregaTiendaRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineipod.dto.PtrVentaOnlineIpodRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineipodindividualdetalle.dto.PtrVentaOnlineIpodIndividualDetalleRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlinepicking.dto.PtrVentaOnlinePickingRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.service.PtrVentaEcommerceService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class PtrVentaEcommerceAsyncServiceImplTest {
  @Mock
  private PtrVentaEcommerceService ptrVentaEcommerceService;

  @InjectMocks
  private PtrVentaEcommerceAsyncServiceImpl ptrVentaEcommerceAsyncService;

  @Test
  void ventaOnlineEntregaDomicilioTest() {
    final PtrVentaOnlineEntregaDomicilioRequestDto request = new PtrVentaOnlineEntregaDomicilioRequestDto();

    this.ptrVentaEcommerceAsyncService.ventaOnlineEntregaDomicilio(request);

    verify(this.ptrVentaEcommerceService).ventaOnlineEntregaDomicilio(any(PtrVentaOnlineEntregaDomicilioRequestDto.class));
  }

  @Test
  void ventaOnlineEntregaTiendaTest() {
    final PtrVentaOnlineEntregaTiendaRequestDto request = new PtrVentaOnlineEntregaTiendaRequestDto();

    this.ptrVentaEcommerceAsyncService.ventaOnlineEntregaTienda(request);

    verify(this.ptrVentaEcommerceService).ventaOnlineEntregaTienda(any(PtrVentaOnlineEntregaTiendaRequestDto.class));
  }

  @Test
  void ventaOnlineiPodTest() {
    final PtrVentaOnlineIpodRequestDto request = new PtrVentaOnlineIpodRequestDto();

    this.ptrVentaEcommerceAsyncService.ventaOnlineiPod(request);

    verify(this.ptrVentaEcommerceService).ventaOnlineiPod(any(PtrVentaOnlineIpodRequestDto.class));
  }

  @Test
  void ventaOnlineiPodIndividualDetalleTest() {
    final PtrVentaOnlineIpodIndividualDetalleRequestDto request = new PtrVentaOnlineIpodIndividualDetalleRequestDto();

    this.ptrVentaEcommerceAsyncService.ventaOnlineiPodIndividualDetalle(request);

    verify(this.ptrVentaEcommerceService).ventaOnlineiPodIndividualDetalle(any(PtrVentaOnlineIpodIndividualDetalleRequestDto.class));
  }

  @Test
  void ventaOnlinePickingTest() {
    final PtrVentaOnlinePickingRequestDto request = new PtrVentaOnlinePickingRequestDto();

    this.ptrVentaEcommerceAsyncService.ventaOnlinePicking(request);

    verify(this.ptrVentaEcommerceService).ventaOnlinePicking(any(PtrVentaOnlinePickingRequestDto.class));
  }
}
