package com.inditex.rrhh.icmclcwb.model.app.calcular.globaltiendaseccion.v1;

import com.inditex.aqsw.framework.common.reactor.autoconfiguration.ItxSchedulers;
import com.inditex.rrhh.icmclcwb.api.app.calcular.dto.AlgoritmoDto;
import com.inditex.rrhh.icmclcwb.api.app.calcular.properties.dto.RunAlgoritmoPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.EstadoTareaCalculoPersonaEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaCalculoPersonaService;
import com.inditex.rrhh.icmclcwb.model.app.calcular.RunAlgoritmo;
import com.inditex.rrhh.icmclcwb.model.app.util.StreamUtils;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaCalculoAlgoritmoGlobalTiendaSeccionPorcentajeDesplazamientoV1RepositoryCustom;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

@Component("globalTiendaSeccionPorcentajeDesplazamientoV1")
public class GlobalTiendaSeccionPorcentajeDesplazamientoV1RunAlgoritmo implements RunAlgoritmo {

    @Autowired
    private Logger log;

    @Autowired
    @Qualifier("runAlgoritmoProperties")
    private RunAlgoritmoPropertiesDto runAlgoritmoProperties;

    @Autowired
    private TareaCalculoAlgoritmoGlobalTiendaSeccionPorcentajeDesplazamientoV1RepositoryCustom tareaCalculoAlgoritmoGlobalTiendaSeccionPorcentajeDesplazamientoV1RepositoryCustom;

    @Autowired
    private TareaCalculoPersonaService tareaCalculoPersonaService;

    @Override
    public void execute(RunTareaDto runTarea, AlgoritmoDto algoritmo) {
        log.warn("El algoritmo {} no está implementado", algoritmo);
        // TODO COMENTARIO_DESPLAZAMIENTOS_ALGORITMOS descomentar este bloque para habilitar el algoritmo
//        Flux.fromIterable(StreamUtils.partition(
//            tareaCalculoAlgoritmoGlobalTiendaSeccionPorcentajeDesplazamientoV1RepositoryCustom.ids(algoritmo, runTarea.getTarea()),
//            runAlgoritmoProperties.getBatchSize())).parallel().runOn(ItxSchedulers.elastic()).map(personas -> {
//                log.info("Inicio :: GlobalTiendaSeccionPorcentajeDesplazamientoV1RunAlgoritmo :: Personas: {}", personas.size());
//                try {
//                    tareaCalculoAlgoritmoGlobalTiendaSeccionPorcentajeDesplazamientoV1RepositoryCustom.calcular(algoritmo,
//                        runTarea.getTarea(), personas);
//                } catch (Exception e) {
//                    log.error("GlobalTiendaSeccionPorcentajeDesplazamientoV1RunAlgoritmo :: KO :: Personas: {}", personas.size(), e);
//                    tareaCalculoPersonaService.updateWithEstadoAndidPersona(personas, runTarea, EstadoTareaCalculoPersonaEnum.KO.getDto());
//                }
//                log.info("Fin :: GlobalTiendaSeccionPorcentajeDesplazamientoV1RunAlgoritmo :: Personas: {}", personas.size());
//                return Flux.empty();
//        }).sequential().collectList().block();
    }

    @Override
    public String getSqlCalcular(AlgoritmoDto algoritmo) {
        log.warn("El algoritmo {} no está implementado", algoritmo);
        return "SIN IMPLEMENTAR";
        // TODO COMENTARIO_DESPLAZAMIENTOS_ALGORITMOS descomentar este bloque para habilitar el algoritmo
//        return tareaCalculoAlgoritmoGlobalTiendaSeccionPorcentajeDesplazamientoV1RepositoryCustom.getSqlCalcular(algoritmo);
    }

}
