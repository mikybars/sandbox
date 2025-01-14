package com.inditex.rrhh.icmclcwb.model.ptr.venta.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

import com.inditex.rrhh.icmclcwb.api.ptr.venta.individualdetalle.dto.PtrVentaIndividualDetalleRequestDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.service.PtrVentaEmpleadoService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class PtrVentaEmpleadoAsyncServiceImplTest {
  @Mock
  private PtrVentaEmpleadoService ptrVentaEmpleadoService;

  @InjectMocks
  private PtrVentaEmpleadoAsyncServiceImpl ptrVentaEmpleadoAsyncService;

  @Test
  void ventaIndividualDetalleTest() {
    final PtrVentaIndividualDetalleRequestDto request = new PtrVentaIndividualDetalleRequestDto();
    this.ptrVentaEmpleadoAsyncService.ventaIndividualDetalle(request);

    verify(this.ptrVentaEmpleadoService).ventaIndividualDetalle(any(PtrVentaIndividualDetalleRequestDto.class));
  }

}
