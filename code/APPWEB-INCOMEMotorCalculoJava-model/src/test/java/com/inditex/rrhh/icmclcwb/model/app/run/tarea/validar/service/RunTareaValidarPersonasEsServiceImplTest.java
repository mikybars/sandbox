package com.inditex.rrhh.icmclcwb.model.app.run.tarea.validar.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.timeout;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import com.inditex.rrhh.icmclcwb.api.app.dto.ValidacionDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.validar.service.RunTareaAmbitoValidarPersonasEsService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.EstadoTareaFaseAccionEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.EstadoTareaFaseAccionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaFaseAccionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.AccionService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaFaseAccionService;

import org.instancio.junit.InstancioSource;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith({SpringExtension.class})
class RunTareaValidarPersonasEsServiceImplTest {

  @Mock
  private TareaFaseAccionService tareaFaseAccionService;

  @Mock
  private RunTareaAmbitoValidarPersonasEsService runTareaAmbitoValidarPersonasEsService;

  @Mock
  private AccionService accionService;

  @InjectMocks
  private RunTareaValidarPersonasEsServiceImpl runTareaValidarPersonasService;

  @ParameterizedTest
  @InstancioSource(samples = 1)
  void executeValidacionesConErroresTest(final RunTareaDto runTarea, final TareaFaseAccionDto tareaFaseAccion) {

    final TareaDto tarea = runTarea.getTarea();
    when(this.accionService.findByIdAccionAndIdOrigenAndStdIdLegEnt(
        any(Integer.class), any(String.class),
        any(String.class)))
            .thenReturn(Boolean.TRUE);

    final ValidacionDto validacion = new ValidacionDto();
    validacion.setResult(Boolean.FALSE);
    when(this.runTareaAmbitoValidarPersonasEsService.execute(any(RunTareaDto.class),
        any(TareaAmbitoDto.class),
        any(TareaFaseAccionDto.class)))
            .thenReturn(validacion);

    this.runTareaValidarPersonasService.execute(runTarea, tareaFaseAccion);

    verify(this.tareaFaseAccionService, timeout(1000).times(1)).updateFechaInicio(tareaFaseAccion);

    for (final TareaAmbitoDto ambito : tarea.getAmbito()) {
      verify(this.accionService, timeout(1000).times(1)).findByIdAccionAndIdOrigenAndStdIdLegEnt(tareaFaseAccion.getIdAccion(),
          ambito.getCclIdOrigen(), tarea.getStdIdLegEnt());
      verify(this.runTareaAmbitoValidarPersonasEsService, timeout(1000).times(1)).execute(runTarea, ambito, tareaFaseAccion);
    }

    verify(this.tareaFaseAccionService, timeout(1000).times(0)).updateFechaFinAndEstado(any(TareaFaseAccionDto.class), any(
        EstadoTareaFaseAccionDto.class));
  }

  @ParameterizedTest
  @InstancioSource(samples = 1)
  void executeSinValidacionesTest(final RunTareaDto runTarea, final TareaFaseAccionDto tareaFaseAccion) {

    final TareaDto tarea = runTarea.getTarea();
    tarea.setAmbito(new ArrayList<>());
    when(this.accionService.findByIdAccionAndIdOrigenAndStdIdLegEnt(
        any(Integer.class), any(String.class),
        any(String.class)))
            .thenReturn(Boolean.TRUE);

    this.runTareaValidarPersonasService.execute(runTarea, tareaFaseAccion);

    verify(this.runTareaAmbitoValidarPersonasEsService, timeout(1000).times(0)).execute(any(RunTareaDto.class),
        any(TareaAmbitoDto.class), any(TareaFaseAccionDto.class));
    verify(this.accionService, timeout(1000).times(0)).findAccionDtoById(any(Integer.class));
    verify(this.tareaFaseAccionService, timeout(1000).times(1)).updateFechaFinAndEstado(tareaFaseAccion,
        EstadoTareaFaseAccionEnum.NO_EJECUTADA.getDto());

  }

  @ParameterizedTest
  @InstancioSource(samples = 1)
  void executeValidacionesSinErroresTest(final RunTareaDto runTarea, final TareaFaseAccionDto tareaFaseAccion) {

    final TareaDto tarea = runTarea.getTarea();
    when(this.accionService.findByIdAccionAndIdOrigenAndStdIdLegEnt(
        any(Integer.class), any(String.class),
        any(String.class)))
            .thenReturn(Boolean.TRUE);

    final ValidacionDto validacion = new ValidacionDto();
    validacion.setResult(Boolean.TRUE);
    when(this.runTareaAmbitoValidarPersonasEsService.execute(any(RunTareaDto.class),
        any(TareaAmbitoDto.class),
        any(TareaFaseAccionDto.class)))
            .thenReturn(validacion);

    this.runTareaValidarPersonasService.execute(runTarea, tareaFaseAccion);

    for (final TareaAmbitoDto ambito : tarea.getAmbito()) {
      verify(this.accionService, timeout(1000).times(1)).findByIdAccionAndIdOrigenAndStdIdLegEnt(tareaFaseAccion.getIdAccion(),
          ambito.getCclIdOrigen(), tarea.getStdIdLegEnt());
      verify(this.runTareaAmbitoValidarPersonasEsService, timeout(1000).times(1)).execute(runTarea, ambito, tareaFaseAccion);
    }
    verify(this.tareaFaseAccionService, timeout(1000).times(1)).updateFechaFinAndEstado(tareaFaseAccion,
        EstadoTareaFaseAccionEnum.OK.getDto());

  }

}
