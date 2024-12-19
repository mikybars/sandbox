package com.inditex.rrhh.icmclcwb.model.app.tarea.async.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaAmbitoGlobalPersonaService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class TareaAmbitoGlobalPersonaAsyncServiceImplTest {
  @Mock
  private TareaAmbitoGlobalPersonaService tareaAmbitoGlobalPersonaService;

  @InjectMocks
  private TareaAmbitoGlobalPersonaAsyncServiceImpl tareaAmbitoGlobalPersonaAsyncService;

  @Test
  void mergePersonaTest() {
    final RunTareaDto runTareaDto = new RunTareaDto();

    this.tareaAmbitoGlobalPersonaAsyncService.mergePersona(runTareaDto);

    verify(this.tareaAmbitoGlobalPersonaService).mergePersona(any(RunTareaDto.class));
  }

}
