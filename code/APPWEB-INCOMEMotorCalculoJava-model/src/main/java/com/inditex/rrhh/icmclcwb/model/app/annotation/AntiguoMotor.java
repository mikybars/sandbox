package com.inditex.rrhh.icmclcwb.model.app.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;

/**
 * Marks a component as part of the legacy calculation engine (direct JDBC access).
 *
 * <p>Components annotated with {@code @AntiguoMotor} are only activated when the property {@code app.motor-calculo.nuevo.enabled} is set to
 * {@code false} or is absent, meaning the application uses the legacy calculation engine (direct JDBC to DB2, Oracle, SQL Server).
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@ConditionalOnProperty(name = "app.motor-calculo.nuevo.enabled", havingValue = "false", matchIfMissing = true)
public @interface AntiguoMotor {
}
