package com.inditex.rrhh.icmclcwb.model.app.ajuste.condiciones;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.inditex.rrhh.icmclcwb.api.app.ajuste.properties.dto.RunAjustePropertiesDto;
import com.inditex.rrhh.icmclcwb.api.app.calcular.dto.AlgoritmoAjusteDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.EstadoTareaCalculoPersonaEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaCalculoPersonaService;
import com.inditex.rrhh.icmclcwb.model.app.calcular.RunAjuste;
import com.inditex.rrhh.icmclcwb.model.app.util.StreamUtils;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaCalculoAjusteCarenciaRepositoryCustom;
import org.slf4j.Logger;
import reactor.core.publisher.Flux;

import com.inditex.aqsw.framework.common.reactor.autoconfiguration.ItxSchedulers;

@Component("carenciaV1")
public class RunAjusteCarenciaProcesar implements RunAjuste {

    @Autowired
    private Logger log;

    @Autowired
    @Qualifier("runAjusteProperties")
    private RunAjustePropertiesDto runAjusteProperties;

    @Autowired
    private TareaCalculoAjusteCarenciaRepositoryCustom tareaCalculoAjusteCarenciaRepositoryCustom;

    @Autowired
    private TareaCalculoPersonaService tareaCalculoPersonaService;

    @Override
    public void execute(RunTareaDto runTarea, AlgoritmoAjusteDto algoritmoAjuste) {
        Flux.fromIterable(StreamUtils.partition(
                tareaCalculoAjusteCarenciaRepositoryCustom.ids(runTarea.getTarea()),
                runAjusteProperties.getBatchSize()))
            .parallel()
            .runOn(ItxSchedulers.boundedElastic())
            .map(personas -> {
                log.info("Inicio :: RunAjusteCarenciaProcesar :: Personas: {}", personas.size());
                try {
                    tareaCalculoAjusteCarenciaRepositoryCustom.ajustar(algoritmoAjuste, runTarea.getTarea(), personas);
                } catch (Exception e) {
                    log.error("RunAjusteCarenciaProcesar :: KO :: Personas: {}", personas.size(), e);
                    tareaCalculoPersonaService.updateWithEstadoAndidPersona(personas, runTarea,
                            EstadoTareaCalculoPersonaEnum.KO.getDto());
                }
                log.info("Fin :: RunAjusteCarenciaProcesar :: Personas: {}", personas.size());
                return Flux.empty();
            })
            .sequential()
            .collectList()
            .block();
    }

    @Override
    public String getSqlCalcular(AlgoritmoAjusteDto algoritmoAjuste) {
        return tareaCalculoAjusteCarenciaRepositoryCustom.getSqlAjustar(algoritmoAjuste);
    }

}
