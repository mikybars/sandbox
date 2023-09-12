package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaAmbitoGlobalLocalizacionPersonaRepositoryCustom;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class TareaAmbitoGlobalLocalizacionPersonaServiceImplTest {

  @Mock
  private TareaAmbitoGlobalLocalizacionPersonaRepositoryCustom tareaAmbitoGlobalLocalizacionPersonaRepositoryCustom;

  @InjectMocks
  private TareaAmbitoGlobalLocalizacionPersonaServiceImpl tareaAmbitoGlobalLocalizacionPersonaService;

  @Test
  public void mergePersonaLocalizacionTest() {

    RunTareaDto runTareaDto = mock(RunTareaDto.class);
    tareaAmbitoGlobalLocalizacionPersonaService.mergePersonaLocalizacion(runTareaDto);

    verify(tareaAmbitoGlobalLocalizacionPersonaRepositoryCustom, times(1))
        .mergePersonaLocalizacion(any(RunTareaDto.class));

  }

}
