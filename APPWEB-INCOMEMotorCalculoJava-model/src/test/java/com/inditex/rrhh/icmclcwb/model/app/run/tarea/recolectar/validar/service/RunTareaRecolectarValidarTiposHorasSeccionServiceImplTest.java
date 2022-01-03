
package com.inditex.rrhh.icmclcwb.model.app.run.tarea.recolectar.validar.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.timeout;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.async.service.TareaValidarAsyncService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class RunTareaRecolectarValidarTiposHorasSeccionServiceImplTest {

  @Mock
  private TareaValidarAsyncService tareaValidarAsyncService;

  @InjectMocks
  private RunTareaRecolectarValidarTiposHoraServiceImpl runTareaRecolectarValidarTiposHoraServiceImpl;

  @Test
  public void run() {
    final RunTareaDto runTareaDto = new RunTareaDto();
    final TareaDto tareaDto = new TareaDto();
    tareaDto.setId(1L);
    runTareaDto.setTarea(tareaDto);

    final List<String> lista = new ArrayList<>();
    final CompletableFuture<List<String>> cf = new CompletableFuture<>();
    cf.complete(lista);

    when(this.tareaValidarAsyncService.checkDuplicatedTiposHora(any(Long.class)))
        .thenReturn(cf);

    this.runTareaRecolectarValidarTiposHoraServiceImpl.run(runTareaDto);

    verify(this.tareaValidarAsyncService, timeout(1000).times(1))
        .checkDuplicatedTiposHora(
            ArgumentMatchers.any(Long.class));

  }

}
