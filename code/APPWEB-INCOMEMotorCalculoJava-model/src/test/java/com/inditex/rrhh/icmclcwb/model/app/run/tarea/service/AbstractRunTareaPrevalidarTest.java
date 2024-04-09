package com.inditex.rrhh.icmclcwb.model.app.run.tarea.service;

/*
 * Copyright (c) 2022. Inditex
 */
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.Arrays;
import java.util.List;

import com.inditex.amigafwk.test.randomizer.Random;
import com.inditex.amigafwk.test.randomizer.RandomizerExtension;
import com.inditex.rrhh.icmclcwb.api.app.dto.ValidacionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.AccionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaFaseAccionDatoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaFaseAccionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.AccionService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaFaseAccionService;
import com.inditex.rrhh.icmclcwb.model.app.tarea.service.TareaFaseAccionDatoServiceImpl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith({SpringExtension.class, RandomizerExtension.class})
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
  void insertarDatoIdAccion1Test(@Random(type = ValidacionDto.class, size = 1) List<ValidacionDto> fallidas,
      @Random TareaFaseAccionDto tareaFaseAccion) {

    doReturn(tareaFaseAccion).when(this.tareaFaseAccionService).findById(fallidas.get(0).getIdTareaFaseAccion());
    doReturn(AccionDto.builder().id(1).build()).when(this.accionService).findAccionDtoById(tareaFaseAccion.getIdAccion());

    TareaFaseAccionDatoDto tareaFaseAccionDatoDto = TareaFaseAccionDatoDto.builder()
        .idTareaFaseAccion(tareaFaseAccion.getId())
        .build();
    List<TareaFaseAccionDatoDto> list = Arrays.asList(tareaFaseAccionDatoDto);
    doNothing().when(this.tareaFaseAccionFallidasService).save(list);

    this.abstractRunTareaPrevalidar.insertarDato(fallidas);

    verify(this.tareaFaseAccionFallidasService, times(1)).save(any(List.class));
  }

  @Test
  void insertarDatoIdAccion2Test(@Random(type = ValidacionDto.class, size = 1) List<ValidacionDto> fallidas,
      @Random TareaFaseAccionDto tareaFaseAccion) {

    doReturn(tareaFaseAccion).when(this.tareaFaseAccionService).findById(fallidas.get(0).getIdTareaFaseAccion());
    doReturn(AccionDto.builder().id(2).build()).when(this.accionService).findAccionDtoById(tareaFaseAccion.getIdAccion());

    TareaFaseAccionDatoDto tareaFaseAccionDatoDto = TareaFaseAccionDatoDto.builder()
        .idTareaFaseAccion(tareaFaseAccion.getId())
        .build();
    List<TareaFaseAccionDatoDto> list = Arrays.asList(tareaFaseAccionDatoDto);
    doNothing().when(this.tareaFaseAccionFallidasService).save(list);

    this.abstractRunTareaPrevalidar.insertarDato(fallidas);

    verify(this.tareaFaseAccionFallidasService, times(1)).save(any(List.class));
  }

}
