package com.inditex.rrhh.icmclcwb.model.app.calcular.globaltiendaseccion.v1;

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
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaCalculoAlgoritmoGlobalTiendaSeccionPorcentajeDiariaV1RepositoryCustom;
import org.slf4j.Logger;
import reactor.core.publisher.Flux;

import com.inditex.aqsw.framework.common.reactor.autoconfiguration.ItxSchedulers;

@Component("globalTiendaSeccionPorcentajeDiariaV1")
public class GlobalTiendaSeccionPorcentajeDiariaV1RunAlgoritmo implements RunAlgoritmo {

    @Autowired
    private Logger log;

    @Autowired
    @Qualifier("runAlgoritmoProperties")
    private RunAlgoritmoPropertiesDto runAlgoritmoProperties;

    @Autowired
    private TareaCalculoAlgoritmoGlobalTiendaSeccionPorcentajeDiariaV1RepositoryCustom tareaCalculoAlgoritmoGlobalTiendaSeccionPorcentajeDiariaV1RepositoryCustom;

    @Autowired
    private TareaCalculoPersonaService tareaCalculoPersonaService;


    @Override
    public void execute(final RunTareaDto runTarea, final AlgoritmoDTO algoritmo) {
        Flux.fromIterable(StreamUtils.partition(
                this.tareaCalculoAlgoritmoGlobalTiendaSeccionPorcentajeDiariaV1RepositoryCustom.ids(algoritmo,
                        runTarea.getTarea()),
                this.runAlgoritmoProperties.getBatchSize()))
            .parallel()
            .runOn(ItxSchedulers.boundedElastic())
            .map(personas -> {
                this.log.info("Inicio :: GlobalTiendaSeccionPorcentajeDiariaV1RunAlgoritmo :: Personas: {}",
                        personas.size());
                try {
                    this.tareaCalculoAlgoritmoGlobalTiendaSeccionPorcentajeDiariaV1RepositoryCustom.calcular(algoritmo,
                            runTarea.getTarea(), personas);
                } catch (final Exception e) {
                    this.log.error("GlobalTiendaSeccionPorcentajeDiariaV1RunAlgoritmo :: KO :: Personas: {}",
                            personas.size(), e);
                    this.tareaCalculoPersonaService.updateWithEstadoAndidPersona(personas, runTarea,
                            EstadoTareaCalculoPersonaEnum.KO.getDto());
                }
                this.log.info("Fin :: GlobalTiendaSeccionPorcentajeDiariaV1RunAlgoritmo :: Personas: {}",
                        personas.size());
                return Flux.empty();
            })
            .sequential()
            .collectList()
            .block();
    }

    @Override
    public String getSqlCalcular(final AlgoritmoDTO algoritmo) {
        return this.tareaCalculoAlgoritmoGlobalTiendaSeccionPorcentajeDiariaV1RepositoryCustom
            .getSqlCalcular(algoritmo);
    }

}
