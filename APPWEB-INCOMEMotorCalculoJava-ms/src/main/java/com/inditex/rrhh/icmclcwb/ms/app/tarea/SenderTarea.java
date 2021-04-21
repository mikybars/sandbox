package com.inditex.rrhh.icmclcwb.ms.app.tarea;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import org.apache.activemq.ScheduledMessage;

import com.inditex.aqsw.framework.data.jms.JmsClient;

@Component
public class SenderTarea {

    @Autowired
    @Qualifier("tareaJmsClient")
    private JmsClient tareaJmsClient;

    // @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void send(final TareaDto tarea) {
        this.tareaJmsClient.convertAndSend(tarea);
    }

    // @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void sendWithDelay(final TareaDto tarea, final long delay) {
        this.tareaJmsClient.convertAndSend(tarea, message -> {
            message.setLongProperty(ScheduledMessage.AMQ_SCHEDULED_DELAY, delay);
            return message;
        });
    }

    // @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void sendWithPriority(final TareaDto tarea, final int priority) {
        this.tareaJmsClient.convertAndSend(tarea, message -> {
            message.setJMSPriority(priority);
            return message;
        });
    }

}
