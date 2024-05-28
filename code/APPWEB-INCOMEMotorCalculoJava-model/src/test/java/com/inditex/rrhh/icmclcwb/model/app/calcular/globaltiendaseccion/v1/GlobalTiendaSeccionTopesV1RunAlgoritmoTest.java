package com.inditex.rrhh.icmclcwb.model.app.calcular.globaltiendaseccion.v1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.ErrorConstants;
import com.inditex.rrhh.icmclcwb.dto.AlgoritmoDTO;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.read.ListAppender;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class GlobalTiendaSeccionTopesV1RunAlgoritmoTest {

  @Mock
  private Logger log;

  @InjectMocks
  GlobalTiendaSeccionTopesV1RunAlgoritmo globalTiendaSeccionTopesV1RunAlgoritmo;

  private ListAppender<ILoggingEvent> listAppender;

  @BeforeEach
  public void setup() {
    final ch.qos.logback.classic.Logger logger =
        (ch.qos.logback.classic.Logger) LoggerFactory.getLogger(GlobalTiendaSeccionTopesV1RunAlgoritmo.class);

    this.listAppender = new ListAppender<>();
    this.listAppender.start();

    logger.addAppender(this.listAppender);
  }

  @Test
  public void getSqlCalcularTest() {
    // El algoritmo no esta desarrollado, por lo que de momento se comprueba que lanza el warning
    final AlgoritmoDTO algoritmo = new AlgoritmoDTO();
    final String result = this.globalTiendaSeccionTopesV1RunAlgoritmo.getSqlCalcular(algoritmo);

    assertEquals(ErrorConstants.RUN_ALGORITMO_NOT_IMPLEMENTED_RESULT, result);
    assertEquals(1, this.listAppender.list.size());
    assertEquals(Level.WARN, this.listAppender.list.get(0).getLevel());
    assertEquals(ErrorConstants.RUN_ALWORITMO_NOT_IMPLEMENTED_WARNING, this.listAppender.list.get(0).getMessage());
  }

  @Test
  public void executeTest() {
    // El algoritmo no esta desarrollado, por lo que de momento se comprueba que lanza el warning
    final AlgoritmoDTO algoritmo = new AlgoritmoDTO();
    final RunTareaDto runTarea = new RunTareaDto();
    this.globalTiendaSeccionTopesV1RunAlgoritmo.execute(runTarea, algoritmo);

    assertEquals(1, this.listAppender.list.size());
    assertEquals(Level.WARN, this.listAppender.list.get(0).getLevel());
    assertEquals(ErrorConstants.RUN_ALWORITMO_NOT_IMPLEMENTED_WARNING, this.listAppender.list.get(0).getMessage());
  }

}
