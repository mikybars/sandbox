package com.inditex.rrhh.icmclcwb.model.app.calcular;

import java.util.concurrent.CountDownLatch;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.inditex.rrhh.icmclcwb.api.app.calcular.dto.AlgoritmoDto;
import com.inditex.rrhh.icmclcwb.api.app.calcular.properties.dto.RunAlgoritmoPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.model.app.util.ReactorUtils;
import com.inditex.rrhh.icmclcwb.model.app.util.StreamUtils;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaCalculoAlgoritmoGlobalTiendaRepositoryCustom;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

@Component("globalTiendaPorcentajeV1")
public class GlobalTiendaPorcentajeV1RunAlgoritmo implements RunAlgoritmo {

    @Autowired
    private Logger log;

    @Autowired
    @Qualifier("algoritmoProperties")
    private RunAlgoritmoPropertiesDto runAlgoritmoProperties;

    @Autowired
    private TareaCalculoAlgoritmoGlobalTiendaRepositoryCustom tareaCalculoAlgoritmoGlobalTiendaRepository;

    @Override
    public void execute(RunTareaDto runTarea, AlgoritmoDto algoritmo) {
//        Collection<List<TareaCalculoPersonaDto>> bloques = StreamUtils.partition(
//                tareaCalculoAlgoritmoGlobalTiendaRepository.ids(algoritmo, runTarea.getTarea()),
//                runAlgoritmoProperties.getBatchSize());
//        Flux.fromIterable(bloques).parallel().runOn(Schedulers.parallel()).doOnNext(personas -> {
//            log.info("Inicio :: Lanzando algoritmo: {} :: Personas: {}", algoritmo, personas);
//            tareaCalculoAlgoritmoGlobalTiendaRepository.calcular(algoritmo, runTarea.getTarea(), personas);
//            log.info("Fin :: Lanzando algoritmo: {} :: Personas: {}", algoritmo, personas);
//        }).sequential().collectList().subscribeOn(Schedulers.parallel());

//        CountDownLatch latch = new CountDownLatch(1);
//        Flux.fromIterable(
//                StreamUtils.partition(tareaCalculoAlgoritmoGlobalTiendaRepository.ids(algoritmo, runTarea.getTarea()),
//                        runAlgoritmoProperties.getBatchSize()))
//                .parallel().runOn(Schedulers.parallel()).doOnNext(personas -> {
//                    log.info("Inicio :: Lanzando algoritmo: {} :: Personas: {}", algoritmo, personas);
//                    tareaCalculoAlgoritmoGlobalTiendaRepository.calcular(algoritmo, runTarea.getTarea(), personas);
//                    log.info("Fin :: Lanzando algoritmo: {} :: Personas: {}", algoritmo, personas);
//                }).doOnError(ex -> log.error("Ha fallado un bloque", ex)).sequential()
//                .doAfterTerminate(latch::countDown).subscribe();
//        ReactorUtils.await(latch);

        CountDownLatch latch = new CountDownLatch(1);
        Flux.fromIterable(
                StreamUtils.partition(tareaCalculoAlgoritmoGlobalTiendaRepository.ids(algoritmo, runTarea.getTarea()),
                        runAlgoritmoProperties.getBatchSize()))
                .parallel().runOn(Schedulers.parallel()).doOnNext(personas -> {
                    log.info("Inicio :: Lanzando algoritmo: {} :: Personas: {}", algoritmo, personas);
                    tareaCalculoAlgoritmoGlobalTiendaRepository.calcular(algoritmo, runTarea.getTarea(), personas);
                    log.info("Fin :: Lanzando algoritmo: {} :: Personas: {}", algoritmo, personas);
                }).doOnError(ex -> log.error("Ha fallado un bloque", ex)).doAfterTerminate(latch::countDown)
                .subscribe();
        ReactorUtils.await(latch);

//        CountDownLatch latch = new CountDownLatch(1);
//        Flux.fromIterable(
//                StreamUtils.partition(tareaCalculoAlgoritmoGlobalTiendaRepository.ids(algoritmo, runTarea.getTarea()),
//                        algoritmoProperties.getBatchSize()))
//                .parallel().runOn(Schedulers.parallel()).doOnNext(personas -> {
//                    //log.info("Lanzando: {}", personas);
//                    tareaCalculoAlgoritmoGlobalTiendaRepository.calcular(algoritmo, runTarea.getTarea(), personas)
//                            .onErrorResume(ex -> {
//                                //TODO Hay que marcar las personas como error
//                                log.error("Ha fallado el bloque: {}", personas, ex);
//                                return Flux.empty();
//                            });
//                }).doOnError(ex -> log.error("Ha fallado un bloque", ex)).doAfterTerminate(latch::countDown)
//                .subscribe();
//        ReactorUtils.await(latch);
//        return Flux.empty();

    }

}
