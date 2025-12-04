package com.inditex.rrhh.icmclcwb.model.app.run.tarea.validar.service;

import static org.mockito.Mockito.timeout;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import com.inditex.rrhh.icmclcwb.api.app.dto.ValidacionDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.validar.service.RunTareaAmbitoValidarPresenciasSinVentasService;
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
import org.slf4j.Logger;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class RunTareaValidarPresenciasSinVentasServiceImplTest {

  @Mock
  private TareaFaseAccionService tareaFaseAccionService;

  @Mock
  private RunTareaAmbitoValidarPresenciasSinVentasService runTareaAmbitoValidarPresenciasSinVentasService;

  @Mock
  private AccionService accionService;

  @Mock
  private Logger log;

  @InjectMocks
  private RunTareaValidarPresenciasSinVentasServiceImpl runTareaValidarPresenciasSinVentasService;

  @Test
  void execute() {
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
    when(this.accionService.findByIdAccionAndIdOrigenAndStdIdLegEnt(
        ArgumentMatchers.any(Integer.class), ArgumentMatchers.any(String.class),
        ArgumentMatchers.any(String.class)))
            .thenReturn(Boolean.TRUE);

    when(this.runTareaAmbitoValidarPresenciasSinVentasService.execute(ArgumentMatchers.any(RunTareaDto.class),
        ArgumentMatchers.any(TareaAmbitoDto.class),
        ArgumentMatchers.any(TareaFaseAccionDto.class)))
            .thenReturn(validacion);

    this.runTareaValidarPresenciasSinVentasService.execute(runTareaDto, tareaFaseAccionDto);

    verify(this.tareaFaseAccionService, timeout(1000).times(1))
        .updateFechaInicio(
            ArgumentMatchers.any(TareaFaseAccionDto.class));

    verify(this.accionService, timeout(1000).times(1))
        .findByIdAccionAndIdOrigenAndStdIdLegEnt(
            ArgumentMatchers.any(Integer.class), ArgumentMatchers.any(String.class),
            ArgumentMatchers.any(String.class));

    verify(this.runTareaAmbitoValidarPresenciasSinVentasService, timeout(1000).times(1))
        .execute(
            ArgumentMatchers.any(RunTareaDto.class), ArgumentMatchers.any(TareaAmbitoDto.class),
            ArgumentMatchers.any(TareaFaseAccionDto.class));

  }

  @Test
  void executeWithEmptyValidations() {
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
            .thenReturn(Boolean.FALSE);

    this.runTareaValidarPresenciasSinVentasService.execute(runTareaDto, tareaFaseAccionDto);

    verify(this.tareaFaseAccionService, timeout(1000).times(1))
        .updateFechaInicio(
            ArgumentMatchers.any(TareaFaseAccionDto.class));

    verify(this.accionService, timeout(1000).times(1))
        .findByIdAccionAndIdOrigenAndStdIdLegEnt(
            ArgumentMatchers.any(Integer.class), ArgumentMatchers.any(String.class),
            ArgumentMatchers.any(String.class));

    verify(this.tareaFaseAccionService, timeout(1000).times(1))
        .updateFechaFinAndEstado(
            ArgumentMatchers.any(TareaFaseAccionDto.class),
            ArgumentMatchers.any());

  }

}
