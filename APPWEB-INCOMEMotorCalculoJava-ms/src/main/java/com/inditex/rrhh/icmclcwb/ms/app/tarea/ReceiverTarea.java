package com.inditex.rrhh.icmclcwb.ms.app.tarea;

import com.inditex.rrhh.icmclcwb.api.app.run.service.RunService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component
public class ReceiverTarea {

  @Autowired
  private RunService runService;

  @JmsListener(id = "tareaListener", destination = "${amiga.service.jms.tarea-queue.destination-fqdn}",
      containerFactory = "tareaContainerFactoryListener")
  public void onMessageTareaListener(
      final Message<TareaDto> message /* TareaDto message */ /* TareaDto message, @Headers Map headers */) {
    this.runService.runTarea(message.getPayload().getId());
  }

}
