package com.inditex.rrhh.icmclcwb.model.app.periodo.service;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.model.primary.periodo.repository.PeriodoPersonaRepositoryCustom;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class PeriodoPersonaServiceImplTest {

    @Mock
    PeriodoPersonaRepositoryCustom periodoPersonaRepositoryCustom;

    @InjectMocks
    PeriodoPersonaServiceImpl periodoPersonaService;

    @Test
    public void mergePeriodoLocalizacionPersonaTest() {

        RunTareaDto runTarea = mock(RunTareaDto.class);
        periodoPersonaService.mergePeriodoPersona(runTarea);

        verify(periodoPersonaRepositoryCustom, times(1)).mergePeriodoPersona(runTarea);

    }

}
