package com.inditex.rrhh.icmclcwb.model.app.periodo.service;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.model.primary.periodo.repository.PeriodoLocalizacionRepositoryCustom;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class PeriodoLocalizacionServiceImplTest {

    @Mock
    PeriodoLocalizacionRepositoryCustom periodoLocalizacionRepositoryCustom;

    @InjectMocks
    PeriodoLocalizacionServiceImpl periodoLocalizacionService;

    @Test
    public void mergePeriodoLocalizacionPersonaTest() {

        RunTareaDto runTarea = mock(RunTareaDto.class);
        periodoLocalizacionService.mergePeriodoLocalizacion(runTarea);

        verify(periodoLocalizacionRepositoryCustom, times(1)).mergePeriodoLocalizacion(runTarea);

    }

}
