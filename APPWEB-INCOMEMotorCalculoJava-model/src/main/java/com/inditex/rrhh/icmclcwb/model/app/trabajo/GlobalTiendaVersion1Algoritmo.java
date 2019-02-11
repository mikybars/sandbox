package com.inditex.rrhh.icmclcwb.model.app.trabajo;

import java.util.concurrent.CountDownLatch;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.inditex.rrhh.icmclcwb.api.app.exception.IcmclcwbException;
import com.inditex.rrhh.icmclcwb.api.app.run.dto.RunTrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.AlgoritmoPropertiesDto;
import com.inditex.rrhh.icmclcwb.model.app.util.StreamUtils;
import com.inditex.rrhh.icmclcwb.model.primary.trabajo.repository.TrabajoCalculoAlgoritmoGlobalTiendaRepository;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

@Component("globalTiendaVersion1Algoritmo")
public class GlobalTiendaVersion1Algoritmo implements Algoritmo {

    @Autowired
    private Logger log;

    @Autowired
    private TrabajoCalculoAlgoritmoGlobalTiendaRepository trabajoCalculoAlgoritmoGlobalTiendaRepository;

    @Autowired
    @Qualifier("algoritmoProperties")
    private AlgoritmoPropertiesDto algoritmoProperties;

    @Override
    public Flux<Void> execute(RunTrabajoDto trabajoRunDto) {
        if (trabajoRunDto.getRunTrabajoCalcular().getEmpleado().size() >= algoritmoProperties.getMaxBatchSize()) {
            CountDownLatch latch = new CountDownLatch(1);
            Flux.fromIterable(StreamUtils.partition(/* TODO Hay que lanzarlo por empleado y ordinal */trabajoRunDto
                    .getRunTrabajoCalcular().getEmpleado(), algoritmoProperties.getMaxBatchSize())).parallel()
                    .runOn(Schedulers.parallel())
                    .doOnNext(idsEmpleados -> trabajoCalculoAlgoritmoGlobalTiendaRepository
                            .calcularByIdTrabajoAndIdsEmpleado(trabajoRunDto.getTrabajoDto().getId(), idsEmpleados))
                    .doOnError(ex -> log.error(ex.getMessage(), ex)).doAfterTerminate(latch::countDown).subscribe();
            try {
                latch.await();
            } catch (Exception e) {
                // TODO Modificar el estado de los empleados no procesados
                String msg = new StringBuilder("Trabajo[{").append(trabajoRunDto.getTrabajoDto().getId()).append(
                        "}] :: GlobalTiendaAlgoritmo.execute() :: Ha fallado el algoritmo para un bloque de empleados")
                        .toString();
                log.error(msg, e);
                return Flux.error(new IcmclcwbException(msg, e));
            }
        } else {
            trabajoCalculoAlgoritmoGlobalTiendaRepository.calcularByIdTrabajo(trabajoRunDto.getTrabajoDto().getId());
        }
        return Flux.empty();
    }

}
