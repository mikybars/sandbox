package com.inditex.rrhh.icmclcwb.model.app.tarea.service;

/*
 * Copyright (c) 2022. Inditex
 */
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaFaseAccionFallidasDto;
import com.inditex.rrhh.icmclcwb.model.app.tarea.mapper.TareaFaseAccionFallidasMapper;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.entity.TareaFaseAccionFallidas;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaFaseAccionFallidasRepositoryCustom;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class TareaFaseAccionFallidasServiceImplTest {

  @InjectMocks
  TareaFaseAccionFallidasServiceImpl tareaFaseAccionFallidasService;

  @Mock
  private TareaFaseAccionFallidasMapper tareaFaseAccionFallidasMapper;

  @Mock
  private TareaFaseAccionFallidasRepositoryCustom tareaFaseAccionFallidasRepository;

  @Test
  void saveTest() {
    doReturn(mock(TareaFaseAccionFallidas.class))
        .when(this.tareaFaseAccionFallidasMapper)
        .tareaFaseAccionFallidasDtoToTareaFaseAccionFallidas(any(TareaFaseAccionFallidasDto.class));

    final TareaFaseAccionFallidasDto TFAF = mock(TareaFaseAccionFallidasDto.class);
    this.tareaFaseAccionFallidasService.save(TFAF);
    verify(this.tareaFaseAccionFallidasRepository, times(1)).save(any(TareaFaseAccionFallidas.class));
  }

}
