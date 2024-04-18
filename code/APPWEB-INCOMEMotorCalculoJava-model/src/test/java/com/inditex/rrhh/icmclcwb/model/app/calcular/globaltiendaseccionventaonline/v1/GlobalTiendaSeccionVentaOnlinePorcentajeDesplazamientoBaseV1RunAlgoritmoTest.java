package com.inditex.rrhh.icmclcwb.model.app.calcular.globaltiendaseccionventaonline.v1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaCalculoAlgoritmoGlobalTiendaSeccionVentaOnlinePorcentajeDesplazamientoBaseV1RepositoryCustom;

import org.instancio.junit.InstancioSource;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.slf4j.Logger;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith({SpringExtension.class})
class GlobalTiendaSeccionVentaOnlinePorcentajeDesplazamientoBaseV1RunAlgoritmoTest implements RunAlgoritmoTest {

  private static final String SQL_CALCULAR = "SELECT * FROM WHATEVER";

  @Mock
  private Logger log;

  @Mock
  private TareaCalculoPersonaService tareaCalculoPersonaService;

  @Mock
  private RunAlgoritmoPropertiesDto runAlgoritmoProperties;

  @Mock
  private TareaCalculoAlgoritmoGlobalTiendaSeccionVentaOnlinePorcentajeDesplazamientoBaseV1RepositoryCustom tareaCalculoAlgoritmoGlobalTiendaSeccionVentaOnlinePorcentajeDesplazamientoBaseV1RepositoryCustom;

  @InjectMocks
  private GlobalTiendaSeccionVentaOnlinePorcentajeDesplazamientoBaseV1RunAlgoritmo globalTiendaSeccionVentaOnlinePorcentajeDesplazamientoBaseV1RunAlgoritmo;

  @ParameterizedTest
    @InstancioSource
  void getSqlCalcularTest(final AlgoritmoDTO algoritmo) {
    when(this.tareaCalculoAlgoritmoGlobalTiendaSeccionVentaOnlinePorcentajeDesplazamientoBaseV1RepositoryCustom
        .getSqlCalcular(any(AlgoritmoDTO.class)))
            .thenReturn(SQL_CALCULAR);

    final String result = this.globalTiendaSeccionVentaOnlinePorcentajeDesplazamientoBaseV1RunAlgoritmo.getSqlCalcular(algoritmo);

    verify(this.tareaCalculoAlgoritmoGlobalTiendaSeccionVentaOnlinePorcentajeDesplazamientoBaseV1RepositoryCustom, times(1))
        .getSqlCalcular(algoritmo);

    assertEquals(SQL_CALCULAR, result);
  }

  @ParameterizedTest
    @InstancioSource  void calcularTest(final AlgoritmoDTO algoritmo, final RunTareaDto runTarea,
       final List<IdPersonaLocalDto> personas) {

    when(this.runAlgoritmoProperties.getCalculo()).thenReturn(this.createRunAlgoritmoCalculoPropertiesDto(10));
    when(this.tareaCalculoAlgoritmoGlobalTiendaSeccionVentaOnlinePorcentajeDesplazamientoBaseV1RepositoryCustom.ids(any(AlgoritmoDTO.class),
        any(TareaDto.class)))
            .thenReturn(personas);
    when(this.tareaCalculoAlgoritmoGlobalTiendaSeccionVentaOnlinePorcentajeDesplazamientoBaseV1RepositoryCustom
        .calcular(any(AlgoritmoDTO.class), any(TareaDto.class), anyList())).thenReturn(
            CompletableFuture.completedFuture(AsyncConstants.NIL));

    this.globalTiendaSeccionVentaOnlinePorcentajeDesplazamientoBaseV1RunAlgoritmo.execute(runTarea, algoritmo);

    final Long idTrabajo = runTarea.getTrabajo().getId();
    final Long idTarea = runTarea.getTarea().getId();
    verify(this.log, times(1)).info("Trabajo[{}]Tarea[{}] :: Inicio :: {} :: Ids",
        idTrabajo, idTarea, "GlobalTiendaSeccionVentaOnlinePorcentajeDesplazamientoBaseV1RunAlgoritmo");
    verify(this.log, times(1)).info("Trabajo[{}]Tarea[{}] :: Fin :: {} :: Ids: {}",
        idTrabajo, idTarea, "GlobalTiendaSeccionVentaOnlinePorcentajeDesplazamientoBaseV1RunAlgoritmo", personas);
    verify(this.log, times(1)).info("Trabajo[{}]Tarea[{}] :: Inicio :: {} :: Personas: {}",
        idTrabajo, idTarea, "GlobalTiendaSeccionVentaOnlinePorcentajeDesplazamientoBaseV1RunAlgoritmo", 3);
    verify(this.log, times(1)).info("Trabajo[{}]Tarea[{}] :: Fin :: {} :: Personas: {}",
        idTrabajo, idTarea, "GlobalTiendaSeccionVentaOnlinePorcentajeDesplazamientoBaseV1RunAlgoritmo", 3);
  }

  @ParameterizedTest
  @InstancioSource
  void calcularExceptionTest( final AlgoritmoDTO algoritmo,  final RunTareaDto runTarea,
       final List<IdPersonaLocalDto> personas) {

    when(this.runAlgoritmoProperties.getCalculo()).thenReturn(this.createRunAlgoritmoCalculoPropertiesDto(10));
    when(this.tareaCalculoAlgoritmoGlobalTiendaSeccionVentaOnlinePorcentajeDesplazamientoBaseV1RepositoryCustom.ids(any(AlgoritmoDTO.class),
        any(TareaDto.class)))
            .thenReturn(personas);
    final RuntimeException exception = new RuntimeException("ERROR");
    doThrow(exception).when(this.tareaCalculoAlgoritmoGlobalTiendaSeccionVentaOnlinePorcentajeDesplazamientoBaseV1RepositoryCustom)
        .calcular(any(AlgoritmoDTO.class),
            any(TareaDto.class), anyList());

    this.globalTiendaSeccionVentaOnlinePorcentajeDesplazamientoBaseV1RunAlgoritmo.execute(runTarea, algoritmo);

    final Long idTrabajo = runTarea.getTrabajo().getId();
    final Long idTarea = runTarea.getTarea().getId();
    verify(this.log, times(1)).info("Trabajo[{}]Tarea[{}] :: Inicio :: {} :: Ids",
        idTrabajo, idTarea, "GlobalTiendaSeccionVentaOnlinePorcentajeDesplazamientoBaseV1RunAlgoritmo");
    verify(this.log, times(1)).info("Trabajo[{}]Tarea[{}] :: Fin :: {} :: Ids: {}",
        idTrabajo, idTarea, "GlobalTiendaSeccionVentaOnlinePorcentajeDesplazamientoBaseV1RunAlgoritmo", personas);
    verify(this.log, times(1)).info("Trabajo[{}]Tarea[{}] :: Inicio :: {} :: Personas: {}",
        idTrabajo, idTarea, "GlobalTiendaSeccionVentaOnlinePorcentajeDesplazamientoBaseV1RunAlgoritmo", 3);
    verify(this.log, times(1)).error("Trabajo[{}]Tarea[{}] :: {} :: KO :: Personas: {}",
        idTrabajo, idTarea, "GlobalTiendaSeccionVentaOnlinePorcentajeDesplazamientoBaseV1RunAlgoritmo", 3, exception);
    verify(this.tareaCalculoPersonaService, times(1)).updateWithEstadoAndidPersona(personas, runTarea,
        EstadoTareaCalculoPersonaEnum.KO.getDto());
  }

}
