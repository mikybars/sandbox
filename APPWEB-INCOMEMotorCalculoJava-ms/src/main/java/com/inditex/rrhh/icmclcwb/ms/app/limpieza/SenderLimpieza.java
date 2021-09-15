package com.inditex.rrhh.icmclcwb.ms.app.limpieza;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaLimpiezaDto;

import com.inditex.aqsw.framework.data.jms.JmsClient;

@Component
public class SenderLimpieza {

    @Autowired
    @Qualifier("limpiezaJmsClient")
    private JmsClient limpiezaJmsClient;

    public void send(final TareaLimpiezaDto limpieza) {
        this.limpiezaJmsClient.convertAndSend(limpieza);
    }

}
