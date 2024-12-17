package com.inditex.rrhh.icmclcwb.model.app.tarea.async.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaLocalizacionPersonaVentaService;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.individualdetalle.dto.PtrVentaIndividualDetalleResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineipodindividualdetalle.dto.PtrVentaOnlineIpodIndividualDetalleResultItemDto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class TareaLocalizacionPersonaVentaAsyncServiceImplTest {
  @Mock
  private TareaLocalizacionPersonaVentaService tareaLocalizacionPersonaVentaService;

  @InjectMocks
  private TareaLocalizacionPersonaVentaAsyncServiceImpl tareaLocalizacionPersonaVentaAsyncService;

  @Test
  void savePtrVentaIndividualDetalleResultItemTest() {
    final List<PtrVentaIndividualDetalleResultItemDto> lista = new ArrayList<>();
    final TareaDto tarea = new TareaDto();

    this.tareaLocalizacionPersonaVentaAsyncService.savePtrVentaIndividualDetalleResultItem(lista, tarea);

    verify(this.tareaLocalizacionPersonaVentaService).savePtrVentaIndividualDetalleResultItem(anyList(), any(TareaDto.class));
  }

  @Test
  void savePtrVentaOnlineIpodIndividualDetalleResultItemTest() {
    final List<PtrVentaOnlineIpodIndividualDetalleResultItemDto> operaciones = new ArrayList<>();
    final TareaDto tarea = new TareaDto();

    this.tareaLocalizacionPersonaVentaAsyncService.savePtrVentaOnlineIpodIndividualDetalleResultItem(operaciones, tarea);

    verify(this.tareaLocalizacionPersonaVentaService).savePtrVentaOnlineIpodIndividualDetalleResultItem(anyList(), any(TareaDto.class));
  }
}
