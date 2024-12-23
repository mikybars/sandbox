package com.inditex.rrhh.icmclcwb.model.ptr.venta.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

import com.inditex.rrhh.icmclcwb.api.ptr.venta.service.PtrVentaGeneralService;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.totalizado.dto.PtrVentaTotalizadoRequestDto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class PtrVentaGeneralAsyncServiceImplTest {
  @Mock
  private PtrVentaGeneralService ptrVentaGeneralService;

  @InjectMocks
  private PtrVentaGeneralAsyncServiceImpl ptrVentaGeneralAsyncService;

  @Test
  void ventaTotalizadoTest() {
    final PtrVentaTotalizadoRequestDto request = new PtrVentaTotalizadoRequestDto();

    this.ptrVentaGeneralAsyncService.ventaTotalizado(request);

    verify(this.ptrVentaGeneralService).ventaTotalizado(any(PtrVentaTotalizadoRequestDto.class));
  }
}
