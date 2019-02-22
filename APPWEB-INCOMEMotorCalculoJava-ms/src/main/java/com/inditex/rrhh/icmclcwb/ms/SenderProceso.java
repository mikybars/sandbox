package com.inditex.rrhh.icmclcwb.ms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.inditex.aqsw.framework.data.jms.JmsClient;
import com.inditex.rrhh.icmclcwb.api.app.proceso.dto.ProcesoDto;

@Component
public class SenderProceso {

	@Autowired
	@Qualifier("procesoJmsClient")
	private JmsClient procesoJmsClient;

	public void send(ProcesoDto proceso) {
		procesoJmsClient.convertAndSend(proceso);
	}

}