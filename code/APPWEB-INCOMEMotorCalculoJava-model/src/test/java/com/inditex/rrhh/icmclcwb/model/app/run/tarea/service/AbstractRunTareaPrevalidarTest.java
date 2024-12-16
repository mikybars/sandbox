package com.inditex.rrhh.icmclcwb.model.app.run.tarea.service;

/*
 * Copyright (c) 2022. Inditex
 */
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.Collections;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.dto.ValidacionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.AccionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaFaseAccionDatoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaFaseAccionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.AccionService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaFaseAccionService;
import com.inditex.rrhh.icmclcwb.model.app.tarea.service.TareaFaseAccionDatoServiceImpl;

import org.instancio.Instancio;
import org.instancio.junit.InstancioSource;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith({SpringExtension.class})
class AbstractRunTareaPrevalidarTest {

  @InjectMocks
  AbstractRunTareaPrevalidar abstractRunTareaPrevalidar = Mockito.mock(AbstractRunTareaPrevalidar.class, Mockito.CALLS_REAL_METHODS);

  @Mock
  private TareaFaseAccionService tareaFaseAccionService;

  @Mock
  private AccionService accionService;

  @Mock
  private TareaFaseAccionDatoServiceImpl tareaFaseAccionFallidasService;

  @Test
  void insertarDatoIdAccion1Test() {
    final List<ValidacionDto> fallidas = Instancio.ofList(ValidacionDto.class).size(1).create();
    final TareaFaseAccionDto tareaFaseAccion = Instancio.create(TareaFaseAccionDto.class);
    tareaFaseAccion.setIdAccion(1);
    doReturn(tareaFaseAccion).when(this.tareaFaseAccionService).findById(any(Long.class));
    doReturn(AccionDto.builder().id(1).build()).when(this.accionService).findAccionDtoById(tareaFaseAccion.getIdAccion());

    final TareaFaseAccionDatoDto tareaFaseAccionDatoDto = TareaFaseAccionDatoDto.builder()
        .idTareaFaseAccion(tareaFaseAccion.getId())
        .build();
    final List<TareaFaseAccionDatoDto> list = Collections.singletonList(tareaFaseAccionDatoDto);
    doNothing().when(this.tareaFaseAccionFallidasService).save(list);

    this.abstractRunTareaPrevalidar.insertarDato(fallidas);

    verify(this.tareaFaseAccionFallidasService, times(1)).save(any(List.class));
  }

  @ParameterizedTest
  @InstancioSource(samples = 1)
  void insertarDatoIdAccion2Test(
      final TareaFaseAccionDto tareaFaseAccion) {
    final List<ValidacionDto> fallidas = Instancio.ofList(ValidacionDto.class).size(1).create();

    doReturn(tareaFaseAccion).when(this.tareaFaseAccionService).findById(any(Long.class));
    doReturn(AccionDto.builder().id(2).build()).when(this.accionService).findAccionDtoById(tareaFaseAccion.getIdAccion());

    final TareaFaseAccionDatoDto tareaFaseAccionDatoDto = TareaFaseAccionDatoDto.builder()
        .idTareaFaseAccion(tareaFaseAccion.getId())
        .build();
    final List<TareaFaseAccionDatoDto> list = Collections.singletonList(tareaFaseAccionDatoDto);
    doNothing().when(this.tareaFaseAccionFallidasService).save(list);

    this.abstractRunTareaPrevalidar.insertarDato(fallidas);

    verify(this.tareaFaseAccionFallidasService, times(1)).save(any(List.class));
  }

}
