package com.inditex.rrhh.icmclcwb.ms.app.proceso;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import com.inditex.rrhh.icmclcwb.api.app.run.service.RunService;
import com.inditex.rrhh.icmclcwb.api.app.proceso.dto.ProcesoDto;

@Component
public class ReceiverProceso {

    @Autowired
    private RunService runService;

    @JmsListener(id = "procesoListener", destination = "${amiga.service.jms.proceso-queue.destination-fqdn}", containerFactory = "containerFactoryListener", concurrency = "${amiga.service.jms.proceso-queue.concurrency}")
    public void onMessageProcesoListener(
            Message<ProcesoDto> message /* ProcesoDto message */ /* ProcesoDto message, @Headers Map headers */) {
        runService.runProceso(message.getPayload().getId());
    }

}