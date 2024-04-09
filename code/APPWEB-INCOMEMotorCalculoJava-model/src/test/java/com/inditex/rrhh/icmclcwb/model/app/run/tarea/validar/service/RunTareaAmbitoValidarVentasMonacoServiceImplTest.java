package com.inditex.rrhh.icmclcwb.model.app.run.tarea.validar.service;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.concurrent.CompletableFuture;

import com.inditex.amigafwk.test.randomizer.Random;
import com.inditex.amigafwk.test.randomizer.RandomizerExtension;
import com.inditex.rrhh.icmclcwb.api.app.dto.ValidacionDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.async.service.RunTareaRecolectarPtrMonacoAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaFaseAccionDto;
import com.inditex.rrhh.icmclcwb.model.app.run.tarea.validar.mapper.ValidacionMapper;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@TestInstance(Lifecycle.PER_CLASS)
@ExtendWith({SpringExtension.class, RandomizerExtension.class})
class RunTareaAmbitoValidarVentasMonacoServiceImplTest {

  @Mock
  private RunTareaRecolectarPtrMonacoAsyncService ventasMonacoService;

  @Mock
  private ValidacionMapper validacionMapper;

  @Spy
  @InjectMocks
  private RunTareaAmbitoValidarVentasMonacoServiceImpl runTareaAmbitoValidarVentasMonacoService;

  @Random
  private RunTareaDto runTarea;

  @Random
  private TareaAmbitoDto tareaAmbito;

  @Random
  private TareaFaseAccionDto tareaFaseAccion;

  @Random
  private TareaFaseAccionDto tareaFaseAccion2;

  @Random
  private ValidacionDto validacion;

  @BeforeAll
  void setup() {
    this.runTarea.getTarea().setStdIdLegEnt("1");
    this.tareaAmbito.setCclIdOrigen("2");
  }

  @Test
  void executeTest(@Random final CompletableFuture<Void> completableFuture) {

    doReturn(completableFuture).when(this.ventasMonacoService)
        .ventaFisicaLocalizacionSeccionByRunTarea(this.runTarea);

    doReturn(completableFuture).when(this.ventasMonacoService)
        .ventaOnlineIpodLocalizacionSeccionByRunTarea(this.runTarea);

    doReturn(completableFuture).when(this.ventasMonacoService)
        .ventaOnlinePickingLocalizacionSeccionByRunTarea(this.runTarea);

    doReturn(completableFuture).when(this.ventasMonacoService)
        .ventaOnlineEntregaTiendaLocalizacionSeccionByRunTarea(this.runTarea);

    doReturn(completableFuture).when(this.ventasMonacoService)
        .ventaFisicaLocalizacionSeccionRepartoOnlineByRunTarea(this.runTarea);

    doReturn(completableFuture).when(this.ventasMonacoService)
        .presenciaDetallePersonaIncluidoCommerceByRunTarea(this.runTarea);

    doReturn(completableFuture).when(this.ventasMonacoService)
        .presenciaDetalleComisionablePersonaByRunTarea(this.runTarea);

    doReturn(this.validacion).when(this.validacionMapper).booleanToValidacionDto(this.tareaAmbito, this.tareaFaseAccion, true);

    this.runTareaAmbitoValidarVentasMonacoService.execute(this.runTarea, this.tareaAmbito, this.tareaFaseAccion);

    verify(this.runTareaAmbitoValidarVentasMonacoService, times(1))
        .execute(this.runTarea, this.tareaAmbito, this.tareaFaseAccion);

  }

  @Test
  void executeExceptionTest() {

    doThrow(new RuntimeException()).when(this.ventasMonacoService)
        .ventaFisicaLocalizacionSeccionByRunTarea(this.runTarea);

    assertThrows(RuntimeException.class, () -> {
      this.runTareaAmbitoValidarVentasMonacoService.execute(this.runTarea, this.tareaAmbito, this.tareaFaseAccion2);
    });
  }

}
