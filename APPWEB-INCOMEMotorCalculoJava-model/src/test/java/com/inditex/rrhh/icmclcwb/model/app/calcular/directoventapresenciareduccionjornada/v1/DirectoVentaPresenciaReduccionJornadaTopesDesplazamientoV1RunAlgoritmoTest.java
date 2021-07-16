package com.inditex.rrhh.icmclcwb.model.app.calcular.directoventapresenciareduccionjornada.v1;

import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.inditex.rrhh.icmclcwb.api.app.calcular.dto.AlgoritmoDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.ErrorConstants;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.slf4j.Logger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(SpringExtension.class)
public class DirectoVentaPresenciaReduccionJornadaTopesDesplazamientoV1RunAlgoritmoTest {

    @Mock
    private Logger log;

    @InjectMocks
    DirectoVentaPresenciaReduccionJornadaTopesDesplazamientoV1RunAlgoritmo directoVentaPresenciaReduccionJornadaTopesDesplazamientoV1RunAlgoritmo;

    @Test
    public void getSqlCalcularTest() {
        // El algoritmo no esta desarrollado, por lo que de momento se comprueba que lanza el warning
        AlgoritmoDto algoritmo = new AlgoritmoDto();
        String result = directoVentaPresenciaReduccionJornadaTopesDesplazamientoV1RunAlgoritmo
            .getSqlCalcular(algoritmo);

        assertEquals(ErrorConstants.RUN_ALGORITMO_NOT_IMPLEMENTED_RESULT, result);
        verify(log, times(1)).warn(ErrorConstants.RUN_ALWORITMO_NOT_IMPLEMENTED_WARNING, algoritmo);
    }

    @Test
    public void executeTest() {
        // El algoritmo no esta desarrollado, por lo que de momento se comprueba que lanza el warning
        AlgoritmoDto algoritmo = new AlgoritmoDto();
        RunTareaDto runTarea = new RunTareaDto();
        directoVentaPresenciaReduccionJornadaTopesDesplazamientoV1RunAlgoritmo.execute(runTarea, algoritmo);

        verify(log, times(1)).warn(ErrorConstants.RUN_ALWORITMO_NOT_IMPLEMENTED_WARNING, algoritmo);
    }

}
