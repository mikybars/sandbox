package com.inditex.rrhh.icmclcwb.model.app.tarea.async.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaConfiguracionChallengeDiasMinimosDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaConfiguracionChallengeDiasMinimosService;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.confchdiasminimos.ConfChDiasMinimosResultItemDto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class TareaConfiguracionChallengeDiasMinimosAsyncServiceImplTest {
  @Mock
  private TareaConfiguracionChallengeDiasMinimosService tareaConfiguracionChallengeDiasMinimosService;

  @InjectMocks
  private TareaConfiguracionChallengeDiasMinimosAsyncServiceImpl tareaConfiguracionChallengeDiasMinimosAsyncService;

  @Test
  void saveTest() {
    final List<TareaConfiguracionChallengeDiasMinimosDto> src = new ArrayList<>();
    final TareaDto tarea = new TareaDto();

    this.tareaConfiguracionChallengeDiasMinimosAsyncService.save(src, tarea);

    verify(this.tareaConfiguracionChallengeDiasMinimosService).save(anyList(), any(TareaDto.class));
  }

  @Test
  void saveConfChDiasMinimosResultItemDtoTest() {
    final List<ConfChDiasMinimosResultItemDto> src = new ArrayList<>();
    final TareaDto tarea = new TareaDto();

    this.tareaConfiguracionChallengeDiasMinimosAsyncService.saveConfChDiasMinimosResultItemDto(src, tarea);

    verify(this.tareaConfiguracionChallengeDiasMinimosService).saveConfChDiasMinimosResultItemDto(anyList(), any(TareaDto.class));
  }
}
