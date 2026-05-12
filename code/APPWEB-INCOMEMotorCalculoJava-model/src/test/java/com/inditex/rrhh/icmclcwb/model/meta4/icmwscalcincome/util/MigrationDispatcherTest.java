package com.inditex.rrhh.icmclcwb.model.meta4.icmwscalcincome.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.awaitility.Awaitility.await;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.Duration;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Supplier;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class MigrationDispatcherTest {

  static final String OPERATION = "op-test";

  static final String MIGRATION_THREAD_NAME = "migration-test-thread";

  static final Duration AWAIT_TIMEOUT = Duration.ofSeconds(2);

  @Mock
  Supplier<String> restCall;

  @Mock
  Supplier<String> soapCall;

  ExecutorService migrationExecutor;

  @BeforeEach
  void setUp() {
    migrationExecutor = Executors.newSingleThreadExecutor(r -> new Thread(r, MIGRATION_THREAD_NAME));
  }

  @AfterEach
  void tearDown() throws InterruptedException {
    migrationExecutor.shutdown();
    migrationExecutor.awaitTermination(2, TimeUnit.SECONDS);
  }

  @Nested
  class Constructor {

    @ParameterizedTest
    @ValueSource(strings = {"shadow", "SHADOW", "Shadow"})
    void whenShadowValueExpectShadowBehavior(String value) {
      when(restCall.get()).thenReturn("rest");
      when(soapCall.get()).thenReturn("soap");
      MigrationDispatcher dispatcher = new MigrationDispatcher(value, migrationExecutor);

      String result = dispatcher.dispatch(OPERATION, restCall, soapCall);

      assertThat(result).isEqualTo("soap");
      verify(soapCall, times(1)).get();
      await().atMost(AWAIT_TIMEOUT).untilAsserted(() -> verify(restCall, times(1)).get());
    }

    @ParameterizedTest
    @ValueSource(strings = {"rest", "REST", "Rest"})
    void whenRestValueExpectRestBehavior(String value) {
      when(restCall.get()).thenReturn("rest");
      MigrationDispatcher dispatcher = new MigrationDispatcher(value, migrationExecutor);

      String result = dispatcher.dispatch(OPERATION, restCall, soapCall);

      assertThat(result).isEqualTo("rest");
      verify(restCall, times(1)).get();
      verify(soapCall, never()).get();
    }

    @ParameterizedTest
    @ValueSource(strings = {"invalid", "foo", "bar"})
    void whenUnknownValueExpectShadowFallback(String value) {
      when(restCall.get()).thenReturn("rest");
      when(soapCall.get()).thenReturn("soap");
      MigrationDispatcher dispatcher = new MigrationDispatcher(value, migrationExecutor);

      String result = dispatcher.dispatch(OPERATION, restCall, soapCall);

      assertThat(result).isEqualTo("soap");
      verify(soapCall, times(1)).get();
      await().atMost(AWAIT_TIMEOUT).untilAsserted(() -> verify(restCall, atLeastOnce()).get());
    }
  }

  @Nested
  class Execute {

    @Test
    void whenShadowModeExpectSoapResultReturned() {
      when(soapCall.get()).thenReturn("soap-value");
      MigrationDispatcher dispatcher = new MigrationDispatcher("shadow", migrationExecutor);

      String result = dispatcher.dispatch(OPERATION, restCall, soapCall);

      assertThat(result).isEqualTo("soap-value");
    }

    @Test
    void whenShadowModeExpectSoapCalledOnce() {
      when(soapCall.get()).thenReturn("soap-value");
      MigrationDispatcher dispatcher = new MigrationDispatcher("shadow", migrationExecutor);

      dispatcher.dispatch(OPERATION, restCall, soapCall);

      verify(soapCall, times(1)).get();
    }

    @Test
    void whenShadowModeExpectRestCalledAsynchronously() {
      AtomicReference<Thread> restThread = new AtomicReference<>();
      when(restCall.get()).thenAnswer(invocation -> {
        restThread.set(Thread.currentThread());
        return "rest-value";
      });
      when(soapCall.get()).thenReturn("soap-value");
      MigrationDispatcher dispatcher = new MigrationDispatcher("shadow", migrationExecutor);

      dispatcher.dispatch(OPERATION, restCall, soapCall);

      await().atMost(AWAIT_TIMEOUT).untilAsserted(() -> assertThat(restThread.get()).isNotNull());
      assertThat(restThread.get().getName()).isEqualTo(MIGRATION_THREAD_NAME);
    }

    @Test
    void whenShadowModeAndRestSupplierFailsExpectSoapResultReturnedAndNoExceptionPropagated() {
      when(restCall.get()).thenThrow(new IllegalStateException("rest failure"));
      when(soapCall.get()).thenReturn("soap-value");
      MigrationDispatcher dispatcher = new MigrationDispatcher("shadow", migrationExecutor);

      String result = dispatcher.dispatch(OPERATION, restCall, soapCall);

      assertThat(result).isEqualTo("soap-value");
      await().atMost(AWAIT_TIMEOUT).untilAsserted(() -> verify(restCall, times(1)).get());
    }

    @Test
    void whenRestModeExpectRestResultReturned() {
      when(restCall.get()).thenReturn("rest-value");
      MigrationDispatcher dispatcher = new MigrationDispatcher("rest", migrationExecutor);

      String result = dispatcher.dispatch(OPERATION, restCall, soapCall);

      assertThat(result).isEqualTo("rest-value");
    }

    @Test
    void whenRestModeExpectSoapNotInvoked() {
      when(restCall.get()).thenReturn("rest-value");
      MigrationDispatcher dispatcher = new MigrationDispatcher("rest", migrationExecutor);

      dispatcher.dispatch(OPERATION, restCall, soapCall);

      verify(soapCall, never()).get();
    }

    @Test
    void whenRestModeExpectRestCalledOnce() {
      when(restCall.get()).thenReturn("rest-value");
      MigrationDispatcher dispatcher = new MigrationDispatcher("rest", migrationExecutor);

      dispatcher.dispatch(OPERATION, restCall, soapCall);

      verify(restCall, times(1)).get();
    }
  }
}
