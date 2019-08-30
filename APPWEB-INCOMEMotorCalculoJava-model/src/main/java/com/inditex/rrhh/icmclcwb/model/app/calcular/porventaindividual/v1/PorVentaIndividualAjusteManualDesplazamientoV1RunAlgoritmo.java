package com.inditex.rrhh.icmclcwb.model.app.calcular.porventaindividual.v1;

import com.inditex.rrhh.icmclcwb.api.app.calcular.dto.AlgoritmoDto;
import com.inditex.rrhh.icmclcwb.api.app.calcular.properties.dto.RunAlgoritmoPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.ErrorConstants;
import com.inditex.rrhh.icmclcwb.model.app.calcular.RunAlgoritmo;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("porVentaIndividualAjusteManualDesplazamientoV1")
public class PorVentaIndividualAjusteManualDesplazamientoV1RunAlgoritmo implements RunAlgoritmo {

    @Autowired
    private Logger log;

    @Autowired
    @Qualifier("runAlgoritmoProperties")
    private RunAlgoritmoPropertiesDto runAlgoritmoProperties;

    @Override
    public void execute(RunTareaDto runTarea, AlgoritmoDto algoritmo) {
        log.warn(ErrorConstants.RUN_ALWORITMO_NOT_IMPLEMENTED_WARNING, algoritmo);
    }

    @Override
    public String getSqlCalcular(AlgoritmoDto algoritmo) {
        log.warn(ErrorConstants.RUN_ALWORITMO_NOT_IMPLEMENTED_WARNING, algoritmo);
        return ErrorConstants.RUN_ALGORITMO_NOT_IMPLEMENTED_RESULT;
    }

}
