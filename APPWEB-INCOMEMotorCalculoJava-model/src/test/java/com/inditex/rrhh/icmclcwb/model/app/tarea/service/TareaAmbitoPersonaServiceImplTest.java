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

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoPersonaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaAmbitoPersonaMapper;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator.TareaAmbitoPersonaMapperDecorator;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaAmbitoPersona;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaAmbitoPersonaRepository;

@RunWith(MockitoJUnitRunner.class)
public class TareaAmbitoPersonaServiceImplTest {

    @Mock
    private TareaAmbitoPersonaRepository tareaAmbitoPersonaRepository;

    @InjectMocks
    private TareaAmbitoPersonaServiceImpl tareaAmbitoPersonaServiceImpl;

    @Mock
    private TareaAmbitoPersonaMapper tareaAmbitoPersonaMapper;

    @Mock
    private TareaAmbitoPersonaMapperDecorator tareaAmbitoPersonaMapperDecorator;

    @Test
    public void createTest() {
        TareaDto tarea = mock(TareaDto.class);
        List<TareaAmbitoPersonaDto> list = new ArrayList<TareaAmbitoPersonaDto>();
        when(tareaAmbitoPersonaRepository.saveAll(any(List.class))).thenReturn(list);

        tareaAmbitoPersonaServiceImpl.create(list, tarea);

        verify(tareaAmbitoPersonaRepository, times(1)).saveAll(any(List.class));
    }

    @Test
    public void findByTarea() {
        TareaDto tarea = mock(TareaDto.class);
        List<TareaAmbitoPersona> list = new ArrayList<TareaAmbitoPersona>();
        when(tareaAmbitoPersonaRepository.findByTareaId(any(Long.class))).thenReturn(list);

        tareaAmbitoPersonaServiceImpl.findByTarea(tarea);

        verify(tareaAmbitoPersonaRepository, times(1)).findByTareaId(any(Long.class));
    }

}
