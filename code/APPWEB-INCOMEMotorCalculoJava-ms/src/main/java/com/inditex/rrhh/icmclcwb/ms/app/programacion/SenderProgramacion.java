package com.inditex.rrhh.icmclcwb.ms.app.programacion;

import com.inditex.amigafwk.data.jms.JmsClient;
import com.inditex.rrhh.icmclcwb.api.app.dto.IdProgramacionDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class SenderProgramacion {

  @Autowired
  @Qualifier("programacionJmsClient")
  private JmsClient programacionJmsClient;

  public void send(final IdProgramacionDto programacion) {
    this.programacionJmsClient.convertAndSend(programacion);
  }

}
