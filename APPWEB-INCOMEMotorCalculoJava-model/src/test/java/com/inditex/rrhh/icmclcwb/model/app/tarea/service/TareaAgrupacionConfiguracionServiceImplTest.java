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

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.configuracionventaonline.dto.ConfiguracionVentaOnlineResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaAgrupacionConfiguracionMapper;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator.TareaAgrupacionAgrupacionConfiguracionDecorator;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaAgrupacionConfiguracionRepositoryCustomImpl;

@RunWith(MockitoJUnitRunner.class)
public class TareaAgrupacionConfiguracionServiceImplTest {

    @Mock
    private TareaAgrupacionConfiguracionRepositoryCustomImpl tareaAgrupacionConfiguracionRepositoryCustomImpl;

    @InjectMocks
    private TareaAgrupacionConfiguracionServiceImpl tareaAgrupacionConfiguracionServiceImpl;

    @Mock
    private TareaAgrupacionConfiguracionMapper tareaAgrupacionConfiguracionMapper;

    @Mock
    private TareaAgrupacionAgrupacionConfiguracionDecorator tareaAgrupacionConfiguracionMapperDecorator;

    @Test
    public void saveConfiguracionVentaOnlineTest() {
        RunTareaDto runTarea = mock(RunTareaDto.class);
        ConfiguracionVentaOnlineResultItemDto configuracionVentaOnlineResultItemDto = mock(
                ConfiguracionVentaOnlineResultItemDto.class);
        List<ConfiguracionVentaOnlineResultItemDto> list = new ArrayList<ConfiguracionVentaOnlineResultItemDto>();
        list.add(configuracionVentaOnlineResultItemDto);
        when(tareaAgrupacionConfiguracionRepositoryCustomImpl.save(any(List.class))).thenReturn(list);

        tareaAgrupacionConfiguracionServiceImpl.saveConfiguracionVentaOnline(list, runTarea);

        verify(tareaAgrupacionConfiguracionRepositoryCustomImpl, times(1)).save(any(List.class));
    }

}
