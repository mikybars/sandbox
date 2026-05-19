package com.inditex.rrhh.icmclcwb.model.meta4.pool;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.message.Message;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.oauth2.client.OAuth2AuthorizeRequest;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientManager;

/**
 * CXF out-interceptor that adds an OAuth2 client-credentials bearer token to the outgoing SOAP request when the endpoint URL matches a
 * configured prefix.
 */
public class Meta4OAuth2BearerInterceptor extends AbstractPhaseInterceptor<Message> {

  private static final Logger LOG = LoggerFactory.getLogger(Meta4OAuth2BearerInterceptor.class);

  private static final String AUTHORIZATION_HEADER = "Authorization";

  private static final String BEARER_PREFIX = "Bearer ";

  private final OAuth2AuthorizedClientManager authorizedClientManager;

  private final String clientName;

  public Meta4OAuth2BearerInterceptor(
      final OAuth2AuthorizedClientManager authorizedClientManager, final String clientName) {
    super(Phase.PRE_PROTOCOL);
    this.authorizedClientManager = authorizedClientManager;
    this.clientName = clientName;
  }

  @Override
  public void handleMessage(final Message message) throws Fault {
    if (authorizedClientManager == null) {
      LOG.debug("OAuth2AuthorizedClientManager not available; skipping bearer injection");
      return;
    }

    final OAuth2AuthorizeRequest authorizeRequest =
        OAuth2AuthorizeRequest.withClientRegistrationId(clientName).principal(clientName).build();
    final OAuth2AuthorizedClient authorizedClient = authorizedClientManager.authorize(authorizeRequest);

    if (authorizedClient == null || authorizedClient.getAccessToken() == null) {
      LOG.warn("Could not obtain OAuth2 access token for client '{}'", clientName);
      return;
    }

    final String token = authorizedClient.getAccessToken().getTokenValue();

    @SuppressWarnings("unchecked")
    Map<String, List<String>> headers = (Map<String, List<String>>) message.get(Message.PROTOCOL_HEADERS);
    if (headers == null) {
      headers = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
      message.put(Message.PROTOCOL_HEADERS, headers);
    }
    final List<String> authValues = new ArrayList<>(1);
    authValues.add(BEARER_PREFIX + token);
    headers.put(AUTHORIZATION_HEADER, authValues);
  }
}
