package com.inditex.rrhh.icmclcwb.model.app.calcular.globaltienda.v1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.ErrorConstants;
import com.inditex.rrhh.icmclcwb.dto.AlgoritmoDTO;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.slf4j.Logger;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class GlobalTiendaTopesDesplazamientoV1RunAlgoritmoTest {

  @Mock
  private Logger log;

  @InjectMocks
  GlobalTiendaTopesDesplazamientoV1RunAlgoritmo globalTiendaTopesDesplazamientoV1RunAlgoritmo;

  @Test
  public void getSqlCalcularTest() {
    // El algoritmo no esta desarrollado, por lo que de momento se comprueba que lanza el warning
    AlgoritmoDTO algoritmo = new AlgoritmoDTO();
    String result = globalTiendaTopesDesplazamientoV1RunAlgoritmo.getSqlCalcular(algoritmo);

    assertEquals(ErrorConstants.RUN_ALGORITMO_NOT_IMPLEMENTED_RESULT, result);
    verify(log, times(1)).warn(ErrorConstants.RUN_ALWORITMO_NOT_IMPLEMENTED_WARNING, algoritmo);
  }

  @Test
  public void executeTest() {
    // El algoritmo no esta desarrollado, por lo que de momento se comprueba que lanza el warning
    AlgoritmoDTO algoritmo = new AlgoritmoDTO();
    RunTareaDto runTarea = new RunTareaDto();
    globalTiendaTopesDesplazamientoV1RunAlgoritmo.execute(runTarea, algoritmo);

    verify(log, times(1)).warn(ErrorConstants.RUN_ALWORITMO_NOT_IMPLEMENTED_WARNING, algoritmo);
  }

}
