
package com.inditex.rrhh.icmclcwb.model.app.run.tarea.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.regularizar.async.service.RunTareaRegularizarCalculoAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.EstadoTareaFaseDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaFaseDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaFaseService;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class RunTareaRegularizarServiceImplTest {

  @Mock
  private RunTareaRegularizarCalculoAsyncService runTareaRegularizarCalculoAsyncService;

  @Mock
  private TareaFaseService tareaFaseService;

  @InjectMocks
  private RunTareaRegularizarServiceImpl runTareaRegularizarService;

  @BeforeEach
  public void setup() {
    when(this.tareaFaseService.findTareaFaseDtoByIdTareaAndIdFase(any(Long.class), any(Integer.class)))
        .thenReturn(TareaFaseDto
            .builder()
            .estadoTareaFase(EstadoTareaFaseDto.builder().id(111).build())
            .activo(Boolean.TRUE)
            .build());

    when(this.runTareaRegularizarCalculoAsyncService.regularizarCalculoMejorOpcion(any(RunTareaDto.class)))
        .thenReturn(
            CompletableFuture.completedFuture(AsyncConstants.NIL));
    when(this.runTareaRegularizarCalculoAsyncService.regularizarMejorOpcionSinFechas(any(RunTareaDto.class)))
        .thenReturn(
            CompletableFuture.completedFuture(AsyncConstants.NIL));
    when(this.runTareaRegularizarCalculoAsyncService
        .regularizarMejorOpcionSinFechasTodoPeriodo(any(RunTareaDto.class)))
            .thenReturn(
                CompletableFuture.completedFuture(AsyncConstants.NIL));
  }

  @Test
  void run() {
    final RunTareaDto runTarea = new RunTareaDto();
    final TareaDto tarea = new TareaDto();
    tarea.setId(1L);
    runTarea.setTarea(tarea);
    this.runTareaRegularizarService.run(runTarea);

    verify(this.runTareaRegularizarCalculoAsyncService, times(1)).regularizarCalculoMejorOpcion(runTarea);
    verify(this.runTareaRegularizarCalculoAsyncService, times(1)).regularizarMejorOpcionSinFechas(runTarea);
    verify(this.runTareaRegularizarCalculoAsyncService, times(1))
        .regularizarMejorOpcionSinFechasTodoPeriodo(runTarea);

  }

}
