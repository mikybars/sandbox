package com.inditex.rrhh.icmclcwb.model.app.run.tarea.recolectar.validar.async.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaValidarDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.recolectar.validar.service.RunTareaRecolectarValidarAmbitoService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class RunTareaRecolectarValidarAmbitoAsyncServiceImplTest {
  @Mock
  private RunTareaRecolectarValidarAmbitoService runTareaRecolectarValidarAmbitoService;

  @InjectMocks
  private RunTareaRecolectarValidarAmbitoAsyncServiceImpl runTareaRecolectarValidarAmbitoAsyncService;

  @Test
  void runTest() {
    final RunTareaDto runTarea = new RunTareaDto();
    final List<RunTareaValidarDto> lista = new ArrayList<>();

    when(this.runTareaRecolectarValidarAmbitoService.run(any(RunTareaDto.class))).thenReturn(lista);

    this.runTareaRecolectarValidarAmbitoAsyncService.run(runTarea);

    verify(this.runTareaRecolectarValidarAmbitoService).run(any(RunTareaDto.class));
  }
}
