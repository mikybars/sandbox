package com.inditex.rrhh.icmclcwb.config.app.aop;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CompletionException;

import com.inditex.rrhh.icmclcwb.api.app.aop.annotation.Auditoria;
import com.inditex.rrhh.icmclcwb.api.app.exception.IcmclcwbException;
import com.inditex.rrhh.icmclcwb.api.app.exception.WarningException;
import com.inditex.rrhh.icmclcwb.api.app.programacion.dto.ProgramacionDto;
import com.inditex.rrhh.icmclcwb.api.app.run.limpieza.dto.RunLimpiezaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.programacion.dto.RunProgramacionDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.trabajo.dto.RunTrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.util.ErrorConstants;
import com.inditex.rrhh.icmclcwb.model.app.util.CollectionUtils;

import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

  private static final Logger LOG = LoggerFactory.getLogger(LoggingAspect.class);

  @Pointcut("@annotation(com.inditex.rrhh.icmclcwb.api.app.aop.annotation.Auditoria)")
  public void auditoriaPointcut() {
    throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
  }

  @Pointcut(value = "within(com.inditex.rrhh.icmclcwb..service..*)")
  public void servicePointcut() {
    throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
  }

  @Pointcut(value = "within(com.inditex.rrhh.icmclcwb..controller..*)")
  public void controllerPointcut() {
    throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
  }

  @Pointcut(value = "within(com.inditex.rrhh.icmclcwb..repository..*)")
  public void repositoryPointcut() {
    throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
  }

  @Around(value = "auditoriaPointcut()")
  public Object auditoriaAround(final ProceedingJoinPoint pjp) throws Throwable {
    final Auditoria auditoria = Optional.of(pjp.getSignature())
        .map(signature -> (MethodSignature) signature)
        .map(MethodSignature::getMethod)
        .map(method -> method.getAnnotation(Auditoria.class))
        .orElseThrow(() -> new IcmclcwbException("No se ha configurado la anotación Auditoria"));

    List<Object> args = Arrays.asList(pjp.getArgs());
    if (auditoria.logArgs()) {
      final List<Class<?>> argsLogClass = Arrays.asList(auditoria.argsLogClass());
      if (CollectionUtils.isNotEmpty(argsLogClass)) {
        final List<Object> argsLog = new ArrayList<>();
        for (final Object o : args) {
          for (final Class<?> c : argsLogClass) {
            if (c.isAssignableFrom(o.getClass())) {
              argsLog.add(o);
              break;
            }
          }
        }
        args = argsLog;
      }
    }

    String id = StringUtils.EMPTY;
    for (final Object obj : args) {
      final Class<? extends Object> objClass = obj.getClass();
      if (RunProgramacionDto.class.isAssignableFrom(objClass)) {
        id = new StringBuilder("Programacion[").append(((RunProgramacionDto) obj).getProgramacion().getId())
            .append("] :: ")
            .toString();
        break;
      } else if (RunTrabajoDto.class.isAssignableFrom(objClass)) {
        id = new StringBuilder("Trabajo[").append(((RunTrabajoDto) obj).getTrabajo().getId())
            .append("] :: ")
            .toString();
        break;
      } else if (RunTareaDto.class.isAssignableFrom(objClass)) {
        id = new StringBuilder("Trabajo[").append(((RunTareaDto) obj).getTarea().getIdTrabajo())
            .append("]")
            .append("Tarea[")
            .append(((RunTareaDto) obj).getTarea().getId())
            .append("] :: ")
            .toString();
        break;
      } else if (ProgramacionDto.class.isAssignableFrom(objClass)) {
        id = new StringBuilder("Programacion[").append(((ProgramacionDto) obj).getId())
            .append("] :: ")
            .toString();
        break;
      } else if (TrabajoDto.class.isAssignableFrom(objClass)) {
        id = new StringBuilder("Trabajo[").append(((TrabajoDto) obj).getId()).append("] :: ").toString();
        break;
      } else if (TareaDto.class.isAssignableFrom(objClass)) {
        id = new StringBuilder("Trabajo[").append(((TareaDto) obj).getIdTrabajo())
            .append("]")
            .append("Tarea[")
            .append(((TareaDto) obj).getId())
            .append("] :: ")
            .toString();
        break;
      } else if (RunLimpiezaDto.class.isAssignableFrom(objClass)) {
        id = new StringBuilder("Limpieza[]Tarea[").append(((RunLimpiezaDto) obj).getTarea().getId())
            .append("] :: ")
            .toString();
        break;
      }
    }
    final Instant start = Instant.now();
    if (auditoria.logStart() && LoggingAspect.LOG.isInfoEnabled()) {
      LoggingAspect.LOG.info(new StringBuilder(id).append("AuditoriaAround :: Inicio :: {}").toString(),
          pjp.getSignature().toShortString());
    }
    if (auditoria.logArgs() && LoggingAspect.LOG.isInfoEnabled()) {
      for (final Object o : args) {
        LoggingAspect.LOG.info(new StringBuilder(id).append("AuditoriaAround :: Inicio :: Args :: {} :: {}").toString(),
            pjp.getSignature().toShortString(), o);
      }
    }
    Object result = null;
    try {
      result = pjp.proceed();
      if (auditoria.logResult() && LoggingAspect.LOG.isInfoEnabled()) {
        LoggingAspect.LOG.info(new StringBuilder(id).append("AuditoriaAround :: Result[{}] :: {}").toString(), result,
            pjp.getSignature().toShortString());
      }
    } catch (final Throwable e) {
      if (auditoria.logException() && e instanceof WarningException && LoggingAspect.LOG.isWarnEnabled()) {
        final Instant end = Instant.now();
        final String msg = new StringBuilder(id).append("AuditoriaAround :: Fin :: Warn :: Duration[")
            .append(Duration.between(start, end))
            .append("] :: ")
            .append(pjp.getSignature().toShortString())
            .toString();
        LoggingAspect.LOG.warn(msg, e);
      } else if (auditoria.logException() && LoggingAspect.LOG.isErrorEnabled()) {
        final Instant end = Instant.now();
        LoggingAspect.LOG.error(new StringBuilder(id).append("AuditoriaAround :: Fin :: Error :: Duration[")
            .append(Duration.between(start, end))
            .append("] :: ")
            .append(pjp.getSignature().toShortString())
            .toString(), e);
        for (final Object o : args) {
          LoggingAspect.LOG.error(new StringBuilder(id).append("AuditoriaAround :: Fin :: Error :: Args :: {} :: {}")
              .toString(), pjp.getSignature().toShortString(), o);
        }
      }
      throw e;
    }
    if (auditoria.logEnd() && LoggingAspect.LOG.isInfoEnabled()) {
      final Instant end = Instant.now();
      LoggingAspect.LOG.info(new StringBuilder(id).append("AuditoriaAround :: Fin :: Ok :: Duration[{}] :: {}").toString(),
          Duration.between(start, end), pjp.getSignature().toShortString());
    }
    return result;
  }

  @Around(value = "controllerPointcut() || servicePointcut() || repositoryPointcut()")
  public Object genericAround(final ProceedingJoinPoint pjp) throws Throwable {
    final Instant start = Instant.now();
    if (LoggingAspect.LOG.isDebugEnabled()) {
      LoggingAspect.LOG.debug("GenericAround :: Inicio :: {} :: {}", pjp.getSignature().toShortString(),
          Arrays.asList(pjp.getArgs()));
    }
    Object result = null;
    try {
      result = pjp.proceed();
    } catch (final Throwable e) {
      if (e instanceof WarningException && LoggingAspect.LOG.isWarnEnabled()) {
        final Instant end = Instant.now();
        final String msg = new StringBuilder("GenericAround :: Fin :: Warn :: Duration[")
            .append(Duration.between(start, end))
            .append("] :: ")
            .append(pjp.getSignature().toShortString())
            .toString();
        LoggingAspect.LOG.warn(msg, e);
      } else if (!(e instanceof WarningException) && LoggingAspect.LOG.isErrorEnabled()) {
        final Instant end = Instant.now();
        final String msg = new StringBuilder("GenericAround :: Fin :: Error :: Duration[")
            .append(Duration.between(start, end))
            .append("] :: ")
            .append(pjp.getSignature().toShortString())
            .toString();
        LoggingAspect.LOG.error(msg, e);
      }
      throw e;
    }
    if (LoggingAspect.LOG.isDebugEnabled()) {
      LoggingAspect.LOG.debug("GenericAround :: Fin :: {} :: {}", pjp.getSignature().toShortString(), result);
    }

    final Instant end = Instant.now();
    final Duration duration = Duration.between(start, end);
    if (duration.compareTo(Duration.ofSeconds(60)) > 0) {
      LoggingAspect.LOG.warn("GenericAround :: Lento :: Lento60 :: Duration[{}] :: {}", duration,
          pjp.getSignature().toShortString());
    } else if (duration.compareTo(Duration.ofSeconds(30)) > 0) {
      LoggingAspect.LOG.warn("GenericAround :: Lento :: Lento30 :: Duration[{}] :: {}", duration,
          pjp.getSignature().toShortString());
    } else if (duration.compareTo(Duration.ofSeconds(15)) > 0) {
      LoggingAspect.LOG.warn("GenericAround :: Lento :: Lento15 :: Duration[{}] :: {}", duration,
          pjp.getSignature().toShortString());
    }

    return result;
  }

  @AfterThrowing(
      pointcut = "auditoriaPointcut() || controllerPointcut() || servicePointcut() || repositoryPointcut()",
      throwing = "e")
  public void genericAfterThrowing(final JoinPoint jp, final Exception e) {
    if (!(CompletionException.class.equals(e.getClass())
        && CancellationException.class.equals(e.getCause().getClass()))) {

      if (e instanceof WarningException && LoggingAspect.LOG.isWarnEnabled()) {
        final String msg = new StringBuilder("GenericAfterThrowing :: Warn :: ")
            .append(jp.getSignature().toShortString())
            .append(" :: ")
            .append(Arrays.asList(jp.getArgs()))
            .toString();
        LoggingAspect.LOG.warn(msg, e);
      } else if (!(e instanceof WarningException) && LoggingAspect.LOG.isErrorEnabled()) {
        final String msg = new StringBuilder("GenericAfterThrowing :: Error :: ")
            .append(jp.getSignature().toShortString())
            .append(" :: ")
            .append(Arrays.asList(jp.getArgs()))
            .toString();
        LoggingAspect.LOG.error(msg, e);
      }
    }
  }

}
