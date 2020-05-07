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

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaConfiguracionPrecioHoraDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.confpreciohora.dto.ConfPrecioHoraResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaConfiguracionPrecioHoraMapper;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator.TareaConfiguracionPrecioHoraDecorator;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaConfiguracionPrecioHoraRepositoryCustomImpl;

@RunWith(MockitoJUnitRunner.class)
public class TareaConfiguracionPrecioHoraServiceImplTest {

    @Mock
    private TareaConfiguracionPrecioHoraRepositoryCustomImpl tareaConfiguracionPrecioHoraRepositoryCustomImpl;

    @InjectMocks
    private TareaConfiguracionPrecioHoraServiceImpl tareaLocalizacionPresupuestoService;

    @Mock
    private TareaConfiguracionPrecioHoraMapper tareaConfiguracionPrecioHoraMapper;

    @Mock
    private TareaConfiguracionPrecioHoraDecorator tareaConfiguracionPrecioHoraDecorator;

    @Test
    public void saveTest() {
        TareaDto tarea = mock(TareaDto.class);
        TareaConfiguracionPrecioHoraDto tareaConfiguracionPrecioHora = mock(TareaConfiguracionPrecioHoraDto.class);
        List<TareaConfiguracionPrecioHoraDto> list = new ArrayList<TareaConfiguracionPrecioHoraDto>();
        list.add(tareaConfiguracionPrecioHora);
        when(tareaConfiguracionPrecioHoraRepositoryCustomImpl.save(any(List.class))).thenReturn(list);

        tareaLocalizacionPresupuestoService.save(list, tarea);

        verify(tareaConfiguracionPrecioHoraRepositoryCustomImpl, times(1)).save(any(List.class));

    }

    @Test
    public void saveConfPrecioHoraResultItemDtoTest() {
        TareaDto tarea = mock(TareaDto.class);
        ConfPrecioHoraResultItemDto tareaConfiguracionPrecioHora = mock(ConfPrecioHoraResultItemDto.class);
        List<ConfPrecioHoraResultItemDto> list = new ArrayList<ConfPrecioHoraResultItemDto>();
        list.add(tareaConfiguracionPrecioHora);
        when(tareaConfiguracionPrecioHoraRepositoryCustomImpl.save(any(List.class))).thenReturn(list);

        tareaLocalizacionPresupuestoService.saveConfPrecioHoraResultItemDto(list, tarea);

        verify(tareaConfiguracionPrecioHoraRepositoryCustomImpl, times(1)).save(any(List.class));

    }

}
