package com.inditex.rrhh.icmclcwb.ms.app.trabajo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoDto;

import com.inditex.aqsw.framework.data.jms.JmsClient;

@Component
public class SenderTrabajo {

    @Autowired
    @Qualifier("trabajoJmsClient")
    private JmsClient trabajoJmsClient;

    public void send(final TrabajoDto trabajo) {
        this.trabajoJmsClient.convertAndSend(trabajo);
    }

}
