package com.inditex.rrhh.icmclcwb.model.app.tarea.async.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaLocalizacionCalcularService;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericTiendaResultItemDto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class TareaLocalizacionCalcularAsyncServiceImplTest {
  @Mock
  private TareaLocalizacionCalcularService tareaLocalizacionCalcularService;

  @InjectMocks
  private TareaLocalizacionCalcularAsyncServiceImpl tareaLocalizacionCalcularAsyncService;

  @Test
  void saveTest() {
    final List<GenericTiendaResultItemDto> src = new ArrayList<>();
    final TareaDto tareaDto = new TareaDto();
    this.tareaLocalizacionCalcularAsyncService.save(src, tareaDto);

    verify(this.tareaLocalizacionCalcularService).save(anyList(), any(TareaDto.class));
  }

}
