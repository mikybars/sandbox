package com.inditex.rrhh.icmclcwb.ms;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.inditex.aqsw.framework.data.jms.JmsClient;
import com.inditex.rrhh.icmclcwb.api.app.dto.JobDto;

@Component
public class Sender {

	@Autowired
	private Logger LOG;

	@Autowired
	@Qualifier("primaryJmsClient")
	private JmsClient primaryJmsClient;

	public void send(JobDto job) {
		LOG.info("Inicio :: Sender.send(): " + job.toString());
		this.primaryJmsClient.convertAndSend(job);
		LOG.info("Fin :: Sender.send(): " + job.toString());
	}

}