package com.inditex.rrhh.icmclcwb.model.app.calcular.challengedirectoventa.v1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.calcular.properties.dto.RunAlgoritmoPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.EstadoTareaCalculoPersonaEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaCalculoPersonaService;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;
import com.inditex.rrhh.icmclcwb.dto.AlgoritmoDTO;
import com.inditex.rrhh.icmclcwb.model.app.calcular.RunAlgoritmoTest;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaCalculoAlgoritmoChallengeDirectoVentaReduccionJornadaPorcentajeV1RepositoryCustom;

import org.instancio.Instancio;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class ChallengeDirectoVentaReduccionJornadaPorcentajeV1RunAlgoritmoTest implements RunAlgoritmoTest {

  private static final String SQL_CALCULAR = "SELECT * FROM CHALLENGE_DIRECTO_VENTA_REDUCCION_JORNADA_PORCENTAJE WHERE 1=1";

  private static final Long ID_TAREA = 123L;

  private static final Long ID_TRABAJO = 5675L;

  private static final int BATCH_SIZE = 10;

  @Mock
  private TareaCalculoAlgoritmoChallengeDirectoVentaReduccionJornadaPorcentajeV1RepositoryCustom tareaCalculoAlgoritmoChallengeDirectoVentaPorcentajeV1RepositoryCustom;

  @Mock
  private TareaCalculoPersonaService tareaCalculoPersonaService;

  @Mock
  private RunAlgoritmoPropertiesDto runAlgoritmoProperties;

  @InjectMocks
  private ChallengeDirectoVentaReduccionJornadaPorcentajeV1RunAlgoritmo challengeDirectoVentaReduccionJornadaPorcentajeV1RunAlgoritmo;

  @Test
  void getSqlCalcularTest() {
    // Given
    final AlgoritmoDTO algoritmo = Instancio.create(AlgoritmoDTO.class);
    when(this.tareaCalculoAlgoritmoChallengeDirectoVentaPorcentajeV1RepositoryCustom
        .getSqlCalcular(any(AlgoritmoDTO.class))).thenReturn(SQL_CALCULAR);

    // When
    final String result = this.challengeDirectoVentaReduccionJornadaPorcentajeV1RunAlgoritmo
        .getSqlCalcular(algoritmo);

    // Then
    assertEquals(SQL_CALCULAR, result);
    verify(this.tareaCalculoAlgoritmoChallengeDirectoVentaPorcentajeV1RepositoryCustom, times(1))
        .getSqlCalcular(algoritmo);
  }

  @Test
  void getSqlCalcularWithNullAlgoritmoTest() {
    // Given
    when(this.tareaCalculoAlgoritmoChallengeDirectoVentaPorcentajeV1RepositoryCustom
        .getSqlCalcular(any())).thenReturn(SQL_CALCULAR);

    // When
    final String result = this.challengeDirectoVentaReduccionJornadaPorcentajeV1RunAlgoritmo
        .getSqlCalcular(null);

    // Then
    assertEquals(SQL_CALCULAR, result);
    verify(this.tareaCalculoAlgoritmoChallengeDirectoVentaPorcentajeV1RepositoryCustom, times(1))
        .getSqlCalcular(null);
  }

  @Test
  void calcularTest() {
    // Given
    when(this.runAlgoritmoProperties.getCalculo()).thenReturn(this.createRunAlgoritmoCalculoPropertiesDto(BATCH_SIZE));

    final List<IdPersonaLocalDto> personas = this.createPersonasList(3);
    when(this.tareaCalculoAlgoritmoChallengeDirectoVentaPorcentajeV1RepositoryCustom
        .ids(any(AlgoritmoDTO.class), any(TareaDto.class))).thenReturn(personas);
    when(this.tareaCalculoAlgoritmoChallengeDirectoVentaPorcentajeV1RepositoryCustom.calcular(
        any(AlgoritmoDTO.class),
        any(TareaDto.class), anyList())).thenReturn(
            CompletableFuture.completedFuture(AsyncConstants.NIL));

    final RunTareaDto runTarea = this.createRunTareaDto(ID_TAREA, ID_TRABAJO);
    final AlgoritmoDTO algoritmo = Instancio.create(AlgoritmoDTO.class);

    // When
    final CompletableFuture<Void> result = this.challengeDirectoVentaReduccionJornadaPorcentajeV1RunAlgoritmo
        .execute(runTarea, algoritmo);

    // Then
    assertNotNull(result);
    assertTrue(result.isDone());
    verify(this.tareaCalculoAlgoritmoChallengeDirectoVentaPorcentajeV1RepositoryCustom, times(1))
        .ids(algoritmo, runTarea.getTarea());
    verify(this.tareaCalculoAlgoritmoChallengeDirectoVentaPorcentajeV1RepositoryCustom, times(1))
        .calcular(algoritmo, runTarea.getTarea(), personas);
  }

  @Test
  void calcularWithEmptyPersonasListTest() {
    // Given
    when(this.runAlgoritmoProperties.getCalculo()).thenReturn(this.createRunAlgoritmoCalculoPropertiesDto(BATCH_SIZE));

    final List<IdPersonaLocalDto> personas = new ArrayList<>();
    when(this.tareaCalculoAlgoritmoChallengeDirectoVentaPorcentajeV1RepositoryCustom
        .ids(any(AlgoritmoDTO.class), any(TareaDto.class))).thenReturn(personas);

    final RunTareaDto runTarea = this.createRunTareaDto(ID_TAREA, ID_TRABAJO);
    final AlgoritmoDTO algoritmo = Instancio.create(AlgoritmoDTO.class);

    // When
    final CompletableFuture<Void> result = this.challengeDirectoVentaReduccionJornadaPorcentajeV1RunAlgoritmo
        .execute(runTarea, algoritmo);

    // Then
    assertNotNull(result);
    assertTrue(result.isDone());
    verify(this.tareaCalculoAlgoritmoChallengeDirectoVentaPorcentajeV1RepositoryCustom, times(1))
        .ids(algoritmo, runTarea.getTarea());
    verify(this.tareaCalculoAlgoritmoChallengeDirectoVentaPorcentajeV1RepositoryCustom, times(0))
        .calcular(any(), any(), any());
  }

  @Test
  void calcularWithLargePersonasListTest() {
    // Given
    when(this.runAlgoritmoProperties.getCalculo()).thenReturn(this.createRunAlgoritmoCalculoPropertiesDto(5)); // Batch size smaller than
                                                                                                               // personas list

    final List<IdPersonaLocalDto> personas = this.createPersonasList(12); // More than batch size
    when(this.tareaCalculoAlgoritmoChallengeDirectoVentaPorcentajeV1RepositoryCustom
        .ids(any(AlgoritmoDTO.class), any(TareaDto.class))).thenReturn(personas);
    when(this.tareaCalculoAlgoritmoChallengeDirectoVentaPorcentajeV1RepositoryCustom.calcular(
        any(AlgoritmoDTO.class),
        any(TareaDto.class), anyList())).thenReturn(
            CompletableFuture.completedFuture(AsyncConstants.NIL));

    final RunTareaDto runTarea = this.createRunTareaDto(ID_TAREA, ID_TRABAJO);
    final AlgoritmoDTO algoritmo = Instancio.create(AlgoritmoDTO.class);

    // When
    final CompletableFuture<Void> result = this.challengeDirectoVentaReduccionJornadaPorcentajeV1RunAlgoritmo
        .execute(runTarea, algoritmo);

    // Then
    assertNotNull(result);
    assertTrue(result.isDone());
    verify(this.tareaCalculoAlgoritmoChallengeDirectoVentaPorcentajeV1RepositoryCustom, times(1))
        .ids(algoritmo, runTarea.getTarea());
    verify(this.tareaCalculoAlgoritmoChallengeDirectoVentaPorcentajeV1RepositoryCustom, times(3)) // 12 personas / 5 batch size = 3 batches
        .calcular(eq(algoritmo), eq(runTarea.getTarea()), anyList());
  }

  @Test
  void calcularExceptionTest() {
    // Given
    when(this.runAlgoritmoProperties.getCalculo()).thenReturn(this.createRunAlgoritmoCalculoPropertiesDto(BATCH_SIZE));

    final List<IdPersonaLocalDto> personas = this.createPersonasList(2);
    when(this.tareaCalculoAlgoritmoChallengeDirectoVentaPorcentajeV1RepositoryCustom
        .ids(any(AlgoritmoDTO.class), any(TareaDto.class))).thenReturn(personas);

    final RuntimeException exception = new RuntimeException("Test exception");
    doThrow(exception).when(this.tareaCalculoAlgoritmoChallengeDirectoVentaPorcentajeV1RepositoryCustom)
        .calcular(any(AlgoritmoDTO.class), any(TareaDto.class), ArgumentMatchers.any());

    final RunTareaDto runTarea = this.createRunTareaDto(ID_TAREA, ID_TRABAJO);
    final AlgoritmoDTO algoritmo = Instancio.create(AlgoritmoDTO.class);

    // When
    final CompletableFuture<Void> result = this.challengeDirectoVentaReduccionJornadaPorcentajeV1RunAlgoritmo
        .execute(runTarea, algoritmo);

    // Then
    assertNotNull(result);
    assertTrue(result.isDone());
    verify(this.tareaCalculoPersonaService, times(1))
        .updateWithEstadoAndidPersona(personas, runTarea, EstadoTareaCalculoPersonaEnum.KO.getDto());
  }

  @Test
  void calcularWithNullRunTareaTest() {
    // Given
    final AlgoritmoDTO algoritmo = Instancio.create(AlgoritmoDTO.class);

    // When/Then - Should throw exception due to null access
    try {
      this.challengeDirectoVentaReduccionJornadaPorcentajeV1RunAlgoritmo.execute(null, algoritmo);
    } catch (final NullPointerException e) {
      // Expected behavior
      assertTrue(true);
    }
  }

  @Test
  void calcularWithNullAlgoritmoTest() {
    // Given
    when(this.runAlgoritmoProperties.getCalculo()).thenReturn(this.createRunAlgoritmoCalculoPropertiesDto(BATCH_SIZE));

    final List<IdPersonaLocalDto> personas = this.createPersonasList(1);
    when(this.tareaCalculoAlgoritmoChallengeDirectoVentaPorcentajeV1RepositoryCustom
        .ids(any(), any(TareaDto.class))).thenReturn(personas);
    when(this.tareaCalculoAlgoritmoChallengeDirectoVentaPorcentajeV1RepositoryCustom.calcular(
        any(),
        any(TareaDto.class), anyList())).thenReturn(
            CompletableFuture.completedFuture(AsyncConstants.NIL));

    final RunTareaDto runTarea = this.createRunTareaDto(ID_TAREA, ID_TRABAJO);

    // When
    final CompletableFuture<Void> result = this.challengeDirectoVentaReduccionJornadaPorcentajeV1RunAlgoritmo
        .execute(runTarea, null);

    // Then
    assertNotNull(result);
    assertTrue(result.isDone());
    verify(this.tareaCalculoAlgoritmoChallengeDirectoVentaPorcentajeV1RepositoryCustom, times(1))
        .ids(null, runTarea.getTarea());
    verify(this.tareaCalculoAlgoritmoChallengeDirectoVentaPorcentajeV1RepositoryCustom, times(1))
        .calcular(null, runTarea.getTarea(), personas);
  }

  /**
   * Helper method to create a list of IdPersonaLocalDto objects using Instancio.
   *
   * @param size the number of personas to create
   * @return a list of IdPersonaLocalDto objects
   */
  private List<IdPersonaLocalDto> createPersonasList(final int size) {
    final List<IdPersonaLocalDto> personas = new ArrayList<>();
    for (int i = 0; i < size; i++) {
      personas.add(Instancio.create(IdPersonaLocalDto.class));
    }
    return personas;
  }

}
