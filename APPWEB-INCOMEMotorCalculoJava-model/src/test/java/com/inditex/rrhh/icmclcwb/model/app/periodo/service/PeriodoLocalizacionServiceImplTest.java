package com.inditex.rrhh.icmclcwb.model.app.periodo.service;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.model.primary.periodo.repository.PeriodoLocalizacionRepositoryCustom;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class PeriodoLocalizacionServiceImplTest {

  @Mock
  PeriodoLocalizacionRepositoryCustom periodoLocalizacionRepositoryCustom;

  @InjectMocks
  PeriodoLocalizacionServiceImpl periodoLocalizacionService;

  @Test
  public void mergePeriodoLocalizacionPersonaTest() {

    final RunTareaDto runTarea = mock(RunTareaDto.class);
    this.periodoLocalizacionService.mergePeriodoLocalizacion(runTarea);

    verify(this.periodoLocalizacionRepositoryCustom, times(1)).mergePeriodoLocalizacion(runTarea);

  }

  @Test
  public void limpiezaPeriodoLocalizacionTest() {

    final RunTareaDto runTarea = mock(RunTareaDto.class);
    final TareaAmbitoDto tareaAmbitoDto = mock(TareaAmbitoDto.class);

    this.periodoLocalizacionService.limpiezaPeriodoLocalizacion(runTarea, tareaAmbitoDto);

    verify(this.periodoLocalizacionRepositoryCustom, times(1)).limpiezaPeriodoLocalizacion(runTarea,
        tareaAmbitoDto);

  }

}
