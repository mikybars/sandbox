/*
 * Copyright (c) 2021. Inditex
 */

package com.inditex.rrhh.icmclcwb.model.meta4.pool;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

import java.util.List;

import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmWsCalcIncomeService;
import com.inditex.rrhh.icmclcwb.model.meta4.login.entity.LoginService;
import com.inditex.rrhh.icmclcwb.model.meta4.login.entity.M4SoapException;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.read.ListAppender;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.mockito.Mock;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import stormpot.SlotInfo;

@ExtendWith(SpringExtension.class)
class Meta4ClientExpirationTest {

  @Mock
  private SlotInfo<Meta4ClientPoolable> info;

  @Mock
  private Meta4ClientPoolable poolable;

  @Mock
  private LoginService loginService;

  @Mock
  private IcmWsCalcIncomeService icmWsCalcIncomeService;

  @BeforeEach
  public void setup() {
    when(this.info.getPoolable()).thenReturn(this.poolable);
  }

  @Test
  void hasExpiredLoginFalseTest() {
    final Meta4ClientSession session = new Meta4ClientSession();
    session.setId("SESION");
    session.setLogin(false);
    when(this.poolable.getSession()).thenReturn(session);
    when(this.poolable.getLoginService()).thenReturn(this.loginService);
    when(this.poolable.getIcmWsCalcIncomeService()).thenReturn(this.icmWsCalcIncomeService);

    final Meta4ClientExpiration meta4ClientExpiration = new Meta4ClientExpiration();

    assertTrue(meta4ClientExpiration.hasExpired(this.info));

  }

  @ParameterizedTest
  @NullAndEmptySource
  void hasExpiredSessionIdTest(final String sessionId) {
    final Meta4ClientSession session = new Meta4ClientSession();
    session.setId(sessionId);
    session.setLogin(true);
    when(this.poolable.getSession()).thenReturn(session);
    when(this.poolable.getLoginService()).thenReturn(this.loginService);
    when(this.poolable.getIcmWsCalcIncomeService()).thenReturn(this.icmWsCalcIncomeService);

    final Meta4ClientExpiration meta4ClientExpiration = new Meta4ClientExpiration();

    assertTrue(meta4ClientExpiration.hasExpired(this.info));

  }

  @Test
  void hasExpiredLoginServiceNullTest() {
    final Meta4ClientSession session = new Meta4ClientSession();
    session.setId("SESION");
    session.setLogin(true);
    when(this.poolable.getSession()).thenReturn(session);
    when(this.poolable.getIcmWsCalcIncomeService()).thenReturn(this.icmWsCalcIncomeService);

    final Meta4ClientExpiration meta4ClientExpiration = new Meta4ClientExpiration();

    final ListAppender<ILoggingEvent> listAppender = this.createLogListAppender();

    assertTrue(meta4ClientExpiration.hasExpired(this.info));

    final List<ILoggingEvent> list = listAppender.list;
    assertEquals("Meta4ClientExpiration :: La session '{}' ha caducado", list.get(0).getMessage());
    assertEquals(Level.DEBUG, list.get(0).getLevel());
  }

  @Test
  void hasExpiredIcmWsCalcIncomeServiceNullTest() {
    final Meta4ClientSession session = new Meta4ClientSession();
    session.setId("SESION");
    session.setLogin(true);
    when(this.poolable.getSession()).thenReturn(session);
    when(this.poolable.getLoginService()).thenReturn(this.loginService);

    final Meta4ClientExpiration meta4ClientExpiration = new Meta4ClientExpiration();

    assertTrue(meta4ClientExpiration.hasExpired(this.info));

  }

  @Test
  void hasExpiredLoginServiceNotRetrievedLoginTest()
      throws com.inditex.rrhh.icmclcwb.model.meta4.login.entity.M4SoapException,
      com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.M4SoapException_Exception {
    final Meta4ClientSession session = new Meta4ClientSession();
    session.setId("SESION");
    session.setLogin(true);
    when(this.poolable.getSession()).thenReturn(session);
    when(this.poolable.getLoginService()).thenReturn(this.loginService);
    when(this.poolable.getIcmWsCalcIncomeService()).thenReturn(this.icmWsCalcIncomeService);
    when(this.loginService.retrieveM4Session(any(String.class))).thenReturn(1);
    when(this.icmWsCalcIncomeService.retrieveM4Session(any(String.class))).thenReturn(0);

    final Meta4ClientExpiration meta4ClientExpiration = new Meta4ClientExpiration();

    assertTrue(meta4ClientExpiration.hasExpired(this.info));

  }

