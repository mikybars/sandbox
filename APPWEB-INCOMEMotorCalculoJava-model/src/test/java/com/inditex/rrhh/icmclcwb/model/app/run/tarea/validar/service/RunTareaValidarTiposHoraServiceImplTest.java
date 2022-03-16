package com.inditex.rrhh.icmclcwb.model.app.run.tarea.validar.service;

/*
 * Copyright (c) 2022. Inditex
 */
import static org.mockito.Mockito.timeout;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import com.inditex.rrhh.icmclcwb.api.app.dto.ValidacionDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.validar.service.RunTareaAmbitoValidarTiposHoraService;
import com.inditex.rrhh.icmclcwb.api.app.service.MailService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaFaseAccionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.AccionService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaFaseAccionService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class RunTareaValidarTiposHoraServiceImplTest {

  @Mock
  private TareaFaseAccionService tareaFaseAccionService;

  @Mock
  private RunTareaAmbitoValidarTiposHoraService runTareaAmbitoValidarTiposHoraService;

  @Mock
  private AccionService accionService;

  @InjectMocks
  private RunTareaValidarTiposHoraServiceImpl runTareaValidarTiposHoraServiceImpl;

  @Mock
  private MailService mailService;

  @Test
  public void executeTest() {
    final ValidacionDto validacion = new ValidacionDto();
    validacion.setResult(Boolean.FALSE);
    this.execute(validacion, Boolean.TRUE);
    verify(this.runTareaAmbitoValidarTiposHoraService, timeout(1000).times(1))
        .execute(
            ArgumentMatchers.any(RunTareaDto.class), ArgumentMatchers.any(TareaAmbitoDto.class),
            ArgumentMatchers.any(TareaFaseAccionDto.class));
  }

  @Test
  public void executeTestTrue() {
    final ValidacionDto validacion = new ValidacionDto();
    validacion.setResult(Boolean.TRUE);
    this.execute(validacion, Boolean.TRUE);
    verify(this.runTareaAmbitoValidarTiposHoraService, timeout(1000).times(1))
        .execute(
            ArgumentMatchers.any(RunTareaDto.class), ArgumentMatchers.any(TareaAmbitoDto.class),
            ArgumentMatchers.any(TareaFaseAccionDto.class));
  }

  @Test
  public void executeTestNull() {
    this.execute(null, Boolean.FALSE);
  }

  public void execute(final ValidacionDto validacion, final Boolean flagAccion) {
    final RunTareaDto runTareaDto = new RunTareaDto();
    final TareaDto tareaDto = new TareaDto();
    tareaDto.setId(1L);
    tareaDto.setAmbito(new ArrayList<TareaAmbitoDto>());
    tareaDto.setStdIdLegEnt("1");
    runTareaDto.setTarea(tareaDto);
    final TareaAmbitoDto tareaAmbitoDto = new TareaAmbitoDto();
    tareaAmbitoDto.setCclIdOrigen("1");
    tareaDto.getAmbito().add(tareaAmbitoDto);
    final TareaFaseAccionDto tareaFaseAccionDto = new TareaFaseAccionDto();
    tareaFaseAccionDto.setIdAccion(1);

    when(this.accionService.findByIdAccionAndIdOrigenAndStdIdLegEnt(
        ArgumentMatchers.any(Integer.class), ArgumentMatchers.any(String.class),
        ArgumentMatchers.any(String.class)))
            .thenReturn(flagAccion);

    when(this.runTareaAmbitoValidarTiposHoraService.execute(ArgumentMatchers.any(RunTareaDto.class),
        ArgumentMatchers.any(TareaAmbitoDto.class),
        ArgumentMatchers.any(TareaFaseAccionDto.class)))
            .thenReturn(validacion);

    this.runTareaValidarTiposHoraServiceImpl.execute(runTareaDto, tareaFaseAccionDto);

    verify(this.tareaFaseAccionService, timeout(1000).times(1))
        .updateFechaInicio(
            ArgumentMatchers.any(TareaFaseAccionDto.class));

    verify(this.accionService, timeout(1000).times(1))
        .findByIdAccionAndIdOrigenAndStdIdLegEnt(
            ArgumentMatchers.any(Integer.class), ArgumentMatchers.any(String.class),
            ArgumentMatchers.any(String.class));

  }
}
