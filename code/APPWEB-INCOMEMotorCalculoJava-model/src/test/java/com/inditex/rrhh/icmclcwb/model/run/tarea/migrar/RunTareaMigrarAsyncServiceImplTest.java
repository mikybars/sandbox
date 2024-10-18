package com.inditex.rrhh.icmclcwb.model.run.tarea.migrar;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaMigrarService;
import com.inditex.rrhh.icmclcwb.model.app.run.tarea.migrar.RunTareaMigrarAsyncServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.concurrent.CompletableFuture;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
class RunTareaMigrarAsyncServiceImplTest {

    @Mock
    private TareaMigrarService tareaMigrarService;

    @InjectMocks
    private RunTareaMigrarAsyncServiceImpl runTareaMigrarAsyncServiceImpl;

    @Test
    void testMigrarListCalculoComision() {
        RunTareaDto runTareaDto = new RunTareaDto();
        doNothing().when(tareaMigrarService).migrarCalculoComision(runTareaDto);

        CompletableFuture<Void> result = runTareaMigrarAsyncServiceImpl.migrarListCalculoComision(runTareaDto);

        verify(tareaMigrarService, times(1)).migrarCalculoComision(runTareaDto);
        assertTrue(result.isDone());
    }
}
