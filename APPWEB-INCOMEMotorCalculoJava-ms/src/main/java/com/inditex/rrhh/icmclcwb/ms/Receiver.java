package com.inditex.rrhh.icmclcwb.ms;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.inditex.rrhh.icmclcwb.api.app.dto.JobDto;

@Component
public class Receiver {

	@Autowired
	private Logger LOG;
	
	@JmsListener(destination = "proceso.queue", containerFactory = "containerFactoryListener1", concurrency = "2")
	//@JmsListener(id = "testListener", destination = "${amiga.service.jms.listener1.destination-fqdn}", containerFactory = "containerFactoryListener1")
	public void receiverProcessor(JobDto job) {
		LOG.info("Receiver.receiverProcessor(): " + job.toString());
	}

}