package com.inditex.rrhh.icmclcwb.model.app.ajuste.condiciones;

/*
 * Copyright (c) 2021. Inditex
 */
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.ajuste.properties.dto.RunAjustePropertiesDto;
import com.inditex.rrhh.icmclcwb.api.app.ajuste.properties.dto.RunAlgoritmoAjustePropertiesDto;
import com.inditex.rrhh.icmclcwb.api.app.async.ajustar.personas.CalculoAjusteMaximoGarantizadoAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.calcular.dto.AlgoritmoAjusteDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.EstadoTareaCalculoPersonaEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaCalculoPersonaService;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;
import com.inditex.rrhh.icmclcwb.dto.TrabajoDTO;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaCalculoAjusteMaximoGarantizadoRepositoryCustom;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.slf4j.Logger;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * javierev
 */
@ExtendWith(SpringExtension.class)
class RunAjusteMaximoGarantizadoProcesarTest {

  private final static Long ID_TAREA = 19191L;

  private final static Long ID_TRABAJO = 3232L;

  private final static Integer THREAD_SIZE = 15;

  private final static Integer BATCH_SIZE = 5;

  @Mock
  private Logger log;

  @Mock
  private RunAjustePropertiesDto runAjusteProperties;

  @Mock
  private TareaCalculoAjusteMaximoGarantizadoRepositoryCustom tareaCalculoAjusteMaximoGarantizadoRepositoryCustom;

  @Mock
  private TareaCalculoPersonaService tareaCalculoPersonaService;

  @Mock
  private CalculoAjusteMaximoGarantizadoAsyncService calculoAjusteMaximoGarantizadoAsyncService;

  @InjectMocks
  private RunAjusteMaximoGarantizadoProcesar runAjusteMaximoGarantizadoProcesar;

  @BeforeEach
  public void setup() {
    when(this.tareaCalculoAjusteMaximoGarantizadoRepositoryCustom.ids(any(TareaDto.class)))
        .thenReturn(this.createPersonaIds());
    final RunAlgoritmoAjustePropertiesDto properties = new RunAlgoritmoAjustePropertiesDto();
    properties.setThreadSize(THREAD_SIZE);
    properties.setBatchSize(BATCH_SIZE);
    when(this.runAjusteProperties.getAjuste()).thenReturn(properties);
    when(this.calculoAjusteMaximoGarantizadoAsyncService.ajustar(any(AlgoritmoAjusteDto.class),
        any(TareaDto.class),
        ArgumentMatchers.<List<IdPersonaLocalDto>>any())).thenReturn(CompletableFuture.completedFuture(
            AsyncConstants.NIL));
  }

  private RunTareaDto createRunTarea() {
    final RunTareaDto runTarea = new RunTareaDto();
    final TareaDto tarea = new TareaDto();
    tarea.setId(ID_TAREA);
    final TrabajoDTO trabajo = new TrabajoDTO();
    trabajo.setId(ID_TRABAJO);
    runTarea.setTarea(tarea);
    runTarea.setTrabajo(trabajo);
    return runTarea;
  }

  private AlgoritmoAjusteDto createAlgoritmoAjuste() {
    final AlgoritmoAjusteDto algoritmoAjuste = new AlgoritmoAjusteDto();
    algoritmoAjuste.setId(1919);
    return algoritmoAjuste;
  }

  private List<IdPersonaLocalDto> createPersonaIds() {
    return Arrays.asList(
        IdPersonaLocalDto
            .builder()
            .stdOrHrPeriod("1")
            .idPersonaLocal("767676")
            .build(),
        IdPersonaLocalDto
            .builder()
            .stdOrHrPeriod("2")
            .idPersonaLocal("121212")
            .build());
  }

  @Test
  void getSqlCalcularTest() {
    final AlgoritmoAjusteDto algoritmoAjuste = this.createAlgoritmoAjuste();
    this.runAjusteMaximoGarantizadoProcesar.getSqlCalcular(algoritmoAjuste);
    verify(this.tareaCalculoAjusteMaximoGarantizadoRepositoryCustom, times(1)).getSqlAjustar(algoritmoAjuste);
  }

