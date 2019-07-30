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

import com.inditex.rrhh.icmclcwb.api.app.util.CxfConstants;

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

    public static void replaceRequestHeaders(final Object service, final Map<String, List<String>> requestHeaders) {
        ((BindingProvider) service).getRequestContext().replace(MessageContext.HTTP_REQUEST_HEADERS, requestHeaders);
    }

    public static List<String> getSetCookie(final Map<String, List<String>> map) {
        return CastUtils.cast((List<?>) (map.get(CxfConstants.SET_COOKIE)));
    }

    public static String getJSessionID(final List<String> list) {
        String jSessionID = null;
        if (CollectionUtils.isNotEmpty(list)) {
            for (String item : list) {
                if (item.contains(CxfConstants.JSESSIONID)) {
                    jSessionID = item.substring(CxfConstants.JSESSIONID.length() + 1, item.length());
                    break;
                }
            }
        }
        return jSessionID;
    }

    public static Map<String, List<String>> mapJSessionID(final String jSessionID) {
        return CxfUtils.mapCookie(Collections.singletonList(
                new StringBuilder(CxfConstants.JSESSIONID).append(CxfConstants.SEPARADOR).append(jSessionID).toString()));
    }

    public static Map<String, List<String>> mapCookie(final List<String> list) {
        return Stream.of(new AbstractMap.SimpleEntry<>(CxfConstants.COOKIE, list))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    public static Map<String, Cookie> cookieJSessionID(final String jSessionID) {
        return Stream
                .of(new AbstractMap.SimpleEntry<>(CxfConstants.COOKIE, new Cookie(CxfConstants.JSESSIONID, jSessionID)))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    public static void putCookies(final Object service, final Map<String, Cookie> cookies) {
        Client client = CxfUtils.getClient(service);
        HTTPConduit http = (HTTPConduit) client.getConduit();
        http.getCookies().putAll(cookies);
    }

    public static void putCookie(final Object service, final String jSessionID) {
        Client client = CxfUtils.getClient(service);
        HTTPConduit http = (HTTPConduit) client.getConduit();
        http.getClient().setCookie(
                new StringBuilder(CxfConstants.JSESSIONID).append(CxfConstants.SEPARADOR).append(jSessionID).toString());
    }

    public static Map<String, Cookie> getCookies(final Object service) {
        Client client = CxfUtils.getClient(service);
        HTTPConduit httpConduit = (HTTPConduit) client.getConduit();
        return httpConduit.getCookies();
    }

    public static void setCookies(final Object service, Map<String, Cookie> cookies) {
        Client client = CxfUtils.getClient(service);
        HTTPConduit httpConduit = (HTTPConduit) client.getConduit();
        httpConduit.getCookies().clear();
        httpConduit.getCookies().putAll(cookies);
    }

    public static void cloneHeaders(final Object serviceLogin, final Object service) {
        Client clientLogin = CxfUtils.getClient(serviceLogin);
        Client clientService = CxfUtils.getClient(service);
        HTTPConduit httpConduitLogin = (HTTPConduit) clientLogin.getConduit();
        HTTPConduit httpConduitService = (HTTPConduit) clientService.getConduit();
        httpConduitService.getCookies().clear();
        httpConduitService.getCookies().putAll(httpConduitLogin.getCookies());
    }
    
    public static Client getClient(final Object o) {
        return ClientProxy.getClient(o);
    }

}
