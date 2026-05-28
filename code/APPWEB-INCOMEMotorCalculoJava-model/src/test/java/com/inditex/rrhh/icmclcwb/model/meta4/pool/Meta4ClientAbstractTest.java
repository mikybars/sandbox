package com.inditex.rrhh.icmclcwb.model.meta4.pool;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mockConstruction;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.inditex.rrhh.icmclcwb.model.app.util.CxfUtils;

import jakarta.xml.ws.BindingProvider;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.interceptor.Interceptor;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.message.Message;
import org.apache.cxf.transport.http.HTTPConduit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockedConstruction;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientManager;

@ExtendWith(MockitoExtension.class)
class Meta4ClientAbstractTest {

  private TestableClient client;

  @Mock
  private OAuth2AuthorizedClientManager oauth2AuthorizedClientManager;

  @Mock
  private BindingProvider proxy;

  @Mock
  private HTTPConduit httpConduit;

  @Mock
  private Client cxfClient;

  @BeforeEach
  void beforeEach() {
    client = new TestableClient();
    client.connectTimeout = 5000L;
    client.receiveTimeout = 10000L;
    when(proxy.getRequestContext()).thenReturn(new HashMap<>());
  }

  @Nested
  class RegisterOAuth2BearerInterceptor {

    @Test
    void whenOauthManagerIsNullExpectNoInterceptorRegistered() {
      client.server = "https://preint-api.inditex.com/icmclcws/service";
      client.oauthUrlPrefix = "https://preint-api.inditex.com/icmclcws";
      client.oauthClientName = "client-income";

      try (MockedConstruction<JaxWsProxyFactoryBean> ignored = mockConstruction(
          JaxWsProxyFactoryBean.class,
          (mock, context) -> {
            when(mock.getFeatures()).thenReturn(new ArrayList<>());
            when(mock.create()).thenReturn(proxy);
          });
          MockedStatic<CxfUtils> cxfMock = mockStatic(CxfUtils.class);
          MockedStatic<ClientProxy> clientProxyMock = mockStatic(ClientProxy.class)) {
        cxfMock.when(() -> CxfUtils.getHttpConduit(proxy)).thenReturn(httpConduit);

        client.build(BindingProvider.class);

        clientProxyMock.verify(() -> ClientProxy.getClient(proxy), never());
      }
    }

    @Test
    void whenServerIsNullExpectNoInterceptorRegistered() {
      client.oauth2AuthorizedClientManager = oauth2AuthorizedClientManager;
      client.oauthUrlPrefix = "https://preint-api.inditex.com/icmclcws";
      client.oauthClientName = "client-income";

      try (MockedConstruction<JaxWsProxyFactoryBean> ignored = mockConstruction(
          JaxWsProxyFactoryBean.class,
          (mock, context) -> {
            when(mock.getFeatures()).thenReturn(new ArrayList<>());
            when(mock.create()).thenReturn(proxy);
          });
          MockedStatic<CxfUtils> cxfMock = mockStatic(CxfUtils.class);
          MockedStatic<ClientProxy> clientProxyMock = mockStatic(ClientProxy.class)) {
        cxfMock.when(() -> CxfUtils.getHttpConduit(proxy)).thenReturn(httpConduit);

        client.build(BindingProvider.class);

        clientProxyMock.verify(() -> ClientProxy.getClient(proxy), never());
      }
    }

    @Test
    void whenOauthUrlPrefixIsNullExpectNoInterceptorRegistered() {
      client.oauth2AuthorizedClientManager = oauth2AuthorizedClientManager;
      client.server = "https://preint-api.inditex.com/icmclcws/service";
      client.oauthUrlPrefix = null;
      client.oauthClientName = "client-income";

      try (MockedConstruction<JaxWsProxyFactoryBean> ignored = mockConstruction(
          JaxWsProxyFactoryBean.class,
          (mock, context) -> {
            when(mock.getFeatures()).thenReturn(new ArrayList<>());
            when(mock.create()).thenReturn(proxy);
          });
          MockedStatic<CxfUtils> cxfMock = mockStatic(CxfUtils.class);
          MockedStatic<ClientProxy> clientProxyMock = mockStatic(ClientProxy.class)) {
        cxfMock.when(() -> CxfUtils.getHttpConduit(proxy)).thenReturn(httpConduit);

        client.build(BindingProvider.class);

        clientProxyMock.verify(() -> ClientProxy.getClient(proxy), never());
      }
    }

