package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericTiendaResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaLocalizacionFestivoMapper;
import com.inditex.rrhh.icmclcwb.model.app.trabajo.service.TrabajoServiceImpl;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaLocalizacionFestivoRepositoryCustom;

@RunWith(MockitoJUnitRunner.class)
public class TareaLocalizacionFestivoServiceImplTest {

    @Mock
    private TareaLocalizacionFestivoRepositoryCustom tareaLocalizacionFestivoRepositoryCustom;
    
    @InjectMocks
    private TareaLocalizacionFestivoServiceImpl tareaLocalizacionFestivoServiceImpl;
    
    @Mock
    private TrabajoServiceImpl trabajoServiceImpl;
    
    @Mock
    private TareaLocalizacionFestivoMapper tareaLocalizacionFestivoMapper;
    
    @Test
    public void saveTest() {
        TareaDto tarea = mock(TareaDto.class);
        tarea.setIdTrabajo(1L);
        List<GenericTiendaResultItemDto> genericTiendaResultItemDto = new ArrayList<>();

        tareaLocalizacionFestivoServiceImpl.save(genericTiendaResultItemDto, tarea);
        verify(tareaLocalizacionFestivoRepositoryCustom, times(1)).save(any(List.class));
    }
}
