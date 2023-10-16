package com.inditex.rrhh.icmclcwb.model.app.calcular.directoventa.v1;

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
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;
import com.inditex.rrhh.icmclcwb.dto.AlgoritmoDTO;
import com.inditex.rrhh.icmclcwb.model.app.calcular.RunAlgoritmoTest;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaCalculoAlgoritmoDirectoVentaPorcentajeDesplazamientoBaseV1RepositoryCustom;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.slf4j.Logger;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class DirectoVentaPorcentajeDesplazamientoBaseV1RunAlgoritmoTest implements RunAlgoritmoTest {

  private final static String SQL_CALCULAR = "SELECT * FROM TABLE WHERE 1";

  @Mock
  private Logger log;

  @Mock
  private TareaCalculoAlgoritmoDirectoVentaPorcentajeDesplazamientoBaseV1RepositoryCustom tareaCalculoAlgoritmoDirectoVentaPorcentajeDesplazamientoBaseV1RepositoryCustom;

  @Mock
  private RunAlgoritmoPropertiesDto runAlgoritmoPropertiesDto;

  @Mock
  private TareaCalculoPersonaService tareaCalculoPersonaService;

  @InjectMocks
  private DirectoVentaPorcentajeDesplazamientoBaseV1RunAlgoritmo directoVentaPorcentajeDesplazamientoBaseV1RunAlgoritmo;

  @Test
  public void getSqlCalcularTest() {
    when(this.tareaCalculoAlgoritmoDirectoVentaPorcentajeDesplazamientoBaseV1RepositoryCustom
        .getSqlCalcular(any(AlgoritmoDTO.class))).thenReturn(SQL_CALCULAR);

    final String result = this.directoVentaPorcentajeDesplazamientoBaseV1RunAlgoritmo
        .getSqlCalcular(new AlgoritmoDTO());

    assertEquals(SQL_CALCULAR, result);
  }

  @Test
  public void calcularTest() {

    when(this.runAlgoritmoPropertiesDto.getCalculo()).thenReturn(this.createRunAlgoritmoCalculoPropertiesDto(10));

    final List<IdPersonaLocalDto> personas = new ArrayList<>();
    final IdPersonaLocalDto p1 = new IdPersonaLocalDto();
    personas.add(p1);
    final IdPersonaLocalDto p2 = new IdPersonaLocalDto();
    personas.add(p2);
    final IdPersonaLocalDto p3 = new IdPersonaLocalDto();
    personas.add(p3);
    when(this.tareaCalculoAlgoritmoDirectoVentaPorcentajeDesplazamientoBaseV1RepositoryCustom
        .ids(any(AlgoritmoDTO.class), any(TareaDto.class))).thenReturn(personas);

    when(this.tareaCalculoAlgoritmoDirectoVentaPorcentajeDesplazamientoBaseV1RepositoryCustom.calcular(
        any(AlgoritmoDTO.class),
        any(TareaDto.class), anyList())).thenReturn(
            CompletableFuture.completedFuture(AsyncConstants.NIL));

    final long idTarea = 123L;
    final long idTrabajo = 5675L;
    final RunTareaDto runTarea = this.createRunTareaDto(idTarea, idTrabajo);
    final AlgoritmoDTO algoritmo = new AlgoritmoDTO();
    this.directoVentaPorcentajeDesplazamientoBaseV1RunAlgoritmo.execute(runTarea, algoritmo);

    verify(this.log, times(1))
        .info("Trabajo[{}]Tarea[{}] :: Inicio :: DirectoVentaPorcentajeDesplazamientoBaseV1RunAlgoritmo :: Personas: {}",
            idTrabajo, idTarea, 3);
    verify(this.tareaCalculoAlgoritmoDirectoVentaPorcentajeDesplazamientoBaseV1RepositoryCustom, times(1))
        .calcular(algoritmo, runTarea.getTarea(), personas);
    verify(this.log, times(1))
        .info("Trabajo[{}]Tarea[{}] :: Fin :: DirectoVentaPorcentajeDesplazamientoBaseV1RunAlgoritmo :: Personas: {}",
            idTrabajo, idTarea, 3);
  }

  @Test
  public void calcularExceptionTest() {

    final List<IdPersonaLocalDto> personas = new ArrayList<>();
    final IdPersonaLocalDto p1 = new IdPersonaLocalDto();
    personas.add(p1);
    final IdPersonaLocalDto p2 = new IdPersonaLocalDto();
    personas.add(p2);
    when(this.tareaCalculoAlgoritmoDirectoVentaPorcentajeDesplazamientoBaseV1RepositoryCustom
        .ids(any(AlgoritmoDTO.class), any(TareaDto.class))).thenReturn(personas);

    when(this.runAlgoritmoPropertiesDto.getCalculo()).thenReturn(this.createRunAlgoritmoCalculoPropertiesDto(2));
    final RuntimeException exception = new RuntimeException("EEEE");
    doThrow(exception).when(this.tareaCalculoAlgoritmoDirectoVentaPorcentajeDesplazamientoBaseV1RepositoryCustom)
        .calcular(any(AlgoritmoDTO.class), any(TareaDto.class),
            ArgumentMatchers.<List<IdPersonaLocalDto>>any());

    final long idTarea = 123L;
    final long idTrabajo = 5675L;
    final RunTareaDto runTarea = this.createRunTareaDto(idTarea, idTrabajo);
    final AlgoritmoDTO algoritmo = new AlgoritmoDTO();
    this.directoVentaPorcentajeDesplazamientoBaseV1RunAlgoritmo.execute(runTarea, algoritmo);

    verify(this.log, times(1))
        .error("Trabajo[{}]Tarea[{}] :: DirectoVentaPorcentajeDesplazamientoBaseV1RunAlgoritmo :: KO :: Personas: {}",
            idTrabajo, idTarea, 2, exception);
    verify(this.tareaCalculoPersonaService, times(1)).updateWithEstadoAndidPersona(personas, runTarea,
        EstadoTareaCalculoPersonaEnum.KO.getDto());
  }

}
