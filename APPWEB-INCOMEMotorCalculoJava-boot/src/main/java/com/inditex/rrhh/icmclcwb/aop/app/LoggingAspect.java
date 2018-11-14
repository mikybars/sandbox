package com.inditex.rrhh.icmclcwb.aop.app;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Autowired
    private Logger LOG;

    @Around(value = "execution(public * com.inditex.rrhh.icmclcwb.*.*(..))")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        LOG.info("Inicio :: LoggingAspect.around() :: Method: {}", pjp.getSignature().getName());
        Object retVal = pjp.proceed();
        LOG.info("Fin :: LoggingAspect.around() :: Method: {} :: {}", pjp.getSignature().getName(), retVal);
        return retVal;
    }

    @AfterThrowing(pointcut = "execution(public * com.inditex.rrhh.icmclcwb.*.*(..))", throwing = "e")
    public void afterThrowing(JoinPoint jp, Exception e) {
        LOG.error("LoggingAspect.afterThrowing() :: Method: {}", jp.getSignature().getName());
        LOG.error("LoggingAspect.afterThrowing()", e);
    }

}