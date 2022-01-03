package com.inditex.rrhh.icmclcwb.model.app.calcular.directoventareduccionjornada.v1;

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
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaCalculoAlgoritmoDirectoVentaReduccionJornadaPorcentajeDesplazamientoBaseV1RepositoryCustom;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.slf4j.Logger;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class DirectoVentaReduccionJornadaPorcentajeDesplazamientoBaseV1RunAlgoritmoTest implements RunAlgoritmoTest {

  private final static String SQL_CALCULAR = "SELECT * FROM TABLE WHERE 1";

  @Mock
  private Logger log;

  @Mock
  private TareaCalculoAlgoritmoDirectoVentaReduccionJornadaPorcentajeDesplazamientoBaseV1RepositoryCustom tareaCalculoAlgoritmoDirectoVentaReduccionJornadaPorcentajeDesplazamientoBaseV1RepositoryCustom;

  @Mock
  private TareaCalculoPersonaService tareaCalculoPersonaService;

  @Mock
  private RunAlgoritmoPropertiesDto runAlgoritmoPropertiesDto;

  @InjectMocks
  private DirectoVentaReduccionJornadaPorcentajeDesplazamientoBaseV1RunAlgoritmo directoVentaReduccionJornadaPorcentajeDesplazamientoBaseV1RunAlgoritmo;

  @Test
  public void getSqlCalcularTest() {
    when(this.tareaCalculoAlgoritmoDirectoVentaReduccionJornadaPorcentajeDesplazamientoBaseV1RepositoryCustom
        .getSqlCalcular(any(AlgoritmoDTO.class))).thenReturn(SQL_CALCULAR);

    final String result = this.directoVentaReduccionJornadaPorcentajeDesplazamientoBaseV1RunAlgoritmo
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
    when(this.tareaCalculoAlgoritmoDirectoVentaReduccionJornadaPorcentajeDesplazamientoBaseV1RepositoryCustom
        .ids(any(AlgoritmoDTO.class), any(TareaDto.class))).thenReturn(personas);
    when(this.tareaCalculoAlgoritmoDirectoVentaReduccionJornadaPorcentajeDesplazamientoBaseV1RepositoryCustom
        .calcular(
            any(AlgoritmoDTO.class),
            any(TareaDto.class), anyList())).thenReturn(
                CompletableFuture.completedFuture(AsyncConstants.NIL));

    final long idTarea = 123L;
    final long idTrabajo = 5675L;
    final RunTareaDto runTarea = this.createRunTareaDto(idTarea, idTrabajo);
    final AlgoritmoDTO algoritmo = new AlgoritmoDTO();
    this.directoVentaReduccionJornadaPorcentajeDesplazamientoBaseV1RunAlgoritmo.execute(runTarea, algoritmo);

    verify(this.log, times(1))
        .info("Trabajo[{}]Tarea[{}] :: Inicio :: DirectoVentaReduccionJornadaPorcentajeDesplazamientoBaseV1RunAlgoritmo :: Personas: {}",
            idTrabajo, idTarea, 3);
    verify(this.tareaCalculoAlgoritmoDirectoVentaReduccionJornadaPorcentajeDesplazamientoBaseV1RepositoryCustom,
        times(1))
            .calcular(algoritmo, runTarea.getTarea(), personas);
    verify(this.log, times(1))
        .info("Trabajo[{}]Tarea[{}] :: Fin :: DirectoVentaReduccionJornadaPorcentajeDesplazamientoBaseV1RunAlgoritmo :: Personas: {}",
            idTrabajo, idTarea, 3);
  }

  @Test
  public void calcularExceptionTest() {

    final List<IdPersonaLocalDto> personas = new ArrayList<>();
    final IdPersonaLocalDto p1 = new IdPersonaLocalDto();
    personas.add(p1);
    final IdPersonaLocalDto p2 = new IdPersonaLocalDto();
    personas.add(p2);
    when(this.tareaCalculoAlgoritmoDirectoVentaReduccionJornadaPorcentajeDesplazamientoBaseV1RepositoryCustom
        .ids(any(AlgoritmoDTO.class), any(TareaDto.class))).thenReturn(personas);

    when(this.runAlgoritmoPropertiesDto.getCalculo()).thenReturn(this.createRunAlgoritmoCalculoPropertiesDto(2));
    final RuntimeException exception = new RuntimeException("EEEE");
    doThrow(exception)
        .when(this.tareaCalculoAlgoritmoDirectoVentaReduccionJornadaPorcentajeDesplazamientoBaseV1RepositoryCustom)
        .calcular(any(AlgoritmoDTO.class), any(TareaDto.class),
            ArgumentMatchers.<List<IdPersonaLocalDto>>any());

    final long idTarea = 123L;
    final long idTrabajo = 5675L;
    final RunTareaDto runTarea = this.createRunTareaDto(idTarea, idTrabajo);
    final AlgoritmoDTO algoritmo = new AlgoritmoDTO();
    this.directoVentaReduccionJornadaPorcentajeDesplazamientoBaseV1RunAlgoritmo.execute(runTarea, algoritmo);

    verify(this.log, times(1))
        .error("Trabajo[{}]Tarea[{}] :: DirectoVentaReduccionJornadaPorcentajeDesplazamientoBaseV1RunAlgoritmo :: KO :: Personas: {}",
            idTrabajo, idTarea, 2, exception);
    verify(this.tareaCalculoPersonaService, times(1)).updateWithEstadoAndidPersona(personas, runTarea,
        EstadoTareaCalculoPersonaEnum.KO.getDto());
  }

}
