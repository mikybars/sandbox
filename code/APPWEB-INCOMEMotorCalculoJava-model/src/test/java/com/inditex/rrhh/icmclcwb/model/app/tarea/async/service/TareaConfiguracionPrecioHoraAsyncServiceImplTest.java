package com.inditex.rrhh.icmclcwb.model.app.tarea.async.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaConfiguracionPrecioHoraDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaConfiguracionPrecioHoraService;
import com.inditex.rrhh.icmclcwb.rest.client.dto.ConfiguracionPrecioHoraResponseDTO;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class TareaConfiguracionPrecioHoraAsyncServiceImplTest {
  @Mock
  private TareaConfiguracionPrecioHoraService tareaConfiguracionPrecioHoraService;

  @InjectMocks
  private TareaConfiguracionPrecioHoraAsyncServiceImpl tareaConfiguracionPrecioHoraAsyncService;

  @Test
  void saveTest() {
    final List<TareaConfiguracionPrecioHoraDto> src = new ArrayList<>();
    final TareaDto tarea = new TareaDto();

    this.tareaConfiguracionPrecioHoraAsyncService.save(src, tarea);

    verify(this.tareaConfiguracionPrecioHoraService).save(anyList(), any(TareaDto.class));
  }

  @Test
  void saveConfiguracionPrecioHoraResponseDTOTest() {
    final List<ConfiguracionPrecioHoraResponseDTO> src = new ArrayList<>();
    final TareaDto tarea = new TareaDto();
    final String cclIdOrigen = "1";

    this.tareaConfiguracionPrecioHoraAsyncService.saveConfiguracionPrecioHoraResponseDTO(src, tarea, cclIdOrigen);

    verify(this.tareaConfiguracionPrecioHoraService).saveConfiguracionPrecioHoraResponseDTO(anyList(), any(TareaDto.class), anyString());
  }
}
