package com.inditex.rrhh.icmclcwb.model.app.proceso;

import java.util.concurrent.CountDownLatch;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.inditex.rrhh.icmclcwb.api.app.exception.IcmclcwbException;
import com.inditex.rrhh.icmclcwb.api.app.proceso.properties.dto.AlgoritmoPropertiesDto;
import com.inditex.rrhh.icmclcwb.api.app.run.proceso.dto.RunProcesoDto;
import com.inditex.rrhh.icmclcwb.model.app.util.StreamUtils;
import com.inditex.rrhh.icmclcwb.model.primary.proceso.repository.ProcesoCalculoAlgoritmoGlobalTiendaRepository;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

@Component("globalTiendaVersion1Algoritmo")
public class GlobalTiendaVersion1Algoritmo implements Algoritmo {

    @Autowired
    private Logger log;

    @Autowired
    private ProcesoCalculoAlgoritmoGlobalTiendaRepository procesoCalculoAlgoritmoGlobalTiendaRepository;

    @Autowired
    @Qualifier("algoritmoProperties")
    private AlgoritmoPropertiesDto algoritmoProperties;

    @Override
    public Flux<Void> execute(RunProcesoDto runProceso) {
        if (runProceso.getRunProcesoCalcular().getEmpleado().size() >= algoritmoProperties.getMaxBatchSize()) {
            CountDownLatch latch = new CountDownLatch(1);
            Flux.fromIterable(StreamUtils.partition(/* TODO Hay que lanzarlo por empleado y ordinal */runProceso
                    .getRunProcesoCalcular().getEmpleado(), algoritmoProperties.getMaxBatchSize())).parallel()
                    .runOn(Schedulers.parallel())
                    .doOnNext(idsEmpleados -> procesoCalculoAlgoritmoGlobalTiendaRepository
                            .calcularByIdProcesoAndIdsEmpleado(runProceso.getProceso().getId(), idsEmpleados))
                    .doOnError(ex -> log.error(ex.getMessage(), ex)).doAfterTerminate(latch::countDown).subscribe();
            try {
                latch.await();
            } catch (Exception e) {
                // TODO Modificar el estado de los empleados no procesados
                String msg = new StringBuilder("Proceso[{").append(runProceso.getProceso().getId()).append(
                        "}] :: GlobalTiendaAlgoritmo.execute() :: Ha fallado el algoritmo para un bloque de empleados")
                        .toString();
                log.error(msg, e);
                return Flux.error(new IcmclcwbException(msg, e));
            }
        } else {
            procesoCalculoAlgoritmoGlobalTiendaRepository.calcularByIdProceso(runProceso.getProceso().getId());
        }
        return Flux.empty();
    }

}
