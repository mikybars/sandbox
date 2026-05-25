package com.inditex.rrhh.icmclcwb.ms.app.tarea;

import com.inditex.rrhh.icmclcwb.api.app.run.service.RunService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ReceiverTarea {

  @Autowired
  private RunService runService;

  @JmsListener(id = "tareaListener", destination = "${amiga.service.jms.tarea-queue.destination-fqdn}",
      containerFactory = "tareaContainerFactoryListener")
  public void onMessageTareaListener(
      final Message<TareaDto> message /* TareaDto message */ /* TareaDto message, @Headers Map headers */) {
    final var idTarea = message.getPayload().getId();
    log.info("📥 Tarea {} RECEIVED FROM queue", idTarea);
    this.runService.runTarea(idTarea);
  }

}
