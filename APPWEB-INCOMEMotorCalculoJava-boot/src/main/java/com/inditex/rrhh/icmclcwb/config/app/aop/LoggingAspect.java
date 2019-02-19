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
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;

@Aspect
@Component
public class LoggingAspect {

    @Autowired
    private Logger log;

    @Pointcut("@annotation(com.inditex.rrhh.icmclcwb.api.app.aop.annotation.Auditoria)")
    public void auditoriaPointcut() {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Pointcut("@annotation(com.inditex.rrhh.icmclcwb.api.app.aop.annotation.TareaAuditoria)")
    public void auditoriaTareaPointcut() {
        throw new UnsupportedOperationException("Not implemented");
    }
    
    @Pointcut("@annotation(com.inditex.rrhh.icmclcwb.api.app.aop.annotation.RunTareaAuditoria)")
    public void auditoriaRunTareaPointcut() {
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

    @Around(value = "auditoriaTareaPointcut()")
    public Object auditoriaTareaAround(ProceedingJoinPoint pjp) throws Throwable {
//        TareaAuditoria auditoriaTarea = Optional.of(pjp.getSignature())
//                .map(signature -> (MethodSignature) signature).map(MethodSignature::getMethod)
//                .map(method -> method.getAnnotation(TareaAuditoria.class))
//                .orElseThrow(() -> new IcmclcwbException("No se ha configurado la anotación TareaAuditoria"));
        TareaDto tarea = null;
        List<Object> args = Arrays.asList(pjp.getArgs());
        for (Object obj : args) {
            if (TareaDto.class.isAssignableFrom(obj.getClass())) {
                tarea = (TareaDto) obj;
                break;
            }
        }
        if (tarea == null) {
            throw new IcmclcwbException(
                    "La anotacion TareaAuditoria necesita que el metodo tenga un parametro TareaDto");
        }
        Instant start = Instant.now();
        if (log.isInfoEnabled()) {
            log.info("Tarea[{}] :: Inicio :: TareaAuditoria :: {} :: {} :: {}", tarea.getId(),
                    pjp.getSignature().toShortString(), args, tarea);
        }
        Object result;
        try {
            result = pjp.proceed();
        } catch (Throwable e) {
            if (log.isErrorEnabled()) {
                Instant end = Instant.now();
                String msg = new StringBuilder("Tarea[").append(tarea.getId())
                        .append("] :: Fin :: Error :: TareaAuditoria[").append(Duration.between(start, end)).append("] :: ")
                        .append(pjp.getSignature().toShortString()).append(" :: ").append(tarea).toString();
                log.error(msg, e);
            }
            throw e;
        }
        if (log.isInfoEnabled()) {
            Instant end = Instant.now();
            log.info("Tarea[{}] :: Fin :: Ok :: TareaAuditoria[{}] :: {} :: {} :: {}", tarea.getId(),
                    Duration.between(start, end), pjp.getSignature().toShortString(), result, tarea);
        }
        return result;
    }
    
    @Around(value = "auditoriaRunTareaPointcut()")
    public Object auditoriaRunTareaAround(ProceedingJoinPoint pjp) throws Throwable {
//        RunTareaAuditoria auditoriaRunTarea = Optional.of(pjp.getSignature())
//                .map(signature -> (MethodSignature) signature).map(MethodSignature::getMethod)
//                .map(method -> method.getAnnotation(TareaAuditoria.class))
//                .orElseThrow(() -> new IcmclcwbException("No se ha configurado la anotación RunTareaAuditoria"));
        RunTareaDto runTarea = null;
        List<Object> args = Arrays.asList(pjp.getArgs());
        for (Object obj : args) {
            if (RunTareaDto.class.isAssignableFrom(obj.getClass())) {
                runTarea = (RunTareaDto) obj;
                break;
            }
        }
        if (runTarea == null) {
            throw new IcmclcwbException(
                    "La anotacion RunTareaAuditoria necesita que el metodo tenga un parametro RunTareaDto");
        }
        TareaDto tarea = runTarea.getTarea();
        if (tarea == null) {
            throw new IcmclcwbException(
                    "La anotacion RunTareaAuditoria necesita que el metodo tenga un parametro TareaDto");
        }
        Instant start = Instant.now();
        if (log.isInfoEnabled()) {
            log.info("Tarea[{}] :: Inicio :: RunTareaAuditoria :: {} :: {} :: {}", tarea.getId(),
                    pjp.getSignature().toShortString(), args, tarea);
        }
        Object result;
        try {
            result = pjp.proceed();
        } catch (Throwable e) {
            if (log.isErrorEnabled()) {
                Instant end = Instant.now();
                String msg = new StringBuilder("Tarea[").append(tarea.getId())
                        .append("] :: Fin :: Error :: RunTareaAuditoria[").append(Duration.between(start, end)).append("] :: ")
                        .append(pjp.getSignature().toShortString()).append(" :: ").append(tarea).toString();
                log.error(msg, e);
            }
            throw e;
        }
        if (log.isInfoEnabled()) {
            Instant end = Instant.now();
            log.info("Tarea[{}] :: Fin :: Ok :: RunTareaAuditoria[{}] :: {} :: {} :: {}", tarea.getId(),
                    Duration.between(start, end), pjp.getSignature().toShortString(), result, tarea);
        }
        return result;
    }

    @Around(value = "auditoriaPointcut()")
    public Object auditoriaAround(ProceedingJoinPoint pjp) throws Throwable {
//        Auditoria auditoria = Optional.of(pjp.getSignature()).map(signature -> (MethodSignature) signature)
//                .map(MethodSignature::getMethod).map(method -> method.getAnnotation(Auditoria.class))
//                .orElseThrow(() -> new IcmclcwbException("No se ha configurado la anotación TareaAuditoria"));
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

    @AfterThrowing(pointcut = "auditoriaPointcut() || auditoriaTareaPointcut() || controllerPointcut() || servicePointcut() || repositoryPointcut()", throwing = "e")
    public void genericAfterThrowing(JoinPoint jp, Exception e) {
        if (log.isErrorEnabled()) {
            String msg = new StringBuilder("Error :: ").append(jp.getSignature().toShortString()).append(" :: ")
                    .append(Arrays.asList(jp.getArgs())).toString();
            log.error(msg, e);
        }
    }

}