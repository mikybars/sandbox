/**
 *
 */
package com.inditex.rrhh.icmclcwb.config.app.aop;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.inditex.rrhh.icmclcwb.api.app.aop.annotation.Validation;
import com.inditex.rrhh.icmclcwb.api.app.exception.IcmclcwbException;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.service.RunTareaAjustarService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.service.RunTareaPrevalidarService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.service.RunTareaRegularizarChallengeService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.FaseEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.PuntoEjecucionEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.FaseDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaFaseAccionService;
import com.inditex.rrhh.icmclcwb.api.app.util.ErrorConstants;
import com.inditex.rrhh.icmclcwb.model.app.run.tarea.service.RunTareaCalcularServiceImpl;
import com.inditex.rrhh.icmclcwb.model.app.run.tarea.service.RunTareaProcesarServiceImpl;
import com.inditex.rrhh.icmclcwb.model.app.run.tarea.service.RunTareaRecolectarServiceImpl;
import com.inditex.rrhh.icmclcwb.model.app.run.tarea.service.RunTareaRecolectarValidarServiceImpl;
import com.inditex.rrhh.icmclcwb.model.app.run.tarea.service.RunTareaRegularizarServiceImpl;
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
    private TareaFaseAccionService tareaFaseAccionService;

    @Autowired
    private RunTareaPrevalidarService runTareaPrevalidarService;

    @Pointcut("@annotation(com.inditex.rrhh.icmclcwb.api.app.aop.annotation.Validation)")
    public void validationPointcut() {
        throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
    }

    @Before(value = "validationPointcut()")
    public Object validationBefore(final JoinPoint pjp) throws Throwable {
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
                final TareaDto tareaDto = runTareaDto.getTarea();
                final FaseDto faseDto = this.getFaseDto(pjp);
                this.runTareaPrevalidarService.run(runTareaDto,
                        this.tareaFaseAccionService.findTareaFaseAccionDtoByIdTareaAndIdFaseAndIdPuntoEjecucion(
                                tareaDto.getId(), faseDto.getId(), PuntoEjecucionEnum.ANTES.getId()));
            }
        }
        return pjp;
    }


    @After(value = "validationPointcut()")
    public Object validationAfter(final JoinPoint pjp) throws Throwable {
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
                final TareaDto tareaDto = runTareaDto.getTarea();
                final FaseDto faseDto = this.getFaseDto(pjp);
                this.runTareaPrevalidarService.run(runTareaDto,
                        this.tareaFaseAccionService.findTareaFaseAccionDtoByIdTareaAndIdFaseAndIdPuntoEjecucion(
                                tareaDto.getId(), faseDto.getId(), PuntoEjecucionEnum.DESPUES.getId()));
            }
        }
        return pjp;
    }

    /**
     * @param pjp
     */
    private FaseDto getFaseDto(final JoinPoint pjp) {
        if (RunTareaRegularizarServiceImpl.class.isAssignableFrom(pjp.getTarget().getClass())) {
            return FaseEnum.REGULARIZAR.getDto();
        } else if (RunTareaCalcularServiceImpl.class.isAssignableFrom(pjp.getTarget().getClass())) {
            return FaseEnum.CALCULAR.getDto();
        } else if (RunTareaProcesarServiceImpl.class.isAssignableFrom(pjp.getTarget().getClass())) {
            return FaseEnum.PROCESAR.getDto();
        } else if (RunTareaRecolectarServiceImpl.class.isAssignableFrom(pjp.getTarget().getClass())) {
            return FaseEnum.RECOLECTAR.getDto();
        } else if (RunTareaRecolectarValidarServiceImpl.class.isAssignableFrom(pjp.getTarget().getClass())) {
            return FaseEnum.VALIDAR_RECOLECCION.getDto();
        } else if (RunTareaRegularizarChallengeService.class.isAssignableFrom(pjp.getTarget().getClass())) {
            return FaseEnum.REGULARIZAR_CHALLENGE.getDto();
        } else if (RunTareaAjustarService.class.isAssignableFrom(pjp.getTarget().getClass())) {
            return FaseEnum.AJUSTAR.getDto();
        }
        return null;
    }

}
