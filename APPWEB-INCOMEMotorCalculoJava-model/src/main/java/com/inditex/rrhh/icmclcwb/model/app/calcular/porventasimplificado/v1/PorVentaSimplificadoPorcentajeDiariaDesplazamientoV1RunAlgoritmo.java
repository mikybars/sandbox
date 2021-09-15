package com.inditex.rrhh.icmclcwb.model.app.calcular.porventasimplificado.v1;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.inditex.rrhh.icmclcwb.dto.AlgoritmoDTO;
import com.inditex.rrhh.icmclcwb.api.app.calcular.properties.dto.RunAlgoritmoPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.util.AsyncConstants;
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
    public CompletableFuture<Void> execute(final RunTareaDto runTarea, final AlgoritmoDTO algoritmo) {
        this.log.warn("El algoritmo {} no está implementado", algoritmo);
        return CompletableFuture.completedFuture(AsyncConstants.NIL);
    }

    @Override
    public String getSqlCalcular(final AlgoritmoDTO algoritmo) {
        this.log.warn("El algoritmo {} no está implementado", algoritmo);
        return "SIN IMPLEMENTAR";
    }

}