    @Test
    void whenOauthUrlPrefixIsEmptyExpectNoInterceptorRegistered() {
      client.oauth2AuthorizedClientManager = oauth2AuthorizedClientManager;
      client.server = "https://preint-api.inditex.com/icmclcws/service";
      client.oauthUrlPrefix = "";
      client.oauthClientName = "client-income";

      try (MockedConstruction<JaxWsProxyFactoryBean> ignored = mockConstruction(
          JaxWsProxyFactoryBean.class,
          (mock, context) -> {
            when(mock.getFeatures()).thenReturn(new ArrayList<>());
            when(mock.create()).thenReturn(proxy);
          });
          MockedStatic<CxfUtils> cxfMock = mockStatic(CxfUtils.class);
          MockedStatic<ClientProxy> clientProxyMock = mockStatic(ClientProxy.class)) {
        cxfMock.when(() -> CxfUtils.getHttpConduit(proxy)).thenReturn(httpConduit);

        client.build(BindingProvider.class);

        clientProxyMock.verify(() -> ClientProxy.getClient(proxy), never());
      }
    }

    @Test
    void whenServerDoesNotMatchPrefixExpectNoInterceptorRegistered() {
      client.oauth2AuthorizedClientManager = oauth2AuthorizedClientManager;
      client.server = "https://other-api.inditex.com/service";
      client.oauthUrlPrefix = "https://preint-api.inditex.com/icmclcws";
      client.oauthClientName = "client-income";

      try (MockedConstruction<JaxWsProxyFactoryBean> ignored = mockConstruction(
          JaxWsProxyFactoryBean.class,
          (mock, context) -> {
            when(mock.getFeatures()).thenReturn(new ArrayList<>());
            when(mock.create()).thenReturn(proxy);
          });
          MockedStatic<CxfUtils> cxfMock = mockStatic(CxfUtils.class);
          MockedStatic<ClientProxy> clientProxyMock = mockStatic(ClientProxy.class)) {
        cxfMock.when(() -> CxfUtils.getHttpConduit(proxy)).thenReturn(httpConduit);

        client.build(BindingProvider.class);

        clientProxyMock.verify(() -> ClientProxy.getClient(proxy), never());
      }
    }

    @Test
    void whenServerMatchesPrefixExpectInterceptorRegistered() {
      client.oauth2AuthorizedClientManager = oauth2AuthorizedClientManager;
      client.server = "https://preint-api.inditex.com/icmclcws/service";
      client.oauthUrlPrefix = "https://preint-api.inditex.com/icmclcws";
      client.oauthClientName = "client-income";
      final List<Interceptor<? extends Message>> outInterceptors = new ArrayList<>();

      try (MockedConstruction<JaxWsProxyFactoryBean> ignored = mockConstruction(
          JaxWsProxyFactoryBean.class,
          (mock, context) -> {
            when(mock.getFeatures()).thenReturn(new ArrayList<>());
            when(mock.create()).thenReturn(proxy);
          });
          MockedStatic<CxfUtils> cxfMock = mockStatic(CxfUtils.class);
          MockedStatic<ClientProxy> clientProxyMock = mockStatic(ClientProxy.class)) {
        cxfMock.when(() -> CxfUtils.getHttpConduit(proxy)).thenReturn(httpConduit);
        clientProxyMock.when(() -> ClientProxy.getClient(proxy)).thenReturn(cxfClient);
        doReturn(outInterceptors).when(cxfClient).getOutInterceptors();

        client.build(BindingProvider.class);

        assertThat(outInterceptors).hasSize(1);
        assertThat(outInterceptors.get(0)).isInstanceOf(Meta4OAuth2BearerInterceptor.class);
      }
    }
  }

  static class TestableClient extends Meta4ClientAbstract<BindingProvider> {

    @Override
    protected void setServer(final String server) {
      this.server = server;
    }

    @Override
    protected Meta4ClientAbstract<BindingProvider> factory() {
      return this;
    }
  }
}
