package com.inditex.rrhh.icmclcwb.api.app.aop.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface RunProcesoAuditoria {

    boolean logStart() default true;

    boolean logEnd() default true;

    boolean logParams() default true;

    boolean logResult() default false;

    boolean logException() default true;

}