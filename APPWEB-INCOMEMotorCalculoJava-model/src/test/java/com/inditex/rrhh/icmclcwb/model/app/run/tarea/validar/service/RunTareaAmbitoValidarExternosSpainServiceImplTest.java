/*
 * Copyright (c) 2021. Inditex
 */

package com.inditex.rrhh.icmclcwb.model.app.run.tarea.validar.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.timeout;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.async.service.ComisAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalExternaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaFaseAccionDto;
import com.inditex.rrhh.icmclcwb.api.app.util.AppConstants;
import com.inditex.rrhh.icmclcwb.model.app.run.tarea.validar.mapper.ValidacionMapper;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaPersonaExternaMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaPersonaExternaRepositoryCustom;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class RunTareaAmbitoValidarExternosSpainServiceImplTest {

  @Mock
  private ComisAsyncService comisAsyncService;

  @Mock
  private TareaPersonaExternaRepositoryCustom tareaPersonaExternaRepositoryCustom;

  @Mock
  private TareaPersonaExternaMapper tareaPersonaExternaMapper;

  @Mock
  private ValidacionMapper validacionMapper;

  @InjectMocks
  private RunTareaAmbitoValidarExternosSpainServiceImpl runTareaAmbitoValidarExternosSpainService;

  @Test
  void executeTest() {

    final RunTareaDto runTareaDto = new RunTareaDto();
    final TareaDto tareaDto = new TareaDto();
    tareaDto.setId(1L);
    runTareaDto.setTarea(tareaDto);
    final TareaAmbitoDto tareaAmbitoDto = new TareaAmbitoDto();
    final TareaFaseAccionDto tareaFaseAccionDto = new TareaFaseAccionDto();

    final List<IdPersonaLocalExternaDto> lista = new ArrayList<>();
    final CompletableFuture<List<IdPersonaLocalExternaDto>> cf = new CompletableFuture<>();
    cf.complete(lista);

    when(this.comisAsyncService.findExternosByMinIdPersona(any(RunTareaDto.class), any(TareaAmbitoDto.class),
        any(Long.class))).thenReturn(cf);

    this.runTareaAmbitoValidarExternosSpainService.execute(runTareaDto, tareaAmbitoDto, tareaFaseAccionDto);

    verify(this.comisAsyncService, timeout(1000).times(1)).findExternosByMinIdPersona(runTareaDto, tareaAmbitoDto,
        AppConstants.MIN_ID_PERSONA_EXTERNO_ES);
    verify(this.tareaPersonaExternaMapper, timeout(1000).times(1))
        .idPersonaLocalExternaToTareaPersonaExterna(any(List.class), eq(tareaDto));
    verify(this.tareaPersonaExternaRepositoryCustom, timeout(1000).times(1)).save(any(List.class));
    verify(this.validacionMapper, timeout(1000).times(1)).booleanToValidacionDto(tareaAmbitoDto, tareaFaseAccionDto,
        true);
  }

}
