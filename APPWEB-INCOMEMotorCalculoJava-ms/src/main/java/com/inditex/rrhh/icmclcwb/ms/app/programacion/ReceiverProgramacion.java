package com.inditex.rrhh.icmclcwb.ms.app.programacion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.inditex.rrhh.icmclcwb.api.app.dto.IdProgramacionDto;
import com.inditex.rrhh.icmclcwb.api.app.run.service.RunService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Component
public class ReceiverProgramacion {

    @Autowired
    private RunService runService;

    @CircuitBreaker(name = "programacion")
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @JmsListener(id = "programacionListener", destination = "${amiga.service.jms.programacion-queue.destination-fqdn}",
            containerFactory = "programacionContainerFactoryListener")
    public void onMessageProgramacionListener(final Message<IdProgramacionDto> message) {
        this.runService.runProgramacion(message.getPayload().getId());
    }

}
