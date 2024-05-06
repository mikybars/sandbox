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
import com.inditex.rrhh.icmclcwb.model.app.calcular.RunAlgoritmoTest;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaCalculoAlgoritmoChallengeImporteTiendaV1RepositoryCustom;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.slf4j.Logger;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith({SpringExtension.class})
class ChallengeImporteTiendaV1RunAlgoritmoTest implements RunAlgoritmoTest {

  private final static String SQL_CALCULAR = "SELECT * FROM TABLE WHERE 1";

  @Mock
  private Logger log;

  @Mock
  private RunAlgoritmoPropertiesDto runAlgoritmoProperties;

  @Mock
  private TareaCalculoAlgoritmoChallengeImporteTiendaV1RepositoryCustom tareaCalculoAlgoritmoChallengeImporteTiendaV1RepositoryCustom;

  @Mock
  private TareaCalculoPersonaService tareaCalculoPersonaService;

  @InjectMocks
  private ChallengeImporteTiendaV1RunAlgoritmo challengeImporteTiendaV1RunAlgoritmo;

  @Test
  void executeTest() {

    final IdPersonaLocalDto p1 = new IdPersonaLocalDto("1", "10");
    final IdPersonaLocalDto p2 = new IdPersonaLocalDto("2", "10");
    final IdPersonaLocalDto p3 = new IdPersonaLocalDto("3", "10");

    final List<IdPersonaLocalDto> personas = new ArrayList<>();
    personas.add(p1);
    personas.add(p2);
    personas.add(p3);

    final TareaDto tarea = new TareaDto();
    tarea.setId(1245L);
    final TrabajoDTO trabajo = new TrabajoDTO();
    trabajo.setId(98765L);
    final RunTareaDto runTarea = RunTareaDto.builder().tarea(tarea).trabajo(trabajo).build();

    final AlgoritmoDTO algoritmo = new AlgoritmoDTO();
    final RunAlgoritmoCalculoPropertiesDto runAlgoritmoCalculoPropertiesDto = new RunAlgoritmoCalculoPropertiesDto();
    runAlgoritmoCalculoPropertiesDto.setBatchSize(10);
    runAlgoritmoCalculoPropertiesDto.setThreadSize(10);
    final CompletableFuture completableFuture = new CompletableFuture<>();
    completableFuture.complete(null);

    when(this.runAlgoritmoProperties.getCalculo()).thenReturn(runAlgoritmoCalculoPropertiesDto);

    when(this.tareaCalculoAlgoritmoChallengeImporteTiendaV1RepositoryCustom.ids(any(AlgoritmoDTO.class), any(TareaDto.class)))
        .thenReturn(personas);
    when(this.tareaCalculoAlgoritmoChallengeImporteTiendaV1RepositoryCustom.calcular(any(AlgoritmoDTO.class), any(TareaDto.class),
        anyList())).thenReturn(completableFuture);

    this.challengeImporteTiendaV1RunAlgoritmo.execute(runTarea, algoritmo);

    verify(this.tareaCalculoAlgoritmoChallengeImporteTiendaV1RepositoryCustom, times(1)).calcular(any(AlgoritmoDTO.class),
        any(TareaDto.class),
        anyList());
  }

  @Test
  void executeExceptionTest() {
    final IdPersonaLocalDto p1 = new IdPersonaLocalDto();
    final IdPersonaLocalDto p2 = new IdPersonaLocalDto();

    final List<IdPersonaLocalDto> personas = new ArrayList<>();
    personas.add(p1);
    personas.add(p2);

    when(this.tareaCalculoAlgoritmoChallengeImporteTiendaV1RepositoryCustom.ids(any(AlgoritmoDTO.class), any(TareaDto.class)))
        .thenReturn(personas);

    when(this.runAlgoritmoProperties.getCalculo()).thenReturn(this.createRunAlgoritmoCalculoPropertiesDto(2));

    final RuntimeException exception = new RuntimeException("EEEE");
    doThrow(exception)
        .when(this.tareaCalculoAlgoritmoChallengeImporteTiendaV1RepositoryCustom).calcular(any(AlgoritmoDTO.class), any(TareaDto.class),
            ArgumentMatchers.any());

    final Long idTarea = 1245L;
    final Long idTrabajo = 98765L;
    final AlgoritmoDTO algoritmo = new AlgoritmoDTO();
    final RunTareaDto runTarea = this.createRunTareaDto(idTarea, idTrabajo);

    this.challengeImporteTiendaV1RunAlgoritmo.execute(runTarea, algoritmo);

    verify(this.tareaCalculoPersonaService, times(1)).updateWithEstadoAndidPersona(personas, runTarea,
        EstadoTareaCalculoPersonaEnum.KO.getDto());
  }

  @Test
  void getSqlCalcularTest() {
    when(this.tareaCalculoAlgoritmoChallengeImporteTiendaV1RepositoryCustom.getSqlCalcular(any(AlgoritmoDTO.class)))
        .thenReturn(SQL_CALCULAR);
    assertEquals(SQL_CALCULAR, this.challengeImporteTiendaV1RunAlgoritmo.getSqlCalcular(new AlgoritmoDTO()));
  }
}
