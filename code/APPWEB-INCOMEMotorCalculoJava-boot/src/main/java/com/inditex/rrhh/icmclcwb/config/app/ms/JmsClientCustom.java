package com.inditex.rrhh.icmclcwb.config.app.ms;

import com.inditex.aqsw.framework.data.jms.JmsClient;
import com.inditex.aqsw.framework.data.jms.JmsClientCustomizer;
import com.inditex.rrhh.icmclcwb.config.app.ObjectMapperCustom;

import javax.jms.JMSException;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageType;

public class JmsClientCustom implements JmsClientCustomizer {

  @Override
  public void customize(JmsClient jmsClient) throws JMSException {
    MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
    converter.setTargetType(MessageType.TEXT);
    converter.setTypeIdPropertyName("_type");
    converter.setObjectMapper(new ObjectMapperCustom());
    jmsClient.setMessageConverter(converter);
    jmsClient.setExplicitQosEnabled(true);
  }

}
