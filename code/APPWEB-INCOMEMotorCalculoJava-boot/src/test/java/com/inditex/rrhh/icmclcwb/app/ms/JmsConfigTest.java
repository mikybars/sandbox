package com.inditex.rrhh.icmclcwb.app.ms;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.inditex.amigafwk.data.jms.ArtemisConnectionFactoryBuilder;
import com.inditex.amigafwk.data.jms.JmsConnectionFactoryBuilder;
import com.inditex.amigafwk.service.jms.JmsListenerContainerFactoryBuilder;
import com.inditex.rrhh.icmclcwb.config.app.ms.JmsConfig;
import com.inditex.rrhh.icmclcwb.config.app.ms.JmsListenerContainerFactoryCustom;

import jakarta.jms.ConnectionFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith({SpringExtension.class})
public class JmsConfigTest {

  @Mock
  private ArtemisConnectionFactoryBuilder artemisConnectionFactoryBuilderMock;

  @Mock
  private JmsListenerContainerFactoryBuilder jmsListenerContainerFactoryBuilderMock;

  @Mock
  private ConnectionFactory connectionFactoryMock;

  @Mock
  private JmsConnectionFactoryBuilder jmsConnectionFactoryBuilder;

  @InjectMocks
  private JmsConfig jmsConfig;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
    void trabajoContainerFactoryListenerShouldConfigureCorrectly() {
        when(this.jmsListenerContainerFactoryBuilderMock.additionalCustomizers(any(JmsListenerContainerFactoryCustom.class)))
            .thenReturn(this.jmsListenerContainerFactoryBuilderMock);
        when(this.jmsListenerContainerFactoryBuilderMock.connectionFactory(this.connectionFactoryMock))
            .thenReturn(this.jmsListenerContainerFactoryBuilderMock);
        when(this.jmsListenerContainerFactoryBuilderMock.sessionTransacted(false))
            .thenReturn(this.jmsListenerContainerFactoryBuilderMock);
        when(this.jmsListenerContainerFactoryBuilderMock.build()).thenReturn(mock(JmsListenerContainerFactory.class));

        final JmsListenerContainerFactory factory = this.jmsConfig.trabajoContainerFactoryListener(this.connectionFactoryMock,
            this.jmsListenerContainerFactoryBuilderMock);
        assertNotNull(factory);
        verify(this.jmsListenerContainerFactoryBuilderMock, times(1)).build();
    }

  @Test
    void tareaContainerFactoryListenerShouldConfigureCorrectly() {
        when(this.jmsListenerContainerFactoryBuilderMock.additionalCustomizers(any(JmsListenerContainerFactoryCustom.class)))
            .thenReturn(this.jmsListenerContainerFactoryBuilderMock);
        when(this.jmsListenerContainerFactoryBuilderMock.connectionFactory(this.connectionFactoryMock))
            .thenReturn(this.jmsListenerContainerFactoryBuilderMock);
        when(this.jmsListenerContainerFactoryBuilderMock.sessionTransacted(false))
            .thenReturn(this.jmsListenerContainerFactoryBuilderMock);
        when(this.jmsListenerContainerFactoryBuilderMock.build()).thenReturn(mock(JmsListenerContainerFactory.class));

        final JmsListenerContainerFactory factory = this.jmsConfig.tareaContainerFactoryListener(this.connectionFactoryMock,
            this.jmsListenerContainerFactoryBuilderMock);
        assertNotNull(factory);
        verify(this.jmsListenerContainerFactoryBuilderMock, times(1)).build();
    }

}
