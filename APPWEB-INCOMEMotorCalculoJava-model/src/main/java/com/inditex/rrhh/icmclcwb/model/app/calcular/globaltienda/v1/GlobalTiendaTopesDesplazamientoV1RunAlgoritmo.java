package com.inditex.rrhh.icmclcwb.model.app.calcular.globaltienda.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.inditex.rrhh.icmclcwb.api.app.calcular.dto.AlgoritmoDto;
import com.inditex.rrhh.icmclcwb.api.app.calcular.properties.dto.RunAlgoritmoPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.ErrorConstants;
import com.inditex.rrhh.icmclcwb.model.app.calcular.RunAlgoritmo;
import org.slf4j.Logger;

@Component("globalTiendaTopesDesplazamientoV1")
public class GlobalTiendaTopesDesplazamientoV1RunAlgoritmo implements RunAlgoritmo {

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
