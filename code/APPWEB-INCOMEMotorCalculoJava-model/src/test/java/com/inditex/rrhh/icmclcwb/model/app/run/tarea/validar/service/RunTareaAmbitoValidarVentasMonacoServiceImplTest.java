package com.inditex.rrhh.icmclcwb.model.app.run.tarea.validar.service;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.dto.ValidacionDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.async.service.RunTareaRecolectarPtrMonacoAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaAmbitoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaFaseAccionDto;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;
import com.inditex.rrhh.icmclcwb.model.app.run.tarea.validar.mapper.ValidacionMapper;

import org.instancio.Instancio;
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
@ExtendWith({SpringExtension.class})
class RunTareaAmbitoValidarVentasMonacoServiceImplTest {

  @Mock
  private RunTareaRecolectarPtrMonacoAsyncService ventasMonacoService;

  @Mock
  private ValidacionMapper validacionMapper;

  @Spy
  @InjectMocks
  private RunTareaAmbitoValidarVentasMonacoServiceImpl runTareaAmbitoValidarVentasMonacoService;

  final RunTareaDto runTarea = Instancio.create(RunTareaDto.class);

  final TareaAmbitoDto tareaAmbito = Instancio.create(TareaAmbitoDto.class);

  final TareaFaseAccionDto tareaFaseAccion = Instancio.create(TareaFaseAccionDto.class);

  final TareaFaseAccionDto tareaFaseAccion2 = Instancio.create(TareaFaseAccionDto.class);

  final ValidacionDto validacion = Instancio.create(ValidacionDto.class);

  @BeforeAll
  void setup() {
    this.runTarea.getTarea().setStdIdLegEnt("1");
    this.tareaAmbito.setCclIdOrigen("2");
  }

  @Test
  void executeTest() {

    final CompletableFuture<Void> completableFuture = CompletableFuture.completedFuture(AsyncConstants.NIL);
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
