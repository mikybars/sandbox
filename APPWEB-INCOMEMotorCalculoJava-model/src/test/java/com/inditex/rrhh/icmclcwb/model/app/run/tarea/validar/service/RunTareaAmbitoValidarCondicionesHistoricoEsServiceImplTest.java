package com.inditex.rrhh.icmclcwb.model.app.run.tarea.validar.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.timeout;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.async.service.ComisAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalCondicionesDto;
import com.inditex.rrhh.icmclcwb.api.app.prevalidar.properties.dto.PrevalidarPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.AccionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.FaseDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
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

/*
 * Copyright (c) 2022. Inditex
 */
@ExtendWith(SpringExtension.class)
public class RunTareaAmbitoValidarCondicionesHistoricoEsServiceImplTest {

  @Mock
  private ComisAsyncService comisAsyncService;

  @Mock
  private TareaFaseAccionService tareaFaseAccionService;

  @Mock
  private AccionService accionService;

  @Mock
  private PrimaryTemporaryTableRepositoryCustom primaryTemporaryTableRepositoryCustom;

  @Mock
  private ValidacionMapper validacionMapper;

  @Mock
  private PrevalidarPropertiesDto bajaProperties;

  @InjectMocks
  private RunTareaAmbitoValidarCondicionesHistoricoEsServiceImpl runTareaAmbitoValidarCondicionesHistoricoEsServiceImpl;

  @Test
  public void execute() {
    final RunTareaDto runTareaDto = new RunTareaDto();
    final TareaDto tareaDto = new TareaDto();
    tareaDto.setId(1L);
    runTareaDto.setTarea(tareaDto);
    final TareaAmbitoDto tareaAmbitoDto = new TareaAmbitoDto();
    final TareaFaseAccionDto tareaFaseAccionDto = new TareaFaseAccionDto();
    final FaseDto faseDto = new FaseDto();
    faseDto.setId(1);
    final AccionDto accionDto = new AccionDto();
    accionDto.setId(1);

    final List<IdPersonaLocalCondicionesDto> lista = new ArrayList<>();
    final CompletableFuture<List<IdPersonaLocalCondicionesDto>> cf = new CompletableFuture<>();
    cf.complete(lista);

    when(this.comisAsyncService.findCondicionesHistoricoEs(any(RunTareaDto.class), any(TareaAmbitoDto.class)))
        .thenReturn(cf);

    this.runTareaAmbitoValidarCondicionesHistoricoEsServiceImpl.execute(runTareaDto, tareaAmbitoDto,
        tareaFaseAccionDto);

    verify(this.comisAsyncService, timeout(1000).times(1))
        .findCondicionesHistoricoEs(
            ArgumentMatchers.any(RunTareaDto.class), ArgumentMatchers.any(TareaAmbitoDto.class));
    verify(this.primaryTemporaryTableRepositoryCustom, timeout(1000).times(1))
        .createTempComisHistorico();
    verify(this.primaryTemporaryTableRepositoryCustom, timeout(1000).times(1))
        .insertTempComisHistorico(ArgumentMatchers.any(List.class));
    verify(this.primaryTemporaryTableRepositoryCustom, timeout(1000).times(1))
        .validateTempComisHistorico(ArgumentMatchers.any(TareaDto.class));
    verify(this.primaryTemporaryTableRepositoryCustom, timeout(1000).times(1))
        .deleteTempComisHistorico();
    verify(this.validacionMapper, timeout(1000).times(1))
        .idPersonaLocalDtoTovalidacionDto(ArgumentMatchers.any(TareaAmbitoDto.class),
            ArgumentMatchers.any(TareaFaseAccionDto.class), ArgumentMatchers.any(List.class),
            ArgumentMatchers.any(PrevalidarPropertiesDto.class), ArgumentMatchers.any(TareaDto.class));
  }
}
