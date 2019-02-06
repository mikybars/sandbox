package com.inditex.rrhh.icmclcwb.model.app.trabajo;

import java.util.concurrent.CountDownLatch;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.inditex.rrhh.icmclcwb.api.app.exception.IcmclcwbException;
import com.inditex.rrhh.icmclcwb.api.app.run.dto.RunTrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.CalculoPropertiesDto;
import com.inditex.rrhh.icmclcwb.model.app.util.StreamUtils;
import com.inditex.rrhh.icmclcwb.model.primary.trabajo.repository.GTCalculoRepository;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

@Component
public class GTAlgoritmo implements TipoCalculoAlgoritmo {

    @Autowired
    private Logger log;

    @Autowired
    private GTCalculoRepository gTCalculoRepository;

    @Autowired
    @Qualifier("calculoGTPropertiesDto")
    private CalculoPropertiesDto gTcalculoProperties;

    @Override
    public Flux<Void> execute(RunTrabajoDto trabajoRunDto) {
        if (trabajoRunDto.getRunTrabajoCalcular().getEmpleado().size() >= gTcalculoProperties.getNumBlock()) {
            CountDownLatch latch = new CountDownLatch(1);
            Flux.fromIterable(StreamUtils.partition(/* TODO Hay que lanzarlo por empleado y ordinal */trabajoRunDto
                    .getRunTrabajoCalcular().getEmpleado(), gTcalculoProperties.getNumBlock())).parallel()
                    .runOn(Schedulers.parallel())
                    .doOnNext(idsEmpleados -> gTCalculoRepository
                            .calcularByIdTrabajoAndIdsEmpleado(trabajoRunDto.getTrabajoDto().getId(), idsEmpleados))
                    .doOnError(ex -> log.error(ex.getMessage(), ex)).doAfterTerminate(latch::countDown).subscribe();
            try {
                latch.await();
            } catch (Exception e) {
                // TODO Modificar el estado de los empleados no procesados
                String msg = new StringBuilder("Trabajo[{").append(trabajoRunDto.getTrabajoDto().getId())
                        .append("}] :: GTAlgoritmo.execute() :: Ha fallado el algoritmo para un bloque de empleados")
                        .toString();
                log.error(msg, e);
                return Flux.error(new IcmclcwbException(msg, e));
            }
        } else {
            gTCalculoRepository.calcularByIdTrabajo(trabajoRunDto.getTrabajoDto().getId());
        }
        return Flux.empty();
    }

}
