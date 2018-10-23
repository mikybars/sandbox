package com.inditex.rrhh.icmclcwb.ms;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.service.TrabajoService;

@Component
public class Receiver {

	@Autowired
	private Logger LOG;
	
	@Autowired
	private TrabajoService trabajoService;

	@JmsListener(id = "trabajoListener", destination = "${amiga.service.jms.trabajo-queue.destination-fqdn}", containerFactory = "containerFactoryListener", concurrency = "50-100")
	public void onMessageTrabajoListener(
			Message<TrabajoDto> message /* TrabajoDto message */ /* TrabajoDto message, @Headers Map headers */)
			throws Exception {
		LOG.info("Receiver.onMessageTrabajoListener() :: message.getPayload(): " + message.getPayload().toString());
		LOG.info("Receiver.onMessageTrabajoListener() :: message.getHeaders(): " + message.getHeaders().toString());
		LOG.info("Receiver.onMessageTrabajoListener() :: trabajoService.run(message.getPayload().getId())" + trabajoService.run(message.getPayload().getId()).toString());
	}

}