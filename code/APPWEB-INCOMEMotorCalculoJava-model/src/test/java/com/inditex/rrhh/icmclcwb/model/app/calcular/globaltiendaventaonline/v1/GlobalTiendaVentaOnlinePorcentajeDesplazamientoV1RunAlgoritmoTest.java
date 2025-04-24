package com.inditex.rrhh.icmclcwb.model.app.calcular.globaltiendaventaonline.v1;

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
import com.inditex.rrhh.icmclcwb.model.app.calcular.AbstractV1RunAlgoritmo;
import com.inditex.rrhh.icmclcwb.model.app.calcular.RunAlgoritmoTest;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaCalculoAlgoritmoGlobalTiendaVentaOnlinePorcentajeDesplazamientoV1RepositoryCustom;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.read.ListAppender;
import org.instancio.junit.InstancioSource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith({SpringExtension.class})
class GlobalTiendaVentaOnlinePorcentajeDesplazamientoV1RunAlgoritmoTest implements RunAlgoritmoTest {

  private final static String SQL_CALCULAR = "SELECT * FROM TABLE WHERE 1";

  @Mock
  private Logger log;

  @Mock
  private TareaCalculoAlgoritmoGlobalTiendaVentaOnlinePorcentajeDesplazamientoV1RepositoryCustom tareaCalculoAlgoritmoGlobalTiendaVentaOnlinePorcentajeDesplazamientoV1RepositoryCustom;

  @Mock
  private TareaCalculoPersonaService tareaCalculoPersonaService;

  @Mock
  private RunAlgoritmoPropertiesDto runAlgoritmoProperties;

  @InjectMocks
  private GlobalTiendaVentaOnlinePorcentajeDesplazamientoV1RunAlgoritmo globalTiendaVentaOnlinePorcentajeDesplazamientoV1RunAlgoritmo;

  private ListAppender<ILoggingEvent> listAppender;

  @BeforeEach
  public void setup() {
    final ch.qos.logback.classic.Logger logger =
        (ch.qos.logback.classic.Logger) LoggerFactory.getLogger(AbstractV1RunAlgoritmo.class);

    this.listAppender = new ListAppender<>();
    this.listAppender.start();

    logger.addAppender(this.listAppender);
  }

  @ParameterizedTest
  @InstancioSource(samples = 1)
  void getSqlCalcularTest(final AlgoritmoDTO algoritmo) {
    when(
        this.tareaCalculoAlgoritmoGlobalTiendaVentaOnlinePorcentajeDesplazamientoV1RepositoryCustom.getSqlCalcular(any(AlgoritmoDTO.class)))
            .thenReturn(SQL_CALCULAR);

    final String result = this.globalTiendaVentaOnlinePorcentajeDesplazamientoV1RunAlgoritmo.getSqlCalcular(algoritmo);

    verify(this.tareaCalculoAlgoritmoGlobalTiendaVentaOnlinePorcentajeDesplazamientoV1RepositoryCustom, times(1)).getSqlCalcular(algoritmo);

    assertEquals(SQL_CALCULAR, result);
  }

  @ParameterizedTest
  @InstancioSource(samples = 1)
  void calcularTest(final AlgoritmoDTO algoritmo, final RunTareaDto runTarea,
      final List<IdPersonaLocalDto> personas) {

    when(this.runAlgoritmoProperties.getCalculo()).thenReturn(this.createRunAlgoritmoCalculoPropertiesDto(10));
    when(this.tareaCalculoAlgoritmoGlobalTiendaVentaOnlinePorcentajeDesplazamientoV1RepositoryCustom.ids(any(AlgoritmoDTO.class),
        any(TareaDto.class)))
            .thenReturn(personas);
    when(this.tareaCalculoAlgoritmoGlobalTiendaVentaOnlinePorcentajeDesplazamientoV1RepositoryCustom
        .calcular(any(AlgoritmoDTO.class), any(TareaDto.class), anyList())).thenReturn(
            CompletableFuture.completedFuture(AsyncConstants.NIL));

    this.globalTiendaVentaOnlinePorcentajeDesplazamientoV1RunAlgoritmo.execute(runTarea, algoritmo);

    final Long idTrabajo = runTarea.getTrabajo().getId();
    final Long idTarea = runTarea.getTarea().getId();

    assertEquals(4, this.listAppender.list.size());
    assertEquals(Level.INFO, this.listAppender.list.get(0).getLevel());
    assertEquals("Trabajo[{}]Tarea[{}] :: Fin :: {} :: Personas: {}", this.listAppender.list.get(3).getMessage());

  }

  @ParameterizedTest
  @InstancioSource(samples = 1)
  void calcularExceptionTest(final AlgoritmoDTO algoritmo, final RunTareaDto runTarea,
      final List<IdPersonaLocalDto> personas) {

    when(this.runAlgoritmoProperties.getCalculo()).thenReturn(this.createRunAlgoritmoCalculoPropertiesDto(10));
    when(this.tareaCalculoAlgoritmoGlobalTiendaVentaOnlinePorcentajeDesplazamientoV1RepositoryCustom.ids(any(AlgoritmoDTO.class),
        any(TareaDto.class)))
            .thenReturn(personas);
    final RuntimeException exception = new RuntimeException("ERROR");
    doThrow(exception).when(this.tareaCalculoAlgoritmoGlobalTiendaVentaOnlinePorcentajeDesplazamientoV1RepositoryCustom).calcular(
        any(AlgoritmoDTO.class),
        any(TareaDto.class), anyList());

    this.globalTiendaVentaOnlinePorcentajeDesplazamientoV1RunAlgoritmo.execute(runTarea, algoritmo);

    final Long idTrabajo = runTarea.getTrabajo().getId();
    final Long idTarea = runTarea.getTarea().getId();
    assertEquals(5, this.listAppender.list.size());
    assertEquals(Level.INFO, this.listAppender.list.get(0).getLevel());
    assertEquals("Trabajo[{}]Tarea[{}] :: Fin :: {} :: Personas: {}",
        this.listAppender.list.get(4).getMessage());
    verify(this.tareaCalculoPersonaService, times(1)).updateWithEstadoAndidPersona(personas, runTarea,
        EstadoTareaCalculoPersonaEnum.KO.getDto());
  }

}
