package com.inditex.rrhh.icmclcwb.ms.app.tareaprevalidar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.inditex.rrhh.icmclcwb.api.app.run.service.RunService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Component
public class ReceiverTareaPreValidar {

    @Autowired
    private RunService runService;

    @CircuitBreaker(name = "tarea-prevalidar")
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @JmsListener(id = "tareaPreValidarListener",
            destination = "${amiga.service.jms.tarea-prevalidar-queue.destination-fqdn}",
            containerFactory = "tareaPrevalidarContainerFactoryListener")
    public void onMessageTareaPreValidarListener(
            final Message<TareaDto> message /* TareaDto message */ /* TareaDto message, @Headers Map headers */) {
        this.runService.runTareaPreValidar(message.getPayload().getId());
    }

}
