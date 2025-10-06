package com.inditex.rrhh.icmclcwb.model.app.calcular.challengedirectoventa.v1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
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
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaCalculoAlgoritmoChallengeDirectoVentaPorcentajeDesplazamientoV1RepositoryCustom;

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
public class ChallengeDirectoVentaReduccionJornadaPorcentajeDesplazamientoV1RunAlgoritmoTest {

  private static final String SQL_CALCULAR = "SELECT * FROM TABLE WHERE challenge_directo_venta_reduccion_jornada_porcentaje_desplazamiento = 1";

  @Mock
  private Logger log;

  @Mock
  private TareaCalculoAlgoritmoChallengeDirectoVentaPorcentajeDesplazamientoV1RepositoryCustom tareaCalculoAlgoritmoChallengeDirectoVentaPorcentajeDesplazamientoV1RepositoryCustom;

  @Mock
  private TareaCalculoPersonaService tareaCalculoPersonaService;

  @Mock
  @Qualifier("runAlgoritmoProperties")
  private RunAlgoritmoPropertiesDto runAlgoritmoProperties;

  @InjectMocks
  private ChallengeDirectoVentaReduccionJornadaPorcentajeDesplazamientoV1RunAlgoritmo challengeDirectoVentaReduccionJornadaPorcentajeDesplazamientoV1RunAlgoritmo;

  // Datos de prueba generados con Instancio
  private final AlgoritmoDTO algoritmo = Instancio.create(AlgoritmoDTO.class);

  private final RunTareaDto runTarea = Instancio.create(RunTareaDto.class);

  @Test
  void executeTest() {
    // Given - Datos de prueba
    final IdPersonaLocalDto p1 = new IdPersonaLocalDto("1", "2");
    final IdPersonaLocalDto p2 = new IdPersonaLocalDto("2", "2");
    final IdPersonaLocalDto p3 = new IdPersonaLocalDto("3", "2");
    final List<IdPersonaLocalDto> personas = new ArrayList<>();
    personas.add(p1);
    personas.add(p2);
    personas.add(p3);

    final TrabajoDTO trabajo = new TrabajoDTO();
    trabajo.setId(2231L);
    final TareaDto tarea = new TareaDto();
    tarea.setId(12549L);
    final RunTareaDto runTareaPrueba = RunTareaDto.builder().tarea(tarea).trabajo(trabajo).build();

    final AlgoritmoDTO algoritmoPrueba = new AlgoritmoDTO();

    final CompletableFuture<Void> completableFuture = CompletableFuture.completedFuture(AsyncConstants.NIL);

    final RunAlgoritmoCalculoPropertiesDto runAlgoritmoCalculoPropertiesDto = new RunAlgoritmoCalculoPropertiesDto();
    runAlgoritmoCalculoPropertiesDto.setBatchSize(5);
    runAlgoritmoCalculoPropertiesDto.setThreadSize(5);

    // When - Configuración de mocks
    when(this.runAlgoritmoProperties.getCalculo()).thenReturn(runAlgoritmoCalculoPropertiesDto);

    when(this.tareaCalculoAlgoritmoChallengeDirectoVentaPorcentajeDesplazamientoV1RepositoryCustom
        .calcular(any(AlgoritmoDTO.class), any(TareaDto.class), anyList()))
            .thenReturn(completableFuture);

    when(this.tareaCalculoAlgoritmoChallengeDirectoVentaPorcentajeDesplazamientoV1RepositoryCustom
        .ids(any(AlgoritmoDTO.class), any(TareaDto.class)))
            .thenReturn(personas);

    // Then - Ejecución y verificación
    final CompletableFuture<Void> result = this.challengeDirectoVentaReduccionJornadaPorcentajeDesplazamientoV1RunAlgoritmo
        .execute(runTareaPrueba, algoritmoPrueba);

    assertNotNull(result);
    verify(this.tareaCalculoAlgoritmoChallengeDirectoVentaPorcentajeDesplazamientoV1RepositoryCustom, times(1))
        .calcular(any(AlgoritmoDTO.class), any(TareaDto.class), anyList());
    verify(this.tareaCalculoAlgoritmoChallengeDirectoVentaPorcentajeDesplazamientoV1RepositoryCustom, times(1))
        .ids(any(AlgoritmoDTO.class), any(TareaDto.class));
  }

