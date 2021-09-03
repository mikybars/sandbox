package com.inditex.rrhh.icmclcwb.model.app.calcular.resaltamanual.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.inditex.rrhh.icmclcwb.api.app.calcular.properties.dto.RunAlgoritmoPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.EstadoTareaCalculoPersonaEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaCalculoPersonaService;
import com.inditex.rrhh.icmclcwb.dto.AlgoritmoDTO;
import com.inditex.rrhh.icmclcwb.model.app.calcular.RunAlgoritmo;
import com.inditex.rrhh.icmclcwb.model.app.util.StreamUtils;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaCalculoAlgoritmoResaltaManualV1RepositoryCustom;
import org.slf4j.Logger;
import reactor.core.publisher.Flux;

import com.inditex.aqsw.framework.common.reactor.autoconfiguration.ItxSchedulers;

@Component("resaltaManualV1")
public class ResaltaManualV1RunAlgoritmo implements RunAlgoritmo {

    @Autowired
    private Logger log;

    @Autowired
    @Qualifier("runAlgoritmoProperties")
    private RunAlgoritmoPropertiesDto runAlgoritmoProperties;

    @Autowired
    private TareaCalculoAlgoritmoResaltaManualV1RepositoryCustom tareaCalculoAlgoritmoResaltaManualV1RepositoryCustom;

    @Autowired
    private TareaCalculoPersonaService tareaCalculoPersonaService;

    @Override
    public void execute(final RunTareaDto runTarea,
            final AlgoritmoDTO algoritmo) {
        Flux.fromIterable(StreamUtils.partition(
                this.tareaCalculoAlgoritmoResaltaManualV1RepositoryCustom.ids(algoritmo,
                        runTarea.getTarea()),
                this.runAlgoritmoProperties.getBatchSize()))
            .parallel()
            .runOn(ItxSchedulers.boundedElastic())
            .map(personas -> {
                this.log.info("Inicio :: ResaltaManualV1RunAlgoritmo :: Personas: {}",
                        personas.size());
                try {
                    this.tareaCalculoAlgoritmoResaltaManualV1RepositoryCustom.calcular(algoritmo,
                            runTarea.getTarea(), personas);
                } catch (final Exception e) {
                    this.log.error("ResaltaManualV1RunAlgoritmo :: KO :: Personas: {}",
                            personas.size(), e);
                    this.tareaCalculoPersonaService.updateWithEstadoAndidPersona(personas, runTarea,
                            EstadoTareaCalculoPersonaEnum.KO.getDto());
                }
                this.log.info("Fin :: ResaltaManualV1RunAlgoritmo :: Personas: {}",
                        personas.size());
                return Flux.empty();
            })
            .sequential()
            .collectList()
            .block();
    }

    @Override
    public String getSqlCalcular(final AlgoritmoDTO algoritmo) {
        return this.tareaCalculoAlgoritmoResaltaManualV1RepositoryCustom.getSqlCalcular(algoritmo);
    }

}
