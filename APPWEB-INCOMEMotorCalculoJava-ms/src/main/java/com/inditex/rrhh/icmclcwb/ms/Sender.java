package com.inditex.rrhh.icmclcwb.ms;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.inditex.aqsw.framework.data.jms.JmsClient;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoDto;

@Component
public class Sender {

	@Autowired
	private Logger LOG;

	@Autowired
	@Qualifier("trabajoJmsClient")
	private JmsClient trabajoJmsClient;

	public void send(TrabajoDto trabajo) {
		LOG.info("Inicio :: Sender.send(): " + trabajo.toString());
		trabajoJmsClient.convertAndSend(trabajo);
		LOG.info("Fin :: Sender.send(): " + trabajo.toString());
	}

}