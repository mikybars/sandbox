package com.inditex.rrhh.icmclcwb.model.app.calcular.porventa.v1;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.inditex.rrhh.icmclcwb.api.app.calcular.dto.AlgoritmoDto;
import com.inditex.rrhh.icmclcwb.api.app.calcular.properties.dto.RunAlgoritmoPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.model.app.calcular.RunAlgoritmo;

@Component("porVentaTopesV1")
public class PorVentaTopesV1RunAlgoritmo implements RunAlgoritmo {

    @Autowired
    private Logger log;

    @Autowired
    @Qualifier("runAlgoritmoProperties")
    private RunAlgoritmoPropertiesDto runAlgoritmoProperties;

    @Override
    public void execute(RunTareaDto runTarea, AlgoritmoDto algoritmo) {
        log.warn("El algoritmo {} no está implementado", algoritmo);
    }

    @Override
    public String getSqlCalcular(AlgoritmoDto algoritmo) {
        log.warn("El algoritmo {} no está implementado", algoritmo);
        return "SIN IMPLEMENTAR";
    }

}
