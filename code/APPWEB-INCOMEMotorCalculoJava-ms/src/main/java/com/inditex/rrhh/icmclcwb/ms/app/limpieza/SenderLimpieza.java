package com.inditex.rrhh.icmclcwb.ms.app.limpieza;

import com.inditex.amigafwk.data.jms.JmsClient;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaLimpiezaDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class SenderLimpieza {

  @Autowired
  @Qualifier("limpiezaJmsClient")
  private JmsClient limpiezaJmsClient;

  public void send(final TareaLimpiezaDto limpieza) {
    this.limpiezaJmsClient.convertAndSend(limpieza);
  }

}
