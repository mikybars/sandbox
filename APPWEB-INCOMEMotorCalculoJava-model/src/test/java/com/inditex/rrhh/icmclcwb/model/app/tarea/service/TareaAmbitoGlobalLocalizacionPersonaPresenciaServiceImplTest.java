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
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.empleadotienda.dto.PtrPresenciaEmpleadosTiendaResponseDto;
import com.inditex.rrhh.icmclcwb.api.ptr.presencia.empleadotienda.dto.PtrPresenciaEmpleadosTiendaResultItemDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaAmbitoGlobalLocalizacionPersonaPresenciaMapper;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.decorator.TareaAmbitoGlobalLocalizacionPersonaPresenciaDecorator;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaAmbitoGlobalLocalizacionPersonaPresenciaRepositoryCustomImpl;

@RunWith(MockitoJUnitRunner.class)
public class TareaAmbitoGlobalLocalizacionPersonaPresenciaServiceImplTest {

    @Mock
    private TareaAmbitoGlobalLocalizacionPersonaPresenciaRepositoryCustomImpl tareaAmbitoGlobalLocalizacionPersonaPresenciaRepositoryCustomImpl;

    @InjectMocks
    private TareaAmbitoGlobalLocalizacionPersonaPresenciaServiceImpl tareaAmbitoGlobalLocalizacionPersonaPresenciaServiceImpl;

    @Mock
    private TareaAmbitoGlobalLocalizacionPersonaPresenciaMapper tareaAmbitoGlobalLocalizacionPersonaPresenciaMapper;

    @Mock
    private TareaAmbitoGlobalLocalizacionPersonaPresenciaDecorator tareaAmbitoGlobalLocalizacionPersonaPresenciaDecorator;

    @Test
    public void saveTest() {
        TareaDto tarea = mock(TareaDto.class);
        PtrPresenciaEmpleadosTiendaResponseDto ptrPresenciaEmpleadosTiendaResponseDto = mock(
                PtrPresenciaEmpleadosTiendaResponseDto.class);
        PtrPresenciaEmpleadosTiendaResultItemDto ptrPresenciaEmpleadosTiendaResultItemDto = mock(
                PtrPresenciaEmpleadosTiendaResultItemDto.class);
        ptrPresenciaEmpleadosTiendaResponseDto.setPresenciasTiendasEmpleado(new ArrayList<>());
        ptrPresenciaEmpleadosTiendaResponseDto.getPresenciasTiendasEmpleado()
            .add(ptrPresenciaEmpleadosTiendaResultItemDto);

        tareaAmbitoGlobalLocalizacionPersonaPresenciaServiceImpl.save(ptrPresenciaEmpleadosTiendaResponseDto, tarea);

        verify(tareaAmbitoGlobalLocalizacionPersonaPresenciaRepositoryCustomImpl, times(1)).save(any(List.class));
    }

}
