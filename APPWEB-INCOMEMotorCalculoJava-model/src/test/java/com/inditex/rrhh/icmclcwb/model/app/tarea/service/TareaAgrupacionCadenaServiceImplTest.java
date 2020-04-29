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

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.agruponline.dto.AgrupOnlineResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaAgrupacionCadenaMapper;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator.TareaAgrupacionCadenaMapperDecorator;
import com.inditex.rrhh.icmclcwb.model.primary.calcular.entity.TareaAgrupacionCadena;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaAgrupacionCadenaRepository;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaAgrupacionCadenaRepositoryCustomImpl;

@RunWith(MockitoJUnitRunner.class)
public class TareaAgrupacionCadenaServiceImplTest {

    @Mock
    private TareaAgrupacionCadenaRepositoryCustomImpl tareaAgrupacionCadenaRepositoryCustomImpl;
    
    @Mock
    private TareaAgrupacionCadenaRepository tareaAgrupacionCadenaRepository;

    @InjectMocks
    private TareaAgrupacionCadenaServiceImpl tareaAgrupacionCadenaServiceImpl;
    
    @Mock
    private TareaAgrupacionCadenaMapper tareaAgrupacionCadenaMapper;
    
    @Mock
    private TareaAgrupacionCadenaMapperDecorator tareaAgrupacionCadenaMapperDecorator;
    
    @Test
    public void saveTest() {
        TareaDto tarea = mock(TareaDto.class);
        AgrupOnlineResultItemDto agrupOnlineResultItemDto = mock(AgrupOnlineResultItemDto.class);
        List<AgrupOnlineResultItemDto> list = new ArrayList<AgrupOnlineResultItemDto>();
        list.add(agrupOnlineResultItemDto);
        when(tareaAgrupacionCadenaRepositoryCustomImpl.save(any(List.class))).thenReturn(list);

        tareaAgrupacionCadenaServiceImpl.save(list, tarea);

        verify(tareaAgrupacionCadenaRepositoryCustomImpl, times(1)).save(any(List.class));
    }
    
    @Test
    public void findAgrupacionesByTarea() {
        TareaDto tarea = mock(TareaDto.class);
        List<TareaAgrupacionCadena> agrupaciones = new ArrayList<>();
        when(tareaAgrupacionCadenaRepository.findByTareaId(any(Long.class))).thenReturn(agrupaciones);

        tareaAgrupacionCadenaServiceImpl.findAgrupacionesByTarea(tarea);

        verify(tareaAgrupacionCadenaRepository, times(1)).findByTareaId(any(Long.class));
    }
    
}
