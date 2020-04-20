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
import com.inditex.rrhh.icmclcwb.model.app.calcular.service.TipoDatoServiceImpl;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaLocalizacionCalcularMapper;
import com.inditex.rrhh.icmclcwb.model.app.trabajo.service.TrabajoServiceImpl;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaLocalizacionCalcularRepositoryCustom;

@RunWith(MockitoJUnitRunner.class)
public class TareaLocalizacionCalcularServiceImplTest {

    @Mock
    private TareaLocalizacionCalcularRepositoryCustom tareaLocalizacionCalcularRepositoryCustom;
    
    @InjectMocks
    private TareaLocalizacionCalcularServiceImpl tareaLocalizacionCalcularServiceImpl;
    
    @Mock
    private TrabajoServiceImpl trabajoServiceImpl;
    
    @Mock
    private TipoDatoServiceImpl tipoDatoService;
    
    @Mock
    private TareaLocalizacionCalcularMapper tareaLocalizacionCalcularMapper;
    
    @Test
    public void saveCerradoTest() {
        TareaDto tarea = mock(TareaDto.class);
        tarea.setIdTrabajo(1L);
        List<GenericTiendaResultItemDto> genericTiendaResultItemDto = new ArrayList<>();

        tareaLocalizacionCalcularServiceImpl.save(genericTiendaResultItemDto, tarea);
        verify(tareaLocalizacionCalcularRepositoryCustom, times(1)).save(any(List.class));
    }
}
