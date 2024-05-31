package com.inditex.rrhh.icmclcwb.model.app.tarea.async.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaAmbitoGlobalLocalizacionPersonaService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class TareaAmbitoGlobalLocalizacionPersonaAsyncServiceImplTest {
  @Mock
  private TareaAmbitoGlobalLocalizacionPersonaService tareaLocalizacionPersonaService;

  @InjectMocks
  private TareaAmbitoGlobalLocalizacionPersonaAsyncServiceImpl tareaAmbitoGlobalLocalizacionPersonaAsyncService;

  @Test
  void mergePersonaLocalizacion() {
    final RunTareaDto tarea = new RunTareaDto();

    this.tareaAmbitoGlobalLocalizacionPersonaAsyncService.mergePersonaLocalizacion(tarea);

    verify(this.tareaLocalizacionPersonaService).mergePersonaLocalizacion(any(RunTareaDto.class));
  }
}
