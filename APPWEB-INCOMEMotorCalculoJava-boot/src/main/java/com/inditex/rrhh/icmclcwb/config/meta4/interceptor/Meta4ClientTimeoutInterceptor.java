package com.inditex.rrhh.icmclcwb.config.meta4.interceptor;

import java.lang.reflect.Method;
import java.util.HashMap;

import javax.annotation.Resource;
import javax.xml.namespace.QName;

import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.message.Exchange;
import org.apache.cxf.message.Message;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;
import org.apache.cxf.service.Service;
import org.apache.cxf.service.invoker.MethodDispatcher;
import org.apache.cxf.service.model.BindingOperationInfo;
import org.apache.cxf.transport.Conduit;
import org.apache.cxf.transport.http.HTTPConduit;
import org.apache.cxf.transports.http.configuration.HTTPClientPolicy;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Meta4ClientTimeoutInterceptor extends AbstractPhaseInterceptor<Message> {

	public Meta4ClientTimeoutInterceptor() {
		super(Phase.SETUP);
	}

	// Clave para identificar el timeout por defecto en el fichero externo.
	private final String CLAVE_DEFAULT = "DEFAULT_TIMEOUT";
	

	// Valor del timeout por defecto
	private final Long DEFAULT_CONNECTION_TIMEOUT = 90000L;
	private final Long DEFAULT_RECEIVE_TIMEOUT = 90000L;

	private final String CONNECTION = "connection";
	private final String RECEIVE = "receive";
	
	private final String SEPARADOR = ".";

	@Resource
	@Qualifier("timeOutsMap")
	private HashMap<String, String> timeOutsMap;

	@Override
	public void handleMessage(Message message) throws Fault {

		Long connectionTimeout = null;
		Long receiveTimeout = null;

		// Obtenemos la clave del servicio
		String clave = getClaveMessage(message);

		
		connectionTimeout = setTimeout(CONNECTION, clave, CLAVE_DEFAULT, DEFAULT_CONNECTION_TIMEOUT);
		receiveTimeout = setTimeout(RECEIVE, clave, CLAVE_DEFAULT, DEFAULT_RECEIVE_TIMEOUT);
		
		// Setear el timeout en el "conduit"
		Conduit conduit = message.getExchange().getConduit(message);
		if (conduit instanceof HTTPConduit) {
			HTTPConduit httpConduit = (HTTPConduit) conduit;
			HTTPClientPolicy httpClientPolicy = new HTTPClientPolicy();
			// connection timeout
			httpClientPolicy.setConnectionTimeout(connectionTimeout);
			// receive timeout
			httpClientPolicy.setReceiveTimeout(receiveTimeout);
			httpConduit.setClient(httpClientPolicy);
		}
	}	
	
	
	private Long setTimeout(String prefijo, String clave, String defaultKey, Long defaultValue){
		Long retorno = getTimeoutValue(prefijo, clave);
		
		if(retorno == null){
			retorno = getTimeoutValue(prefijo, defaultKey);
		}
		
		if(retorno == null){
			retorno = defaultValue;
		}
		
		return retorno;
	}

	private Long getTimeoutValue(String prefijo, String clave) {
		Long retorno = null;
		String claveCompleta = prefijo + SEPARADOR + clave;
		if (timeOutsMap.get(claveCompleta.toLowerCase()) != null) {
			String timeout = timeOutsMap.get(claveCompleta.toLowerCase());
			retorno = Long.valueOf(timeout);
		}
		return retorno;
	}

	private String getClaveMessage(Message message) {
		String nombreServicio = null;
		String nombreMetodo = null;
		String clave = null;

		try {
			Exchange exchange = message.getExchange();
			QName qname = (QName) exchange.get("javax.xml.ws.wsdl.port");

			BindingOperationInfo bop = exchange.get(BindingOperationInfo.class);
			MethodDispatcher md = (MethodDispatcher) exchange
					.get(Service.class).get(MethodDispatcher.class.getName());
			Method meth = md.getMethod(bop);

			if (qname != null) {
				nombreServicio = qname.getLocalPart();
			}
			if (meth != null) {
				nombreMetodo = meth.getName();
			}

		} catch (Exception e) {
			// TODO log: se han encontrado errores obteniendo las propiedades
			// del servicio
			// no se hace un throws para no romper la aplicacion
		}

		if (nombreServicio != null && nombreMetodo != null) {
			clave = nombreServicio + SEPARADOR + nombreMetodo;
		}

		return clave;
	}
}
