package com.inditex.rrhh.icmclcwb.model.app.tarea.async.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalChallengeDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaCalculoService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class TareaCalculoAsyncServiceImplTest {
  @Mock
  private TareaCalculoService tareaCalculoService;

  @InjectMocks
  private TareaCalculoAsyncServiceImpl tareaCalculoAsyncService;

  @Test
  void regularizarChallengeTest() {
    final RunTareaDto runTareaDto = new RunTareaDto();
    final IdPersonaLocalChallengeDto id = new IdPersonaLocalChallengeDto();

    this.tareaCalculoAsyncService.regularizarChallenge(runTareaDto, id);

    verify(this.tareaCalculoService).regularizarChallenge(any(RunTareaDto.class), any(IdPersonaLocalChallengeDto.class));
  }

}
