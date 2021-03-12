package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import java.util.ArrayList;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoPersonaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaAmbitoPersonaMapper;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator.TareaAmbitoPersonaMapperDecorator;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaAmbitoPersona;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaAmbitoPersonaRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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
        final TareaDto tarea = mock(TareaDto.class);
        final List<TareaAmbitoPersona> list = new ArrayList<TareaAmbitoPersona>();
        final List<TareaAmbitoPersonaDto> dtoList = new ArrayList<TareaAmbitoPersonaDto>();
        when(this.tareaAmbitoPersonaRepository.saveAll(ArgumentMatchers.<List<TareaAmbitoPersona>>any()))
            .thenReturn(list);

        this.tareaAmbitoPersonaServiceImpl.create(dtoList, tarea);

        verify(this.tareaAmbitoPersonaRepository, times(1)).saveAll(ArgumentMatchers.<List<TareaAmbitoPersona>>any());
    }

    @Test
    public void findByTarea() {
        final TareaDto tarea = mock(TareaDto.class);
        final List<TareaAmbitoPersona> list = new ArrayList<TareaAmbitoPersona>();
        when(this.tareaAmbitoPersonaRepository.findByTareaId(any(Long.class))).thenReturn(list);

        this.tareaAmbitoPersonaServiceImpl.findByTarea(tarea);

        verify(this.tareaAmbitoPersonaRepository, times(1)).findByTareaId(any(Long.class));
    }

}
