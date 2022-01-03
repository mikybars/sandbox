package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaAmbitoGlobalLocalizacionRepositoryCustom;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class TareaAmbitoGlobalLocalizacionServiceImplTest {

  @Mock
  private TareaAmbitoGlobalLocalizacionRepositoryCustom tareaAmbitoGlobalLocalizacionRepositoryCustom;

  @InjectMocks
  private TareaAmbitoGlobalLocalizacionServiceImpl tareaAmbitoGlobalLocalizacionServiceImpl;

  @Test
  public void mergeLocalizacion() {
    RunTareaDto runTareaDto = mock(RunTareaDto.class);
    tareaAmbitoGlobalLocalizacionServiceImpl.mergeLocalizacion(runTareaDto);

    verify(tareaAmbitoGlobalLocalizacionRepositoryCustom, times(1)).mergeLocalizacion(any(RunTareaDto.class));
  }

}
