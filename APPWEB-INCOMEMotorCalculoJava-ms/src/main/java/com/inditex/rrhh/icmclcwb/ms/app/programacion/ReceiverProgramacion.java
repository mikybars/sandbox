package com.inditex.rrhh.icmclcwb.ms.app.programacion;

import com.inditex.rrhh.icmclcwb.api.app.dto.IdProgramacionDto;
import com.inditex.rrhh.icmclcwb.api.app.run.service.RunService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component
public class ReceiverProgramacion {

  @Autowired
  private RunService runService;

  @JmsListener(id = "programacionListener", destination = "${amiga.service.jms.programacion-queue.destination-fqdn}",
      containerFactory = "programacionContainerFactoryListener")
  public void onMessageProgramacionListener(final Message<IdProgramacionDto> message) {
    this.runService.runProgramacion(message.getPayload().getId());
  }

}
