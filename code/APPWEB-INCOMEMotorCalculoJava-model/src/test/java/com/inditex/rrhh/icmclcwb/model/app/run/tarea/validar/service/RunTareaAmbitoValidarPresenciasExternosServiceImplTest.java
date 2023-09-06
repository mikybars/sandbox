/*
 * Copyright (c) 2021. Inditex
 */

package com.inditex.rrhh.icmclcwb.model.app.run.tarea.validar.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.timeout;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaLocalizacionPersonaPresenciaAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaFaseAccionDto;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;
import com.inditex.rrhh.icmclcwb.model.app.run.tarea.validar.mapper.ValidacionMapper;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class RunTareaAmbitoValidarPresenciasExternosServiceImplTest {

  @Mock
  private TareaLocalizacionPersonaPresenciaAsyncService tareaLocalizacionPersonaPresenciaAsyncService;

  @Mock
  private ValidacionMapper validacionMapper;

  @InjectMocks
  private RunTareaAmbitoValidarPresenciasExternosServiceImpl runTareaAmbitoValidarPresenciasExternosService;

  @Test
  public void executeTest() {

    final RunTareaDto runTareaDto = new RunTareaDto();
    final TareaDto tareaDto = new TareaDto();
    tareaDto.setId(1L);
    runTareaDto.setTarea(tareaDto);
    final TareaAmbitoDto tareaAmbitoDto = new TareaAmbitoDto();
    final TareaFaseAccionDto tareaFaseAccionDto = new TareaFaseAccionDto();

    final CompletableFuture<Void> cf = new CompletableFuture<>();
    cf.complete(AsyncConstants.NIL);

    when(this.tareaLocalizacionPersonaPresenciaAsyncService.updateActivoPersonasExternas(any(RunTareaDto.class)))
        .thenReturn(cf);

    this.runTareaAmbitoValidarPresenciasExternosService.execute(runTareaDto, tareaAmbitoDto, tareaFaseAccionDto);

    verify(this.tareaLocalizacionPersonaPresenciaAsyncService, timeout(1000).times(1))
        .updateActivoPersonasExternas(runTareaDto);
    verify(this.validacionMapper, timeout(1000).times(1)).booleanToValidacionDto(tareaAmbitoDto, tareaFaseAccionDto,
        true);

  }

}
