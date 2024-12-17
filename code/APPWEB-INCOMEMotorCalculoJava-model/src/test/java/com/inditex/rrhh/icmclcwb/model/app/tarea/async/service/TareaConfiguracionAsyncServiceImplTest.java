package com.inditex.rrhh.icmclcwb.model.app.tarea.async.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaConfiguracionService;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.configuracionorganizacion.ConfiguracionItemDto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class TareaConfiguracionAsyncServiceImplTest {
  @Mock
  private TareaConfiguracionService tareaConfiguracionService;

  @InjectMocks
  private TareaConfiguracionAsyncServiceImpl tareaConfiguracionAsyncService;

  @Test
  void saveConfiguracionItemDtoTest() {
    final List<ConfiguracionItemDto> src = new ArrayList<>();
    final TareaDto tarea = new TareaDto();

    this.tareaConfiguracionAsyncService.saveConfiguracionItemDto(src, tarea);

    verify(this.tareaConfiguracionService).save(anyList(), any(TareaDto.class));
  }

}
