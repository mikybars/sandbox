package com.inditex.rrhh.icmclcwb.ms.app.programacion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.inditex.rrhh.icmclcwb.api.app.dto.IdProgramacionDto;

import com.inditex.aqsw.framework.data.jms.JmsClient;

@Component
public class SenderProgramacion {

    @Autowired
    @Qualifier("programacionJmsClient")
    private JmsClient programacionJmsClient;

    // @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void send(final IdProgramacionDto programacion) {
        this.programacionJmsClient.convertAndSend(programacion);
    }

}
