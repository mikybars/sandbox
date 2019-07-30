package com.inditex.rrhh.icmclcwb.config.app.aop;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CompletionException;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.inditex.rrhh.icmclcwb.api.app.aop.annotation.Auditoria;
import com.inditex.rrhh.icmclcwb.api.app.exception.IcmclcwbException;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.util.ErrorConstants;
import com.inditex.rrhh.icmclcwb.api.app.programacion.dto.ProgramacionDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.programacion.dto.RunProgramacionDto;
import com.inditex.rrhh.icmclcwb.api.app.run.trabajo.dto.RunTrabajoDto;

@Aspect
@Component
public class LoggingAspect {

    @Autowired
    private Logger log;

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
    public Object auditoriaAround(ProceedingJoinPoint pjp) throws Throwable {
        Auditoria auditoria = Optional.of(pjp.getSignature()).map(signature -> (MethodSignature) signature)
                .map(MethodSignature::getMethod).map(method -> method.getAnnotation(Auditoria.class))
                .orElseThrow(() -> new IcmclcwbException("No se ha configurado la anotación Auditoria"));

        List<Object> args = Arrays.asList(pjp.getArgs());
        if (auditoria.logArgs()) {
            List<Class<?>> argsLogClass = Arrays.asList(auditoria.argsLogClass());
            if (CollectionUtils.isNotEmpty(argsLogClass)) {
                List<Object> argsLog = new ArrayList<>();
                for (Object o : args) {
                    for (Class<?> c : argsLogClass) {
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
        for (Object obj : args) {
            Class<? extends Object> objClass = obj.getClass();
            if (RunProgramacionDto.class.isAssignableFrom(objClass)) {
                id = new StringBuilder("Programacion[").append(((RunProgramacionDto) obj).getProgramacion().getId())
                        .append("] :: ").toString();
                break;
            } else if (RunTrabajoDto.class.isAssignableFrom(objClass)) {
                id = new StringBuilder("Trabajo[").append(((RunTrabajoDto) obj).getTrabajo().getId()).append("] :: ")
                        .toString();
                break;
            } else if (RunTareaDto.class.isAssignableFrom(objClass)) {
                id = new StringBuilder("Trabajo[").append(((RunTareaDto) obj).getTarea().getIdTrabajo()).append("]")
                        .append("Tarea[").append(((RunTareaDto) obj).getTarea().getId()).append("] :: ").toString();
                break;
            } else if (ProgramacionDto.class.isAssignableFrom(objClass)) {
                id = new StringBuilder("Programacion[").append(((ProgramacionDto) obj).getId()).append("] :: ")
                        .toString();
                break;
            } else if (TrabajoDto.class.isAssignableFrom(objClass)) {
                id = new StringBuilder("Trabajo[").append(((TrabajoDto) obj).getId()).append("] :: ").toString();
                break;
            } else if (TareaDto.class.isAssignableFrom(objClass)) {
                id = new StringBuilder("Trabajo[").append(((TareaDto) obj).getIdTrabajo()).append("]").append("Tarea[")
                        .append(((TareaDto) obj).getId()).append("] :: ").toString();
                break;
            }
        }
        Instant start = Instant.now();
        if (auditoria.logStart() && log.isInfoEnabled()) {
            log.info(new StringBuilder(id).append("AuditoriaAround :: Inicio :: {}").toString(),
                    pjp.getSignature().toShortString());
        }
        if (auditoria.logArgs() && log.isInfoEnabled()) {
            for (Object o : args) {
                log.info(new StringBuilder(id).append("AuditoriaAround :: Inicio :: Args :: {} :: {}").toString(),
                        pjp.getSignature().toShortString(), o);
            }
        }
        Object result;
        try {
            result = pjp.proceed();
            if (auditoria.logResult() && log.isInfoEnabled()) {
                log.info(new StringBuilder(id).append("AuditoriaAround :: Result[{}] :: {}").toString(), result,
                        pjp.getSignature().toShortString());
            }
        } catch (Throwable e) {
            if (auditoria.logException() && log.isErrorEnabled()) {
                Instant end = Instant.now();
                log.error(new StringBuilder(id).append("AuditoriaAround :: Fin :: Error :: Duration[")
                        .append(Duration.between(start, end)).append("] :: ").append(pjp.getSignature().toShortString())
                        .toString(), e);
                for (Object o : args) {
                    log.error(new StringBuilder(id).append("AuditoriaAround :: Fin :: Error :: Args :: {} :: {}")
                            .toString(), pjp.getSignature().toShortString(), o);
                }
            }
            throw e;
        }
        if (auditoria.logEnd() && log.isInfoEnabled()) {
            Instant end = Instant.now();
            log.info(new StringBuilder(id).append("AuditoriaAround :: Fin :: Ok :: Duration[{}] :: {}").toString(),
                    Duration.between(start, end), pjp.getSignature().toShortString());
        }
        return result;
    }

    @Around(value = "controllerPointcut() || servicePointcut() || repositoryPointcut()")
    public Object genericAround(ProceedingJoinPoint pjp) throws Throwable {
        Instant start = Instant.now();
        if (log.isDebugEnabled()) {
            log.debug("GenericAround :: Inicio :: {} :: {}", pjp.getSignature().toShortString(),
                    Arrays.asList(pjp.getArgs()));
        }
        Object result;
        try {
            result = pjp.proceed();
        } catch (Throwable e) {
            if (log.isErrorEnabled()) {
                Instant end = Instant.now();
                String msg = new StringBuilder("GenericAround :: Fin :: Error :: Duration[")
                        .append(Duration.between(start, end)).append("] :: ").append(pjp.getSignature().toShortString())
                        .toString();
                log.error(msg, e);
            }
            throw e;
        }
        if (log.isDebugEnabled()) {
            log.debug("GenericAround :: Fin :: {} :: {}", pjp.getSignature().toShortString(), result);
        }

        Instant end = Instant.now();
        Duration duration = Duration.between(start, end);
        if (duration.compareTo(Duration.ofSeconds(15)) > 0) {
            log.warn("GenericAround :: Lento :: Duration[{}] :: {}", duration, pjp.getSignature().toShortString());
        }

        return result;
    }

    @AfterThrowing(pointcut = "auditoriaPointcut() || controllerPointcut() || servicePointcut() || repositoryPointcut()", throwing = "e")
    public void genericAfterThrowing(JoinPoint jp, Exception e) {
        if (log.isErrorEnabled() && !(CompletionException.class.equals(e.getClass())
                && CancellationException.class.equals(e.getCause().getClass()))) {
            String msg = new StringBuilder("GenericAfterThrowing :: Error :: ")
                    .append(jp.getSignature().toShortString()).append(" :: ").append(Arrays.asList(jp.getArgs()))
                    .toString();
            log.error(msg, e);
        }
    }

}