package com.inditex.rrhh.icmclcwb.model.app.run.tarea.consolidar.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import com.inditex.rrhh.icmclcwb.api.app.periodo.service.PeriodoCalculoPersonaService;
import com.inditex.rrhh.icmclcwb.api.app.periodo.service.PeriodoLocalizacionPersonaService;
import com.inditex.rrhh.icmclcwb.api.app.periodo.service.PeriodoLocalizacionService;
import com.inditex.rrhh.icmclcwb.api.app.periodo.service.PeriodoPersonaService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class RunTareaConsolidarPeriodoServiceImplTest {
  @Mock
  private PeriodoCalculoPersonaService periodoCalculoPersonaService;

  @Mock
  private PeriodoPersonaService periodoPersonaService;

  @Mock
  private PeriodoLocalizacionService periodoLocalizacionService;

  @Mock
  private PeriodoLocalizacionPersonaService periodoLocalizacionPersonaService;

  @InjectMocks
  private RunTareaConsolidarPeriodoServiceImpl runTareaConsolidarPeriodoService;

  @Test
  void mergePeriodoCalculoPersonaTest() {
    this.runTareaConsolidarPeriodoService.mergePeriodoCalculoPersona(new RunTareaDto());
    verify(this.periodoCalculoPersonaService, times(1)).mergePeriodoCalculoPersona(any(RunTareaDto.class));
  }

  @Test
  void limpiezaPeriodoCalculoPersonaTest() {
    this.runTareaConsolidarPeriodoService.limpiezaPeriodoCalculoPersona(new RunTareaDto(), new TareaAmbitoDto());
    verify(this.periodoCalculoPersonaService, times(1)).limpiezaPeriodoCalculoPersona(any(RunTareaDto.class), any(TareaAmbitoDto.class));
  }

  @Test
  void mergePeriodoPersonaTest() {
    this.runTareaConsolidarPeriodoService.mergePeriodoPersona(new RunTareaDto());
    verify(this.periodoPersonaService, times(1)).mergePeriodoPersona(any(RunTareaDto.class));
  }

  @Test
  void limpiezaPeriodoPersonaTest() {
    this.runTareaConsolidarPeriodoService.limpiezaPeriodoPersona(new RunTareaDto(), new TareaAmbitoDto());
    verify(this.periodoPersonaService, times(1)).limpiezaPeriodoPersona(any(RunTareaDto.class), any(TareaAmbitoDto.class));
  }

  @Test
  void mergePeriodoLocalizacionTest() {
    this.runTareaConsolidarPeriodoService.mergePeriodoLocalizacion(new RunTareaDto());
    verify(this.periodoLocalizacionService, times(1)).mergePeriodoLocalizacion(any(RunTareaDto.class));
  }

  @Test
  void limpiezaPeriodoLocalizacionTest() {
    this.runTareaConsolidarPeriodoService.limpiezaPeriodoLocalizacion(new RunTareaDto(), new TareaAmbitoDto());
    verify(this.periodoLocalizacionService, times(1)).limpiezaPeriodoLocalizacion(any(RunTareaDto.class), any(TareaAmbitoDto.class));
  }

  @Test
  void mergePeriodoLocalizacionPersonaTest() {
    this.runTareaConsolidarPeriodoService.mergePeriodoLocalizacionPersona(new RunTareaDto());
    verify(this.periodoLocalizacionPersonaService, times(1)).mergePeriodoLocalizacionPersona(any(RunTareaDto.class));
  }

  @Test
  void limpiezaPeriodoLocalizacionPersonaTest() {
    this.runTareaConsolidarPeriodoService.limpiezaPeriodoLocalizacionPersona(new RunTareaDto(), new TareaAmbitoDto());
    verify(this.periodoLocalizacionPersonaService, times(1)).limpiezaPeriodoLocalizacionPersona(any(RunTareaDto.class),
        any(TareaAmbitoDto.class));
  }

}
