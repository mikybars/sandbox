package com.inditex.rrhh.icmclcwb.model.app.calcular.challengeimportetienda.v1;

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

import com.inditex.rrhh.icmclcwb.api.app.calcular.properties.dto.RunAlgoritmoCalculoPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.app.calcular.properties.dto.RunAlgoritmoPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdPersonaLocalDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.EstadoTareaCalculoPersonaEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaCalculoPersonaService;
import com.inditex.rrhh.icmclcwb.dto.AlgoritmoDTO;
import com.inditex.rrhh.icmclcwb.dto.TrabajoDTO;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaCalculoAlgoritmoChallengeImporteTiendaDesplazamientoV1RepositoryCustom;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.slf4j.Logger;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith({SpringExtension.class})
class ChallengeImporteTiendaDesplazamientoV1RunAlgoritmoTest {

  private final static String SQL_CALCULAR = "SELECT * FROM TABLE WHERE 1";

  @Mock
  private Logger log;

  @Mock
  private RunAlgoritmoPropertiesDto runAlgoritmoProperties;

  @Mock
  private TareaCalculoAlgoritmoChallengeImporteTiendaDesplazamientoV1RepositoryCustom tareaCalculoAlgoritmoChallengeImporteTiendaDesplazamientoV1RepositoryCustom;

  @Mock
  private TareaCalculoPersonaService tareaCalculoPersonaService;

  @InjectMocks
  private ChallengeImporteTiendaDesplazamientoV1RunAlgoritmo challengeImporteTiendaDesplazamientoV1RunAlgoritmo;

  @Test
  void executeTest() {
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
    final RunTareaDto runTarea = RunTareaDto.builder().tarea(tarea).trabajo(trabajo).build();

    final AlgoritmoDTO algoritmo = new AlgoritmoDTO();

    final CompletableFuture completableFuture = new CompletableFuture<>();
    completableFuture.complete(null);

    final RunAlgoritmoCalculoPropertiesDto runAlgoritmoCalculoPropertiesDto = new RunAlgoritmoCalculoPropertiesDto();
    runAlgoritmoCalculoPropertiesDto.setBatchSize(5);
    runAlgoritmoCalculoPropertiesDto.setThreadSize(5);
    when(this.runAlgoritmoProperties.getCalculo()).thenReturn(runAlgoritmoCalculoPropertiesDto);

    when(this.tareaCalculoAlgoritmoChallengeImporteTiendaDesplazamientoV1RepositoryCustom.calcular(any(AlgoritmoDTO.class),
        any(TareaDto.class), anyList())).thenReturn(
            completableFuture);

    when(this.tareaCalculoAlgoritmoChallengeImporteTiendaDesplazamientoV1RepositoryCustom.ids(any(AlgoritmoDTO.class), any(TareaDto.class)))
        .thenReturn(personas);

    this.challengeImporteTiendaDesplazamientoV1RunAlgoritmo.execute(runTarea, algoritmo);

    verify(this.tareaCalculoAlgoritmoChallengeImporteTiendaDesplazamientoV1RepositoryCustom, times(1)).calcular(any(AlgoritmoDTO.class),
        any(TareaDto.class), anyList());
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

    when(this.tareaCalculoAlgoritmoChallengeImporteTiendaDesplazamientoV1RepositoryCustom.ids(any(AlgoritmoDTO.class), any(TareaDto.class)))
        .thenReturn(personas);

    final RuntimeException exception = new RuntimeException("EE");
    doThrow(exception)
        .when(this.tareaCalculoAlgoritmoChallengeImporteTiendaDesplazamientoV1RepositoryCustom).calcular(any(AlgoritmoDTO.class), any(
            TareaDto.class), anyList());
    final TrabajoDTO trabajo = new TrabajoDTO();
    trabajo.setId(2231L);
    final TareaDto tarea = new TareaDto();
    tarea.setId(12549L);
    final RunTareaDto runTarea = RunTareaDto.builder().tarea(tarea).trabajo(trabajo).build();

    final AlgoritmoDTO algoritmo = new AlgoritmoDTO();
    this.challengeImporteTiendaDesplazamientoV1RunAlgoritmo.execute(runTarea, algoritmo);

    verify(this.tareaCalculoPersonaService, times(1)).updateWithEstadoAndidPersona(personas, runTarea,
        EstadoTareaCalculoPersonaEnum.KO.getDto());
  }

  @Test
  void getSqlCalcularTest() {
    when(this.tareaCalculoAlgoritmoChallengeImporteTiendaDesplazamientoV1RepositoryCustom.getSqlCalcular(any(AlgoritmoDTO.class)))
        .thenReturn(SQL_CALCULAR);
    assertEquals(SQL_CALCULAR, this.challengeImporteTiendaDesplazamientoV1RunAlgoritmo.getSqlCalcular(new AlgoritmoDTO()));

  }
}
