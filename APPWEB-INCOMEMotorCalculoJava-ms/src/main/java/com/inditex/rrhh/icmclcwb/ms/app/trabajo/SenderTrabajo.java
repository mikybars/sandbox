package com.inditex.rrhh.icmclcwb.ms.app.trabajo;

import com.inditex.aqsw.framework.data.jms.JmsClient;
import com.inditex.rrhh.icmclcwb.dto.TrabajoDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class SenderTrabajo {

  @Autowired
  @Qualifier("trabajoJmsClient")
  private JmsClient trabajoJmsClient;

  public void send(final TrabajoDTO trabajo) {
    this.trabajoJmsClient.convertAndSend(trabajo);
  }

}
