package com.inditex.rrhh.icmclcwb.model.app.calcular.challengepreciohoratiendaseccion.v1;

/*
 * Copyright (c) 2021. Inditex
 */
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.inditex.amigafwk.test.randomizer.Random;
import com.inditex.amigafwk.test.randomizer.RandomizerExtension;
import com.inditex.rrhh.icmclcwb.api.app.calcular.properties.dto.RunAlgoritmoCalculoPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.app.calcular.properties.dto.RunAlgoritmoPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaCalculoPersonaService;
import com.inditex.rrhh.icmclcwb.dto.AlgoritmoDTO;
import com.inditex.rrhh.icmclcwb.model.app.util.StreamUtils;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaCalculoAlgoritmoChallengePrecioHoraTiendaSeccionDesplazamientoBaseV1RepositoryCustom;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith({SpringExtension.class, RandomizerExtension.class})
class ChallengePrecioHoraTiendaSeccionDesplazamientoBaseV1RunAlgoritmoTest {

  @Mock
  Logger log;

  @Mock
  TareaCalculoPersonaService tareaCalculoPersonaService;

  @Mock
  TareaCalculoAlgoritmoChallengePrecioHoraTiendaSeccionDesplazamientoBaseV1RepositoryCustom tareaCalculoAlgoritmoChallengePrecioHoraTiendaSeccionDesplazamientoBaseV1RepositoryCustom;

  @Mock
  @Qualifier("runAlgoritmoProperties")
  RunAlgoritmoPropertiesDto runAlgoritmoProperties;

  @InjectMocks
  ChallengePrecioHoraTiendaSeccionDesplazamientoBaseV1RunAlgoritmo challengePrecioHoraTiendaSeccionDesplazamientoBaseV1RunAlgoritmo;

  @Random
  RunTareaDto runTarea;

  @Random
  AlgoritmoDTO algoritmo;

  @BeforeEach
  void initExecuteTest(@Random(type = IdPersonaLocalDto.class, size = 2) List<IdPersonaLocalDto> ids,
      @Random RunAlgoritmoCalculoPropertiesDto algoritmoCalculo, @Random CompletableFuture<Void> cfCalc) {

    doReturn(ids).when(this.tareaCalculoAlgoritmoChallengePrecioHoraTiendaSeccionDesplazamientoBaseV1RepositoryCustom)
        .ids(this.algoritmo, this.runTarea.getTarea());

    doReturn(algoritmoCalculo).when(this.runAlgoritmoProperties).getCalculo();

    for (List<IdPersonaLocalDto> personas : StreamUtils.partition(ids, algoritmoCalculo.getBatchSize())) {
      doReturn(cfCalc).when(this.tareaCalculoAlgoritmoChallengePrecioHoraTiendaSeccionDesplazamientoBaseV1RepositoryCustom)
          .calcular(this.algoritmo, this.runTarea.getTarea(), personas);
    }
  }

  @Test
  void executeTest() {
    final CompletableFuture<Void> result = this.challengePrecioHoraTiendaSeccionDesplazamientoBaseV1RunAlgoritmo
        .execute(this.runTarea, this.algoritmo);

    assertNotNull(result);
  }

  @BeforeEach
  void initExecuteExceptionTest(@Random(type = IdPersonaLocalDto.class, size = 2) List<IdPersonaLocalDto> ids,
      @Random RunAlgoritmoCalculoPropertiesDto algoritmoCalculo, @Random CompletableFuture<Void> cfCalc) {

    doReturn(ids).when(this.tareaCalculoAlgoritmoChallengePrecioHoraTiendaSeccionDesplazamientoBaseV1RepositoryCustom)
        .ids(this.algoritmo, this.runTarea.getTarea());

    doReturn(algoritmoCalculo).when(this.runAlgoritmoProperties).getCalculo();

    for (List<IdPersonaLocalDto> personas : StreamUtils.partition(ids, algoritmoCalculo.getBatchSize())) {
      doThrow(new RuntimeException())
          .when(this.tareaCalculoAlgoritmoChallengePrecioHoraTiendaSeccionDesplazamientoBaseV1RepositoryCustom)
          .calcular(this.algoritmo, this.runTarea.getTarea(), personas);
    }
  }

  @Test
  void executeExceptionTest() {
    final CompletableFuture<Void> result = this.challengePrecioHoraTiendaSeccionDesplazamientoBaseV1RunAlgoritmo
        .execute(this.runTarea, this.algoritmo);

    assertNotNull(result);
  }

  @BeforeEach
  void initGetSqlCalcularTest() {
    doReturn("getSqlCalcular").when(this.tareaCalculoAlgoritmoChallengePrecioHoraTiendaSeccionDesplazamientoBaseV1RepositoryCustom)
        .getSqlCalcular(this.algoritmo);
  }

  @Test
  void getSqlCalcularTest() {
    final String result = this.challengePrecioHoraTiendaSeccionDesplazamientoBaseV1RunAlgoritmo
        .getSqlCalcular(this.algoritmo);

    assertNotNull(result);
    assertEquals("getSqlCalcular", result);
  }
}
