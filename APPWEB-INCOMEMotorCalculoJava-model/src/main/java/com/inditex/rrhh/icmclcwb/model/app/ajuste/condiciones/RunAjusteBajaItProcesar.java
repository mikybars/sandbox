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
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaCalculoPostProcesarBajaItRepositoryCustom;

import reactor.core.publisher.Flux;

@Component("bajaItV1")
public class RunAjusteBajaItProcesar implements RunAjuste {

    @Autowired
    private Logger log;

    @Autowired
    @Qualifier("runAjusteProperties")
    private RunAjustePropertiesDto runAjusteProperties;

    @Autowired
    private TareaCalculoPostProcesarBajaItRepositoryCustom tareaCalculoPostProcesarBajaItRepositoryCustom;

    @Override
    public void execute(RunTareaDto runTarea) {
        Flux.fromIterable(StreamUtils.partition(
                tareaCalculoPostProcesarBajaItRepositoryCustom.ids(runTarea.getTarea()),
                runAjusteProperties.getBatchSize())).parallel().runOn(ItxSchedulers.elastic()).map(personas -> {
                    log.info("Inicio :: RunAjusteBajaItProcesar :: Personas: {}", personas.size());
                    try {
                        tareaCalculoPostProcesarBajaItRepositoryCustom.postProcesar(runTarea.getTarea(), personas);
                    } catch (Exception e) {
                        log.error("RunAjusteBajaItProcesar :: KO :: Personas: {}", personas.size(), e);
                    }
                    log.info("Fin :: RunAjusteBajaItProcesar :: Personas: {}", personas.size());
                    return Flux.empty();
                }).sequential().collectList().block();   
    }

    @Override
    public String getSqlCalcular() {
        return tareaCalculoPostProcesarBajaItRepositoryCustom.getSqlPostProcesar();
    }

}
