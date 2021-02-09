package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import java.util.Arrays;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.dto.IdTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaLimpiezaDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaLimpiezaMapper;
import com.inditex.rrhh.icmclcwb.model.app.trabajo.service.TrabajoServiceImpl;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaLimpiezaRepository;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaLimpiezaRepositoryCustom;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TareaLimpiezaServiceImplTest {

    @Mock
    private TareaLimpiezaRepositoryCustom tareaLimpiezaRepositoryCustom;

    @Mock
    private TareaLimpiezaRepository tareaLimpiezaRepository;

    @InjectMocks
    private TareaLimpiezaServiceImpl tareaLimpiezaServiceImpl;

    @Mock
    private TrabajoServiceImpl trabajoServiceImpl;

    @Mock
    private TareaLimpiezaMapper tareaLimpiezaMapper;

    @Test
    public void saveTest() {
        final TareaLimpiezaDto limpieza = mock(TareaLimpiezaDto.class);
        when(limpieza.getNombreUsuario()).thenReturn("username");
        when(limpieza.getIdTarea()).thenReturn(1234L);

        this.tareaLimpiezaServiceImpl.save(limpieza);
        verify(this.tareaLimpiezaRepositoryCustom, times(1)).save(any(TareaLimpiezaDto.class));
        verify(this.tareaLimpiezaRepository, times(1)).findByTareaId(1234L);
    }

    @Test
    public void saveSeveralTest() {

        final List<IdTareaDto> ids = Arrays.asList(IdTareaDto.builder().id(32L).build(),
                IdTareaDto.builder().id(789L).build());
        this.tareaLimpiezaServiceImpl.save(ids);
        verify(this.tareaLimpiezaMapper, times(1)).idTareaDtoToTareaLimpiezaDto(ids);
    }

}
