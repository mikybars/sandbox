package com.inditex.rrhh.icmclcwb.model.app.periodo.service;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.model.primary.periodo.repository.PeriodoPersonaRepositoryCustom;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
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
