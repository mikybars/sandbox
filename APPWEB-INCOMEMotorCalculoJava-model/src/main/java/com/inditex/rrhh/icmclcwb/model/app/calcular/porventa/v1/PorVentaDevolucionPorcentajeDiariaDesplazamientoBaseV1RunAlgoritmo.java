package com.inditex.rrhh.icmclcwb.model.app.calcular.porventa.v1;

import com.inditex.aqsw.framework.common.reactor.autoconfiguration.ItxSchedulers;
import com.inditex.rrhh.icmclcwb.api.app.calcular.dto.AlgoritmoDto;
import com.inditex.rrhh.icmclcwb.api.app.calcular.properties.dto.RunAlgoritmoPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.EstadoTareaCalculoPersonaEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaCalculoPersonaService;
import com.inditex.rrhh.icmclcwb.model.app.calcular.RunAlgoritmo;
import com.inditex.rrhh.icmclcwb.model.app.util.StreamUtils;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaCalculoAlgoritmoPorVentaDevolucionPorcentajeDiariaDesplazamientoBaseV1RepositoryCustom;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

@Component("porVentaDevolucionPorcentajeDiariaDesplazamientoBaseV1")
public class PorVentaDevolucionPorcentajeDiariaDesplazamientoBaseV1RunAlgoritmo implements RunAlgoritmo {

    @Autowired
    private Logger log;

    @Autowired
    @Qualifier("runAlgoritmoProperties")
    private RunAlgoritmoPropertiesDto runAlgoritmoProperties;

    @Autowired
    private TareaCalculoAlgoritmoPorVentaDevolucionPorcentajeDiariaDesplazamientoBaseV1RepositoryCustom tareaCalculoAlgoritmoPorVentaDevolucionPorcentajeDiariaDesplazamientoBaseV1RepositoryCustom;

    @Autowired
    private TareaCalculoPersonaService tareaCalculoPersonaService;

    @Override
    public void execute(RunTareaDto runTarea, AlgoritmoDto algoritmo) {
        Flux.fromIterable(StreamUtils.partition(
            tareaCalculoAlgoritmoPorVentaDevolucionPorcentajeDiariaDesplazamientoBaseV1RepositoryCustom.ids(algoritmo, runTarea.getTarea()),
            runAlgoritmoProperties.getBatchSize())).parallel().runOn(ItxSchedulers.elastic()).map(personas -> {
            log.info("Inicio :: PorVentaDevolucionPorcentajeDiariaDesplazamientoBaseV1RunAlgoritmo :: Personas: {}", personas.size());
            try {
                tareaCalculoAlgoritmoPorVentaDevolucionPorcentajeDiariaDesplazamientoBaseV1RepositoryCustom.calcular(algoritmo,
                    runTarea.getTarea(), personas);
            } catch (Exception e) {
                log.error("PorVentaDevolucionPorcentajeDiariaDesplazamientoBaseV1RunAlgoritmo :: KO :: Personas: {}", personas.size(), e);
                tareaCalculoPersonaService.updateWithEstadoAndidPersona(personas, runTarea, EstadoTareaCalculoPersonaEnum.KO.getDto());
            }
            log.info("Fin :: PorVentaDevolucionPorcentajeDiariaDesplazamientoBaseV1RunAlgoritmo :: Personas: {}", personas.size());
            return Flux.empty();
        }).sequential().collectList().block();
    }

    @Override
    public String getSqlCalcular(AlgoritmoDto algoritmo) {
        return tareaCalculoAlgoritmoPorVentaDevolucionPorcentajeDiariaDesplazamientoBaseV1RepositoryCustom.getSqlCalcular(algoritmo);
    }
    
}
