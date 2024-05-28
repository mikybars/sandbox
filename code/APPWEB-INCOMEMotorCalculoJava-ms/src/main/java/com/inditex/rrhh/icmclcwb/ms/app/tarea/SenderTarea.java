package com.inditex.rrhh.icmclcwb.ms.app.tarea;

import com.inditex.amigafwk.data.jms.JmsClient;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;

import org.apache.activemq.ScheduledMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class SenderTarea {

  @Autowired
  @Qualifier("tareaJmsClient")
  private JmsClient tareaJmsClient;

  public void sendWithDelayWithPriority(final TareaDto tarea, final long delay, final TareaPriorityEnum priority) {
    this.tareaJmsClient.setPriority(priority.getPriority());
    this.tareaJmsClient.convertAndSend(tarea, message -> {
      message.setLongProperty(ScheduledMessage.AMQ_SCHEDULED_DELAY, delay);
      return message;
    });
  }

  public void sendWithPriority(final TareaDto tarea, final TareaPriorityEnum priority) {
    this.tareaJmsClient.setPriority(priority.getPriority());
    this.tareaJmsClient.convertAndSend(tarea);
  }

}
