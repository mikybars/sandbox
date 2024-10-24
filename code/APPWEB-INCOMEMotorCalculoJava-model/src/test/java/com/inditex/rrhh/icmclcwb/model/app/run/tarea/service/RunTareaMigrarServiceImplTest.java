package com.inditex.rrhh.icmclcwb.model.app.run.tarea.service;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.migrar.RunTareaMigrarAsyncService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class RunTareaMigrarServiceImplTest {

  @Mock
  private RunTareaMigrarAsyncService runTareaMigrarAsyncService;

  @InjectMocks
  private RunTareaMigrarServiceImpl runTareaMigrarService;

  private RunTareaDto createRunTarea() {
    return new RunTareaDto();
  }

  @BeforeEach
  public void setup() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  void runShouldInvokeMigrarListCalculoComision() {
    final RunTareaDto runTarea = this.createRunTarea();
    final CompletableFuture<Void> future = CompletableFuture.completedFuture(null);
    when(this.runTareaMigrarAsyncService.migrarListCalculoComision(runTarea)).thenReturn(future);

    this.runTareaMigrarService.run(runTarea);

    verify(this.runTareaMigrarAsyncService, times(1)).migrarListCalculoComision(runTarea);
  }

  @Test
  void runShouldInvokeMigrarListCalculoComisionCatch1() {
      final RunTareaDto runTarea = this.createRunTarea();
      when(runTareaMigrarAsyncService.migrarListCalculoComision(any())).thenThrow(new RuntimeException());

      Exception exception = assertThrows(Exception.class, () -> {
          this.runTareaMigrarService.run(runTarea);
      });

      assertTrue(exception instanceof RuntimeException);
  }

}
