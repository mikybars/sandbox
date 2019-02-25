package com.inditex.rrhh.icmclcwb.ms.app.tarea;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.inditex.aqsw.framework.data.jms.JmsClient;
import com.inditex.rrhh.icmclcwb.api.app.proceso.dto.ProcesoDto;

@Component
public class SenderTarea {

    @Autowired
    @Qualifier("tareaJmsClient")
    private JmsClient tareaJmsClient;

    public void send(ProcesoDto proceso) {
        tareaJmsClient.convertAndSend(proceso);
    }

}
