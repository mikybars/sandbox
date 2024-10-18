package com.inditex.rrhh.icmclcwb.model.run.tarea.migrar;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaMigrarService;
import com.inditex.rrhh.icmclcwb.model.app.run.tarea.migrar.RunTareaMigrarAsyncServiceImpl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class RunTareaMigrarAsyncServiceImplTest {

  @Mock
  private TareaMigrarService tareaMigrarService;

  @InjectMocks
  private RunTareaMigrarAsyncServiceImpl runTareaMigrarAsyncServiceImpl;

  @Test
  void testMigrarListCalculoComision() {
    final RunTareaDto runTareaDto = new RunTareaDto();
    doNothing().when(this.tareaMigrarService).migrarCalculoComision(runTareaDto);

    final CompletableFuture<Void> result = this.runTareaMigrarAsyncServiceImpl.migrarListCalculoComision(runTareaDto);

    verify(this.tareaMigrarService, times(1)).migrarCalculoComision(runTareaDto);
    assertTrue(result.isDone());
  }
}