  @Test
  void hasExpiredIcmWsCalcIncomeServiceNotRetrievedLoginTest()
      throws com.inditex.rrhh.icmclcwb.model.meta4.login.entity.M4SoapException,
      com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.M4SoapException_Exception {
    final Meta4ClientSession session = new Meta4ClientSession();
    session.setId("SESION");
    session.setLogin(true);
    when(this.poolable.getSession()).thenReturn(session);
    when(this.poolable.getLoginService()).thenReturn(this.loginService);
    when(this.poolable.getIcmWsCalcIncomeService()).thenReturn(this.icmWsCalcIncomeService);
    when(this.loginService.retrieveM4Session(any(String.class))).thenReturn(0);
    when(this.icmWsCalcIncomeService.retrieveM4Session(any(String.class))).thenReturn(1);

    final Meta4ClientExpiration meta4ClientExpiration = new Meta4ClientExpiration();

    assertTrue(meta4ClientExpiration.hasExpired(this.info));

  }

  @Test
  void hasExpiredFalseTest()
      throws com.inditex.rrhh.icmclcwb.model.meta4.login.entity.M4SoapException,
      com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.M4SoapException_Exception {
    final Meta4ClientSession session = new Meta4ClientSession();
    session.setId("SESION");
    session.setLogin(true);
    when(this.poolable.getSession()).thenReturn(session);
    when(this.poolable.getLoginService()).thenReturn(this.loginService);
    when(this.poolable.getIcmWsCalcIncomeService()).thenReturn(this.icmWsCalcIncomeService);
    when(this.loginService.retrieveM4Session(any(String.class))).thenReturn(0);
    when(this.icmWsCalcIncomeService.retrieveM4Session(any(String.class))).thenReturn(0);

    final Meta4ClientExpiration meta4ClientExpiration = new Meta4ClientExpiration();

    final ListAppender<ILoggingEvent> listAppender = this.createLogListAppender();
    assertFalse(meta4ClientExpiration.hasExpired(this.info));

  }

  @Test
  void hasExpiredExceptionTest() throws com.inditex.rrhh.icmclcwb.model.meta4.login.entity.M4SoapException {
    final Meta4ClientSession session = new Meta4ClientSession();
    session.setId("SESION");
    session.setLogin(true);
    when(this.poolable.getSession()).thenReturn(session);
    when(this.poolable.getLoginService()).thenReturn(this.loginService);
    when(this.poolable.getIcmWsCalcIncomeService()).thenReturn(this.icmWsCalcIncomeService);
    final com.inditex.rrhh.icmclcwb.model.meta4.login.entity.M4SoapException exception =
        new com.inditex.rrhh.icmclcwb.model.meta4.login.entity.M4SoapException("",
            new M4SoapException());
    doThrow(exception)
        .when(this.loginService)
        .retrieveM4Session(any(String.class));

    final ListAppender<ILoggingEvent> listAppender = this.createLogListAppender();

    final Meta4ClientExpiration meta4ClientExpiration = new Meta4ClientExpiration();
    assertTrue(meta4ClientExpiration.hasExpired(this.info));

    final List<ILoggingEvent> list = listAppender.list;
    assertEquals("Meta4ClientExpiration :: Sesión expirada detectada en hasExpired(): {}", list.get(0).getMessage());
    assertEquals(Level.DEBUG, list.get(0).getLevel());

  }

  private ListAppender<ILoggingEvent> createLogListAppender() {
    final Logger log = (Logger) LoggerFactory.getLogger(Meta4ClientExpiration.class);
    log.setLevel(Level.DEBUG);
    final ListAppender<ILoggingEvent> listAppender = new ListAppender<>();
    listAppender.start();
    log.addAppender(listAppender);
    return listAppender;
  }

}
