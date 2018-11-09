package com.inditex.rrhh.icmclcwb.config.app.ms;

import javax.jms.ConnectionFactory;

import com.inditex.aqsw.framework.data.jms.ActiveMQConnectionFactory;
import com.inditex.aqsw.framework.data.jms.JmsConnectionFactoryGlobalCustomizer;

public class JmsConnectionFactoryGlobalCustom implements JmsConnectionFactoryGlobalCustomizer {
	
	@Override
	public void customize(ConnectionFactory cf) {
		if (ActiveMQConnectionFactory.class.isInstance(cf)) {
			ActiveMQConnectionFactory activeMQCF = (ActiveMQConnectionFactory) cf;
			// activeMQCF.setCloseTimeout(CLOSE_TIMEOUT);
			// activeMQCF.setSendTimeout(SEND_TIMEOUT);
			activeMQCF.setMessagePrioritySupported(true);
		}
	}

}