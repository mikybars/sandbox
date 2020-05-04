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

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoLocalizacionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaAmbitoLocalizacionMapper;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator.TareaAmbitoLocalizacionMapperDecorator;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaAmbitoLocalizacion;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaAmbitoLocalizacionRepository;

@RunWith(MockitoJUnitRunner.class)
public class TareaAmbitoLocalizacionServiceImplTest {

    @Mock
    private TareaAmbitoLocalizacionRepository tareaAmbitoLocalizacionRepository;

    @InjectMocks
    private TareaAmbitoLocalizacionServiceImpl tareaAmbitoLocalizacionServiceImpl;

    @Mock
    private TareaAmbitoLocalizacionMapper tareaAmbitoLocalizacionMapper;

    @Mock
    private TareaAmbitoLocalizacionMapperDecorator tareaAmbitoLocalizacionMapperDecorator;

    @Test
    public void createTest() {
        TareaDto tarea = mock(TareaDto.class);
        List<TareaAmbitoLocalizacionDto> list = new ArrayList<TareaAmbitoLocalizacionDto>();
        when(tareaAmbitoLocalizacionRepository.saveAll(any(List.class))).thenReturn(list);

        tareaAmbitoLocalizacionServiceImpl.create(list, tarea);

        verify(tareaAmbitoLocalizacionRepository, times(1)).saveAll(any(List.class));
    }

    @Test
    public void findByTarea() {
        TareaDto tarea = mock(TareaDto.class);
        List<TareaAmbitoLocalizacion> list = new ArrayList<TareaAmbitoLocalizacion>();
        when(tareaAmbitoLocalizacionRepository.findByTareaId(any(Long.class))).thenReturn(list);

        tareaAmbitoLocalizacionServiceImpl.findByTarea(tarea);

        verify(tareaAmbitoLocalizacionRepository, times(1)).findByTareaId(any(Long.class));
    }

}
