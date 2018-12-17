package com.inditex.rrhh.icmclcwb.model.meta4.pool;

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
import org.apache.cxf.transports.http.configuration.ConnectionType;
import org.apache.cxf.transports.http.configuration.HTTPClientPolicy;
import org.springframework.beans.factory.annotation.Value;

public abstract class Meta4ClientAbstract<T> {

    public String server;

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
        T result = (T) pfb.create();

        ((BindingProvider) result).getRequestContext().put(BindingProvider.SESSION_MAINTAIN_PROPERTY, Boolean.TRUE);
        ((BindingProvider) result).getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, server);

        Client client = ClientProxy.getClient(result);
        if (client != null) {
            HTTPConduit httpConduit = (HTTPConduit) client.getConduit();

            HTTPClientPolicy httpClientPolicy = new HTTPClientPolicy();
            httpClientPolicy.setContentType("text/xml;charset=UTF-8");
            httpClientPolicy.setAllowChunking(false);
            httpClientPolicy.setConnectionTimeout(connectTimeout);
            httpClientPolicy.setReceiveTimeout(receiveTimeout);
            httpClientPolicy.setConnection(ConnectionType.KEEP_ALIVE);
            // Apache CXF uses HTTPUrlConnection internally and relies on java system
            // properties to configure client connection settings
            // http.keepAlive (default: true)
            // http.maxConnections (default: 5)

            httpConduit.setClient(httpClientPolicy);

            SSLSocketFactory sslSF = HttpsURLConnection.getDefaultSSLSocketFactory();

            TLSClientParameters tlsClientParameters = new TLSClientParameters();
            tlsClientParameters.setSSLSocketFactory(sslSF);

            httpConduit.setTlsClientParameters(tlsClientParameters);

            // TODO Pendiente revisar propiedad
            // client.getEndpoint().put(StaxOutInterceptor.FORCE_START_DOCUMENT,
            // Boolean.TRUE);

            // TODO Pendiente ajustar trazas
            LoggingInInterceptor loggingInInterceptor = new LoggingInInterceptor();
            loggingInInterceptor.setPrettyLogging(Boolean.TRUE);
            loggingInInterceptor.setLimit(-1);
            client.getInInterceptors().add(loggingInInterceptor);

            // TODO Pendiente ajustar trazas
            LoggingOutInterceptor loggingOutInterceptor = new LoggingOutInterceptor();
            loggingOutInterceptor.setPrettyLogging(Boolean.TRUE);
            loggingOutInterceptor.setLimit(-1);
            client.getOutInterceptors().add(loggingOutInterceptor);

        }
        return result;
    }

}