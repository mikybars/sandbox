package com.inditex.rrhh.icmclcwb.model.app.postprocesar.condiciones;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.inditex.aqsw.framework.common.reactor.autoconfiguration.ItxSchedulers;
import com.inditex.rrhh.icmclcwb.api.app.postprocesar.properties.dto.RunPostProcesarPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.model.app.postprocesar.RunPostCondicion;
import com.inditex.rrhh.icmclcwb.model.app.util.StreamUtils;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaCalculoPostProcesarAntiguedadRepositoryCustom;

import reactor.core.publisher.Flux;

@Component
public class AntiguedadRunPostProcesar implements RunPostCondicion {

    @Autowired
    private Logger log;

    @Autowired
    @Qualifier("runPostProcesarProperties")
    private RunPostProcesarPropertiesDto runPostProcesarProperties;

    @Autowired
    private TareaCalculoPostProcesarAntiguedadRepositoryCustom tareaCalculoPostProcesarAntiguedadRepositoryCustom;

    @Override
    public void execute(RunTareaDto runTarea) {
        Flux.fromIterable(StreamUtils.partition(
                tareaCalculoPostProcesarAntiguedadRepositoryCustom.ids(runTarea.getTarea()),
                runPostProcesarProperties.getBatchSize())).parallel().runOn(ItxSchedulers.elastic()).map(personas -> {
                    log.info("Inicio :: AntiguedadRunPostProcesar :: Personas: {}", personas.size());
                    try {
                        tareaCalculoPostProcesarAntiguedadRepositoryCustom.postProcesar(runTarea.getTarea(), personas);
                    } catch (Exception e) {
                        log.error("AntiguedadRunPostProcesar :: KO :: Personas: {}", personas.size(), e);
                    }
                    log.info("Fin :: AntiguedadRunPostProcesar :: Personas: {}", personas.size());
                    return Flux.empty();
                }).sequential().collectList().block();   
    }

    @Override
    public String getSqlCalcular() {
        return tareaCalculoPostProcesarAntiguedadRepositoryCustom.getSqlPostProcesar();
    }

}
