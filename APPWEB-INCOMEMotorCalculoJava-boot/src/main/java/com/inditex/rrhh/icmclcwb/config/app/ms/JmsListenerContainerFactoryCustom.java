package com.inditex.rrhh.icmclcwb.config.app.ms;

import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageType;

import com.inditex.rrhh.icmclcwb.config.app.ObjectMapperCustom;

import com.inditex.aqsw.framework.service.jms.JmsListenerContainerFactoryCustomizer;

public class JmsListenerContainerFactoryCustom implements JmsListenerContainerFactoryCustomizer {

    @Override
    public void customize(JmsListenerContainerFactory factory) {
        if (DefaultJmsListenerContainerFactory.class.isInstance(factory)) {
            MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
            converter.setTargetType(MessageType.TEXT);
            converter.setTypeIdPropertyName("_type");
            converter.setObjectMapper(new ObjectMapperCustom());
            ((DefaultJmsListenerContainerFactory) factory).setMessageConverter(converter);
            // ((DefaultJmsListenerContainerFactory) factory).setErrorHandler(new JmsErrorHandlerCustom());
        }
    }

}
