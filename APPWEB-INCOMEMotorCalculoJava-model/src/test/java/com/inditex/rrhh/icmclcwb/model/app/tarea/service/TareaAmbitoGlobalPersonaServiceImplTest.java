package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaAmbitoGlobalPersonaRepositoryCustom;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class TareaAmbitoGlobalPersonaServiceImplTest {

  @Mock
  private TareaAmbitoGlobalPersonaRepositoryCustom tareaAmbitoGlobalPersonaRepositoryCustom;

  @InjectMocks
  private TareaAmbitoGlobalPersonaServiceImpl tareaAmbitoGlobalPersonaServiceImpl;

  @Test
  public void mergePersona() {
    RunTareaDto runTareaDto = mock(RunTareaDto.class);
    tareaAmbitoGlobalPersonaServiceImpl.mergePersona(runTareaDto);

    verify(tareaAmbitoGlobalPersonaRepositoryCustom, times(1)).mergePersona(any(RunTareaDto.class));
  }

}
