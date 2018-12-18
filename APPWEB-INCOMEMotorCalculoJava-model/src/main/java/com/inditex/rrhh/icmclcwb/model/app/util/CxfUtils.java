package com.inditex.rrhh.icmclcwb.model.app.util;

import java.util.AbstractMap;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.xml.ws.BindingProvider;
import javax.xml.ws.handler.MessageContext;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.helpers.CastUtils;
import org.apache.cxf.transport.http.Cookie;
import org.apache.cxf.transport.http.HTTPConduit;
import org.springframework.stereotype.Component;

@Component
public class CxfUtils {

	private CxfUtils() {
	}

	public static Map<String, List<String>> getResponseHeaders(final Object service) {
		Map<String, List<String>> result = new HashMap<>();
		Map<String, Object> responseContext = ((BindingProvider) service).getResponseContext();
		if (MapUtils.isNotEmpty(responseContext)) {
			result = CastUtils.cast((Map<?, ?>) responseContext.get(MessageContext.HTTP_RESPONSE_HEADERS));
		}
		return result;
	}

	public static Map<String, List<String>> getRequestHeaders(final Object service) {
		Map<String, List<String>> result = new HashMap<>();
		Map<String, Object> requestContext = ((BindingProvider) service).getRequestContext();
		if (MapUtils.isNotEmpty(requestContext)) {
			result = CastUtils.cast((Map<?, ?>) requestContext.get(MessageContext.HTTP_REQUEST_HEADERS));
		}
		return result;
	}

	public static void putRequestHeaders(final Object service, final Map<String, List<String>> requestHeaders) {
		((BindingProvider) service).getRequestContext().put(MessageContext.HTTP_REQUEST_HEADERS, requestHeaders);
	}

	public static List<String> getSetCookie(final Map<String, List<String>> map) {
		return CastUtils.cast((List<?>) (map.get("Set-Cookie")));
	}

	public static String getJSessionID(final List<String> list) {
		String jSessionID = null;
		if (CollectionUtils.isNotEmpty(list)) {
			for (String item : list) {
				if (item.contains("JSESSIONID")) {
					jSessionID = item.substring("JSESSIONID".length() + 1, item.length());
					break;
				}
			}
		}
		return jSessionID;
	}

	public static Map<String, List<String>> mapJSessionID(final String jSessionID) {
		return Stream
				.of(new AbstractMap.SimpleEntry<>("Cookie",
						Collections.singletonList(new StringBuilder("JSESSIONID=").append(jSessionID).toString())))
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
	}

	public static Map<String, Cookie> cookieJSessionID(final String jSessionID) {
		return Stream.of(new AbstractMap.SimpleEntry<>("Cookie", new Cookie("JSESSIONID", jSessionID)))
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
	}

	public static void putCookies(final Object service, final Map<String, Cookie> cookies) {
		Client cl = ClientProxy.getClient(service);
		HTTPConduit http = (HTTPConduit) cl.getConduit();
		http.getCookies().putAll(cookies);
	}

}
