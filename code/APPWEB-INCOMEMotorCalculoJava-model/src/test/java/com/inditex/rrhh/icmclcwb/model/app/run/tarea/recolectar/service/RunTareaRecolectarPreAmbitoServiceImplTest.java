package com.inditex.rrhh.icmclcwb.model.app.run.tarea.recolectar.service;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.async.service.RunTareaRecolectarMeta4IcmWsCalcIncomeAsyncService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class RunTareaRecolectarPreAmbitoServiceImplTest {
  @Mock
  private RunTareaRecolectarMeta4IcmWsCalcIncomeAsyncService runTareaRecolectarMeta4IcmWsCalcIncomeAsyncService;

  @InjectMocks
  private RunTareaRecolectarPreAmbitoServiceImpl runTareaRecolectarPreAmbitoService;

  @Test
  void runTest() {
    final RunTareaDto runTarea = new RunTareaDto();
    final CompletableFuture<Void> cf = new CompletableFuture<>();
    cf.complete(null);
    when(this.runTareaRecolectarMeta4IcmWsCalcIncomeAsyncService.fechaAmbitoAndEmpresaByRunTarea(any(RunTareaDto.class))).thenReturn(cf);

    this.runTareaRecolectarPreAmbitoService.run(runTarea);

    verify(this.runTareaRecolectarMeta4IcmWsCalcIncomeAsyncService).fechaAmbitoAndEmpresaByRunTarea(any(RunTareaDto.class));
  }

  @Test
  void runExceptionTest() {
    doThrow(new RuntimeException("EE")).when(this.runTareaRecolectarMeta4IcmWsCalcIncomeAsyncService).fechaAmbitoAndEmpresaByRunTarea(any(
        RunTareaDto.class));
    final RunTareaDto runTarea = new RunTareaDto();
    assertThrows(RuntimeException.class, () -> this.runTareaRecolectarPreAmbitoService.run(runTarea));
  }
}
