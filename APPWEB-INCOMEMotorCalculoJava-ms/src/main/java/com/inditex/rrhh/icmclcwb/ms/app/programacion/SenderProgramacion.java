package com.inditex.rrhh.icmclcwb.ms.app.programacion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.inditex.aqsw.framework.data.jms.JmsClient;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdProgramacionDto;

@Component
public class SenderProgramacion {

    @Autowired
    @Qualifier("programacionJmsClient")
    private JmsClient programacionJmsClient;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void send(IdProgramacionDto programacion) {
        programacionJmsClient.convertAndSend(programacion);
    }

}
