package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaAmbitoGlobalLocalizacionPersonaRepositoryCustom;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class TareaAmbitoGlobalLocalizacionPersonaServiceImplTest {

    @Mock
    private TareaAmbitoGlobalLocalizacionPersonaRepositoryCustom tareaAmbitoGlobalLocalizacionPersonaRepositoryCustom;

    @InjectMocks
    private TareaAmbitoGlobalLocalizacionPersonaServiceImpl tareaAmbitoGlobalLocalizacionPersonaService;

    @Test
    public void mergePersonaLocalizacionTest() {

        RunTareaDto runTareaDto = mock(RunTareaDto.class);
        tareaAmbitoGlobalLocalizacionPersonaService.mergePersonaLocalizacion(runTareaDto);

        verify(tareaAmbitoGlobalLocalizacionPersonaRepositoryCustom, times(1))
            .mergePersonaLocalizacion(any(RunTareaDto.class));

    }

}
