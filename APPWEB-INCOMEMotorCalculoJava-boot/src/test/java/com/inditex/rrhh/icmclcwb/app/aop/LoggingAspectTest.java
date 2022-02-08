package com.inditex.rrhh.icmclcwb.app.aop;

/*
 * Copyright (c) 2021. Inditex
 */

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.lang.reflect.Method;
import java.util.Collections;

import com.inditex.aqsw.framework.test.randomizer.RandomizerExtension;
import com.inditex.rrhh.icmclcwb.api.app.aop.annotation.Auditoria;
import com.inditex.rrhh.icmclcwb.api.app.exception.ValidationReintentoException;
import com.inditex.rrhh.icmclcwb.api.app.exception.WarningException;
import com.inditex.rrhh.icmclcwb.api.app.programacion.dto.ProgramacionDto;
import com.inditex.rrhh.icmclcwb.api.app.run.programacion.dto.RunProgramacionDto;
import com.inditex.rrhh.icmclcwb.config.app.aop.LoggingAspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.reflect.MethodSignature;
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
  LoggingAspect loggingAspect = this.getClassMock();

  @Mock
  JoinPoint jp;

  @Mock
  ProceedingJoinPoint pjp;

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
    final Exception exception = new Exception();
    this.loggingAspect.genericAfterThrowing(this.jp, exception);

    verify(this.loggingAspect, times(1)).genericAfterThrowing(this.jp, exception);
  }

  @Test
  void genericAfterThrowingTest2() {
    final Exception exception = new Exception();
    this.loggingAspect.genericAfterThrowing(this.jp, exception);

    verify(this.loggingAspect, times(1)).genericAfterThrowing(this.jp, exception);
  }

  @Test
  void genericAfterThrowingTest3() {
    doReturn(true).when(this.log).isWarnEnabled();
    final Signature signature = Mockito.mock(Signature.class);
    final Signature spiedSignature = Mockito.spy(signature);
    doReturn(spiedSignature).when(this.jp).getSignature();
    doReturn("").when(spiedSignature).toShortString();
    doReturn(new String[]{"A"}).when(this.jp).getArgs();

    final Exception exception = new WarningException("e", new Throwable());
    this.loggingAspect.genericAfterThrowing(this.jp, exception);

    verify(this.loggingAspect, times(1)).genericAfterThrowing(this.jp, exception);
  }

  @Test
  void genericAfterThrowingTest4() {
    doReturn(false).when(this.log).isWarnEnabled();
    final Exception exception = new Exception("e");
    this.loggingAspect.genericAfterThrowing(this.jp, exception);

    verify(this.loggingAspect, times(1)).genericAfterThrowing(this.jp, exception);
  }

  @Test
  void genericAfterThrowingTest5() {
    doReturn(true).when(this.log).isWarnEnabled();
    final Exception exception = new Exception("e");
    this.loggingAspect.genericAfterThrowing(this.jp, exception);

    verify(this.loggingAspect, times(1)).genericAfterThrowing(this.jp, exception);
  }

  @Test
  void genericAfterThrowingTest6() {
    doReturn(false).when(this.log).isWarnEnabled();
    final Exception exception = new ValidationReintentoException("e", new Throwable());
    this.loggingAspect.genericAfterThrowing(this.jp, exception);

    verify(this.loggingAspect, times(1)).genericAfterThrowing(this.jp, exception);
  }

  @Test
  void genericAroundTest() throws Throwable {
    doReturn(true).when(this.log).isDebugEnabled();

    final Signature signature = Mockito.mock(Signature.class);
    final Signature spiedSignature = Mockito.spy(signature);
    doReturn(spiedSignature).when(this.pjp).getSignature();
    doReturn("").when(spiedSignature).toShortString();
    doReturn(new String[]{"A"}).when(this.pjp).getArgs();

    this.loggingAspect.genericAround(this.pjp);

    verify(this.pjp, times(1)).proceed();
  }

  @Test
  void genericAroundTest2() throws Throwable {
    doReturn(true).when(this.log).isErrorEnabled();

    final Signature signature = Mockito.mock(Signature.class);
    final Signature spiedSignature = Mockito.spy(signature);
    doReturn(spiedSignature).when(this.pjp).getSignature();
    doReturn("").when(spiedSignature).toShortString();
    doReturn(new String[]{"A"}).when(this.pjp).getArgs();

    doThrow(new Throwable()).when(this.pjp).proceed();

    assertThrows(Throwable.class, () -> {
      this.loggingAspect.genericAround(this.pjp);
    });

  }

  @Test
  void genericAroundTest3() throws Throwable {
    doReturn(true).when(this.log).isWarnEnabled();

    final Signature signature = Mockito.mock(Signature.class);
    final Signature spiedSignature = Mockito.spy(signature);
    doReturn(spiedSignature).when(this.pjp).getSignature();
    doReturn("").when(spiedSignature).toShortString();
    doReturn(new String[]{"A"}).when(this.pjp).getArgs();

    doThrow(new WarningException("")).when(this.pjp).proceed();

    assertThrows(WarningException.class, () -> {
      this.loggingAspect.genericAround(this.pjp);
    });

  }

  @Test
  void auditoriaAroundTest() throws Throwable {
    doReturn(true).when(this.log).isDebugEnabled();
    final RunProgramacionDto runProgramacion = new RunProgramacionDto();
    final ProgramacionDto programacion = new ProgramacionDto();
    programacion.setId(1L);
    runProgramacion.setProgramacion(programacion);
    final Signature signature = Mockito.mock(Signature.class);
    final MethodSignature methodSignature = Mockito.mock(MethodSignature.class);
    final Signature spiedSignature = Mockito.spy(signature);
    doReturn(methodSignature).when(this.pjp).getSignature();
    doReturn("").when(methodSignature).toShortString();
    doReturn(new RunProgramacionDto[]{runProgramacion}).when(this.pjp).getArgs();
    doReturn(this.myMethod()).when(methodSignature).getMethod();

    this.loggingAspect.auditoriaAround(this.pjp);

    verify(this.pjp, times(1)).proceed();
  }

  public Method myMethod() throws NoSuchMethodException {
    return this.getClass().getDeclaredMethod("someMethod", RunProgramacionDto.class);
  }

  @Auditoria(logArgs = true)
  public void someMethod(final RunProgramacionDto a) {
  }

}
