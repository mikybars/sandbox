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
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaPersonaEstructuraDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.estructurascom.dto.EstructurasComResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaPersonaEstructuraMapper;
import com.inditex.rrhh.icmclcwb.model.app.trabajo.service.TrabajoServiceImpl;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaPersonaEstructuraRepositoryCustom;

@RunWith(MockitoJUnitRunner.class)
public class TareaPersonaEstructuraServiceImplTest {

    @Mock
    private TareaPersonaEstructuraRepositoryCustom tareaPersonaEstructuraRepositoryCustom;
    
    @InjectMocks
    private TareaPersonaEstructuraServiceImpl tareaPersonaEstructuraServiceImpl;
    
    @Mock
    private TareaPersonaEstructuraMapper tareaPersonaEstructuraMapper;
    
    @Mock
    private TrabajoServiceImpl trabajoServiceImpl;
    
    @Test
    public void saveTest() {
        TareaDto tarea = mock(TareaDto.class);
        tarea.setIdTrabajo(1L);
        List<TareaPersonaEstructuraDto> estructuras = new ArrayList<>();

        tareaPersonaEstructuraServiceImpl.save(estructuras, tarea);
        verify(tareaPersonaEstructuraRepositoryCustom, times(1)).save(any(List.class));
    }
    
    @Test
    public void mergeEstructurasComResultItemDtoTest() {
        TareaDto tarea = mock(TareaDto.class);
        tarea.setIdTrabajo(1L);
        List<EstructurasComResultItemDto> estructuras = new ArrayList<>();

        tareaPersonaEstructuraServiceImpl.mergeEstructurasComResultItemDto(estructuras, tarea);
        verify(tareaPersonaEstructuraMapper, times(1)).estructurasComResultItemDtoAndTareaDtoToTareaPersonaEstructuraDto(any(List.class), any(TareaDto.class));
    }
    
    @Test
    public void findPersonasChallengeTest() {
        TareaDto tarea = mock(TareaDto.class);
        tarea.setIdTrabajo(1L);

        tareaPersonaEstructuraServiceImpl.findPersonasChallenge(tarea);
        verify(tareaPersonaEstructuraRepositoryCustom, times(1)).findPersonasChallenge(any(TareaDto.class));
    }
}
