package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalChallengeDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaCalculoRepositoryCustom;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class TareaCalculoServiceImplTest {

  @Mock
  private TareaCalculoRepositoryCustom tareaCalculoRepositoryCustom;

  @InjectMocks
  private TareaCalculoServiceImpl tareaCalculoServiceImpl;

  @Test
  public void regularizarChallengeTest() {
    RunTareaDto runTarea = new RunTareaDto();
    TareaDto tarea = mock(TareaDto.class);
    runTarea.setTarea(tarea);
    IdPersonaLocalChallengeDto persona = mock(IdPersonaLocalChallengeDto.class);
    tareaCalculoServiceImpl.regularizarChallenge(runTarea, persona);

    verify(tareaCalculoRepositoryCustom, times(1)).regularizarChallenge(any(TareaDto.class),
        any(IdPersonaLocalChallengeDto.class));
  }

}
