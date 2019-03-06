package com.inditex.rrhh.icmclcwb.config.app.ms;

import javax.jms.ConnectionFactory;
import javax.jms.JMSException;

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

    @Primary
    @Bean
    @ConfigurationProperties(prefix = "amiga.data.jms.connection-factory.broker-lectura")
    public ConnectionFactory connectionFactoryLectura(JmsConnectionFactoryBuilder builder) throws JMSException {
        return builder.build();
    }

    @Bean
    @ConfigurationProperties(prefix = "amiga.data.jms.connection-factory.broker-escritura")
    public ConnectionFactory connectionFactoryEscritura(JmsConnectionFactoryBuilder builder) throws JMSException {
        return builder.build();
    }

    @Bean
    public JmsListenerContainerFactory containerFactoryListener(
            @Qualifier("connectionFactoryLectura") final ConnectionFactory cf,
            final JmsListenerContainerFactoryBuilder listenerContainerFactoryBuilder) {
        return listenerContainerFactoryBuilder.additionalCustomizers(new JmsListenerContainerFactoryCustom())
                .connectionFactory(cf).build();
    }

    @Bean
    @Qualifier("trabajoJmsClient")
    @ConfigurationProperties(prefix = "amiga.data.jms.client.trabajo")
    public JmsClient trabajoJmsClient(final JmsClientBuilder builder,
            @Qualifier("connectionFactoryEscritura") final ConnectionFactory cf) throws JMSException {
        return builder.additionalCustomizers(new JmsClientCustom()).connectionFactory(cf).build();
    }
    
    @Bean
    @Qualifier("tareaJmsClient")
    @ConfigurationProperties(prefix = "amiga.data.jms.client.tarea")
    public JmsClient tareaJmsClient(final JmsClientBuilder builder,
            @Qualifier("connectionFactoryEscritura") final ConnectionFactory cf) throws JMSException {
        return builder.additionalCustomizers(new JmsClientCustom()).connectionFactory(cf).build();
    }

    @Bean
    public JmsConnectionFactoryGlobalCustomizer globalCustomizer() {
        return new JmsConnectionFactoryGlobalCustom();
    }

}