package com.inditex.rrhh.icmclcwb.ms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.inditex.aqsw.framework.data.jms.JmsClient;
import com.inditex.rrhh.icmclcwb.api.app.dto.JobDto;

@Component
public class Sender {

	@Autowired
	@Qualifier("primaryJmsClient")
	private JmsClient primaryJmsClient;

	public void send(JobDto job) {
		this.primaryJmsClient.convertAndSend(job);
	}
	
}