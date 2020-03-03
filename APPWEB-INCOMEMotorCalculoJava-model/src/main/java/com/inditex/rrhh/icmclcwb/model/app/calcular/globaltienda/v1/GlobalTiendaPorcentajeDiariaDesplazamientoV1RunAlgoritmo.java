package com.inditex.rrhh.icmclcwb.model.app.calcular.globaltienda.v1;

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
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaCalculoAlgoritmoGlobalTiendaPorcentajeDiariaDesplazamientoV1RepositoryCustom;

import reactor.core.publisher.Flux;

@Component("globalTiendaPorcentajeDiariaDesplazamientoV1")
public class GlobalTiendaPorcentajeDiariaDesplazamientoV1RunAlgoritmo implements RunAlgoritmo {

    @Autowired
    private Logger log;

    @Autowired
    @Qualifier("runAlgoritmoProperties")
    private RunAlgoritmoPropertiesDto runAlgoritmoProperties;

    @Autowired
    private TareaCalculoAlgoritmoGlobalTiendaPorcentajeDiariaDesplazamientoV1RepositoryCustom tareaCalculoAlgoritmoGlobalTiendaPorcentajeDiariaDesplazamientoV1RepositoryCustom;

    @Autowired
    private TareaCalculoPersonaService tareaCalculoPersonaService;
    
    @Override
    public void execute(RunTareaDto runTarea, AlgoritmoDto algoritmo) {
        Flux.fromIterable(StreamUtils.partition(
                tareaCalculoAlgoritmoGlobalTiendaPorcentajeDiariaDesplazamientoV1RepositoryCustom.ids(algoritmo, runTarea.getTarea()),
                runAlgoritmoProperties.getBatchSize())).parallel().runOn(ItxSchedulers.elastic()).map(personas -> {
                    log.info("Inicio :: GlobalTiendaPorcentajeDiariaDesplazamientoV1RunAlgoritmo :: Personas: {}", personas.size());
                    try {
                        tareaCalculoAlgoritmoGlobalTiendaPorcentajeDiariaDesplazamientoV1RepositoryCustom.calcular(algoritmo,
                                runTarea.getTarea(), personas);
                    } catch (Exception e) {
                        log.error("GlobalTiendaPorcentajeDiariaDesplazamientoV1RunAlgoritmo :: KO :: Personas: {}", personas.size(), e);
                        tareaCalculoPersonaService.updateWithEstadoAndidPersona(personas, runTarea,
                                EstadoTareaCalculoPersonaEnum.KO.getDto());
                    }
                    log.info("Fin :: GlobalTiendaPorcentajeDiariaDesplazamientoV1RunAlgoritmo :: Personas: {}", personas.size());
                    return Flux.empty();
                }).sequential().collectList().block();
    }

    @Override
    public String getSqlCalcular(AlgoritmoDto algoritmo) {
        return tareaCalculoAlgoritmoGlobalTiendaPorcentajeDiariaDesplazamientoV1RepositoryCustom.getSqlCalcular(algoritmo);
    }

}
