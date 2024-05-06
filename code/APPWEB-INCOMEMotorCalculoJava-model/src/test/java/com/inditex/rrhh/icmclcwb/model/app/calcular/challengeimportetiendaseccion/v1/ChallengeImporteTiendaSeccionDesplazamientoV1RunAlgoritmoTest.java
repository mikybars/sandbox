package com.inditex.rrhh.icmclcwb.model.app.calcular.challengeimportetiendaseccion.v1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.inditex.rrhh.icmclcwb.api.app.calcular.properties.dto.RunAlgoritmoPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.EstadoTareaCalculoPersonaEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaCalculoPersonaService;
import com.inditex.rrhh.icmclcwb.dto.AlgoritmoDTO;
import com.inditex.rrhh.icmclcwb.model.app.calcular.RunAlgoritmoTest;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaCalculoAlgoritmoChallengeImporteTiendaSeccionDesplazamientoV1RepositoryCustom;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.slf4j.Logger;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class ChallengeImporteTiendaSeccionDesplazamientoV1RunAlgoritmoTest implements RunAlgoritmoTest {
  private final static String SQL_CALCULAR = "SELECT * FROM TABLE WHERE 1";

  @Mock
  private Logger log;

  @Mock
  private RunAlgoritmoPropertiesDto runAlgoritmoProperties;

  @Mock
  private TareaCalculoAlgoritmoChallengeImporteTiendaSeccionDesplazamientoV1RepositoryCustom tareaCalculoAlgoritmoChallengeImporteTiendaSeccionDesplazamientoV1RepositoryCustom;

  @Mock
  private TareaCalculoPersonaService tareaCalculoPersonaService;

  @InjectMocks
  private ChallengeImporteTiendaSeccionDesplazamientoV1RunAlgoritmo challengeImporteTiendaSeccionDesplazamientoV1RunAlgoritmo;

  @Test
  void executeTest() {
    final IdPersonaLocalDto p1 = new IdPersonaLocalDto();
    final IdPersonaLocalDto p2 = new IdPersonaLocalDto();
    final List<IdPersonaLocalDto> personas = new ArrayList<>();
    personas.add(p1);
    personas.add(p2);
    when(this.tareaCalculoAlgoritmoChallengeImporteTiendaSeccionDesplazamientoV1RepositoryCustom.ids(any(AlgoritmoDTO.class), any(
        TareaDto.class))).thenReturn(personas);

    when(this.runAlgoritmoProperties.getCalculo()).thenReturn(this.createRunAlgoritmoCalculoPropertiesDto(2));
    final CompletableFuture<Void> completedFuture = new CompletableFuture<>();
    completedFuture.complete(null);
    when(this.tareaCalculoAlgoritmoChallengeImporteTiendaSeccionDesplazamientoV1RepositoryCustom.calcular(any(AlgoritmoDTO.class), any(
        TareaDto.class), anyList())).thenReturn(completedFuture);
    final AlgoritmoDTO algoritmo = new AlgoritmoDTO();
    this.challengeImporteTiendaSeccionDesplazamientoV1RunAlgoritmo.execute(this.createRunTareaDto(2L, 3L), algoritmo);
    verify(this.tareaCalculoAlgoritmoChallengeImporteTiendaSeccionDesplazamientoV1RepositoryCustom, times(1))
        .calcular(any(AlgoritmoDTO.class), any(
            TareaDto.class), anyList());
  }

  @Test
  void executeExceptionTest() {
    final IdPersonaLocalDto p1 = new IdPersonaLocalDto();
    final IdPersonaLocalDto p2 = new IdPersonaLocalDto();
    final List<IdPersonaLocalDto> personas = new ArrayList<>();
    personas.add(p1);
    personas.add(p2);
    when(this.tareaCalculoAlgoritmoChallengeImporteTiendaSeccionDesplazamientoV1RepositoryCustom.ids(any(AlgoritmoDTO.class), any(
        TareaDto.class))).thenReturn(personas);

    when(this.runAlgoritmoProperties.getCalculo()).thenReturn(this.createRunAlgoritmoCalculoPropertiesDto(2));

    final CompletableFuture<Void> completedFuture = new CompletableFuture<>();
    completedFuture.complete(null);
    final RuntimeException exception = new RuntimeException("EEEE");
    doThrow(exception)
        .when(this.tareaCalculoAlgoritmoChallengeImporteTiendaSeccionDesplazamientoV1RepositoryCustom)
        .calcular(any(AlgoritmoDTO.class), any(
            TareaDto.class), anyList());
    final AlgoritmoDTO algoritmo = new AlgoritmoDTO();
    this.challengeImporteTiendaSeccionDesplazamientoV1RunAlgoritmo.execute(this.createRunTareaDto(2L, 3L), algoritmo);
    verify(this.tareaCalculoPersonaService, times(1)).updateWithEstadoAndidPersona(personas, this.createRunTareaDto(2L, 3L),
        EstadoTareaCalculoPersonaEnum.KO.getDto());
  }

  @Test
  void getSqlCalcularTest() {
    when(this.tareaCalculoAlgoritmoChallengeImporteTiendaSeccionDesplazamientoV1RepositoryCustom
        .getSqlCalcular(any(AlgoritmoDTO.class))).thenReturn(SQL_CALCULAR);
    assertEquals(SQL_CALCULAR, this.challengeImporteTiendaSeccionDesplazamientoV1RunAlgoritmo.getSqlCalcular(new AlgoritmoDTO()));
  }
}
