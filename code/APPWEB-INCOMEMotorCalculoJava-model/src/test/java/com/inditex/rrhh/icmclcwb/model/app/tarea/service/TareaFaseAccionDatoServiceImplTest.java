package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

/*
 * Copyright (c) 2022. Inditex
 */
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.Arrays;
import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaFaseAccionDatoDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaFaseAccionDatoMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaFaseAccionDato;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaFaseAccionDatoRepositoryCustom;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class TareaFaseAccionDatoServiceImplTest {

  @InjectMocks
  TareaFaseAccionDatoServiceImpl tareaFaseAccionFallidasService;

  @Mock
  private TareaFaseAccionDatoMapper tareaFaseAccionDatoMapper;

  @Mock
  private TareaFaseAccionDatoRepositoryCustom tareaFaseAccionFallidasRepository;

  @Test
  void saveTest() {
    doReturn(mock(TareaFaseAccionDato.class))
        .when(this.tareaFaseAccionDatoMapper)
        .tareaFaseAccionDatoDtoToTareaFaseAccionDato(any(TareaFaseAccionDatoDto.class));

    final TareaFaseAccionDatoDto TFAF = mock(TareaFaseAccionDatoDto.class);
    this.tareaFaseAccionFallidasService.save(Arrays.asList(TFAF));
    verify(this.tareaFaseAccionFallidasRepository, times(1)).save(any(List.class));
  }

}
