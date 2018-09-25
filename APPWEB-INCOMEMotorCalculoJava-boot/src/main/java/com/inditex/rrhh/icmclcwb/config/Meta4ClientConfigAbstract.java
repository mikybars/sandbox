package com.inditex.rrhh.icmclcwb.config;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;
import javax.xml.ws.BindingProvider;

import org.apache.cxf.configuration.jsse.TLSClientParameters;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.interceptor.StaxOutInterceptor;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.transport.http.HTTPConduit;
import org.apache.cxf.transports.http.configuration.HTTPClientPolicy;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class Meta4ClientConfigAbstract<T> {

	@Autowired
    private Logger LOG;

	protected String server;

	protected abstract void setServer(String server);
	
	protected abstract T init();

	protected T build(Class<T> classType) {
		LOG.info("INICIO build()");
		JaxWsProxyFactoryBean pfb = new JaxWsProxyFactoryBean();
		pfb.setServiceClass(classType);
		pfb.setAddress(server);
		@SuppressWarnings("unchecked")
		T result = (T) pfb.create();
		
		((BindingProvider) result).getRequestContext().put(BindingProvider.SESSION_MAINTAIN_PROPERTY, Boolean.TRUE);
		
		Client client = ClientProxy.getClient(result);
		if (client != null) {
			HTTPConduit conduit = (HTTPConduit) client.getConduit();
			
			HTTPClientPolicy policy = new HTTPClientPolicy();
			policy.setContentType("text/xml;charset=UTF-8");
			policy.setAllowChunking(false);
			conduit.setClient(policy);
			
			TLSClientParameters tlsClientParameters = new TLSClientParameters();
			SSLSocketFactory sslSF = HttpsURLConnection.getDefaultSSLSocketFactory();
			tlsClientParameters.setSSLSocketFactory(sslSF);
			conduit.setTlsClientParameters(tlsClientParameters);
			
			client.getEndpoint().put(StaxOutInterceptor.FORCE_START_DOCUMENT, Boolean.TRUE);
		}
		LOG.info("FIN build()");
		return result;
	}

}