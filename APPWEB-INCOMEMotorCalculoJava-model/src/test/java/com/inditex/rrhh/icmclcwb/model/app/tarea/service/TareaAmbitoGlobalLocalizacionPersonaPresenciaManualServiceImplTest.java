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
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaAmbitoGlobalLocalizacionPersonaPresenciaManualMapper;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator.TareaAmbitoGlobalLocalizacionPersonaPresenciaManualDecorator;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaAmbitoGlobalLocalizacionPersonaPresenciaManualRepositoryCustomImpl;

@RunWith(MockitoJUnitRunner.class)
public class TareaAmbitoGlobalLocalizacionPersonaPresenciaManualServiceImplTest {

    @Mock
    private TareaAmbitoGlobalLocalizacionPersonaPresenciaManualRepositoryCustomImpl tareaAmbitoGlobalLocalizacionPersonaPresenciaManualRepositoryCustomImpl;

    @InjectMocks
    private TareaAmbitoGlobalLocalizacionPersonaPresenciaManualServiceImpl tareaAmbitoGlobalLocalizacionPersonaPresenciaManualServiceImpl;

    @Mock
    private TareaAmbitoGlobalLocalizacionPersonaPresenciaManualMapper tareaAmbitoGlobalLocalizacionPersonaPresenciaManualMapper;

    @Mock
    private TareaAmbitoGlobalLocalizacionPersonaPresenciaManualDecorator tareaAmbitoGlobalLocalizacionPersonaPresenciaManualDecorator;

    @Test
    public void saveTest() {
        TareaDto tarea = mock(TareaDto.class);
        GenericEmpleadoResultItemDto genericEmpleadoResultItemDto = mock(GenericEmpleadoResultItemDto.class);
        List<GenericEmpleadoResultItemDto> list = new ArrayList<GenericEmpleadoResultItemDto>();
        list.add(genericEmpleadoResultItemDto);
        when(tareaAmbitoGlobalLocalizacionPersonaPresenciaManualRepositoryCustomImpl.save(any(List.class)))
            .thenReturn(list);

        tareaAmbitoGlobalLocalizacionPersonaPresenciaManualServiceImpl.save(list, tarea);

        verify(tareaAmbitoGlobalLocalizacionPersonaPresenciaManualRepositoryCustomImpl, times(1)).save(any(List.class));
    }

}
