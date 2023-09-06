package com.inditex.rrhh.icmclcwb.config.app.ms;

import com.inditex.aqsw.framework.data.jms.ActiveMQConnectionFactory;
import com.inditex.aqsw.framework.data.jms.ActiveMQXAConnectionFactory;
import com.inditex.aqsw.framework.data.jms.JmsConnectionFactoryGlobalCustomizer;

import javax.jms.ConnectionFactory;
import org.apache.activemq.RedeliveryPolicy;

public class JmsConnectionFactoryGlobalCustom implements JmsConnectionFactoryGlobalCustomizer {

  @Override
  public void customize(ConnectionFactory cf) {
    if (ActiveMQXAConnectionFactory.class.isInstance(cf)) {
      ActiveMQXAConnectionFactory activeMQCF = (ActiveMQXAConnectionFactory) cf;
      activeMQCF.setMessagePrioritySupported(true);
      RedeliveryPolicy redeliveryPolicy = new RedeliveryPolicy();
      redeliveryPolicy.setMaximumRedeliveries(0);
      activeMQCF.setRedeliveryPolicy(redeliveryPolicy);
    } else if (org.apache.activemq.ActiveMQXAConnectionFactory.class.isInstance(cf)) {
      org.apache.activemq.ActiveMQXAConnectionFactory activeMQCF = (org.apache.activemq.ActiveMQXAConnectionFactory) cf;
      activeMQCF.setMessagePrioritySupported(true);
      RedeliveryPolicy redeliveryPolicy = new RedeliveryPolicy();
      redeliveryPolicy.setMaximumRedeliveries(0);
      activeMQCF.setRedeliveryPolicy(redeliveryPolicy);
    } else if (ActiveMQConnectionFactory.class.isInstance(cf)) {
      ActiveMQConnectionFactory activeMQCF = (ActiveMQConnectionFactory) cf;
      activeMQCF.setMessagePrioritySupported(true);
      RedeliveryPolicy redeliveryPolicy = new RedeliveryPolicy();
      redeliveryPolicy.setMaximumRedeliveries(0);
      activeMQCF.setRedeliveryPolicy(redeliveryPolicy);
    } else if (org.apache.activemq.ActiveMQConnectionFactory.class.isInstance(cf)) {
      org.apache.activemq.ActiveMQConnectionFactory activeMQCF = (org.apache.activemq.ActiveMQConnectionFactory) cf;
      activeMQCF.setMessagePrioritySupported(true);
      RedeliveryPolicy redeliveryPolicy = new RedeliveryPolicy();
      redeliveryPolicy.setMaximumRedeliveries(0);
      activeMQCF.setRedeliveryPolicy(redeliveryPolicy);
    }
  }

}
