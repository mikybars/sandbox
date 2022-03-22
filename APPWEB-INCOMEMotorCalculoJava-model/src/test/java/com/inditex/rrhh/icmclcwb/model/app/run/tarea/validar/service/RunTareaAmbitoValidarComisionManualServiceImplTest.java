package com.inditex.rrhh.icmclcwb.model.app.run.tarea.validar.service;

/*
 * Copyright (c) 2022. Inditex
 */
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.timeout;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.inditex.aqsw.framework.test.randomizer.Random;
import com.inditex.aqsw.framework.test.randomizer.RandomizerExtension;
import com.inditex.rrhh.icmclcwb.api.app.async.service.ComisAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalComisionManualDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.prevalidar.properties.dto.PrevalidarPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.EstadoTareaFaseAccionEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaFaseAccionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.AccionService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaFaseAccionService;
import com.inditex.rrhh.icmclcwb.model.app.run.tarea.validar.mapper.ValidacionMapper;
import com.inditex.rrhh.icmclcwb.model.primary.repository.PrimaryTemporaryTableRepositoryCustom;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith({SpringExtension.class, RandomizerExtension.class})
class RunTareaAmbitoValidarComisionManualServiceImplTest {

  @Mock
  private TareaFaseAccionService tareaFaseAccionService;

  @Mock
  private ComisAsyncService comisAsyncService;

  @Mock
  private AccionService accionService;

  @Mock
  private PrimaryTemporaryTableRepositoryCustom primaryTemporaryTableRepositoryCustom;

  @Mock
  private ValidacionMapper validacionMapper;

  @Mock
  private PrevalidarPropertiesDto comisionManualProperties;

  @InjectMocks
  private RunTareaAmbitoValidarComisionManualServiceImpl runTareaAmbitoValidarComisionManualService;

  @Test
  void executeTest(@Random final RunTareaDto runTarea, @Random final TareaAmbitoDto tareaAmbito,
      @Random final TareaFaseAccionDto tareaFaseAccion,
      @Random final IdPersonaLocalComisionManualDto comision) {

    final List<IdPersonaLocalComisionManualDto> lista = Collections.singletonList(comision);
    final CompletableFuture<List<IdPersonaLocalComisionManualDto>> cf = new CompletableFuture<>();
    cf.complete(lista);

    when(this.comisAsyncService.findComisionManual(any(RunTareaDto.class), any(TareaAmbitoDto.class))).thenReturn(cf);

    this.runTareaAmbitoValidarComisionManualService.execute(runTarea, tareaAmbito, tareaFaseAccion);

    verify(this.comisAsyncService, timeout(1000).times(1)).findComisionManual(runTarea, tareaAmbito);
    verify(this.primaryTemporaryTableRepositoryCustom, timeout(1000).times(1)).createTempComisComisionManual();
    verify(this.primaryTemporaryTableRepositoryCustom, timeout(1000).times(1)).indexTempComisComisionManual();
    verify(this.primaryTemporaryTableRepositoryCustom, timeout(1000).times(1)).insertTempComisComisionManual(lista);
    verify(this.primaryTemporaryTableRepositoryCustom, timeout(1000).times(1)).validateTempComisComisionManual(runTarea.getTarea());
    verify(this.primaryTemporaryTableRepositoryCustom, timeout(1000).times(1)).deleteTempComisComisionManual();
    verify(this.validacionMapper, timeout(1000).times(1)).idPersonaLocalDtoTovalidacionDto(eq(tareaAmbito), eq(tareaFaseAccion),
        ArgumentMatchers.<List<IdPersonaLocalDto>>any(), eq(
            this.comisionManualProperties),
        eq(runTarea.getTarea()));

  }

  @Test
  void executeExceptionTest(@Random final RunTareaDto runTarea, @Random final TareaAmbitoDto tareaAmbito,
      @Random final TareaFaseAccionDto tareaFaseAccion) {

    when(this.comisAsyncService.findComisionManual(any(RunTareaDto.class), any(TareaAmbitoDto.class))).thenThrow(RuntimeException.class);

    assertThrows(RuntimeException.class, () -> {
      this.runTareaAmbitoValidarComisionManualService.execute(runTarea, tareaAmbito, tareaFaseAccion);
    });
    verify(this.tareaFaseAccionService, timeout(1000).times(1)).updateFechaFinAndEstado(tareaFaseAccion,
        EstadoTareaFaseAccionEnum.ERROR.getDto());

  }

}