  @Test
  void executeExceptionTest() {
    // Given - Datos de prueba
    final IdPersonaLocalDto p1 = new IdPersonaLocalDto("1", "2");
    final IdPersonaLocalDto p2 = new IdPersonaLocalDto("2", "2");
    final List<IdPersonaLocalDto> personas = new ArrayList<>();
    personas.add(p1);
    personas.add(p2);

    final TrabajoDTO trabajo = new TrabajoDTO();
    trabajo.setId(2231L);
    final TareaDto tarea = new TareaDto();
    tarea.setId(12549L);
    final RunTareaDto runTareaPrueba = RunTareaDto.builder().tarea(tarea).trabajo(trabajo).build();

    final AlgoritmoDTO algoritmoPrueba = new AlgoritmoDTO();

    final RunAlgoritmoCalculoPropertiesDto runAlgoritmoCalculoPropertiesDto = new RunAlgoritmoCalculoPropertiesDto();
    runAlgoritmoCalculoPropertiesDto.setBatchSize(5);
    runAlgoritmoCalculoPropertiesDto.setThreadSize(5);

    // When - Configuración de mocks con excepción
    when(this.runAlgoritmoProperties.getCalculo()).thenReturn(runAlgoritmoCalculoPropertiesDto);

    when(this.tareaCalculoAlgoritmoChallengeDirectoVentaPorcentajeDesplazamientoV1RepositoryCustom
        .ids(any(AlgoritmoDTO.class), any(TareaDto.class)))
            .thenReturn(personas);

    final RuntimeException exception = new RuntimeException("Error de prueba");
    doThrow(exception)
        .when(this.tareaCalculoAlgoritmoChallengeDirectoVentaPorcentajeDesplazamientoV1RepositoryCustom)
        .calcular(any(AlgoritmoDTO.class), any(TareaDto.class), anyList());

    // Then - Ejecución y verificación
    final CompletableFuture<Void> result = this.challengeDirectoVentaReduccionJornadaPorcentajeDesplazamientoV1RunAlgoritmo
        .execute(runTareaPrueba, algoritmoPrueba);

    assertNotNull(result);
    verify(this.tareaCalculoPersonaService, times(1))
        .updateWithEstadoAndidPersona(personas, runTareaPrueba, EstadoTareaCalculoPersonaEnum.KO.getDto());
  }

  @Test
  void getSqlCalcularTest() {
    // Given
    final AlgoritmoDTO algoritmoPrueba = new AlgoritmoDTO();

    // When
    when(this.tareaCalculoAlgoritmoChallengeDirectoVentaPorcentajeDesplazamientoV1RepositoryCustom
        .getSqlCalcular(any(AlgoritmoDTO.class)))
            .thenReturn(SQL_CALCULAR);

    // Then
    final String result = this.challengeDirectoVentaReduccionJornadaPorcentajeDesplazamientoV1RunAlgoritmo
        .getSqlCalcular(algoritmoPrueba);

    assertEquals(SQL_CALCULAR, result);
    verify(this.tareaCalculoAlgoritmoChallengeDirectoVentaPorcentajeDesplazamientoV1RepositoryCustom, times(1))
        .getSqlCalcular(algoritmoPrueba);
  }

  @ParameterizedTest
  @InstancioSource(samples = 3)
  void executeTestWithInstancio(final List<IdPersonaLocalDto> ids,
      final RunAlgoritmoCalculoPropertiesDto runAlgoritmoCalculoPropertiesDto) {
    // Given
    final CompletableFuture<Void> completableFuture = CompletableFuture.completedFuture(AsyncConstants.NIL);

    // When
    doReturn(ids).when(this.tareaCalculoAlgoritmoChallengeDirectoVentaPorcentajeDesplazamientoV1RepositoryCustom)
        .ids(this.algoritmo, this.runTarea.getTarea());

    doReturn(runAlgoritmoCalculoPropertiesDto).when(this.runAlgoritmoProperties).getCalculo();
    final RunAlgoritmoCalculoPropertiesDto spiedItem = Mockito.spy(runAlgoritmoCalculoPropertiesDto);
    doReturn(1).when(spiedItem).getThreadSize();

    doReturn(completableFuture).when(this.tareaCalculoAlgoritmoChallengeDirectoVentaPorcentajeDesplazamientoV1RepositoryCustom)
        .calcular(this.algoritmo, this.runTarea.getTarea(), ids);

    // Then
    final CompletableFuture<Void> result = this.challengeDirectoVentaReduccionJornadaPorcentajeDesplazamientoV1RunAlgoritmo
        .execute(this.runTarea, this.algoritmo);

    assertNotNull(result);
  }

  @ParameterizedTest
  @InstancioSource(samples = 2)
  void executeTestExceptionWithInstancio(final List<IdPersonaLocalDto> ids,
      final RunAlgoritmoCalculoPropertiesDto runAlgoritmoCalculoPropertiesDto) {
    // Given - When
    doReturn(ids).when(this.tareaCalculoAlgoritmoChallengeDirectoVentaPorcentajeDesplazamientoV1RepositoryCustom)
        .ids(this.algoritmo, this.runTarea.getTarea());

    doReturn(runAlgoritmoCalculoPropertiesDto).when(this.runAlgoritmoProperties).getCalculo();
    final RunAlgoritmoCalculoPropertiesDto spiedItem = Mockito.spy(runAlgoritmoCalculoPropertiesDto);
    doReturn(1).when(spiedItem).getThreadSize();

    doThrow(new RuntimeException("Error con Instancio"))
        .when(this.tareaCalculoAlgoritmoChallengeDirectoVentaPorcentajeDesplazamientoV1RepositoryCustom)
        .calcular(this.algoritmo, this.runTarea.getTarea(), ids);

    // Then
    final CompletableFuture<Void> result = this.challengeDirectoVentaReduccionJornadaPorcentajeDesplazamientoV1RunAlgoritmo
        .execute(this.runTarea, this.algoritmo);

    assertNotNull(result);
  }

