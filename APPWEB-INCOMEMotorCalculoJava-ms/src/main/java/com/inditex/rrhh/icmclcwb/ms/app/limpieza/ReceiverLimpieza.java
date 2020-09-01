package com.inditex.rrhh.icmclcwb.ms.app.limpieza;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.Message;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.inditex.rrhh.icmclcwb.api.app.dto.IdTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.service.RunService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Component
public class ReceiverLimpieza {

    @Autowired
    private RunService runService;

//    @CircuitBreaker(name = "limpieza")
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @JmsListener(id = "limpiezaListener", destination = "${amiga.service.jms.limpieza-queue.destination-fqdn}",
            containerFactory = "limpiezaContainerFactoryListener")
    public void onMessageTareaListener(Message<IdTareaDto> message) {
        runService.runLimpieza(message.getPayload().getId());
    }

}
