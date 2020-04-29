package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaLimpiezaMapper;
import com.inditex.rrhh.icmclcwb.model.app.trabajo.service.TrabajoServiceImpl;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaLimpiezaRepositoryCustom;

@RunWith(MockitoJUnitRunner.class)
public class TareaLimpiezaServiceImplTest {

    @Mock
    private TareaLimpiezaRepositoryCustom tareaLimpiezaRepositoryCustom;
    
    @InjectMocks
    private TareaLimpiezaServiceImpl tareaLimpiezaServiceImpl;
    
    @Mock
    private TrabajoServiceImpl trabajoServiceImpl;
    
    @Mock
    private TareaLimpiezaMapper tareaLimpiezaMapper;
    
    @Test
    public void saveTest() {
        TareaDto tarea = mock(TareaDto.class);
        tarea.setIdTrabajo(1L);
        TrabajoDto trabajo = mock(TrabajoDto.class);
        when(tarea.getIdTrabajo()).thenReturn(1L);
        when(trabajoServiceImpl.find(any(Long.class))).thenReturn(trabajo);

        tareaLimpiezaServiceImpl.save(tarea);
        verify(tareaLimpiezaRepositoryCustom, times(1)).mergeLimpieza(any(TareaDto.class), any(TrabajoDto.class));
    }
}
