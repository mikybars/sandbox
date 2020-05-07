package com.inditex.rrhh.icmclcwb.model.app.calcular.challengepreciohoratiendaseccion.v1;

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
import com.inditex.rrhh.icmclcwb.model.app.calcular.RunAlgoritmo;
import com.inditex.rrhh.icmclcwb.model.app.util.StreamUtils;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaCalculoAlgoritmoChallengePrecioHoraTiendaSeccionV1RepositoryCustom;

import reactor.core.publisher.Flux;

@Component("challengePrecioHoraTiendaSeccionV1")
public class ChallengePrecioHoraTiendaSeccionV1RunAlgoritmo implements RunAlgoritmo {

    @Autowired
    private Logger log;

    @Autowired
    @Qualifier("runAlgoritmoProperties")
    private RunAlgoritmoPropertiesDto runAlgoritmoProperties;

    @Autowired
    private TareaCalculoAlgoritmoChallengePrecioHoraTiendaSeccionV1RepositoryCustom tareaCalculoAlgoritmoChallengePrecioHoraTiendaSeccionV1RepositoryCustom;

    @Autowired
    private TareaCalculoPersonaService tareaCalculoPersonaService;

    @Override
    public void execute(RunTareaDto runTarea, AlgoritmoDto algoritmo) {
        Flux.fromIterable(StreamUtils.partition(
                tareaCalculoAlgoritmoChallengePrecioHoraTiendaSeccionV1RepositoryCustom.ids(algoritmo,
                        runTarea.getTarea()),
                runAlgoritmoProperties.getBatchSize()))
            .parallel()
            .runOn(ItxSchedulers.elastic())
            .map(personas -> {
                log.info("Inicio :: ChallengePrecioHoraTiendaSeccionV1RunAlgoritmo :: Personas: {}", personas.size());
                try {
                    tareaCalculoAlgoritmoChallengePrecioHoraTiendaSeccionV1RepositoryCustom.calcular(algoritmo,
                            runTarea.getTarea(), personas);
                } catch (Exception e) {
                    log.error("ChallengePrecioHoraTiendaSeccionV1RunAlgoritmo :: KO :: Personas: {}", personas.size(),
                            e);
                    tareaCalculoPersonaService.updateWithEstadoAndidPersona(personas, runTarea,
                            EstadoTareaCalculoPersonaEnum.KO.getDto());
                }
                log.info("Fin :: ChallengePrecioHoraTiendaSeccionV1RunAlgoritmo :: Personas: {}", personas.size());
                return Flux.empty();
            })
            .sequential()
            .collectList()
            .block();
    }

    @Override
    public String getSqlCalcular(AlgoritmoDto algoritmo) {
        return tareaCalculoAlgoritmoChallengePrecioHoraTiendaSeccionV1RepositoryCustom.getSqlCalcular(algoritmo);
    }

}
