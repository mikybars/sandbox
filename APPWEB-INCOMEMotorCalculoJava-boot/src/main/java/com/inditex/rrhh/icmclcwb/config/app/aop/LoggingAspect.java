package com.inditex.rrhh.icmclcwb.config.app.aop;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

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

import com.inditex.aqsw.framework.common.core.exception.ApplicationException;
import com.inditex.rrhh.icmclcwb.api.app.aop.annotation.Auditoria;
import com.inditex.rrhh.icmclcwb.api.app.aop.annotation.AuditoriaTrabajo;
import com.inditex.rrhh.icmclcwb.api.app.dto.TrabajoDto;

@Aspect
@Component
public class LoggingAspect {

    @Autowired
    private Logger LOG;

    @Pointcut("@annotation(com.inditex.rrhh.icmclcwb.config.app.aop.annotation.Auditoria)")
    public void auditoriaPointcut() {
        throw new UnsupportedOperationException();
    }

    @Pointcut("@annotation(com.inditex.rrhh.icmclcwb.config.app.aop.annotation.AuditoriaTrabajo)")
    public void auditoriaTrabajoPointcut() {
        throw new UnsupportedOperationException();
    }

    @Pointcut(value = "within(com.inditex.rrhh.icmclcwb..service..*)")
    public void servicePointcut() {
        throw new UnsupportedOperationException();
    }

    @Pointcut(value = "within(com.inditex.rrhh.icmclcwb..controller..*)")
    public void controllerPointcut() {
        throw new UnsupportedOperationException();
    }

    @Pointcut(value = "within(com.inditex.rrhh.icmclcwb..repository..*)")
    public void repositoryPointcut() {
        throw new UnsupportedOperationException();
    }

    @Around(value = "auditoriaTrabajoPointcut()")
    public Object auditoriaTrabajoAround(ProceedingJoinPoint pjp) throws Throwable {
        AuditoriaTrabajo auditoriaTrabajo = Optional.of(pjp.getSignature())
                .map(signature -> (MethodSignature) signature).map(MethodSignature::getMethod)
                .map(method -> method.getAnnotation(AuditoriaTrabajo.class))
                .orElseThrow(() -> new ApplicationException("No se ha configurado la anotación AuditoriaTrabajo"));
        TrabajoDto trabajo = null;
        List<Object> args = Arrays.asList(pjp.getArgs());
        for (Object obj : args) {
            if (TrabajoDto.class.isAssignableFrom(obj.getClass())) {
                trabajo = (TrabajoDto) obj;
                break;
            }
        }
        if (trabajo == null) {
            throw new ApplicationException(
                    "La anotacion AuditoriaTrabajo necesita que el metodo tenga un parametro TrabajoDto");
        }
        Instant start = Instant.now();
        LOG.info("Trabajo[{}] :: Inicio :: Auditoria :: {} :: {} :: {}", trabajo.getId(),
                pjp.getSignature().toShortString(), args, trabajo);
        Object result;
        try {
            result = pjp.proceed();
        } catch (Throwable e) {
            Instant end = Instant.now();
            LOG.error("Trabajo[{}] :: Fin :: Error :: Auditoria[{}] :: {} :: {}", trabajo.getId(),
                    Duration.between(start, end), pjp.getSignature().toShortString(), trabajo);
            throw e;
        }
        Instant end = Instant.now();
        LOG.info("Trabajo[{}] :: Fin :: Ok :: Auditoria[{}] :: {} :: {} :: {}", trabajo.getId(),
                Duration.between(start, end), pjp.getSignature().toShortString(), result, trabajo);
        return result;
    }

    @Around(value = "auditoriaPointcut()")
    public Object auditoriaAround(ProceedingJoinPoint pjp) throws Throwable {
        Auditoria auditoria = Optional.of(pjp.getSignature()).map(signature -> (MethodSignature) signature)
                .map(MethodSignature::getMethod).map(method -> method.getAnnotation(Auditoria.class))
                .orElseThrow(() -> new ApplicationException("No se ha configurado la anotación AuditoriaTrabajo"));
        List<Object> args = Arrays.asList(pjp.getArgs());
        Instant start = Instant.now();
        LOG.debug("Inicio :: Auditoria :: {} :: {}", pjp.getSignature().toShortString(), args);
        Object result;
        try {
            result = pjp.proceed();
        } catch (Throwable e) {
            Instant end = Instant.now();
            LOG.error("Fin :: Error :: Auditoria {} :: {}", Duration.between(start, end),
                    pjp.getSignature().toShortString());
            throw e;
        }
        Instant end = Instant.now();
        LOG.debug("Fin :: Ok :: Auditoria {} :: {} :: {}", Duration.between(start, end),
                pjp.getSignature().toShortString(), result);
        return result;
    }

    @Around(value = "controllerPointcut() || servicePointcut() || repositoryPointcut()")
    public Object genericAround(ProceedingJoinPoint pjp) throws Throwable {
        LOG.debug("Inicio :: {} :: {}", pjp.getSignature().toShortString(), Arrays.asList(pjp.getArgs()));
        Object result = pjp.proceed();
        LOG.debug("Fin :: {} :: {}", pjp.getSignature().toShortString(), result);
        return result;
    }

    @AfterThrowing(pointcut = "auditoriaPointcut() || auditoriaTrabajoPointcut() || controllerPointcut() || servicePointcut() || repositoryPointcut()", throwing = "e")
    public void genericAfterThrowing(JoinPoint jp, Exception e) {
        String msg = new StringBuilder("Error :: ").append(jp.getSignature().toShortString()).append(" :: ")
                .append(Arrays.asList(jp.getArgs())).toString();
        LOG.error(msg);
    }

}