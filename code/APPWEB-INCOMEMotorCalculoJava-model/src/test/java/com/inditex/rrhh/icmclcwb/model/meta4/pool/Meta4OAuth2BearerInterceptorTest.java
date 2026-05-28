package com.inditex.rrhh.icmclcwb.model.meta4.pool;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.cxf.message.Message;
import org.apache.cxf.phase.Phase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.oauth2.client.OAuth2AuthorizeRequest;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientManager;
import org.springframework.security.oauth2.core.OAuth2AccessToken;

@ExtendWith(MockitoExtension.class)
class Meta4OAuth2BearerInterceptorTest {

  private Meta4OAuth2BearerInterceptor interceptor;

  @Mock
  private OAuth2AuthorizedClientManager authorizedClientManager;

  private static final String CLIENT_NAME = "test-client";

  @BeforeEach
  void beforeEach() {
    interceptor = new Meta4OAuth2BearerInterceptor(authorizedClientManager, CLIENT_NAME);
  }

  @Nested
  class Constructor {

    @Test
    void whenCreatedExpectPhasePreProtocol() {
      assertThat(interceptor.getPhase()).isEqualTo(Phase.PRE_PROTOCOL);
    }
  }

  @Nested
  class HandleMessage {

    @Mock
    private Message message;

    @Test
    void whenManagerIsNullExpectNoAuthorizationHeader() {
      final Meta4OAuth2BearerInterceptor nullManagerInterceptor =
          new Meta4OAuth2BearerInterceptor(null, CLIENT_NAME);

      nullManagerInterceptor.handleMessage(message);

      verify(message, never()).get(Message.PROTOCOL_HEADERS);
    }

    @Test
    void whenAuthorizedClientIsNullExpectNoAuthorizationHeader() {
      when(authorizedClientManager.authorize(any(OAuth2AuthorizeRequest.class))).thenReturn(null);

      interceptor.handleMessage(message);

      verify(message, never()).get(Message.PROTOCOL_HEADERS);
    }

    @Test
    void whenAccessTokenIsNullExpectNoAuthorizationHeader() {
      final OAuth2AuthorizedClient authorizedClient = mock(OAuth2AuthorizedClient.class);
      when(authorizedClientManager.authorize(any(OAuth2AuthorizeRequest.class)))
          .thenReturn(authorizedClient);
      when(authorizedClient.getAccessToken()).thenReturn(null);

      interceptor.handleMessage(message);

      verify(message, never()).get(Message.PROTOCOL_HEADERS);
    }

    @Test
    @SuppressWarnings("unchecked")
    void whenValidTokenAndNoExistingHeadersExpectNewHeadersWithBearer() {
      final OAuth2AuthorizedClient authorizedClient = mock(OAuth2AuthorizedClient.class);
      final OAuth2AccessToken accessToken = mock(OAuth2AccessToken.class);
      when(authorizedClientManager.authorize(any(OAuth2AuthorizeRequest.class)))
          .thenReturn(authorizedClient);
      when(authorizedClient.getAccessToken()).thenReturn(accessToken);
      when(accessToken.getTokenValue()).thenReturn("test-token-value");

      interceptor.handleMessage(message);

      final ArgumentCaptor<Object> headersCaptor = ArgumentCaptor.forClass(Object.class);
      verify(message).put(eq(Message.PROTOCOL_HEADERS), headersCaptor.capture());
      final Map<String, List<String>> headers =
          (Map<String, List<String>>) headersCaptor.getValue();
      assertThat(headers).containsKey("Authorization");
      assertThat(headers.get("Authorization")).containsExactly("Bearer test-token-value");
    }

    @Test
    void whenValidTokenAndExistingHeadersExpectBearerAdded() {
      final OAuth2AuthorizedClient authorizedClient = mock(OAuth2AuthorizedClient.class);
      final OAuth2AccessToken accessToken = mock(OAuth2AccessToken.class);
      when(authorizedClientManager.authorize(any(OAuth2AuthorizeRequest.class)))
          .thenReturn(authorizedClient);
      when(authorizedClient.getAccessToken()).thenReturn(accessToken);
      when(accessToken.getTokenValue()).thenReturn("test-token-value");
      final Map<String, List<String>> existingHeaders = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
      existingHeaders.put("Content-Type", new ArrayList<>(List.of("text/xml")));
      when(message.get(Message.PROTOCOL_HEADERS)).thenReturn(existingHeaders);

      interceptor.handleMessage(message);

      verify(message, never()).put(eq(Message.PROTOCOL_HEADERS), any());
      assertThat(existingHeaders).containsKey("Authorization");
      assertThat(existingHeaders.get("Authorization")).containsExactly("Bearer test-token-value");
    }
  }
}
