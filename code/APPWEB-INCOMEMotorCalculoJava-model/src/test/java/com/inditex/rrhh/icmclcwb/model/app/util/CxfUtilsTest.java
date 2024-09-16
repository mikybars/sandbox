package com.inditex.rrhh.icmclcwb.model.app.util;

/*
 * Copyright (c) 2021. Inditex
 */
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.cxf.transport.http.Cookie;
import org.instancio.Instancio;
import org.instancio.junit.InstancioSource;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith({SpringExtension.class})
class CxfUtilsTest {

  // TODO [albertoggu] Tests: Parámetros recuperados a null fallanº - Lista de métodos:
  // getResponseHeaders, getRequestHeaders, putRequestHeaders, replaceRequestHeaders, putCookies,
  // putCookie, cloneHeaders, close

  final String jsessionID = "JSESSIONID454545455";

  // @Test
  // void getResponseHeadersTest (@Random Object service) {
  // Map<String, Object> responseContext = new HashMap<>();
  // responseContext.put("1", new Object());
  // doReturn(responseContext).when(((BindingProvider) service)).getResponseContext();
  //
  // final Map<String, List<String>> result = CxfUtils.getResponseHeaders(service);
  // assertNotNull(result);
  // }

  @Test
  void getSetCoockie() {
    final var list = Instancio.createList(String.class);

    final Map<String, List<String>> map = new HashMap<>();
    map.put("Set-Cookie", list);

    final List<String> result = CxfUtils.getSetCookie(map);
    assertNotNull(result);
    assertFalse(result.isEmpty());
  }

  @ParameterizedTest
  @InstancioSource
  void getJSessionIDTest(final List<String> emptyList) {
    final var list = Instancio.createList(String.class);

    list.add(this.jsessionID);

    final String result = CxfUtils.getJSessionID(list);
    assertNotNull(result);

    final String result2 = CxfUtils.getJSessionID(emptyList);
    assertNull(result2);
  }

  @Test
  void mapJSessionIDTest() {
    final Map<String, List<String>> result = CxfUtils.mapJSessionID(this.jsessionID);

    assertNotNull(result);
    assertFalse(result.isEmpty());
    for (final List<String> list : result.values()) {
      assertNotNull(list);
      assertFalse(list.isEmpty());
    }
  }

  @Test
  void cookieJSessionIDTest() {
    final Map<String, Cookie> result = CxfUtils.cookieJSessionID(this.jsessionID);

    assertNotNull(result);
    assertFalse(result.isEmpty());
    for (final Cookie cookie : result.values()) {
      assertNotNull(cookie);
    }
  }

  // @Test
  // void putCookiesTest (@Random Object service ) {
  // final Map<String, Cookie> map = CxfUtils.cookieJSessionID(this.jsessionID);
  //
  // CxfUtils.putCookies(service, map);
  // }

}
