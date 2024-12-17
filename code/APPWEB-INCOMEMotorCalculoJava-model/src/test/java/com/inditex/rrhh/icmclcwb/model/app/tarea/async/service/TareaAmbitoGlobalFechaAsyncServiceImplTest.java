package com.inditex.rrhh.icmclcwb.model.app.tarea.async.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoGlobalFechaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaAmbitoGlobalFechaService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class TareaAmbitoGlobalFechaAsyncServiceImplTest {
  @Mock
  private TareaAmbitoGlobalFechaService tareaAmbitoGlobalFechaService;

  @InjectMocks
  private TareaAmbitoGlobalFechaAsyncServiceImpl tareaAmbitoGlobalFechaAsyncService;

  @Test
  void saveTest() {
    final TareaAmbitoGlobalFechaDto src = new TareaAmbitoGlobalFechaDto();
    final TareaDto tarea = new TareaDto();

    this.tareaAmbitoGlobalFechaAsyncService.save(src, tarea);

    verify(this.tareaAmbitoGlobalFechaService).save(any(TareaAmbitoGlobalFechaDto.class), any(TareaDto.class));
  }

}
