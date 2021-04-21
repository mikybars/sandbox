package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaAmbitoGlobalPersonaRepositoryCustom;

@RunWith(MockitoJUnitRunner.class)
public class TareaAmbitoGlobalPersonaServiceImplTest {

    @Mock
    private TareaAmbitoGlobalPersonaRepositoryCustom tareaAmbitoGlobalPersonaRepositoryCustom;

    @InjectMocks
    private TareaAmbitoGlobalPersonaServiceImpl tareaAmbitoGlobalPersonaServiceImpl;

    @Test
    public void mergePersona() {
        RunTareaDto runTareaDto = mock(RunTareaDto.class);
        tareaAmbitoGlobalPersonaServiceImpl.mergePersona(runTareaDto);

        verify(tareaAmbitoGlobalPersonaRepositoryCustom, times(1)).mergePersona(any(RunTareaDto.class));
    }

}
