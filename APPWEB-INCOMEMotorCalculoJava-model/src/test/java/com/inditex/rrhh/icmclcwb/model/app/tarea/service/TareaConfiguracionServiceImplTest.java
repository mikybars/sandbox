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
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.configuracionorganizacion.ConfiguracionItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaConfiguracionMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaConfiguracionRepositoryCustom;

@RunWith(MockitoJUnitRunner.class)
public class TareaConfiguracionServiceImplTest {

    @Mock
    private TareaConfiguracionRepositoryCustom tareaConfiguracionRepositoryCustom;

    @InjectMocks
    private TareaConfiguracionServiceImpl tareaConfiguracionServiceImpl;

    @Mock
    private TareaConfiguracionMapper tareaConfiguracionMapper;

    @Test
    public void saveTest() {
        TareaDto tarea = mock(TareaDto.class);
        ConfiguracionItemDto configuracionItemDto = mock(ConfiguracionItemDto.class);
        List<ConfiguracionItemDto> list = new ArrayList<ConfiguracionItemDto>();
        list.add(configuracionItemDto);
        when(tareaConfiguracionRepositoryCustom.save(any(List.class))).thenReturn(list);

        tareaConfiguracionServiceImpl.save(list, tarea);

        verify(tareaConfiguracionRepositoryCustom, times(1)).save(any(List.class));
    }

}
