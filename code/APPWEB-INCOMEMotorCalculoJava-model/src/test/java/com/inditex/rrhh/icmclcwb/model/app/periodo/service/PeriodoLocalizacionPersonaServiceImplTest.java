package com.inditex.rrhh.icmclcwb.model.app.periodo.service;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.model.primary.periodo.repository.PeriodoLocalizacionPersonaRepositoryCustom;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class PeriodoLocalizacionPersonaServiceImplTest {

  @Mock
  PeriodoLocalizacionPersonaRepositoryCustom periodoLocalizacionPersonaRepositoryCustom;

  @InjectMocks
  PeriodoLocalizacionPersonaServiceImpl periodoLocalizacionPersonaService;

  @Test
  public void mergePeriodoLocalizacionPersonaTest() {

    final RunTareaDto runTarea = mock(RunTareaDto.class);
    this.periodoLocalizacionPersonaService.mergePeriodoLocalizacionPersona(runTarea);

    verify(this.periodoLocalizacionPersonaRepositoryCustom, times(1)).mergePeriodoLocalizacionPersona(runTarea);

  }

  @Test
  public void limpiezaPeriodoLocalizacionPersonaTest() {

    final RunTareaDto runTarea = mock(RunTareaDto.class);
    final TareaAmbitoDto tareaAmbitoDto = mock(TareaAmbitoDto.class);

    this.periodoLocalizacionPersonaService.limpiezaPeriodoLocalizacionPersona(runTarea, tareaAmbitoDto);

    verify(this.periodoLocalizacionPersonaRepositoryCustom, times(1)).limpiezaPeriodoLocalizacionPersona(runTarea,
        tareaAmbitoDto);
  }

}
