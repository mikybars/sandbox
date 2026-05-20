package com.inditex.rrhh.icmclcwb.model.meta4.pool;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicLong;

import com.inditex.rrhh.icmclcwb.model.app.util.CxfUtils;
import com.inditex.rrhh.icmclcwb.model.app.util.TimeUtils;
import com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.entity.IcmWsCalcIncomeService;
import com.inditex.rrhh.icmclcwb.model.meta4.login.entity.LoginService;
import com.inditex.rrhh.icmclcwb.model.meta4.login.entity.M4LoginOutput;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;
import stormpot.Slot;

@ExtendWith(MockitoExtension.class)
class Meta4ClientReallocatorTest {

  private Meta4ClientReallocator reallocator;

  @Mock
  private Meta4ClientFactory meta4ClientFactory;

  @Mock
  private Meta4ClientAbstract<LoginService> loginServiceFactory;

  @Mock
  private Meta4ClientAbstract<IcmWsCalcIncomeService> icmWsCalcIncomeServiceFactory;

  @Mock
  private LoginService loginService;

  @Mock
  private IcmWsCalcIncomeService icmWsCalcIncomeService;

  @Mock
  private Slot slot;

  @BeforeEach
  @SuppressWarnings("java:S3011")
  void beforeEach() throws Exception {
    final Field countField = Meta4ClientReallocator.class.getDeclaredField("count");
    countField.setAccessible(true);
    ((AtomicLong) countField.get(null)).set(0);
    reallocator = new Meta4ClientReallocator(meta4ClientFactory);
  }

  @Nested
  class Allocate {

    @Test
    void whenLoginSuccessfulExpectRetrieveM4SessionCalledOnLoginService() throws Exception {
      final Meta4ClientProperties properties = new Meta4ClientProperties();
      properties.setPreLogin(true);
      when(meta4ClientFactory.getMeta4ClientProperties()).thenReturn(properties);
      final Meta4ClientCredentials credentials = new Meta4ClientCredentials();
      credentials.setUser("user");
      credentials.setPassword("pass");
      credentials.setLanguage("es");
      when(meta4ClientFactory.getMeta4ClientCredentials()).thenReturn(credentials);
      when(meta4ClientFactory.getLoginServiceFactory()).thenReturn(loginServiceFactory);
      when(meta4ClientFactory.getIcmWsCalcIncomeServiceFactory())
          .thenReturn(icmWsCalcIncomeServiceFactory);
      when(loginServiceFactory.build(LoginService.class)).thenReturn(loginService);
      when(icmWsCalcIncomeServiceFactory.build(IcmWsCalcIncomeService.class))
          .thenReturn(icmWsCalcIncomeService);
      final M4LoginOutput loginOutput = new M4LoginOutput();
      loginOutput.setSessionID("SESSION-123");
      when(loginService.login("user", "pass", "es")).thenReturn(loginOutput);

      try (MockedStatic<CxfUtils> cxfMock = mockStatic(CxfUtils.class);
          MockedStatic<TimeUtils> timeMock = mockStatic(TimeUtils.class)) {
        cxfMock.when(() -> CxfUtils.getCookies(loginService)).thenReturn(new HashMap<>());
        timeMock.when(TimeUtils::nowLocalDateTime)
            .thenReturn(LocalDateTime.parse("2025-10-22T18:45:00"));

        final Meta4ClientPoolable result = reallocator.allocate(slot);

        verify(loginService).retrieveM4Session("SESSION-123");
        verify(icmWsCalcIncomeService, never()).retrieveM4Session(any(String.class));
        assertThat(result).isNotNull();
        assertThat(result.getSession().getId()).isEqualTo("SESSION-123");
        assertThat(result.getSession().isLogin()).isTrue();
      }
    }

