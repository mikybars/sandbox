package com.inditex.rrhh.icmclcwb.model.app.calcular.resaltamanual.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.inditex.rrhh.icmclcwb.api.app.calcular.dto.AlgoritmoDto;
import com.inditex.rrhh.icmclcwb.api.app.calcular.properties.dto.RunAlgoritmoPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.EstadoTareaCalculoPersonaEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaCalculoPersonaService;
import com.inditex.rrhh.icmclcwb.model.app.calcular.RunAlgoritmo;
import com.inditex.rrhh.icmclcwb.model.app.util.StreamUtils;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaCalculoAlgoritmoResaltaManualDesplazamientoBaseV1RepositoryCustom;
import org.slf4j.Logger;
import reactor.core.publisher.Flux;

import com.inditex.aqsw.framework.common.reactor.autoconfiguration.ItxSchedulers;

@Component("resaltaManualDesplazamientoBaseV1")
public class ResaltaManualDesplazamientoBaseV1RunAlgoritmo implements RunAlgoritmo {

    @Autowired
    private Logger log;

    @Autowired
    @Qualifier("runAlgoritmoProperties")
    private RunAlgoritmoPropertiesDto runAlgoritmoProperties;

    @Autowired
    private TareaCalculoAlgoritmoResaltaManualDesplazamientoBaseV1RepositoryCustom tareaCalculoAlgoritmoResaltaManualDesplazamientoBaseV1RepositoryCustom;

    @Autowired
    private TareaCalculoPersonaService tareaCalculoPersonaService;

    @Override
    public void execute(final RunTareaDto runTarea,
            final AlgoritmoDto algoritmo) {
        Flux.fromIterable(StreamUtils.partition(
                this.tareaCalculoAlgoritmoResaltaManualDesplazamientoBaseV1RepositoryCustom.ids(algoritmo,
                        runTarea.getTarea()),
                this.runAlgoritmoProperties.getBatchSize()))
            .parallel()
            .runOn(ItxSchedulers.boundedElastic())
            .map(personas -> {
                this.log.info("Inicio :: ResaltaManualDesplazamientoBaseV1RunAlgoritmo :: Personas: {}",
                        personas.size());
                try {
                    this.tareaCalculoAlgoritmoResaltaManualDesplazamientoBaseV1RepositoryCustom.calcular(algoritmo,
                            runTarea.getTarea(), personas);
                } catch (final Exception e) {
                    this.log.error("ResaltaManualDesplazamientoBaseV1RunAlgoritmo :: KO :: Personas: {}",
                            personas.size(), e);
                    this.tareaCalculoPersonaService.updateWithEstadoAndidPersona(personas, runTarea,
                            EstadoTareaCalculoPersonaEnum.KO.getDto());
                }
                this.log.info("Fin :: ResaltaManualDesplazamientoBaseV1RunAlgoritmo :: Personas: {}",
                        personas.size());
                return Flux.empty();
            })
            .sequential()
            .collectList()
            .block();
    }

    @Override
    public String getSqlCalcular(final AlgoritmoDto algoritmo) {
        return this.tareaCalculoAlgoritmoResaltaManualDesplazamientoBaseV1RepositoryCustom.getSqlCalcular(algoritmo);
    }

}
