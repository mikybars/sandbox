package com.inditex.rrhh.icmclcwb.ms;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.service.TrabajoRunService;

@Component
public class ReceiverTrabajo {

	@Autowired
	private Logger LOG;

	@Autowired
	private TrabajoRunService trabajoRunService;

	@JmsListener(id = "trabajoListener", destination = "${amiga.service.jms.trabajo-queue.destination-fqdn}", containerFactory = "containerFactoryListener", concurrency = "${amiga.service.jms.trabajo-queue.concurrency}")
	public void onMessageTrabajoListener(
			Message<TrabajoDto> message /* TrabajoDto message */ /* TrabajoDto message, @Headers Map headers */)
			throws Exception {
		LOG.info("Inicio :: ReceiverTrabajo.onMessageTrabajoListener()");
		LOG.info("Receiver.onMessageTrabajoListener() :: message.getPayload(): {}", message.getPayload());
		LOG.info("Receiver.onMessageTrabajoListener() :: message.getHeaders(): {}", message.getHeaders());
		LOG.info("Receiver.onMessageTrabajoListener() :: trabajoRunService.run(message.getPayload().getId()): {}",
				trabajoRunService.run(message.getPayload().getId()));
		LOG.info("Fin :: ReceiverTrabajo.onMessageTrabajoListener()");
	}

}