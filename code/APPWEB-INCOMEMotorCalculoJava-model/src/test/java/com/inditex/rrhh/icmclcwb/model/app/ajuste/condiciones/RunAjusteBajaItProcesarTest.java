package com.inditex.rrhh.icmclcwb.model.app.ajuste.condiciones;

/*
 * Copyright (c) 2021. Inditex
 */
import static org.junit.jupiter.api.Assertions.assertEquals;
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
import com.inditex.rrhh.icmclcwb.api.app.async.ajustar.personas.CalculoAjusteBajaItAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.calcular.dto.AlgoritmoAjusteDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.EstadoTareaCalculoPersonaEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaCalculoPersonaService;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;
import com.inditex.rrhh.icmclcwb.dto.TrabajoDTO;
import com.inditex.rrhh.icmclcwb.model.primary.repository.PrimaryTemporaryTablePoliticasRepositoryCustomImpl;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaCalculoAjusteBajaItRepositoryCustom;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.read.ListAppender;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class RunAjusteBajaItProcesarTest {

  private final static Long ID_TAREA = 19191L;

  private final static Long ID_TRABAJO = 3232L;

  private final static Integer THREAD_SIZE = 15;

  private final static Integer BATCH_SIZE = 5;

  @Mock
  private Logger log;

  @Mock
  private RunAjustePropertiesDto runAjusteProperties;

  @Mock
  private TareaCalculoAjusteBajaItRepositoryCustom tareaCalculoAjusteBajaItRepositoryCustom;

  @Mock
  private CalculoAjusteBajaItAsyncService calculoAjusteBajaItAsyncService;

  @Mock
  private TareaCalculoPersonaService tareaCalculoPersonaService;

  @Mock
  private PrimaryTemporaryTablePoliticasRepositoryCustomImpl primaryTemporaryTablePoliticasRepositoryCustom;

  @InjectMocks
  private RunAjusteBajaItProcesar runAjusteBajaItProcesar;

  private ListAppender<ILoggingEvent> listAppender;

  @BeforeEach
  public void setup() {
    final ch.qos.logback.classic.Logger logger =
        (ch.qos.logback.classic.Logger) LoggerFactory
            .getLogger(RunAjusteBajaItProcesar.class);

    this.listAppender = new ListAppender<>();
    this.listAppender.start();
    logger.addAppender(this.listAppender);

    when(this.tareaCalculoAjusteBajaItRepositoryCustom.ids(any(TareaDto.class)))
        .thenReturn(this.createPersonaIds());
    final RunAlgoritmoAjustePropertiesDto properties = new RunAlgoritmoAjustePropertiesDto();
    properties.setThreadSize(THREAD_SIZE);
    properties.setBatchSize(BATCH_SIZE);
    when(this.runAjusteProperties.getAjuste()).thenReturn(properties);
    when(this.calculoAjusteBajaItAsyncService.ajustar(any(AlgoritmoAjusteDto.class), any(TareaDto.class),
        ArgumentMatchers.any())).thenReturn(CompletableFuture.completedFuture(
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
    this.runAjusteBajaItProcesar.getSqlCalcular(algoritmoAjuste);
    verify(this.tareaCalculoAjusteBajaItRepositoryCustom, times(1)).getSqlAjustar(algoritmoAjuste);
  }

  @Test
  void executeLogIdsTareaTrabajoInicioTest() {
    final RunTareaDto runTarea = this.createRunTarea();
    final AlgoritmoAjusteDto algoritmoAjuste = this.createAlgoritmoAjuste();
    this.runAjusteBajaItProcesar.execute(runTarea, algoritmoAjuste);

    assertEquals(4, this.listAppender.list.size());
    assertEquals(Level.INFO, this.listAppender.list.get(0).getLevel());
    assertEquals("Fin :: RunAjusteBajaItProcesar :: Personas: {}", this.listAppender.list.get(3).getMessage());
  }

  @Test
  void executeLogIdsTareaTrabajoFinTest() {
    final RunTareaDto runTarea = this.createRunTarea();
    final AlgoritmoAjusteDto algoritmoAjuste = this.createAlgoritmoAjuste();
    this.runAjusteBajaItProcesar.execute(runTarea, algoritmoAjuste);

    assertEquals(4, this.listAppender.list.size());
    assertEquals(Level.INFO, this.listAppender.list.get(0).getLevel());
    assertEquals("Fin :: RunAjusteBajaItProcesar :: Personas: {}", this.listAppender.list.get(3).getMessage());
  }

  @Test
  void executeLogInicioTest() {
    final RunTareaDto runTarea = this.createRunTarea();
    final AlgoritmoAjusteDto algoritmoAjuste = this.createAlgoritmoAjuste();
    this.runAjusteBajaItProcesar.execute(runTarea, algoritmoAjuste);

    assertEquals(4, this.listAppender.list.size());
    assertEquals(Level.INFO, this.listAppender.list.get(0).getLevel());
    assertEquals("Fin :: RunAjusteBajaItProcesar :: Personas: {}", this.listAppender.list.get(3).getMessage());
  }

  @Test
  void executeLogFinTest() {
    final RunTareaDto runTarea = this.createRunTarea();
    final AlgoritmoAjusteDto algoritmoAjuste = this.createAlgoritmoAjuste();
    this.runAjusteBajaItProcesar.execute(runTarea, algoritmoAjuste);

    assertEquals(4, this.listAppender.list.size());
    assertEquals(Level.INFO, this.listAppender.list.get(0).getLevel());
    assertEquals("Fin :: RunAjusteBajaItProcesar :: Personas: {}", this.listAppender.list.get(3).getMessage());
  }

  @Test
  void executeIdsPersonaTest() {
    final RunTareaDto runTarea = this.createRunTarea();
    final AlgoritmoAjusteDto algoritmoAjuste = this.createAlgoritmoAjuste();
    this.runAjusteBajaItProcesar.execute(runTarea, algoritmoAjuste);

    verify(this.tareaCalculoAjusteBajaItRepositoryCustom, times(1)).ids(runTarea.getTarea());
  }

  @Test
  void executeAjustePropertiesTest() {
    final RunTareaDto runTarea = this.createRunTarea();
    final AlgoritmoAjusteDto algoritmoAjuste = this.createAlgoritmoAjuste();
    this.runAjusteBajaItProcesar.execute(runTarea, algoritmoAjuste);

    verify(this.runAjusteProperties, times(2)).getAjuste();
  }

  @Test
  void executeAjustarTest() {
    final RunTareaDto runTarea = this.createRunTarea();
    final AlgoritmoAjusteDto algoritmoAjuste = this.createAlgoritmoAjuste();
    this.runAjusteBajaItProcesar.execute(runTarea, algoritmoAjuste);

    verify(this.calculoAjusteBajaItAsyncService, times(1))
        .ajustar(algoritmoAjuste, runTarea.getTarea(), this.createPersonaIds());
  }

  @Test
  void executeExceptionTest() {

    final RunTareaDto runTarea = this.createRunTarea();
    final AlgoritmoAjusteDto algoritmoAjuste = this.createAlgoritmoAjuste();

    final RuntimeException exception = new RuntimeException("Exception");
    doThrow(exception)
        .when(this.calculoAjusteBajaItAsyncService)
        .ajustar(any(AlgoritmoAjusteDto.class), any(TareaDto.class),
            ArgumentMatchers.any());

    this.runAjusteBajaItProcesar.execute(runTarea, algoritmoAjuste);

    final List<IdPersonaLocalDto> personas = this.createPersonaIds();
    assertEquals(5, this.listAppender.list.size());
    assertEquals(Level.INFO, this.listAppender.list.get(0).getLevel());
    assertEquals("RunAjusteBajaItProcesar :: KO :: Personas: {}", this.listAppender.list.get(3).getMessage());

    verify(this.tareaCalculoPersonaService, times(1)).updateWithEstadoAndidPersona(personas, runTarea,
        EstadoTareaCalculoPersonaEnum.KO.getDto());

  }

}
