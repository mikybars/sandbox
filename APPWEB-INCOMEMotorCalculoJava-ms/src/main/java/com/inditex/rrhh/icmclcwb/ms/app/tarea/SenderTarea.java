package com.inditex.rrhh.icmclcwb.ms.app.tarea;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import org.apache.activemq.ScheduledMessage;

import com.inditex.aqsw.framework.data.jms.JmsClient;

@Component
public class SenderTarea {

    @Autowired
    @Qualifier("tareaJmsClient")
    private JmsClient tareaJmsClient;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void send(final TareaDto tarea) {
        // this.tareaJmsClient.convertAndSend(tarea);
        this.tareaJmsClient.convertAndSend(tarea, message -> {
            message.setLongProperty(ScheduledMessage.AMQ_SCHEDULED_DELAY, 60000);
            return message;
        });
    }

}
