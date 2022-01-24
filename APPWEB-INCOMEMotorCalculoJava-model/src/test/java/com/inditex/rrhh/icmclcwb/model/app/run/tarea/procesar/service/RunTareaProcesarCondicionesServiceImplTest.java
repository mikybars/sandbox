package com.inditex.rrhh.icmclcwb.model.app.run.tarea.procesar.service;

/*
 * Copyright (c) 2022. Inditex
 */
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import com.inditex.aqsw.framework.test.randomizer.Random;
import com.inditex.aqsw.framework.test.randomizer.RandomizerExtension;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.model.primary.repository.PrimaryTemporaryTableRepositoryCustom;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaPersonaEstructuraDesplazamientoRepositoryCustom;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaPersonaEstructuraRepositoryCustomImpl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith({SpringExtension.class, RandomizerExtension.class})
class RunTareaProcesarCondicionesServiceImplTest {

  @Mock
  private TareaPersonaEstructuraDesplazamientoRepositoryCustom tareaPersonaEstructuraDesplazamientoRepositoryCustom;

  @Mock
  private TareaPersonaEstructuraRepositoryCustomImpl tareaPersonaEstructuraRepositoryCustom;

  @Mock
  private PrimaryTemporaryTableRepositoryCustom primaryTemporaryTableRepositoryCustom;

  @InjectMocks
  private RunTareaProcesarCondicionesServiceImpl runTareaProcesarCondicionesService;

  @Test
  void igualarBandasOrigenDestinoTest(@Random final TareaDto tarea) {
    this.runTareaProcesarCondicionesService.igualarBandasOrigenDestino(tarea);
    verify(this.primaryTemporaryTableRepositoryCustom, times(1)).createTempBandasOrigenSinBandaDesplazamiento();
    verify(this.primaryTemporaryTableRepositoryCustom, times(1)).insertBandasOrigenSinBandaDesplazamiento(tarea);
    verify(this.tareaPersonaEstructuraRepositoryCustom, times(1)).crearEstructurasOrigenIgualarBandas();
    verify(this.tareaPersonaEstructuraDesplazamientoRepositoryCustom, times(1)).crearEstructurasDestinoIgualarBandas();
    verify(this.primaryTemporaryTableRepositoryCustom, times(1)).deleteTempBandasOrigenSinBandaDesplazamiento();
  }

  @Test
  void establecerBandaOpcionOrigen(@Random final TareaDto tarea) {
    this.runTareaProcesarCondicionesService.establecerBandaOpcionOrigen(tarea);
    verify(this.tareaPersonaEstructuraRepositoryCustom, times(1)).establecerBandaOpcionOrigen(tarea);
  }

}
