package com.inditex.rrhh.icmclcwb.model.app.run.tarea.validar.service;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.timeout;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;

import com.inditex.rrhh.icmclcwb.api.app.dto.ValidacionDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.EstadoTareaFaseAccionEnum;
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
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class RunTareaValidarCalculoPendienteServiceImplTest {

  @Mock
  private TareaFaseAccionService tareaFaseAccionService;

  @Mock
  private RunTareaAmbitoValidarCalculoPendienteServiceImpl runTareaAmbitoValidarCalculoPendienteServiceService;

  @Mock
  private AccionService accionService;

  @InjectMocks
  private RunTareaValidarCalculoPendienteServiceImpl runTareaValidarCalculoPendienteService;

  @Test
  void executeEmptyValidacionesTest() {
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

    doReturn(null).when(this.runTareaAmbitoValidarCalculoPendienteServiceService)
        .execute(runTareaDto, tareaAmbitoDto, tareaFaseAccionDto);

    this.runTareaValidarCalculoPendienteService.execute(runTareaDto, tareaFaseAccionDto);

    verify(this.tareaFaseAccionService, timeout(1000).times(1))
        .updateFechaInicio(
            ArgumentMatchers.any(TareaFaseAccionDto.class));

    verify(this.accionService, timeout(1000).times(1))
        .findByIdAccionAndIdOrigenAndStdIdLegEnt(
            ArgumentMatchers.any(Integer.class), ArgumentMatchers.any(String.class),
            ArgumentMatchers.any(String.class));

    verify(this.tareaFaseAccionService, timeout(1000).times(1))
        .updateFechaFinAndEstado(
            Mockito.any(TareaFaseAccionDto.class), Mockito.eq(EstadoTareaFaseAccionEnum.NO_EJECUTADA.getDto()));
  }

  @Test
  void executeTest() {
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

    final ValidacionDto validacion = new ValidacionDto();
    validacion.setResult(Boolean.TRUE);

    doReturn(Boolean.TRUE).when(this.accionService).findByIdAccionAndIdOrigenAndStdIdLegEnt(
        ArgumentMatchers.any(Integer.class), ArgumentMatchers.any(String.class),
        ArgumentMatchers.any(String.class));

    doReturn(validacion).when(this.runTareaAmbitoValidarCalculoPendienteServiceService)
        .execute(ArgumentMatchers.any(RunTareaDto.class),
            ArgumentMatchers.any(TareaAmbitoDto.class),
            ArgumentMatchers.any(TareaFaseAccionDto.class));

    this.runTareaValidarCalculoPendienteService.execute(runTareaDto, tareaFaseAccionDto);

    verify(this.tareaFaseAccionService, timeout(1000).times(1))
        .updateFechaInicio(
            ArgumentMatchers.any(TareaFaseAccionDto.class));

    verify(this.accionService, timeout(1000).times(1))
        .findByIdAccionAndIdOrigenAndStdIdLegEnt(
            ArgumentMatchers.any(Integer.class), ArgumentMatchers.any(String.class),
            ArgumentMatchers.any(String.class));

    verify(this.tareaFaseAccionService, timeout(1000).times(1))
        .updateFechaFinAndEstado(
            Mockito.any(TareaFaseAccionDto.class), Mockito.eq(EstadoTareaFaseAccionEnum.OK.getDto()));
  }

  @Test
  void executeValidacionResultFalseTest() {
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

    final ValidacionDto validacion = new ValidacionDto();
    validacion.setResult(Boolean.FALSE);

    doReturn(Boolean.TRUE).when(this.accionService).findByIdAccionAndIdOrigenAndStdIdLegEnt(
        ArgumentMatchers.any(Integer.class), ArgumentMatchers.any(String.class),
        ArgumentMatchers.any(String.class));

    doReturn(validacion).when(this.runTareaAmbitoValidarCalculoPendienteServiceService)
        .execute(ArgumentMatchers.any(RunTareaDto.class),
            ArgumentMatchers.any(TareaAmbitoDto.class),
            ArgumentMatchers.any(TareaFaseAccionDto.class));

    this.runTareaValidarCalculoPendienteService.execute(runTareaDto, tareaFaseAccionDto);

    verify(this.tareaFaseAccionService, timeout(1000).times(1))
        .updateFechaInicio(
            ArgumentMatchers.any(TareaFaseAccionDto.class));

    verify(this.accionService, timeout(1000).times(1))
        .findByIdAccionAndIdOrigenAndStdIdLegEnt(
            ArgumentMatchers.any(Integer.class), ArgumentMatchers.any(String.class),
            ArgumentMatchers.any(String.class));
  }
}
