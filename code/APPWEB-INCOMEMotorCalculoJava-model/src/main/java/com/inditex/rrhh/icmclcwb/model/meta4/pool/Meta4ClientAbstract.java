package com.inditex.rrhh.icmclcwb.model.meta4.pool;

import java.io.Serializable;

import com.inditex.rrhh.icmclcwb.api.app.util.CxfConstants;
import com.inditex.rrhh.icmclcwb.model.app.util.CxfUtils;

import jakarta.xml.ws.BindingProvider;
import javax.net.ssl.HttpsURLConnection;
import org.apache.cxf.configuration.jsse.TLSClientParameters;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.ext.logging.LoggingFeature;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.transport.http.HTTPConduit;
import org.apache.cxf.transports.http.configuration.ConnectionType;
import org.apache.cxf.transports.http.configuration.HTTPClientPolicy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientManager;

public abstract class Meta4ClientAbstract<T> implements Serializable {

  private static final long serialVersionUID = -4381434626162543493L;

  private static final Logger LOG = LoggerFactory.getLogger(Meta4ClientAbstract.class);

  @Value("${app.envars.meta4.config.timeout.connectTimeout}")
  public long connectTimeout;

  @Value("${app.envars.meta4.config.timeout.receiveTimeout}")
  public long receiveTimeout;

  @Value("${app.envars.meta4.oauth.url-prefix:https://preint-api.inditex.com/icmclcws}")
  protected String oauthUrlPrefix;

  @Value("${app.envars.meta4.oauth.client-name:client-income}")
  protected String oauthClientName;

  @Autowired(required = false)
  protected transient OAuth2AuthorizedClientManager oauth2AuthorizedClientManager;

  protected String server;

  protected abstract void setServer(String server);

  protected abstract Meta4ClientAbstract<T> factory();

  public T build(final Class<T> classType) {
    final JaxWsProxyFactoryBean pfb = new JaxWsProxyFactoryBean();
    pfb.setServiceClass(classType);
    pfb.setAddress(this.server);
    final LoggingFeature loggingFeature = new LoggingFeature();
    loggingFeature.setLimit(-1);
    loggingFeature.setPrettyLogging(true);
    pfb.getFeatures().add(loggingFeature);

    final T result = classType.cast(pfb.create());

    ((BindingProvider) result).getRequestContext().put(BindingProvider.SESSION_MAINTAIN_PROPERTY, Boolean.TRUE);
    ((BindingProvider) result).getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, this.server);

    final HTTPConduit httpConduit = CxfUtils.getHttpConduit(result);

    final HTTPClientPolicy httpClientPolicy = new HTTPClientPolicy();
    httpClientPolicy.setContentType(CxfConstants.CONTENT_TYPE);
    httpClientPolicy.setAllowChunking(false);
    httpClientPolicy.setConnectionTimeout(this.connectTimeout);
    httpClientPolicy.setReceiveTimeout(this.receiveTimeout);
    httpClientPolicy.setConnection(ConnectionType.KEEP_ALIVE);
    httpConduit.setClient(httpClientPolicy);

    final TLSClientParameters tlsClientParameters = new TLSClientParameters();
    tlsClientParameters.setSSLSocketFactory(HttpsURLConnection.getDefaultSSLSocketFactory());
    httpConduit.setTlsClientParameters(tlsClientParameters);

    registerOAuth2BearerInterceptor(result);

    return result;
  }

  private void registerOAuth2BearerInterceptor(final T proxy) {
    if (oauth2AuthorizedClientManager == null) {
      return;
    }
    if (this.server == null || oauthUrlPrefix == null || oauthUrlPrefix.isEmpty()) {
      return;
    }
    if (!this.server.startsWith(oauthUrlPrefix)) {
      return;
    }
    final Client client = ClientProxy.getClient(proxy);
    client.getOutInterceptors().add(
        new Meta4OAuth2BearerInterceptor(oauth2AuthorizedClientManager, oauthClientName));
    LOG.debug(
        "OAuth2 bearer interceptor registered for Meta4 client (server='{}', client-name='{}')",
        this.server,
        this.oauthClientName);
  }

}
