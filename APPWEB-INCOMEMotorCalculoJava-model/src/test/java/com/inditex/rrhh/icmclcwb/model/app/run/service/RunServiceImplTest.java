/*
 * Copyright (c) 2021. Inditex
 */

package com.inditex.rrhh.icmclcwb.model.app.run.service;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.service.RunTareaService;
import com.inditex.rrhh.icmclcwb.api.app.run.trabajo.dto.RunTrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.run.trabajo.service.RunTrabajoService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaService;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.service.TrabajoService;
import com.inditex.rrhh.icmclcwb.dto.TrabajoDTO;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;

@ExtendWith(MockitoExtension.class)
class RunServiceImplTest {

  @Mock
  TrabajoService trabajoService;

  @Mock
  RunTrabajoService runTrabajoService;

  @Mock
  TareaService tareaService;

  @Mock
  RunTareaService runTareaService;

  @Mock
  Logger log;

  @InjectMocks
  RunServiceImpl runService;

  @Test
  void runTrabajoTest() {
    Long trabajoId = 1L;
    TrabajoDTO trabajo = mock(TrabajoDTO.class);
    RunTrabajoDto runTrabajo = mock(RunTrabajoDto.class);

    when(this.trabajoService.findByIdWithStates(trabajoId)).thenReturn(trabajo);
    when(this.runTrabajoService.run(RunTrabajoDto.builder().trabajo(trabajo).build())).thenReturn(runTrabajo);

    this.runService.runTrabajo(trabajoId);

    verify(this.trabajoService, times(1)).findByIdWithStates(trabajoId);
    verify(this.runTrabajoService, times(1)).run(RunTrabajoDto.builder().trabajo(trabajo).build());
  }

  @Test
  void runTrabajoTest2() {
    Long trabajoId = 1L;

    when(this.trabajoService.findByIdWithStates(trabajoId)).thenReturn(null);
    doNothing().when(this.log)
        .warn("El Trabajo[{}] no existe o no se encuentra en una estado válido para procesar", trabajoId);

    this.runService.runTrabajo(trabajoId);

    verify(this.trabajoService, times(1)).findByIdWithStates(trabajoId);
    verify(this.log, times(1)).warn("El Trabajo[{}] no existe o no se encuentra en una estado válido para procesar",
        trabajoId);
  }

  @Test
  void runTareaTest() {
    Long tareaId = 1L;
    TareaDto tarea = mock(TareaDto.class);
    tarea.setIdTrabajo(tareaId);
    TrabajoDTO trabajo = mock(TrabajoDTO.class);

    when(this.tareaService.findByIdWithStates(tareaId)).thenReturn(tarea);
    when(this.trabajoService.find(tarea.getIdTrabajo())).thenReturn(trabajo);
    doNothing().when(this.runTareaService).run(RunTareaDto.builder().trabajo(trabajo).tarea(tarea).build());

    this.runService.runTarea(tareaId);

    verify(this.trabajoService, times(1)).find(tarea.getIdTrabajo());
    verify(this.tareaService, times(1)).findByIdWithStates(tareaId);
    verify(this.runTareaService, times(1)).run(RunTareaDto.builder().trabajo(trabajo).tarea(tarea).build());
  }

  @Test
  void runTareaTest2() {
    Long tareaId = 1L;

    when(this.tareaService.findByIdWithStates(tareaId)).thenReturn(null);
    doNothing().when(this.log)
        .warn("La Tarea[{}] no existe o no se encuentra en una estado válido para procesar", tareaId);

    this.runService.runTarea(tareaId);

    verify(this.tareaService, times(1)).findByIdWithStates(tareaId);
    verify(this.log, times(1)).warn("La Tarea[{}] no existe o no se encuentra en una estado válido para procesar",
        tareaId);
  }

}
