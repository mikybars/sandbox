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
import com.inditex.rrhh.icmclcwb.api.app.run.proceso.dto.RunProcesoDto;
import com.inditex.rrhh.icmclcwb.api.app.proceso.dto.ProcesoDto;

@Aspect
@Component
public class LoggingAspect {

    @Autowired
    private Logger log;

    @Pointcut("@annotation(com.inditex.rrhh.icmclcwb.api.app.aop.annotation.Auditoria)")
    public void auditoriaPointcut() {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Pointcut("@annotation(com.inditex.rrhh.icmclcwb.api.app.aop.annotation.ProcesoAuditoria)")
    public void auditoriaProcesoPointcut() {
        throw new UnsupportedOperationException("Not implemented");
    }
    
    @Pointcut("@annotation(com.inditex.rrhh.icmclcwb.api.app.aop.annotation.RunProcesoAuditoria)")
    public void auditoriaRunProcesoPointcut() {
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

    @Around(value = "auditoriaProcesoPointcut()")
    public Object auditoriaProcesoAround(ProceedingJoinPoint pjp) throws Throwable {
//        ProcesoAuditoria auditoriaProceso = Optional.of(pjp.getSignature())
//                .map(signature -> (MethodSignature) signature).map(MethodSignature::getMethod)
//                .map(method -> method.getAnnotation(ProcesoAuditoria.class))
//                .orElseThrow(() -> new IcmclcwbException("No se ha configurado la anotación ProcesoAuditoria"));
        ProcesoDto proceso = null;
        List<Object> args = Arrays.asList(pjp.getArgs());
        for (Object obj : args) {
            if (ProcesoDto.class.isAssignableFrom(obj.getClass())) {
                proceso = (ProcesoDto) obj;
                break;
            }
        }
        if (proceso == null) {
            throw new IcmclcwbException(
                    "La anotacion ProcesoAuditoria necesita que el metodo tenga un parametro ProcesoDto");
        }
        Instant start = Instant.now();
        if (log.isInfoEnabled()) {
            log.info("Proceso[{}] :: Inicio :: ProcesoAuditoria :: {} :: {} :: {}", proceso.getId(),
                    pjp.getSignature().toShortString(), args, proceso);
        }
        Object result;
        try {
            result = pjp.proceed();
        } catch (Throwable e) {
            if (log.isErrorEnabled()) {
                Instant end = Instant.now();
                String msg = new StringBuilder("Proceso[").append(proceso.getId())
                        .append("] :: Fin :: Error :: ProcesoAuditoria[").append(Duration.between(start, end)).append("] :: ")
                        .append(pjp.getSignature().toShortString()).append(" :: ").append(proceso).toString();
                log.error(msg, e);
            }
            throw e;
        }
        if (log.isInfoEnabled()) {
            Instant end = Instant.now();
            log.info("Proceso[{}] :: Fin :: Ok :: ProcesoAuditoria[{}] :: {} :: {} :: {}", proceso.getId(),
                    Duration.between(start, end), pjp.getSignature().toShortString(), result, proceso);
        }
        return result;
    }
    
    @Around(value = "auditoriaRunProcesoPointcut()")
    public Object auditoriaRunProcesoAround(ProceedingJoinPoint pjp) throws Throwable {
//        RunProcesoAuditoria auditoriaRunProceso = Optional.of(pjp.getSignature())
//                .map(signature -> (MethodSignature) signature).map(MethodSignature::getMethod)
//                .map(method -> method.getAnnotation(ProcesoAuditoria.class))
//                .orElseThrow(() -> new IcmclcwbException("No se ha configurado la anotación RunProcesoAuditoria"));
        RunProcesoDto runProceso = null;
        List<Object> args = Arrays.asList(pjp.getArgs());
        for (Object obj : args) {
            if (RunProcesoDto.class.isAssignableFrom(obj.getClass())) {
                runProceso = (RunProcesoDto) obj;
                break;
            }
        }
        if (runProceso == null) {
            throw new IcmclcwbException(
                    "La anotacion RunProcesoAuditoria necesita que el metodo tenga un parametro RunProcesoDto");
        }
        ProcesoDto proceso = runProceso.getProceso();
        if (proceso == null) {
            throw new IcmclcwbException(
                    "La anotacion RunProcesoAuditoria necesita que el metodo tenga un parametro ProcesoDto");
        }
        Instant start = Instant.now();
        if (log.isInfoEnabled()) {
            log.info("Proceso[{}] :: Inicio :: RunProcesoAuditoria :: {} :: {} :: {}", proceso.getId(),
                    pjp.getSignature().toShortString(), args, proceso);
        }
        Object result;
        try {
            result = pjp.proceed();
        } catch (Throwable e) {
            if (log.isErrorEnabled()) {
                Instant end = Instant.now();
                String msg = new StringBuilder("Proceso[").append(proceso.getId())
                        .append("] :: Fin :: Error :: RunProcesoAuditoria[").append(Duration.between(start, end)).append("] :: ")
                        .append(pjp.getSignature().toShortString()).append(" :: ").append(proceso).toString();
                log.error(msg, e);
            }
            throw e;
        }
        if (log.isInfoEnabled()) {
            Instant end = Instant.now();
            log.info("Proceso[{}] :: Fin :: Ok :: RunProcesoAuditoria[{}] :: {} :: {} :: {}", proceso.getId(),
                    Duration.between(start, end), pjp.getSignature().toShortString(), result, proceso);
        }
        return result;
    }

    @Around(value = "auditoriaPointcut()")
    public Object auditoriaAround(ProceedingJoinPoint pjp) throws Throwable {
//        Auditoria auditoria = Optional.of(pjp.getSignature()).map(signature -> (MethodSignature) signature)
//                .map(MethodSignature::getMethod).map(method -> method.getAnnotation(Auditoria.class))
//                .orElseThrow(() -> new IcmclcwbException("No se ha configurado la anotación ProcesoAuditoria"));
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

    @AfterThrowing(pointcut = "auditoriaPointcut() || auditoriaProcesoPointcut() || controllerPointcut() || servicePointcut() || repositoryPointcut()", throwing = "e")
    public void genericAfterThrowing(JoinPoint jp, Exception e) {
        if (log.isErrorEnabled()) {
            String msg = new StringBuilder("Error :: ").append(jp.getSignature().toShortString()).append(" :: ")
                    .append(Arrays.asList(jp.getArgs())).toString();
            log.error(msg, e);
        }
    }

}