package com.inditex.rrhh.icmclcwb.model.app.periodo.service;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.model.primary.periodo.repository.PeriodoLocalizacionPersonaRepositoryCustom;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class PeriodoLocalizacionPersonaServiceImplTest {

    @Mock
    PeriodoLocalizacionPersonaRepositoryCustom periodoLocalizacionPersonaRepositoryCustom;

    @InjectMocks
    PeriodoLocalizacionPersonaServiceImpl periodoLocalizacionPersonaService;

    @Test
    public void mergePeriodoLocalizacionPersonaTest() {

        RunTareaDto runTarea = mock(RunTareaDto.class);
        periodoLocalizacionPersonaService.mergePeriodoLocalizacionPersona(runTarea);

        verify(periodoLocalizacionPersonaRepositoryCustom, times(1)).mergePeriodoLocalizacionPersona(runTarea);

    }

}
