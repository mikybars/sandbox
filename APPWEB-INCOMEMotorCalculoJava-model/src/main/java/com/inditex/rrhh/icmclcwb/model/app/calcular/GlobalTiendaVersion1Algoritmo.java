package com.inditex.rrhh.icmclcwb.model.app.calcular;

import java.util.concurrent.CountDownLatch;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.inditex.rrhh.icmclcwb.api.app.calcular.dto.AlgoritmoDto;
import com.inditex.rrhh.icmclcwb.api.app.calcular.properties.dto.AlgoritmoPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.app.exception.IcmclcwbException;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.model.app.util.StreamUtils;
import com.inditex.rrhh.icmclcwb.model.primary.tarea.repository.TareaCalculoAlgoritmoGlobalTiendaRepositoryCustom;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

@Component("globalTiendaVersion1Algoritmo")
public class GlobalTiendaVersion1Algoritmo implements Algoritmo {

    @Autowired
    private Logger log;

    @Autowired
    private TareaCalculoAlgoritmoGlobalTiendaRepositoryCustom tareaCalculoAlgoritmoGlobalTiendaRepository;

    @Autowired
    @Qualifier("algoritmoProperties")
    private AlgoritmoPropertiesDto algoritmoProperties;

    @Override
    public Flux<Void> execute(RunTareaDto runTarea, AlgoritmoDto algoritmo) {
        if (runTarea.getRunTareaCalcular().getEmpleado().size() >= algoritmoProperties.getBatchSize()) {
            CountDownLatch latch = new CountDownLatch(1);
            Flux.fromIterable(StreamUtils.partition(
                    /* TODO Hay que lanzarlo por empleado y ordinal */runTarea.getRunTareaCalcular().getEmpleado(),
                    algoritmoProperties.getBatchSize())).parallel().runOn(Schedulers.parallel())
                    .doOnNext(idsEmpleados -> tareaCalculoAlgoritmoGlobalTiendaRepository
                            .calcularByIdTareaAndIdsEmpleado(runTarea.getTarea().getId(), algoritmo, idsEmpleados))
                    .doOnError(ex -> log.error(ex.getMessage(), ex)).doAfterTerminate(latch::countDown).subscribe();
            try {
                latch.await();
            } catch (Exception e) {
                // TODO Modificar el estado de los empleados no procesados
                String msg = new StringBuilder("Tarea[{").append(runTarea.getTarea().getId())
                        .append("}] :: GlobalTiendaAlgoritmo.execute() :: Ha fallado el algoritmo: ")
                        .append(algoritmo.getId()).append(" para un bloque de empleados").toString();
                log.error(msg, e);
                return Flux.error(new IcmclcwbException(msg, e));
            }
        } else {
            tareaCalculoAlgoritmoGlobalTiendaRepository.calcularByIdTarea(runTarea.getTarea().getId(), algoritmo);
        }
        return Flux.empty();
    }

}
