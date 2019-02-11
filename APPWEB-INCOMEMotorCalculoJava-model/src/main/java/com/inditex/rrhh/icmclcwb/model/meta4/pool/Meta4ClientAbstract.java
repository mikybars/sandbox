package com.inditex.rrhh.icmclcwb.model.meta4.pool;

import javax.net.ssl.HttpsURLConnection;
import javax.xml.ws.BindingProvider;

import org.apache.cxf.configuration.jsse.TLSClientParameters;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.ext.logging.LoggingFeature;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.transport.http.HTTPConduit;
import org.apache.cxf.transports.http.configuration.ConnectionType;
import org.apache.cxf.transports.http.configuration.HTTPClientPolicy;
import org.springframework.beans.factory.annotation.Value;

import com.inditex.rrhh.icmclcwb.api.app.util.CxfConstants;

public abstract class Meta4ClientAbstract<T> {

	protected String server;

	@Value("${app.envars.meta4.config.timeout.connectTimeout}")
	public long connectTimeout;

	@Value("${app.envars.meta4.config.timeout.receiveTimeout}")
	public long receiveTimeout;

	protected abstract void setServer(String server);

	protected abstract Meta4ClientAbstract<T> factory();

	public T build(Class<T> classType) {
		JaxWsProxyFactoryBean pfb = new JaxWsProxyFactoryBean();
		pfb.setServiceClass(classType);
		pfb.setAddress(server);
		LoggingFeature loggingFeature = new LoggingFeature();
        loggingFeature.setLimit(-1);
        loggingFeature.setPrettyLogging(true);
        pfb.getFeatures().add(loggingFeature);
		
		T result = (T) pfb.create();

		((BindingProvider) result).getRequestContext().put(BindingProvider.SESSION_MAINTAIN_PROPERTY, Boolean.TRUE);
		((BindingProvider) result).getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, server);

		Client client = ClientProxy.getClient(result);

		HTTPConduit httpConduit = (HTTPConduit) client.getConduit();

		HTTPClientPolicy httpClientPolicy = new HTTPClientPolicy();
		httpClientPolicy.setContentType(CxfConstants.CONTENT_TYPE);
		httpClientPolicy.setAllowChunking(false);
		httpClientPolicy.setConnectionTimeout(connectTimeout);
		httpClientPolicy.setReceiveTimeout(receiveTimeout);
		httpClientPolicy.setConnection(ConnectionType.KEEP_ALIVE);
		httpConduit.setClient(httpClientPolicy);

		TLSClientParameters tlsClientParameters = new TLSClientParameters();
		tlsClientParameters.setSSLSocketFactory(HttpsURLConnection.getDefaultSSLSocketFactory());
		httpConduit.setTlsClientParameters(tlsClientParameters);

		return result;
	}

}