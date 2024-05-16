package com.inditex.rrhh.icmclcwb.model.app.calcular.challengepreciohoratiendaseccion.v1;

/*
 * Copyright (c) 2021. Inditex
 */

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.calcular.properties.dto.RunAlgoritmoCalculoPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.app.calcular.properties.dto.RunAlgoritmoPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.EstadoTareaCalculoPersonaEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaCalculoPersonaService;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;
import com.inditex.rrhh.icmclcwb.dto.AlgoritmoDTO;
import com.inditex.rrhh.icmclcwb.dto.TrabajoDTO;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaCalculoAlgoritmoChallengePrecioHoraTiendaSeccionDesplazamientoBaseV1RepositoryCustom;

import org.instancio.Instancio;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
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
    final IdPersonaLocalDto p1 = new IdPersonaLocalDto("1", "2");
    final IdPersonaLocalDto p2 = new IdPersonaLocalDto("2", "2");

    final List<IdPersonaLocalDto> personas = new ArrayList<>();
    personas.add(p1);
    personas.add(p2);

    final RunAlgoritmoCalculoPropertiesDto runAlgoritmoCalculoPropertiesDto = new RunAlgoritmoCalculoPropertiesDto();
    runAlgoritmoCalculoPropertiesDto.setBatchSize(5);
    runAlgoritmoCalculoPropertiesDto.setThreadSize(5);
    when(this.runAlgoritmoProperties.getCalculo()).thenReturn(runAlgoritmoCalculoPropertiesDto);

    when(this.tareaCalculoAlgoritmoChallengePrecioHoraTiendaSeccionDesplazamientoBaseV1RepositoryCustom.ids(any(AlgoritmoDTO.class),
        any(TareaDto.class)))
            .thenReturn(personas);

    final RuntimeException exception = new RuntimeException("EEEE");
    doThrow(exception).when(this.tareaCalculoAlgoritmoChallengePrecioHoraTiendaSeccionDesplazamientoBaseV1RepositoryCustom)
        .calcular(any(AlgoritmoDTO.class), any(TareaDto.class),
            ArgumentMatchers.any());

    final TrabajoDTO trabajo = new TrabajoDTO();
    trabajo.setId(2231L);
    final TareaDto tarea = new TareaDto();
    tarea.setId(12549L);
    final RunTareaDto runTarea = RunTareaDto.builder().tarea(tarea).trabajo(trabajo).build();

    final AlgoritmoDTO algoritmo = new AlgoritmoDTO();
    this.challengePrecioHoraTiendaSeccionDesplazamientoBaseV1RunAlgoritmo.execute(runTarea, algoritmo);

    verify(this.tareaCalculoPersonaService, times(1)).updateWithEstadoAndidPersona(personas, runTarea,
        EstadoTareaCalculoPersonaEnum.KO.getDto());

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
