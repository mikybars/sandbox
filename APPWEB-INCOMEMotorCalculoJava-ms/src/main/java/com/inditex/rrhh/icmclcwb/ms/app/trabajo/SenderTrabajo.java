package com.inditex.rrhh.icmclcwb.ms.app.trabajo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.inditex.aqsw.framework.data.jms.JmsClient;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoDto;

@Component
public class SenderTrabajo {

	@Autowired
	@Qualifier("trabajoJmsClient")
	private JmsClient trabajoJmsClient;

	@Transactional
	public void send(TrabajoDto trabajo) {
		trabajoJmsClient.convertAndSend(trabajo);
	}

}