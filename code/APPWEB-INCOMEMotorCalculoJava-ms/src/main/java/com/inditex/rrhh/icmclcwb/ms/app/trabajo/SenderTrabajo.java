package com.inditex.rrhh.icmclcwb.ms.app.trabajo;

import com.inditex.amigafwk.data.jms.JmsClient;
import com.inditex.rrhh.icmclcwb.dto.TrabajoDTO;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class SenderTrabajo {

  @Autowired
  @Qualifier("trabajoJmsClient")
  private JmsClient trabajoJmsClient;

  public void send(final TrabajoDTO trabajo) {
    this.trabajoJmsClient.convertAndSend(trabajo);
    log.info("📤 Trabajo {} SENT TO queue for processing", trabajo.getId());
  }

}
