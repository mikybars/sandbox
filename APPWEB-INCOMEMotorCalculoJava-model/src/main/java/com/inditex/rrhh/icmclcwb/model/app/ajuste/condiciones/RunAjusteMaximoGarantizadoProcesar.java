package com.inditex.rrhh.icmclcwb.model.app.ajuste.condiciones;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.inditex.aqsw.framework.common.reactor.autoconfiguration.ItxSchedulers;
import com.inditex.rrhh.icmclcwb.api.app.ajuste.properties.dto.RunAjustePropertiesDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.model.app.calcular.RunAjuste;
import com.inditex.rrhh.icmclcwb.model.app.util.StreamUtils;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaCalculoAjusteMaximoGarantizadoRepositoryCustom;

import reactor.core.publisher.Flux;

@Component("maximoGarantizadoV1")
public class RunAjusteMaximoGarantizadoProcesar implements RunAjuste {

    @Autowired
    private Logger log;

    @Autowired
    @Qualifier("runAjusteProperties")
    private RunAjustePropertiesDto runAjusteProperties;

    @Autowired
    private TareaCalculoAjusteMaximoGarantizadoRepositoryCustom tareaCalculoAjusteMaximoGarantizadoRepositoryCustom;

    @Override
    public void execute(RunTareaDto runTarea) {
        Flux.fromIterable(StreamUtils.partition(
                tareaCalculoAjusteMaximoGarantizadoRepositoryCustom.ids(runTarea.getTarea()),
                runAjusteProperties.getBatchSize())).parallel().runOn(ItxSchedulers.elastic()).map(personas -> {
                    log.info("Inicio :: RunAjusteMaximoGarantizadoProcesar :: Personas: {}", personas.size());
                    try {
                        tareaCalculoAjusteMaximoGarantizadoRepositoryCustom.ajustar(runTarea.getTarea(), personas);
                    } catch (Exception e) {
                        log.error("RunAjusteMaximoGarantizadoProcesar :: KO :: Personas: {}", personas.size(), e);
                    }
                    log.info("Fin :: RunAjusteMaximoGarantizadoProcesar :: Personas: {}", personas.size());
                    return Flux.empty();
                }).sequential().collectList().block();   
    }

    @Override
    public String getSqlCalcular() {
        return tareaCalculoAjusteMaximoGarantizadoRepositoryCustom.getSqlAjustar();
    }

}
