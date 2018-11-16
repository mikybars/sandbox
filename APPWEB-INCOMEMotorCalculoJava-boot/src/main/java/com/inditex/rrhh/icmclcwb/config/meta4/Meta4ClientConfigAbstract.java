package com.inditex.rrhh.icmclcwb.config.meta4;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;
import javax.xml.ws.BindingProvider;

import org.apache.cxf.configuration.jsse.TLSClientParameters;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.transport.http.HTTPConduit;
import org.apache.cxf.transports.http.configuration.HTTPClientPolicy;

public abstract class Meta4ClientConfigAbstract<T> {

	protected String server;

	protected abstract void setServer(String server);

	protected abstract T init();

	protected T build(Class<T> classType) {
		JaxWsProxyFactoryBean pfb = new JaxWsProxyFactoryBean();
		pfb.setServiceClass(classType);
		pfb.setAddress(server);
		@SuppressWarnings("unchecked")
		T result = (T) pfb.create();

		((BindingProvider) result).getRequestContext().put(BindingProvider.SESSION_MAINTAIN_PROPERTY, Boolean.TRUE);
		// END_POINT_SERVICIO_CUESTIONARIO=http://develop-persarew.axdesocp1.central.inditex.grp/services/GLB_WS_CUESTIONARIO_DINAMICO
		((BindingProvider) result).getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, server);

		Client client = ClientProxy.getClient(result);
		if (client != null) {
			HTTPConduit conduit = (HTTPConduit) client.getConduit();

			HTTPClientPolicy httpClientPolicy = new HTTPClientPolicy();
			httpClientPolicy.setContentType("text/xml;charset=UTF-8");
			httpClientPolicy.setAllowChunking(false);
			// httpClientPolicy.setConnectionTimeout(30000L);
			// httpClientPolicy.setReceiveTimeout(60000L);
			// httpClientPolicy.setConnection(ConnectionType.CLOSE);
			conduit.setClient(httpClientPolicy);

			TLSClientParameters tlsClientParameters = new TLSClientParameters();
			SSLSocketFactory sslSF = HttpsURLConnection.getDefaultSSLSocketFactory();
			tlsClientParameters.setSSLSocketFactory(sslSF);
			conduit.setTlsClientParameters(tlsClientParameters);

			// client.getEndpoint().put(StaxOutInterceptor.FORCE_START_DOCUMENT,
			// Boolean.TRUE);
			
			client.getInInterceptors().add(new LoggingInInterceptor());
			client.getOutInterceptors().add(new LoggingOutInterceptor());
		}
		return result;
	}

}