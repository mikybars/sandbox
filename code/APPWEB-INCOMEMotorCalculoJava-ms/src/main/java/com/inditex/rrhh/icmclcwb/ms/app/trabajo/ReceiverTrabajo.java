package com.inditex.rrhh.icmclcwb.ms.app.trabajo;

import com.inditex.rrhh.icmclcwb.api.app.run.service.RunService;
import com.inditex.rrhh.icmclcwb.dto.TrabajoDTO;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ReceiverTrabajo {

  @Autowired
  private RunService runService;

  @JmsListener(id = "trabajoListener", destination = "${amiga.service.jms.trabajo-queue.destination-fqdn}",
      containerFactory = "trabajoContainerFactoryListener")
  public void onMessageTrabajoListener(
      final Message<TrabajoDTO> message /* TrabajoDto message */ /* TrabajoDto message, @Headers Map headers */) {
    final var idTrabajo = message.getPayload().getId();
    log.info("📥 Trabajo {} RECEIVED FROM queue", idTrabajo);
    this.runService.runTrabajo(message.getPayload().getId());
  }

}
