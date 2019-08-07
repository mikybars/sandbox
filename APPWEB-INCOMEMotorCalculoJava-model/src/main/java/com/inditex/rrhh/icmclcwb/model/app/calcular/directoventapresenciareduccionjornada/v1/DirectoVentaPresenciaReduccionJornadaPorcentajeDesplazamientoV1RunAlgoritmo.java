package com.inditex.rrhh.icmclcwb.model.app.calcular.directoventapresenciareduccionjornada.v1;

import com.inditex.aqsw.framework.common.reactor.autoconfiguration.ItxSchedulers;
import com.inditex.rrhh.icmclcwb.api.app.calcular.dto.AlgoritmoDto;
import com.inditex.rrhh.icmclcwb.api.app.calcular.properties.dto.RunAlgoritmoPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.EstadoTareaCalculoPersonaEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaCalculoPersonaService;
import com.inditex.rrhh.icmclcwb.model.app.calcular.RunAlgoritmo;
import com.inditex.rrhh.icmclcwb.model.app.util.StreamUtils;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaCalculoAlgoritmoDirectoVentaPresenciaReduccionJornadaPorcentajeDesplazamientoV1RepositoryCustom;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

@Component("directoVentaPresenciaReduccionJornadaPorcentajeDesplazamientoV1")
public class DirectoVentaPresenciaReduccionJornadaPorcentajeDesplazamientoV1RunAlgoritmo implements RunAlgoritmo {

    @Autowired
    private Logger log;

    @Autowired
    @Qualifier("runAlgoritmoProperties")
    private RunAlgoritmoPropertiesDto runAlgoritmoProperties;

    @Autowired
    private TareaCalculoAlgoritmoDirectoVentaPresenciaReduccionJornadaPorcentajeDesplazamientoV1RepositoryCustom tareaCalculoAlgoritmoDirectoVentaPresenciaReduccionJornadaPorcentajeDesplazamientoV1RepositoryCustom;

    @Autowired
    private TareaCalculoPersonaService tareaCalculoPersonaService;

    @Override
    public void execute(RunTareaDto runTarea, AlgoritmoDto algoritmo) {
        log.warn("El algoritmo {} no está implementado", algoritmo);
        // TODO COMENTARIO_DESPLAZAMIENTOS_ALGORITMOS descomentar este bloque para habilitar el algoritmo
//        Flux.fromIterable(StreamUtils.partition(
//            tareaCalculoAlgoritmoDirectoVentaPresenciaReduccionJornadaPorcentajeDesplazamientoV1RepositoryCustom.ids(algoritmo, runTarea.getTarea()),
//            runAlgoritmoProperties.getBatchSize())).parallel().runOn(ItxSchedulers.elastic()).map(personas -> {
//                log.info("Inicio:: DirectoVentaPresenciaReduccionJornadaPorcentajeDesplazamientoV1RunAlgoritmo :: Personas: {}", personas.size());
//                try {
//                    tareaCalculoAlgoritmoDirectoVentaPresenciaReduccionJornadaPorcentajeDesplazamientoV1RepositoryCustom.calcular(algoritmo, runTarea.getTarea(), personas);
//                } catch (Exception e) {
//                    log.error("DirectoVentaPresenciaReduccionJornadaPorcentajeDesplazamientoV1RunAlgoritmo :: KO :: Personas: {}", personas.size(), e);
//                    tareaCalculoPersonaService.updateWithEstadoAndidPersona(personas, runTarea, EstadoTareaCalculoPersonaEnum.KO.getDto());
//                }
//                log.info("Fin :: DirectoVentaPresenciaReduccionJornadaPorcentajeDesplazamientoV1RunAlgoritmo :: Personas: {}", personas.size());
//                return Flux.empty();
//        }).sequential().collectList().block();
    }

    @Override
    public String getSqlCalcular(AlgoritmoDto algoritmo) {
        log.warn("El algoritmo {} no está implementado", algoritmo);
        return "SIN IMPLEMENTAR";
        // TODO COMENTARIO_DESPLAZAMIENTOS_ALGORITMOS descomentar este bloque para habilitar el algoritmo
//        return tareaCalculoAlgoritmoDirectoVentaPresenciaReduccionJornadaPorcentajeDesplazamientoV1RepositoryCustom.getSqlCalcular(algoritmo);
    }

}
