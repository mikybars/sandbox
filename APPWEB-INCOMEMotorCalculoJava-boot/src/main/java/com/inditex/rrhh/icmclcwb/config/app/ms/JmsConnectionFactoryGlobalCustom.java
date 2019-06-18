package com.inditex.rrhh.icmclcwb.config.app.ms;

import javax.jms.ConnectionFactory;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.RedeliveryPolicy;

import com.inditex.aqsw.framework.data.jms.JmsConnectionFactoryGlobalCustomizer;

public class JmsConnectionFactoryGlobalCustom implements JmsConnectionFactoryGlobalCustomizer {

    @Override
    public void customize(ConnectionFactory cf) {
        if (ActiveMQConnectionFactory.class.isInstance(cf)) {
            ActiveMQConnectionFactory activeMQCF = (ActiveMQConnectionFactory) cf;
            activeMQCF.setMessagePrioritySupported(true);
            RedeliveryPolicy redeliveryPolicy = new RedeliveryPolicy();
            redeliveryPolicy.setMaximumRedeliveries(0);
            activeMQCF.setRedeliveryPolicy(redeliveryPolicy);
        }
    }

}