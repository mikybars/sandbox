package com.inditex.rrhh.icmclcwb.ms.app.tareaprevalidar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import org.apache.activemq.ScheduledMessage;

import com.inditex.aqsw.framework.data.jms.JmsClient;

@Component
public class SenderTareaPreValidar {

    @Autowired
    @Qualifier("tareaPreValidarJmsClient")
    private JmsClient tareaPreValidarJmsClient;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void send(final TareaDto tarea) {
        this.tareaPreValidarJmsClient.convertAndSend(tarea);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void sendWithDelay(final TareaDto tarea, final long delay) {
        this.tareaPreValidarJmsClient.convertAndSend(tarea, message -> {
            message.setLongProperty(ScheduledMessage.AMQ_SCHEDULED_DELAY, delay);
            return message;
        });
    }

}