    @Test
    void whenLoginReturnsBlankIdExpectErrorLogged() throws Exception {
      final Meta4ClientProperties properties = new Meta4ClientProperties();
      properties.setPreLogin(true);
      when(meta4ClientFactory.getMeta4ClientProperties()).thenReturn(properties);
      final Meta4ClientCredentials credentials = new Meta4ClientCredentials();
      credentials.setUser("user");
      credentials.setPassword("pass");
      credentials.setLanguage("es");
      when(meta4ClientFactory.getMeta4ClientCredentials()).thenReturn(credentials);
      when(meta4ClientFactory.getLoginServiceFactory()).thenReturn(loginServiceFactory);
      when(meta4ClientFactory.getIcmWsCalcIncomeServiceFactory())
          .thenReturn(icmWsCalcIncomeServiceFactory);
      when(loginServiceFactory.build(LoginService.class)).thenReturn(loginService);
      when(icmWsCalcIncomeServiceFactory.build(IcmWsCalcIncomeService.class))
          .thenReturn(icmWsCalcIncomeService);
      final M4LoginOutput loginOutput = new M4LoginOutput();
      loginOutput.setSessionID("");
      when(loginService.login("user", "pass", "es")).thenReturn(loginOutput);

      try (MockedStatic<CxfUtils> cxfMock = mockStatic(CxfUtils.class);
          MockedStatic<TimeUtils> timeMock = mockStatic(TimeUtils.class)) {
        timeMock.when(TimeUtils::nowLocalDateTime)
            .thenReturn(LocalDateTime.parse("2025-10-22T18:45:00"));

        final Meta4ClientPoolable result = reallocator.allocate(slot);

        assertThat(result).isNotNull();
        assertThat(result.getSession().getId()).isEmpty();
        assertThat(result.getSession().isLogin()).isTrue();
      }
    }

    @Test
    void whenPreLoginFalseAndCountBelowSizeExpectNoLogin() throws Exception {
      final Meta4ClientProperties properties = new Meta4ClientProperties();
      properties.setPreLogin(false);
      properties.setSize(10);
      when(meta4ClientFactory.getMeta4ClientProperties()).thenReturn(properties);

      try (MockedStatic<TimeUtils> timeMock = mockStatic(TimeUtils.class)) {
        timeMock.when(TimeUtils::nowLocalDateTime)
            .thenReturn(LocalDateTime.parse("2025-10-22T18:45:00"));

        final Meta4ClientPoolable result = reallocator.allocate(slot);

        assertThat(result).isNotNull();
        assertThat(result.getSession().isLogin()).isFalse();
        assertThat(result.getSession().getId()).isEmpty();
        verify(meta4ClientFactory, never()).getLoginServiceFactory();
      }
    }
  }

  @Nested
  class Deallocate {

    @Test
    void whenSessionIdPresentExpectLogoutCalled() throws Exception {
      final Meta4ClientPoolable poolable = mock(Meta4ClientPoolable.class);
      final Meta4ClientSession session = new Meta4ClientSession();
      session.setId("SESSION-123");
      when(poolable.getSession()).thenReturn(session);
      when(poolable.getLoginService()).thenReturn(loginService);

      reallocator.deallocate(poolable);

      verify(loginService).logout();
    }

    @Test
    void whenLogoutThrowsExceptionExpectErrorLogged() throws Exception {
      final Meta4ClientPoolable poolable = mock(Meta4ClientPoolable.class);
      final Meta4ClientSession session = new Meta4ClientSession();
      session.setId("SESSION-123");
      when(poolable.getSession()).thenReturn(session);
      when(poolable.getLoginService()).thenReturn(loginService);
      doThrow(new RuntimeException("logout failed")).when(loginService).logout();

      reallocator.deallocate(poolable);

      verify(loginService).logout();
    }
  }

  @Nested
  class Reallocate {

    @Test
    void whenReallocateExpectAllocateDelegated() throws Exception {
      final Meta4ClientReallocator spiedReallocator = spy(reallocator);
      final Meta4ClientPoolable allocatedPoolable = mock(Meta4ClientPoolable.class);
      doReturn(allocatedPoolable).when(spiedReallocator).allocate(slot);
      final Meta4ClientPoolable oldPoolable = mock(Meta4ClientPoolable.class);
      final Meta4ClientSession oldSession = new Meta4ClientSession();
      oldSession.setId("OLD-SESSION");
      when(oldPoolable.getSession()).thenReturn(oldSession);

      final Meta4ClientPoolable result = spiedReallocator.reallocate(slot, oldPoolable);

      verify(spiedReallocator).allocate(slot);
      assertThat(result).isSameAs(allocatedPoolable);
    }
  }
}
