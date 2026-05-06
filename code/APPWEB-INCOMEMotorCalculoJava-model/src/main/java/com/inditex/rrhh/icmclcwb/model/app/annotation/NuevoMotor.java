package com.inditex.rrhh.icmclcwb.model.app.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;

/**
 * Marks a component as part of the new calculation engine (facade-based).
 *
 * <p>Components annotated with {@code @NuevoMotor} are only activated when the property {@code app.motor-calculo.nuevo.enabled} is set to
 * {@code true}, meaning the application uses the new calculation engine (REST facade calls, no direct legacy DB access).
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@ConditionalOnProperty(name = "app.motor-calculo.nuevo.enabled", havingValue = "true")
public @interface NuevoMotor {
}
