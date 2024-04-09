package com.inditex.rrhh.icmclcwb.config.app.ms;

import com.inditex.amigafwk.data.jms.ActiveMQConnectionFactoryBuilder;
import com.inditex.amigafwk.data.jms.JmsClient;
import com.inditex.amigafwk.data.jms.JmsClientBuilder;
import com.inditex.amigafwk.data.jms.JmsConnectionFactoryGlobalCustomizer;
import com.inditex.amigafwk.data.jms.JmsConnectionFactoryType;
import com.inditex.amigafwk.data.jms.annotation.AmigaJmsClient;
import com.inditex.amigafwk.data.jms.annotation.AmigaJmsConnectionFactory;
import com.inditex.amigafwk.service.jms.JmsListenerContainerFactoryBuilder;

import jakarta.jms.ConnectionFactory;
import jakarta.jms.JMSException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jms.config.JmsListenerContainerFactory;

@Configuration
public class JmsConfig {
  @Primary
  @AmigaJmsConnectionFactory("broker-lectura")
  public ConnectionFactory connectionFactoryLectura(final ActiveMQConnectionFactoryBuilder builder)
      throws JMSException {
    return builder.type(JmsConnectionFactoryType.NONXA).build();
  }

  @AmigaJmsConnectionFactory("broker-escritura")
  public ConnectionFactory connectionFactoryEscritura(final ActiveMQConnectionFactoryBuilder builder)
      throws JMSException {
    return builder.type(JmsConnectionFactoryType.NONXA).build();
  }

  @Bean
  @ConfigurationProperties(prefix = "amiga.data.jms.listener-container-factory.trabajo")
  public JmsListenerContainerFactory trabajoContainerFactoryListener(
      @Qualifier("connectionFactoryLectura") final ConnectionFactory cf,
      final JmsListenerContainerFactoryBuilder listenerContainerFactoryBuilder) {
    return listenerContainerFactoryBuilder.additionalCustomizers(new JmsListenerContainerFactoryCustom())
        .connectionFactory(cf)
        .sessionTransacted(false)
        .build();
  }

  @Bean
  @ConfigurationProperties(prefix = "amiga.data.jms.listener-container-factory.tarea")
  public JmsListenerContainerFactory tareaContainerFactoryListener(
      @Qualifier("connectionFactoryLectura") final ConnectionFactory cf,
      final JmsListenerContainerFactoryBuilder listenerContainerFactoryBuilder) {
    return listenerContainerFactoryBuilder.additionalCustomizers(new JmsListenerContainerFactoryCustom())
        .connectionFactory(cf)
        .sessionTransacted(false)
        .build();
  }

  @Bean
  @ConfigurationProperties(prefix = "amiga.data.jms.listener-container-factory.limpieza")
  public JmsListenerContainerFactory limpiezaContainerFactoryListener(
      @Qualifier("connectionFactoryLectura") final ConnectionFactory cf,
      final JmsListenerContainerFactoryBuilder listenerContainerFactoryBuilder) {
    return listenerContainerFactoryBuilder.additionalCustomizers(new JmsListenerContainerFactoryCustom())
        .connectionFactory(cf)
        .sessionTransacted(false)
        .build();
  }

  @Bean
  @ConfigurationProperties(prefix = "amiga.data.jms.listener-container-factory.programacion")
  public JmsListenerContainerFactory programacionContainerFactoryListener(
      @Qualifier("connectionFactoryLectura") final ConnectionFactory cf,
      final JmsListenerContainerFactoryBuilder listenerContainerFactoryBuilder) {
    return listenerContainerFactoryBuilder.additionalCustomizers(new JmsListenerContainerFactoryCustom())
        .connectionFactory(cf)
        .sessionTransacted(false)
        .build();
  }

  @Qualifier("trabajoJmsClient")
  @AmigaJmsClient("trabajo")
  public JmsClient trabajoJmsClient(final JmsClientBuilder builder,
      @Qualifier("connectionFactoryEscritura") final ConnectionFactory cf) throws JMSException {
    final JmsClient jmsClient = builder.additionalCustomizers(new JmsClientCustom()).build();
    jmsClient.setConnectionFactory(cf);
    return jmsClient;
  }

  @Qualifier("tareaJmsClient")
  @AmigaJmsClient("tarea")
  public JmsClient tareaJmsClient(final JmsClientBuilder builder,
      @Qualifier("connectionFactoryEscritura") final ConnectionFactory cf) throws JMSException {
    final JmsClient jmsClient = builder.additionalCustomizers(new JmsClientCustom()).build();
    jmsClient.setConnectionFactory(cf);
    return jmsClient;
  }

  @Qualifier("limpiezaJmsClient")
  @AmigaJmsClient("limpieza")
  public JmsClient limpiezaJmsClient(final JmsClientBuilder builder,
      @Qualifier("connectionFactoryEscritura") final ConnectionFactory cf) throws JMSException {
    final JmsClient jmsClient = builder.additionalCustomizers(new JmsClientCustom()).build();
    jmsClient.setConnectionFactory(cf);
    return jmsClient;
  }

  @Qualifier("programacionJmsClient")
  @AmigaJmsClient("programacion")
  public JmsClient programacionJmsClient(final JmsClientBuilder builder,
      @Qualifier("connectionFactoryEscritura") final ConnectionFactory cf) throws JMSException {
    final JmsClient jmsClient = builder.additionalCustomizers(new JmsClientCustom()).build();
    jmsClient.setConnectionFactory(cf);
    return jmsClient;
  }

  @Bean
  public JmsConnectionFactoryGlobalCustomizer globalCustomizer() {
    return new JmsConnectionFactoryGlobalCustom();
  }

}
