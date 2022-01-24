package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.individualdetalle.dto.PtrVentaIndividualDetalleResultItemDto;
import com.inditex.rrhh.icmclcwb.api.ptr.venta.onlineipodindividualdetalle.dto.PtrVentaOnlineIpodIndividualDetalleResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaLocalizacionPersonaVentaMapper;
import com.inditex.rrhh.icmclcwb.model.app.trabajo.service.TrabajoServiceImpl;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaLocalizacionPersonaVenta;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaLocalizacionPersonaVentaRepositoryCustom;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class TareaLocalizacionPersonaVentaServiceImplTest {

  @Mock
  private TareaLocalizacionPersonaVentaRepositoryCustom tareaLocalizacionPersonaVentaRepositoryCustom;

  @InjectMocks
  private TareaLocalizacionPersonaVentaServiceImpl tareaLocalizacionPersonaVentaServiceImpl;

  @Mock
  private TrabajoServiceImpl trabajoServiceImpl;

  @Mock
  private TareaLocalizacionPersonaVentaMapper tareaLocalizacionPersonaVentaMapper;

  @Test
  public void savePtrVentaIndividualDetalleResultItemTest() {
    final TareaDto tarea = mock(TareaDto.class);
    tarea.setIdTrabajo(1L);
    final List<PtrVentaIndividualDetalleResultItemDto> ventaIndividual = new ArrayList<>();

    this.tareaLocalizacionPersonaVentaServiceImpl.savePtrVentaIndividualDetalleResultItem(ventaIndividual, tarea);

    verify(this.tareaLocalizacionPersonaVentaMapper, times(1))
        .ptrVentaIndividualDetalleResultItemDtoToTareaLocalizacionPersonaVenta(
            ArgumentMatchers.<List<PtrVentaIndividualDetalleResultItemDto>>any(),
            any(TareaDto.class));
    verify(this.tareaLocalizacionPersonaVentaRepositoryCustom, times(1))
        .save(ArgumentMatchers.<List<TareaLocalizacionPersonaVenta>>any());
  }

  @Test
  public void savePtrVentaOnlineIpodIndividualDetalleResultItemTest() {
    final TareaDto tarea = mock(TareaDto.class);
    tarea.setIdTrabajo(1L);
    final List<PtrVentaOnlineIpodIndividualDetalleResultItemDto> ventaOnlineIpod = new ArrayList<>();

    this.tareaLocalizacionPersonaVentaServiceImpl.savePtrVentaOnlineIpodIndividualDetalleResultItem(ventaOnlineIpod,
        tarea);

    verify(this.tareaLocalizacionPersonaVentaMapper, times(1))
        .ptrVentaOnlineIpodIndividualDetalleResultItemDtoToTareaLocalizacionPersonaVenta(
            ArgumentMatchers.<List<PtrVentaOnlineIpodIndividualDetalleResultItemDto>>any(),
            any(TareaDto.class));
    verify(this.tareaLocalizacionPersonaVentaRepositoryCustom, times(1))
        .save(ArgumentMatchers.<List<TareaLocalizacionPersonaVenta>>any());
  }

}
