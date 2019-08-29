package com.inditex.rrhh.icmclcwb.model.app.periodo.service;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.model.primary.periodo.repository.PeriodoCalculoPersonaRepositoryCustom;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class PeriodoCalculoPersonaServiceImplTest {

    @Mock
    PeriodoCalculoPersonaRepositoryCustom periodoCalculoPersonaRepositoryCustom;

    @InjectMocks
    PeriodoCalculoPersonaServiceImpl periodoCalculoPersonaService;

    @Test
    public void mergePeriodoCalculoPersonaTest() {

        RunTareaDto runTarea = mock(RunTareaDto.class);
        periodoCalculoPersonaService.mergePeriodoCalculoPersona(runTarea);

        verify(periodoCalculoPersonaRepositoryCustom, times(1))
            .mergePeriodoCalculoPersona(runTarea);

    }

}
