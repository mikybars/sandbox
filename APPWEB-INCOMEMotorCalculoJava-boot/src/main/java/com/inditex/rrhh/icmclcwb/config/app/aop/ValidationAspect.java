/**
 *
 */
package com.inditex.rrhh.icmclcwb.config.app.aop;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.service.RunTareaAjustarService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.service.RunTareaPrevalidarAntesService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.service.RunTareaPrevalidarDespuesService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.service.RunTareaRegularizarChallengeService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.FaseEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.FaseDto;
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

@Aspect
@Component
public class ValidationAspect {

    @Autowired
    private RunTareaPrevalidarAntesService runTareaPrevalidarAntesService;

    @Autowired
    private RunTareaPrevalidarDespuesService runTareaPrevalidarDespuesService;

    @Pointcut("@annotation(com.inditex.rrhh.icmclcwb.api.app.aop.annotation.Validation)")
    public void validationPointcut() {
        throw new UnsupportedOperationException(ErrorConstants.NOT_IMPLEMENTED);
    }

    @Before(value = "validationPointcut()")
    public Object validationBefore(final JoinPoint pjp) throws Throwable {

        final List<Object> args = Arrays.asList(pjp.getArgs());
        for (final Object obj : args) {
            final Class<? extends Object> objClass = obj.getClass();
            if (RunTareaDto.class.isAssignableFrom(objClass)) {
                final RunTareaDto runTareaDto = ((RunTareaDto) obj);
                final FaseDto faseDto = this.getFaseDto(pjp);
                this.runTareaPrevalidarAntesService.run(runTareaDto, faseDto);
            }
        }
        return pjp;
    }


    @After(value = "validationPointcut()")
    public Object validationAfter(final JoinPoint pjp) throws Throwable {

        final List<Object> args = Arrays.asList(pjp.getArgs());
        for (final Object obj : args) {
            final Class<? extends Object> objClass = obj.getClass();
            if (RunTareaDto.class.isAssignableFrom(objClass)) {
                final RunTareaDto runTareaDto = ((RunTareaDto) obj);
                final FaseDto faseDto = this.getFaseDto(pjp);
                this.runTareaPrevalidarDespuesService.run(runTareaDto, faseDto);
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
