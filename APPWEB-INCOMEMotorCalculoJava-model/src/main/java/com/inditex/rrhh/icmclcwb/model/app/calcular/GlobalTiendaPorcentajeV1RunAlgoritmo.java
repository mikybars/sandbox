package com.inditex.rrhh.icmclcwb.model.app.calcular;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.inditex.aqsw.framework.common.reactor.autoconfiguration.ItxSchedulers;
import com.inditex.rrhh.icmclcwb.api.app.calcular.dto.AlgoritmoDto;
import com.inditex.rrhh.icmclcwb.api.app.calcular.properties.dto.RunAlgoritmoPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.EstadoTareaCalculoPersonaEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaCalculoPersonaService;
import com.inditex.rrhh.icmclcwb.model.app.util.StreamUtils;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaCalculoAlgoritmoGlobalTiendaRepositoryCustom;

import reactor.core.publisher.Flux;

@Component("globalTiendaPorcentajeV1")
public class GlobalTiendaPorcentajeV1RunAlgoritmo implements RunAlgoritmo {

    @Autowired
    private Logger log;

    @Autowired
    @Qualifier("runAlgoritmoProperties")
    private RunAlgoritmoPropertiesDto runAlgoritmoProperties;

    @Autowired
    private TareaCalculoAlgoritmoGlobalTiendaRepositoryCustom tareaCalculoAlgoritmoGlobalTiendaRepository;

    @Autowired
    private TareaCalculoPersonaService tareaCalculoPersonaService;

    @Override
    public void execute(RunTareaDto runTarea, AlgoritmoDto algoritmo) {
        Flux.fromIterable(
                StreamUtils.partition(tareaCalculoAlgoritmoGlobalTiendaRepository.ids(algoritmo, runTarea.getTarea()),
                        runAlgoritmoProperties.getBatchSize()))
                .parallel().runOn(ItxSchedulers.elastic()).map(personas -> {
                    log.info("Inicio :: Lanzando algoritmo: {} :: Personas: {}", algoritmo, personas);
                    try {
                        tareaCalculoAlgoritmoGlobalTiendaRepository.calcular(algoritmo, runTarea.getTarea(), personas);
                    } catch (Exception e) {
                        tareaCalculoPersonaService.save(personas, EstadoTareaCalculoPersonaEnum.KO.getDto());
                        log.error("Han fallado las personas", personas, e);
                    }
                    log.info("Fin :: Lanzando algoritmo: {} :: Personas: {}", algoritmo, personas);
                    return Flux.empty();
                }).sequential().collectList().block();
    }

}
