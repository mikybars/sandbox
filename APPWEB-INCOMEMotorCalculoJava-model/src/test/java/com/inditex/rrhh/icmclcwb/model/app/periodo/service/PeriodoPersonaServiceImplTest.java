package com.inditex.rrhh.icmclcwb.model.app.periodo.service;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.model.primary.periodo.repository.PeriodoPersonaRepositoryCustom;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class PeriodoPersonaServiceImplTest {

    @Mock
    PeriodoPersonaRepositoryCustom periodoPersonaRepositoryCustom;

    @InjectMocks
    PeriodoPersonaServiceImpl periodoPersonaService;

    @Test
    public void mergePeriodoLocalizacionPersonaTest() {

        final RunTareaDto runTarea = mock(RunTareaDto.class);
        this.periodoPersonaService.mergePeriodoPersona(runTarea);

        verify(this.periodoPersonaRepositoryCustom, times(1)).mergePeriodoPersona(runTarea);

    }

    @Test
    public void limpiezaPeriodoPersonaTest() {

        final RunTareaDto runTarea = mock(RunTareaDto.class);
        final TareaAmbitoDto tareaAmbitoDto = mock(TareaAmbitoDto.class);

        this.periodoPersonaService.limpiezaPeriodoPersona(runTarea, tareaAmbitoDto);

        verify(this.periodoPersonaRepositoryCustom, times(1)).limpiezaPeriodoPersona(runTarea,
                tareaAmbitoDto);

    }

}
