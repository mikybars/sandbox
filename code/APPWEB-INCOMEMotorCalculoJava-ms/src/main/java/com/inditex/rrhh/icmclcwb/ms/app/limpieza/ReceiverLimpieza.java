package com.inditex.rrhh.icmclcwb.ms.app.limpieza;

import com.inditex.rrhh.icmclcwb.api.app.run.service.RunService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaLimpiezaDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component
public class ReceiverLimpieza {

  @Autowired
  private RunService runService;

  @JmsListener(id = "limpiezaListener", destination = "${amiga.service.jms.limpieza-queue.destination-fqdn}",
      containerFactory = "limpiezaContainerFactoryListener")
  public void onMessageTareaListener(final Message<TareaLimpiezaDto> message) {
    this.runService.runLimpieza(message.getPayload().getId());
  }

}
