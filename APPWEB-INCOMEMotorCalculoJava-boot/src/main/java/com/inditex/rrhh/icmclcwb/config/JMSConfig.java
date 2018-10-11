package com.inditex.rrhh.icmclcwb.config;

import javax.jms.ConnectionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.config.JmsListenerContainerFactory;

import com.inditex.aqsw.framework.data.jms.JmsClient;
import com.inditex.aqsw.framework.data.jms.JmsClientBuilder;
import com.inditex.aqsw.framework.data.jms.JmsConnectionFactoryBuilder;
import com.inditex.aqsw.framework.service.jms.JmsListenerContainerFactoryBuilder;

@Configuration
@EnableAutoConfiguration
public class JMSConfig {

	@Autowired
	private JmsClientBuilder jmsClientBuilder;

	@Autowired
	private JmsConnectionFactoryBuilder builderCF;

	@Bean
	@ConfigurationProperties(prefix = "amiga.data.jms.connectionFactory.broker1")
	public ConnectionFactory broker1CF(JmsConnectionFactoryBuilder builderCF) throws Exception {
		return builderCF.build();
	}

	@Bean
	public JmsListenerContainerFactory<?> containerFactoryListener1(@Qualifier("broker1CF") final ConnectionFactory cf,
					final JmsListenerContainerFactoryBuilder listenerContainerFactoryBuilder) {
		return listenerContainerFactoryBuilder.additionalCustomizers(new JmsListenerContainerFactoryCustom())
						.connectionFactory(cf).build();
	}

	@Bean("primaryJmsClient")
	@ConfigurationProperties(prefix = "amiga.data.jms.client.primary")
	public JmsClient primaryJmsClient(final JmsClientBuilder builder,
					@Qualifier("broker1CF") final ConnectionFactory cf) throws Exception {
		return jmsClientBuilder.additionalCustomizers(new JmsClientCustom()).connectionFactory(cf).build();
	}

}