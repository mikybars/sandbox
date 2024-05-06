package com.inditex.rrhh.icmclcwb.model.app.calcular.challengepreciohoratienda.v1;

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
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.EstadoTareaCalculoPersonaEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaCalculoPersonaService;
import com.inditex.rrhh.icmclcwb.dto.AlgoritmoDTO;
import com.inditex.rrhh.icmclcwb.model.app.calcular.RunAlgoritmoTest;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaCalculoAlgoritmoChallengePrecioHoraTiendaDesplazamientoBaseV1RepositoryCustom;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.slf4j.Logger;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class ChallengePrecioHoraTiendaDesplazamientoBaseV1RunAlgoritmoTest implements RunAlgoritmoTest {

  private final static String SQL_CALCULAR = "SELECT * FROM TABLE WHERE 1";

  @Mock
  private Logger log;

  @Mock
  private RunAlgoritmoPropertiesDto runAlgoritmoProperties;

  @Mock
  private TareaCalculoAlgoritmoChallengePrecioHoraTiendaDesplazamientoBaseV1RepositoryCustom tareaCalculoAlgoritmoChallengePrecioHoraTiendaDesplazamientoBaseV1RepositoryCustom;

  @Mock
  private TareaCalculoPersonaService tareaCalculoPersonaService;

  @InjectMocks
  private ChallengePrecioHoraTiendaDesplazamientoBaseV1RunAlgoritmo challengePrecioHoraTiendaDesplazamientoBaseV1RunAlgoritmo;

  @Test
  void executeTest() {
    final IdPersonaLocalDto p1 = new IdPersonaLocalDto();
    final IdPersonaLocalDto p2 = new IdPersonaLocalDto();
    final List<IdPersonaLocalDto> personas = new ArrayList<>();
    personas.add(p1);
    personas.add(p2);
    when(this.tareaCalculoAlgoritmoChallengePrecioHoraTiendaDesplazamientoBaseV1RepositoryCustom.ids(any(AlgoritmoDTO.class),
        any(TareaDto.class)))
            .thenReturn(personas);
    when(this.runAlgoritmoProperties.getCalculo()).thenReturn(this.createRunAlgoritmoCalculoPropertiesDto(2));

    final CompletableFuture<Void> future = new CompletableFuture<>();
    future.complete(null);
    when(this.tareaCalculoAlgoritmoChallengePrecioHoraTiendaDesplazamientoBaseV1RepositoryCustom.calcular(any(AlgoritmoDTO.class),
        any(TareaDto.class),
        anyList())).thenReturn(future);

    final AlgoritmoDTO algoritmo = new AlgoritmoDTO();

    this.challengePrecioHoraTiendaDesplazamientoBaseV1RunAlgoritmo.execute(this.createRunTareaDto(2L, 3L), algoritmo);
    verify(this.tareaCalculoAlgoritmoChallengePrecioHoraTiendaDesplazamientoBaseV1RepositoryCustom, times(1)).calcular(
        any(AlgoritmoDTO.class),
        any(TareaDto.class),
        anyList());
  }

  @Test
  void calcularExceptionTest() {

    final List<IdPersonaLocalDto> personas = new ArrayList<>();
    final IdPersonaLocalDto p1 = new IdPersonaLocalDto();
    personas.add(p1);
    final IdPersonaLocalDto p2 = new IdPersonaLocalDto();
    personas.add(p2);
    when(this.tareaCalculoAlgoritmoChallengePrecioHoraTiendaDesplazamientoBaseV1RepositoryCustom
        .ids(any(AlgoritmoDTO.class), any(TareaDto.class))).thenReturn(personas);

    when(this.runAlgoritmoProperties.getCalculo()).thenReturn(this.createRunAlgoritmoCalculoPropertiesDto(2));
    final RuntimeException exception = new RuntimeException("EEEE");
    doThrow(exception).when(this.tareaCalculoAlgoritmoChallengePrecioHoraTiendaDesplazamientoBaseV1RepositoryCustom)
        .calcular(any(AlgoritmoDTO.class), any(TareaDto.class),
            ArgumentMatchers.any());

    final long idTarea = 122L;
    final long idTrabajo = 5672L;
    final RunTareaDto runTarea = this.createRunTareaDto(idTarea, idTrabajo);
    final AlgoritmoDTO algoritmo = new AlgoritmoDTO();
    this.challengePrecioHoraTiendaDesplazamientoBaseV1RunAlgoritmo.execute(runTarea, algoritmo);

    verify(this.tareaCalculoPersonaService, times(1)).updateWithEstadoAndidPersona(personas, runTarea,
        EstadoTareaCalculoPersonaEnum.KO.getDto());
  }

  @Test
  void getSqlCalcularTest() {
    when(this.tareaCalculoAlgoritmoChallengePrecioHoraTiendaDesplazamientoBaseV1RepositoryCustom.getSqlCalcular(any(AlgoritmoDTO.class)))
        .thenReturn(SQL_CALCULAR);
    assertEquals(SQL_CALCULAR, this.challengePrecioHoraTiendaDesplazamientoBaseV1RunAlgoritmo.getSqlCalcular(new AlgoritmoDTO()));
  }
}
