package com.inditex.rrhh.icmclcwb.ms;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import com.inditex.rrhh.icmclcwb.api.app.dto.JobDto;
import com.inditex.rrhh.icmclcwb.api.app.service.JobService;

import javax.jms.JMSException;

@Component
public class Receiver {

	@Autowired
	private Logger LOG;
	
	@Autowired
	private JobService jobService;

	@JmsListener(id = "jobListener", destination = "${amiga.service.jms.job-queue.destination-fqdn}", containerFactory = "containerFactoryListener", concurrency = "20")
	public void onMessageJobListener(
			Message<JobDto> message /* JobDto message */ /* JobDto message, @Headers Map headers */)
			throws JMSException {
		LOG.info("Receiver.onMessageJobListener() :: message.getPayload(): " + message.getPayload().toString());
		LOG.info("Receiver.onMessageJobListener() :: message.getHeaders(): " + message.getHeaders().toString());
		LOG.info("Receiver.onMessageJobListener() :: jobService.run(message.getPayload().getId())" + jobService.run(message.getPayload().getId()).toString());
	}

}