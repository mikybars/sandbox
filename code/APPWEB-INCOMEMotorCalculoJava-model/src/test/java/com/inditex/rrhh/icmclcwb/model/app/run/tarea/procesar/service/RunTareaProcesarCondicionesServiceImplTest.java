package com.inditex.rrhh.icmclcwb.model.app.run.tarea.procesar.service;

/*
 * Copyright (c) 2022. Inditex
 */

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.model.primary.repository.PrimaryTemporaryTableRepositoryCustom;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaPersonaEstructuraDesplazamientoRepositoryCustom;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaPersonaEstructuraRepositoryCustomImpl;

import org.instancio.junit.InstancioSource;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith({SpringExtension.class})
class RunTareaProcesarCondicionesServiceImplTest {

  @Mock
  private TareaPersonaEstructuraDesplazamientoRepositoryCustom tareaPersonaEstructuraDesplazamientoRepositoryCustom;

  @Mock
  private TareaPersonaEstructuraRepositoryCustomImpl tareaPersonaEstructuraRepositoryCustom;

  @Mock
  private PrimaryTemporaryTableRepositoryCustom primaryTemporaryTableRepositoryCustom;

  @InjectMocks
  private RunTareaProcesarCondicionesServiceImpl runTareaProcesarCondicionesService;

  @ParameterizedTest
  @InstancioSource
  void igualarBandasOrigenDestinoTest(final TareaDto tarea) {
    this.runTareaProcesarCondicionesService.igualarBandasOrigenDestino(tarea);
    verify(this.primaryTemporaryTableRepositoryCustom, times(1)).createTempBandasOrigenSinBandaDesplazamiento();
    verify(this.primaryTemporaryTableRepositoryCustom, times(1)).insertBandasOrigenSinBandaDesplazamiento(tarea);
    verify(this.tareaPersonaEstructuraRepositoryCustom, times(1)).crearEstructurasOrigenIgualarBandas();
    verify(this.tareaPersonaEstructuraDesplazamientoRepositoryCustom, times(1)).crearEstructurasDestinoIgualarBandas();
    verify(this.primaryTemporaryTableRepositoryCustom, times(1)).deleteTempBandasOrigenSinBandaDesplazamiento();
  }

  @ParameterizedTest
  @InstancioSource
  void establecerBandaOpcionOrigen(final TareaDto tarea) {
    this.runTareaProcesarCondicionesService.establecerBandaOpcionOrigen(tarea);
    verify(this.primaryTemporaryTableRepositoryCustom, times(1)).createTempEstructurasBaseChallenge();
    verify(this.primaryTemporaryTableRepositoryCustom, times(1)).indexTempEstructurasBaseChallenge();
    verify(this.primaryTemporaryTableRepositoryCustom, times(1)).insertTempEstructurasBaseChallenge(tarea);
    verify(this.primaryTemporaryTableRepositoryCustom, times(1)).createTempEstructurasDesplazamientoNoChallenge();
    verify(this.primaryTemporaryTableRepositoryCustom, times(1)).indexTempEstructurasDesplazamientoNoChallenge();
    verify(this.primaryTemporaryTableRepositoryCustom, times(1)).insertTempEstructurasDesplazamientoNoChallenge(tarea);
    verify(this.tareaPersonaEstructuraRepositoryCustom, times(1)).establecerBandaOpcionOrigen();
    verify(this.primaryTemporaryTableRepositoryCustom, times(1)).deleteTempEstructurasBaseChallenge();
    verify(this.primaryTemporaryTableRepositoryCustom, times(1)).deleteTempEstructurasDesplazamientoNoChallenge();

  }

  @ParameterizedTest
  @InstancioSource
  void crearChallengeOpcionOrigen(final TareaDto tarea) {
    this.runTareaProcesarCondicionesService.crearChallengeOpcionOrigen(tarea);
    verify(this.tareaPersonaEstructuraRepositoryCustom, times(1)).crearChallengeOpcionOrigen(tarea);
  }

  @ParameterizedTest
  @InstancioSource
  void desactivarChallengeOpcionOrigen(final TareaDto tarea) {
    this.runTareaProcesarCondicionesService.desactivarChallengeOpcionOrigen(tarea);
    verify(this.tareaPersonaEstructuraRepositoryCustom, times(1)).desactivarChallengeOpcionOrigen(tarea);
  }

  @ParameterizedTest
  @InstancioSource
  void crearGlobalSeccionOpcionOrigen(final TareaDto tarea) {
    this.runTareaProcesarCondicionesService.crearGlobalSeccionOpcionOrigen(tarea);
    verify(this.tareaPersonaEstructuraRepositoryCustom, times(1)).crearGlobalSeccionOpcionOrigen(tarea);
  }

  @ParameterizedTest
  @InstancioSource
  void desactivarGlobalSeccionOpcionOrigen(final TareaDto tarea) {
    this.runTareaProcesarCondicionesService.desactivarGlobalSeccionOpcionOrigen(tarea);
    verify(this.tareaPersonaEstructuraRepositoryCustom, times(1)).desactivarGlobalSeccionOpcionOrigen(tarea);
  }

}
