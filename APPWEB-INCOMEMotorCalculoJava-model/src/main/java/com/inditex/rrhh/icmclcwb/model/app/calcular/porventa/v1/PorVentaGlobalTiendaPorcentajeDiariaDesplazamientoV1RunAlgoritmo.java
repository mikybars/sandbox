package com.inditex.rrhh.icmclcwb.model.app.calcular.porventa.v1;

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
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaCalculoAlgoritmoPorVentaGlobalTiendaPorcentajeDiariaDesplazamientoV1RepositoryCustom;
import org.slf4j.Logger;
import reactor.core.publisher.Flux;

import com.inditex.aqsw.framework.common.reactor.autoconfiguration.ItxSchedulers;

@Component("porVentaGlobalTiendaPorcentajeDiariaDesplazamientoV1")
public class PorVentaGlobalTiendaPorcentajeDiariaDesplazamientoV1RunAlgoritmo implements RunAlgoritmo {

    @Autowired
    private Logger log;

    @Autowired
    @Qualifier("runAlgoritmoProperties")
    private RunAlgoritmoPropertiesDto runAlgoritmoProperties;

    @Autowired
    private TareaCalculoAlgoritmoPorVentaGlobalTiendaPorcentajeDiariaDesplazamientoV1RepositoryCustom tareaCalculoAlgoritmoPorVentaGlobalTiendaPorcentajeDiariaDesplazamientoV1RepositoryCustom;

    @Autowired
    private TareaCalculoPersonaService tareaCalculoPersonaService;

    @Override
    public void execute(RunTareaDto runTarea, AlgoritmoDto algoritmo) {
        Flux.fromIterable(StreamUtils.partition(
                tareaCalculoAlgoritmoPorVentaGlobalTiendaPorcentajeDiariaDesplazamientoV1RepositoryCustom.ids(algoritmo,
                        runTarea.getTarea()),
                runAlgoritmoProperties.getBatchSize()))
            .parallel()
            .runOn(ItxSchedulers.boundedElastic())
            .map(personas -> {
                log.info("Inicio :: PorVentaGlobalTiendaPorcentajeDiariaDesplazamientoV1RunAlgoritmo :: Personas: {}",
                        personas.size());
                try {
                    tareaCalculoAlgoritmoPorVentaGlobalTiendaPorcentajeDiariaDesplazamientoV1RepositoryCustom.calcular(
                            algoritmo,
                            runTarea.getTarea(), personas);
                } catch (Exception e) {
                    log.error("PorVentaGlobalTiendaPorcentajeDiariaDesplazamientoV1RunAlgoritmo :: KO :: Personas: {}",
                            personas.size(), e);
                    tareaCalculoPersonaService.updateWithEstadoAndidPersona(personas, runTarea,
                            EstadoTareaCalculoPersonaEnum.KO.getDto());
                }
                log.info("Fin :: PorVentaGlobalTiendaPorcentajeDiariaDesplazamientoV1RunAlgoritmo :: Personas: {}",
                        personas.size());
                return Flux.empty();
            })
            .sequential()
            .collectList()
            .block();
    }

    @Override
    public String getSqlCalcular(AlgoritmoDto algoritmo) {
        return tareaCalculoAlgoritmoPorVentaGlobalTiendaPorcentajeDiariaDesplazamientoV1RepositoryCustom
            .getSqlCalcular(algoritmo);
    }

}
