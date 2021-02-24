/**
 *
 */
package com.inditex.rrhh.icmclcwb.config.app.aop;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;

import com.inditex.rrhh.icmclcwb.api.app.aop.annotation.Validation;
import com.inditex.rrhh.icmclcwb.api.app.dto.ValidacionDto;
import com.inditex.rrhh.icmclcwb.api.app.exception.IcmclcwbException;
import com.inditex.rrhh.icmclcwb.api.app.exception.ValidationException;
import com.inditex.rrhh.icmclcwb.api.app.limpieza.service.LimpiezaService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.dto.RunTareaDto;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.service.RunTareaPrevalidarAntesService;
import com.inditex.rrhh.icmclcwb.api.app.run.tarea.service.RunTareaPrevalidarDespuesService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.EstadoTareaFaseAccionEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.EstadoTareaFaseEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.FaseEnum;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.AccionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.FaseDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaFaseAccionDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.dto.TareaFaseDto;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.AccionService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaFaseAccionService;
import com.inditex.rrhh.icmclcwb.api.app.tarea.service.TareaFaseService;
import com.inditex.rrhh.icmclcwb.api.app.util.ErrorConstants;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.service.Meta4IcmWsCalcIncomeService;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.sincronizacion.dto.SincronizacionFilterDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.sincronizacion.dto.SincronizacionFilterParametersDto;
import com.inditex.rrhh.icmclcwb.api.meta4.icmwscalcincome.sincronizacion.dto.SincronizacionRequestDto;
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
    private LimpiezaService limpiezaService;

    @Autowired
    private Meta4IcmWsCalcIncomeService meta4IcmWsCalcIncomeService;

    @Autowired
    private TareaFaseAccionService tareaFaseAccionService;

    @Autowired
    private TareaFaseService tareaFaseService;

    @Autowired
    private AccionService accionService;

    @Autowired
    private SenderTarea senderTarea;

    @Autowired
    private MailSender mailSender;

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
                final TareaFaseDto tareaFase = this.tareaFaseService.findTareaFaseDtoByIdTareaAndIdFase(
                        runTareaDto.getTarea().getId(), faseDto.getId());
                final List<ValidacionDto> validaciones = this.runTareaPrevalidarAntesService.run(runTareaDto,
                        faseDto);

                final List<ValidacionDto> fallidas = validaciones.stream()
                    .filter(e -> Boolean.FALSE.equals(e.getResult()))
                    .sorted(Comparator.comparingInt(ValidacionDto::getReaccionPeso)
                        .reversed())
                    .map(e -> {
                        final TareaFaseAccionDto tareaFaseAccion = this.tareaFaseAccionService
                            .findById(e.getIdTareaFaseAccion());
                        this.tareaFaseAccionService.updateFechaFinAndEstado(tareaFaseAccion,
                                EstadoTareaFaseAccionEnum.KO.getDto());
                        this.tareaFaseService.updateFechaInicioAndFechaFinAndEstado(tareaFase,
                                EstadoTareaFaseEnum.KO.getDto());

                        return e;
                    })
                    .collect(Collectors.toList());

                if (!fallidas.isEmpty()) {
                    this.tareaFaseAccionService
                        .updateFechaInicioFechaFinAndEstadoAndActivoByIdTareaAndEstadoActual(
                                tareaFase,
                                EstadoTareaFaseAccionEnum.PENDIENTE.getDto(),
                                EstadoTareaFaseAccionEnum.NO_EJECUTADA.getDto());
                    this.tareaFaseService
                        .updateFechaInicioAndFechaFinAndEstadoByIdTareaAndEstadoActual(
                                runTareaDto.getTarea(),
                                EstadoTareaFaseEnum.PENDIENTE.getDto(),
                                EstadoTareaFaseEnum.NO_EJECUTADA.getDto());
                    this.tareaFaseService.updateActivo(runTareaDto);
                    this.limpiezaService.limpiezaAmbito(runTareaDto.getTarea());

                    this.sendMail(tareaFase, fallidas);

                    fallidas.stream().forEach(e -> {
                        if ((e.getIdPersonaLocal() != null)
                                && !e.getIdPersonaLocal().isEmpty()) {
                            final List<SincronizacionFilterParametersDto> filterParameters = e
                                .getIdPersonaLocal()
                                .stream()
                                .map(
                                        f -> SincronizacionFilterParametersDto.builder()
                                            .idOrigen(e.getCclIdOrigen())
                                            .idEmpleado(f)
                                            .build())
                                .collect(Collectors.toList());
                            final SincronizacionFilterDto filter = SincronizacionFilterDto.builder()
                                .items(filterParameters)
                                .build();
                            final SincronizacionRequestDto request = new SincronizacionRequestDto();
                            request.setData(filter);
                            this.meta4IcmWsCalcIncomeService
                                .sincronizacion(request);
                        }
                    });

                    final TareaFaseAccionDto tareaFaseAccion = this.tareaFaseAccionService
                        .findById(fallidas.get(0).getIdTareaFaseAccion());
                    final AccionDto accion = this.accionService
                        .findAccionDtoById(tareaFaseAccion.getIdAccion());

                    if (Boolean.TRUE.equals(accion.getEsReaccionReintento()) && (this.tareaFaseAccionService
                        .countReintentosByIdTareaAndIdAccionAndIdEstado(
                                tareaFaseAccion, tareaFase) < accion.getReintentoMax())) {
                        if (Boolean.TRUE.equals(accion.getEsReaccionEsperar())) {
                            this.senderTarea.sendWithDelay(runTareaDto.getTarea(),
                                    accion.getReintentoDelay());
                        } else {
                            this.senderTarea.send(runTareaDto.getTarea());
                        }

                    }
                    throw new ValidationException("Error validando");
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
                final TareaFaseDto tareaFase = this.tareaFaseService.findTareaFaseDtoByIdTareaAndIdFase(
                        runTareaDto.getTarea().getId(), faseDto.getId());
                final List<ValidacionDto> validaciones = this.runTareaPrevalidarDespuesService.run(runTareaDto,
                        faseDto);

                final List<ValidacionDto> fallidas = validaciones.stream()
                    .filter(e -> Boolean.FALSE.equals(e.getResult()))
                    .sorted(Comparator.comparingInt(ValidacionDto::getReaccionPeso)
                        .reversed())
                    .map(e -> {
                        final TareaFaseAccionDto tareaFaseAccion = this.tareaFaseAccionService
                            .findById(e.getIdTareaFaseAccion());
                        this.tareaFaseAccionService.updateFechaFinAndEstado(tareaFaseAccion,
                                EstadoTareaFaseAccionEnum.KO.getDto());
                        this.tareaFaseService.updateFechaFinAndEstado(tareaFase,
                                EstadoTareaFaseEnum.KO.getDto());
                        return e;
                    })
                    .collect(Collectors.toList());

                if (!fallidas.isEmpty()) {
                    this.tareaFaseAccionService
                        .updateFechaInicioFechaFinAndEstadoAndActivoByIdTareaAndEstadoActual(
                                tareaFase,
                                EstadoTareaFaseAccionEnum.PENDIENTE.getDto(),
                                EstadoTareaFaseAccionEnum.NO_EJECUTADA.getDto());
                    this.tareaFaseService
                        .updateFechaInicioAndFechaFinAndEstadoByIdTareaAndEstadoActual(
                                runTareaDto.getTarea(),
                                EstadoTareaFaseEnum.PENDIENTE.getDto(),
                                EstadoTareaFaseEnum.NO_EJECUTADA.getDto());
                    this.tareaFaseService.updateActivo(runTareaDto);
                    this.limpiezaService.limpiezaAmbito(runTareaDto.getTarea());

                    this.sendMail(tareaFase, fallidas);

                    fallidas.stream().forEach(e -> {
                        if ((e.getIdPersonaLocal() != null)
                                && !e.getIdPersonaLocal().isEmpty()) {
                            final List<SincronizacionFilterParametersDto> filterParameters = e
                                .getIdPersonaLocal()
                                .stream()
                                .map(
                                        f -> SincronizacionFilterParametersDto.builder()
                                            .idOrigen(e.getCclIdOrigen())
                                            .idEmpleado(f)
                                            .build())
                                .collect(Collectors.toList());
                            final SincronizacionFilterDto filter = SincronizacionFilterDto.builder()
                                .items(filterParameters)
                                .build();
                            final SincronizacionRequestDto request = new SincronizacionRequestDto();
                            request.setData(filter);
                            this.meta4IcmWsCalcIncomeService
                                .sincronizacion(request);
                        }
                    });

                    final TareaFaseAccionDto tareaFaseAccion = this.tareaFaseAccionService
                        .findById(fallidas.get(0).getIdTareaFaseAccion());
                    final AccionDto accion = this.accionService
                        .findAccionDtoById(tareaFaseAccion.getIdAccion());

                    if (Boolean.TRUE.equals(accion.getEsReaccionReintento()) && (this.tareaFaseAccionService
                        .countReintentosByIdTareaAndIdAccionAndIdEstado(
                                tareaFaseAccion, tareaFase) < accion.getReintentoMax())) {
                        if (Boolean.TRUE.equals(accion.getEsReaccionEsperar())) {
                            this.senderTarea.sendWithDelay(runTareaDto.getTarea(),
                                    accion.getReintentoDelay());
                        } else {
                            this.senderTarea.send(runTareaDto.getTarea());
                        }
                    }

                    throw new ValidationException("Error validando");
                }
            }
        }
        return pjp;
    }

    /**
     * @param tareaFase
     * @param fallidas
     */
    private void sendMail(final TareaFaseDto tareaFase, final List<ValidacionDto> fallidas) {
        final StringBuilder result = new StringBuilder();
        result.append("Listado de errores: \n");
        fallidas.stream().forEach(e -> {
            final TareaFaseAccionDto tareaFaseAccion = this.tareaFaseAccionService
                .findById(e.getIdTareaFaseAccion());
            final AccionDto accion = this.accionService
                .findAccionDtoById(tareaFaseAccion.getIdAccion());
            result.append(accion.getNombre());
            if ((e.getIdPersonaLocal() != null) && !e.getIdPersonaLocal().isEmpty()) {
                result.append(" - ");
                result.append(e.getIdPersonaLocal());
            }
            result.append("\n");
        });

        final SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("noreply@inditex.com");
        message.setTo("mdelrio@vectoritcgroup.com");
        message.setSubject(new StringBuilder("[INCOME][CALC] - Errores validación tarea: ")
            .append(tareaFase.getIdTarea())
            .toString());
        message.setText(result.toString());

        this.mailSender.send(message);
    }

}
