package com.inditex.rrhh.icmclcwb.ms.app.limpieza;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.inditex.aqsw.framework.data.jms.JmsClient;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdTareaDto;

@Component
public class SenderLimpieza {

    @Autowired
    @Qualifier("limpiezaJmsClient")
    private JmsClient limpiezaJmsClient;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void send(IdTareaDto tarea) {
        limpiezaJmsClient.convertAndSend(tarea);
    }

}
