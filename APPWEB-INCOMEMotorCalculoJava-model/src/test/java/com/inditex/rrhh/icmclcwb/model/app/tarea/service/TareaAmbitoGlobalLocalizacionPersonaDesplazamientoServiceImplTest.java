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
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.generic.dto.GenericEmpleadoResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaAmbitoGlobalLocalizacionPersonaDesplazamientoMapper;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator.TareaAmbitoGlobalLocalizacionPersonaDesplazamientoDecorator;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaAmbitoGlobalLocalizacionPersonaDesplazamientoRepositoryCustomImpl;

@RunWith(MockitoJUnitRunner.class)
public class TareaAmbitoGlobalLocalizacionPersonaDesplazamientoServiceImplTest {

    @Mock
    private TareaAmbitoGlobalLocalizacionPersonaDesplazamientoRepositoryCustomImpl tareaAmbitoGlobalLocalizacionPersonaDesplazamientoRepositoryCustomImpl;

    @InjectMocks
    private TareaAmbitoGlobalLocalizacionPersonaDesplazamientoServiceImpl tareaAmbitoGlobalLocalizacionPersonaDesplazamientoServiceImpl;

    @Mock
    private TareaAmbitoGlobalLocalizacionPersonaDesplazamientoMapper tareaAmbitoGlobalLocalizacionPersonaDesplazamientoMapper;

    @Mock
    private TareaAmbitoGlobalLocalizacionPersonaDesplazamientoDecorator tareaAmbitoGlobalLocalizacionPersonaDesplazamientoDecorator;

    @Test
    public void saveTest() {
        TareaDto tarea = mock(TareaDto.class);
        GenericEmpleadoResultItemDto genericEmpleadoResultItemDto = mock(GenericEmpleadoResultItemDto.class);
        List<GenericEmpleadoResultItemDto> list = new ArrayList<GenericEmpleadoResultItemDto>();
        list.add(genericEmpleadoResultItemDto);
        when(tareaAmbitoGlobalLocalizacionPersonaDesplazamientoRepositoryCustomImpl.save(any(List.class)))
            .thenReturn(list);

        tareaAmbitoGlobalLocalizacionPersonaDesplazamientoServiceImpl.save(list, tarea);

        verify(tareaAmbitoGlobalLocalizacionPersonaDesplazamientoRepositoryCustomImpl, times(1)).save(any(List.class));
    }

}
