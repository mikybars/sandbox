package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaConfiguracionChallengeDiasMinimosDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.confchdiasminimos.ConfChDiasMinimosResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaConfiguracionChallengeDiasMinimosMapper;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator.TareaConfiguracionChallengeDiasMinimosDecorator;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaConfiguracionChallengeDiasMinimosRepositoryCustomImpl;

@RunWith(MockitoJUnitRunner.class)
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
        TareaDto tarea = mock(TareaDto.class);
        TareaConfiguracionChallengeDiasMinimosDto tareaConfiguracionChallengeDiasMinimosDto = mock(TareaConfiguracionChallengeDiasMinimosDto.class);
        List<TareaConfiguracionChallengeDiasMinimosDto> list = new ArrayList<TareaConfiguracionChallengeDiasMinimosDto>();
        list.add(tareaConfiguracionChallengeDiasMinimosDto);
        when(tareaConfiguracionChallengeDiasMinimosRepositoryCustomImpl.save(any(List.class))).thenReturn(list);

        tareaConfiguracionChallengeDiasMinimosServiceImpl.save(list, tarea);

        verify(tareaConfiguracionChallengeDiasMinimosRepositoryCustomImpl, times(1)).save(any(List.class));

    }
    
    @Test
    public void saveConfChDiasMinimosResultItemDtoTest() {
        TareaDto tarea = mock(TareaDto.class);
        ConfChDiasMinimosResultItemDto tareaConfiguracionChDiasMinimos = mock(ConfChDiasMinimosResultItemDto.class);
        List<ConfChDiasMinimosResultItemDto> list = new ArrayList<ConfChDiasMinimosResultItemDto>();
        list.add(tareaConfiguracionChDiasMinimos);
        when(tareaConfiguracionChallengeDiasMinimosRepositoryCustomImpl.save(any(List.class))).thenReturn(list);

        tareaConfiguracionChallengeDiasMinimosServiceImpl.saveConfChDiasMinimosResultItemDto(list, tarea);

        verify(tareaConfiguracionChallengeDiasMinimosRepositoryCustomImpl, times(1)).save(any(List.class));

    }
}
