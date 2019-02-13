package com.inditex.rrhh.icmclcwb.config.app.aop;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.inditex.rrhh.icmclcwb.api.app.exception.IcmclcwbException;
import com.inditex.rrhh.icmclcwb.api.app.run.dto.RunTrabajoDto;
import com.inditex.rrhh.icmclcwb.api.app.trabajo.dto.TrabajoDto;

@Aspect
@Component
public class LoggingAspect {

    @Autowired
    private Logger log;

    @Pointcut("@annotation(com.inditex.rrhh.icmclcwb.api.app.aop.annotation.Auditoria)")
    public void auditoriaPointcut() {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Pointcut("@annotation(com.inditex.rrhh.icmclcwb.api.app.aop.annotation.TrabajoAuditoria)")
    public void auditoriaTrabajoPointcut() {
        throw new UnsupportedOperationException("Not implemented");
    }
    
    @Pointcut("@annotation(com.inditex.rrhh.icmclcwb.api.app.aop.annotation.RunTrabajoAuditoria)")
    public void auditoriaRunTrabajoPointcut() {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Pointcut(value = "within(com.inditex.rrhh.icmclcwb..service..*)")
    public void servicePointcut() {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Pointcut(value = "within(com.inditex.rrhh.icmclcwb..controller..*)")
    public void controllerPointcut() {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Pointcut(value = "within(com.inditex.rrhh.icmclcwb..repository..*)")
    public void repositoryPointcut() {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Around(value = "auditoriaTrabajoPointcut()")
    public Object auditoriaTrabajoAround(ProceedingJoinPoint pjp) throws Throwable {
//        TrabajoAuditoria auditoriaTrabajo = Optional.of(pjp.getSignature())
//                .map(signature -> (MethodSignature) signature).map(MethodSignature::getMethod)
//                .map(method -> method.getAnnotation(TrabajoAuditoria.class))
//                .orElseThrow(() -> new IcmclcwbException("No se ha configurado la anotación TrabajoAuditoria"));
        TrabajoDto trabajo = null;
        List<Object> args = Arrays.asList(pjp.getArgs());
        for (Object obj : args) {
            if (TrabajoDto.class.isAssignableFrom(obj.getClass())) {
                trabajo = (TrabajoDto) obj;
                break;
            }
        }
        if (trabajo == null) {
            throw new IcmclcwbException(
                    "La anotacion TrabajoAuditoria necesita que el metodo tenga un parametro TrabajoDto");
        }
        Instant start = Instant.now();
        if (log.isInfoEnabled()) {
            log.info("Trabajo[{}] :: Inicio :: TrabajoAuditoria :: {} :: {} :: {}", trabajo.getId(),
                    pjp.getSignature().toShortString(), args, trabajo);
        }
        Object result;
        try {
            result = pjp.proceed();
        } catch (Throwable e) {
            if (log.isErrorEnabled()) {
                Instant end = Instant.now();
                String msg = new StringBuilder("Trabajo[").append(trabajo.getId())
                        .append("] :: Fin :: Error :: TrabajoAuditoria[").append(Duration.between(start, end)).append("] :: ")
                        .append(pjp.getSignature().toShortString()).append(" :: ").append(trabajo).toString();
                log.error(msg, e);
            }
            throw e;
        }
        if (log.isInfoEnabled()) {
            Instant end = Instant.now();
            log.info("Trabajo[{}] :: Fin :: Ok :: TrabajoAuditoria[{}] :: {} :: {} :: {}", trabajo.getId(),
                    Duration.between(start, end), pjp.getSignature().toShortString(), result, trabajo);
        }
        return result;
    }
    
    @Around(value = "auditoriaRunTrabajoPointcut()")
    public Object auditoriaRunTrabajoAround(ProceedingJoinPoint pjp) throws Throwable {
//        RunTrabajoAuditoria auditoriaRunTrabajo = Optional.of(pjp.getSignature())
//                .map(signature -> (MethodSignature) signature).map(MethodSignature::getMethod)
//                .map(method -> method.getAnnotation(TrabajoAuditoria.class))
//                .orElseThrow(() -> new IcmclcwbException("No se ha configurado la anotación RunTrabajoAuditoria"));
        RunTrabajoDto trabajoRun = null;
        List<Object> args = Arrays.asList(pjp.getArgs());
        for (Object obj : args) {
            if (RunTrabajoDto.class.isAssignableFrom(obj.getClass())) {
                trabajoRun = (RunTrabajoDto) obj;
                break;
            }
        }
        if (trabajoRun == null) {
            throw new IcmclcwbException(
                    "La anotacion RunTrabajoAuditoria necesita que el metodo tenga un parametro RunTrabajoDto");
        }
        TrabajoDto trabajo = trabajoRun.getTrabajoDto();
        if (trabajo == null) {
            throw new IcmclcwbException(
                    "La anotacion RunTrabajoAuditoria necesita que el metodo tenga un parametro TrabajoDto");
        }
        Instant start = Instant.now();
        if (log.isInfoEnabled()) {
            log.info("Trabajo[{}] :: Inicio :: RunTrabajoAuditoria :: {} :: {} :: {}", trabajo.getId(),
                    pjp.getSignature().toShortString(), args, trabajo);
        }
        Object result;
        try {
            result = pjp.proceed();
        } catch (Throwable e) {
            if (log.isErrorEnabled()) {
                Instant end = Instant.now();
                String msg = new StringBuilder("Trabajo[").append(trabajo.getId())
                        .append("] :: Fin :: Error :: RunTrabajoAuditoria[").append(Duration.between(start, end)).append("] :: ")
                        .append(pjp.getSignature().toShortString()).append(" :: ").append(trabajo).toString();
                log.error(msg, e);
            }
            throw e;
        }
        if (log.isInfoEnabled()) {
            Instant end = Instant.now();
            log.info("Trabajo[{}] :: Fin :: Ok :: RunTrabajoAuditoria[{}] :: {} :: {} :: {}", trabajo.getId(),
                    Duration.between(start, end), pjp.getSignature().toShortString(), result, trabajo);
        }
        return result;
    }

    @Around(value = "auditoriaPointcut()")
    public Object auditoriaAround(ProceedingJoinPoint pjp) throws Throwable {
//        Auditoria auditoria = Optional.of(pjp.getSignature()).map(signature -> (MethodSignature) signature)
//                .map(MethodSignature::getMethod).map(method -> method.getAnnotation(Auditoria.class))
//                .orElseThrow(() -> new IcmclcwbException("No se ha configurado la anotación TrabajoAuditoria"));
        Instant start = Instant.now();
        if (log.isInfoEnabled()) {
            List<Object> args = Arrays.asList(pjp.getArgs());
            log.info("Inicio :: Auditoria :: {} :: {}", pjp.getSignature().toShortString(), args);
        }
        Object result;
        try {
            result = pjp.proceed();
        } catch (Throwable e) {
            if (log.isErrorEnabled()) {
                Instant end = Instant.now();
                String msg = new StringBuilder("Fin :: Error :: Auditoria[").append(Duration.between(start, end))
                        .append("] :: ").append(pjp.getSignature().toShortString()).toString();
                log.error(msg, e);
            }
            throw e;
        }
        if (log.isInfoEnabled()) {
            Instant end = Instant.now();
            log.info("Fin :: Ok :: Auditoria[{}] :: {} :: {}", Duration.between(start, end),
                    pjp.getSignature().toShortString(), result);
        }
        return result;
    }

    @Around(value = "controllerPointcut() || servicePointcut() || repositoryPointcut()")
    public Object genericAround(ProceedingJoinPoint pjp) throws Throwable {
        Instant start = Instant.now();
        if (log.isDebugEnabled()) {
            log.debug("Inicio :: {} :: {}", pjp.getSignature().toShortString(), Arrays.asList(pjp.getArgs()));
        }
        Object result;
        try {
            result = pjp.proceed();
        } catch (Throwable e) {
            if (log.isErrorEnabled()) {
                Instant end = Instant.now();
                String msg = new StringBuilder("Fin :: Error :: Generic[").append(Duration.between(start, end))
                        .append("] :: ").append(pjp.getSignature().toShortString()).toString();
                log.error(msg, e);
            }
            throw e;
        }
        if (log.isDebugEnabled()) {
            log.debug("Fin :: {} :: {}", pjp.getSignature().toShortString(), result);
        }
        
        Instant end = Instant.now();
        Duration duration = Duration.between(start, end);
        if (duration.compareTo(Duration.ofSeconds(15)) > 0) {
            log.warn("Lento[{}] :: {} :: {}", duration, pjp.getSignature().toShortString(), result);
        }
        
        return result;
    }

    @AfterThrowing(pointcut = "auditoriaPointcut() || auditoriaTrabajoPointcut() || controllerPointcut() || servicePointcut() || repositoryPointcut()", throwing = "e")
    public void genericAfterThrowing(JoinPoint jp, Exception e) {
        if (log.isErrorEnabled()) {
            String msg = new StringBuilder("Error :: ").append(jp.getSignature().toShortString()).append(" :: ")
                    .append(Arrays.asList(jp.getArgs())).toString();
            log.error(msg, e);
        }
    }

}