
package com.inditex.rrhh.icmclcwb.model.app.run.tarea.regularizar.async.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.regularizar.service.RunTareaRegularizarCalculoService;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class RunTareaRegularizarCalculoAsyncServiceImplTest {

  @Mock
  RunTareaRegularizarCalculoService runTareaRegularizarCalculoService;

  @InjectMocks
  RunTareaRegularizarCalculoAsyncServiceImpl runTareaRegularizarCalculoAsyncServiceImpl;

  @Test
  void normalizarAjusteComisionTest() {
    final RunTareaDto runTarea = new RunTareaDto();

    final CompletableFuture<Void> result = this.runTareaRegularizarCalculoAsyncServiceImpl
        .regularizarCalculoMejorOpcion(runTarea);
    verify(this.runTareaRegularizarCalculoService, times(1)).regularizarCalculoMejorOpcion(runTarea);

    try {
      assertEquals(AsyncConstants.NIL, result.get());
    } catch (final ExecutionException | InterruptedException e) {
      fail("Se ha producido una excepción que no debería ocurrir.");
    }
  }

  @Test
  void regularizarMejorOpcionSinFechasTest() {
    final RunTareaDto runTarea = new RunTareaDto();

    final CompletableFuture<Void> result = this.runTareaRegularizarCalculoAsyncServiceImpl
        .regularizarMejorOpcionSinFechas(runTarea);
    verify(this.runTareaRegularizarCalculoService, times(1)).regularizarMejorOpcionSinFechas(runTarea);

    try {
      assertEquals(AsyncConstants.NIL, result.get());
    } catch (final ExecutionException | InterruptedException e) {
      fail("Se ha producido una excepción que no debería ocurrir.");
    }
  }

  @Test
  void regularizarMejorOpcionSinFechasTodoPeriodoTest() {
    final RunTareaDto runTarea = new RunTareaDto();

    final CompletableFuture<Void> result = this.runTareaRegularizarCalculoAsyncServiceImpl
        .regularizarMejorOpcionSinFechasTodoPeriodo(runTarea);
    verify(this.runTareaRegularizarCalculoService, times(1)).regularizarMejorOpcionSinFechasTodoPeriodo(runTarea);

    try {
      assertEquals(AsyncConstants.NIL, result.get());
    } catch (final ExecutionException | InterruptedException e) {
      fail("Se ha producido una excepción que no debería ocurrir.");
    }
  }

}
