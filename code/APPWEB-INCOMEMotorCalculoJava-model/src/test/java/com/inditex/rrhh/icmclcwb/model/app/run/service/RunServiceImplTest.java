/*
 * Copyright (c) 2021. Inditex
 */

package com.inditex.rrhh.icmclcwb.model.app.run.service;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.service.RunTareaService;
import com.inditex.rrhh.icmclcwb.api.app.run.trabajo.dto.RunTrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.run.trabajo.service.RunTrabajoService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaService;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.service.TrabajoService;
import com.inditex.rrhh.icmclcwb.dto.TrabajoDTO;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.read.ListAppender;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
    final Long trabajoId = 1L;
    final TrabajoDTO trabajo = mock(TrabajoDTO.class);
    final RunTrabajoDto runTrabajo = mock(RunTrabajoDto.class);

    when(this.trabajoService.findByIdWithStates(trabajoId)).thenReturn(trabajo);
    when(this.runTrabajoService.run(RunTrabajoDto.builder().trabajo(trabajo).build())).thenReturn(runTrabajo);

    this.runService.runTrabajo(trabajoId);

    verify(this.trabajoService, times(1)).findByIdWithStates(trabajoId);
    verify(this.runTrabajoService, times(1)).run(RunTrabajoDto.builder().trabajo(trabajo).build());
  }

  @Test
  void runTrabajoTest2() {
    final Long trabajoId = 1L;

    when(this.trabajoService.findByIdWithStates(trabajoId)).thenReturn(null);

    final ListAppender<ILoggingEvent> listAppender = this.createLogListAppender();

    this.runService.runTrabajo(trabajoId);
    final List<ILoggingEvent> list = listAppender.list;

    verify(this.trabajoService, times(1)).findByIdWithStates(trabajoId);

    Assertions.assertEquals("El Trabajo[{}] no existe o no se encuentra en una estado válido para procesar", list.get(0).getMessage());

  }

  @Test
  void runTareaTest() {
    final Long tareaId = 1L;
    final TareaDto tarea = mock(TareaDto.class);
    tarea.setIdTrabajo(tareaId);
    final TrabajoDTO trabajo = mock(TrabajoDTO.class);

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
    final Long tareaId = 1L;

    when(this.tareaService.findByIdWithStates(tareaId)).thenReturn(null);

    final ListAppender<ILoggingEvent> listAppender = this.createLogListAppender();

    this.runService.runTarea(tareaId);

    final List<ILoggingEvent> list = listAppender.list;

    verify(this.tareaService, times(1)).findByIdWithStates(tareaId);
    Assertions.assertEquals("La Tarea[{}] no existe o no se encuentra en una estado válido para procesar", list.get(0).getMessage());

  }

  private ListAppender<ILoggingEvent> createLogListAppender() {
    final ch.qos.logback.classic.Logger log =
        (ch.qos.logback.classic.Logger) LoggerFactory.getLogger(RunServiceImpl.class);
    final ListAppender<ILoggingEvent> listAppender = new ListAppender<>();
    listAppender.start();
    log.addAppender(listAppender);
    return listAppender;
  }

}
