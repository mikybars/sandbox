package com.inditex.rrhh.icmclcwb.model.app.calcular.challengepreciohoratiendaseccion.v1;

/*
 * Copyright (c) 2021. Inditex
 */
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.calcular.properties.dto.RunAlgoritmoCalculoPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.app.calcular.properties.dto.RunAlgoritmoPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaCalculoPersonaService;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;
import com.inditex.rrhh.icmclcwb.dto.AlgoritmoDTO;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaCalculoAlgoritmoChallengePrecioHoraTiendaSeccionDesplazamientoBaseV1RepositoryCustom;

import org.instancio.Instancio;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith({SpringExtension.class})
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

  final AlgoritmoDTO algoritmo = Instancio.create(AlgoritmoDTO.class);

  final RunTareaDto runTarea = Instancio.create(RunTareaDto.class);

  @Test
  void executeTest() {

    final List<IdPersonaLocalDto> ids = Instancio.ofList(IdPersonaLocalDto.class).size(1).create();
    final RunAlgoritmoCalculoPropertiesDto prop = Instancio.create(RunAlgoritmoCalculoPropertiesDto.class);

    doReturn(prop).when(this.runAlgoritmoProperties).getCalculo();

    doReturn(ids).when(this.tareaCalculoAlgoritmoChallengePrecioHoraTiendaSeccionDesplazamientoBaseV1RepositoryCustom)
        .ids(any(AlgoritmoDTO.class), any(TareaDto.class));

    doReturn(CompletableFuture.completedFuture(AsyncConstants.NIL))
        .when(this.tareaCalculoAlgoritmoChallengePrecioHoraTiendaSeccionDesplazamientoBaseV1RepositoryCustom)
        .calcular(any(AlgoritmoDTO.class), any(TareaDto.class), any(List.class));

    final CompletableFuture<Void> result = this.challengePrecioHoraTiendaSeccionDesplazamientoBaseV1RunAlgoritmo
        .execute(this.runTarea, this.algoritmo);

    assertNotNull(result);
  }

  @Test
  void executeExceptionTest() {
    final RunAlgoritmoCalculoPropertiesDto prop = Instancio.create(RunAlgoritmoCalculoPropertiesDto.class);
    doReturn(prop).when(this.runAlgoritmoProperties).getCalculo();

    final CompletableFuture<Void> result = this.challengePrecioHoraTiendaSeccionDesplazamientoBaseV1RunAlgoritmo
        .execute(this.runTarea, this.algoritmo);

    assertNotNull(result);
  }

  @Test
  void getSqlCalcularTest() {
    final RunAlgoritmoCalculoPropertiesDto prop = Instancio.create(RunAlgoritmoCalculoPropertiesDto.class);
    doReturn(prop).when(this.runAlgoritmoProperties).getCalculo();

    doReturn("getSqlCalcular").when(this.tareaCalculoAlgoritmoChallengePrecioHoraTiendaSeccionDesplazamientoBaseV1RepositoryCustom)
        .getSqlCalcular(any(AlgoritmoDTO.class));

    final String result = this.challengePrecioHoraTiendaSeccionDesplazamientoBaseV1RunAlgoritmo
        .getSqlCalcular(this.algoritmo);

    assertNotNull(result);
    assertEquals("getSqlCalcular", result);
  }
}
