package com.inditex.rrhh.icmclcwb.model.app.periodo.service;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.model.primary.periodo.repository.PeriodoCalculoPersonaRepositoryCustom;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class PeriodoCalculoPersonaServiceImplTest {

  @Mock
  PeriodoCalculoPersonaRepositoryCustom periodoCalculoPersonaRepositoryCustom;

  @InjectMocks
  PeriodoCalculoPersonaServiceImpl periodoCalculoPersonaService;

  @Test
  public void mergePeriodoCalculoPersonaTest() {

    final RunTareaDto runTarea = mock(RunTareaDto.class);
    this.periodoCalculoPersonaService.mergePeriodoCalculoPersona(runTarea);

    verify(this.periodoCalculoPersonaRepositoryCustom, times(1))
        .mergePeriodoCalculoPersona(runTarea);

  }

  @Test
  public void limpiezaPeriodoCalculoPersonaTest() {

    final RunTareaDto runTarea = mock(RunTareaDto.class);
    final TareaAmbitoDto tareaAmbitoDto = mock(TareaAmbitoDto.class);
    this.periodoCalculoPersonaService.limpiezaPeriodoCalculoPersona(runTarea, tareaAmbitoDto);

    verify(this.periodoCalculoPersonaRepositoryCustom, times(1))
        .limpiezaPeriodoCalculoPersona(runTarea, tareaAmbitoDto);
  }

}
