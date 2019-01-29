package com.inditex.rrhh.icmclcwb.ms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.inditex.aqsw.framework.data.jms.JmsClient;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoDto;

@Component
public class SenderTrabajo {

	@Autowired
	@Qualifier("trabajoJmsClient")
	private JmsClient trabajoJmsClient;

	public void send(TrabajoDto trabajo) {
		trabajoJmsClient.convertAndSend(trabajo);
	}

}