package com.inditex.rrhh.icmclcwb.app.aop;

/*
 * Copyright (c) 2021. Inditex
 */
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.Collections;

import com.inditex.aqsw.framework.test.randomizer.RandomizerExtension;
import com.inditex.rrhh.icmclcwb.config.app.aop.LoggingAspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith({SpringExtension.class, RandomizerExtension.class})
class LoggingAspectTest {

  @Mock
  Logger log;

  @InjectMocks
  LoggingAspect loggingAspect = getClassMock();

  @Mock
  JoinPoint jp;

  @Mock
  Signature signature;

  private LoggingAspect getClassMock() {
    return Mockito.mock(LoggingAspect.class, Mockito.CALLS_REAL_METHODS);
  }

  @Test
  void auditoriaPointcutTest() {
    assertThrows(UnsupportedOperationException.class, () -> {
      this.loggingAspect.auditoriaPointcut();
    });
  }

  @Test
  void servicePointcutTest() {
    assertThrows(UnsupportedOperationException.class, () -> {
      this.loggingAspect.servicePointcut();
    });
  }

  @Test
  void controllerPointcutTest() {
    assertThrows(UnsupportedOperationException.class, () -> {
      this.loggingAspect.controllerPointcut();
    });
  }

  @Test
  void repositoryPointcutTest() {
    assertThrows(UnsupportedOperationException.class, () -> {
      this.loggingAspect.repositoryPointcut();
    });
  }

  @Test
  void genericAfterThrowingTest() {
    doReturn(true).when(this.log).isErrorEnabled();
    doReturn(this.signature).when(this.jp).getSignature();
    doReturn("").when(this.signature).toShortString();
    doReturn(Collections.emptyList().toArray()).when(this.jp).getArgs();
    Exception exception = new Exception();
    this.loggingAspect.genericAfterThrowing(this.jp, exception);

    verify(this.loggingAspect, times(1)).genericAfterThrowing(this.jp, exception);
  }

  @Test
  void genericAfterThrowingTest2() {
    Exception exception = new Exception();
    this.loggingAspect.genericAfterThrowing(this.jp, exception);

    verify(this.loggingAspect, times(1)).genericAfterThrowing(this.jp, exception);
  }

}
