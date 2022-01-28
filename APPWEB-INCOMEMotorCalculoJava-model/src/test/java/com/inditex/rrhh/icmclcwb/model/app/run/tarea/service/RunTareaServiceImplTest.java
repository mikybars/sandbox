/*
 * Copyright (c) 2021. Inditex
 */

package com.inditex.rrhh.icmclcwb.model.app.run.tarea.service;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import com.inditex.rrhh.icmclcwb.api.app.TipoAmbitoEnum;
import com.inditex.rrhh.icmclcwb.api.app.exception.ValidationNoReintentoException;
import com.inditex.rrhh.icmclcwb.api.app.exception.ValidationReintentoException;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.limpiar.consolidar.service.RunTareaLimpiarConsolidarByAmbitoService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.service.RunTareaAjustarService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.service.RunTareaCalcularService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.service.RunTareaConsolidarService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.service.RunTareaNormalizarService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.service.RunTareaProcesarService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.service.RunTareaRecolectarService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.service.RunTareaRecolectarValidarService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.service.RunTareaRegularizarChallengeService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.service.RunTareaRegularizarService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.EstadoTareaCalculoPersonaEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.EstadoTareaEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaCalculoPersonaService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaFaseAccionService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaFaseService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaService;
import com.inditex.rrhh.icmclcwb.dto.TipoAmbitoDTO;
import com.inditex.rrhh.icmclcwb.dto.TrabajoDTO;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class RunTareaServiceImplTest {

  @Mock
  private TareaCalculoPersonaService tareaCalculoPersonaService;

  @Mock
  private RunTareaRecolectarService runTareaRecolectarService;

  @Mock
  private RunTareaProcesarService runTareaProcesarService;

  @Mock
  private RunTareaCalcularService runTareaCalcularService;

  @Mock
  private RunTareaConsolidarService runTareaConsolidarService;

  @Mock
  private RunTareaRecolectarValidarService runTareaRecolectarValidarService;

  @Mock
  private RunTareaRegularizarService runTareaRegularizarService;

  @Mock
  private RunTareaRegularizarChallengeService runTareaRegularizarChallengeService;

  @Mock
  private RunTareaLimpiarConsolidarByAmbitoService runTareaLimpiarConsolidarByAmbitoService;

  @Mock
  private RunTareaAjustarService runTareaAjustarService;

  @Mock
  private RunTareaNormalizarService runTareaNormalizarService;

  @Mock
  private TareaService tareaService;

  @Mock
  private TareaFaseService tareaFaseService;

  @Mock
  private TareaFaseAccionService tareaFaseAccionService;

  @InjectMocks
  private RunTareaServiceImpl runTareaService;

  private RunTareaDto createRunTarea() {
    final RunTareaDto runTarea = new RunTareaDto();
    runTarea.setTarea(new TareaDto());
    final TrabajoDTO trabajoDto = new TrabajoDTO();
    final TipoAmbitoDTO tipoAmbito = new TipoAmbitoDTO();
    tipoAmbito.setId(TipoAmbitoEnum.SOCIEDAD.getId());
    trabajoDto.setTipoAmbito(tipoAmbito);
    runTarea.setTrabajo(trabajoDto);
    return runTarea;
  }

  @Test
  void runNormalizarTest() {
    final RunTareaDto runTarea = this.createRunTarea();
    this.runTareaService.run(runTarea);
    verify(this.runTareaNormalizarService, times(1)).run(runTarea);
    verify(this.tareaService, times(1)).updateFechaFin(runTarea.getTarea());
  }

  @Test
  void runNormalizarExceptionTest() {
    final RunTareaDto runTarea = this.createRunTarea();
    doThrow(new RuntimeException("e")).when(this.runTareaNormalizarService).run(any(RunTareaDto.class));
    assertThrows(RuntimeException.class, () -> this.runTareaService.run(runTarea));
    verify(this.tareaCalculoPersonaService, times(1)).updateWithEstado(runTarea,
        EstadoTareaCalculoPersonaEnum.PENDIENTE.getDto(), EstadoTareaCalculoPersonaEnum.KO.getDto());
    verify(this.tareaService, times(1)).updateEstado(runTarea.getTarea(), EstadoTareaEnum.ERROR.getDto());
    verify(this.tareaService, times(1)).updateFechaFin(runTarea.getTarea());
  }

  @Test
  void runValidationExceptionTest() {
    final RunTareaDto runTarea = this.createRunTarea();
    doThrow(new ValidationNoReintentoException("e")).when(this.runTareaNormalizarService).run(any(RunTareaDto.class));
    this.runTareaService.run(runTarea);
    verify(this.tareaCalculoPersonaService, times(1)).updateWithEstado(runTarea,
        EstadoTareaCalculoPersonaEnum.PENDIENTE.getDto(), EstadoTareaCalculoPersonaEnum.KO.getDto());
    verify(this.tareaCalculoPersonaService, times(1)).updateWithEstado(runTarea,
        EstadoTareaCalculoPersonaEnum.PENDIENTE.getDto(),
        EstadoTareaCalculoPersonaEnum.KO.getDto());
    verify(this.runTareaConsolidarService, times(1)).run(runTarea);
    verify(this.tareaService, times(1)).updateEstado(runTarea.getTarea(), EstadoTareaEnum.ERROR_VALIDANDO.getDto());
    verify(this.tareaService, times(1)).updateFechaFin(runTarea.getTarea());
  }

  @Test
  void runValidationReintentoExceptionTest() {
    final RunTareaDto runTarea = this.createRunTarea();
    doThrow(new ValidationReintentoException("e")).when(this.runTareaNormalizarService).run(any(RunTareaDto.class));
    this.runTareaService.run(runTarea);
    verify(this.tareaFaseService, times(1)).create(runTarea);
    verify(this.runTareaAjustarService, times(1)).run(runTarea);

  }

}
