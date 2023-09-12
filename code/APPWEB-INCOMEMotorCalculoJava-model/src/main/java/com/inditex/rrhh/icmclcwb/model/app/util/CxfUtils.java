package com.inditex.rrhh.icmclcwb.model.app.util;

import java.util.AbstractMap;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.inditex.rrhh.icmclcwb.api.app.util.CxfConstants;

import javax.xml.ws.BindingProvider;
import javax.xml.ws.handler.MessageContext;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.helpers.CastUtils;
import org.apache.cxf.transport.http.Cookie;
import org.apache.cxf.transport.http.HTTPConduit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class CxfUtils {

  private static final Logger log = LoggerFactory.getLogger(CxfUtils.class);

  private CxfUtils() {
  }

  public static Map<String, List<String>> getResponseHeaders(final Object service) {
    Map<String, List<String>> result = new HashMap<>();
    final Map<String, Object> responseContext = ((BindingProvider) service).getResponseContext();
    if (MapUtils.isNotEmpty(responseContext)) {
      result = CastUtils.cast((Map<?, ?>) responseContext.get(MessageContext.HTTP_RESPONSE_HEADERS));
    }
    return result;
  }

  public static Map<String, List<String>> getRequestHeaders(final Object service) {
    Map<String, List<String>> result = new HashMap<>();
    final Map<String, Object> requestContext = ((BindingProvider) service).getRequestContext();
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
    String jsessionID = null;
    if (CollectionUtils.isNotEmpty(list)) {
      for (final String item : list) {
        if (item.contains(CxfConstants.JSESSIONID)) {
          jsessionID = item.substring(CxfConstants.JSESSIONID.length() + 1, item.length());
          break;
        }
      }
    }
    return jsessionID;
  }

  public static Map<String, List<String>> mapJSessionID(final String jsessionID) {
    return CxfUtils.mapCookie(Collections.singletonList(new StringBuilder(CxfConstants.JSESSIONID)
        .append(CxfConstants.SEPARADOR)
        .append(jsessionID)
        .toString()));
  }

  public static Map<String, List<String>> mapCookie(final List<String> list) {
    return Stream.of(new AbstractMap.SimpleEntry<>(CxfConstants.COOKIE, list))
        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
  }

  public static Map<String, Cookie> cookieJSessionID(final String jsessionID) {
    return Stream
        .of(new AbstractMap.SimpleEntry<>(CxfConstants.COOKIE, new Cookie(CxfConstants.JSESSIONID, jsessionID)))
        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
  }

  public static void putCookies(final Object service, final Map<String, Cookie> cookies) {
    final HTTPConduit http = CxfUtils.getHttpConduit(service);
    http.getCookies().putAll(cookies);
  }

  public static void putCookie(final Object service, final String jsessionID) {
    final HTTPConduit http = CxfUtils.getHttpConduit(service);
    http.getClient()
        .setCookie(new StringBuilder(CxfConstants.JSESSIONID).append(CxfConstants.SEPARADOR)
            .append(jsessionID)
            .toString());
  }

  public static Map<String, Cookie> getCookies(final Object service) {
    final HTTPConduit httpConduit = CxfUtils.getHttpConduit(service);
    return httpConduit.getCookies();
  }

  public static void setCookies(final Object service, final Map<String, Cookie> cookies) {
    final HTTPConduit httpConduit = CxfUtils.getHttpConduit(service);
    httpConduit.getCookies().clear();
    httpConduit.getCookies().putAll(cookies);
  }

  public static void cloneHeaders(final Object serviceLogin, final Object service) {
    final HTTPConduit httpConduitLogin = CxfUtils.getHttpConduit(serviceLogin);
    final HTTPConduit httpConduitService = CxfUtils.getHttpConduit(service);
    httpConduitService.getCookies().clear();
    httpConduitService.getCookies().putAll(httpConduitLogin.getCookies());
  }

  public static Client getClient(final Object o) {
    return ClientProxy.getClient(o);
  }

  public static void close(final Object o) {
    try {
      if (o != null) {
        final Client client = CxfUtils.getClient(o);
        client.close();
      }
    } catch (final Exception e) {
      log.error("Error cerrando el cliente cxf", e);
    }
  }

  public static HTTPConduit getHttpConduit(final Client client) {
    return (HTTPConduit) client.getConduit();
  }

  public static HTTPConduit getHttpConduit(final Object o) {
    return CxfUtils.getHttpConduit(CxfUtils.getClient(o));
  }

}
