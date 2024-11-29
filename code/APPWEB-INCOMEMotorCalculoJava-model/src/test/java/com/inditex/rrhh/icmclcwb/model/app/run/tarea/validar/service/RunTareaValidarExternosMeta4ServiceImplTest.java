package com.inditex.rrhh.icmclcwb.model.app.run.tarea.validar.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.timeout;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import com.inditex.rrhh.icmclcwb.api.app.dto.ValidacionDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.validar.service.RunTareaAmbitoValidarExternosMeta4Service;
import com.inditex.rrhh.icmclcwb.api.app.tarea.EstadoTareaFaseAccionEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaFaseAccionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.AccionService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaFaseAccionService;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class RunTareaValidarExternosMeta4ServiceImplTest {

  @Mock
  private TareaFaseAccionService tareaFaseAccionService;

  @Mock
  private RunTareaAmbitoValidarExternosMeta4Service runTareaAmbitoValidarExternosMeta4Service;

  @Mock
  private AccionService accionService;

  @InjectMocks
  private RunTareaValidarExternosMeta4ServiceImpl runTareaValidarExternosMeta4ServiceImpl;

  @Test
  void executeWithValidations() throws ExecutionException, InterruptedException {
    final RunTareaDto runTareaDto = new RunTareaDto();
    final TareaDto tareaDto = new TareaDto();
    tareaDto.setId(1L);
    runTareaDto.setTarea(tareaDto);
    final TareaFaseAccionDto tareaFaseAccionDto = new TareaFaseAccionDto();
    tareaFaseAccionDto.setIdAccion(1);

    final TareaAmbitoDto tareaAmbitoDto = new TareaAmbitoDto();
    tareaAmbitoDto.setCclIdOrigen("11");
    final List<TareaAmbitoDto> ambitoList = new ArrayList<>();
    ambitoList.add(tareaAmbitoDto);
    runTareaDto.getTarea().setAmbito(ambitoList);

    final ValidacionDto validacionDto = new ValidacionDto();
    validacionDto.setResult(true);
    final List<ValidacionDto> validaciones = new ArrayList<>();
    validaciones.add(validacionDto);

    when(this.accionService.findByIdAccionAndIdOrigenAndStdIdLegEnt(any(), any(), any())).thenReturn(true);
    when(this.runTareaAmbitoValidarExternosMeta4Service.execute(any(), any(), any())).thenReturn(validacionDto);

    final CompletableFuture<List<ValidacionDto>> result =
        this.runTareaValidarExternosMeta4ServiceImpl.execute(runTareaDto, tareaFaseAccionDto);

    verify(this.tareaFaseAccionService, timeout(1000).times(1)).updateFechaInicio(tareaFaseAccionDto);
    verify(this.tareaFaseAccionService, timeout(1000).times(1)).updateFechaFinAndEstado(tareaFaseAccionDto,
        EstadoTareaFaseAccionEnum.OK.getDto());
    Assertions.assertEquals(validaciones, result.get());
  }

  @Test
  void executeWithoutValidations() throws ExecutionException, InterruptedException {
    final RunTareaDto runTareaDto = new RunTareaDto();
    final TareaDto tareaDto = new TareaDto();
    tareaDto.setId(1L);
    runTareaDto.setTarea(tareaDto);
    final TareaFaseAccionDto tareaFaseAccionDto = new TareaFaseAccionDto();
    tareaFaseAccionDto.setIdAccion(1);

    final List<TareaAmbitoDto> ambitoList = new ArrayList<>();
    runTareaDto.getTarea().setAmbito(ambitoList);

    when(this.accionService.findByIdAccionAndIdOrigenAndStdIdLegEnt(any(), any(), any())).thenReturn(false);

    final CompletableFuture<List<ValidacionDto>> result =
        this.runTareaValidarExternosMeta4ServiceImpl.execute(runTareaDto, tareaFaseAccionDto);

    verify(this.tareaFaseAccionService, timeout(1000).times(1)).updateFechaInicio(tareaFaseAccionDto);
    verify(this.tareaFaseAccionService, timeout(1000).times(1)).updateFechaFinAndEstado(tareaFaseAccionDto,
        EstadoTareaFaseAccionEnum.NO_EJECUTADA.getDto());
    Assertions.assertTrue(result.get().isEmpty());
  }

  @Test
  void executeWithFailedValidations() throws ExecutionException, InterruptedException {
    final RunTareaDto runTareaDto = new RunTareaDto();
    final TareaDto tareaDto = new TareaDto();
    tareaDto.setId(1L);
    runTareaDto.setTarea(tareaDto);
    final TareaFaseAccionDto tareaFaseAccionDto = new TareaFaseAccionDto();
    tareaFaseAccionDto.setIdAccion(1);

    final TareaAmbitoDto tareaAmbitoDto = new TareaAmbitoDto();
    tareaAmbitoDto.setCclIdOrigen("11");
    final List<TareaAmbitoDto> ambitoList = new ArrayList<>();
    ambitoList.add(tareaAmbitoDto);
    runTareaDto.getTarea().setAmbito(ambitoList);

    final ValidacionDto validacionDto = new ValidacionDto();
    validacionDto.setResult(false);
    final List<ValidacionDto> validaciones = new ArrayList<>();
    validaciones.add(validacionDto);

    when(this.accionService.findByIdAccionAndIdOrigenAndStdIdLegEnt(any(), any(), any())).thenReturn(true);
    when(this.runTareaAmbitoValidarExternosMeta4Service.execute(any(), any(), any())).thenReturn(validacionDto);

    final CompletableFuture<List<ValidacionDto>> result =
        this.runTareaValidarExternosMeta4ServiceImpl.execute(runTareaDto, tareaFaseAccionDto);

    verify(this.tareaFaseAccionService, timeout(1000).times(1)).updateFechaInicio(tareaFaseAccionDto);
    Assertions.assertEquals(validaciones, result.get());
  }
}
