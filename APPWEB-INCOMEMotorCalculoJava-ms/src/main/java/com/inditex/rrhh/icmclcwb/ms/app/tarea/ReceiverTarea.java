package com.inditex.rrhh.icmclcwb.ms.app.tarea;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import com.inditex.rrhh.icmclcwb.api.app.run.service.RunService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Component
public class ReceiverTarea {

    @Autowired
    private RunService runService;

    @CircuitBreaker(name = "tarea")
    //@Transactional(propagation = Propagation.REQUIRES_NEW)
    @JmsListener(id = "tareaListener", destination = "${amiga.service.jms.tarea-queue.destination-fqdn}",
        containerFactory = "tareaContainerFactoryListener")
    public void onMessageTareaListener(
        final Message<TareaDto> message /* TareaDto message */ /* TareaDto message, @Headers Map headers */) {
        this.runService.runTarea(message.getPayload().getId());
    }

}