  @Test
  void executeLogIdsTareaTrabajoInicioTest() {
    final RunTareaDto runTarea = this.createRunTarea();
    final AlgoritmoAjusteDto algoritmoAjuste = this.createAlgoritmoAjuste();
    this.runAjusteMaximoGarantizadoProcesar.execute(runTarea, algoritmoAjuste);

    verify(this.log, times(1)).info("Trabajo[{}]Tarea[{}] :: Inicio :: RunAjusteMaximoGarantizadoProcesar :: Ids",
        ID_TRABAJO,
        ID_TAREA);
  }

  @Test
  void executeLogIdsTareaTrabajoFinTest() {
    final RunTareaDto runTarea = this.createRunTarea();
    final AlgoritmoAjusteDto algoritmoAjuste = this.createAlgoritmoAjuste();
    this.runAjusteMaximoGarantizadoProcesar.execute(runTarea, algoritmoAjuste);

    verify(this.log, times(1)).info("Trabajo[{}]Tarea[{}] :: Fin :: RunAjusteMaximoGarantizadoProcesar :: Ids: {}",
        ID_TRABAJO,
        ID_TAREA, this.createPersonaIds());
  }

  @Test
  void executeLogInicioTest() {
    final RunTareaDto runTarea = this.createRunTarea();
    final AlgoritmoAjusteDto algoritmoAjuste = this.createAlgoritmoAjuste();
    this.runAjusteMaximoGarantizadoProcesar.execute(runTarea, algoritmoAjuste);

    verify(this.log, times(1)).info(
        "Trabajo[{}]Tarea[{}] :: Inicio :: RunAjusteMaximoGarantizadoProcesar :: Personas: {}",
        ID_TRABAJO, ID_TAREA, this.createPersonaIds().size());
  }

  @Test
  void executeLogFinTest() {
    final RunTareaDto runTarea = this.createRunTarea();
    final AlgoritmoAjusteDto algoritmoAjuste = this.createAlgoritmoAjuste();
    this.runAjusteMaximoGarantizadoProcesar.execute(runTarea, algoritmoAjuste);

    verify(this.log, times(1)).info("Fin :: RunAjusteMaximoGarantizadoProcesar :: Personas: {}",
        this.createPersonaIds().size());
  }

  @Test
  void executeIdsPersonaTest() {
    final RunTareaDto runTarea = this.createRunTarea();
    final AlgoritmoAjusteDto algoritmoAjuste = this.createAlgoritmoAjuste();
    this.runAjusteMaximoGarantizadoProcesar.execute(runTarea, algoritmoAjuste);

    verify(this.tareaCalculoAjusteMaximoGarantizadoRepositoryCustom, times(1)).ids(runTarea.getTarea());
  }

  @Test
  void executeAjustePropertiesTest() {
    final RunTareaDto runTarea = this.createRunTarea();
    final AlgoritmoAjusteDto algoritmoAjuste = this.createAlgoritmoAjuste();
    this.runAjusteMaximoGarantizadoProcesar.execute(runTarea, algoritmoAjuste);

    verify(this.runAjusteProperties, times(2)).getAjuste();
  }

  @Test
  void executeAjustarTest() {
    final RunTareaDto runTarea = this.createRunTarea();
    final AlgoritmoAjusteDto algoritmoAjuste = this.createAlgoritmoAjuste();
    this.runAjusteMaximoGarantizadoProcesar.execute(runTarea, algoritmoAjuste);

    verify(this.calculoAjusteMaximoGarantizadoAsyncService, times(1))
        .ajustar(algoritmoAjuste, runTarea.getTarea(), this.createPersonaIds());
  }

  @Test
  void executeExceptionTest() {

    final RunTareaDto runTarea = this.createRunTarea();
    final AlgoritmoAjusteDto algoritmoAjuste = this.createAlgoritmoAjuste();

    final RuntimeException exception = new RuntimeException("Exception");
    doThrow(exception)
        .when(this.calculoAjusteMaximoGarantizadoAsyncService)
        .ajustar(any(AlgoritmoAjusteDto.class), any(TareaDto.class),
            ArgumentMatchers.<List<IdPersonaLocalDto>>any());

    this.runAjusteMaximoGarantizadoProcesar.execute(runTarea, algoritmoAjuste);

    final List<IdPersonaLocalDto> personas = this.createPersonaIds();
    verify(this.log, times(1)).error("RunAjusteMaximoGarantizadoProcesar :: KO :: Personas: {}", personas.size(),
        exception);
    verify(this.tareaCalculoPersonaService, times(1)).updateWithEstadoAndidPersona(personas, runTarea,
        EstadoTareaCalculoPersonaEnum.KO.getDto());

  }

}
