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
import com.inditex.rrhh.icmclcwb.api.app.service.IncomeMetaService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.ReglaEmpleadoExternoMeta4RequestDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaFaseAccionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.ReglaEmpleadoExternoMeta4Service;
import com.inditex.rrhh.icmclcwb.api.app.util.AppConstants;
import com.inditex.rrhh.icmclcwb.model.app.mapper.IdPersonaLocalExternaMapper;
import com.inditex.rrhh.icmclcwb.model.app.run.tarea.validar.mapper.ValidacionMapper;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.ReglaEmpleadoExternoMeta4Mapper;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaPersonaExternaMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaPersonaExternaRepositoryCustom;
import com.inditex.rrhh.icmclcwb.rest.client.dto.EmpleadoExternoDTO;
import com.inditex.rrhh.icmclcwb.rest.client.dto.ExternosRequestDTO;

import org.instancio.junit.InstancioSource;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith({SpringExtension.class})
class RunTareaAmbitoValidarExternosSpainServiceImplTest {

  @Mock
  private ComisAsyncService comisAsyncService;

  @Mock
  private TareaPersonaExternaRepositoryCustom tareaPersonaExternaRepositoryCustom;

  @Mock
  private TareaPersonaExternaMapper tareaPersonaExternaMapper;

  @Mock
  private ValidacionMapper validacionMapper;

  @Mock
  private IncomeMetaService incomeMetaService;

  @Mock
  private ReglaEmpleadoExternoMeta4Service reglaEmpleadoExternoMeta4Service;

  @Mock
  private ReglaEmpleadoExternoMeta4Mapper reglaEmpleadoExternoMeta4Mapper;

  @Mock
  private IdPersonaLocalExternaMapper idPersonaLocalExternaMapper;

  @InjectMocks
  private RunTareaAmbitoValidarExternosSpainServiceImpl runTareaAmbitoValidarExternosSpainService;

  @ParameterizedTest
  @InstancioSource
  void executeTest(final List<Integer> puestos,
      final ExternosRequestDTO externosRequestDTO,
      final List<EmpleadoExternoDTO> externos,
      final List<IdPersonaLocalExternaDto> idPersonaLocalExternaDtos) {

    final RunTareaDto runTareaDto = new RunTareaDto();
    final TareaDto tareaDto = new TareaDto();
    tareaDto.setId(1L);
    tareaDto.setStdIdLegEnt("0");
    runTareaDto.setTarea(tareaDto);
    final TareaAmbitoDto tareaAmbitoDto = new TareaAmbitoDto();
    tareaAmbitoDto.setCclIdOrigen("1");
    final TareaFaseAccionDto tareaFaseAccionDto = new TareaFaseAccionDto();

    final List<IdPersonaLocalExternaDto> lista = new ArrayList<>();
    final CompletableFuture<List<IdPersonaLocalExternaDto>> cf = new CompletableFuture<>();
    cf.complete(lista);

    final ReglaEmpleadoExternoMeta4RequestDto request =
        ReglaEmpleadoExternoMeta4RequestDto.builder().puestos(puestos).idOrganization("2").build();

    when(this.comisAsyncService.findExternosByMinIdPersona(any(RunTareaDto.class), any(TareaAmbitoDto.class),
        any(Long.class))).thenReturn(cf);

    when(this.reglaEmpleadoExternoMeta4Service.getReglasEmpleadoExternoMeta4ActivasByCclIdOrigen(any(String.class), any(String.class)))
        .thenReturn(request);

    when(this.reglaEmpleadoExternoMeta4Mapper.reglaEmpleadoExternoMeta4RequestDtotoExternosRequestDto(request))
        .thenReturn(externosRequestDTO);

    when(this.incomeMetaService.getEmpleadosExternosExcluidosDenominador(externosRequestDTO))
        .thenReturn(externos);

    when(this.idPersonaLocalExternaMapper.empleadoExternoDTOtoIdPersonaLocalExternaDto(externos))
        .thenReturn(idPersonaLocalExternaDtos);

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
