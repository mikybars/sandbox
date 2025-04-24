package com.inditex.rrhh.icmclcwb.app.ms;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.inditex.amigafwk.data.jms.ArtemisConnectionFactoryBuilder;
import com.inditex.amigafwk.data.jms.JmsClient;
import com.inditex.amigafwk.data.jms.JmsClientBuilder;
import com.inditex.amigafwk.data.jms.JmsConnectionFactoryType;
import com.inditex.amigafwk.service.jms.JmsListenerContainerFactoryBuilder;
import com.inditex.rrhh.icmclcwb.config.app.ms.JmsConfig;

import jakarta.jms.ConnectionFactory;
import jakarta.jms.JMSException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class JmsConfigTest {

  @Mock
  private ArtemisConnectionFactoryBuilder builderCF;

  @Mock
  private JmsListenerContainerFactoryBuilder listenerContainerFactoryBuilder;

  @Mock
  private JmsClientBuilder jmsClientBuilder;

  @InjectMocks
  private JmsConfig jmsConfig;

  @BeforeEach
  public void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  void connectionFactoryLecturaShouldReturnNonXAConnectionFactory() throws JMSException {
    when(this.builderCF.type(JmsConnectionFactoryType.NONXA)).thenReturn(this.builderCF);
    when(this.builderCF.build()).thenReturn(mock(ConnectionFactory.class));

    final ConnectionFactory cf = this.jmsConfig.connectionFactoryLectura(this.builderCF);

    assertNotNull(cf);
    verify(this.builderCF).type(JmsConnectionFactoryType.NONXA);
    verify(this.builderCF).build();
  }

  @Test
  void connectionFactoryEscrituraShouldReturnNonXAConnectionFactory() throws JMSException {
    when(this.builderCF.type(JmsConnectionFactoryType.NONXA)).thenReturn(this.builderCF);
    when(this.builderCF.build()).thenReturn(mock(ConnectionFactory.class));

    final ConnectionFactory cf = this.jmsConfig.connectionFactoryEscritura(this.builderCF);

    assertNotNull(cf);
    verify(this.builderCF).type(JmsConnectionFactoryType.NONXA);
    verify(this.builderCF).build();
  }

  @Test
  void trabajoJmsClientShouldReturnConfiguredClient() throws JMSException {
    final ConnectionFactory cf = mock(ConnectionFactory.class);
    final JmsClient expectedClient = mock(JmsClient.class);
    when(this.jmsClientBuilder.additionalCustomizers(any())).thenReturn(this.jmsClientBuilder);
    when(this.jmsClientBuilder.build()).thenReturn(expectedClient);

    final JmsClient client = this.jmsConfig.trabajoJmsClient(this.jmsClientBuilder, cf);

    assertNotNull(client);
    assertEquals(expectedClient, client);
    verify(expectedClient).setConnectionFactory(cf);
  }

}
