package com.inditex.rrhh.icmclcwb.ms.app.trabajo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoDto;

import com.inditex.aqsw.framework.data.jms.JmsClient;

@Component
public class SenderTrabajo {

    @Autowired
    @Qualifier("trabajoJmsClient")
    private JmsClient trabajoJmsClient;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void send(final TrabajoDto trabajo) {
        this.trabajoJmsClient.convertAndSend(trabajo);
    }

}
