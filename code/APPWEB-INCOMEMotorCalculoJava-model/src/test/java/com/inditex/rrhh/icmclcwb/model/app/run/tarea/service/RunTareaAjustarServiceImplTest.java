package com.inditex.rrhh.icmclcwb.model.app.run.tarea.service;

/*
 * Copyright (c) 2021. Inditex
 */
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.ajuste.properties.dto.RunAjustePropertiesDto;
import com.inditex.rrhh.icmclcwb.api.app.calcular.dto.AlgoritmoAjusteDto;
import com.inditex.rrhh.icmclcwb.api.app.calcular.service.AlgoritmoAjusteService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.EstadoTareaFaseEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.FaseEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaFaseDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaFaseService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaPersonaEstructuraPoliticaService;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;
import com.inditex.rrhh.icmclcwb.model.app.calcular.RunAjusteAsync;
import com.inditex.rrhh.icmclcwb.model.app.calcular.RunAjusteFactory;
import com.inditex.rrhh.icmclcwb.model.primary.repository.PrimaryTemporaryTablePoliticasRepositoryCustom;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class RunTareaAjustarServiceImplTest {

  public static final long ID_TAREA = 1919L;

  public static final String NOMBRE_ALGORITMO_AJUSTE = "NOMBRE ALGORITMO AJUSTE";

  @Mock
  private RunAjustePropertiesDto runAjusteProperties;

  @Mock
  private AlgoritmoAjusteService algoritmoAjusteService;

  @Mock
  private RunAjusteFactory runAjusteFactory;

  @Mock
  private TareaFaseService tareaFaseService;

  @Mock
  private RunAjusteAsync runAjuste;

  @Mock
  private TareaPersonaEstructuraPoliticaService tareaPersonaEstructuraPoliticaService;

  @Mock
  private PrimaryTemporaryTablePoliticasRepositoryCustom primaryTemporaryTablePoliticasRepositoryCustom;

  @InjectMocks
  private RunTareaAjustarServiceImpl runTareaAjustarService;

  @BeforeEach
  void setup() {
    when(this.runAjuste.execute(any(RunTareaDto.class), any(AlgoritmoAjusteDto.class)))
        .thenReturn(CompletableFuture.completedFuture(
            AsyncConstants.NIL));
    when(this.runAjusteFactory.getRunAjuste(any(String.class))).thenReturn(this.runAjuste);
    when(this.runAjusteProperties.getThreadSize()).thenReturn(1);
    when(this.algoritmoAjusteService.customFindAjustePesosByTarea(any(Long.class))).thenReturn(
        Collections.singletonList(1L));
    when(this.algoritmoAjusteService.customFindAjusteIdsByTareaAndPeso(any(Long.class), any(Long.class)))
        .thenReturn(Collections.singletonList(4));
    final AlgoritmoAjusteDto ajuste = new AlgoritmoAjusteDto();
    ajuste.setNombre(NOMBRE_ALGORITMO_AJUSTE);
    when(this.algoritmoAjusteService.findById(any(Integer.class))).thenReturn(ajuste);
  }

  private RunTareaDto createRunTarea() {
    final RunTareaDto runTarea = new RunTareaDto();
    final TareaDto tarea = this.createTarea();
    runTarea.setTarea(tarea);
    return runTarea;
  }

  private TareaDto createTarea() {
    final TareaDto tarea = new TareaDto();
    tarea.setId(ID_TAREA);
    return tarea;
  }

  @Test
  void runUpdateFechaInicioTest() {

    final RunTareaDto runTarea = this.createRunTarea();
    final TareaFaseDto fase = TareaFaseDto.builder().id(199L).activo(true).build();
    when(this.tareaFaseService.findTareaFaseDtoByIdTareaAndIdFase(any(Long.class), any(Integer.class)))
        .thenReturn(fase);

    this.runTareaAjustarService.run(runTarea);

    verify(this.tareaFaseService, times(2)).findTareaFaseDtoByIdTareaAndIdFase(ID_TAREA, FaseEnum.AJUSTAR.getId());
    verify(this.tareaFaseService, times(1)).updateFechaInicio(fase);

  }

  @Test
  void runUpdateFechaFinAndEstadoTest() {

    final RunTareaDto runTarea = this.createRunTarea();
    final TareaFaseDto fase = TareaFaseDto.builder().id(199L).activo(true).build();
    when(this.tareaFaseService.findTareaFaseDtoByIdTareaAndIdFase(any(Long.class), any(Integer.class)))
        .thenReturn(fase);

    this.runTareaAjustarService.run(runTarea);

    verify(this.tareaFaseService, times(2)).findTareaFaseDtoByIdTareaAndIdFase(ID_TAREA, FaseEnum.AJUSTAR.getId());
    verify(this.tareaFaseService, times(1)).updateFechaFinAndEstado(fase, EstadoTareaFaseEnum.OK.getDto());

  }

  @Test
  void runCustomFindAjustePesosByTareaTest() {

    final RunTareaDto runTarea = this.createRunTarea();
    this.runTareaAjustarService.run(runTarea);
    verify(this.algoritmoAjusteService, times(1)).customFindAjustePesosByTarea(ID_TAREA);

  }

  @Test
  void runCustomFindAjusteIdsByTareaAndPesoTest() {

    final RunTareaDto runTarea = this.createRunTarea();

    when(this.algoritmoAjusteService.customFindAjustePesosByTarea(any(Long.class)))
        .thenReturn(Arrays.asList(1L, 2L, 3L));

    this.runTareaAjustarService.run(runTarea);

    verify(this.algoritmoAjusteService, times(1)).customFindAjusteIdsByTareaAndPeso(ID_TAREA, 1L);
    verify(this.algoritmoAjusteService, times(1)).customFindAjusteIdsByTareaAndPeso(ID_TAREA, 2L);
    verify(this.algoritmoAjusteService, times(1)).customFindAjusteIdsByTareaAndPeso(ID_TAREA, 3L);

  }

  @Test
  void runAlgoritmoAjusteFindByIdTest() {

    final RunTareaDto runTarea = this.createRunTarea();

    when(this.algoritmoAjusteService.customFindAjusteIdsByTareaAndPeso(any(Long.class), any(Long.class)))
        .thenReturn(Arrays.asList(4, 5, 6));

    this.runTareaAjustarService.run(runTarea);

    verify(this.algoritmoAjusteService, times(1)).findById(4);
    verify(this.algoritmoAjusteService, times(1)).findById(5);
    verify(this.algoritmoAjusteService, times(1)).findById(6);

  }

  @Test
  void runGetRunAjusteTest() {

    final RunTareaDto runTarea = this.createRunTarea();
    this.runTareaAjustarService.run(runTarea);
    verify(this.runAjusteFactory, times(1)).getRunAjuste(NOMBRE_ALGORITMO_AJUSTE);

  }

  @Test
  void runExecuteTest() {

    final RunTareaDto runTarea = this.createRunTarea();
    final AlgoritmoAjusteDto ajuste = new AlgoritmoAjusteDto();
    ajuste.setNombre(NOMBRE_ALGORITMO_AJUSTE);
    ajuste.setId(111);
    when(this.algoritmoAjusteService.findById(any(Integer.class))).thenReturn(ajuste);
    this.runTareaAjustarService.run(runTarea);
    verify(this.runAjuste, times(1)).execute(runTarea, ajuste);

  }

}
