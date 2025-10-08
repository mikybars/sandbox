// code/APPWEB-INCOMEMotorCalculoJava-model/src/test/java/com/inditex/rrhh/icmclcwb/model/app/run/tarea/validar/service/RunTareaValidarPorcentajeServiceImplTest.java
package com.inditex.rrhh.icmclcwb.model.app.run.tarea.validar.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.dto.ValidacionDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.validar.service.RunTareaAmbitoValidarPorcentajeService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.EstadoTareaFaseAccionEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaFaseAccionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.AccionService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaFaseAccionService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class RunTareaValidarPorcentajeServiceImplTest {

  @InjectMocks
  private RunTareaValidarPorcentajeServiceImpl service;

  @Mock
  private TareaFaseAccionService tareaFaseAccionService;

  @Mock
  private AccionService accionService;

  @Mock
  private RunTareaAmbitoValidarPorcentajeService runTareaAmbitoValidarPorcentajeServiceService;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  void execute_ok() {
    // Arrange
    final RunTareaDto runTarea = new RunTareaDto();
    final TareaDto tareaDto = new TareaDto();
    tareaDto.setId(1L);
    tareaDto.setStdIdLegEnt("LEG");
    runTarea.setTarea(tareaDto);

    final TareaAmbitoDto ambito = new TareaAmbitoDto();
    ambito.setCclIdOrigen("ORIGEN");
    ambito.setIdTarea(1L);
    runTarea.setTarea(tareaDto);
    runTarea.getTarea().setAmbito(List.of(ambito));

    final TareaFaseAccionDto faseAccion = new TareaFaseAccionDto();
    faseAccion.setIdAccion(10);

    when(this.accionService.findByIdAccionAndIdOrigenAndStdIdLegEnt(any(), any(), any()))
        .thenReturn(true);

    final ValidacionDto validacion = new ValidacionDto();
    validacion.setResult(Boolean.TRUE);
    when(this.runTareaAmbitoValidarPorcentajeServiceService.execute(runTarea, ambito, faseAccion))
        .thenReturn(validacion);

    // Act
    final CompletableFuture<List<ValidacionDto>> result = this.service.execute(runTarea, faseAccion);

    // Assert
    assertNotNull(result);
    assertEquals(1, result.join().size());
    verify(this.tareaFaseAccionService).updateFechaInicio(faseAccion);
    verify(this.tareaFaseAccionService).updateFechaFinAndEstado(faseAccion, EstadoTareaFaseAccionEnum.OK.getDto());
  }

  @Test
  void execute_noValidaciones() {
    // Arrange
    final RunTareaDto runTarea = new RunTareaDto();
    final TareaDto tareaDto = new TareaDto();
    tareaDto.setId(1L);
    tareaDto.setStdIdLegEnt("LEG");
    runTarea.setTarea(tareaDto);

    runTarea.getTarea().setAmbito(List.of()); // Sin ámbitos

    final TareaFaseAccionDto faseAccion = new TareaFaseAccionDto();

    // Act
    final CompletableFuture<List<ValidacionDto>> result = this.service.execute(runTarea, faseAccion);

    // Assert
    assertNotNull(result);
    assertTrue(result.join().isEmpty());
    verify(this.tareaFaseAccionService).updateFechaInicio(faseAccion);
    verify(this.tareaFaseAccionService).updateFechaFinAndEstado(faseAccion, EstadoTareaFaseAccionEnum.NO_EJECUTADA.getDto());
  }
}
