package com.inditex.rrhh.icmclcwb.model.app.calcular.directoventareduccionjornada.v1;

import com.inditex.rrhh.icmclcwb.api.app.calcular.dto.AlgoritmoDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.ErrorConstants;
import com.inditex.rrhh.icmclcwb.model.app.calcular.directoventapresencia.v1.DirectoVentaPresenciaAjusteManualDesplazamientoV1RunAlgoritmo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.slf4j.Logger;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class DirectoVentaReduccionJornadaAjusteManualDesplazamientoV1RunAlgoritmoTest {

    @Mock
    private Logger log;

    @InjectMocks
    DirectoVentaReduccionJornadaAjusteManualDesplazamientoV1RunAlgoritmo directoVentaReduccionJornadaAjusteManualDesplazamientoV1RunAlgoritmo;

    @Test
    public void getSqlCalcularTest() {
        //El algoritmo no esta desarrollado, por lo que de momento se comprueba que lanza el warning
        AlgoritmoDto algoritmo = new AlgoritmoDto();
        String result = directoVentaReduccionJornadaAjusteManualDesplazamientoV1RunAlgoritmo.getSqlCalcular(algoritmo);

        assertEquals(ErrorConstants.RUN_ALGORITMO_NOT_IMPLEMENTED_RESULT, result);
        verify(log, times(1)).warn(ErrorConstants.RUN_ALWORITMO_NOT_IMPLEMENTED_WARNING, algoritmo);
    }

    @Test
    public void executeTest() {
        //El algoritmo no esta desarrollado, por lo que de momento se comprueba que lanza el warning
        AlgoritmoDto algoritmo = new AlgoritmoDto();
        RunTareaDto runTarea = new RunTareaDto();
        directoVentaReduccionJornadaAjusteManualDesplazamientoV1RunAlgoritmo.execute(runTarea, algoritmo);

        verify(log, times(1)).warn(ErrorConstants.RUN_ALWORITMO_NOT_IMPLEMENTED_WARNING, algoritmo);
    }
}
