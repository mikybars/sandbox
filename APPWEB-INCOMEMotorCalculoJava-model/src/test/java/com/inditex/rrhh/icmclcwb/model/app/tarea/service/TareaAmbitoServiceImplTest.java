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

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaAmbitoMapper;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator.TareaAmbitoMapperDecorator;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaAmbito;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaAmbitoRepository;

@RunWith(MockitoJUnitRunner.class)
public class TareaAmbitoServiceImplTest {

    @Mock
    private TareaAmbitoRepository tareaAmbitoRepository;
    
    @InjectMocks
    private TareaAmbitoServiceImpl tareaAmbitoServiceImpl;
    
    @Mock
    private TareaAmbitoMapper tareaAmbitoMapper;
    
    @Mock
    private TareaAmbitoMapperDecorator tareaAmbitoMapperDecorator;
    
    @Test
    public void createTest() {
        TareaDto tarea = mock(TareaDto.class);
        List<TareaAmbitoDto> list = new ArrayList<TareaAmbitoDto>();
        when(tareaAmbitoRepository.saveAll(any(List.class))).thenReturn(list);

        tareaAmbitoServiceImpl.create(list, tarea);

        verify(tareaAmbitoRepository, times(1)).saveAll(any(List.class));
    }
    
    @Test
    public void findByTarea() {
        TareaDto tarea = mock(TareaDto.class);
        List<TareaAmbito> list = new ArrayList<TareaAmbito>();
        when(tareaAmbitoRepository.findByTareaId(any(Long.class))).thenReturn(list);

        tareaAmbitoServiceImpl.findByTarea(tarea);

        verify(tareaAmbitoRepository, times(1)).findByTareaId(any(Long.class));
    }
    
}
