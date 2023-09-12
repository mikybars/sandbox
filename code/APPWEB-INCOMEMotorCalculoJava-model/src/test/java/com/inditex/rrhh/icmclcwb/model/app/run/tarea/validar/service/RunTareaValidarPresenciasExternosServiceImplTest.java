/*
 * Copyright (c) 2021. Inditex
 */

package com.inditex.rrhh.icmclcwb.model.app.run.tarea.validar.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.timeout;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import com.inditex.rrhh.icmclcwb.api.app.dto.ValidacionDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.validar.service.RunTareaAmbitoValidarPresenciasExternosService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaFaseAccionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.AccionService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaFaseAccionService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class RunTareaValidarPresenciasExternosServiceImplTest {

  private static final String ID_EMPRESA = "EMPRESA";

  private static final String ID_ORIGEN = "ORIGEN";

  private static final Integer ID_ACCION = 111;

  @Mock
  private TareaFaseAccionService tareaFaseAccionService;

  @Mock
  private AccionService accionService;

  @Mock
  private RunTareaAmbitoValidarPresenciasExternosService runTareaAmbitoValidarPresenciasExternosService;

  @InjectMocks
  private RunTareaValidarPresenciasExternosServiceImpl runTareaValidarPresenciasExternosService;

  @Test
  public void executeTest() {
    final RunTareaDto runTareaDto = new RunTareaDto();
    final TareaDto tareaDto = new TareaDto();
    tareaDto.setId(1L);
    tareaDto.setAmbito(new ArrayList<TareaAmbitoDto>());
    tareaDto.setStdIdLegEnt(ID_EMPRESA);
    runTareaDto.setTarea(tareaDto);
    final TareaAmbitoDto tareaAmbitoDto = new TareaAmbitoDto();
    tareaAmbitoDto.setCclIdOrigen(ID_ORIGEN);
    tareaDto.getAmbito().add(tareaAmbitoDto);
    final TareaFaseAccionDto tareaFaseAccionDto = new TareaFaseAccionDto();
    tareaFaseAccionDto.setIdAccion(ID_ACCION);

    final ValidacionDto validacion = new ValidacionDto();
    validacion.setResult(Boolean.TRUE);

    when(this.accionService.findByIdAccionAndIdOrigenAndStdIdLegEnt(any(Integer.class), any(String.class),
        any(String.class))).thenReturn(Boolean.TRUE);

    when(this.runTareaAmbitoValidarPresenciasExternosService.execute(any(RunTareaDto.class),
        any(TareaAmbitoDto.class),
        any(TareaFaseAccionDto.class))).thenReturn(validacion);

    this.runTareaValidarPresenciasExternosService.execute(runTareaDto, tareaFaseAccionDto);

    verify(this.tareaFaseAccionService, timeout(1000).times(1)).updateFechaInicio(tareaFaseAccionDto);

    verify(this.accionService, timeout(1000).times(1)).findByIdAccionAndIdOrigenAndStdIdLegEnt(ID_ACCION, ID_ORIGEN,
        ID_EMPRESA);

    verify(this.runTareaAmbitoValidarPresenciasExternosService, timeout(1000).times(1)).execute(runTareaDto,
        tareaAmbitoDto,
        tareaFaseAccionDto);
  }

}
