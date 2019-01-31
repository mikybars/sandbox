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

/**
 * The Class CxfUtils.
 */
@Component
public class CxfUtils {

    /**
     * Instantiates a new cxf utils.
     */
    private CxfUtils() {
    }

    /**
     * Gets the response headers.
     *
     * @param service the service
     * @return the response headers
     */
    public static Map<String, List<String>> getResponseHeaders(final Object service) {
        Map<String, List<String>> result = new HashMap<>();
        Map<String, Object> responseContext = ((BindingProvider) service).getResponseContext();
        if (MapUtils.isNotEmpty(responseContext)) {
            result = CastUtils.cast((Map<?, ?>) responseContext.get(MessageContext.HTTP_RESPONSE_HEADERS));
        }
        return result;
    }

    /**
     * Gets the request headers.
     *
     * @param service the service
     * @return the request headers
     */
    public static Map<String, List<String>> getRequestHeaders(final Object service) {
        Map<String, List<String>> result = new HashMap<>();
        Map<String, Object> requestContext = ((BindingProvider) service).getRequestContext();
        if (MapUtils.isNotEmpty(requestContext)) {
            result = CastUtils.cast((Map<?, ?>) requestContext.get(MessageContext.HTTP_REQUEST_HEADERS));
        }
        return result;
    }

    /**
     * Put request headers.
     *
     * @param service the service
     * @param requestHeaders the request headers
     */
    public static void putRequestHeaders(final Object service, final Map<String, List<String>> requestHeaders) {
        ((BindingProvider) service).getRequestContext().put(MessageContext.HTTP_REQUEST_HEADERS, requestHeaders);
    }

    /**
     * Replace request headers.
     *
     * @param service the service
     * @param requestHeaders the request headers
     */
    public static void replaceRequestHeaders(final Object service, final Map<String, List<String>> requestHeaders) {
        ((BindingProvider) service).getRequestContext().replace(MessageContext.HTTP_REQUEST_HEADERS, requestHeaders);
    }

    /**
     * Gets the sets the cookie.
     *
     * @param map the map
     * @return the sets the cookie
     */
    public static List<String> getSetCookie(final Map<String, List<String>> map) {
        return CastUtils.cast((List<?>) (map.get(CxfConstants.SET_COOKIE)));
    }

    /**
     * Gets the j session ID.
     *
     * @param list the list
     * @return the j session ID
     */
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

    /**
     * Map J session ID.
     *
     * @param jSessionID the j session ID
     * @return the map
     */
    public static Map<String, List<String>> mapJSessionID(final String jSessionID) {
        return CxfUtils.mapCookie(Collections.singletonList(
                new StringBuilder(CxfConstants.JSESSIONID).append(CxfConstants.EQUALS).append(jSessionID).toString()));
    }

    /**
     * Map cookie.
     *
     * @param list the list
     * @return the map
     */
    public static Map<String, List<String>> mapCookie(final List<String> list) {
        return Stream.of(new AbstractMap.SimpleEntry<>(CxfConstants.COOKIE, list))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    /**
     * Cookie J session ID.
     *
     * @param jSessionID the j session ID
     * @return the map
     */
    public static Map<String, Cookie> cookieJSessionID(final String jSessionID) {
        return Stream
                .of(new AbstractMap.SimpleEntry<>(CxfConstants.COOKIE, new Cookie(CxfConstants.JSESSIONID, jSessionID)))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    /**
     * Put cookies.
     *
     * @param service the service
     * @param cookies the cookies
     */
    public static void putCookies(final Object service, final Map<String, Cookie> cookies) {
        Client cl = ClientProxy.getClient(service);
        HTTPConduit http = (HTTPConduit) cl.getConduit();
        http.getCookies().putAll(cookies);
    }

    /**
     * Put cookie.
     *
     * @param service the service
     * @param jSessionID the j session ID
     */
    public static void putCookie(final Object service, final String jSessionID) {
        Client cl = ClientProxy.getClient(service);
        HTTPConduit http = (HTTPConduit) cl.getConduit();
        http.getClient().setCookie(
                new StringBuilder(CxfConstants.JSESSIONID).append(CxfConstants.EQUALS).append(jSessionID).toString());
    }

    /**
     * Gets the cookies.
     *
     * @param service the service
     * @return the cookies
     */
    public static Map<String, Cookie> getCookies(final Object service) {
        Client client = ClientProxy.getClient(service);
        HTTPConduit httpConduit = (HTTPConduit) client.getConduit();
        return httpConduit.getCookies();
    }

    /**
     * Sets the cookies.
     *
     * @param service the service
     * @param cookies the cookies
     */
    public static void setCookies(final Object service, Map<String, Cookie> cookies) {
        Client client = ClientProxy.getClient(service);
        HTTPConduit httpConduit = (HTTPConduit) client.getConduit();
        httpConduit.getCookies().clear();
        httpConduit.getCookies().putAll(cookies);
    }

    /**
     * Clone headers.
     *
     * @param serviceLogin the service login
     * @param service the service
     */
    public static void cloneHeaders(final Object serviceLogin, final Object service) {
        Client clientLogin = ClientProxy.getClient(serviceLogin);
        Client clientService = ClientProxy.getClient(service);
        HTTPConduit httpConduitLogin = (HTTPConduit) clientLogin.getConduit();
        HTTPConduit httpConduitService = (HTTPConduit) clientService.getConduit();
        httpConduitService.getCookies().clear();
        httpConduitService.getCookies().putAll(httpConduitLogin.getCookies());
    }

}
