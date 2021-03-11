package com.inditex.rrhh.icmclcwb.model.app.calcular.porventaindividual.v1;

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
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaCalculoAlgoritmoPorVentaIndividualPorcentajeV1RepositoryCustom;
import org.slf4j.Logger;
import reactor.core.publisher.Flux;

import com.inditex.aqsw.framework.common.reactor.autoconfiguration.ItxSchedulers;

@Component("porVentaIndividualPorcentajeV1")
public class PorVentaIndividualPorcentajeV1RunAlgoritmo implements RunAlgoritmo {

    @Autowired
    private Logger log;

    @Autowired
    @Qualifier("runAlgoritmoProperties")
    private RunAlgoritmoPropertiesDto runAlgoritmoProperties;

    @Autowired
    private TareaCalculoAlgoritmoPorVentaIndividualPorcentajeV1RepositoryCustom tareaCalculoAlgoritmoPorVentaIndividualPorcentajeV1RepositoryCustom;

    @Autowired
    private TareaCalculoPersonaService tareaCalculoPersonaService;

    @Override
    public void execute(final RunTareaDto runTarea, final AlgoritmoDto algoritmo) {
        Flux.fromIterable(StreamUtils.partition(
            this.tareaCalculoAlgoritmoPorVentaIndividualPorcentajeV1RepositoryCustom.ids(algoritmo,
                        runTarea.getTarea()),
            this.runAlgoritmoProperties.getBatchSize()))
            .parallel()
            .runOn(ItxSchedulers.boundedElastic())
            .map(personas -> {
                this.log.info("Inicio :: PorVentaIndividualPorcentajeV1RunAlgoritmo :: Personas: {}", personas.size());
                try {
                    this.tareaCalculoAlgoritmoPorVentaIndividualPorcentajeV1RepositoryCustom.calcular(algoritmo,
                            runTarea.getTarea(), personas);
                } catch (final Exception e) {
                    this.log
                        .error("PorVentaIndividualPorcentajeV1RunAlgoritmo :: KO :: Personas: {}", personas.size(), e);
                    this.tareaCalculoPersonaService.updateWithEstadoAndidPersona(personas, runTarea,
                            EstadoTareaCalculoPersonaEnum.KO.getDto());
                }
                this.log.info("Fin :: PorVentaIndividualPorcentajeV1RunAlgoritmo :: Personas: {}", personas.size());
                return Flux.empty();
            })
            .sequential()
            .collectList()
            .block();
    }

    @Override
    public String getSqlCalcular(final AlgoritmoDto algoritmo) {
        return this.tareaCalculoAlgoritmoPorVentaIndividualPorcentajeV1RepositoryCustom.getSqlCalcular(algoritmo);
    }

}
