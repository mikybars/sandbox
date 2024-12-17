package com.inditex.rrhh.icmclcwb.model.app.tarea.async.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaConfiguracionPrecioHoraDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaConfiguracionPrecioHoraService;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.confpreciohora.dto.ConfPrecioHoraResultItemDto;

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
  void saveConfPrecioHoraResultItemDtoTest() {
    final List<ConfPrecioHoraResultItemDto> src = new ArrayList<>();
    final TareaDto tarea = new TareaDto();

    this.tareaConfiguracionPrecioHoraAsyncService.saveConfPrecioHoraResultItemDto(src, tarea);

    verify(this.tareaConfiguracionPrecioHoraService).saveConfPrecioHoraResultItemDto(anyList(), any(TareaDto.class));
  }
}
