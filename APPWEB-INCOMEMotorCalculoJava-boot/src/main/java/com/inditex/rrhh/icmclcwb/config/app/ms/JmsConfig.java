package com.inditex.rrhh.icmclcwb.config.app.ms;

import javax.jms.ConnectionFactory;
import javax.jms.JMSException;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jms.config.JmsListenerContainerFactory;

import com.inditex.aqsw.framework.data.jms.JmsClient;
import com.inditex.aqsw.framework.data.jms.JmsClientBuilder;
import com.inditex.aqsw.framework.data.jms.JmsConnectionFactoryBuilder;
import com.inditex.aqsw.framework.data.jms.JmsConnectionFactoryGlobalCustomizer;
import com.inditex.aqsw.framework.service.jms.JmsListenerContainerFactoryBuilder;

@Configuration
@EnableAutoConfiguration
public class JmsConfig {

	@Autowired
	private Logger LOG;

	@Primary
	@Bean
	@ConfigurationProperties(prefix = "amiga.data.jms.connectionFactory.brokerLectura")
	public ConnectionFactory connectionFactoryLectura(JmsConnectionFactoryBuilder builder) throws JMSException {
		LOG.info("Inicio :: JMSConfig.connectionFactoryLectura(): {}", builder);
		ConnectionFactory result = builder.build();
		LOG.info("Fin :: JMSConfig.connectionFactoryLectura(): {}", result);
		return result;
	}

	@Bean
	@ConfigurationProperties(prefix = "amiga.data.jms.connectionFactory.brokerEscritura")
	public ConnectionFactory connectionFactoryEscritura(JmsConnectionFactoryBuilder builder) throws JMSException {
		LOG.info("Inicio :: JMSConfig.connectionFactoryEscritura(): {}", builder);
		ConnectionFactory result = builder.build();
		LOG.info("Fin :: JMSConfig.connectionFactoryEscritura(): {}", result);
		return result;
	}

	@Bean
	public JmsListenerContainerFactory<?> containerFactoryListener(
			@Qualifier("connectionFactoryLectura") final ConnectionFactory cf,
			final JmsListenerContainerFactoryBuilder listenerContainerFactoryBuilder) {
		LOG.info("Inicio :: JMSConfig.containerFactoryListener(): {} {}", cf, listenerContainerFactoryBuilder);
		JmsListenerContainerFactory<?> result = listenerContainerFactoryBuilder
				.additionalCustomizers(new JmsListenerContainerFactoryCustom()).connectionFactory(cf).build();
		LOG.info("Fin :: JMSConfig.containerFactoryListener(): {}", result);
		return result;
	}

	@Bean
	@ConfigurationProperties(prefix = "amiga.data.jms.client.trabajoJmsClient")
	public JmsClient trabajoJmsClient(final JmsClientBuilder builder,
			@Qualifier("connectionFactoryEscritura") final ConnectionFactory cf) throws JMSException {
		LOG.info("Inicio :: JMSConfig.trabajoJmsClient(): {} {}", builder, cf);
		JmsClient result = builder.additionalCustomizers(new JmsClientCustom()).connectionFactory(cf).build();
		LOG.info("Fin :: JMSConfig.trabajoJmsClient(): {}", result);
		return result;
	}

	@Bean
	public JmsConnectionFactoryGlobalCustomizer globalCustomizer() {
		LOG.info("Inicio :: JMSConfig.globalCustomizer()");
		JmsConnectionFactoryGlobalCustom result = new JmsConnectionFactoryGlobalCustom();
		LOG.info("Fin :: JMSConfig.globalCustomizer(): {}", result);
		return result;
	}

}