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

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAgrupacionConfiguracionChallengeTipoVentaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.confchtpventa.ConfChTpVentaResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaAgrupacionConfiguracionChallengeTipoVentaMapper;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator.TareaAgrupacionConfiguracionChallengeTipoVentaDecorator;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaAgrupacionConfiguracionChallengeTipoVentaRepositoryCustomImpl;

@RunWith(MockitoJUnitRunner.class)
public class TareaAgrupacionConfiguracionChallengeTipoVentaServiceImplTest {

    @Mock
    private TareaAgrupacionConfiguracionChallengeTipoVentaRepositoryCustomImpl tareaAgrupacionConfiguracionChallengeTipoVentaRepositoryCustomImpl;

    @InjectMocks
    private TareaAgrupacionConfiguracionChallengeTipoVentaServiceImpl tareaAgrupacionConfiguracionChallengeTipoVentaServiceImpl;

    @Mock
    private TareaAgrupacionConfiguracionChallengeTipoVentaMapper tareaAgrupacionConfiguracionChallengeTipoVentaMapper;

    @Mock
    private TareaAgrupacionConfiguracionChallengeTipoVentaDecorator tareaAgrupacionConfiguracionChallengeTipoVentaDecorator;

    @Test
    public void saveTest() {
        TareaDto tarea = mock(TareaDto.class);
        TareaAgrupacionConfiguracionChallengeTipoVentaDto tareaAgrupacionConfiguracionChallengeTipoVentaDto = mock(
                TareaAgrupacionConfiguracionChallengeTipoVentaDto.class);
        List<TareaAgrupacionConfiguracionChallengeTipoVentaDto> list = new ArrayList<TareaAgrupacionConfiguracionChallengeTipoVentaDto>();
        list.add(tareaAgrupacionConfiguracionChallengeTipoVentaDto);
        when(tareaAgrupacionConfiguracionChallengeTipoVentaRepositoryCustomImpl.save(any(List.class))).thenReturn(list);

        tareaAgrupacionConfiguracionChallengeTipoVentaServiceImpl.save(list, tarea);

        verify(tareaAgrupacionConfiguracionChallengeTipoVentaRepositoryCustomImpl, times(1)).save(any(List.class));
    }

    @Test
    public void saveConfChTpVentaResultItemDtoTest() {
        TareaDto tarea = mock(TareaDto.class);
        ConfChTpVentaResultItemDto confChTpVentaResultItemDto = mock(ConfChTpVentaResultItemDto.class);
        List<ConfChTpVentaResultItemDto> list = new ArrayList<ConfChTpVentaResultItemDto>();
        list.add(confChTpVentaResultItemDto);
        when(tareaAgrupacionConfiguracionChallengeTipoVentaRepositoryCustomImpl.save(any(List.class))).thenReturn(list);

        tareaAgrupacionConfiguracionChallengeTipoVentaServiceImpl.saveConfChTpVentaResultItemDto(list, tarea);

        verify(tareaAgrupacionConfiguracionChallengeTipoVentaRepositoryCustomImpl, times(1)).save(any(List.class));
    }

}
