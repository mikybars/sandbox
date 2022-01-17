package com.inditex.rrhh.icmclcwb.model.app.run.tarea.procesar.service;/*
 * Copyright (c) 2022.  Inditex
 */

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaPersonaEstructuraDesplazamientoRepositoryCustom;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class RunTareaProcesarCondicionesServiceImplTest {

  @Mock
  private TareaPersonaEstructuraDesplazamientoRepositoryCustom tareaPersonaEstructuraDesplazamientoRepositoryCustom;

  @InjectMocks
  private RunTareaProcesarCondicionesServiceImpl runTareaProcesarCondicionesService;

  @Test
  void crearChallengeOpcionOrigenIgualarBandasTest() {
    final TareaDto tarea = new TareaDto();
    tarea.setId(890890L);
    this.runTareaProcesarCondicionesService.crearChallengeOpcionOrigenIgualarBandas(tarea);
    verify(this.tareaPersonaEstructuraDesplazamientoRepositoryCustom, times(1)).crearChallengeOpcionOrigenIgualarBandas(tarea);
  }

}
