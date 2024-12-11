package com.inditex.rrhh.icmclcwb.config.app.ms;

import com.inditex.amigafwk.data.jms.ArtemisConnectionFactoryBuilder;
import com.inditex.amigafwk.data.jms.JmsClient;
import com.inditex.amigafwk.data.jms.JmsClientBuilder;
import com.inditex.amigafwk.data.jms.JmsConnectionFactoryGlobalCustomizer;
import com.inditex.amigafwk.data.jms.annotation.AmigaJmsClient;
import com.inditex.amigafwk.data.jms.annotation.AmigaJmsConnectionFactory;
import com.inditex.amigafwk.service.jms.JmsListenerContainerFactoryBuilder;
import com.inditex.amigafwk.service.jms.annotation.AmigaJmsListenerContainerFactory;

import jakarta.jms.ConnectionFactory;
import jakarta.jms.JMSException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jms.config.JmsListenerContainerFactory;

@Configuration
public class JmsConfig {

  @Autowired
  private ArtemisConnectionFactoryBuilder builderCF;

  @Primary
  @AmigaJmsConnectionFactory("broker-lectura")
  public ConnectionFactory connectionFactoryLectura(ArtemisConnectionFactoryBuilder builderCF) throws JMSException {
    return builderCF.build();
  }

  @AmigaJmsConnectionFactory("broker-escritura")
  public ConnectionFactory connectionFactoryEscritura(ArtemisConnectionFactoryBuilder builderCF) throws JMSException {
    return builderCF.build();
  }

  @AmigaJmsListenerContainerFactory("trabajo")
  public JmsListenerContainerFactory trabajoContainerFactoryListener(
      @Qualifier("connectionFactoryLectura") final ConnectionFactory cf,
      final JmsListenerContainerFactoryBuilder listenerContainerFactoryBuilder) {
    return listenerContainerFactoryBuilder.additionalCustomizers(new JmsListenerContainerFactoryCustom())
        .connectionFactory(cf)
        .sessionTransacted(false)
        .build();
  }

  @AmigaJmsListenerContainerFactory("tarea")
  public JmsListenerContainerFactory tareaContainerFactoryListener(
      @Qualifier("connectionFactoryLectura") final ConnectionFactory cf,
      final JmsListenerContainerFactoryBuilder listenerContainerFactoryBuilder) {
    return listenerContainerFactoryBuilder.additionalCustomizers(new JmsListenerContainerFactoryCustom())
        .connectionFactory(cf)
        .sessionTransacted(false)
        .build();
  }

  @AmigaJmsListenerContainerFactory("limpieza")
  public JmsListenerContainerFactory limpiezaContainerFactoryListener(
      @Qualifier("connectionFactoryLectura") final ConnectionFactory cf,
      final JmsListenerContainerFactoryBuilder listenerContainerFactoryBuilder) {
    return listenerContainerFactoryBuilder.additionalCustomizers(new JmsListenerContainerFactoryCustom())
        .connectionFactory(cf)
        .sessionTransacted(false)
        .build();
  }

  @AmigaJmsListenerContainerFactory("programacion")
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
