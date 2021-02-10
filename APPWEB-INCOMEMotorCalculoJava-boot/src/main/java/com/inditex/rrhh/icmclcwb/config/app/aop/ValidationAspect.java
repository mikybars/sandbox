/**
 *
 */
package com.inditex.rrhh.icmclcwb.config.app.aop;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.validation.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.inditex.rrhh.icmclcwb.api.app.aop.annotation.Validation;
import com.inditex.rrhh.icmclcwb.api.app.dto.ValidacionDto;
import com.inditex.rrhh.icmclcwb.api.app.exception.IcmclcwbException;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.service.RunTareaPrevalidarAntesService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.service.RunTareaPrevalidarDespuesService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.EstadoTareaFaseAccionEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.FaseEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.AccionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.FaseDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaFaseAccionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.AccionService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaFaseAccionService;
import com.inditex.rrhh.icmclcwb.api.app.util.ErrorConstants;
import com.inditex.rrhh.icmclcwb.ms.app.tarea.SenderTarea;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

@Aspect
@Component
public class ValidationAspect {

    @Autowired
    private RunTareaPrevalidarAntesService runTareaPrevalidarAntesService;

    @Autowired
    private RunTareaPrevalidarDespuesService runTareaPrevalidarDespuesService;

    @Autowired
    private TareaFaseAccionService tareaFaseAccionService;

    @Autowired
    private AccionService accionService;

    @Autowired
    private SenderTarea senderTarea;

    @Pointcut("@annotation(com.inditex.rrhh.icmclcwb.api.app.aop.annotation.Validation)")
    public void validationPointcut() {
        throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
    }

    @Before(value = "validationPointcut()")
    public Object validationBefore(final JoinPoint pjp) {
        final Validation validation = Optional.of(pjp.getSignature())
            .map(signature -> (MethodSignature) signature)
            .map(MethodSignature::getMethod)
            .map(method -> method.getAnnotation(Validation.class))
            .orElseThrow(() -> new IcmclcwbException("No se ha configurado la anotación Validation"));

        final List<Object> args = Arrays.asList(pjp.getArgs());
        for (final Object obj : args) {
            final Class<? extends Object> objClass = obj.getClass();
            if (RunTareaDto.class.isAssignableFrom(objClass)) {
                final RunTareaDto runTareaDto = ((RunTareaDto) obj);
                final FaseDto faseDto = FaseEnum.fromId(validation.fase()).getDto();
                if (faseDto != null) {
                    final List<ValidacionDto> validaciones = this.runTareaPrevalidarAntesService.run(runTareaDto,
                            faseDto);

                    validaciones.stream()
                        .filter(e -> Boolean.FALSE.equals(e.getResult()))
                        .forEach(e -> {
                            final TareaFaseAccionDto tareaFaseAccion = this.tareaFaseAccionService
                                .findById(e.getIdTareaFaseAccion());
                            this.tareaFaseAccionService.updateFechaFinAndEstado(tareaFaseAccion,
                                    EstadoTareaFaseAccionEnum.KO.getDto());
                            final AccionDto accion = this.accionService
                                .findAccionDtoById(tareaFaseAccion.getIdAccion());
                            if (Boolean.TRUE.equals(accion.getEsReaccionReintento())) {
                                if (Boolean.TRUE.equals(accion.getEsReaccionEsperar())) {
                                    this.senderTarea.sendWithDelay(runTareaDto.getTarea(),
                                            accion.getReintentoDelay());
                                } else {
                                    this.senderTarea.send(runTareaDto.getTarea());
                                }

                            }
                            this.tareaFaseAccionService.updateFechaFinAndEstadoAndActivo(tareaFaseAccion,
                                    EstadoTareaFaseAccionEnum.NO_EJECUTADA.getDto());
                            throw new ValidationException("Error validando");
                        });
                }
            }
        }
        return pjp;
    }


    @After(value = "validationPointcut()")
    public Object validationAfter(final JoinPoint pjp) {
        final Validation validation = Optional.of(pjp.getSignature())
            .map(signature -> (MethodSignature) signature)
            .map(MethodSignature::getMethod)
            .map(method -> method.getAnnotation(Validation.class))
            .orElseThrow(() -> new IcmclcwbException("No se ha configurado la anotación Validation"));

        final List<Object> args = Arrays.asList(pjp.getArgs());
        for (final Object obj : args) {
            final Class<? extends Object> objClass = obj.getClass();
            if (RunTareaDto.class.isAssignableFrom(objClass)) {
                final RunTareaDto runTareaDto = ((RunTareaDto) obj);
                final FaseDto faseDto = FaseEnum.fromId(validation.fase()).getDto();
                if (faseDto != null) {
                    final List<ValidacionDto> validaciones = this.runTareaPrevalidarDespuesService.run(runTareaDto,
                            faseDto);

                    validaciones.stream()
                        .filter(e -> Boolean.FALSE.equals(e.getResult()))
                        .forEach(e -> {
                            final TareaFaseAccionDto tareaFaseAccion = this.tareaFaseAccionService
                                .findById(e.getIdTareaFaseAccion());
                            this.tareaFaseAccionService.updateFechaFinAndEstado(tareaFaseAccion,
                                    EstadoTareaFaseAccionEnum.KO.getDto());
                            final AccionDto accion = this.accionService
                                .findAccionDtoById(tareaFaseAccion.getIdAccion());
                            if (Boolean.TRUE.equals(accion.getEsReaccionReintento())) {
                                if (Boolean.TRUE.equals(accion.getEsReaccionEsperar())) {
                                    this.senderTarea.sendWithDelay(runTareaDto.getTarea(),
                                            accion.getReintentoDelay());
                                }
                                this.senderTarea.send(runTareaDto.getTarea());
                            }
                            this.tareaFaseAccionService.updateFechaFinAndEstadoAndActivo(tareaFaseAccion,
                                    EstadoTareaFaseAccionEnum.NO_EJECUTADA.getDto());
                            throw new ValidationException("Error validando");
                        });
                }
            }
        }
        return pjp;
    }

}
