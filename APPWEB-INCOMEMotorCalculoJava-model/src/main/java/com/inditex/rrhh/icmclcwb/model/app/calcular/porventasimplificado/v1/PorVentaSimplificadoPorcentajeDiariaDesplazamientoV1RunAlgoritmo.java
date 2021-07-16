package com.inditex.rrhh.icmclcwb.model.app.calcular.porventasimplificado.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.inditex.rrhh.icmclcwb.api.app.calcular.dto.AlgoritmoDto;
import com.inditex.rrhh.icmclcwb.api.app.calcular.properties.dto.RunAlgoritmoPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.model.app.calcular.RunAlgoritmo;
import org.slf4j.Logger;

@Component("porVentaSimplificadoPorcentajeDiariaDesplazamientoV1")
public class PorVentaSimplificadoPorcentajeDiariaDesplazamientoV1RunAlgoritmo implements RunAlgoritmo {

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
