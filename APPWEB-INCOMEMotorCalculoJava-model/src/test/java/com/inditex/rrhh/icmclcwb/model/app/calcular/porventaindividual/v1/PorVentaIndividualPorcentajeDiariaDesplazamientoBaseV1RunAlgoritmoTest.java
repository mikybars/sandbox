package com.inditex.rrhh.icmclcwb.model.app.calcular.porventaindividual.v1;

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
public class PorVentaIndividualPorcentajeDiariaDesplazamientoBaseV1RunAlgoritmoTest {

    @Mock
    private Logger log;

    @InjectMocks
    PorVentaIndividualPorcentajeDiariaDesplazamientoBaseV1RunAlgoritmo porVentaIndividualPorcentajeDiariaDesplazamientoBaseV1RunAlgoritmo;

    @Test
    public void getSqlCalcularTest() {
        // El algoritmo no esta desarrollado, por lo que de momento se comprueba que lanza el warning
        final AlgoritmoDto algoritmo = new AlgoritmoDto();
        final String result = this.porVentaIndividualPorcentajeDiariaDesplazamientoBaseV1RunAlgoritmo
            .getSqlCalcular(algoritmo);

        assertEquals(ErrorConstants.RUN_ALGORITMO_NOT_IMPLEMENTED_RESULT, result);
        verify(this.log, times(1)).warn(ErrorConstants.RUN_ALWORITMO_NOT_IMPLEMENTED_WARNING, algoritmo);
    }

    @Test
    public void executeTest() {
        // El algoritmo no esta desarrollado, por lo que de momento se comprueba que lanza el warning
        final AlgoritmoDto algoritmo = new AlgoritmoDto();
        final RunTareaDto runTarea = new RunTareaDto();
        this.porVentaIndividualPorcentajeDiariaDesplazamientoBaseV1RunAlgoritmo.execute(runTarea, algoritmo);

        verify(this.log, times(1)).warn(ErrorConstants.RUN_ALWORITMO_NOT_IMPLEMENTED_WARNING, algoritmo);
    }

}