  @ParameterizedTest
  @InstancioSource(samples = 1)
  void getSqlCalcularTestWithInstancio(final AlgoritmoDTO algoritmoInstancio) {
    // Given - When
    doReturn(SQL_CALCULAR).when(this.tareaCalculoAlgoritmoChallengeDirectoVentaPorcentajeDesplazamientoV1RepositoryCustom)
        .getSqlCalcular(algoritmoInstancio);

    // Then
    final String result = this.challengeDirectoVentaReduccionJornadaPorcentajeDesplazamientoV1RunAlgoritmo
        .getSqlCalcular(algoritmoInstancio);

    assertNotNull(result);
    assertEquals(SQL_CALCULAR, result);
  }

  @Test
  void executeTestWithEmptyIds() {
    // Given - Lista vacía para probar el caso edge
    final List<IdPersonaLocalDto> personasVacias = new ArrayList<>();
    final AlgoritmoDTO algoritmoPrueba = new AlgoritmoDTO();

    final TrabajoDTO trabajo = new TrabajoDTO();
    trabajo.setId(1L);
    final TareaDto tarea = new TareaDto();
    tarea.setId(1L);
    final RunTareaDto runTareaPrueba = RunTareaDto.builder().tarea(tarea).trabajo(trabajo).build();

    final RunAlgoritmoCalculoPropertiesDto runAlgoritmoCalculoPropertiesDto = new RunAlgoritmoCalculoPropertiesDto();
    runAlgoritmoCalculoPropertiesDto.setBatchSize(5);
    runAlgoritmoCalculoPropertiesDto.setThreadSize(5);

    // When
    when(this.runAlgoritmoProperties.getCalculo()).thenReturn(runAlgoritmoCalculoPropertiesDto);
    when(this.tareaCalculoAlgoritmoChallengeDirectoVentaPorcentajeDesplazamientoV1RepositoryCustom
        .ids(any(AlgoritmoDTO.class), any(TareaDto.class)))
            .thenReturn(personasVacias);

    // Then
    final CompletableFuture<Void> result = this.challengeDirectoVentaReduccionJornadaPorcentajeDesplazamientoV1RunAlgoritmo
        .execute(runTareaPrueba, algoritmoPrueba);

    assertNotNull(result);
    // Verificar que no se llama calcular cuando no hay personas
    verify(this.tareaCalculoAlgoritmoChallengeDirectoVentaPorcentajeDesplazamientoV1RepositoryCustom, times(0))
        .calcular(any(AlgoritmoDTO.class), any(TareaDto.class), anyList());
  }

  @Test
  void executeTestWithLargeBatch() {
    // Given - Lote grande para probar la lógica de particionado
    final List<IdPersonaLocalDto> personasGrandes = new ArrayList<>();
    for (int i = 1; i <= 15; i++) {
      personasGrandes.add(new IdPersonaLocalDto(String.valueOf(i), "local"));
    }

    final AlgoritmoDTO algoritmoPrueba = new AlgoritmoDTO();
    final TrabajoDTO trabajo = new TrabajoDTO();
    trabajo.setId(3L);
    final TareaDto tarea = new TareaDto();
    tarea.setId(3L);
    final RunTareaDto runTareaPrueba = RunTareaDto.builder().tarea(tarea).trabajo(trabajo).build();

    final CompletableFuture<Void> completableFuture = CompletableFuture.completedFuture(AsyncConstants.NIL);

    final RunAlgoritmoCalculoPropertiesDto runAlgoritmoCalculoPropertiesDto = new RunAlgoritmoCalculoPropertiesDto();
    runAlgoritmoCalculoPropertiesDto.setBatchSize(5); // Batch size smaller than personas list
    runAlgoritmoCalculoPropertiesDto.setThreadSize(3);

    // When
    when(this.runAlgoritmoProperties.getCalculo()).thenReturn(runAlgoritmoCalculoPropertiesDto);
    when(this.tareaCalculoAlgoritmoChallengeDirectoVentaPorcentajeDesplazamientoV1RepositoryCustom
        .ids(any(AlgoritmoDTO.class), any(TareaDto.class)))
            .thenReturn(personasGrandes);
    when(this.tareaCalculoAlgoritmoChallengeDirectoVentaPorcentajeDesplazamientoV1RepositoryCustom
        .calcular(any(AlgoritmoDTO.class), any(TareaDto.class), anyList()))
            .thenReturn(completableFuture);

    // Then
    final CompletableFuture<Void> result = this.challengeDirectoVentaReduccionJornadaPorcentajeDesplazamientoV1RunAlgoritmo
        .execute(runTareaPrueba, algoritmoPrueba);

    assertNotNull(result);
    // Should be called multiple times due to partitioning (15 items / 5 batch size = 3 calls)
    verify(this.tareaCalculoAlgoritmoChallengeDirectoVentaPorcentajeDesplazamientoV1RepositoryCustom, times(3))
        .calcular(any(AlgoritmoDTO.class), any(TareaDto.class), anyList());
  }

}
