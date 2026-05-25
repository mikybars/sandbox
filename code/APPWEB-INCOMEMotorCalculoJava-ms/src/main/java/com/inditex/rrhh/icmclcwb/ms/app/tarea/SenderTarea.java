package com.inditex.rrhh.icmclcwb.ms.app.tarea;

import com.inditex.amigafwk.data.jms.JmsClient;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class SenderTarea {

  @Autowired
  @Qualifier("tareaJmsClient")
  private JmsClient tareaJmsClient;

  public void sendWithDelayWithPriority(final TareaDto tarea, final long delay, final TareaPriorityEnum priority) {
    this.tareaJmsClient.setPriority(priority.getPriority());
    this.tareaJmsClient.convertAndSend(tarea, message -> {
      message.setLongProperty("_AMQ_SCHED_DELIVERY", delay);
      return message;
    });
    log.info("📤 Tarea {} SENT TO queue for processing (delay {}, priority {})", tarea.getId(), delay, priority);
  }

  public void sendWithPriority(final TareaDto tarea, final TareaPriorityEnum priority) {
    this.tareaJmsClient.setPriority(priority.getPriority());
    this.tareaJmsClient.convertAndSend(tarea);
    log.info("📤 Tarea {} SENT TO queue for processing (priority {})", tarea.getId(), priority);
  }

}
