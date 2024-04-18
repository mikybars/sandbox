package com.inditex.rrhh.icmclcwb.model.app.calcular.porventa.v1;

/*
 * Copyright (c) 2021. Inditex
 */

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.calcular.properties.dto.RunAlgoritmoCalculoPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.app.calcular.properties.dto.RunAlgoritmoPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaCalculoPersonaService;
import com.inditex.rrhh.icmclcwb.dto.AlgoritmoDTO;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaCalculoAlgoritmoPorVentaDevolucionPorcentajeDiariaDesplazamientoBaseV1RepositoryCustom;

import org.instancio.Instancio;
import org.instancio.junit.InstancioSource;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith({SpringExtension.class})
class PorVentaDevolucionPorcentajeDiariaDesplazamientoBaseV1RunAlgoritmoTest {

  @Mock
  private Logger log;

  @Mock
  private TareaCalculoAlgoritmoPorVentaDevolucionPorcentajeDiariaDesplazamientoBaseV1RepositoryCustom tareaCalculoAlgoritmoPorVentaDevolucionPorcentajeDiariaDesplazamientoBaseV1RepositoryCustom;

  @Mock
  private TareaCalculoPersonaService tareaCalculoPersonaService;

  @Mock
  @Qualifier("runAlgoritmoProperties")
  private RunAlgoritmoPropertiesDto runAlgoritmoProperties;

  final AlgoritmoDTO algoritmo = Instancio.create(AlgoritmoDTO.class);

  final RunTareaDto runTarea = Instancio.create(RunTareaDto.class);

  @InjectMocks
  PorVentaDevolucionPorcentajeDiariaDesplazamientoBaseV1RunAlgoritmo porVentaDevolucionPorcentajeDiariaDesplazamientoBaseV1RunAlgoritmo;

  @Test
  void getSqlCalcularTest() {
    doReturn("").when(this.tareaCalculoAlgoritmoPorVentaDevolucionPorcentajeDiariaDesplazamientoBaseV1RepositoryCustom)
        .getSqlCalcular(this.algoritmo);

    final String result = this.porVentaDevolucionPorcentajeDiariaDesplazamientoBaseV1RunAlgoritmo.getSqlCalcular(this.algoritmo);

    assertNotNull(result);
  }

  @ParameterizedTest
  @InstancioSource
  void executeTest(final List<IdPersonaLocalDto> ids,
      final RunAlgoritmoCalculoPropertiesDto runAlgoritmoCalculoPropertiesDto,
      final CompletableFuture<Void> completable) {
    doReturn(ids).when(this.tareaCalculoAlgoritmoPorVentaDevolucionPorcentajeDiariaDesplazamientoBaseV1RepositoryCustom)
        .ids(this.algoritmo, this.runTarea.getTarea());

    doReturn(runAlgoritmoCalculoPropertiesDto).when(this.runAlgoritmoProperties).getCalculo();
    final RunAlgoritmoCalculoPropertiesDto spiedItem = Mockito.spy(runAlgoritmoCalculoPropertiesDto);
    doReturn(1).when(spiedItem).getThreadSize();

    doReturn(completable).when(this.tareaCalculoAlgoritmoPorVentaDevolucionPorcentajeDiariaDesplazamientoBaseV1RepositoryCustom)
        .calcular(this.algoritmo, this.runTarea.getTarea(), ids);

    final CompletableFuture<Void> result = this.porVentaDevolucionPorcentajeDiariaDesplazamientoBaseV1RunAlgoritmo
        .execute(this.runTarea, this.algoritmo);

    assertNotNull(result);
  }

  @ParameterizedTest
  @InstancioSource
  void executeTestException(final List<IdPersonaLocalDto> ids,
      final RunAlgoritmoCalculoPropertiesDto runAlgoritmoCalculoPropertiesDto) {
    doReturn(ids).when(this.tareaCalculoAlgoritmoPorVentaDevolucionPorcentajeDiariaDesplazamientoBaseV1RepositoryCustom)
        .ids(this.algoritmo, this.runTarea.getTarea());

    doReturn(runAlgoritmoCalculoPropertiesDto).when(this.runAlgoritmoProperties).getCalculo();
    final RunAlgoritmoCalculoPropertiesDto spiedItem = Mockito.spy(runAlgoritmoCalculoPropertiesDto);
    doReturn(1).when(spiedItem).getThreadSize();

    doThrow(new RuntimeException()).when(this.tareaCalculoAlgoritmoPorVentaDevolucionPorcentajeDiariaDesplazamientoBaseV1RepositoryCustom)
        .calcular(this.algoritmo, this.runTarea.getTarea(), ids);

    final CompletableFuture<Void> result = this.porVentaDevolucionPorcentajeDiariaDesplazamientoBaseV1RunAlgoritmo
        .execute(this.runTarea, this.algoritmo);

    assertNotNull(result);
  }

}
