package com.inditex.rrhh.icmclcwb.model.app.calcular.porventaindividual.v1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.ErrorConstants;
import com.inditex.rrhh.icmclcwb.dto.AlgoritmoDTO;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.read.ListAppender;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class PorVentaIndividualPorcentajeDiariaV1RunAlgoritmoTest {

  @Mock
  private Logger log;

  @InjectMocks
  PorVentaIndividualPorcentajeDiariaV1RunAlgoritmo porVentaIndividualPorcentajeDiariaV1RunAlgoritmo;

  @Test
  public void getSqlCalcularTest() {
    // El algoritmo no esta desarrollado, por lo que de momento se comprueba que lanza el warning
    final AlgoritmoDTO algoritmo = new AlgoritmoDTO();
    final ListAppender<ILoggingEvent> listAppender = this.createLogListAppender();

    final String result = this.porVentaIndividualPorcentajeDiariaV1RunAlgoritmo.getSqlCalcular(algoritmo);

    final List<ILoggingEvent> list = listAppender.list;
    assertEquals(ErrorConstants.RUN_ALGORITMO_NOT_IMPLEMENTED_RESULT, result);
    assertEquals(ErrorConstants.RUN_ALWORITMO_NOT_IMPLEMENTED_WARNING, list.get(0).getMessage());
  }

  @Test
  public void executeTest() {
    // El algoritmo no esta desarrollado, por lo que de momento se comprueba que lanza el warning
    final AlgoritmoDTO algoritmo = new AlgoritmoDTO();
    final RunTareaDto runTarea = new RunTareaDto();
    final ListAppender<ILoggingEvent> listAppender = this.createLogListAppender();

    this.porVentaIndividualPorcentajeDiariaV1RunAlgoritmo.execute(runTarea, algoritmo);
    final List<ILoggingEvent> list = listAppender.list;

    assertEquals(ErrorConstants.RUN_ALWORITMO_NOT_IMPLEMENTED_WARNING, list.get(0).getMessage());

  }

  private ListAppender<ILoggingEvent> createLogListAppender() {
    final ch.qos.logback.classic.Logger log =
        (ch.qos.logback.classic.Logger) LoggerFactory.getLogger(PorVentaIndividualPorcentajeDiariaV1RunAlgoritmo.class);
    final ListAppender<ILoggingEvent> listAppender = new ListAppender<>();
    listAppender.start();
    log.addAppender(listAppender);
    return listAppender;
  }

}
