package com.inditex.rrhh.icmclcwb.ms.app.trabajo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import com.inditex.rrhh.icmclcwb.api.app.run.service.RunService;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoDto;

@Component
public class ReceiverTrabajo {

    @Autowired
    private RunService runService;

    // @CircuitBreaker(name = "trabajo")
    // @Transactional(propagation = Propagation.REQUIRES_NEW)
    @JmsListener(id = "trabajoListener", destination = "${amiga.service.jms.trabajo-queue.destination-fqdn}",
            containerFactory = "trabajoContainerFactoryListener")
    public void onMessageTrabajoListener(
            final Message<TrabajoDto> message /* TrabajoDto message */ /* TrabajoDto message, @Headers Map headers */) {
        this.runService.runTrabajo(message.getPayload().getId());
    }

}
