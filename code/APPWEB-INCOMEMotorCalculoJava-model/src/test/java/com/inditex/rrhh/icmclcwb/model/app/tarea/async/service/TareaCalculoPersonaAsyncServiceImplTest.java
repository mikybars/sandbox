package com.inditex.rrhh.icmclcwb.model.app.tarea.async.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.EstadoTareaPersonaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaCalculoPersonaService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class TareaCalculoPersonaAsyncServiceImplTest {
  @Mock
  private TareaCalculoPersonaService tareaCalculoPersonaService;

  @InjectMocks
  private TareaCalculoPersonaAsyncServiceImpl tareaCalculoPersonaAsyncService;

  @Test
  void mergePersonaCalculoByAmbitoTest() {
    final RunTareaDto runTareaDto = new RunTareaDto();

    this.tareaCalculoPersonaAsyncService.mergePersonaCalculoByAmbito(runTareaDto);

    verify(this.tareaCalculoPersonaService).mergePersonaCalculoByAmbito(any(RunTareaDto.class));
  }

  @Test
  void mergePersonaCalculoByAmbitoLocalizacionTest() {
    final RunTareaDto runTareaDto = new RunTareaDto();

    this.tareaCalculoPersonaAsyncService.mergePersonaCalculoByAmbitoLocalizacion(runTareaDto);

    verify(this.tareaCalculoPersonaService).mergePersonaCalculoByAmbitoLocalizacion(any(RunTareaDto.class));
  }

  @Test
  void mergePersonaCalculoByAmbitoPersonaTest() {
    final RunTareaDto runTareaDto = new RunTareaDto();

    this.tareaCalculoPersonaAsyncService.mergePersonaCalculoByAmbitoPersona(runTareaDto);

    verify(this.tareaCalculoPersonaService).mergePersonaCalculoByAmbitoPersona(any(RunTareaDto.class));
  }

  @Test
  void updateWithEstadoTest() {
    final RunTareaDto runTareaDto = new RunTareaDto();
    final EstadoTareaPersonaDto estadoActual = new EstadoTareaPersonaDto();
    final EstadoTareaPersonaDto estadoNuevo = new EstadoTareaPersonaDto();

    this.tareaCalculoPersonaAsyncService.updateWithEstado(runTareaDto, estadoActual, estadoNuevo);

    verify(this.tareaCalculoPersonaService).updateWithEstado(any(RunTareaDto.class), any(EstadoTareaPersonaDto.class),
        any(EstadoTareaPersonaDto.class));
  }
}
