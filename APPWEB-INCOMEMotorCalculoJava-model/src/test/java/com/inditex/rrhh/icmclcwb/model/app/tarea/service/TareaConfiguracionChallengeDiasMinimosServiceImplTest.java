package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaConfiguracionChallengeDiasMinimosDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.confchdiasminimos.ConfChDiasMinimosResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaConfiguracionChallengeDiasMinimosMapper;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator.TareaConfiguracionChallengeDiasMinimosDecorator;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaConfiguracionChallengeDiasMinimos;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaConfiguracionChallengeDiasMinimosRepositoryCustomImpl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class TareaConfiguracionChallengeDiasMinimosServiceImplTest {

  @Mock
  private TareaConfiguracionChallengeDiasMinimosRepositoryCustomImpl tareaConfiguracionChallengeDiasMinimosRepositoryCustomImpl;

  @InjectMocks
  private TareaConfiguracionChallengeDiasMinimosServiceImpl tareaConfiguracionChallengeDiasMinimosServiceImpl;

  @Mock
  private TareaConfiguracionChallengeDiasMinimosMapper tareaConfiguracionChallengeDiasMinimosMapper;

  @Mock
  private TareaConfiguracionChallengeDiasMinimosDecorator tareaConfiguracionChallengeDiasMinimosDecorator;

  @Test
  public void saveTest() {
    final TareaDto tarea = mock(TareaDto.class);
    final TareaConfiguracionChallengeDiasMinimosDto tareaConfiguracionChallengeDiasMinimosDto = mock(
        TareaConfiguracionChallengeDiasMinimosDto.class);
    final List<TareaConfiguracionChallengeDiasMinimosDto> dtoList = new ArrayList<TareaConfiguracionChallengeDiasMinimosDto>();
    final List<TareaConfiguracionChallengeDiasMinimos> list = new ArrayList<TareaConfiguracionChallengeDiasMinimos>();
    dtoList.add(tareaConfiguracionChallengeDiasMinimosDto);
    when(this.tareaConfiguracionChallengeDiasMinimosRepositoryCustomImpl
        .save(ArgumentMatchers.<List<TareaConfiguracionChallengeDiasMinimos>>any())).thenReturn(list);

    this.tareaConfiguracionChallengeDiasMinimosServiceImpl.save(dtoList, tarea);

    verify(this.tareaConfiguracionChallengeDiasMinimosRepositoryCustomImpl, times(1))
        .save(ArgumentMatchers.<List<TareaConfiguracionChallengeDiasMinimos>>any());

  }

  @Test
  public void saveConfChDiasMinimosResultItemDtoTest() {
    final TareaDto tarea = mock(TareaDto.class);
    final ConfChDiasMinimosResultItemDto tareaConfiguracionChDiasMinimos = mock(
        ConfChDiasMinimosResultItemDto.class);
    final List<ConfChDiasMinimosResultItemDto> dtoList = new ArrayList<ConfChDiasMinimosResultItemDto>();
    final List<TareaConfiguracionChallengeDiasMinimos> list = new ArrayList<TareaConfiguracionChallengeDiasMinimos>();
    dtoList.add(tareaConfiguracionChDiasMinimos);
    when(this.tareaConfiguracionChallengeDiasMinimosRepositoryCustomImpl
        .save(ArgumentMatchers.<List<TareaConfiguracionChallengeDiasMinimos>>any())).thenReturn(list);

    this.tareaConfiguracionChallengeDiasMinimosServiceImpl.saveConfChDiasMinimosResultItemDto(dtoList, tarea);

    verify(this.tareaConfiguracionChallengeDiasMinimosRepositoryCustomImpl, times(1))
        .save(ArgumentMatchers.<List<TareaConfiguracionChallengeDiasMinimos>>any());

  }

}
